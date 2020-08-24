package cn.edu.ncu.service;

import cn.edu.ncu.pojo.SpecificationOption;

import java.util.List;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-21.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
public interface SpecificationOptionService {
    List<SpecificationOption> findSpecOptionBySpecId(int specId);
}
