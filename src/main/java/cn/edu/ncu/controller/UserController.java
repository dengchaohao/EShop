package cn.edu.ncu.controller;

import cn.edu.ncu.pojo.User;
import cn.edu.ncu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /*
    @GetMapping用于将HTTP get请求映射到特定处理程序的方法注解
    是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
    @PostMapping用于将HTTP post请求映射到特定处理程序的方法注解
    是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。
    */
    @GetMapping("/login")
    public String login(){
        System.out.println("go to login page");
        return "login";
    }

    @PostMapping("/login")
    public String loginLogic(User user){
        System.out.println("login logic");
        // 获取subject 调用login
        Subject subject = SecurityUtils.getSubject();
        // 创建用于登录的令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 开启记住我
        token.setRememberMe(true);
        // 登录失败抛出异常，则交由异常解析器处理
        subject.login(token);
        return "index"; // 登录成功，跳转首页
    }

    // 登录之后，有权限才能访问
    @GetMapping("/all")
    public String queryAllUsers(){
        System.out.println("query all users");
        return "index";
    }

    @RequestMapping("/perms/error")
    public String permsError(){
        System.out.println("权限不足");
        return "perm_error";
    }

    @GetMapping("/regist")
    public String registPage(){
        System.out.println("goto regist page");
        return "regist";
    }

    /**
     * @Description: 注册逻辑
     * @Name: regist
     * @Param: [user]
     * @Return: java.lang.String
     */
    @PostMapping("/regist")
    public String regist(User user){
        userService.insertUser(user);
        return "redirect:/user/login";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "index";
    }
}
