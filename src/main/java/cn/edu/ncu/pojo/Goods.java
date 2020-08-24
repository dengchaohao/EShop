package cn.edu.ncu.pojo;

import java.math.BigDecimal;
import java.util.Objects;

public class Goods {
    private BigDecimal goodsId;

    private BigDecimal specOptionId;

    private BigDecimal contentId;

    private String name;

    private BigDecimal price;

    private BigDecimal stock;

    private String isMarketable;

    private String categoryOne;

    private String categoryTwo;

    private String style;

    private String prodetPic;

    private String introduction;

    private String specId;

    public BigDecimal getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigDecimal goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getSpecOptionId() {
        return specOptionId;
    }

    public void setSpecOptionId(BigDecimal specOptionId) {
        this.specOptionId = specOptionId;
    }

    public BigDecimal getContentId() {
        return contentId;
    }

    public void setContentId(BigDecimal contentId) {
        this.contentId = contentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable == null ? null : isMarketable.trim();
    }

    public String getCategoryOne() {
        return categoryOne;
    }

    public void setCategoryOne(String categoryOne) {
        this.categoryOne = categoryOne == null ? null : categoryOne.trim();
    }

    public String getCategoryTwo() {
        return categoryTwo;
    }

    public void setCategoryTwo(String categoryTwo) {
        this.categoryTwo = categoryTwo == null ? null : categoryTwo.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public String getProdetPic() {
        return prodetPic;
    }

    public void setProdetPic(String prodetPic) {
        this.prodetPic = prodetPic == null ? null : prodetPic.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId) &&
                Objects.equals(specOptionId, goods.specOptionId) &&
                Objects.equals(contentId, goods.contentId) &&
                Objects.equals(name, goods.name) &&
                Objects.equals(price, goods.price) &&
                Objects.equals(stock, goods.stock) &&
                Objects.equals(isMarketable, goods.isMarketable) &&
                Objects.equals(categoryOne, goods.categoryOne) &&
                Objects.equals(categoryTwo, goods.categoryTwo) &&
                Objects.equals(style, goods.style) &&
                Objects.equals(prodetPic, goods.prodetPic) &&
                Objects.equals(introduction, goods.introduction) &&
                Objects.equals(specId, goods.specId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, specOptionId, contentId, name, price, stock, isMarketable, categoryOne, categoryTwo, style, prodetPic, introduction, specId);
    }
}