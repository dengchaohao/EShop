package cn.edu.ncu.service;

import cn.edu.ncu.dao.MsgImgsMapper;
import cn.edu.ncu.pojo.MsgImgs;
import cn.edu.ncu.pojo.MsgImgsExample;
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
public class MsgImgsServiceImpl implements MsgImgsService{
    @Resource
    private MsgImgsMapper tbMsgImgsMapper;

    @Override
    public List<MsgImgs> findMsgImgsByGoodsId(long goodsId){
        MsgImgsExample example = new MsgImgsExample();
        MsgImgsExample.Criteria cri = example.createCriteria();
        cri.andGoodsIdEqualTo(BigDecimal.valueOf(goodsId));
        return tbMsgImgsMapper.selectByExample(example);
    }
}
