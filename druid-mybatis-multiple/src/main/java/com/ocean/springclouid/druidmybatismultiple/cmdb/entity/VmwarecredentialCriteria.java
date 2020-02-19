package com.ocean.springclouid.druidmybatismultiple.cmdb.entity;

import java.util.ArrayList;
import java.util.List;

public class VmwarecredentialCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VmwarecredentialCriteria() {
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

        public Criteria andCycleIsNull() {
            addCriterion("cycle is null");
            return (Criteria) this;
        }

        public Criteria andCycleIsNotNull() {
            addCriterion("cycle is not null");
            return (Criteria) this;
        }

        public Criteria andCycleEqualTo(Integer value) {
            addCriterion("cycle =", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotEqualTo(Integer value) {
            addCriterion("cycle <>", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThan(Integer value) {
            addCriterion("cycle >", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleGreaterThanOrEqualTo(Integer value) {
            addCriterion("cycle >=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThan(Integer value) {
            addCriterion("cycle <", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleLessThanOrEqualTo(Integer value) {
            addCriterion("cycle <=", value, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleIn(List<Integer> values) {
            addCriterion("cycle in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotIn(List<Integer> values) {
            addCriterion("cycle not in", values, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleBetween(Integer value1, Integer value2) {
            addCriterion("cycle between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andCycleNotBetween(Integer value1, Integer value2) {
            addCriterion("cycle not between", value1, value2, "cycle");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andSysntimeIsNull() {
            addCriterion("sysntime is null");
            return (Criteria) this;
        }

        public Criteria andSysntimeIsNotNull() {
            addCriterion("sysntime is not null");
            return (Criteria) this;
        }

        public Criteria andSysntimeEqualTo(Long value) {
            addCriterion("sysntime =", value, "sysntime");
            return (Criteria) this;
        }

        public Criteria andSysntimeNotEqualTo(Long value) {
            addCriterion("sysntime <>", value, "sysntime");
            return (Criteria) this;
        }

        public Criteria andSysntimeGreaterThan(Long value) {
            addCriterion("sysntime >", value, "sysntime");
            return (Criteria) this;
        }

        public Criteria andSysntimeGreaterThanOrEqualTo(Long value) {
            addCriterion("sysntime >=", value, "sysntime");
            return (Criteria) this;
        }

        public Criteria andSysntimeLessThan(Long value) {
            addCriterion("sysntime <", value, "sysntime");
            return (Criteria) this;
        }

        public Criteria andSysntimeLessThanOrEqualTo(Long value) {
            addCriterion("sysntime <=", value, "sysntime");
            return (Criteria) this;
        }

        public Criteria andSysntimeIn(List<Long> values) {
            addCriterion("sysntime in", values, "sysntime");
            return (Criteria) this;
        }

        public Criteria andSysntimeNotIn(List<Long> values) {
            addCriterion("sysntime not in", values, "sysntime");
            return (Criteria) this;
        }

        public Criteria andSysntimeBetween(Long value1, Long value2) {
            addCriterion("sysntime between", value1, value2, "sysntime");
            return (Criteria) this;
        }

        public Criteria andSysntimeNotBetween(Long value1, Long value2) {
            addCriterion("sysntime not between", value1, value2, "sysntime");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andAcountstateIsNull() {
            addCriterion("acountstate is null");
            return (Criteria) this;
        }

        public Criteria andAcountstateIsNotNull() {
            addCriterion("acountstate is not null");
            return (Criteria) this;
        }

        public Criteria andAcountstateEqualTo(String value) {
            addCriterion("acountstate =", value, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateNotEqualTo(String value) {
            addCriterion("acountstate <>", value, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateGreaterThan(String value) {
            addCriterion("acountstate >", value, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateGreaterThanOrEqualTo(String value) {
            addCriterion("acountstate >=", value, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateLessThan(String value) {
            addCriterion("acountstate <", value, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateLessThanOrEqualTo(String value) {
            addCriterion("acountstate <=", value, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateLike(String value) {
            addCriterion("acountstate like", value, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateNotLike(String value) {
            addCriterion("acountstate not like", value, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateIn(List<String> values) {
            addCriterion("acountstate in", values, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateNotIn(List<String> values) {
            addCriterion("acountstate not in", values, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateBetween(String value1, String value2) {
            addCriterion("acountstate between", value1, value2, "acountstate");
            return (Criteria) this;
        }

        public Criteria andAcountstateNotBetween(String value1, String value2) {
            addCriterion("acountstate not between", value1, value2, "acountstate");
            return (Criteria) this;
        }

        public Criteria andSyncTypeIsNull() {
            addCriterion("sync_type is null");
            return (Criteria) this;
        }

        public Criteria andSyncTypeIsNotNull() {
            addCriterion("sync_type is not null");
            return (Criteria) this;
        }

        public Criteria andSyncTypeEqualTo(String value) {
            addCriterion("sync_type =", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotEqualTo(String value) {
            addCriterion("sync_type <>", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeGreaterThan(String value) {
            addCriterion("sync_type >", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sync_type >=", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeLessThan(String value) {
            addCriterion("sync_type <", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeLessThanOrEqualTo(String value) {
            addCriterion("sync_type <=", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeLike(String value) {
            addCriterion("sync_type like", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotLike(String value) {
            addCriterion("sync_type not like", value, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeIn(List<String> values) {
            addCriterion("sync_type in", values, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotIn(List<String> values) {
            addCriterion("sync_type not in", values, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeBetween(String value1, String value2) {
            addCriterion("sync_type between", value1, value2, "syncType");
            return (Criteria) this;
        }

        public Criteria andSyncTypeNotBetween(String value1, String value2) {
            addCriterion("sync_type not between", value1, value2, "syncType");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Boolean value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Boolean value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Boolean value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Boolean value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Boolean> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Boolean> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andSaveMonthIsNull() {
            addCriterion("save_month is null");
            return (Criteria) this;
        }

        public Criteria andSaveMonthIsNotNull() {
            addCriterion("save_month is not null");
            return (Criteria) this;
        }

        public Criteria andSaveMonthEqualTo(Integer value) {
            addCriterion("save_month =", value, "saveMonth");
            return (Criteria) this;
        }

        public Criteria andSaveMonthNotEqualTo(Integer value) {
            addCriterion("save_month <>", value, "saveMonth");
            return (Criteria) this;
        }

        public Criteria andSaveMonthGreaterThan(Integer value) {
            addCriterion("save_month >", value, "saveMonth");
            return (Criteria) this;
        }

        public Criteria andSaveMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("save_month >=", value, "saveMonth");
            return (Criteria) this;
        }

        public Criteria andSaveMonthLessThan(Integer value) {
            addCriterion("save_month <", value, "saveMonth");
            return (Criteria) this;
        }

        public Criteria andSaveMonthLessThanOrEqualTo(Integer value) {
            addCriterion("save_month <=", value, "saveMonth");
            return (Criteria) this;
        }

        public Criteria andSaveMonthIn(List<Integer> values) {
            addCriterion("save_month in", values, "saveMonth");
            return (Criteria) this;
        }

        public Criteria andSaveMonthNotIn(List<Integer> values) {
            addCriterion("save_month not in", values, "saveMonth");
            return (Criteria) this;
        }

        public Criteria andSaveMonthBetween(Integer value1, Integer value2) {
            addCriterion("save_month between", value1, value2, "saveMonth");
            return (Criteria) this;
        }

        public Criteria andSaveMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("save_month not between", value1, value2, "saveMonth");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Integer value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Integer value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Integer value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Integer value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Integer value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Integer> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Integer> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Integer value1, Integer value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Integer value1, Integer value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andNumEsxiIsNull() {
            addCriterion("num_esxi is null");
            return (Criteria) this;
        }

        public Criteria andNumEsxiIsNotNull() {
            addCriterion("num_esxi is not null");
            return (Criteria) this;
        }

        public Criteria andNumEsxiEqualTo(Integer value) {
            addCriterion("num_esxi =", value, "numEsxi");
            return (Criteria) this;
        }

        public Criteria andNumEsxiNotEqualTo(Integer value) {
            addCriterion("num_esxi <>", value, "numEsxi");
            return (Criteria) this;
        }

        public Criteria andNumEsxiGreaterThan(Integer value) {
            addCriterion("num_esxi >", value, "numEsxi");
            return (Criteria) this;
        }

        public Criteria andNumEsxiGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_esxi >=", value, "numEsxi");
            return (Criteria) this;
        }

        public Criteria andNumEsxiLessThan(Integer value) {
            addCriterion("num_esxi <", value, "numEsxi");
            return (Criteria) this;
        }

        public Criteria andNumEsxiLessThanOrEqualTo(Integer value) {
            addCriterion("num_esxi <=", value, "numEsxi");
            return (Criteria) this;
        }

        public Criteria andNumEsxiIn(List<Integer> values) {
            addCriterion("num_esxi in", values, "numEsxi");
            return (Criteria) this;
        }

        public Criteria andNumEsxiNotIn(List<Integer> values) {
            addCriterion("num_esxi not in", values, "numEsxi");
            return (Criteria) this;
        }

        public Criteria andNumEsxiBetween(Integer value1, Integer value2) {
            addCriterion("num_esxi between", value1, value2, "numEsxi");
            return (Criteria) this;
        }

        public Criteria andNumEsxiNotBetween(Integer value1, Integer value2) {
            addCriterion("num_esxi not between", value1, value2, "numEsxi");
            return (Criteria) this;
        }

        public Criteria andNumVmwareIsNull() {
            addCriterion("num_vmware is null");
            return (Criteria) this;
        }

        public Criteria andNumVmwareIsNotNull() {
            addCriterion("num_vmware is not null");
            return (Criteria) this;
        }

        public Criteria andNumVmwareEqualTo(Integer value) {
            addCriterion("num_vmware =", value, "numVmware");
            return (Criteria) this;
        }

        public Criteria andNumVmwareNotEqualTo(Integer value) {
            addCriterion("num_vmware <>", value, "numVmware");
            return (Criteria) this;
        }

        public Criteria andNumVmwareGreaterThan(Integer value) {
            addCriterion("num_vmware >", value, "numVmware");
            return (Criteria) this;
        }

        public Criteria andNumVmwareGreaterThanOrEqualTo(Integer value) {
            addCriterion("num_vmware >=", value, "numVmware");
            return (Criteria) this;
        }

        public Criteria andNumVmwareLessThan(Integer value) {
            addCriterion("num_vmware <", value, "numVmware");
            return (Criteria) this;
        }

        public Criteria andNumVmwareLessThanOrEqualTo(Integer value) {
            addCriterion("num_vmware <=", value, "numVmware");
            return (Criteria) this;
        }

        public Criteria andNumVmwareIn(List<Integer> values) {
            addCriterion("num_vmware in", values, "numVmware");
            return (Criteria) this;
        }

        public Criteria andNumVmwareNotIn(List<Integer> values) {
            addCriterion("num_vmware not in", values, "numVmware");
            return (Criteria) this;
        }

        public Criteria andNumVmwareBetween(Integer value1, Integer value2) {
            addCriterion("num_vmware between", value1, value2, "numVmware");
            return (Criteria) this;
        }

        public Criteria andNumVmwareNotBetween(Integer value1, Integer value2) {
            addCriterion("num_vmware not between", value1, value2, "numVmware");
            return (Criteria) this;
        }

        public Criteria andVCenteripIsNull() {
            addCriterion("v_centerip is null");
            return (Criteria) this;
        }

        public Criteria andVCenteripIsNotNull() {
            addCriterion("v_centerip is not null");
            return (Criteria) this;
        }

        public Criteria andVCenteripEqualTo(String value) {
            addCriterion("v_centerip =", value, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripNotEqualTo(String value) {
            addCriterion("v_centerip <>", value, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripGreaterThan(String value) {
            addCriterion("v_centerip >", value, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripGreaterThanOrEqualTo(String value) {
            addCriterion("v_centerip >=", value, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripLessThan(String value) {
            addCriterion("v_centerip <", value, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripLessThanOrEqualTo(String value) {
            addCriterion("v_centerip <=", value, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripLike(String value) {
            addCriterion("v_centerip like", value, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripNotLike(String value) {
            addCriterion("v_centerip not like", value, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripIn(List<String> values) {
            addCriterion("v_centerip in", values, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripNotIn(List<String> values) {
            addCriterion("v_centerip not in", values, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripBetween(String value1, String value2) {
            addCriterion("v_centerip between", value1, value2, "vCenterip");
            return (Criteria) this;
        }

        public Criteria andVCenteripNotBetween(String value1, String value2) {
            addCriterion("v_centerip not between", value1, value2, "vCenterip");
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