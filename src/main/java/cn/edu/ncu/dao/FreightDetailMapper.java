package cn.edu.ncu.dao;

import cn.edu.ncu.pojo.FreightDetail;
import cn.edu.ncu.pojo.FreightDetailExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FreightDetailMapper {
    int countByExample(FreightDetailExample example);

    int deleteByExample(FreightDetailExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(FreightDetail record);

    int insertSelective(FreightDetail record);

    List<FreightDetail> selectByExample(FreightDetailExample example);

    FreightDetail selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") FreightDetail record, @Param("example") FreightDetailExample example);

    int updateByExample(@Param("record") FreightDetail record, @Param("example") FreightDetailExample example);

    int updateByPrimaryKeySelective(FreightDetail record);

    int updateByPrimaryKey(FreightDetail record);
}