package cn.edu.ncu.pojo;

import java.math.BigDecimal;

public class SmallImg {
    private BigDecimal id;

    private BigDecimal goodsId;

    private String prodet;

    private String prodetBig;

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

    public String getProdet() {
        return prodet;
    }

    public void setProdet(String prodet) {
        this.prodet = prodet == null ? null : prodet.trim();
    }

    public String getProdetBig() {
        return prodetBig;
    }

    public void setProdetBig(String prodetBig) {
        this.prodetBig = prodetBig == null ? null : prodetBig.trim();
    }
}