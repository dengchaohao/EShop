package cn.edu.ncu.pojo;

import java.math.BigDecimal;

public class CartImg {
    private BigDecimal id;

    private String spec;

    private String cartImgUrl;

    private BigDecimal goodsId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getCartImgUrl() {
        return cartImgUrl;
    }

    public void setCartImgUrl(String cartImgUrl) {
        this.cartImgUrl = cartImgUrl == null ? null : cartImgUrl.trim();
    }

    public BigDecimal getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigDecimal goodsId) {
        this.goodsId = goodsId;
    }
}