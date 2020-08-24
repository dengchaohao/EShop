package cn.edu.ncu.service;

import cn.edu.ncu.dao.CityMapper;
import cn.edu.ncu.pojo.City;
import cn.edu.ncu.pojo.CityExample;
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
public class CityServiceImpl implements CityService{
    @Resource
    private CityMapper cityMapper;

    @Override
    public List<City> findAllCities() {
        CityExample example = new CityExample();
        CityExample.Criteria cri = example.createCriteria();
        cri.andCityIdIsNotNull();
        List<City> cities = cityMapper.selectByExample(example);
        return cities;
    }
}
