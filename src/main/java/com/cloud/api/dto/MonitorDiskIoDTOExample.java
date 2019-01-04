package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitorDiskIoDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitorDiskIoDTOExample() {
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

        public Criteria andDiskNameIsNull() {
            addCriterion("disk_name is null");
            return (Criteria) this;
        }

        public Criteria andDiskNameIsNotNull() {
            addCriterion("disk_name is not null");
            return (Criteria) this;
        }

        public Criteria andDiskNameEqualTo(String value) {
            addCriterion("disk_name =", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameNotEqualTo(String value) {
            addCriterion("disk_name <>", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameGreaterThan(String value) {
            addCriterion("disk_name >", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameGreaterThanOrEqualTo(String value) {
            addCriterion("disk_name >=", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameLessThan(String value) {
            addCriterion("disk_name <", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameLessThanOrEqualTo(String value) {
            addCriterion("disk_name <=", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameLike(String value) {
            addCriterion("disk_name like", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameNotLike(String value) {
            addCriterion("disk_name not like", value, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameIn(List<String> values) {
            addCriterion("disk_name in", values, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameNotIn(List<String> values) {
            addCriterion("disk_name not in", values, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameBetween(String value1, String value2) {
            addCriterion("disk_name between", value1, value2, "diskName");
            return (Criteria) this;
        }

        public Criteria andDiskNameNotBetween(String value1, String value2) {
            addCriterion("disk_name not between", value1, value2, "diskName");
            return (Criteria) this;
        }

        public Criteria andRpsIsNull() {
            addCriterion("rps is null");
            return (Criteria) this;
        }

        public Criteria andRpsIsNotNull() {
            addCriterion("rps is not null");
            return (Criteria) this;
        }

        public Criteria andRpsEqualTo(Float value) {
            addCriterion("rps =", value, "rps");
            return (Criteria) this;
        }

        public Criteria andRpsNotEqualTo(Float value) {
            addCriterion("rps <>", value, "rps");
            return (Criteria) this;
        }

        public Criteria andRpsGreaterThan(Float value) {
            addCriterion("rps >", value, "rps");
            return (Criteria) this;
        }

        public Criteria andRpsGreaterThanOrEqualTo(Float value) {
            addCriterion("rps >=", value, "rps");
            return (Criteria) this;
        }

        public Criteria andRpsLessThan(Float value) {
            addCriterion("rps <", value, "rps");
            return (Criteria) this;
        }

        public Criteria andRpsLessThanOrEqualTo(Float value) {
            addCriterion("rps <=", value, "rps");
            return (Criteria) this;
        }

        public Criteria andRpsIn(List<Float> values) {
            addCriterion("rps in", values, "rps");
            return (Criteria) this;
        }

        public Criteria andRpsNotIn(List<Float> values) {
            addCriterion("rps not in", values, "rps");
            return (Criteria) this;
        }

        public Criteria andRpsBetween(Float value1, Float value2) {
            addCriterion("rps between", value1, value2, "rps");
            return (Criteria) this;
        }

        public Criteria andRpsNotBetween(Float value1, Float value2) {
            addCriterion("rps not between", value1, value2, "rps");
            return (Criteria) this;
        }

        public Criteria andWpsIsNull() {
            addCriterion("wps is null");
            return (Criteria) this;
        }

        public Criteria andWpsIsNotNull() {
            addCriterion("wps is not null");
            return (Criteria) this;
        }

        public Criteria andWpsEqualTo(Float value) {
            addCriterion("wps =", value, "wps");
            return (Criteria) this;
        }

        public Criteria andWpsNotEqualTo(Float value) {
            addCriterion("wps <>", value, "wps");
            return (Criteria) this;
        }

        public Criteria andWpsGreaterThan(Float value) {
            addCriterion("wps >", value, "wps");
            return (Criteria) this;
        }

        public Criteria andWpsGreaterThanOrEqualTo(Float value) {
            addCriterion("wps >=", value, "wps");
            return (Criteria) this;
        }

        public Criteria andWpsLessThan(Float value) {
            addCriterion("wps <", value, "wps");
            return (Criteria) this;
        }

        public Criteria andWpsLessThanOrEqualTo(Float value) {
            addCriterion("wps <=", value, "wps");
            return (Criteria) this;
        }

        public Criteria andWpsIn(List<Float> values) {
            addCriterion("wps in", values, "wps");
            return (Criteria) this;
        }

        public Criteria andWpsNotIn(List<Float> values) {
            addCriterion("wps not in", values, "wps");
            return (Criteria) this;
        }

        public Criteria andWpsBetween(Float value1, Float value2) {
            addCriterion("wps between", value1, value2, "wps");
            return (Criteria) this;
        }

        public Criteria andWpsNotBetween(Float value1, Float value2) {
            addCriterion("wps not between", value1, value2, "wps");
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