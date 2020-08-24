package cn.edu.ncu.dao;

import cn.edu.ncu.pojo.MsgImgs;
import cn.edu.ncu.pojo.MsgImgsExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgImgsMapper {
    int countByExample(MsgImgsExample example);

    int deleteByExample(MsgImgsExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(MsgImgs record);

    int insertSelective(MsgImgs record);

    List<MsgImgs> selectByExample(MsgImgsExample example);

    MsgImgs selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") MsgImgs record, @Param("example") MsgImgsExample example);

    int updateByExample(@Param("record") MsgImgs record, @Param("example") MsgImgsExample example);

    int updateByPrimaryKeySelective(MsgImgs record);

    int updateByPrimaryKey(MsgImgs record);
}