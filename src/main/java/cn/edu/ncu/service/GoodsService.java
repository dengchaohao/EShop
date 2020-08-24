package cn.edu.ncu.service;

import cn.edu.ncu.pojo.Goods;

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
public interface GoodsService {
    List<Goods> findGoodsByCategoryOneAndStyle(String categoryOne, String style, int pageNumber, int pageSize);
    List<Goods> findGoodsByCategoryOneAndStyle(String categoryOne,String style);
    List<Goods> findGoodsByCategoryOneAndCategoryTwo(String categoryOne,String categoryTwo);
    List<Goods> findGoodsByCategoryOne(String categoryOne);
    Goods findGoodsById(long id);
    boolean checkStore(Integer id, Integer number);
    List<Goods> findGoodsByContentId(BigDecimal ContentId);
}
