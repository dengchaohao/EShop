package cn.edu.ncu.service;

import cn.edu.ncu.dao.OrderMapper;
import cn.edu.ncu.dto.OrderAndAddressDTO;
import cn.edu.ncu.pojo.Order;
import cn.edu.ncu.pojo.OrderDetail;
import cn.edu.ncu.pojo.OrderExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
@Service
public class OrderServiceImpl implements OrderService{
    @Resource
    private OrderMapper orderMapper;


    @Override
    public OrderAndAddressDTO QueryOrderAndAddressByOrderId(String orderId){
        return orderMapper.queryOrderAndAddressByOrderId(orderId);
    }

    @Override
    public int updateOrder(Order order){
        OrderExample example = new OrderExample();
        OrderExample.Criteria cri = example.createCriteria();
        cri.andOrderIdEqualTo(order.getOrderId());
        return orderMapper.updateByExampleSelective(order, example);
    }

    @Override
    public int addOrder(Order order){
        return orderMapper.insertSelective(order);
    }

    @Override
    public List<Order> findOrderByOrderId(String orderId){
        OrderExample example = new OrderExample();
        OrderExample.Criteria cri = example.createCriteria();
        cri.andOrderIdEqualTo(orderId);
        return orderMapper.selectByExample(example);
    }

    @Override
    public int findAllOrderCountByUserName(String userName){
        OrderExample example = new OrderExample();
        OrderExample.Criteria cri = example.createCriteria();
        cri.andUsernameEqualTo(userName);
        return orderMapper.countByExample(example);
    }

    @Override
    public List<Order> findAllOrderByUserNameAndStatus(String userName,String status){
        OrderExample example = new OrderExample();
        OrderExample.Criteria cri = example.createCriteria();
        cri.andUsernameEqualTo(userName);
        cri.andStatusEqualTo(status);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> findAllOrderByUserName(String userName){
        OrderExample example = new OrderExample();
        OrderExample.Criteria cri = example.createCriteria();
        cri.andUsernameEqualTo(userName);
        return orderMapper.selectByExample(example);
    }

    @Override
    public List<Order> findAllOrderByUserName(String userName,int pageNumber, int pageSize){
        OrderExample example = new OrderExample();
        OrderExample.Criteria cri = example.createCriteria();
        cri.andUsernameEqualTo(userName);
        PageHelper.startPage(pageNumber, pageSize);
        List<Order> ordersList = orderMapper.selectByExample(example);
        // 获取分页对象
        PageInfo<Order> ordersPageInfo = new PageInfo<>(ordersList,pageSize);
        // 获取分页后的list集合
        List<Order> list = ordersPageInfo.getList();
        return list;
    }

    @Override
    public String addOrderAndOrderDetail(Order order, String p_goods, String p_num, String p_spec) {
        Map<String,Object> map = new HashMap<>();
        map.put("p_goods",p_goods);
        map.put("p_spec",p_spec);
        map.put("p_num",p_num);
        map.put("p_postFee",order.getPostFee());
        map.put("p_payment",order.getPayment());
        map.put("p_paymentType",order.getPaymentType());
        map.put("p_orderId",order.getOrderId());
        map.put("p_shopper",order.getUsername());
        map.put("p_address",order.getAddressId());
        orderMapper.insertOrderAndOrderDetail(map);
        String state = (String) map.get("p_success");
        if ("4001".equals(state)){
            return "商品不存在";
        }else if("4002".equals(state)){
            return "用户不存在";
        }else if ("4003".equals(state)){
            return "收货人地址信息不存在";
        }
        return "success";
    }
}
