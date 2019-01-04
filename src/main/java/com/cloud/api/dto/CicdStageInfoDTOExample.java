package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CicdStageInfoDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CicdStageInfoDTOExample() {
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

        public Criteria andProcessIdIsNull() {
            addCriterion("process_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(String value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(String value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(String value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(String value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(String value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(String value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLike(String value) {
            addCriterion("process_id like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotLike(String value) {
            addCriterion("process_id not like", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<String> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<String> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(String value1, String value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(String value1, String value2) {
            addCriterion("process_id not between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("node_id is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("node_id is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(String value) {
            addCriterion("node_id =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(String value) {
            addCriterion("node_id <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(String value) {
            addCriterion("node_id >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("node_id >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(String value) {
            addCriterion("node_id <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(String value) {
            addCriterion("node_id <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLike(String value) {
            addCriterion("node_id like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotLike(String value) {
            addCriterion("node_id not like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<String> values) {
            addCriterion("node_id in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<String> values) {
            addCriterion("node_id not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(String value1, String value2) {
            addCriterion("node_id between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(String value1, String value2) {
            addCriterion("node_id not between", value1, value2, "nodeId");
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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDurationMillisIsNull() {
            addCriterion("duration_millis is null");
            return (Criteria) this;
        }

        public Criteria andDurationMillisIsNotNull() {
            addCriterion("duration_millis is not null");
            return (Criteria) this;
        }

        public Criteria andDurationMillisEqualTo(Long value) {
            addCriterion("duration_millis =", value, "durationMillis");
            return (Criteria) this;
        }

        public Criteria andDurationMillisNotEqualTo(Long value) {
            addCriterion("duration_millis <>", value, "durationMillis");
            return (Criteria) this;
        }

        public Criteria andDurationMillisGreaterThan(Long value) {
            addCriterion("duration_millis >", value, "durationMillis");
            return (Criteria) this;
        }

        public Criteria andDurationMillisGreaterThanOrEqualTo(Long value) {
            addCriterion("duration_millis >=", value, "durationMillis");
            return (Criteria) this;
        }

        public Criteria andDurationMillisLessThan(Long value) {
            addCriterion("duration_millis <", value, "durationMillis");
            return (Criteria) this;
        }

        public Criteria andDurationMillisLessThanOrEqualTo(Long value) {
            addCriterion("duration_millis <=", value, "durationMillis");
            return (Criteria) this;
        }

        public Criteria andDurationMillisIn(List<Long> values) {
            addCriterion("duration_millis in", values, "durationMillis");
            return (Criteria) this;
        }

        public Criteria andDurationMillisNotIn(List<Long> values) {
            addCriterion("duration_millis not in", values, "durationMillis");
            return (Criteria) this;
        }

        public Criteria andDurationMillisBetween(Long value1, Long value2) {
            addCriterion("duration_millis between", value1, value2, "durationMillis");
            return (Criteria) this;
        }

        public Criteria andDurationMillisNotBetween(Long value1, Long value2) {
            addCriterion("duration_millis not between", value1, value2, "durationMillis");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageIsNull() {
            addCriterion("api_url_stage is null");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageIsNotNull() {
            addCriterion("api_url_stage is not null");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageEqualTo(String value) {
            addCriterion("api_url_stage =", value, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageNotEqualTo(String value) {
            addCriterion("api_url_stage <>", value, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageGreaterThan(String value) {
            addCriterion("api_url_stage >", value, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageGreaterThanOrEqualTo(String value) {
            addCriterion("api_url_stage >=", value, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageLessThan(String value) {
            addCriterion("api_url_stage <", value, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageLessThanOrEqualTo(String value) {
            addCriterion("api_url_stage <=", value, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageLike(String value) {
            addCriterion("api_url_stage like", value, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageNotLike(String value) {
            addCriterion("api_url_stage not like", value, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageIn(List<String> values) {
            addCriterion("api_url_stage in", values, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageNotIn(List<String> values) {
            addCriterion("api_url_stage not in", values, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageBetween(String value1, String value2) {
            addCriterion("api_url_stage between", value1, value2, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andApiUrlStageNotBetween(String value1, String value2) {
            addCriterion("api_url_stage not between", value1, value2, "apiUrlStage");
            return (Criteria) this;
        }

        public Criteria andCodePathIsNull() {
            addCriterion("code_path is null");
            return (Criteria) this;
        }

        public Criteria andCodePathIsNotNull() {
            addCriterion("code_path is not null");
            return (Criteria) this;
        }

        public Criteria andCodePathEqualTo(String value) {
            addCriterion("code_path =", value, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathNotEqualTo(String value) {
            addCriterion("code_path <>", value, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathGreaterThan(String value) {
            addCriterion("code_path >", value, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathGreaterThanOrEqualTo(String value) {
            addCriterion("code_path >=", value, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathLessThan(String value) {
            addCriterion("code_path <", value, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathLessThanOrEqualTo(String value) {
            addCriterion("code_path <=", value, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathLike(String value) {
            addCriterion("code_path like", value, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathNotLike(String value) {
            addCriterion("code_path not like", value, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathIn(List<String> values) {
            addCriterion("code_path in", values, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathNotIn(List<String> values) {
            addCriterion("code_path not in", values, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathBetween(String value1, String value2) {
            addCriterion("code_path between", value1, value2, "codePath");
            return (Criteria) this;
        }

        public Criteria andCodePathNotBetween(String value1, String value2) {
            addCriterion("code_path not between", value1, value2, "codePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathIsNull() {
            addCriterion("compile_file_path is null");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathIsNotNull() {
            addCriterion("compile_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathEqualTo(String value) {
            addCriterion("compile_file_path =", value, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathNotEqualTo(String value) {
            addCriterion("compile_file_path <>", value, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathGreaterThan(String value) {
            addCriterion("compile_file_path >", value, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("compile_file_path >=", value, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathLessThan(String value) {
            addCriterion("compile_file_path <", value, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathLessThanOrEqualTo(String value) {
            addCriterion("compile_file_path <=", value, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathLike(String value) {
            addCriterion("compile_file_path like", value, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathNotLike(String value) {
            addCriterion("compile_file_path not like", value, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathIn(List<String> values) {
            addCriterion("compile_file_path in", values, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathNotIn(List<String> values) {
            addCriterion("compile_file_path not in", values, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathBetween(String value1, String value2) {
            addCriterion("compile_file_path between", value1, value2, "compileFilePath");
            return (Criteria) this;
        }

        public Criteria andCompileFilePathNotBetween(String value1, String value2) {
            addCriterion("compile_file_path not between", value1, value2, "compileFilePath");
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