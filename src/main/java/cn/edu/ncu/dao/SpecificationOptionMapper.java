package cn.edu.ncu.dao;

import cn.edu.ncu.pojo.SpecificationOption;
import cn.edu.ncu.pojo.SpecificationOptionExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpecificationOptionMapper {
    int countByExample(SpecificationOptionExample example);

    int deleteByExample(SpecificationOptionExample example);

    int deleteByPrimaryKey(BigDecimal specOptionId);

    int insert(SpecificationOption record);

    int insertSelective(SpecificationOption record);

    List<SpecificationOption> selectByExample(SpecificationOptionExample example);

    SpecificationOption selectByPrimaryKey(BigDecimal specOptionId);

    int updateByExampleSelective(@Param("record") SpecificationOption record, @Param("example") SpecificationOptionExample example);

    int updateByExample(@Param("record") SpecificationOption record, @Param("example") SpecificationOptionExample example);

    int updateByPrimaryKeySelective(SpecificationOption record);

    int updateByPrimaryKey(SpecificationOption record);
}