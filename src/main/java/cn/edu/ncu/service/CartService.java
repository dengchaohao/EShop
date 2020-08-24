package cn.edu.ncu.service;

import cn.edu.ncu.pojo.Cart;
import cn.edu.ncu.pojo.Goods;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-21.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public interface CartService {
    Cart addGoodsInCart(Goods good, String spec, int number, Cart cart, String img);
    Cart removeGoodsFromCart(Goods good,String spec,Cart cart);
    Cart calTotalPrice(Cart cart);
}
