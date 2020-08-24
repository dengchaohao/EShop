package cn.edu.ncu.service;

import cn.edu.ncu.dao.AreaMapper;
import cn.edu.ncu.pojo.Area;
import cn.edu.ncu.pojo.AreaExample;
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
public class AreaServiceImpl implements AreaService{
    @Resource
    private AreaMapper areaMapper;

    @Override
    public List<Area> findAllAreas() {
        AreaExample example = new AreaExample();
        AreaExample.Criteria cri = example.createCriteria();
        cri.andAreaIdIsNotNull();
        List<Area> areas = areaMapper.selectByExample(example);
        return areas;
    }
}
