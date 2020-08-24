package cn.edu.ncu.controller;

import cn.edu.ncu.pojo.*;
import cn.edu.ncu.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-22.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private SmallImgService smallImgService;
    @Resource
    private MsgImgsService msgImgsService;
    @Resource
    private SpecificationOptionService specificationOptionService;
    @Resource
    private CartImgService cartImgService;
    @Resource
    private CartService cartService;
    @Resource
    private ContentCategoryService tbContentCategoryService;
    @Resource
    private OrderDetailService orderDetailService;
    @Resource
    private UserService userService;
    @Resource
    private OrderService orderService;

    @ResponseBody
    @RequestMapping("/buyGoods")
    public String buyGoods(String id, Integer number, String spec, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null) return "false";
        Goods good = goodsService.findGoodsById(Long.parseLong(id));
        Cart cartOrder = null;
        if(session.getAttribute("cartOrder")!=null){
            cartOrder = (Cart) session.getAttribute("cartOrder");
        }else{
            cartOrder = new Cart();
        }
        List<CartImg> cartImgs = cartImgService.findCartImgByIdAndSpec(Long.parseLong(id),spec);
        String img = null;
        if (cartImgs.size() == 1) img = cartImgs.get(0).getCartImgUrl();
        cartOrder = cartService.addGoodsInCart(good, spec, number,cartOrder,img);
        session.setAttribute("cartOrder",cartOrder);
        return "success";
    }

    @RequestMapping("/proDetail")
    public ModelAndView displayProDetail(String goodsId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("proDetail");

        Goods goods= goodsService.findGoodsById(Long.parseLong(goodsId));
        List<MsgImgs> msgImgs = msgImgsService.findMsgImgsByGoodsId(Long.parseLong(goodsId));
        List<SmallImg> smallImgs = smallImgService.findSmalllImgBiGoodsId(Long.parseLong(goodsId));
        List<SpecificationOption> specificationOptions = specificationOptionService.findSpecOptionBySpecId(Integer.parseInt(goods.getSpecId()));

        ContentCategory contentCategory = null;
        List<ContentCategory> contentCategories = tbContentCategoryService.findContentCategoryByName("为你推荐");
        if (contentCategories.size() == 1) contentCategory = contentCategories.get(0);
        List<Goods> recommendedForYou = goodsService.findGoodsByContentId(contentCategory.getContentId());

        ContentCategory contentCategory2 = null;
        List<ContentCategory> contentCategories2 = tbContentCategoryService.findContentCategoryByName("猜你喜欢");
        if (contentCategories.size() == 1) contentCategory2 = contentCategories2.get(0);
        List<Goods> guessYouLike = goodsService.findGoodsByContentId(contentCategory2.getContentId());

        modelAndView.addObject("goods",goods);
        modelAndView.addObject("msgImgs",msgImgs);
        modelAndView.addObject("smallImgs",smallImgs);
        modelAndView.addObject("specificationOptions",specificationOptions);
        modelAndView.addObject("recommendedForYou",recommendedForYou);
        modelAndView.addObject("guessYouLike",guessYouLike);

        List<OrderDetail> orderItems = orderDetailService.findOrderItemsByGoodsIdAndEvaluate(Long.valueOf(goodsId),"1");

        Map<OrderDetail,User> map = new HashMap<>();
        for (OrderDetail orderItem : orderItems){
            Order order = null;
            List<Order> orders =  orderService.findOrderByOrderId(orderItem.getOrderId());
            if (orders.size()==1) order = orders.get(0);
            User user = userService.queryUserByUsername(order.getUsername());
            if (user != null) user.setPassword("");
            map.put(orderItem,user);
        }

        modelAndView.addObject("map",map);
        return modelAndView;
    }
}
