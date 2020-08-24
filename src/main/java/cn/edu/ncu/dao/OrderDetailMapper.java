package cn.edu.ncu.dao;

import cn.edu.ncu.dto.GoodsAndOrderDetailDTO;
import cn.edu.ncu.pojo.OrderDetail;
import cn.edu.ncu.pojo.OrderDetailExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {
    List<GoodsAndOrderDetailDTO> queryGoodsAndOrderDetailByOrderId(String orderId);

    GoodsAndOrderDetailDTO queryGoodsAndOrderDetailById(int id);

    int countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}