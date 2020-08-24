package cn.edu.ncu.service;

import cn.edu.ncu.pojo.FreightDetail;
import cn.edu.ncu.pojo.FreightDetailExample;

import java.util.List;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-22.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public interface FreightDetailService {
    List<FreightDetail> findFreightDetailByFreightId(String freightId);
    List<FreightDetail> findFreightDetailByOrderId(String orderId);
    int addFreightDetail(FreightDetail freightDetail);
}
