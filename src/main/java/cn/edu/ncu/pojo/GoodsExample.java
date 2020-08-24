package cn.edu.ncu.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("GOODS_ID is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("GOODS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(BigDecimal value) {
            addCriterion("GOODS_ID =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(BigDecimal value) {
            addCriterion("GOODS_ID <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(BigDecimal value) {
            addCriterion("GOODS_ID >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_ID >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(BigDecimal value) {
            addCriterion("GOODS_ID <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("GOODS_ID <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<BigDecimal> values) {
            addCriterion("GOODS_ID in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<BigDecimal> values) {
            addCriterion("GOODS_ID not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_ID between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("GOODS_ID not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdIsNull() {
            addCriterion("SPEC_OPTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdIsNotNull() {
            addCriterion("SPEC_OPTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdEqualTo(BigDecimal value) {
            addCriterion("SPEC_OPTION_ID =", value, "specOptionId");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdNotEqualTo(BigDecimal value) {
            addCriterion("SPEC_OPTION_ID <>", value, "specOptionId");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdGreaterThan(BigDecimal value) {
            addCriterion("SPEC_OPTION_ID >", value, "specOptionId");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SPEC_OPTION_ID >=", value, "specOptionId");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdLessThan(BigDecimal value) {
            addCriterion("SPEC_OPTION_ID <", value, "specOptionId");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SPEC_OPTION_ID <=", value, "specOptionId");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdIn(List<BigDecimal> values) {
            addCriterion("SPEC_OPTION_ID in", values, "specOptionId");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdNotIn(List<BigDecimal> values) {
            addCriterion("SPEC_OPTION_ID not in", values, "specOptionId");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPEC_OPTION_ID between", value1, value2, "specOptionId");
            return (Criteria) this;
        }

        public Criteria andSpecOptionIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPEC_OPTION_ID not between", value1, value2, "specOptionId");
            return (Criteria) this;
        }

        public Criteria andContentIdIsNull() {
            addCriterion("CONTENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andContentIdIsNotNull() {
            addCriterion("CONTENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andContentIdEqualTo(BigDecimal value) {
            addCriterion("CONTENT_ID =", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotEqualTo(BigDecimal value) {
            addCriterion("CONTENT_ID <>", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdGreaterThan(BigDecimal value) {
            addCriterion("CONTENT_ID >", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTENT_ID >=", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLessThan(BigDecimal value) {
            addCriterion("CONTENT_ID <", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CONTENT_ID <=", value, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdIn(List<BigDecimal> values) {
            addCriterion("CONTENT_ID in", values, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotIn(List<BigDecimal> values) {
            addCriterion("CONTENT_ID not in", values, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTENT_ID between", value1, value2, "contentId");
            return (Criteria) this;
        }

        public Criteria andContentIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CONTENT_ID not between", value1, value2, "contentId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("STOCK is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("STOCK is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(BigDecimal value) {
            addCriterion("STOCK =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(BigDecimal value) {
            addCriterion("STOCK <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(BigDecimal value) {
            addCriterion("STOCK >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("STOCK >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(BigDecimal value) {
            addCriterion("STOCK <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(BigDecimal value) {
            addCriterion("STOCK <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<BigDecimal> values) {
            addCriterion("STOCK in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<BigDecimal> values) {
            addCriterion("STOCK not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STOCK between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("STOCK not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andIsMarketableIsNull() {
            addCriterion("IS_MARKETABLE is null");
            return (Criteria) this;
        }

        public Criteria andIsMarketableIsNotNull() {
            addCriterion("IS_MARKETABLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsMarketableEqualTo(String value) {
            addCriterion("IS_MARKETABLE =", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableNotEqualTo(String value) {
            addCriterion("IS_MARKETABLE <>", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableGreaterThan(String value) {
            addCriterion("IS_MARKETABLE >", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableGreaterThanOrEqualTo(String value) {
            addCriterion("IS_MARKETABLE >=", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableLessThan(String value) {
            addCriterion("IS_MARKETABLE <", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableLessThanOrEqualTo(String value) {
            addCriterion("IS_MARKETABLE <=", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableLike(String value) {
            addCriterion("IS_MARKETABLE like", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableNotLike(String value) {
            addCriterion("IS_MARKETABLE not like", value, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableIn(List<String> values) {
            addCriterion("IS_MARKETABLE in", values, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableNotIn(List<String> values) {
            addCriterion("IS_MARKETABLE not in", values, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableBetween(String value1, String value2) {
            addCriterion("IS_MARKETABLE between", value1, value2, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andIsMarketableNotBetween(String value1, String value2) {
            addCriterion("IS_MARKETABLE not between", value1, value2, "isMarketable");
            return (Criteria) this;
        }

        public Criteria andCategoryOneIsNull() {
            addCriterion("CATEGORY_ONE is null");
            return (Criteria) this;
        }

        public Criteria andCategoryOneIsNotNull() {
            addCriterion("CATEGORY_ONE is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryOneEqualTo(String value) {
            addCriterion("CATEGORY_ONE =", value, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneNotEqualTo(String value) {
            addCriterion("CATEGORY_ONE <>", value, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneGreaterThan(String value) {
            addCriterion("CATEGORY_ONE >", value, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY_ONE >=", value, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneLessThan(String value) {
            addCriterion("CATEGORY_ONE <", value, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY_ONE <=", value, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneLike(String value) {
            addCriterion("CATEGORY_ONE like", value, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneNotLike(String value) {
            addCriterion("CATEGORY_ONE not like", value, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneIn(List<String> values) {
            addCriterion("CATEGORY_ONE in", values, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneNotIn(List<String> values) {
            addCriterion("CATEGORY_ONE not in", values, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneBetween(String value1, String value2) {
            addCriterion("CATEGORY_ONE between", value1, value2, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryOneNotBetween(String value1, String value2) {
            addCriterion("CATEGORY_ONE not between", value1, value2, "categoryOne");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoIsNull() {
            addCriterion("CATEGORY_TWO is null");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoIsNotNull() {
            addCriterion("CATEGORY_TWO is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoEqualTo(String value) {
            addCriterion("CATEGORY_TWO =", value, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoNotEqualTo(String value) {
            addCriterion("CATEGORY_TWO <>", value, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoGreaterThan(String value) {
            addCriterion("CATEGORY_TWO >", value, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoGreaterThanOrEqualTo(String value) {
            addCriterion("CATEGORY_TWO >=", value, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoLessThan(String value) {
            addCriterion("CATEGORY_TWO <", value, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoLessThanOrEqualTo(String value) {
            addCriterion("CATEGORY_TWO <=", value, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoLike(String value) {
            addCriterion("CATEGORY_TWO like", value, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoNotLike(String value) {
            addCriterion("CATEGORY_TWO not like", value, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoIn(List<String> values) {
            addCriterion("CATEGORY_TWO in", values, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoNotIn(List<String> values) {
            addCriterion("CATEGORY_TWO not in", values, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoBetween(String value1, String value2) {
            addCriterion("CATEGORY_TWO between", value1, value2, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andCategoryTwoNotBetween(String value1, String value2) {
            addCriterion("CATEGORY_TWO not between", value1, value2, "categoryTwo");
            return (Criteria) this;
        }

        public Criteria andStyleIsNull() {
            addCriterion("STYLE is null");
            return (Criteria) this;
        }

        public Criteria andStyleIsNotNull() {
            addCriterion("STYLE is not null");
            return (Criteria) this;
        }

        public Criteria andStyleEqualTo(String value) {
            addCriterion("STYLE =", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotEqualTo(String value) {
            addCriterion("STYLE <>", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThan(String value) {
            addCriterion("STYLE >", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThanOrEqualTo(String value) {
            addCriterion("STYLE >=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThan(String value) {
            addCriterion("STYLE <", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThanOrEqualTo(String value) {
            addCriterion("STYLE <=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLike(String value) {
            addCriterion("STYLE like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotLike(String value) {
            addCriterion("STYLE not like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleIn(List<String> values) {
            addCriterion("STYLE in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotIn(List<String> values) {
            addCriterion("STYLE not in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleBetween(String value1, String value2) {
            addCriterion("STYLE between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotBetween(String value1, String value2) {
            addCriterion("STYLE not between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andProdetPicIsNull() {
            addCriterion("PRODET_PIC is null");
            return (Criteria) this;
        }

        public Criteria andProdetPicIsNotNull() {
            addCriterion("PRODET_PIC is not null");
            return (Criteria) this;
        }

        public Criteria andProdetPicEqualTo(String value) {
            addCriterion("PRODET_PIC =", value, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicNotEqualTo(String value) {
            addCriterion("PRODET_PIC <>", value, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicGreaterThan(String value) {
            addCriterion("PRODET_PIC >", value, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicGreaterThanOrEqualTo(String value) {
            addCriterion("PRODET_PIC >=", value, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicLessThan(String value) {
            addCriterion("PRODET_PIC <", value, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicLessThanOrEqualTo(String value) {
            addCriterion("PRODET_PIC <=", value, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicLike(String value) {
            addCriterion("PRODET_PIC like", value, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicNotLike(String value) {
            addCriterion("PRODET_PIC not like", value, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicIn(List<String> values) {
            addCriterion("PRODET_PIC in", values, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicNotIn(List<String> values) {
            addCriterion("PRODET_PIC not in", values, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicBetween(String value1, String value2) {
            addCriterion("PRODET_PIC between", value1, value2, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andProdetPicNotBetween(String value1, String value2) {
            addCriterion("PRODET_PIC not between", value1, value2, "prodetPic");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("INTRODUCTION is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("INTRODUCTION is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("INTRODUCTION =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("INTRODUCTION <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("INTRODUCTION >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("INTRODUCTION >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("INTRODUCTION <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("INTRODUCTION <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("INTRODUCTION like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("INTRODUCTION not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("INTRODUCTION in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("INTRODUCTION not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("INTRODUCTION between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("INTRODUCTION not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andSpecIdIsNull() {
            addCriterion("SPEC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSpecIdIsNotNull() {
            addCriterion("SPEC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSpecIdEqualTo(String value) {
            addCriterion("SPEC_ID =", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotEqualTo(String value) {
            addCriterion("SPEC_ID <>", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdGreaterThan(String value) {
            addCriterion("SPEC_ID >", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdGreaterThanOrEqualTo(String value) {
            addCriterion("SPEC_ID >=", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdLessThan(String value) {
            addCriterion("SPEC_ID <", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdLessThanOrEqualTo(String value) {
            addCriterion("SPEC_ID <=", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdLike(String value) {
            addCriterion("SPEC_ID like", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotLike(String value) {
            addCriterion("SPEC_ID not like", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdIn(List<String> values) {
            addCriterion("SPEC_ID in", values, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotIn(List<String> values) {
            addCriterion("SPEC_ID not in", values, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdBetween(String value1, String value2) {
            addCriterion("SPEC_ID between", value1, value2, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotBetween(String value1, String value2) {
            addCriterion("SPEC_ID not between", value1, value2, "specId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}