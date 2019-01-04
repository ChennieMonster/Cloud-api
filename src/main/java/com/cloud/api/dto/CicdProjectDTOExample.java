package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CicdProjectDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CicdProjectDTOExample() {
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

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(String value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(String value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(String value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(String value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(String value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(String value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLike(String value) {
            addCriterion("job_id like", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotLike(String value) {
            addCriterion("job_id not like", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<String> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<String> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(String value1, String value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(String value1, String value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andGitUrlIsNull() {
            addCriterion("git_url is null");
            return (Criteria) this;
        }

        public Criteria andGitUrlIsNotNull() {
            addCriterion("git_url is not null");
            return (Criteria) this;
        }

        public Criteria andGitUrlEqualTo(String value) {
            addCriterion("git_url =", value, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlNotEqualTo(String value) {
            addCriterion("git_url <>", value, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlGreaterThan(String value) {
            addCriterion("git_url >", value, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlGreaterThanOrEqualTo(String value) {
            addCriterion("git_url >=", value, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlLessThan(String value) {
            addCriterion("git_url <", value, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlLessThanOrEqualTo(String value) {
            addCriterion("git_url <=", value, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlLike(String value) {
            addCriterion("git_url like", value, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlNotLike(String value) {
            addCriterion("git_url not like", value, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlIn(List<String> values) {
            addCriterion("git_url in", values, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlNotIn(List<String> values) {
            addCriterion("git_url not in", values, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlBetween(String value1, String value2) {
            addCriterion("git_url between", value1, value2, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUrlNotBetween(String value1, String value2) {
            addCriterion("git_url not between", value1, value2, "gitUrl");
            return (Criteria) this;
        }

        public Criteria andGitUsernameIsNull() {
            addCriterion("git_username is null");
            return (Criteria) this;
        }

        public Criteria andGitUsernameIsNotNull() {
            addCriterion("git_username is not null");
            return (Criteria) this;
        }

        public Criteria andGitUsernameEqualTo(String value) {
            addCriterion("git_username =", value, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameNotEqualTo(String value) {
            addCriterion("git_username <>", value, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameGreaterThan(String value) {
            addCriterion("git_username >", value, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("git_username >=", value, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameLessThan(String value) {
            addCriterion("git_username <", value, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameLessThanOrEqualTo(String value) {
            addCriterion("git_username <=", value, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameLike(String value) {
            addCriterion("git_username like", value, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameNotLike(String value) {
            addCriterion("git_username not like", value, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameIn(List<String> values) {
            addCriterion("git_username in", values, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameNotIn(List<String> values) {
            addCriterion("git_username not in", values, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameBetween(String value1, String value2) {
            addCriterion("git_username between", value1, value2, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitUsernameNotBetween(String value1, String value2) {
            addCriterion("git_username not between", value1, value2, "gitUsername");
            return (Criteria) this;
        }

        public Criteria andGitPasswordIsNull() {
            addCriterion("git_password is null");
            return (Criteria) this;
        }

        public Criteria andGitPasswordIsNotNull() {
            addCriterion("git_password is not null");
            return (Criteria) this;
        }

        public Criteria andGitPasswordEqualTo(String value) {
            addCriterion("git_password =", value, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordNotEqualTo(String value) {
            addCriterion("git_password <>", value, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordGreaterThan(String value) {
            addCriterion("git_password >", value, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("git_password >=", value, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordLessThan(String value) {
            addCriterion("git_password <", value, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordLessThanOrEqualTo(String value) {
            addCriterion("git_password <=", value, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordLike(String value) {
            addCriterion("git_password like", value, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordNotLike(String value) {
            addCriterion("git_password not like", value, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordIn(List<String> values) {
            addCriterion("git_password in", values, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordNotIn(List<String> values) {
            addCriterion("git_password not in", values, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordBetween(String value1, String value2) {
            addCriterion("git_password between", value1, value2, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andGitPasswordNotBetween(String value1, String value2) {
            addCriterion("git_password not between", value1, value2, "gitPassword");
            return (Criteria) this;
        }

        public Criteria andServicePortIsNull() {
            addCriterion("service_port is null");
            return (Criteria) this;
        }

        public Criteria andServicePortIsNotNull() {
            addCriterion("service_port is not null");
            return (Criteria) this;
        }

        public Criteria andServicePortEqualTo(Integer value) {
            addCriterion("service_port =", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotEqualTo(Integer value) {
            addCriterion("service_port <>", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortGreaterThan(Integer value) {
            addCriterion("service_port >", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_port >=", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLessThan(Integer value) {
            addCriterion("service_port <", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLessThanOrEqualTo(Integer value) {
            addCriterion("service_port <=", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortIn(List<Integer> values) {
            addCriterion("service_port in", values, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotIn(List<Integer> values) {
            addCriterion("service_port not in", values, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortBetween(Integer value1, Integer value2) {
            addCriterion("service_port between", value1, value2, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotBetween(Integer value1, Integer value2) {
            addCriterion("service_port not between", value1, value2, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisIsNull() {
            addCriterion("code_analysis is null");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisIsNotNull() {
            addCriterion("code_analysis is not null");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisEqualTo(Integer value) {
            addCriterion("code_analysis =", value, "codeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisNotEqualTo(Integer value) {
            addCriterion("code_analysis <>", value, "codeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisGreaterThan(Integer value) {
            addCriterion("code_analysis >", value, "codeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisGreaterThanOrEqualTo(Integer value) {
            addCriterion("code_analysis >=", value, "codeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisLessThan(Integer value) {
            addCriterion("code_analysis <", value, "codeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisLessThanOrEqualTo(Integer value) {
            addCriterion("code_analysis <=", value, "codeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisIn(List<Integer> values) {
            addCriterion("code_analysis in", values, "codeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisNotIn(List<Integer> values) {
            addCriterion("code_analysis not in", values, "codeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisBetween(Integer value1, Integer value2) {
            addCriterion("code_analysis between", value1, value2, "codeAnalysis");
            return (Criteria) this;
        }

        public Criteria andCodeAnalysisNotBetween(Integer value1, Integer value2) {
            addCriterion("code_analysis not between", value1, value2, "codeAnalysis");
            return (Criteria) this;
        }

        public Criteria andUnitTestIsNull() {
            addCriterion("unit_test is null");
            return (Criteria) this;
        }

        public Criteria andUnitTestIsNotNull() {
            addCriterion("unit_test is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTestEqualTo(Integer value) {
            addCriterion("unit_test =", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestNotEqualTo(Integer value) {
            addCriterion("unit_test <>", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestGreaterThan(Integer value) {
            addCriterion("unit_test >", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_test >=", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestLessThan(Integer value) {
            addCriterion("unit_test <", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestLessThanOrEqualTo(Integer value) {
            addCriterion("unit_test <=", value, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestIn(List<Integer> values) {
            addCriterion("unit_test in", values, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestNotIn(List<Integer> values) {
            addCriterion("unit_test not in", values, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestBetween(Integer value1, Integer value2) {
            addCriterion("unit_test between", value1, value2, "unitTest");
            return (Criteria) this;
        }

        public Criteria andUnitTestNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_test not between", value1, value2, "unitTest");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestIsNull() {
            addCriterion("integration_test is null");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestIsNotNull() {
            addCriterion("integration_test is not null");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestEqualTo(Integer value) {
            addCriterion("integration_test =", value, "integrationTest");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestNotEqualTo(Integer value) {
            addCriterion("integration_test <>", value, "integrationTest");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestGreaterThan(Integer value) {
            addCriterion("integration_test >", value, "integrationTest");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestGreaterThanOrEqualTo(Integer value) {
            addCriterion("integration_test >=", value, "integrationTest");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestLessThan(Integer value) {
            addCriterion("integration_test <", value, "integrationTest");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestLessThanOrEqualTo(Integer value) {
            addCriterion("integration_test <=", value, "integrationTest");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestIn(List<Integer> values) {
            addCriterion("integration_test in", values, "integrationTest");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestNotIn(List<Integer> values) {
            addCriterion("integration_test not in", values, "integrationTest");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestBetween(Integer value1, Integer value2) {
            addCriterion("integration_test between", value1, value2, "integrationTest");
            return (Criteria) this;
        }

        public Criteria andIntegrationTestNotBetween(Integer value1, Integer value2) {
            addCriterion("integration_test not between", value1, value2, "integrationTest");
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

        public Criteria andApiUrlIsNull() {
            addCriterion("api_url is null");
            return (Criteria) this;
        }

        public Criteria andApiUrlIsNotNull() {
            addCriterion("api_url is not null");
            return (Criteria) this;
        }

        public Criteria andApiUrlEqualTo(String value) {
            addCriterion("api_url =", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotEqualTo(String value) {
            addCriterion("api_url <>", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlGreaterThan(String value) {
            addCriterion("api_url >", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlGreaterThanOrEqualTo(String value) {
            addCriterion("api_url >=", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLessThan(String value) {
            addCriterion("api_url <", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLessThanOrEqualTo(String value) {
            addCriterion("api_url <=", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLike(String value) {
            addCriterion("api_url like", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotLike(String value) {
            addCriterion("api_url not like", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlIn(List<String> values) {
            addCriterion("api_url in", values, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotIn(List<String> values) {
            addCriterion("api_url not in", values, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlBetween(String value1, String value2) {
            addCriterion("api_url between", value1, value2, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotBetween(String value1, String value2) {
            addCriterion("api_url not between", value1, value2, "apiUrl");
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