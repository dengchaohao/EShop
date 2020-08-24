package cn.edu.ncu.controller;

import cn.edu.ncu.pojo.Cart;
import cn.edu.ncu.pojo.CartImg;
import cn.edu.ncu.pojo.Goods;
import cn.edu.ncu.pojo.User;
import cn.edu.ncu.service.CartImgService;
import cn.edu.ncu.service.CartService;
import cn.edu.ncu.service.GoodsService;
import javafx.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
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
public class CartController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private CartService cartService;
    @Resource
    private CartImgService cartImgService;

    @ResponseBody
    @RequestMapping("/settleAccounts")
    public String settleAccounts(String[] strs, HttpSession session){
        if(strs == null){
            return "false";
        }
        Cart cartOrder = new Cart();
        for (String str:strs){
            String[] cartGoodsInfo = str.split(",");
            Goods item = goodsService.findGoodsById(Long.parseLong(cartGoodsInfo[0]));
            cartOrder.addGoodsInCart(item,cartGoodsInfo[1],Integer.parseInt(cartGoodsInfo[2]),cartGoodsInfo[3]);
        }
        if (session.getAttribute("cartOrder")!=null) {
            session.removeAttribute("cartOrder");
        }
        session.setAttribute("cartOrder",cartOrder);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/batchRemoveGoodsFromCart")
    public String batchRemoveGoodsFromCart(String[] strs, HttpSession session){
        if(strs == null){
            return "false";
        }
        for (String str:strs){
            String[] cartGoodsInfo = str.split(",");
            removeGoodsFromCart(cartGoodsInfo[0],cartGoodsInfo[1],session);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("/addGoodsInCart")
    public String addGoodsInCart(String id, Integer number, String spec, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null) return "false";
        Goods good = goodsService.findGoodsById(Long.parseLong(id));
        Cart cart = null;
        if(session.getAttribute("cart")!=null){
            cart=(Cart) session.getAttribute("cart");
        }else{
            cart=new Cart();
        }
        List<CartImg> cartImgs = cartImgService.findCartImgByIdAndSpec(Long.parseLong(id),spec);
        String img = null;
        if (cartImgs.size() == 1) img = cartImgs.get(0).getCartImgUrl();
        cart = cartService.addGoodsInCart(good, spec, number,cart,img);
        session.setAttribute("cart",cart);
        return "success";
    }

    @RequestMapping("/removeGoodsFromCart")
    public ModelAndView removeGoodsFromCart(String id, String spec, HttpSession session){
        Goods good = goodsService.findGoodsById(Long.parseLong(id));
        Cart cart=(Cart) session.getAttribute("cart");
        cart = cartService.removeGoodsFromCart(good, spec, cart);
        session.setAttribute("cart",cart);
        return new ModelAndView("redirect:/cart");
    }

    @RequestMapping("/cleanCart")
    public ModelAndView cleanCart(HttpSession session){
        Cart cart = null;
        session.setAttribute("cart",cart);
        return new ModelAndView("redirect:/cart");
    }

    @ResponseBody
    @RequestMapping(value = "/checkStore",produces={"text/html;charset=UTF-8;","application/json;"})
    public String checkStore(HttpSession session){
        Cart cart =(Cart)session.getAttribute("cart");
        Map<Pair<Goods,String>, Pair<Integer, String>> map = cart.getGoods();
        Iterator<Map.Entry<Pair<Goods,String>, Pair<Integer, String>>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Pair<Goods,String>, Pair<Integer, String>> entry =  iter.next();
            Pair<Goods,String> good = entry.getKey();
            Integer number = entry.getValue().getKey();
            if (!goodsService.checkStore(good.getKey().getGoodsId().intValue(),number)){
                return good.getKey().getName()+" 库存不足, 库存剩余:"+good.getKey().getStock();
            }
        }
        return "success";
    }
}
