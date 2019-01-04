package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitorHistoryDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitorHistoryDTOExample() {
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

        public Criteria andDataTimeIsNull() {
            addCriterion("data_time is null");
            return (Criteria) this;
        }

        public Criteria andDataTimeIsNotNull() {
            addCriterion("data_time is not null");
            return (Criteria) this;
        }

        public Criteria andDataTimeEqualTo(Long value) {
            addCriterion("data_time =", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotEqualTo(Long value) {
            addCriterion("data_time <>", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeGreaterThan(Long value) {
            addCriterion("data_time >", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("data_time >=", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeLessThan(Long value) {
            addCriterion("data_time <", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeLessThanOrEqualTo(Long value) {
            addCriterion("data_time <=", value, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeIn(List<Long> values) {
            addCriterion("data_time in", values, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotIn(List<Long> values) {
            addCriterion("data_time not in", values, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeBetween(Long value1, Long value2) {
            addCriterion("data_time between", value1, value2, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataTimeNotBetween(Long value1, Long value2) {
            addCriterion("data_time not between", value1, value2, "dataTime");
            return (Criteria) this;
        }

        public Criteria andDataValueIsNull() {
            addCriterion("data_value is null");
            return (Criteria) this;
        }

        public Criteria andDataValueIsNotNull() {
            addCriterion("data_value is not null");
            return (Criteria) this;
        }

        public Criteria andDataValueEqualTo(Float value) {
            addCriterion("data_value =", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueNotEqualTo(Float value) {
            addCriterion("data_value <>", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueGreaterThan(Float value) {
            addCriterion("data_value >", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueGreaterThanOrEqualTo(Float value) {
            addCriterion("data_value >=", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueLessThan(Float value) {
            addCriterion("data_value <", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueLessThanOrEqualTo(Float value) {
            addCriterion("data_value <=", value, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueIn(List<Float> values) {
            addCriterion("data_value in", values, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueNotIn(List<Float> values) {
            addCriterion("data_value not in", values, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueBetween(Float value1, Float value2) {
            addCriterion("data_value between", value1, value2, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataValueNotBetween(Float value1, Float value2) {
            addCriterion("data_value not between", value1, value2, "dataValue");
            return (Criteria) this;
        }

        public Criteria andDataUnitIsNull() {
            addCriterion("data_unit is null");
            return (Criteria) this;
        }

        public Criteria andDataUnitIsNotNull() {
            addCriterion("data_unit is not null");
            return (Criteria) this;
        }

        public Criteria andDataUnitEqualTo(String value) {
            addCriterion("data_unit =", value, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitNotEqualTo(String value) {
            addCriterion("data_unit <>", value, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitGreaterThan(String value) {
            addCriterion("data_unit >", value, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitGreaterThanOrEqualTo(String value) {
            addCriterion("data_unit >=", value, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitLessThan(String value) {
            addCriterion("data_unit <", value, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitLessThanOrEqualTo(String value) {
            addCriterion("data_unit <=", value, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitLike(String value) {
            addCriterion("data_unit like", value, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitNotLike(String value) {
            addCriterion("data_unit not like", value, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitIn(List<String> values) {
            addCriterion("data_unit in", values, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitNotIn(List<String> values) {
            addCriterion("data_unit not in", values, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitBetween(String value1, String value2) {
            addCriterion("data_unit between", value1, value2, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataUnitNotBetween(String value1, String value2) {
            addCriterion("data_unit not between", value1, value2, "dataUnit");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("data_type like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("data_type not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
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