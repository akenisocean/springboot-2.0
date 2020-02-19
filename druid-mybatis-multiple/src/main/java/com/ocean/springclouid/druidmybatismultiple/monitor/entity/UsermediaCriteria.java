package com.ocean.springclouid.druidmybatismultiple.monitor.entity;

import java.util.ArrayList;
import java.util.List;

public class UsermediaCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UsermediaCriteria() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMediatypeidIsNull() {
            addCriterion("mediatypeid is null");
            return (Criteria) this;
        }

        public Criteria andMediatypeidIsNotNull() {
            addCriterion("mediatypeid is not null");
            return (Criteria) this;
        }

        public Criteria andMediatypeidEqualTo(Integer value) {
            addCriterion("mediatypeid =", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidNotEqualTo(Integer value) {
            addCriterion("mediatypeid <>", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidGreaterThan(Integer value) {
            addCriterion("mediatypeid >", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mediatypeid >=", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidLessThan(Integer value) {
            addCriterion("mediatypeid <", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidLessThanOrEqualTo(Integer value) {
            addCriterion("mediatypeid <=", value, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidIn(List<Integer> values) {
            addCriterion("mediatypeid in", values, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidNotIn(List<Integer> values) {
            addCriterion("mediatypeid not in", values, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidBetween(Integer value1, Integer value2) {
            addCriterion("mediatypeid between", value1, value2, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andMediatypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("mediatypeid not between", value1, value2, "mediatypeid");
            return (Criteria) this;
        }

        public Criteria andSendtoIsNull() {
            addCriterion("sendto is null");
            return (Criteria) this;
        }

        public Criteria andSendtoIsNotNull() {
            addCriterion("sendto is not null");
            return (Criteria) this;
        }

        public Criteria andSendtoEqualTo(String value) {
            addCriterion("sendto =", value, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoNotEqualTo(String value) {
            addCriterion("sendto <>", value, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoGreaterThan(String value) {
            addCriterion("sendto >", value, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoGreaterThanOrEqualTo(String value) {
            addCriterion("sendto >=", value, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoLessThan(String value) {
            addCriterion("sendto <", value, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoLessThanOrEqualTo(String value) {
            addCriterion("sendto <=", value, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoLike(String value) {
            addCriterion("sendto like", value, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoNotLike(String value) {
            addCriterion("sendto not like", value, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoIn(List<String> values) {
            addCriterion("sendto in", values, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoNotIn(List<String> values) {
            addCriterion("sendto not in", values, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoBetween(String value1, String value2) {
            addCriterion("sendto between", value1, value2, "sendto");
            return (Criteria) this;
        }

        public Criteria andSendtoNotBetween(String value1, String value2) {
            addCriterion("sendto not between", value1, value2, "sendto");
            return (Criteria) this;
        }

        public Criteria andActiveIsNull() {
            addCriterion("active is null");
            return (Criteria) this;
        }

        public Criteria andActiveIsNotNull() {
            addCriterion("active is not null");
            return (Criteria) this;
        }

        public Criteria andActiveEqualTo(String value) {
            addCriterion("active =", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotEqualTo(String value) {
            addCriterion("active <>", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThan(String value) {
            addCriterion("active >", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveGreaterThanOrEqualTo(String value) {
            addCriterion("active >=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThan(String value) {
            addCriterion("active <", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLessThanOrEqualTo(String value) {
            addCriterion("active <=", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveLike(String value) {
            addCriterion("active like", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotLike(String value) {
            addCriterion("active not like", value, "active");
            return (Criteria) this;
        }

        public Criteria andActiveIn(List<String> values) {
            addCriterion("active in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotIn(List<String> values) {
            addCriterion("active not in", values, "active");
            return (Criteria) this;
        }

        public Criteria andActiveBetween(String value1, String value2) {
            addCriterion("active between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andActiveNotBetween(String value1, String value2) {
            addCriterion("active not between", value1, value2, "active");
            return (Criteria) this;
        }

        public Criteria andSeverityIsNull() {
            addCriterion("severity is null");
            return (Criteria) this;
        }

        public Criteria andSeverityIsNotNull() {
            addCriterion("severity is not null");
            return (Criteria) this;
        }

        public Criteria andSeverityEqualTo(String value) {
            addCriterion("severity =", value, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityNotEqualTo(String value) {
            addCriterion("severity <>", value, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityGreaterThan(String value) {
            addCriterion("severity >", value, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityGreaterThanOrEqualTo(String value) {
            addCriterion("severity >=", value, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityLessThan(String value) {
            addCriterion("severity <", value, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityLessThanOrEqualTo(String value) {
            addCriterion("severity <=", value, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityLike(String value) {
            addCriterion("severity like", value, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityNotLike(String value) {
            addCriterion("severity not like", value, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityIn(List<String> values) {
            addCriterion("severity in", values, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityNotIn(List<String> values) {
            addCriterion("severity not in", values, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityBetween(String value1, String value2) {
            addCriterion("severity between", value1, value2, "severity");
            return (Criteria) this;
        }

        public Criteria andSeverityNotBetween(String value1, String value2) {
            addCriterion("severity not between", value1, value2, "severity");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(String value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(String value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(String value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(String value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(String value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLike(String value) {
            addCriterion("period like", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotLike(String value) {
            addCriterion("period not like", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<String> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<String> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(String value1, String value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(String value1, String value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMediaidIsNull() {
            addCriterion("mediaid is null");
            return (Criteria) this;
        }

        public Criteria andMediaidIsNotNull() {
            addCriterion("mediaid is not null");
            return (Criteria) this;
        }

        public Criteria andMediaidEqualTo(Integer value) {
            addCriterion("mediaid =", value, "mediaid");
            return (Criteria) this;
        }

        public Criteria andMediaidNotEqualTo(Integer value) {
            addCriterion("mediaid <>", value, "mediaid");
            return (Criteria) this;
        }

        public Criteria andMediaidGreaterThan(Integer value) {
            addCriterion("mediaid >", value, "mediaid");
            return (Criteria) this;
        }

        public Criteria andMediaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mediaid >=", value, "mediaid");
            return (Criteria) this;
        }

        public Criteria andMediaidLessThan(Integer value) {
            addCriterion("mediaid <", value, "mediaid");
            return (Criteria) this;
        }

        public Criteria andMediaidLessThanOrEqualTo(Integer value) {
            addCriterion("mediaid <=", value, "mediaid");
            return (Criteria) this;
        }

        public Criteria andMediaidIn(List<Integer> values) {
            addCriterion("mediaid in", values, "mediaid");
            return (Criteria) this;
        }

        public Criteria andMediaidNotIn(List<Integer> values) {
            addCriterion("mediaid not in", values, "mediaid");
            return (Criteria) this;
        }

        public Criteria andMediaidBetween(Integer value1, Integer value2) {
            addCriterion("mediaid between", value1, value2, "mediaid");
            return (Criteria) this;
        }

        public Criteria andMediaidNotBetween(Integer value1, Integer value2) {
            addCriterion("mediaid not between", value1, value2, "mediaid");
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