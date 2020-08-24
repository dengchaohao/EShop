package cn.edu.ncu.service;

import cn.edu.ncu.pojo.CartGoods;
import cn.edu.ncu.pojo.User;

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
public interface CartGoodsService {
    List<CartGoods> findAllCartGood(User user);
    int addCartGood(CartGoods cartGoods);
    int ClearCartGood();
    String insertCartGoods(CartGoods cartGoods);
}
