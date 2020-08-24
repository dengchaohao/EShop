package cn.edu.ncu.service;

import cn.edu.ncu.dao.OrderDetailMapper;
import cn.edu.ncu.dto.GoodsAndOrderDetailDTO;
import cn.edu.ncu.pojo.OrderDetail;
import cn.edu.ncu.pojo.OrderDetailExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-21.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<GoodsAndOrderDetailDTO> queryGoodsAndOrderDetailByOrderId(String orderId) {
        return orderDetailMapper.queryGoodsAndOrderDetailByOrderId(orderId);
    }

    @Override
    public GoodsAndOrderDetailDTO queryGoodsAndOrderDetailByrId(int id) {
        return orderDetailMapper.queryGoodsAndOrderDetailById(id);
    }

    @Override
    public List<OrderDetail> findOrderItemsByGoodsIdAndEvaluate(Long goodsId, String evaluate) {
        OrderDetailExample example = new OrderDetailExample();
        OrderDetailExample.Criteria cri = example.createCriteria();
        cri.andGoodsIdEqualTo(BigDecimal.valueOf(goodsId));
        cri.andEvaluateEqualTo(evaluate);
        return orderDetailMapper.selectByExample(example);
    }

    @Override
    public int updateOrderItem(OrderDetail orderItem) {
        return orderDetailMapper.updateByPrimaryKeySelective(orderItem);
    }

    @Override
    public OrderDetail findOrderItemById(long id) {
        return orderDetailMapper.selectByPrimaryKey(BigDecimal.valueOf(id));
    }

    @Override
    public List<OrderDetail> findOrderItemByOrderIdAndGoodsId(long goodsId, String orderId) {
        OrderDetailExample example = new OrderDetailExample();
        OrderDetailExample.Criteria cri = example.createCriteria();
        cri.andOrderIdEqualTo(orderId);
        cri.andGoodsIdEqualTo(BigDecimal.valueOf(goodsId));
        return orderDetailMapper.selectByExample(example);
    }

    @Override
    public int addOrderItem(OrderDetail orderItem) {
        return orderDetailMapper.insertSelective(orderItem);
    }

    @Override
    public List<OrderDetail> findOrderItemsBuOrderId(String orderId) {
        OrderDetailExample example = new OrderDetailExample();
        OrderDetailExample.Criteria cri = example.createCriteria();
        cri.andOrderIdEqualTo(orderId);
        return orderDetailMapper.selectByExample(example);
    }

    @Override
    public List<GoodsAndOrderDetailDTO> findOrderItemsByOrderIdAndEvaluate(List<String> orderId, String evaluate) {
        OrderDetailExample example = new OrderDetailExample();
        OrderDetailExample.Criteria cri = example.createCriteria();
        cri.andOrderIdIn(orderId);
        cri.andEvaluateEqualTo(evaluate);
        List<GoodsAndOrderDetailDTO> list = new ArrayList<>();
        List<OrderDetail> ods = orderDetailMapper.selectByExample(example);
        for (OrderDetail od : ods) {
            GoodsAndOrderDetailDTO e = orderDetailMapper.queryGoodsAndOrderDetailById(od.getId().intValue());
            list.add(e);
        }
        return list;
    }
}
