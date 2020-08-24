package cn.edu.ncu.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

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
public class OrderAndAddressDTO {
    private String orderId;
    private String status;
    private String contact;
    private String mobile;
    private String area;
    private String city;
    private String province;
    private String address;
    private String paymentType;
    private double payment;
    private double postFee;
    private Date createTime;
}
