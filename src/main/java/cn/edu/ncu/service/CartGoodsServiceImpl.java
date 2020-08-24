package cn.edu.ncu.service;

import cn.edu.ncu.dao.CartGoodsMapper;
import cn.edu.ncu.pojo.CartGoods;
import cn.edu.ncu.pojo.CartGoodsExample;
import cn.edu.ncu.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
@Service
public class CartGoodsServiceImpl implements CartGoodsService{
    @Resource
    private CartGoodsMapper cartGoodsMapper;

    @Override
    public List<CartGoods> findAllCartGood(User user){
        CartGoodsExample example = new CartGoodsExample();
        CartGoodsExample.Criteria cri = example.createCriteria();
        cri.andIdIsNotNull();
        cri.andUsernameEqualTo(user.getUsername());
        return cartGoodsMapper.selectByExample(example);
    }

    /*
    不安全的sql插入方式
     */
    @Override
    public int addCartGood(CartGoods cartGoods){
        return cartGoodsMapper.insert(cartGoods);
    }

    @Override
    public int ClearCartGood(){
        CartGoodsExample example = new CartGoodsExample();
        CartGoodsExample.Criteria cri = example.createCriteria();
        cri.andIdIsNotNull();
        return cartGoodsMapper.deleteByExample(example);
    }

    @Override
    public String insertCartGoods(CartGoods cartGoods) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",cartGoods.getUsername());
        map.put("goodsId",cartGoods.getGoodsId());
        map.put("numb",cartGoods.getNum());
        map.put("specification",cartGoods.getSpec());
        cartGoodsMapper.insertCartGoods(map);
        String state = (String) map.get("state");
        if ("4001".equals(state)){
            return "商品不存在";
        }else if("4002".equals(state)){
            return "用户不存在";
        }
        return "success";
    }
}
