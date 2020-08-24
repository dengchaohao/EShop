package cn.edu.ncu.service;

import cn.edu.ncu.dto.GoodsAndOrderDetailDTO;
import cn.edu.ncu.pojo.OrderDetail;

import java.util.List;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-21.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public interface OrderDetailService {
    List<GoodsAndOrderDetailDTO> queryGoodsAndOrderDetailByOrderId(String orderId);
    GoodsAndOrderDetailDTO queryGoodsAndOrderDetailByrId(int id);
    List<OrderDetail> findOrderItemsByGoodsIdAndEvaluate(Long goodsId, String evaluate);
    int updateOrderItem(OrderDetail orderItem);
    OrderDetail findOrderItemById(long id);
    List<OrderDetail> findOrderItemByOrderIdAndGoodsId(long goodsId, String orderId);
    int addOrderItem(OrderDetail orderItem);
    List<OrderDetail> findOrderItemsBuOrderId(String orderId);
    List<GoodsAndOrderDetailDTO> findOrderItemsByOrderIdAndEvaluate(List<String> orderId, String evaluate);
}
