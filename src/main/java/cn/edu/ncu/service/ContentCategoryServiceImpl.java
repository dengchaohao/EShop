package cn.edu.ncu.service;

import cn.edu.ncu.dao.ContentCategoryMapper;
import cn.edu.ncu.pojo.ContentCategory;
import cn.edu.ncu.pojo.ContentCategoryExample;
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
public class ContentCategoryServiceImpl implements ContentCategoryService{
    @Resource
    private ContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List<ContentCategory> findContentCategoryByName(String name){
        ContentCategoryExample example = new ContentCategoryExample();
        ContentCategoryExample.Criteria cri = example.createCriteria();
        cri.andNameEqualTo(name);
        return tbContentCategoryMapper.selectByExample(example);
    }
}
