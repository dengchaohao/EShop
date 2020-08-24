package cn.edu.ncu.service;

import cn.edu.ncu.pojo.Cart;
import cn.edu.ncu.pojo.Goods;
import javafx.util.Pair;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-21.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Service
public class CartServiceImpl implements CartService{
    @Override
    public Cart addGoodsInCart(Goods good, String spec, int number, Cart cart, String img) {
        Map<Pair<Goods, String>, Pair<Integer, String>> goods = cart.getGoods();
        Pair<Goods,String> p = new Pair<>(good,spec);
        // 比较对象时， ==比较的是地址
        // 想要比较两个对象相等，可以通过重写equals()实现。此时需要重写equals()方法必须重写hashCode()
        // 这里需要重写 Goods 类的 equals()方法和 hashCode()
        if(goods.containsKey(p))
        {
            Pair<Integer,String> pair = new Pair<>(goods.get(p).getKey()+number,goods.get(p).getValue());
            goods.put(p, pair);
        }
        else
        {
            Pair<Integer,String> pair = new Pair<>(number,img);
            goods.put(p, pair);
        }
        //重新计算购物车的总金额
        return calTotalPrice(cart);
    }


    @Override
    public Cart removeGoodsFromCart(Goods good,String spec,Cart cart) {
        Map<Pair<Goods, String>, Pair<Integer, String>> goods = cart.getGoods();
        Pair<Goods,String> p = new Pair<>(good,spec); // 需要重写TbGoods的equals方法和hashCode方法
        /*for (Map.Entry<Pair<TbGoods, String>, Pair<Integer, String>> entry : goods.entrySet()) {
            if (entry.getKey().getKey().equals(good) && entry.getKey().getValue().equals(spec)){
                Pair<TbGoods,String> p = entry.getKey();
                goods.remove(p);
            }
        }*/
        goods.remove(p);
        System.out.println(goods);
        cart.setGoods(goods);
        //重新计算购物车的总金额
        return calTotalPrice(cart);
    }

    @Override
    public Cart calTotalPrice(Cart cart) {
        Map<Pair<Goods, String>, Pair<Integer, String>> goods = cart.getGoods();
        double sum = 0.0;
        Set<Pair<Goods,String>> keys = goods.keySet(); //获得键的集合
        Iterator<Pair<Goods,String>> it = keys.iterator(); //获得迭代器对象
        while(it.hasNext())
        {
            Pair<Goods,String> i = it.next();
            sum += i.getKey().getPrice().doubleValue()* goods.get(i).getKey();
        }
        cart.setTotalPrice(sum);
        return cart;
    }
}
