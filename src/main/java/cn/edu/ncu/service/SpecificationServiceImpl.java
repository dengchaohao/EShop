package cn.edu.ncu.service;

import cn.edu.ncu.dao.SpecificationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-21.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Service
public class SpecificationServiceImpl implements SpecificationService{
    @Resource
    private SpecificationMapper specificationMapper;
}
