package cn.edu.ncu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-07-02-0:07.
 * @Description: ssm
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
public class GuideController {
    @RequestMapping("/login")
    public String LoginHtml() {
        return "login";
    }

    /*@RequestMapping("/index")
    public String IndexHtml() {
        return "index";
    }*/

    @RequestMapping("/forget")
    public String ForgetHtml() {
        return "forget";
    }

    /*@RequestMapping("/address")
    public String AddressHtml() {
        return "displayAddress";
    }*/

   /* @RequestMapping("/bzproList")
    public String BzproListHtml() {
        return "bzproList";
    }*/

    @RequestMapping("/cart")
    public String CartHtml() {
        return "cart";
    }

/*    @RequestMapping("/decoration")
    public String DecorationHtml() {
        return "decoration";
    }*/

    /*@RequestMapping("/flowerDer")
    public String FlowerDerHtml() {
        return "flowerDer";
    }*/

    /*@RequestMapping("/idea")
    public String IdeaHtml() {
        return "idea";
    }*/

    @RequestMapping("/mygrxx")
    public String MygrxxHtml() {
        return "mygrxx";
    }

    /*@RequestMapping("/mygxin")
    public String MygxinHtml() {
        return "mygxin";
    }*/

    /*@RequestMapping("/myorderq")
    public String MyorderqHtml() {
        return "myorderq";
    }*/

    /*@RequestMapping("/myprod")
    public String MyprodHtml() {
        return "myprod";
    }*/

    @RequestMapping("/ok")
    public String OkHtml() {
        return "ok";
    }

    @RequestMapping("/order")
    public String OrderHtml() {
        return "order";
    }

    @RequestMapping("/orderxq")
    public String OrderxqHtml() {
        return "orderxq";
    }

    /*@RequestMapping("/paint")
    public String PaintHtml() {
        return "paint";
    }*/

    /*@RequestMapping("/perfume")
    public String PerfumeHtml() {
        return "perfume";
    }*/

    /*@RequestMapping("/proDetail")
    public String ProDetailHtml() {
        return "proDetail";
    }*/

/*    @RequestMapping("/proList")
    public String ProListHtml() {
        return "proList";
    }*/

    @RequestMapping("/reg")
    public String RegHtml() {
        return "reg";
    }

    @RequestMapping("/remima")
    public String RemimaHtml() {
        return "remima";
    }

    @RequestMapping("/search")
    public String SearchHtml() {
        return "search";
    }

/*    @RequestMapping("/vase_proList")
    public String VaseProListHtml() {
        return "vase_proList";
    }*/

    @RequestMapping("/wuliu")
    public String WuliuHtml() {
        return "wuliu";
    }

    /*@RequestMapping("/zbproList")
    public String ZbproListHtml() {
        return "zbproList";
    }*/

}
