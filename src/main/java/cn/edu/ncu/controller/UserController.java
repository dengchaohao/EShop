package cn.edu.ncu.controller;

import cn.edu.ncu.constant.Constant;
import cn.edu.ncu.pojo.*;
import cn.edu.ncu.service.*;
import cn.edu.ncu.utils.CalculatorUtil;
import cn.edu.ncu.utils.SendmailUtil;
import cn.edu.ncu.utils.VerifyCodeUtil;
import javafx.util.Pair;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private CartGoodsService cartGoodsService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private CartImgService cartImgService;
    @Resource
    private AddressService addressService;
    @Resource
    private AreaService areaService;
    @Resource
    private CityService cityService;
    @Resource
    private ProvinceService provinceService;
    /*
    @GetMapping用于将HTTP get请求映射到特定处理程序的方法注解
    是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
    @PostMapping用于将HTTP post请求映射到特定处理程序的方法注解
    是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。
    */

    @PostMapping("/loginLogic")
    public ModelAndView loginLogic(User user, HttpSession session){
        String userName = user.getUsername();
        String passWord = user.getPassword();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/index");
        ModelAndView modelAndView1 = new ModelAndView();
        modelAndView1.setViewName("login");
        if (userName == null || userName.equals("")) {
            modelAndView1.addObject("msg", "*账号不能为空");
            return modelAndView1;
        }
        if (passWord == null || passWord.equals("")) {
            modelAndView1.addObject("msg", "*密码不能为空");
            return modelAndView1;
        }
        // 获取subject 调用login
        Subject subject = SecurityUtils.getSubject();
        // 创建用于登录的令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 开启记住我
        token.setRememberMe(true);
        // 登录失败抛出异常，则交由异常解析器处理
        subject.login(token);
        user = userService.queryUserByUsername(user.getUsername());
        session.setAttribute("user", user);
        session.setAttribute("cart", setCart(user));
        getAddress(session);
        return modelAndView; // 登录成功，跳转首页
    }

    private Cart setCart(User sessionUser){
        List<CartGoods> cartGoods = cartGoodsService.findAllCartGood(sessionUser);
        Cart cart = new Cart();
        for (CartGoods cartGood : cartGoods){
            List<CartImg> cartImgs = cartImgService.findCartImgByIdAndSpec(
                    Long.parseLong(cartGood.getGoodsId().toString()),cartGood.getSpec());
            String img = null;
            if (cartImgs.size() == 1) img = cartImgs.get(0).getCartImgUrl();
            cart.addGoodsInCart(goodsService.findGoodsById(Long.parseLong(cartGood.getGoodsId().toString())),
                    cartGood.getSpec(),
                    Integer.parseInt(cartGood.getNum().toString()),img);
        }
        return cart;
    }

    @PostMapping("/userReg")
    public ModelAndView userReg(String username,String phone, String email,String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/login");
        ModelAndView modelAndView1 = new ModelAndView();
        modelAndView1.setViewName("reg");
        if (username == null || username.equals("")) {
            modelAndView1.addObject("msg", "*账号不能为空");
            return modelAndView1;
        }
        if (password == null || password.equals("")) {
            modelAndView1.addObject("msg", "*密码不能为空");
            return modelAndView1;
        }
        if (phone == null || phone.equals("")) {
            modelAndView1.addObject("msg", "*手机号不能为空");
            return modelAndView1;
        }
        if (email == null || email.equals("")) {
            modelAndView1.addObject("msg", "*邮箱不能为空");
            return modelAndView1;
        }
        List<User> users = userService.findUserByMail(email);
        if (users.size()>0){
            modelAndView1.addObject("msg", "邮箱已经被使用! ");
            return modelAndView1;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        user.setIsEmailCheck("1");
        user.setIsMobileCheck("1");
        user.setCreateTime(new Date());
        if (!userService.hasUserByUsername(user)) {
            userService.insertUser(user);
            return modelAndView;
        }
        modelAndView1.addObject("msg", "用户已存在,请重新注册! ");
        return modelAndView1;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        User sessionUser = (User)session.getAttribute("user");
        Cart cart = (Cart)session.getAttribute("cart");
        cartGoodsService.ClearCartGood();
        for (Map.Entry<Pair<Goods, String>, Pair<Integer, String>> entry:cart.getGoods().entrySet()){
            CartGoods cartGood  = new CartGoods();
            cartGood.setGoodsId(entry.getKey().getKey().getGoodsId());
            cartGood.setNum(BigDecimal.valueOf(entry.getValue().getKey()));
            cartGood.setSpec(entry.getKey().getValue());
            cartGood.setUsername(sessionUser.getUsername());
            //cartGoodsService.addCartGood(cartGood); // addCartGood sql不安全
            cartGoodsService.insertCartGoods(cartGood);
        }
        session.removeAttribute("user");
        session.removeAttribute("cart");
        session.removeAttribute("allAddresses");
        session.removeAttribute("defaultAddresses");
        session.removeAttribute("provinces");
        session.removeAttribute("cities");
        session.removeAttribute("areas");
        SecurityUtils.getSubject().logout();
        return "redirect:/index";
    }

    @RequestMapping("/updatePwdByEmail")
    @ResponseBody
    public String updatePwdByEmail(String email, String password){
        if(email == null||email .equals("")){
            return "emailEmpty";
        }
        if(password==null||password.equals("")){
            return "passwordEmpty";
        }

        User user = null;
        List<User> users = userService.findUserByMail(email);
        if (users.size() == 1) user = users.get(0);
        assert user != null;
        user.setPassword(password);

        // 加密
        String salt = UUID.randomUUID().toString();
        String s = new Sha256Hash(user.getPassword(), salt, Constant.INTERCOUNT).toBase64();
        // 设置密文
        user.setPassword(s);
        // 设置盐
        user.setSalt(salt);

        userService.userModify(user);
        return "success";
    }

    @RequestMapping("/verifyMailCode")
    @ResponseBody
    public String verifyMailCode(String toEmailAddress, String verifyCode){
        if ("".equals(toEmailAddress)||toEmailAddress==null){
            return "emailEmpty";
        }
        if ("".equals(verifyCode)||verifyCode==null){
            return "verifyCodeEmpty";
        }
        User user = null;
        List<User> users = userService.findUserByMail(toEmailAddress);
        if (users.size() == 1) user = users.get(0);
        if (user != null && verifyCode.equals(user.getVerifyCode())){
            return "success";
        }
        return "verifyCodeError";
    }

    /**
     * 发送自由编辑的邮件
     *
     * @param toEmailAddress 收件人邮箱
     * @param emailTitle 邮件主题
     * @param emailContent 邮件内容
     * @return
     */
    @RequestMapping(value={"/sendEmailOwn"},method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String sendEmailOwn(@RequestParam("toEmailAddress") String toEmailAddress,
                               @RequestParam("emailTitle") String emailTitle,
                               @RequestParam("emailContent") String emailContent){
        try{
            //发送邮件
            SendmailUtil.sendEmail(toEmailAddress, emailTitle, emailContent);
            return CalculatorUtil.getJSONString(0);
        } catch (Exception e) {
            return CalculatorUtil.getJSONString(1,"邮件发送失败！");
        }
    }

    /**
     * 发送系统验证
     *
     * @param toEmailAddress 收件人邮箱
     * @return
     */
    @RequestMapping(value={"/sendEmailSystem"},method={RequestMethod.GET,RequestMethod.POST},produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String sendEmailSystem(@RequestParam("toEmailAddress") String toEmailAddress){

        if ("".equals(toEmailAddress)||toEmailAddress==null){
            return CalculatorUtil.getJSONString(2,"*邮箱不能为空！");
        }
        User user = null;
        List<User> users = userService.findUserByMail(toEmailAddress);
        if (users.size() == 1) user = users.get(0);
        else if(users.size() == 0) return CalculatorUtil.getJSONString(3,"*邮箱绑定的用户不存在！");
        try{
            //生成验证码
            String verifyCode = VerifyCodeUtil.generateVerifyCode(6);
            //邮件主题
            String emailTitle = "【最家家居商城】邮箱验证";
            //邮件内容
            String emailContent = "您正在【最家家居商城】进行邮箱验证，您的验证码为：" + verifyCode + "，请于10分钟内完成验证！";
            //发送邮件
            SendmailUtil.sendEmail(toEmailAddress, emailTitle, emailContent);
            assert user != null;
            user.setVerifyCode(verifyCode);
            userService.userModify(user);
            return CalculatorUtil.getJSONString(0,verifyCode);
        } catch (Exception e) {
            return CalculatorUtil.getJSONString(1,"邮件发送失败！");
        }
    }

    private void getAddress(HttpSession session){
        List<Province> provinces = provinceService.findAllProvinces();
        List<City> cities = cityService.findAllCities();
        List<Area> areas = areaService.findAllAreas();
        User sessionUser = (User) session.getAttribute("user");
        List<Address> allAddresses = addressService.findAddressByUserId(sessionUser.getUsername());
        List<Address> defaultAddresses = addressService.findDefaultAddress(sessionUser.getUsername());
        Address defaultAddress = new Address();
        if (defaultAddresses.size()==0){
            defaultAddress = null;
        }else {
            defaultAddress = defaultAddresses.get(0);
        }
        if (allAddresses.size()==0){
            allAddresses = null;
        }
        session.setAttribute("allAddresses",allAddresses);
        session.setAttribute("defaultAddress",defaultAddress);
        session.setAttribute("provinces",provinces);
        session.setAttribute("cities", cities);
        session.setAttribute("areas", areas);
    }

    @RequestMapping("/modifyUser")
    public ModelAndView modifyUser(String username, String gender, String name, String birthday,HttpSession session){
        User user = (User)session.getAttribute("user");
        if(!(gender == null||gender .equals(""))){
            user.setSex(gender);
        }
        if(!(name==null||name.equals(""))){
            user.setName(name);
        }
        if(!(birthday==null||birthday.equals(""))){
            try {
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                user.setBirthday(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        userService.userModify(user);
        session.setAttribute("user",user);
        return new ModelAndView("redirect:/mygrxx");
    }

    @RequestMapping("/updatePwd")
    public ModelAndView updatePwd(String username, String oldPassword, String newPassword,HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/remima");
        ModelAndView modelAndView1 = new ModelAndView();
        modelAndView1.setViewName("redirect:/login");
        if(oldPassword == null||oldPassword .equals("")){
            modelAndView.addObject("msg", "*旧密码不能为空");
            return modelAndView;
        }
        if(newPassword==null||newPassword.equals("")){
            modelAndView.addObject("msg", "*新密码不能为空");
            return modelAndView;
        }
        User user = userService.queryUserByUsername(username);

        String userSalt = user.getSalt();
        String s1 = new Sha256Hash(oldPassword, userSalt, Constant.INTERCOUNT).toBase64();

        if(!s1.equals(user.getPassword())){
            modelAndView.addObject("msg", "*旧密码错误");
            return modelAndView;
        }

        user.setPassword(newPassword);
        // 加密
        String salt = UUID.randomUUID().toString();
        String s = new Sha256Hash(user.getPassword(), salt, Constant.INTERCOUNT).toBase64();
        // 设置密文
        user.setPassword(s);
        // 设置盐
        user.setSalt(salt);
        userService.userModify(user);

        logout(session);
        return modelAndView1;
    }

    @RequestMapping("/upload")
    public ModelAndView uploadHeadPic(HttpServletRequest request, HttpSession session){
        ModelAndView mv =  new ModelAndView();
        mv.setViewName("mygrxx");
        String destFilePath = "E:/CodeOfProgramming/Maven_Project/EShop/src/main/webapp/img/uploads";
        String path = request.getSession().getServletContext().getRealPath("/");
        // 转换成为复合文件类
        MultipartRequest mr = (MultipartRequest) request;
        // 文件类
        MultipartFile mrFile = mr.getFile("file");
        if (mrFile != null && !mrFile.isEmpty()){
            try {
                mrFile.transferTo(new File(destFilePath,mrFile.getOriginalFilename().toLowerCase()));
                String picName = mrFile.getOriginalFilename();
                picName = picName.toLowerCase();
                String headPicUrl = "img/uploads/" + picName;
                User sessionUser = (User)session.getAttribute("user");
                userService.updateHeadPicUrlById(sessionUser,headPicUrl);
                User user = userService.queryUserByUsername(sessionUser.getUsername());
                session.setAttribute("user",user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mv;
    }
}
