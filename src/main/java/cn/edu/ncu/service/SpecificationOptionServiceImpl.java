package cn.edu.ncu.service;

import cn.edu.ncu.dao.SpecificationOptionMapper;
import cn.edu.ncu.pojo.SpecificationOption;
import cn.edu.ncu.pojo.SpecificationOptionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
public class SpecificationOptionServiceImpl implements SpecificationOptionService{
    @Resource
    private SpecificationOptionMapper SpecificationOptionExample;

    @Override
    public List<SpecificationOption> findSpecOptionBySpecId(int specId){
        cn.edu.ncu.pojo.SpecificationOptionExample example = new SpecificationOptionExample();
        SpecificationOptionExample.Criteria cri = example.createCriteria();
        cri.andSpecIdEqualTo(BigDecimal.valueOf(specId));
        return SpecificationOptionExample.selectByExample(example);
    }
}
