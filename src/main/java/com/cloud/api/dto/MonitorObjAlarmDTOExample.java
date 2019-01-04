package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.List;

public class MonitorObjAlarmDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitorObjAlarmDTOExample() {
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

        public Criteria andMonitorAlarmIdIsNull() {
            addCriterion("monitor_alarm_id is null");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdIsNotNull() {
            addCriterion("monitor_alarm_id is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdEqualTo(String value) {
            addCriterion("monitor_alarm_id =", value, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdNotEqualTo(String value) {
            addCriterion("monitor_alarm_id <>", value, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdGreaterThan(String value) {
            addCriterion("monitor_alarm_id >", value, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_alarm_id >=", value, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdLessThan(String value) {
            addCriterion("monitor_alarm_id <", value, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdLessThanOrEqualTo(String value) {
            addCriterion("monitor_alarm_id <=", value, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdLike(String value) {
            addCriterion("monitor_alarm_id like", value, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdNotLike(String value) {
            addCriterion("monitor_alarm_id not like", value, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdIn(List<String> values) {
            addCriterion("monitor_alarm_id in", values, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdNotIn(List<String> values) {
            addCriterion("monitor_alarm_id not in", values, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdBetween(String value1, String value2) {
            addCriterion("monitor_alarm_id between", value1, value2, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorAlarmIdNotBetween(String value1, String value2) {
            addCriterion("monitor_alarm_id not between", value1, value2, "monitorAlarmId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdIsNull() {
            addCriterion("monitor_obj_id is null");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdIsNotNull() {
            addCriterion("monitor_obj_id is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdEqualTo(String value) {
            addCriterion("monitor_obj_id =", value, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdNotEqualTo(String value) {
            addCriterion("monitor_obj_id <>", value, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdGreaterThan(String value) {
            addCriterion("monitor_obj_id >", value, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_obj_id >=", value, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdLessThan(String value) {
            addCriterion("monitor_obj_id <", value, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdLessThanOrEqualTo(String value) {
            addCriterion("monitor_obj_id <=", value, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdLike(String value) {
            addCriterion("monitor_obj_id like", value, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdNotLike(String value) {
            addCriterion("monitor_obj_id not like", value, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdIn(List<String> values) {
            addCriterion("monitor_obj_id in", values, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdNotIn(List<String> values) {
            addCriterion("monitor_obj_id not in", values, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdBetween(String value1, String value2) {
            addCriterion("monitor_obj_id between", value1, value2, "monitorObjId");
            return (Criteria) this;
        }

        public Criteria andMonitorObjIdNotBetween(String value1, String value2) {
            addCriterion("monitor_obj_id not between", value1, value2, "monitorObjId");
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