package cn.edu.ncu.dao;

import cn.edu.ncu.dto.OrderAndAddressDTO;
import cn.edu.ncu.pojo.Order;
import cn.edu.ncu.pojo.OrderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    OrderAndAddressDTO queryOrderAndAddressByOrderId(String orderId);

    void insertOrderAndOrderDetail(Map<String,Object> map);

    int countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}