package cn.edu.ncu.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author Zhaiyi Jun
 * @Create by Masters on 2020-08-22.
 * @Description: EShop
 * @Modified by：[描述修改人]
 * @Version: 1.0
 * @History: [描述修改信息]
 */
@Setter
@Getter
@ToString
public class GoodsAndOrderDetailDTO {
    private int orderDetailId;
    private String content;
    private String picPath;
    private String title;
    private Double price;
    private int num;
}
