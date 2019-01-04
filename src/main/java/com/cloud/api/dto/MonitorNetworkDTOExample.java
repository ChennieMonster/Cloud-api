package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitorNetworkDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitorNetworkDTOExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andHostnameIsNull() {
            addCriterion("hostname is null");
            return (Criteria) this;
        }

        public Criteria andHostnameIsNotNull() {
            addCriterion("hostname is not null");
            return (Criteria) this;
        }

        public Criteria andHostnameEqualTo(String value) {
            addCriterion("hostname =", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameNotEqualTo(String value) {
            addCriterion("hostname <>", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameGreaterThan(String value) {
            addCriterion("hostname >", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameGreaterThanOrEqualTo(String value) {
            addCriterion("hostname >=", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameLessThan(String value) {
            addCriterion("hostname <", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameLessThanOrEqualTo(String value) {
            addCriterion("hostname <=", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameLike(String value) {
            addCriterion("hostname like", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameNotLike(String value) {
            addCriterion("hostname not like", value, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameIn(List<String> values) {
            addCriterion("hostname in", values, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameNotIn(List<String> values) {
            addCriterion("hostname not in", values, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameBetween(String value1, String value2) {
            addCriterion("hostname between", value1, value2, "hostname");
            return (Criteria) this;
        }

        public Criteria andHostnameNotBetween(String value1, String value2) {
            addCriterion("hostname not between", value1, value2, "hostname");
            return (Criteria) this;
        }

        public Criteria andNetnameIsNull() {
            addCriterion("netname is null");
            return (Criteria) this;
        }

        public Criteria andNetnameIsNotNull() {
            addCriterion("netname is not null");
            return (Criteria) this;
        }

        public Criteria andNetnameEqualTo(String value) {
            addCriterion("netname =", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameNotEqualTo(String value) {
            addCriterion("netname <>", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameGreaterThan(String value) {
            addCriterion("netname >", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameGreaterThanOrEqualTo(String value) {
            addCriterion("netname >=", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameLessThan(String value) {
            addCriterion("netname <", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameLessThanOrEqualTo(String value) {
            addCriterion("netname <=", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameLike(String value) {
            addCriterion("netname like", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameNotLike(String value) {
            addCriterion("netname not like", value, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameIn(List<String> values) {
            addCriterion("netname in", values, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameNotIn(List<String> values) {
            addCriterion("netname not in", values, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameBetween(String value1, String value2) {
            addCriterion("netname between", value1, value2, "netname");
            return (Criteria) this;
        }

        public Criteria andNetnameNotBetween(String value1, String value2) {
            addCriterion("netname not between", value1, value2, "netname");
            return (Criteria) this;
        }

        public Criteria andFlowInIsNull() {
            addCriterion("flow_in is null");
            return (Criteria) this;
        }

        public Criteria andFlowInIsNotNull() {
            addCriterion("flow_in is not null");
            return (Criteria) this;
        }

        public Criteria andFlowInEqualTo(Long value) {
            addCriterion("flow_in =", value, "flowIn");
            return (Criteria) this;
        }

        public Criteria andFlowInNotEqualTo(Long value) {
            addCriterion("flow_in <>", value, "flowIn");
            return (Criteria) this;
        }

        public Criteria andFlowInGreaterThan(Long value) {
            addCriterion("flow_in >", value, "flowIn");
            return (Criteria) this;
        }

        public Criteria andFlowInGreaterThanOrEqualTo(Long value) {
            addCriterion("flow_in >=", value, "flowIn");
            return (Criteria) this;
        }

        public Criteria andFlowInLessThan(Long value) {
            addCriterion("flow_in <", value, "flowIn");
            return (Criteria) this;
        }

        public Criteria andFlowInLessThanOrEqualTo(Long value) {
            addCriterion("flow_in <=", value, "flowIn");
            return (Criteria) this;
        }

        public Criteria andFlowInIn(List<Long> values) {
            addCriterion("flow_in in", values, "flowIn");
            return (Criteria) this;
        }

        public Criteria andFlowInNotIn(List<Long> values) {
            addCriterion("flow_in not in", values, "flowIn");
            return (Criteria) this;
        }

        public Criteria andFlowInBetween(Long value1, Long value2) {
            addCriterion("flow_in between", value1, value2, "flowIn");
            return (Criteria) this;
        }

        public Criteria andFlowInNotBetween(Long value1, Long value2) {
            addCriterion("flow_in not between", value1, value2, "flowIn");
            return (Criteria) this;
        }

        public Criteria andFlowOutIsNull() {
            addCriterion("flow_out is null");
            return (Criteria) this;
        }

        public Criteria andFlowOutIsNotNull() {
            addCriterion("flow_out is not null");
            return (Criteria) this;
        }

        public Criteria andFlowOutEqualTo(Long value) {
            addCriterion("flow_out =", value, "flowOut");
            return (Criteria) this;
        }

        public Criteria andFlowOutNotEqualTo(Long value) {
            addCriterion("flow_out <>", value, "flowOut");
            return (Criteria) this;
        }

        public Criteria andFlowOutGreaterThan(Long value) {
            addCriterion("flow_out >", value, "flowOut");
            return (Criteria) this;
        }

        public Criteria andFlowOutGreaterThanOrEqualTo(Long value) {
            addCriterion("flow_out >=", value, "flowOut");
            return (Criteria) this;
        }

        public Criteria andFlowOutLessThan(Long value) {
            addCriterion("flow_out <", value, "flowOut");
            return (Criteria) this;
        }

        public Criteria andFlowOutLessThanOrEqualTo(Long value) {
            addCriterion("flow_out <=", value, "flowOut");
            return (Criteria) this;
        }

        public Criteria andFlowOutIn(List<Long> values) {
            addCriterion("flow_out in", values, "flowOut");
            return (Criteria) this;
        }

        public Criteria andFlowOutNotIn(List<Long> values) {
            addCriterion("flow_out not in", values, "flowOut");
            return (Criteria) this;
        }

        public Criteria andFlowOutBetween(Long value1, Long value2) {
            addCriterion("flow_out between", value1, value2, "flowOut");
            return (Criteria) this;
        }

        public Criteria andFlowOutNotBetween(Long value1, Long value2) {
            addCriterion("flow_out not between", value1, value2, "flowOut");
            return (Criteria) this;
        }

        public Criteria andClockIsNull() {
            addCriterion("clock is null");
            return (Criteria) this;
        }

        public Criteria andClockIsNotNull() {
            addCriterion("clock is not null");
            return (Criteria) this;
        }

        public Criteria andClockEqualTo(Integer value) {
            addCriterion("clock =", value, "clock");
            return (Criteria) this;
        }

        public Criteria andClockNotEqualTo(Integer value) {
            addCriterion("clock <>", value, "clock");
            return (Criteria) this;
        }

        public Criteria andClockGreaterThan(Integer value) {
            addCriterion("clock >", value, "clock");
            return (Criteria) this;
        }

        public Criteria andClockGreaterThanOrEqualTo(Integer value) {
            addCriterion("clock >=", value, "clock");
            return (Criteria) this;
        }

        public Criteria andClockLessThan(Integer value) {
            addCriterion("clock <", value, "clock");
            return (Criteria) this;
        }

        public Criteria andClockLessThanOrEqualTo(Integer value) {
            addCriterion("clock <=", value, "clock");
            return (Criteria) this;
        }

        public Criteria andClockIn(List<Integer> values) {
            addCriterion("clock in", values, "clock");
            return (Criteria) this;
        }

        public Criteria andClockNotIn(List<Integer> values) {
            addCriterion("clock not in", values, "clock");
            return (Criteria) this;
        }

        public Criteria andClockBetween(Integer value1, Integer value2) {
            addCriterion("clock between", value1, value2, "clock");
            return (Criteria) this;
        }

        public Criteria andClockNotBetween(Integer value1, Integer value2) {
            addCriterion("clock not between", value1, value2, "clock");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
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