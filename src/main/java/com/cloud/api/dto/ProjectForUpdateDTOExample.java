package com.cloud.api.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectForUpdateDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectForUpdateDTOExample() {
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

        public Criteria andDisplayNameIsNull() {
            addCriterion("display_name is null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNotNull() {
            addCriterion("display_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameEqualTo(String value) {
            addCriterion("display_name =", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotEqualTo(String value) {
            addCriterion("display_name <>", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThan(String value) {
            addCriterion("display_name >", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("display_name >=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThan(String value) {
            addCriterion("display_name <", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("display_name <=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLike(String value) {
            addCriterion("display_name like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotLike(String value) {
            addCriterion("display_name not like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIn(List<String> values) {
            addCriterion("display_name in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotIn(List<String> values) {
            addCriterion("display_name not in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameBetween(String value1, String value2) {
            addCriterion("display_name between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotBetween(String value1, String value2) {
            addCriterion("display_name not between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaIsNull() {
            addCriterion("cpu_quota is null");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaIsNotNull() {
            addCriterion("cpu_quota is not null");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaEqualTo(BigDecimal value) {
            addCriterion("cpu_quota =", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaNotEqualTo(BigDecimal value) {
            addCriterion("cpu_quota <>", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaGreaterThan(BigDecimal value) {
            addCriterion("cpu_quota >", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cpu_quota >=", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaLessThan(BigDecimal value) {
            addCriterion("cpu_quota <", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cpu_quota <=", value, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaIn(List<BigDecimal> values) {
            addCriterion("cpu_quota in", values, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaNotIn(List<BigDecimal> values) {
            addCriterion("cpu_quota not in", values, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cpu_quota between", value1, value2, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andCpuQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cpu_quota not between", value1, value2, "cpuQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaIsNull() {
            addCriterion("memory_quota is null");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaIsNotNull() {
            addCriterion("memory_quota is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaEqualTo(BigDecimal value) {
            addCriterion("memory_quota =", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaNotEqualTo(BigDecimal value) {
            addCriterion("memory_quota <>", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaGreaterThan(BigDecimal value) {
            addCriterion("memory_quota >", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("memory_quota >=", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaLessThan(BigDecimal value) {
            addCriterion("memory_quota <", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("memory_quota <=", value, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaIn(List<BigDecimal> values) {
            addCriterion("memory_quota in", values, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaNotIn(List<BigDecimal> values) {
            addCriterion("memory_quota not in", values, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("memory_quota between", value1, value2, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andMemoryQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("memory_quota not between", value1, value2, "memoryQuota");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaIsNull() {
            addCriterion("pods_quota is null");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaIsNotNull() {
            addCriterion("pods_quota is not null");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaEqualTo(Integer value) {
            addCriterion("pods_quota =", value, "podsQuota");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaNotEqualTo(Integer value) {
            addCriterion("pods_quota <>", value, "podsQuota");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaGreaterThan(Integer value) {
            addCriterion("pods_quota >", value, "podsQuota");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("pods_quota >=", value, "podsQuota");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaLessThan(Integer value) {
            addCriterion("pods_quota <", value, "podsQuota");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("pods_quota <=", value, "podsQuota");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaIn(List<Integer> values) {
            addCriterion("pods_quota in", values, "podsQuota");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaNotIn(List<Integer> values) {
            addCriterion("pods_quota not in", values, "podsQuota");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaBetween(Integer value1, Integer value2) {
            addCriterion("pods_quota between", value1, value2, "podsQuota");
            return (Criteria) this;
        }

        public Criteria andPodsQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("pods_quota not between", value1, value2, "podsQuota");
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

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNull() {
            addCriterion("approve_status is null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNotNull() {
            addCriterion("approve_status is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusEqualTo(Integer value) {
            addCriterion("approve_status =", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotEqualTo(Integer value) {
            addCriterion("approve_status <>", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThan(Integer value) {
            addCriterion("approve_status >", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve_status >=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThan(Integer value) {
            addCriterion("approve_status <", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThanOrEqualTo(Integer value) {
            addCriterion("approve_status <=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIn(List<Integer> values) {
            addCriterion("approve_status in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotIn(List<Integer> values) {
            addCriterion("approve_status not in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusBetween(Integer value1, Integer value2) {
            addCriterion("approve_status between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("approve_status not between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNull() {
            addCriterion("apply_user is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNotNull() {
            addCriterion("apply_user is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserEqualTo(String value) {
            addCriterion("apply_user =", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotEqualTo(String value) {
            addCriterion("apply_user <>", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThan(String value) {
            addCriterion("apply_user >", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThanOrEqualTo(String value) {
            addCriterion("apply_user >=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThan(String value) {
            addCriterion("apply_user <", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThanOrEqualTo(String value) {
            addCriterion("apply_user <=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLike(String value) {
            addCriterion("apply_user like", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotLike(String value) {
            addCriterion("apply_user not like", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserIn(List<String> values) {
            addCriterion("apply_user in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotIn(List<String> values) {
            addCriterion("apply_user not in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserBetween(String value1, String value2) {
            addCriterion("apply_user between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotBetween(String value1, String value2) {
            addCriterion("apply_user not between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaIsNull() {
            addCriterion("disk_quota is null");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaIsNotNull() {
            addCriterion("disk_quota is not null");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaEqualTo(Integer value) {
            addCriterion("disk_quota =", value, "diskQuota");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaNotEqualTo(Integer value) {
            addCriterion("disk_quota <>", value, "diskQuota");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaGreaterThan(Integer value) {
            addCriterion("disk_quota >", value, "diskQuota");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("disk_quota >=", value, "diskQuota");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaLessThan(Integer value) {
            addCriterion("disk_quota <", value, "diskQuota");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("disk_quota <=", value, "diskQuota");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaIn(List<Integer> values) {
            addCriterion("disk_quota in", values, "diskQuota");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaNotIn(List<Integer> values) {
            addCriterion("disk_quota not in", values, "diskQuota");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaBetween(Integer value1, Integer value2) {
            addCriterion("disk_quota between", value1, value2, "diskQuota");
            return (Criteria) this;
        }

        public Criteria andDiskQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("disk_quota not between", value1, value2, "diskQuota");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdIsNull() {
            addCriterion("origin_task_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdIsNotNull() {
            addCriterion("origin_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdEqualTo(String value) {
            addCriterion("origin_task_id =", value, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdNotEqualTo(String value) {
            addCriterion("origin_task_id <>", value, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdGreaterThan(String value) {
            addCriterion("origin_task_id >", value, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("origin_task_id >=", value, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdLessThan(String value) {
            addCriterion("origin_task_id <", value, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdLessThanOrEqualTo(String value) {
            addCriterion("origin_task_id <=", value, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdLike(String value) {
            addCriterion("origin_task_id like", value, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdNotLike(String value) {
            addCriterion("origin_task_id not like", value, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdIn(List<String> values) {
            addCriterion("origin_task_id in", values, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdNotIn(List<String> values) {
            addCriterion("origin_task_id not in", values, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdBetween(String value1, String value2) {
            addCriterion("origin_task_id between", value1, value2, "originTaskId");
            return (Criteria) this;
        }

        public Criteria andOriginTaskIdNotBetween(String value1, String value2) {
            addCriterion("origin_task_id not between", value1, value2, "originTaskId");
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