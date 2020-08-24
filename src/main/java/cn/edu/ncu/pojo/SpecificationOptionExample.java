package cn.edu.ncu.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SpecificationOptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecificationOptionExample() {
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

        public Criteria andSpecIdIsNull() {
            addCriterion("SPEC_ID is null");
            return (Criteria) this;
        }

        public Criteria andSpecIdIsNotNull() {
            addCriterion("SPEC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSpecIdEqualTo(BigDecimal value) {
            addCriterion("SPEC_ID =", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotEqualTo(BigDecimal value) {
            addCriterion("SPEC_ID <>", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdGreaterThan(BigDecimal value) {
            addCriterion("SPEC_ID >", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SPEC_ID >=", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdLessThan(BigDecimal value) {
            addCriterion("SPEC_ID <", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SPEC_ID <=", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdIn(List<BigDecimal> values) {
            addCriterion("SPEC_ID in", values, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotIn(List<BigDecimal> values) {
            addCriterion("SPEC_ID not in", values, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPEC_ID between", value1, value2, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SPEC_ID not between", value1, value2, "specId");
            return (Criteria) this;
        }

        public Criteria andSepcNameIsNull() {
            addCriterion("SEPC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSepcNameIsNotNull() {
            addCriterion("SEPC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSepcNameEqualTo(String value) {
            addCriterion("SEPC_NAME =", value, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameNotEqualTo(String value) {
            addCriterion("SEPC_NAME <>", value, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameGreaterThan(String value) {
            addCriterion("SEPC_NAME >", value, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameGreaterThanOrEqualTo(String value) {
            addCriterion("SEPC_NAME >=", value, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameLessThan(String value) {
            addCriterion("SEPC_NAME <", value, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameLessThanOrEqualTo(String value) {
            addCriterion("SEPC_NAME <=", value, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameLike(String value) {
            addCriterion("SEPC_NAME like", value, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameNotLike(String value) {
            addCriterion("SEPC_NAME not like", value, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameIn(List<String> values) {
            addCriterion("SEPC_NAME in", values, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameNotIn(List<String> values) {
            addCriterion("SEPC_NAME not in", values, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameBetween(String value1, String value2) {
            addCriterion("SEPC_NAME between", value1, value2, "sepcName");
            return (Criteria) this;
        }

        public Criteria andSepcNameNotBetween(String value1, String value2) {
            addCriterion("SEPC_NAME not between", value1, value2, "sepcName");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlIsNull() {
            addCriterion("prosmall_picture_url is null");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlIsNotNull() {
            addCriterion("prosmall_picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlEqualTo(String value) {
            addCriterion("prosmall_picture_url =", value, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlNotEqualTo(String value) {
            addCriterion("prosmall_picture_url <>", value, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlGreaterThan(String value) {
            addCriterion("prosmall_picture_url >", value, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("prosmall_picture_url >=", value, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlLessThan(String value) {
            addCriterion("prosmall_picture_url <", value, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("prosmall_picture_url <=", value, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlLike(String value) {
            addCriterion("prosmall_picture_url like", value, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlNotLike(String value) {
            addCriterion("prosmall_picture_url not like", value, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlIn(List<String> values) {
            addCriterion("prosmall_picture_url in", values, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlNotIn(List<String> values) {
            addCriterion("prosmall_picture_url not in", values, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlBetween(String value1, String value2) {
            addCriterion("prosmall_picture_url between", value1, value2, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProsmallPictureUrlNotBetween(String value1, String value2) {
            addCriterion("prosmall_picture_url not between", value1, value2, "prosmallPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlIsNull() {
            addCriterion("proBig_picture_url is null");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlIsNotNull() {
            addCriterion("proBig_picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlEqualTo(String value) {
            addCriterion("proBig_picture_url =", value, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlNotEqualTo(String value) {
            addCriterion("proBig_picture_url <>", value, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlGreaterThan(String value) {
            addCriterion("proBig_picture_url >", value, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("proBig_picture_url >=", value, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlLessThan(String value) {
            addCriterion("proBig_picture_url <", value, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("proBig_picture_url <=", value, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlLike(String value) {
            addCriterion("proBig_picture_url like", value, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlNotLike(String value) {
            addCriterion("proBig_picture_url not like", value, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlIn(List<String> values) {
            addCriterion("proBig_picture_url in", values, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlNotIn(List<String> values) {
            addCriterion("proBig_picture_url not in", values, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlBetween(String value1, String value2) {
            addCriterion("proBig_picture_url between", value1, value2, "probigPictureUrl");
            return (Criteria) this;
        }

        public Criteria andProbigPictureUrlNotBetween(String value1, String value2) {
            addCriterion("proBig_picture_url not between", value1, value2, "probigPictureUrl");
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