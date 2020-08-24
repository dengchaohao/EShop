package cn.edu.ncu.service;

import cn.edu.ncu.dto.OrderAndAddressDTO;
import cn.edu.ncu.pojo.Order;
import cn.edu.ncu.pojo.OrderDetail;

import java.util.List;
import java.util.Map;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-21.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public interface OrderService {
    OrderAndAddressDTO QueryOrderAndAddressByOrderId(String orderId);
    int updateOrder(Order order);
    int addOrder(Order order);
    List<Order> findOrderByOrderId(String orderId);
    int findAllOrderCountByUserName(String userName);
    List<Order> findAllOrderByUserNameAndStatus(String userName,String status);
    List<Order> findAllOrderByUserName(String userName);
    List<Order> findAllOrderByUserName(String userName,int pageNumber, int pageSize);
    String addOrderAndOrderDetail(Order order, String p_goods,String p_num,String p_spec);
}
