package cn.edu.ncu.service;

import cn.edu.ncu.dao.ProvinceMapper;
import cn.edu.ncu.pojo.Province;
import cn.edu.ncu.pojo.ProvinceExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-20.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Service
public class ProvinceServiceImpl implements ProvinceService{
    @Resource
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> findAllProvinces() {
        ProvinceExample example = new ProvinceExample();
        ProvinceExample.Criteria cri = example.createCriteria();
        cri.andProvinceIdIsNotNull();
        List<Province> provinces = provinceMapper.selectByExample(example);
        return provinces;
    }
}
