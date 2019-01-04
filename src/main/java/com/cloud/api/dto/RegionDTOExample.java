package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.List;

public class RegionDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RegionDTOExample() {
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

        public Criteria andOpenshiftUrlIsNull() {
            addCriterion("openshift_url is null");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlIsNotNull() {
            addCriterion("openshift_url is not null");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlEqualTo(String value) {
            addCriterion("openshift_url =", value, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlNotEqualTo(String value) {
            addCriterion("openshift_url <>", value, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlGreaterThan(String value) {
            addCriterion("openshift_url >", value, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlGreaterThanOrEqualTo(String value) {
            addCriterion("openshift_url >=", value, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlLessThan(String value) {
            addCriterion("openshift_url <", value, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlLessThanOrEqualTo(String value) {
            addCriterion("openshift_url <=", value, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlLike(String value) {
            addCriterion("openshift_url like", value, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlNotLike(String value) {
            addCriterion("openshift_url not like", value, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlIn(List<String> values) {
            addCriterion("openshift_url in", values, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlNotIn(List<String> values) {
            addCriterion("openshift_url not in", values, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlBetween(String value1, String value2) {
            addCriterion("openshift_url between", value1, value2, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andOpenshiftUrlNotBetween(String value1, String value2) {
            addCriterion("openshift_url not between", value1, value2, "openshiftUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlIsNull() {
            addCriterion("container_url is null");
            return (Criteria) this;
        }

        public Criteria andContainerUrlIsNotNull() {
            addCriterion("container_url is not null");
            return (Criteria) this;
        }

        public Criteria andContainerUrlEqualTo(String value) {
            addCriterion("container_url =", value, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlNotEqualTo(String value) {
            addCriterion("container_url <>", value, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlGreaterThan(String value) {
            addCriterion("container_url >", value, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlGreaterThanOrEqualTo(String value) {
            addCriterion("container_url >=", value, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlLessThan(String value) {
            addCriterion("container_url <", value, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlLessThanOrEqualTo(String value) {
            addCriterion("container_url <=", value, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlLike(String value) {
            addCriterion("container_url like", value, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlNotLike(String value) {
            addCriterion("container_url not like", value, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlIn(List<String> values) {
            addCriterion("container_url in", values, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlNotIn(List<String> values) {
            addCriterion("container_url not in", values, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlBetween(String value1, String value2) {
            addCriterion("container_url between", value1, value2, "containerUrl");
            return (Criteria) this;
        }

        public Criteria andContainerUrlNotBetween(String value1, String value2) {
            addCriterion("container_url not between", value1, value2, "containerUrl");
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