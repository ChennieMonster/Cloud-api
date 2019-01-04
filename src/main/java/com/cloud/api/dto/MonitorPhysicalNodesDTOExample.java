package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.List;

public class MonitorPhysicalNodesDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitorPhysicalNodesDTOExample() {
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

        public Criteria andCpuIsNull() {
            addCriterion("cpu is null");
            return (Criteria) this;
        }

        public Criteria andCpuIsNotNull() {
            addCriterion("cpu is not null");
            return (Criteria) this;
        }

        public Criteria andCpuEqualTo(Integer value) {
            addCriterion("cpu =", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotEqualTo(Integer value) {
            addCriterion("cpu <>", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuGreaterThan(Integer value) {
            addCriterion("cpu >", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpu >=", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLessThan(Integer value) {
            addCriterion("cpu <", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuLessThanOrEqualTo(Integer value) {
            addCriterion("cpu <=", value, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuIn(List<Integer> values) {
            addCriterion("cpu in", values, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotIn(List<Integer> values) {
            addCriterion("cpu not in", values, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuBetween(Integer value1, Integer value2) {
            addCriterion("cpu between", value1, value2, "cpu");
            return (Criteria) this;
        }

        public Criteria andCpuNotBetween(Integer value1, Integer value2) {
            addCriterion("cpu not between", value1, value2, "cpu");
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

        public Criteria andDiskIsNull() {
            addCriterion("disk is null");
            return (Criteria) this;
        }

        public Criteria andDiskIsNotNull() {
            addCriterion("disk is not null");
            return (Criteria) this;
        }

        public Criteria andDiskEqualTo(Long value) {
            addCriterion("disk =", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskNotEqualTo(Long value) {
            addCriterion("disk <>", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskGreaterThan(Long value) {
            addCriterion("disk >", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskGreaterThanOrEqualTo(Long value) {
            addCriterion("disk >=", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskLessThan(Long value) {
            addCriterion("disk <", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskLessThanOrEqualTo(Long value) {
            addCriterion("disk <=", value, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskIn(List<Long> values) {
            addCriterion("disk in", values, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskNotIn(List<Long> values) {
            addCriterion("disk not in", values, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskBetween(Long value1, Long value2) {
            addCriterion("disk between", value1, value2, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskNotBetween(Long value1, Long value2) {
            addCriterion("disk not between", value1, value2, "disk");
            return (Criteria) this;
        }

        public Criteria andDiskUsageIsNull() {
            addCriterion("disk_usage is null");
            return (Criteria) this;
        }

        public Criteria andDiskUsageIsNotNull() {
            addCriterion("disk_usage is not null");
            return (Criteria) this;
        }

        public Criteria andDiskUsageEqualTo(Long value) {
            addCriterion("disk_usage =", value, "diskUsage");
            return (Criteria) this;
        }

        public Criteria andDiskUsageNotEqualTo(Long value) {
            addCriterion("disk_usage <>", value, "diskUsage");
            return (Criteria) this;
        }

        public Criteria andDiskUsageGreaterThan(Long value) {
            addCriterion("disk_usage >", value, "diskUsage");
            return (Criteria) this;
        }

        public Criteria andDiskUsageGreaterThanOrEqualTo(Long value) {
            addCriterion("disk_usage >=", value, "diskUsage");
            return (Criteria) this;
        }

        public Criteria andDiskUsageLessThan(Long value) {
            addCriterion("disk_usage <", value, "diskUsage");
            return (Criteria) this;
        }

        public Criteria andDiskUsageLessThanOrEqualTo(Long value) {
            addCriterion("disk_usage <=", value, "diskUsage");
            return (Criteria) this;
        }

        public Criteria andDiskUsageIn(List<Long> values) {
            addCriterion("disk_usage in", values, "diskUsage");
            return (Criteria) this;
        }

        public Criteria andDiskUsageNotIn(List<Long> values) {
            addCriterion("disk_usage not in", values, "diskUsage");
            return (Criteria) this;
        }

        public Criteria andDiskUsageBetween(Long value1, Long value2) {
            addCriterion("disk_usage between", value1, value2, "diskUsage");
            return (Criteria) this;
        }

        public Criteria andDiskUsageNotBetween(Long value1, Long value2) {
            addCriterion("disk_usage not between", value1, value2, "diskUsage");
            return (Criteria) this;
        }

        public Criteria andNetIfInIsNull() {
            addCriterion("net_if_in is null");
            return (Criteria) this;
        }

        public Criteria andNetIfInIsNotNull() {
            addCriterion("net_if_in is not null");
            return (Criteria) this;
        }

        public Criteria andNetIfInEqualTo(Long value) {
            addCriterion("net_if_in =", value, "netIfIn");
            return (Criteria) this;
        }

        public Criteria andNetIfInNotEqualTo(Long value) {
            addCriterion("net_if_in <>", value, "netIfIn");
            return (Criteria) this;
        }

        public Criteria andNetIfInGreaterThan(Long value) {
            addCriterion("net_if_in >", value, "netIfIn");
            return (Criteria) this;
        }

        public Criteria andNetIfInGreaterThanOrEqualTo(Long value) {
            addCriterion("net_if_in >=", value, "netIfIn");
            return (Criteria) this;
        }

        public Criteria andNetIfInLessThan(Long value) {
            addCriterion("net_if_in <", value, "netIfIn");
            return (Criteria) this;
        }

        public Criteria andNetIfInLessThanOrEqualTo(Long value) {
            addCriterion("net_if_in <=", value, "netIfIn");
            return (Criteria) this;
        }

        public Criteria andNetIfInIn(List<Long> values) {
            addCriterion("net_if_in in", values, "netIfIn");
            return (Criteria) this;
        }

        public Criteria andNetIfInNotIn(List<Long> values) {
            addCriterion("net_if_in not in", values, "netIfIn");
            return (Criteria) this;
        }

        public Criteria andNetIfInBetween(Long value1, Long value2) {
            addCriterion("net_if_in between", value1, value2, "netIfIn");
            return (Criteria) this;
        }

        public Criteria andNetIfInNotBetween(Long value1, Long value2) {
            addCriterion("net_if_in not between", value1, value2, "netIfIn");
            return (Criteria) this;
        }

        public Criteria andNetIfOutIsNull() {
            addCriterion("net_if_out is null");
            return (Criteria) this;
        }

        public Criteria andNetIfOutIsNotNull() {
            addCriterion("net_if_out is not null");
            return (Criteria) this;
        }

        public Criteria andNetIfOutEqualTo(Long value) {
            addCriterion("net_if_out =", value, "netIfOut");
            return (Criteria) this;
        }

        public Criteria andNetIfOutNotEqualTo(Long value) {
            addCriterion("net_if_out <>", value, "netIfOut");
            return (Criteria) this;
        }

        public Criteria andNetIfOutGreaterThan(Long value) {
            addCriterion("net_if_out >", value, "netIfOut");
            return (Criteria) this;
        }

        public Criteria andNetIfOutGreaterThanOrEqualTo(Long value) {
            addCriterion("net_if_out >=", value, "netIfOut");
            return (Criteria) this;
        }

        public Criteria andNetIfOutLessThan(Long value) {
            addCriterion("net_if_out <", value, "netIfOut");
            return (Criteria) this;
        }

        public Criteria andNetIfOutLessThanOrEqualTo(Long value) {
            addCriterion("net_if_out <=", value, "netIfOut");
            return (Criteria) this;
        }

        public Criteria andNetIfOutIn(List<Long> values) {
            addCriterion("net_if_out in", values, "netIfOut");
            return (Criteria) this;
        }

        public Criteria andNetIfOutNotIn(List<Long> values) {
            addCriterion("net_if_out not in", values, "netIfOut");
            return (Criteria) this;
        }

        public Criteria andNetIfOutBetween(Long value1, Long value2) {
            addCriterion("net_if_out between", value1, value2, "netIfOut");
            return (Criteria) this;
        }

        public Criteria andNetIfOutNotBetween(Long value1, Long value2) {
            addCriterion("net_if_out not between", value1, value2, "netIfOut");
            return (Criteria) this;
        }

        public Criteria andOsIsNull() {
            addCriterion("os is null");
            return (Criteria) this;
        }

        public Criteria andOsIsNotNull() {
            addCriterion("os is not null");
            return (Criteria) this;
        }

        public Criteria andOsEqualTo(String value) {
            addCriterion("os =", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotEqualTo(String value) {
            addCriterion("os <>", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThan(String value) {
            addCriterion("os >", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsGreaterThanOrEqualTo(String value) {
            addCriterion("os >=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThan(String value) {
            addCriterion("os <", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLessThanOrEqualTo(String value) {
            addCriterion("os <=", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsLike(String value) {
            addCriterion("os like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotLike(String value) {
            addCriterion("os not like", value, "os");
            return (Criteria) this;
        }

        public Criteria andOsIn(List<String> values) {
            addCriterion("os in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotIn(List<String> values) {
            addCriterion("os not in", values, "os");
            return (Criteria) this;
        }

        public Criteria andOsBetween(String value1, String value2) {
            addCriterion("os between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andOsNotBetween(String value1, String value2) {
            addCriterion("os not between", value1, value2, "os");
            return (Criteria) this;
        }

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
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