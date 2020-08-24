package cn.edu.ncu.pojo;

import java.math.BigDecimal;

public class MsgImgs {
    private BigDecimal id;

    private BigDecimal goodsId;

    private String msgImg;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigDecimal goodsId) {
        this.goodsId = goodsId;
    }

    public String getMsgImg() {
        return msgImg;
    }

    public void setMsgImg(String msgImg) {
        this.msgImg = msgImg == null ? null : msgImg.trim();
    }
}