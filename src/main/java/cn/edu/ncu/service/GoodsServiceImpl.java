package cn.edu.ncu.service;

import cn.edu.ncu.dao.GoodsMapper;
import cn.edu.ncu.pojo.Goods;
import cn.edu.ncu.pojo.GoodsExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class GoodsServiceImpl implements GoodsService{
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> findGoodsByCategoryOneAndStyle(String categoryOne, String style, int pageNumber, int pageSize){
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria cri = example.createCriteria();
        cri.andCategoryOneEqualTo(categoryOne);
        cri.andStyleEqualTo(style);

        PageHelper.startPage(pageNumber, pageSize);
        List<Goods> goodsList = goodsMapper.selectByExample(example);
        // 获取分页对象
        PageInfo<Goods> goodsPageInfo = new PageInfo<Goods>(goodsList);
        // 获取分页后的list集合
        List<Goods> list = goodsPageInfo.getList();
        return list;
    }

    @Override
    public List<Goods> findGoodsByCategoryOneAndStyle(String categoryOne,String style){
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria cri = example.createCriteria();
        cri.andCategoryOneEqualTo(categoryOne);
        cri.andStyleEqualTo(style);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public List<Goods> findGoodsByCategoryOneAndCategoryTwo(String categoryOne,String categoryTwo){
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria cri = example.createCriteria();
        cri.andCategoryOneEqualTo(categoryOne);
        cri.andCategoryTwoEqualTo(categoryTwo);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public List<Goods> findGoodsByCategoryOne(String categoryOne){
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria cri = example.createCriteria();
        cri.andCategoryOneEqualTo(categoryOne);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public Goods findGoodsById(long id){
        return goodsMapper.selectByPrimaryKey(BigDecimal.valueOf(id));
    }

    @Override
    public boolean checkStore(Integer id, Integer number){
        BigDecimal store = goodsMapper.selectByPrimaryKey(BigDecimal.valueOf((long)id)).getStock();
        if (store.doubleValue()-number>=0){
            return true;
        }
        return false;
    }

    @Override
    public List<Goods> findGoodsByContentId(BigDecimal ContentId) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria cri = example.createCriteria();
        cri.andContentIdEqualTo(ContentId);
        return goodsMapper.selectByExample(example);
    }
}
