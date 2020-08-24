package cn.edu.ncu.dao;

import cn.edu.ncu.pojo.CartGoods;
import cn.edu.ncu.pojo.CartGoodsExample;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CartGoodsMapper {
    void insertCartGoods(Map<String,Object> map);

    int countByExample(CartGoodsExample example);

    int deleteByExample(CartGoodsExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(CartGoods record);

    int insertSelective(CartGoods record);

    List<CartGoods> selectByExample(CartGoodsExample example);

    CartGoods selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") CartGoods record, @Param("example") CartGoodsExample example);

    int updateByExample(@Param("record") CartGoods record, @Param("example") CartGoodsExample example);

    int updateByPrimaryKeySelective(CartGoods record);

    int updateByPrimaryKey(CartGoods record);
}