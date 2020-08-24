package cn.edu.ncu.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SmallImgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmallImgExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andProdetIsNull() {
            addCriterion("PRODET is null");
            return (Criteria) this;
        }

        public Criteria andProdetIsNotNull() {
            addCriterion("PRODET is not null");
            return (Criteria) this;
        }

        public Criteria andProdetEqualTo(String value) {
            addCriterion("PRODET =", value, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetNotEqualTo(String value) {
            addCriterion("PRODET <>", value, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetGreaterThan(String value) {
            addCriterion("PRODET >", value, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetGreaterThanOrEqualTo(String value) {
            addCriterion("PRODET >=", value, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetLessThan(String value) {
            addCriterion("PRODET <", value, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetLessThanOrEqualTo(String value) {
            addCriterion("PRODET <=", value, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetLike(String value) {
            addCriterion("PRODET like", value, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetNotLike(String value) {
            addCriterion("PRODET not like", value, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetIn(List<String> values) {
            addCriterion("PRODET in", values, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetNotIn(List<String> values) {
            addCriterion("PRODET not in", values, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetBetween(String value1, String value2) {
            addCriterion("PRODET between", value1, value2, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetNotBetween(String value1, String value2) {
            addCriterion("PRODET not between", value1, value2, "prodet");
            return (Criteria) this;
        }

        public Criteria andProdetBigIsNull() {
            addCriterion("PRODET_BIG is null");
            return (Criteria) this;
        }

        public Criteria andProdetBigIsNotNull() {
            addCriterion("PRODET_BIG is not null");
            return (Criteria) this;
        }

        public Criteria andProdetBigEqualTo(String value) {
            addCriterion("PRODET_BIG =", value, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigNotEqualTo(String value) {
            addCriterion("PRODET_BIG <>", value, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigGreaterThan(String value) {
            addCriterion("PRODET_BIG >", value, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigGreaterThanOrEqualTo(String value) {
            addCriterion("PRODET_BIG >=", value, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigLessThan(String value) {
            addCriterion("PRODET_BIG <", value, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigLessThanOrEqualTo(String value) {
            addCriterion("PRODET_BIG <=", value, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigLike(String value) {
            addCriterion("PRODET_BIG like", value, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigNotLike(String value) {
            addCriterion("PRODET_BIG not like", value, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigIn(List<String> values) {
            addCriterion("PRODET_BIG in", values, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigNotIn(List<String> values) {
            addCriterion("PRODET_BIG not in", values, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigBetween(String value1, String value2) {
            addCriterion("PRODET_BIG between", value1, value2, "prodetBig");
            return (Criteria) this;
        }

        public Criteria andProdetBigNotBetween(String value1, String value2) {
            addCriterion("PRODET_BIG not between", value1, value2, "prodetBig");
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