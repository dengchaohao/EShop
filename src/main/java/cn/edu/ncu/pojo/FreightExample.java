package cn.edu.ncu.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FreightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FreightExample() {
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

        public Criteria andFreightIdIsNull() {
            addCriterion("FREIGHT_ID is null");
            return (Criteria) this;
        }

        public Criteria andFreightIdIsNotNull() {
            addCriterion("FREIGHT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFreightIdEqualTo(String value) {
            addCriterion("FREIGHT_ID =", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotEqualTo(String value) {
            addCriterion("FREIGHT_ID <>", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdGreaterThan(String value) {
            addCriterion("FREIGHT_ID >", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdGreaterThanOrEqualTo(String value) {
            addCriterion("FREIGHT_ID >=", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdLessThan(String value) {
            addCriterion("FREIGHT_ID <", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdLessThanOrEqualTo(String value) {
            addCriterion("FREIGHT_ID <=", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdLike(String value) {
            addCriterion("FREIGHT_ID like", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotLike(String value) {
            addCriterion("FREIGHT_ID not like", value, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdIn(List<String> values) {
            addCriterion("FREIGHT_ID in", values, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotIn(List<String> values) {
            addCriterion("FREIGHT_ID not in", values, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdBetween(String value1, String value2) {
            addCriterion("FREIGHT_ID between", value1, value2, "freightId");
            return (Criteria) this;
        }

        public Criteria andFreightIdNotBetween(String value1, String value2) {
            addCriterion("FREIGHT_ID not between", value1, value2, "freightId");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryIsNull() {
            addCriterion("EXPRESS_DELIVERY is null");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryIsNotNull() {
            addCriterion("EXPRESS_DELIVERY is not null");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryEqualTo(String value) {
            addCriterion("EXPRESS_DELIVERY =", value, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryNotEqualTo(String value) {
            addCriterion("EXPRESS_DELIVERY <>", value, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryGreaterThan(String value) {
            addCriterion("EXPRESS_DELIVERY >", value, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryGreaterThanOrEqualTo(String value) {
            addCriterion("EXPRESS_DELIVERY >=", value, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryLessThan(String value) {
            addCriterion("EXPRESS_DELIVERY <", value, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryLessThanOrEqualTo(String value) {
            addCriterion("EXPRESS_DELIVERY <=", value, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryLike(String value) {
            addCriterion("EXPRESS_DELIVERY like", value, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryNotLike(String value) {
            addCriterion("EXPRESS_DELIVERY not like", value, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryIn(List<String> values) {
            addCriterion("EXPRESS_DELIVERY in", values, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryNotIn(List<String> values) {
            addCriterion("EXPRESS_DELIVERY not in", values, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryBetween(String value1, String value2) {
            addCriterion("EXPRESS_DELIVERY between", value1, value2, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andExpressDeliveryNotBetween(String value1, String value2) {
            addCriterion("EXPRESS_DELIVERY not between", value1, value2, "expressDelivery");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeIsNull() {
            addCriterion("SEND_TIME_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeIsNotNull() {
            addCriterion("SEND_TIME_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeEqualTo(String value) {
            addCriterion("SEND_TIME_TYPE =", value, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeNotEqualTo(String value) {
            addCriterion("SEND_TIME_TYPE <>", value, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeGreaterThan(String value) {
            addCriterion("SEND_TIME_TYPE >", value, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_TIME_TYPE >=", value, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeLessThan(String value) {
            addCriterion("SEND_TIME_TYPE <", value, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeLessThanOrEqualTo(String value) {
            addCriterion("SEND_TIME_TYPE <=", value, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeLike(String value) {
            addCriterion("SEND_TIME_TYPE like", value, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeNotLike(String value) {
            addCriterion("SEND_TIME_TYPE not like", value, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeIn(List<String> values) {
            addCriterion("SEND_TIME_TYPE in", values, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeNotIn(List<String> values) {
            addCriterion("SEND_TIME_TYPE not in", values, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeBetween(String value1, String value2) {
            addCriterion("SEND_TIME_TYPE between", value1, value2, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andSendTimeTypeNotBetween(String value1, String value2) {
            addCriterion("SEND_TIME_TYPE not between", value1, value2, "sendTimeType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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