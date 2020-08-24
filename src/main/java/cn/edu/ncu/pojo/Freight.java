package cn.edu.ncu.pojo;

import java.util.Date;

public class Freight {
    private String freightId;

    private String expressDelivery;

    private String sendTimeType;

    private Date createTime;

    public String getFreightId() {
        return freightId;
    }

    public void setFreightId(String freightId) {
        this.freightId = freightId == null ? null : freightId.trim();
    }

    public String getExpressDelivery() {
        return expressDelivery;
    }

    public void setExpressDelivery(String expressDelivery) {
        this.expressDelivery = expressDelivery == null ? null : expressDelivery.trim();
    }

    public String getSendTimeType() {
        return sendTimeType;
    }

    public void setSendTimeType(String sendTimeType) {
        this.sendTimeType = sendTimeType == null ? null : sendTimeType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}