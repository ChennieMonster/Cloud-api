package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PodDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PodDTOExample() {
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andSet_idIsNull() {
            addCriterion("set_id is null");
            return (Criteria) this;
        }

        public Criteria andSet_idIsNotNull() {
            addCriterion("set_id is not null");
            return (Criteria) this;
        }

        public Criteria andSet_idEqualTo(String value) {
            addCriterion("set_id =", value, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idNotEqualTo(String value) {
            addCriterion("set_id <>", value, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idGreaterThan(String value) {
            addCriterion("set_id >", value, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idGreaterThanOrEqualTo(String value) {
            addCriterion("set_id >=", value, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idLessThan(String value) {
            addCriterion("set_id <", value, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idLessThanOrEqualTo(String value) {
            addCriterion("set_id <=", value, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idLike(String value) {
            addCriterion("set_id like", value, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idNotLike(String value) {
            addCriterion("set_id not like", value, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idIn(List<String> values) {
            addCriterion("set_id in", values, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idNotIn(List<String> values) {
            addCriterion("set_id not in", values, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idBetween(String value1, String value2) {
            addCriterion("set_id between", value1, value2, "set_id");
            return (Criteria) this;
        }

        public Criteria andSet_idNotBetween(String value1, String value2) {
            addCriterion("set_id not between", value1, value2, "set_id");
            return (Criteria) this;
        }

        public Criteria andMeta_dataIsNull() {
            addCriterion("meta_data is null");
            return (Criteria) this;
        }

        public Criteria andMeta_dataIsNotNull() {
            addCriterion("meta_data is not null");
            return (Criteria) this;
        }

        public Criteria andMeta_dataEqualTo(String value) {
            addCriterion("meta_data =", value, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataNotEqualTo(String value) {
            addCriterion("meta_data <>", value, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataGreaterThan(String value) {
            addCriterion("meta_data >", value, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataGreaterThanOrEqualTo(String value) {
            addCriterion("meta_data >=", value, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataLessThan(String value) {
            addCriterion("meta_data <", value, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataLessThanOrEqualTo(String value) {
            addCriterion("meta_data <=", value, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataLike(String value) {
            addCriterion("meta_data like", value, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataNotLike(String value) {
            addCriterion("meta_data not like", value, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataIn(List<String> values) {
            addCriterion("meta_data in", values, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataNotIn(List<String> values) {
            addCriterion("meta_data not in", values, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataBetween(String value1, String value2) {
            addCriterion("meta_data between", value1, value2, "meta_data");
            return (Criteria) this;
        }

        public Criteria andMeta_dataNotBetween(String value1, String value2) {
            addCriterion("meta_data not between", value1, value2, "meta_data");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("spec is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("spec =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("spec <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("spec >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("spec >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("spec <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("spec <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLike(String value) {
            addCriterion("spec like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("spec not like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<String> values) {
            addCriterion("spec in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<String> values) {
            addCriterion("spec not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("spec between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("spec not between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andDns_policyIsNull() {
            addCriterion("dns_policy is null");
            return (Criteria) this;
        }

        public Criteria andDns_policyIsNotNull() {
            addCriterion("dns_policy is not null");
            return (Criteria) this;
        }

        public Criteria andDns_policyEqualTo(String value) {
            addCriterion("dns_policy =", value, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyNotEqualTo(String value) {
            addCriterion("dns_policy <>", value, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyGreaterThan(String value) {
            addCriterion("dns_policy >", value, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyGreaterThanOrEqualTo(String value) {
            addCriterion("dns_policy >=", value, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyLessThan(String value) {
            addCriterion("dns_policy <", value, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyLessThanOrEqualTo(String value) {
            addCriterion("dns_policy <=", value, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyLike(String value) {
            addCriterion("dns_policy like", value, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyNotLike(String value) {
            addCriterion("dns_policy not like", value, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyIn(List<String> values) {
            addCriterion("dns_policy in", values, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyNotIn(List<String> values) {
            addCriterion("dns_policy not in", values, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyBetween(String value1, String value2) {
            addCriterion("dns_policy between", value1, value2, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andDns_policyNotBetween(String value1, String value2) {
            addCriterion("dns_policy not between", value1, value2, "dns_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyIsNull() {
            addCriterion("restart_policy is null");
            return (Criteria) this;
        }

        public Criteria andRestart_policyIsNotNull() {
            addCriterion("restart_policy is not null");
            return (Criteria) this;
        }

        public Criteria andRestart_policyEqualTo(String value) {
            addCriterion("restart_policy =", value, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyNotEqualTo(String value) {
            addCriterion("restart_policy <>", value, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyGreaterThan(String value) {
            addCriterion("restart_policy >", value, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyGreaterThanOrEqualTo(String value) {
            addCriterion("restart_policy >=", value, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyLessThan(String value) {
            addCriterion("restart_policy <", value, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyLessThanOrEqualTo(String value) {
            addCriterion("restart_policy <=", value, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyLike(String value) {
            addCriterion("restart_policy like", value, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyNotLike(String value) {
            addCriterion("restart_policy not like", value, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyIn(List<String> values) {
            addCriterion("restart_policy in", values, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyNotIn(List<String> values) {
            addCriterion("restart_policy not in", values, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyBetween(String value1, String value2) {
            addCriterion("restart_policy between", value1, value2, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andRestart_policyNotBetween(String value1, String value2) {
            addCriterion("restart_policy not between", value1, value2, "restart_policy");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameIsNull() {
            addCriterion("scheduler_name is null");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameIsNotNull() {
            addCriterion("scheduler_name is not null");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameEqualTo(String value) {
            addCriterion("scheduler_name =", value, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameNotEqualTo(String value) {
            addCriterion("scheduler_name <>", value, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameGreaterThan(String value) {
            addCriterion("scheduler_name >", value, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameGreaterThanOrEqualTo(String value) {
            addCriterion("scheduler_name >=", value, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameLessThan(String value) {
            addCriterion("scheduler_name <", value, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameLessThanOrEqualTo(String value) {
            addCriterion("scheduler_name <=", value, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameLike(String value) {
            addCriterion("scheduler_name like", value, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameNotLike(String value) {
            addCriterion("scheduler_name not like", value, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameIn(List<String> values) {
            addCriterion("scheduler_name in", values, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameNotIn(List<String> values) {
            addCriterion("scheduler_name not in", values, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameBetween(String value1, String value2) {
            addCriterion("scheduler_name between", value1, value2, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andScheduler_nameNotBetween(String value1, String value2) {
            addCriterion("scheduler_name not between", value1, value2, "scheduler_name");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextIsNull() {
            addCriterion("security_context is null");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextIsNotNull() {
            addCriterion("security_context is not null");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextEqualTo(String value) {
            addCriterion("security_context =", value, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextNotEqualTo(String value) {
            addCriterion("security_context <>", value, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextGreaterThan(String value) {
            addCriterion("security_context >", value, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextGreaterThanOrEqualTo(String value) {
            addCriterion("security_context >=", value, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextLessThan(String value) {
            addCriterion("security_context <", value, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextLessThanOrEqualTo(String value) {
            addCriterion("security_context <=", value, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextLike(String value) {
            addCriterion("security_context like", value, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextNotLike(String value) {
            addCriterion("security_context not like", value, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextIn(List<String> values) {
            addCriterion("security_context in", values, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextNotIn(List<String> values) {
            addCriterion("security_context not in", values, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextBetween(String value1, String value2) {
            addCriterion("security_context between", value1, value2, "security_context");
            return (Criteria) this;
        }

        public Criteria andSecurity_contextNotBetween(String value1, String value2) {
            addCriterion("security_context not between", value1, value2, "security_context");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsIsNull() {
            addCriterion("termination_grace_period_seconds is null");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsIsNotNull() {
            addCriterion("termination_grace_period_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsEqualTo(Integer value) {
            addCriterion("termination_grace_period_seconds =", value, "termination_grace_period_seconds");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsNotEqualTo(Integer value) {
            addCriterion("termination_grace_period_seconds <>", value, "termination_grace_period_seconds");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsGreaterThan(Integer value) {
            addCriterion("termination_grace_period_seconds >", value, "termination_grace_period_seconds");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsGreaterThanOrEqualTo(Integer value) {
            addCriterion("termination_grace_period_seconds >=", value, "termination_grace_period_seconds");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsLessThan(Integer value) {
            addCriterion("termination_grace_period_seconds <", value, "termination_grace_period_seconds");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsLessThanOrEqualTo(Integer value) {
            addCriterion("termination_grace_period_seconds <=", value, "termination_grace_period_seconds");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsIn(List<Integer> values) {
            addCriterion("termination_grace_period_seconds in", values, "termination_grace_period_seconds");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsNotIn(List<Integer> values) {
            addCriterion("termination_grace_period_seconds not in", values, "termination_grace_period_seconds");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsBetween(Integer value1, Integer value2) {
            addCriterion("termination_grace_period_seconds between", value1, value2, "termination_grace_period_seconds");
            return (Criteria) this;
        }

        public Criteria andTermination_grace_period_secondsNotBetween(Integer value1, Integer value2) {
            addCriterion("termination_grace_period_seconds not between", value1, value2, "termination_grace_period_seconds");
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

        public Criteria andReadyIsNull() {
            addCriterion("ready is null");
            return (Criteria) this;
        }

        public Criteria andReadyIsNotNull() {
            addCriterion("ready is not null");
            return (Criteria) this;
        }

        public Criteria andReadyEqualTo(String value) {
            addCriterion("ready =", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyNotEqualTo(String value) {
            addCriterion("ready <>", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyGreaterThan(String value) {
            addCriterion("ready >", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyGreaterThanOrEqualTo(String value) {
            addCriterion("ready >=", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyLessThan(String value) {
            addCriterion("ready <", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyLessThanOrEqualTo(String value) {
            addCriterion("ready <=", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyLike(String value) {
            addCriterion("ready like", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyNotLike(String value) {
            addCriterion("ready not like", value, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyIn(List<String> values) {
            addCriterion("ready in", values, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyNotIn(List<String> values) {
            addCriterion("ready not in", values, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyBetween(String value1, String value2) {
            addCriterion("ready between", value1, value2, "ready");
            return (Criteria) this;
        }

        public Criteria andReadyNotBetween(String value1, String value2) {
            addCriterion("ready not between", value1, value2, "ready");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRestartsIsNull() {
            addCriterion("restarts is null");
            return (Criteria) this;
        }

        public Criteria andRestartsIsNotNull() {
            addCriterion("restarts is not null");
            return (Criteria) this;
        }

        public Criteria andRestartsEqualTo(String value) {
            addCriterion("restarts =", value, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsNotEqualTo(String value) {
            addCriterion("restarts <>", value, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsGreaterThan(String value) {
            addCriterion("restarts >", value, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsGreaterThanOrEqualTo(String value) {
            addCriterion("restarts >=", value, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsLessThan(String value) {
            addCriterion("restarts <", value, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsLessThanOrEqualTo(String value) {
            addCriterion("restarts <=", value, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsLike(String value) {
            addCriterion("restarts like", value, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsNotLike(String value) {
            addCriterion("restarts not like", value, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsIn(List<String> values) {
            addCriterion("restarts in", values, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsNotIn(List<String> values) {
            addCriterion("restarts not in", values, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsBetween(String value1, String value2) {
            addCriterion("restarts between", value1, value2, "restarts");
            return (Criteria) this;
        }

        public Criteria andRestartsNotBetween(String value1, String value2) {
            addCriterion("restarts not between", value1, value2, "restarts");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("age like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("age not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andRsIsNull() {
            addCriterion("rs is null");
            return (Criteria) this;
        }

        public Criteria andRsIsNotNull() {
            addCriterion("rs is not null");
            return (Criteria) this;
        }

        public Criteria andRsEqualTo(String value) {
            addCriterion("rs =", value, "rs");
            return (Criteria) this;
        }

        public Criteria andRsNotEqualTo(String value) {
            addCriterion("rs <>", value, "rs");
            return (Criteria) this;
        }

        public Criteria andRsGreaterThan(String value) {
            addCriterion("rs >", value, "rs");
            return (Criteria) this;
        }

        public Criteria andRsGreaterThanOrEqualTo(String value) {
            addCriterion("rs >=", value, "rs");
            return (Criteria) this;
        }

        public Criteria andRsLessThan(String value) {
            addCriterion("rs <", value, "rs");
            return (Criteria) this;
        }

        public Criteria andRsLessThanOrEqualTo(String value) {
            addCriterion("rs <=", value, "rs");
            return (Criteria) this;
        }

        public Criteria andRsLike(String value) {
            addCriterion("rs like", value, "rs");
            return (Criteria) this;
        }

        public Criteria andRsNotLike(String value) {
            addCriterion("rs not like", value, "rs");
            return (Criteria) this;
        }

        public Criteria andRsIn(List<String> values) {
            addCriterion("rs in", values, "rs");
            return (Criteria) this;
        }

        public Criteria andRsNotIn(List<String> values) {
            addCriterion("rs not in", values, "rs");
            return (Criteria) this;
        }

        public Criteria andRsBetween(String value1, String value2) {
            addCriterion("rs between", value1, value2, "rs");
            return (Criteria) this;
        }

        public Criteria andRsNotBetween(String value1, String value2) {
            addCriterion("rs not between", value1, value2, "rs");
            return (Criteria) this;
        }

        public Criteria andCreated_timeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreated_timeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreated_timeEqualTo(Date value) {
            addCriterion("created_time =", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeGreaterThan(Date value) {
            addCriterion("created_time >", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeLessThan(Date value) {
            addCriterion("created_time <", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeIn(List<Date> values) {
            addCriterion("created_time in", values, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "created_time");
            return (Criteria) this;
        }

        public Criteria andCreated_timeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "created_time");
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