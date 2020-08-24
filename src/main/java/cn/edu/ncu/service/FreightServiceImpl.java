package cn.edu.ncu.service;

import cn.edu.ncu.dao.FreightMapper;
import cn.edu.ncu.pojo.Freight;
import cn.edu.ncu.pojo.FreightExample;
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
public class FreightServiceImpl implements FreightService{
    @Resource
    private FreightMapper freightMapper;

    public int addFreight(Freight freight){
        return freightMapper.insert(freight);
    }

    public List<Freight> findFreightByFreightId(long freightId){
        FreightExample example = new FreightExample();
        FreightExample.Criteria cri = example.createCriteria();
        cri.andFreightIdEqualTo(String.valueOf(freightId));
        return freightMapper.selectByExample(example);
    }
}
