package cn.edu.ncu.dao;

import cn.edu.ncu.pojo.CartImg;
import cn.edu.ncu.pojo.CartImgExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartImgMapper {
    int countByExample(CartImgExample example);

    int deleteByExample(CartImgExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(CartImg record);

    int insertSelective(CartImg record);

    List<CartImg> selectByExample(CartImgExample example);

    CartImg selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") CartImg record, @Param("example") CartImgExample example);

    int updateByExample(@Param("record") CartImg record, @Param("example") CartImgExample example);

    int updateByPrimaryKeySelective(CartImg record);

    int updateByPrimaryKey(CartImg record);
}