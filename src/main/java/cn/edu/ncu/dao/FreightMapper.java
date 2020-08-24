package cn.edu.ncu.dao;

import cn.edu.ncu.pojo.Freight;
import cn.edu.ncu.pojo.FreightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FreightMapper {
    int countByExample(FreightExample example);

    int deleteByExample(FreightExample example);

    int deleteByPrimaryKey(String freightId);

    int insert(Freight record);

    int insertSelective(Freight record);

    List<Freight> selectByExample(FreightExample example);

    Freight selectByPrimaryKey(String freightId);

    int updateByExampleSelective(@Param("record") Freight record, @Param("example") FreightExample example);

    int updateByExample(@Param("record") Freight record, @Param("example") FreightExample example);

    int updateByPrimaryKeySelective(Freight record);

    int updateByPrimaryKey(Freight record);
}