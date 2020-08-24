package cn.edu.ncu.dao;

import cn.edu.ncu.pojo.SmallImg;
import cn.edu.ncu.pojo.SmallImgExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmallImgMapper {
    int countByExample(SmallImgExample example);

    int deleteByExample(SmallImgExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(SmallImg record);

    int insertSelective(SmallImg record);

    List<SmallImg> selectByExample(SmallImgExample example);

    SmallImg selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") SmallImg record, @Param("example") SmallImgExample example);

    int updateByExample(@Param("record") SmallImg record, @Param("example") SmallImgExample example);

    int updateByPrimaryKeySelective(SmallImg record);

    int updateByPrimaryKey(SmallImg record);
}