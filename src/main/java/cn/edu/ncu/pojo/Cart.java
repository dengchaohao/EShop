package cn.edu.ncu.pojo;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author ZhaiyiJun
 * @Create by Masters on 2020-49-04-8:49.
 * @Description: ssm
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public class Cart {
    //购买商品的集合
    private Map<Pair<Goods, String>, Pair<Integer, String>> goods;

    //购物车的总金额
    private double totalPrice;

    //构造方法
    public Cart()
    {
        goods = new HashMap<Pair<Goods,String>, Pair<Integer, String>>();
        totalPrice = 0.0;
    }

    public Cart(Map<Pair<Goods,String>, Pair<Integer, String>> goods, double totalPrice) {
        super();
        this.goods = goods;
        this.totalPrice = totalPrice;
    }

    public Map<Pair<Goods,String>, Pair<Integer, String>> getGoods() {
        return goods;
    }

    public void setGoods(Map<Pair<Goods,String>, Pair<Integer, String>> goods) {
        this.goods = goods;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //添加商品进购物车的方法
    public boolean addGoodsInCart(Goods item ,String spec, int number, String img)
    {
        Pair<Goods,String> p = new Pair<>(item,spec);
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
        calTotalPrice(); //重新计算购物车的总金额
        return true;
    }

    //删除商品的方法
    public boolean removeGoodsFromCart(Goods item,String spec)
    {
        Pair<Goods,String> p = new Pair<>(item,spec);
        goods.remove(p);
        calTotalPrice(); //重新计算购物车的总金额
        return true;
    }

    //统计购物车的总金额
    public double calTotalPrice()
    {
        double sum = 0.0;
        Set<Pair<Goods,String>> keys = goods.keySet(); //获得键的集合
        Iterator<Pair<Goods,String>> it = keys.iterator(); //获得迭代器对象
        while(it.hasNext())
        {
            Pair<Goods,String> i = it.next();
            sum += i.getKey().getPrice().doubleValue()* goods.get(i).getKey();
        }
        this.setTotalPrice(sum); //设置购物车的总金额
        return this.getTotalPrice();
    }
}
