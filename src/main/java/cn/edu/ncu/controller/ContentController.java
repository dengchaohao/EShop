package cn.edu.ncu.controller;


import cn.edu.ncu.pojo.Goods;
import cn.edu.ncu.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-57-10-22:57.
 * @Description: ssm
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
public class ContentController {
    @Resource
    private GoodsService goodsService;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        List<Goods> goods1 = goodsService.findGoodsByCategoryOneAndStyle("首页","摆件花艺");
        List<Goods> goods2 = goodsService.findGoodsByCategoryOneAndStyle("首页","挂壁北欧");
        //List<TbGoods> goods3 = tbGoodsService.findGoodsByCategoryOneAndStyle("创意家居","创意生活");

        // 获取分页后的list集合
        List<List<Goods>> list1 = new ArrayList<>();
        for (int i = 0; i < Math.ceil(goods1.size()/(3.0)); i ++ ){
            list1.add(goodsService.findGoodsByCategoryOneAndStyle("首页","摆件花艺",i+1,3));
        }
        modelAndView.addObject("list1",list1);

        List<List<Goods>> list2 = new ArrayList<>();
        for (int i = 0; i < Math.ceil(goods2.size()/(4.0)); i ++ ){
            list2.add(goodsService.findGoodsByCategoryOneAndStyle("首页","挂壁北欧",i+1,4));
        }
        modelAndView.addObject("list2",list2);

        /*List<List<TbGoods>> list3 = new ArrayList<>();
        for (int i = 0; i < Math.ceil(goods3.size()/(4.0)); i ++ ){
            list3.add(tbGoodsService.findGoodsByCategoryOneAndStyle("创意家居","创意生活",i+1,4));
        }
        modelAndView.addObject("list3",list3);*/
        return modelAndView;
    }


    @RequestMapping("/idea")
    public ModelAndView idea(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("idea");
        List<Goods> goods1 = goodsService.findGoodsByCategoryOneAndStyle("创意家居","普通创意");
        List<Goods> goods2 = goodsService.findGoodsByCategoryOneAndStyle("创意家居","时尚新颖");
        List<Goods> goods3 = goodsService.findGoodsByCategoryOneAndStyle("创意家居","创意生活");

        // 获取分页后的list集合
        List<List<Goods>> list1 = new ArrayList<>();
        for (int i = 0; i < Math.ceil(goods1.size()/(3.0)); i ++ ){
            list1.add(goodsService.findGoodsByCategoryOneAndStyle("创意家居","普通创意",i+1,3));
        }
        modelAndView.addObject("list1",list1);

        List<List<Goods>> list2 = new ArrayList<>();
        for (int i = 0; i < Math.ceil(goods2.size()/(4.0)); i ++ ){
            list2.add(goodsService.findGoodsByCategoryOneAndStyle("创意家居","时尚新颖",i+1,4));
        }
        modelAndView.addObject("list2",list2);

        List<List<Goods>> list3 = new ArrayList<>();
        for (int i = 0; i < Math.ceil(goods3.size()/(4.0)); i ++ ){
            list3.add(goodsService.findGoodsByCategoryOneAndStyle("创意家居","创意生活",i+1,4));
        }
        modelAndView.addObject("list3",list3);
        return modelAndView;
    }

    @RequestMapping("/perfume")
    public ModelAndView perfume(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("perfume");
        List<Goods> goods1 = goodsService.findGoodsByCategoryOneAndStyle("蜡艺香薰","香薰精油");
        List<Goods> goods2 = goodsService.findGoodsByCategoryOneAndStyle("蜡艺香薰","复古香薰炉");
        modelAndView.addObject("goods1",goods1);
        modelAndView.addObject("goods2",goods2);
        return modelAndView;
    }

    @RequestMapping("/paint")
    public ModelAndView paint(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("paint");
        List<Goods> goods1 = goodsService.findGoodsByCategoryOneAndStyle("墙式壁挂","简约现代");
        List<Goods> goods2 = goodsService.findGoodsByCategoryOneAndStyle("墙式壁挂","浓情欧式");
        List<Goods> goods3 = goodsService.findGoodsByCategoryOneAndStyle("墙式壁挂","浪漫美式1");
        List<Goods> goods4 = goodsService.findGoodsByCategoryOneAndStyle("墙式壁挂","浪漫美式2");
        modelAndView.addObject("simpleAndModern",goods1);
        modelAndView.addObject("passionateFeeling",goods2);
        modelAndView.addObject("romanticOne",goods3);
        modelAndView.addObject("romanticTwo",goods4);
        return modelAndView;
    }

    @RequestMapping("/bzproList")
    public ModelAndView decorationBzproList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bzproList");
        List<Goods> goods = goodsService.findGoodsByCategoryOneAndCategoryTwo("布艺软饰","抱枕靠垫");
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }

    @RequestMapping("/zbproList")
    public ModelAndView decorationZbproList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("zbproList");
        List<Goods> goods = goodsService.findGoodsByCategoryOneAndCategoryTwo("布艺软饰","桌布罩件");
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }

    @RequestMapping("/decoration")
    public ModelAndView decoration(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("decoration");
        List<Goods> goods = goodsService.findGoodsByCategoryOne("布艺软饰");
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }

    @RequestMapping("/vase_proList")
    public ModelAndView flowerDerVaseProList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vase_proList");
        List<Goods> goods = goodsService.findGoodsByCategoryOneAndCategoryTwo("装饰摆件","花瓶花器");
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }
    @RequestMapping("/proList")
    public ModelAndView flowerDerProList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("proList");
        List<Goods> goods = goodsService.findGoodsByCategoryOneAndCategoryTwo("装饰摆件","干花花艺");
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }
    @RequestMapping("/flowerDer")
    public ModelAndView flowerDer(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("flowerDer");
        List<Goods> goods = goodsService.findGoodsByCategoryOne("装饰摆件");
        modelAndView.addObject("goods",goods);
        return modelAndView;
    }
}
