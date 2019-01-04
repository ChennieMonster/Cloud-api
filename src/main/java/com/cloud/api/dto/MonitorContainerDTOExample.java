package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitorContainerDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitorContainerDTOExample() {
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

        public Criteria andConCloudIdIsNull() {
            addCriterion("con_cloud_id is null");
            return (Criteria) this;
        }

        public Criteria andConCloudIdIsNotNull() {
            addCriterion("con_cloud_id is not null");
            return (Criteria) this;
        }

        public Criteria andConCloudIdEqualTo(String value) {
            addCriterion("con_cloud_id =", value, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdNotEqualTo(String value) {
            addCriterion("con_cloud_id <>", value, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdGreaterThan(String value) {
            addCriterion("con_cloud_id >", value, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdGreaterThanOrEqualTo(String value) {
            addCriterion("con_cloud_id >=", value, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdLessThan(String value) {
            addCriterion("con_cloud_id <", value, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdLessThanOrEqualTo(String value) {
            addCriterion("con_cloud_id <=", value, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdLike(String value) {
            addCriterion("con_cloud_id like", value, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdNotLike(String value) {
            addCriterion("con_cloud_id not like", value, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdIn(List<String> values) {
            addCriterion("con_cloud_id in", values, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdNotIn(List<String> values) {
            addCriterion("con_cloud_id not in", values, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdBetween(String value1, String value2) {
            addCriterion("con_cloud_id between", value1, value2, "conCloudId");
            return (Criteria) this;
        }

        public Criteria andConCloudIdNotBetween(String value1, String value2) {
            addCriterion("con_cloud_id not between", value1, value2, "conCloudId");
            return (Criteria) this;
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

        public Criteria andConDockerIdIsNull() {
            addCriterion("con_docker_id is null");
            return (Criteria) this;
        }

        public Criteria andConDockerIdIsNotNull() {
            addCriterion("con_docker_id is not null");
            return (Criteria) this;
        }

        public Criteria andConDockerIdEqualTo(String value) {
            addCriterion("con_docker_id =", value, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdNotEqualTo(String value) {
            addCriterion("con_docker_id <>", value, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdGreaterThan(String value) {
            addCriterion("con_docker_id >", value, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdGreaterThanOrEqualTo(String value) {
            addCriterion("con_docker_id >=", value, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdLessThan(String value) {
            addCriterion("con_docker_id <", value, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdLessThanOrEqualTo(String value) {
            addCriterion("con_docker_id <=", value, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdLike(String value) {
            addCriterion("con_docker_id like", value, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdNotLike(String value) {
            addCriterion("con_docker_id not like", value, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdIn(List<String> values) {
            addCriterion("con_docker_id in", values, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdNotIn(List<String> values) {
            addCriterion("con_docker_id not in", values, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdBetween(String value1, String value2) {
            addCriterion("con_docker_id between", value1, value2, "conDockerId");
            return (Criteria) this;
        }

        public Criteria andConDockerIdNotBetween(String value1, String value2) {
            addCriterion("con_docker_id not between", value1, value2, "conDockerId");
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

        public Criteria andMemoryIsNull() {
            addCriterion("memory is null");
            return (Criteria) this;
        }

        public Criteria andMemoryIsNotNull() {
            addCriterion("memory is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryEqualTo(Long value) {
            addCriterion("memory =", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotEqualTo(Long value) {
            addCriterion("memory <>", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThan(Long value) {
            addCriterion("memory >", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryGreaterThanOrEqualTo(Long value) {
            addCriterion("memory >=", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryLessThan(Long value) {
            addCriterion("memory <", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryLessThanOrEqualTo(Long value) {
            addCriterion("memory <=", value, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryIn(List<Long> values) {
            addCriterion("memory in", values, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotIn(List<Long> values) {
            addCriterion("memory not in", values, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryBetween(Long value1, Long value2) {
            addCriterion("memory between", value1, value2, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryNotBetween(Long value1, Long value2) {
            addCriterion("memory not between", value1, value2, "memory");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageIsNull() {
            addCriterion("memory_usage is null");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageIsNotNull() {
            addCriterion("memory_usage is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageEqualTo(Long value) {
            addCriterion("memory_usage =", value, "memoryUsage");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageNotEqualTo(Long value) {
            addCriterion("memory_usage <>", value, "memoryUsage");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageGreaterThan(Long value) {
            addCriterion("memory_usage >", value, "memoryUsage");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageGreaterThanOrEqualTo(Long value) {
            addCriterion("memory_usage >=", value, "memoryUsage");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageLessThan(Long value) {
            addCriterion("memory_usage <", value, "memoryUsage");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageLessThanOrEqualTo(Long value) {
            addCriterion("memory_usage <=", value, "memoryUsage");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageIn(List<Long> values) {
            addCriterion("memory_usage in", values, "memoryUsage");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageNotIn(List<Long> values) {
            addCriterion("memory_usage not in", values, "memoryUsage");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageBetween(Long value1, Long value2) {
            addCriterion("memory_usage between", value1, value2, "memoryUsage");
            return (Criteria) this;
        }

        public Criteria andMemoryUsageNotBetween(Long value1, Long value2) {
            addCriterion("memory_usage not between", value1, value2, "memoryUsage");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilIsNull() {
            addCriterion("memory_util is null");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilIsNotNull() {
            addCriterion("memory_util is not null");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilEqualTo(Float value) {
            addCriterion("memory_util =", value, "memoryUtil");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilNotEqualTo(Float value) {
            addCriterion("memory_util <>", value, "memoryUtil");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilGreaterThan(Float value) {
            addCriterion("memory_util >", value, "memoryUtil");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilGreaterThanOrEqualTo(Float value) {
            addCriterion("memory_util >=", value, "memoryUtil");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilLessThan(Float value) {
            addCriterion("memory_util <", value, "memoryUtil");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilLessThanOrEqualTo(Float value) {
            addCriterion("memory_util <=", value, "memoryUtil");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilIn(List<Float> values) {
            addCriterion("memory_util in", values, "memoryUtil");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilNotIn(List<Float> values) {
            addCriterion("memory_util not in", values, "memoryUtil");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilBetween(Float value1, Float value2) {
            addCriterion("memory_util between", value1, value2, "memoryUtil");
            return (Criteria) this;
        }

        public Criteria andMemoryUtilNotBetween(Float value1, Float value2) {
            addCriterion("memory_util not between", value1, value2, "memoryUtil");
            return (Criteria) this;
        }

        public Criteria andCpuUtilIsNull() {
            addCriterion("cpu_util is null");
            return (Criteria) this;
        }

        public Criteria andCpuUtilIsNotNull() {
            addCriterion("cpu_util is not null");
            return (Criteria) this;
        }

        public Criteria andCpuUtilEqualTo(Float value) {
            addCriterion("cpu_util =", value, "cpuUtil");
            return (Criteria) this;
        }

        public Criteria andCpuUtilNotEqualTo(Float value) {
            addCriterion("cpu_util <>", value, "cpuUtil");
            return (Criteria) this;
        }

        public Criteria andCpuUtilGreaterThan(Float value) {
            addCriterion("cpu_util >", value, "cpuUtil");
            return (Criteria) this;
        }

        public Criteria andCpuUtilGreaterThanOrEqualTo(Float value) {
            addCriterion("cpu_util >=", value, "cpuUtil");
            return (Criteria) this;
        }

        public Criteria andCpuUtilLessThan(Float value) {
            addCriterion("cpu_util <", value, "cpuUtil");
            return (Criteria) this;
        }

        public Criteria andCpuUtilLessThanOrEqualTo(Float value) {
            addCriterion("cpu_util <=", value, "cpuUtil");
            return (Criteria) this;
        }

        public Criteria andCpuUtilIn(List<Float> values) {
            addCriterion("cpu_util in", values, "cpuUtil");
            return (Criteria) this;
        }

        public Criteria andCpuUtilNotIn(List<Float> values) {
            addCriterion("cpu_util not in", values, "cpuUtil");
            return (Criteria) this;
        }

        public Criteria andCpuUtilBetween(Float value1, Float value2) {
            addCriterion("cpu_util between", value1, value2, "cpuUtil");
            return (Criteria) this;
        }

        public Criteria andCpuUtilNotBetween(Float value1, Float value2) {
            addCriterion("cpu_util not between", value1, value2, "cpuUtil");
            return (Criteria) this;
        }

        public Criteria andNetInIsNull() {
            addCriterion("net_in is null");
            return (Criteria) this;
        }

        public Criteria andNetInIsNotNull() {
            addCriterion("net_in is not null");
            return (Criteria) this;
        }

        public Criteria andNetInEqualTo(Long value) {
            addCriterion("net_in =", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInNotEqualTo(Long value) {
            addCriterion("net_in <>", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInGreaterThan(Long value) {
            addCriterion("net_in >", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInGreaterThanOrEqualTo(Long value) {
            addCriterion("net_in >=", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInLessThan(Long value) {
            addCriterion("net_in <", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInLessThanOrEqualTo(Long value) {
            addCriterion("net_in <=", value, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInIn(List<Long> values) {
            addCriterion("net_in in", values, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInNotIn(List<Long> values) {
            addCriterion("net_in not in", values, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInBetween(Long value1, Long value2) {
            addCriterion("net_in between", value1, value2, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetInNotBetween(Long value1, Long value2) {
            addCriterion("net_in not between", value1, value2, "netIn");
            return (Criteria) this;
        }

        public Criteria andNetOutIsNull() {
            addCriterion("net_out is null");
            return (Criteria) this;
        }

        public Criteria andNetOutIsNotNull() {
            addCriterion("net_out is not null");
            return (Criteria) this;
        }

        public Criteria andNetOutEqualTo(Long value) {
            addCriterion("net_out =", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutNotEqualTo(Long value) {
            addCriterion("net_out <>", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutGreaterThan(Long value) {
            addCriterion("net_out >", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutGreaterThanOrEqualTo(Long value) {
            addCriterion("net_out >=", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutLessThan(Long value) {
            addCriterion("net_out <", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutLessThanOrEqualTo(Long value) {
            addCriterion("net_out <=", value, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutIn(List<Long> values) {
            addCriterion("net_out in", values, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutNotIn(List<Long> values) {
            addCriterion("net_out not in", values, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutBetween(Long value1, Long value2) {
            addCriterion("net_out between", value1, value2, "netOut");
            return (Criteria) this;
        }

        public Criteria andNetOutNotBetween(Long value1, Long value2) {
            addCriterion("net_out not between", value1, value2, "netOut");
            return (Criteria) this;
        }

        public Criteria andBlockInIsNull() {
            addCriterion("block_in is null");
            return (Criteria) this;
        }

        public Criteria andBlockInIsNotNull() {
            addCriterion("block_in is not null");
            return (Criteria) this;
        }

        public Criteria andBlockInEqualTo(Long value) {
            addCriterion("block_in =", value, "blockIn");
            return (Criteria) this;
        }

        public Criteria andBlockInNotEqualTo(Long value) {
            addCriterion("block_in <>", value, "blockIn");
            return (Criteria) this;
        }

        public Criteria andBlockInGreaterThan(Long value) {
            addCriterion("block_in >", value, "blockIn");
            return (Criteria) this;
        }

        public Criteria andBlockInGreaterThanOrEqualTo(Long value) {
            addCriterion("block_in >=", value, "blockIn");
            return (Criteria) this;
        }

        public Criteria andBlockInLessThan(Long value) {
            addCriterion("block_in <", value, "blockIn");
            return (Criteria) this;
        }

        public Criteria andBlockInLessThanOrEqualTo(Long value) {
            addCriterion("block_in <=", value, "blockIn");
            return (Criteria) this;
        }

        public Criteria andBlockInIn(List<Long> values) {
            addCriterion("block_in in", values, "blockIn");
            return (Criteria) this;
        }

        public Criteria andBlockInNotIn(List<Long> values) {
            addCriterion("block_in not in", values, "blockIn");
            return (Criteria) this;
        }

        public Criteria andBlockInBetween(Long value1, Long value2) {
            addCriterion("block_in between", value1, value2, "blockIn");
            return (Criteria) this;
        }

        public Criteria andBlockInNotBetween(Long value1, Long value2) {
            addCriterion("block_in not between", value1, value2, "blockIn");
            return (Criteria) this;
        }

        public Criteria andBlockOutIsNull() {
            addCriterion("block_out is null");
            return (Criteria) this;
        }

        public Criteria andBlockOutIsNotNull() {
            addCriterion("block_out is not null");
            return (Criteria) this;
        }

        public Criteria andBlockOutEqualTo(Long value) {
            addCriterion("block_out =", value, "blockOut");
            return (Criteria) this;
        }

        public Criteria andBlockOutNotEqualTo(Long value) {
            addCriterion("block_out <>", value, "blockOut");
            return (Criteria) this;
        }

        public Criteria andBlockOutGreaterThan(Long value) {
            addCriterion("block_out >", value, "blockOut");
            return (Criteria) this;
        }

        public Criteria andBlockOutGreaterThanOrEqualTo(Long value) {
            addCriterion("block_out >=", value, "blockOut");
            return (Criteria) this;
        }

        public Criteria andBlockOutLessThan(Long value) {
            addCriterion("block_out <", value, "blockOut");
            return (Criteria) this;
        }

        public Criteria andBlockOutLessThanOrEqualTo(Long value) {
            addCriterion("block_out <=", value, "blockOut");
            return (Criteria) this;
        }

        public Criteria andBlockOutIn(List<Long> values) {
            addCriterion("block_out in", values, "blockOut");
            return (Criteria) this;
        }

        public Criteria andBlockOutNotIn(List<Long> values) {
            addCriterion("block_out not in", values, "blockOut");
            return (Criteria) this;
        }

        public Criteria andBlockOutBetween(Long value1, Long value2) {
            addCriterion("block_out between", value1, value2, "blockOut");
            return (Criteria) this;
        }

        public Criteria andBlockOutNotBetween(Long value1, Long value2) {
            addCriterion("block_out not between", value1, value2, "blockOut");
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