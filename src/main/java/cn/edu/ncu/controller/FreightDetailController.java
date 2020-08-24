package cn.edu.ncu.controller;

import cn.edu.ncu.pojo.FreightDetail;
import cn.edu.ncu.service.FreightDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-22.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Controller
public class FreightDetailController {
    @Resource
    private FreightDetailService freightDetailService;

    @RequestMapping("/freightDetail")
    public ModelAndView freightDetail(String freightId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("wuliu");
        List<FreightDetail> freightDetails = freightDetailService.findFreightDetailByFreightId(freightId);
        Collections.sort(freightDetails, new Comparator<FreightDetail>() {
            @Override
            public int compare(FreightDetail o1, FreightDetail o2) {
                Date age1 = o1.getUpdateTime();
                Date age2 = o2.getUpdateTime();
                return 0-age1.compareTo(age2);
            }

        });
        modelAndView.addObject("freightDetails",freightDetails);
        return modelAndView;
    }
}
