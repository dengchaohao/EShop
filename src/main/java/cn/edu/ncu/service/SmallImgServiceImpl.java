package cn.edu.ncu.service;

import cn.edu.ncu.dao.SmallImgMapper;
import cn.edu.ncu.pojo.SmallImg;
import cn.edu.ncu.pojo.SmallImgExample;
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
public class SmallImgServiceImpl implements SmallImgService{
    @Resource
    private SmallImgMapper tbSmallImgMapper;

    public List<SmallImg> findSmalllImgBiGoodsId(long goodsId){
        SmallImgExample example = new SmallImgExample();
        SmallImgExample.Criteria cri = example.createCriteria();
        cri.andGoodsIdEqualTo(BigDecimal.valueOf(goodsId));
        return tbSmallImgMapper.selectByExample(example);
    }
}
