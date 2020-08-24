package cn.edu.ncu.service;

import cn.edu.ncu.dao.CartImgMapper;
import cn.edu.ncu.pojo.CartImg;
import cn.edu.ncu.pojo.CartImgExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
public class CartImgServiceImpl implements CartImgService{
    @Resource
    private CartImgMapper cartImgMapper;

    @Override
    public List<CartImg> findCartImgByIdAndSpec(long goodsId, String spec ){
        CartImgExample example = new CartImgExample();
        CartImgExample.Criteria cri = example.createCriteria();
        cri.andGoodsIdEqualTo(BigDecimal.valueOf(goodsId));
        cri.andSpecEqualTo(spec);
        return cartImgMapper.selectByExample(example);
    }
}
