package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContainerDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContainerDTOExample() {
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

        public Criteria andConIdIsNull() {
            addCriterion("con_id is null");
            return (Criteria) this;
        }

        public Criteria andConIdIsNotNull() {
            addCriterion("con_id is not null");
            return (Criteria) this;
        }

        public Criteria andConIdEqualTo(String value) {
            addCriterion("con_id =", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotEqualTo(String value) {
            addCriterion("con_id <>", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdGreaterThan(String value) {
            addCriterion("con_id >", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdGreaterThanOrEqualTo(String value) {
            addCriterion("con_id >=", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLessThan(String value) {
            addCriterion("con_id <", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLessThanOrEqualTo(String value) {
            addCriterion("con_id <=", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdLike(String value) {
            addCriterion("con_id like", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotLike(String value) {
            addCriterion("con_id not like", value, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdIn(List<String> values) {
            addCriterion("con_id in", values, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotIn(List<String> values) {
            addCriterion("con_id not in", values, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdBetween(String value1, String value2) {
            addCriterion("con_id between", value1, value2, "conId");
            return (Criteria) this;
        }

        public Criteria andConIdNotBetween(String value1, String value2) {
            addCriterion("con_id not between", value1, value2, "conId");
            return (Criteria) this;
        }

        public Criteria andPodIdIsNull() {
            addCriterion("pod_id is null");
            return (Criteria) this;
        }

        public Criteria andPodIdIsNotNull() {
            addCriterion("pod_id is not null");
            return (Criteria) this;
        }

        public Criteria andPodIdEqualTo(String value) {
            addCriterion("pod_id =", value, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdNotEqualTo(String value) {
            addCriterion("pod_id <>", value, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdGreaterThan(String value) {
            addCriterion("pod_id >", value, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdGreaterThanOrEqualTo(String value) {
            addCriterion("pod_id >=", value, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdLessThan(String value) {
            addCriterion("pod_id <", value, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdLessThanOrEqualTo(String value) {
            addCriterion("pod_id <=", value, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdLike(String value) {
            addCriterion("pod_id like", value, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdNotLike(String value) {
            addCriterion("pod_id not like", value, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdIn(List<String> values) {
            addCriterion("pod_id in", values, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdNotIn(List<String> values) {
            addCriterion("pod_id not in", values, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdBetween(String value1, String value2) {
            addCriterion("pod_id between", value1, value2, "podId");
            return (Criteria) this;
        }

        public Criteria andPodIdNotBetween(String value1, String value2) {
            addCriterion("pod_id not between", value1, value2, "podId");
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

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andResourcesIsNull() {
            addCriterion("resources is null");
            return (Criteria) this;
        }

        public Criteria andResourcesIsNotNull() {
            addCriterion("resources is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesEqualTo(String value) {
            addCriterion("resources =", value, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesNotEqualTo(String value) {
            addCriterion("resources <>", value, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesGreaterThan(String value) {
            addCriterion("resources >", value, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesGreaterThanOrEqualTo(String value) {
            addCriterion("resources >=", value, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesLessThan(String value) {
            addCriterion("resources <", value, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesLessThanOrEqualTo(String value) {
            addCriterion("resources <=", value, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesLike(String value) {
            addCriterion("resources like", value, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesNotLike(String value) {
            addCriterion("resources not like", value, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesIn(List<String> values) {
            addCriterion("resources in", values, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesNotIn(List<String> values) {
            addCriterion("resources not in", values, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesBetween(String value1, String value2) {
            addCriterion("resources between", value1, value2, "resources");
            return (Criteria) this;
        }

        public Criteria andResourcesNotBetween(String value1, String value2) {
            addCriterion("resources not between", value1, value2, "resources");
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

        public Criteria andProcessIdEqualTo(Integer value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(Integer value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(Integer value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(Integer value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(Integer value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<Integer> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<Integer> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(Integer value1, Integer value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(Integer value1, Integer value2) {
            addCriterion("process_id not between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andWorkDirIsNull() {
            addCriterion("work_dir is null");
            return (Criteria) this;
        }

        public Criteria andWorkDirIsNotNull() {
            addCriterion("work_dir is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDirEqualTo(String value) {
            addCriterion("work_dir =", value, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirNotEqualTo(String value) {
            addCriterion("work_dir <>", value, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirGreaterThan(String value) {
            addCriterion("work_dir >", value, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirGreaterThanOrEqualTo(String value) {
            addCriterion("work_dir >=", value, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirLessThan(String value) {
            addCriterion("work_dir <", value, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirLessThanOrEqualTo(String value) {
            addCriterion("work_dir <=", value, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirLike(String value) {
            addCriterion("work_dir like", value, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirNotLike(String value) {
            addCriterion("work_dir not like", value, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirIn(List<String> values) {
            addCriterion("work_dir in", values, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirNotIn(List<String> values) {
            addCriterion("work_dir not in", values, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirBetween(String value1, String value2) {
            addCriterion("work_dir between", value1, value2, "workDir");
            return (Criteria) this;
        }

        public Criteria andWorkDirNotBetween(String value1, String value2) {
            addCriterion("work_dir not between", value1, value2, "workDir");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("node_name is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("node_name is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("node_name =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("node_name <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("node_name >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("node_name >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("node_name <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("node_name <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("node_name like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("node_name not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("node_name in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("node_name not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("node_name between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("node_name not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andEnvIsNull() {
            addCriterion("env is null");
            return (Criteria) this;
        }

        public Criteria andEnvIsNotNull() {
            addCriterion("env is not null");
            return (Criteria) this;
        }

        public Criteria andEnvEqualTo(String value) {
            addCriterion("env =", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvNotEqualTo(String value) {
            addCriterion("env <>", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvGreaterThan(String value) {
            addCriterion("env >", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvGreaterThanOrEqualTo(String value) {
            addCriterion("env >=", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvLessThan(String value) {
            addCriterion("env <", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvLessThanOrEqualTo(String value) {
            addCriterion("env <=", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvLike(String value) {
            addCriterion("env like", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvNotLike(String value) {
            addCriterion("env not like", value, "env");
            return (Criteria) this;
        }

        public Criteria andEnvIn(List<String> values) {
            addCriterion("env in", values, "env");
            return (Criteria) this;
        }

        public Criteria andEnvNotIn(List<String> values) {
            addCriterion("env not in", values, "env");
            return (Criteria) this;
        }

        public Criteria andEnvBetween(String value1, String value2) {
            addCriterion("env between", value1, value2, "env");
            return (Criteria) this;
        }

        public Criteria andEnvNotBetween(String value1, String value2) {
            addCriterion("env not between", value1, value2, "env");
            return (Criteria) this;
        }

        public Criteria andArgsIsNull() {
            addCriterion("args is null");
            return (Criteria) this;
        }

        public Criteria andArgsIsNotNull() {
            addCriterion("args is not null");
            return (Criteria) this;
        }

        public Criteria andArgsEqualTo(String value) {
            addCriterion("args =", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsNotEqualTo(String value) {
            addCriterion("args <>", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsGreaterThan(String value) {
            addCriterion("args >", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsGreaterThanOrEqualTo(String value) {
            addCriterion("args >=", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsLessThan(String value) {
            addCriterion("args <", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsLessThanOrEqualTo(String value) {
            addCriterion("args <=", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsLike(String value) {
            addCriterion("args like", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsNotLike(String value) {
            addCriterion("args not like", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsIn(List<String> values) {
            addCriterion("args in", values, "args");
            return (Criteria) this;
        }

        public Criteria andArgsNotIn(List<String> values) {
            addCriterion("args not in", values, "args");
            return (Criteria) this;
        }

        public Criteria andArgsBetween(String value1, String value2) {
            addCriterion("args between", value1, value2, "args");
            return (Criteria) this;
        }

        public Criteria andArgsNotBetween(String value1, String value2) {
            addCriterion("args not between", value1, value2, "args");
            return (Criteria) this;
        }

        public Criteria andVolumesIsNull() {
            addCriterion("volumes is null");
            return (Criteria) this;
        }

        public Criteria andVolumesIsNotNull() {
            addCriterion("volumes is not null");
            return (Criteria) this;
        }

        public Criteria andVolumesEqualTo(String value) {
            addCriterion("volumes =", value, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesNotEqualTo(String value) {
            addCriterion("volumes <>", value, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesGreaterThan(String value) {
            addCriterion("volumes >", value, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesGreaterThanOrEqualTo(String value) {
            addCriterion("volumes >=", value, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesLessThan(String value) {
            addCriterion("volumes <", value, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesLessThanOrEqualTo(String value) {
            addCriterion("volumes <=", value, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesLike(String value) {
            addCriterion("volumes like", value, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesNotLike(String value) {
            addCriterion("volumes not like", value, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesIn(List<String> values) {
            addCriterion("volumes in", values, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesNotIn(List<String> values) {
            addCriterion("volumes not in", values, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesBetween(String value1, String value2) {
            addCriterion("volumes between", value1, value2, "volumes");
            return (Criteria) this;
        }

        public Criteria andVolumesNotBetween(String value1, String value2) {
            addCriterion("volumes not between", value1, value2, "volumes");
            return (Criteria) this;
        }

        public Criteria andMountsIsNull() {
            addCriterion("mounts is null");
            return (Criteria) this;
        }

        public Criteria andMountsIsNotNull() {
            addCriterion("mounts is not null");
            return (Criteria) this;
        }

        public Criteria andMountsEqualTo(String value) {
            addCriterion("mounts =", value, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsNotEqualTo(String value) {
            addCriterion("mounts <>", value, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsGreaterThan(String value) {
            addCriterion("mounts >", value, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsGreaterThanOrEqualTo(String value) {
            addCriterion("mounts >=", value, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsLessThan(String value) {
            addCriterion("mounts <", value, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsLessThanOrEqualTo(String value) {
            addCriterion("mounts <=", value, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsLike(String value) {
            addCriterion("mounts like", value, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsNotLike(String value) {
            addCriterion("mounts not like", value, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsIn(List<String> values) {
            addCriterion("mounts in", values, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsNotIn(List<String> values) {
            addCriterion("mounts not in", values, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsBetween(String value1, String value2) {
            addCriterion("mounts between", value1, value2, "mounts");
            return (Criteria) this;
        }

        public Criteria andMountsNotBetween(String value1, String value2) {
            addCriterion("mounts not between", value1, value2, "mounts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsIsNull() {
            addCriterion("exposed_ports is null");
            return (Criteria) this;
        }

        public Criteria andExposedPortsIsNotNull() {
            addCriterion("exposed_ports is not null");
            return (Criteria) this;
        }

        public Criteria andExposedPortsEqualTo(String value) {
            addCriterion("exposed_ports =", value, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsNotEqualTo(String value) {
            addCriterion("exposed_ports <>", value, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsGreaterThan(String value) {
            addCriterion("exposed_ports >", value, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsGreaterThanOrEqualTo(String value) {
            addCriterion("exposed_ports >=", value, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsLessThan(String value) {
            addCriterion("exposed_ports <", value, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsLessThanOrEqualTo(String value) {
            addCriterion("exposed_ports <=", value, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsLike(String value) {
            addCriterion("exposed_ports like", value, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsNotLike(String value) {
            addCriterion("exposed_ports not like", value, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsIn(List<String> values) {
            addCriterion("exposed_ports in", values, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsNotIn(List<String> values) {
            addCriterion("exposed_ports not in", values, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsBetween(String value1, String value2) {
            addCriterion("exposed_ports between", value1, value2, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andExposedPortsNotBetween(String value1, String value2) {
            addCriterion("exposed_ports not between", value1, value2, "exposedPorts");
            return (Criteria) this;
        }

        public Criteria andPortsIsNull() {
            addCriterion("ports is null");
            return (Criteria) this;
        }

        public Criteria andPortsIsNotNull() {
            addCriterion("ports is not null");
            return (Criteria) this;
        }

        public Criteria andPortsEqualTo(String value) {
            addCriterion("ports =", value, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsNotEqualTo(String value) {
            addCriterion("ports <>", value, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsGreaterThan(String value) {
            addCriterion("ports >", value, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsGreaterThanOrEqualTo(String value) {
            addCriterion("ports >=", value, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsLessThan(String value) {
            addCriterion("ports <", value, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsLessThanOrEqualTo(String value) {
            addCriterion("ports <=", value, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsLike(String value) {
            addCriterion("ports like", value, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsNotLike(String value) {
            addCriterion("ports not like", value, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsIn(List<String> values) {
            addCriterion("ports in", values, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsNotIn(List<String> values) {
            addCriterion("ports not in", values, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsBetween(String value1, String value2) {
            addCriterion("ports between", value1, value2, "ports");
            return (Criteria) this;
        }

        public Criteria andPortsNotBetween(String value1, String value2) {
            addCriterion("ports not between", value1, value2, "ports");
            return (Criteria) this;
        }

        public Criteria andEntrypointIsNull() {
            addCriterion("entrypoint is null");
            return (Criteria) this;
        }

        public Criteria andEntrypointIsNotNull() {
            addCriterion("entrypoint is not null");
            return (Criteria) this;
        }

        public Criteria andEntrypointEqualTo(String value) {
            addCriterion("entrypoint =", value, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointNotEqualTo(String value) {
            addCriterion("entrypoint <>", value, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointGreaterThan(String value) {
            addCriterion("entrypoint >", value, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointGreaterThanOrEqualTo(String value) {
            addCriterion("entrypoint >=", value, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointLessThan(String value) {
            addCriterion("entrypoint <", value, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointLessThanOrEqualTo(String value) {
            addCriterion("entrypoint <=", value, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointLike(String value) {
            addCriterion("entrypoint like", value, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointNotLike(String value) {
            addCriterion("entrypoint not like", value, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointIn(List<String> values) {
            addCriterion("entrypoint in", values, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointNotIn(List<String> values) {
            addCriterion("entrypoint not in", values, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointBetween(String value1, String value2) {
            addCriterion("entrypoint between", value1, value2, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andEntrypointNotBetween(String value1, String value2) {
            addCriterion("entrypoint not between", value1, value2, "entrypoint");
            return (Criteria) this;
        }

        public Criteria andCmdIsNull() {
            addCriterion("cmd is null");
            return (Criteria) this;
        }

        public Criteria andCmdIsNotNull() {
            addCriterion("cmd is not null");
            return (Criteria) this;
        }

        public Criteria andCmdEqualTo(String value) {
            addCriterion("cmd =", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotEqualTo(String value) {
            addCriterion("cmd <>", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdGreaterThan(String value) {
            addCriterion("cmd >", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdGreaterThanOrEqualTo(String value) {
            addCriterion("cmd >=", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdLessThan(String value) {
            addCriterion("cmd <", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdLessThanOrEqualTo(String value) {
            addCriterion("cmd <=", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdLike(String value) {
            addCriterion("cmd like", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotLike(String value) {
            addCriterion("cmd not like", value, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdIn(List<String> values) {
            addCriterion("cmd in", values, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotIn(List<String> values) {
            addCriterion("cmd not in", values, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdBetween(String value1, String value2) {
            addCriterion("cmd between", value1, value2, "cmd");
            return (Criteria) this;
        }

        public Criteria andCmdNotBetween(String value1, String value2) {
            addCriterion("cmd not between", value1, value2, "cmd");
            return (Criteria) this;
        }

        public Criteria andDomainNameIsNull() {
            addCriterion("domain_name is null");
            return (Criteria) this;
        }

        public Criteria andDomainNameIsNotNull() {
            addCriterion("domain_name is not null");
            return (Criteria) this;
        }

        public Criteria andDomainNameEqualTo(String value) {
            addCriterion("domain_name =", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotEqualTo(String value) {
            addCriterion("domain_name <>", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameGreaterThan(String value) {
            addCriterion("domain_name >", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameGreaterThanOrEqualTo(String value) {
            addCriterion("domain_name >=", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameLessThan(String value) {
            addCriterion("domain_name <", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameLessThanOrEqualTo(String value) {
            addCriterion("domain_name <=", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameLike(String value) {
            addCriterion("domain_name like", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotLike(String value) {
            addCriterion("domain_name not like", value, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameIn(List<String> values) {
            addCriterion("domain_name in", values, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotIn(List<String> values) {
            addCriterion("domain_name not in", values, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameBetween(String value1, String value2) {
            addCriterion("domain_name between", value1, value2, "domainName");
            return (Criteria) this;
        }

        public Criteria andDomainNameNotBetween(String value1, String value2) {
            addCriterion("domain_name not between", value1, value2, "domainName");
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

        public Criteria andIpAddressIsNull() {
            addCriterion("ip_address is null");
            return (Criteria) this;
        }

        public Criteria andIpAddressIsNotNull() {
            addCriterion("ip_address is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddressEqualTo(String value) {
            addCriterion("ip_address =", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotEqualTo(String value) {
            addCriterion("ip_address <>", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThan(String value) {
            addCriterion("ip_address >", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ip_address >=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThan(String value) {
            addCriterion("ip_address <", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLessThanOrEqualTo(String value) {
            addCriterion("ip_address <=", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressLike(String value) {
            addCriterion("ip_address like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotLike(String value) {
            addCriterion("ip_address not like", value, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressIn(List<String> values) {
            addCriterion("ip_address in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotIn(List<String> values) {
            addCriterion("ip_address not in", values, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressBetween(String value1, String value2) {
            addCriterion("ip_address between", value1, value2, "ipAddress");
            return (Criteria) this;
        }

        public Criteria andIpAddressNotBetween(String value1, String value2) {
            addCriterion("ip_address not between", value1, value2, "ipAddress");
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

        public Criteria andExitCodeIsNull() {
            addCriterion("exit_code is null");
            return (Criteria) this;
        }

        public Criteria andExitCodeIsNotNull() {
            addCriterion("exit_code is not null");
            return (Criteria) this;
        }

        public Criteria andExitCodeEqualTo(String value) {
            addCriterion("exit_code =", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotEqualTo(String value) {
            addCriterion("exit_code <>", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeGreaterThan(String value) {
            addCriterion("exit_code >", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("exit_code >=", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeLessThan(String value) {
            addCriterion("exit_code <", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeLessThanOrEqualTo(String value) {
            addCriterion("exit_code <=", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeLike(String value) {
            addCriterion("exit_code like", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotLike(String value) {
            addCriterion("exit_code not like", value, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeIn(List<String> values) {
            addCriterion("exit_code in", values, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotIn(List<String> values) {
            addCriterion("exit_code not in", values, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeBetween(String value1, String value2) {
            addCriterion("exit_code between", value1, value2, "exitCode");
            return (Criteria) this;
        }

        public Criteria andExitCodeNotBetween(String value1, String value2) {
            addCriterion("exit_code not between", value1, value2, "exitCode");
            return (Criteria) this;
        }

        public Criteria andErrorIsNull() {
            addCriterion("error is null");
            return (Criteria) this;
        }

        public Criteria andErrorIsNotNull() {
            addCriterion("error is not null");
            return (Criteria) this;
        }

        public Criteria andErrorEqualTo(String value) {
            addCriterion("error =", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorNotEqualTo(String value) {
            addCriterion("error <>", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorGreaterThan(String value) {
            addCriterion("error >", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorGreaterThanOrEqualTo(String value) {
            addCriterion("error >=", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorLessThan(String value) {
            addCriterion("error <", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorLessThanOrEqualTo(String value) {
            addCriterion("error <=", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorLike(String value) {
            addCriterion("error like", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorNotLike(String value) {
            addCriterion("error not like", value, "error");
            return (Criteria) this;
        }

        public Criteria andErrorIn(List<String> values) {
            addCriterion("error in", values, "error");
            return (Criteria) this;
        }

        public Criteria andErrorNotIn(List<String> values) {
            addCriterion("error not in", values, "error");
            return (Criteria) this;
        }

        public Criteria andErrorBetween(String value1, String value2) {
            addCriterion("error between", value1, value2, "error");
            return (Criteria) this;
        }

        public Criteria andErrorNotBetween(String value1, String value2) {
            addCriterion("error not between", value1, value2, "error");
            return (Criteria) this;
        }

        public Criteria andConDetailIsNull() {
            addCriterion("con_detail is null");
            return (Criteria) this;
        }

        public Criteria andConDetailIsNotNull() {
            addCriterion("con_detail is not null");
            return (Criteria) this;
        }

        public Criteria andConDetailEqualTo(String value) {
            addCriterion("con_detail =", value, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailNotEqualTo(String value) {
            addCriterion("con_detail <>", value, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailGreaterThan(String value) {
            addCriterion("con_detail >", value, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailGreaterThanOrEqualTo(String value) {
            addCriterion("con_detail >=", value, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailLessThan(String value) {
            addCriterion("con_detail <", value, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailLessThanOrEqualTo(String value) {
            addCriterion("con_detail <=", value, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailLike(String value) {
            addCriterion("con_detail like", value, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailNotLike(String value) {
            addCriterion("con_detail not like", value, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailIn(List<String> values) {
            addCriterion("con_detail in", values, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailNotIn(List<String> values) {
            addCriterion("con_detail not in", values, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailBetween(String value1, String value2) {
            addCriterion("con_detail between", value1, value2, "conDetail");
            return (Criteria) this;
        }

        public Criteria andConDetailNotBetween(String value1, String value2) {
            addCriterion("con_detail not between", value1, value2, "conDetail");
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

        public Criteria andDnsIsNull() {
            addCriterion("dns is null");
            return (Criteria) this;
        }

        public Criteria andDnsIsNotNull() {
            addCriterion("dns is not null");
            return (Criteria) this;
        }

        public Criteria andDnsEqualTo(String value) {
            addCriterion("dns =", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotEqualTo(String value) {
            addCriterion("dns <>", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsGreaterThan(String value) {
            addCriterion("dns >", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsGreaterThanOrEqualTo(String value) {
            addCriterion("dns >=", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLessThan(String value) {
            addCriterion("dns <", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLessThanOrEqualTo(String value) {
            addCriterion("dns <=", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLike(String value) {
            addCriterion("dns like", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotLike(String value) {
            addCriterion("dns not like", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsIn(List<String> values) {
            addCriterion("dns in", values, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotIn(List<String> values) {
            addCriterion("dns not in", values, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsBetween(String value1, String value2) {
            addCriterion("dns between", value1, value2, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotBetween(String value1, String value2) {
            addCriterion("dns not between", value1, value2, "dns");
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