package cn.edu.ncu.controller;

import org.apache.shiro.authz.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-08-15
 * @Description: mybatis-study-01
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @RequiresAuthentication // 需要登录
    @RequestMapping("/query")
    public String queryOrder(){
        System.out.println("query Order");
        return "index";
    }

    @RequiresAuthentication
    @RequiresRoles(value = {"banzhang","student"},logical = Logical.OR) //必须要有角色
    @RequestMapping("/save")
    public String saveOrder(){
        System.out.println("save Order");
        return "index";
    }

    @RequiresAuthentication
    //@RequiresPermissions("user:delete")
    @RequiresPermissions(value = {"user:delete","user:query"},logical = Logical.AND)
    @RequestMapping("/delete")
    public String deleteOrder(){
        System.out.println("delete Order");
        return "index";
    }

    @RequiresUser // 需要登录或记住我
    @RequestMapping("/update")
    public String updateOrder(){
        System.out.println("update Order");
        return "index";
    }
}
