package cn.edu.ncu.service;

import cn.edu.ncu.dao.FreightDetailMapper;
import cn.edu.ncu.pojo.FreightDetail;
import cn.edu.ncu.pojo.FreightDetailExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-22.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Service
public class FreightDetailServiceImpl implements FreightDetailService{
    @Resource
    private FreightDetailMapper freightDetailMapper;

    @Override
    public List<FreightDetail> findFreightDetailByFreightId(String freightId){
        FreightDetailExample example = new FreightDetailExample();
        FreightDetailExample.Criteria cri = example.createCriteria();
        cri.andFreightIdEqualTo(freightId);
        return freightDetailMapper.selectByExample(example);
    }

    @Override
    public List<FreightDetail> findFreightDetailByOrderId(String orderId){
        FreightDetailExample example = new FreightDetailExample();
        FreightDetailExample.Criteria cri = example.createCriteria();
        cri.andOrderIdEqualTo(orderId);
        return freightDetailMapper.selectByExample(example);
    }

    @Override
    public int addFreightDetail(FreightDetail freightDetail){
        return freightDetailMapper.insert(freightDetail);
    }
}
