package com.cloud.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceDTOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceDTOExample() {
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

        public Criteria andInstanceIdIsNull() {
            addCriterion("instance_id is null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIsNotNull() {
            addCriterion("instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdEqualTo(String value) {
            addCriterion("instance_id =", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotEqualTo(String value) {
            addCriterion("instance_id <>", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThan(String value) {
            addCriterion("instance_id >", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThanOrEqualTo(String value) {
            addCriterion("instance_id >=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThan(String value) {
            addCriterion("instance_id <", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThanOrEqualTo(String value) {
            addCriterion("instance_id <=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLike(String value) {
            addCriterion("instance_id like", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotLike(String value) {
            addCriterion("instance_id not like", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIn(List<String> values) {
            addCriterion("instance_id in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotIn(List<String> values) {
            addCriterion("instance_id not in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdBetween(String value1, String value2) {
            addCriterion("instance_id between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotBetween(String value1, String value2) {
            addCriterion("instance_id not between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andProtocolIsNull() {
            addCriterion("protocol is null");
            return (Criteria) this;
        }

        public Criteria andProtocolIsNotNull() {
            addCriterion("protocol is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolEqualTo(String value) {
            addCriterion("protocol =", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotEqualTo(String value) {
            addCriterion("protocol <>", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolGreaterThan(String value) {
            addCriterion("protocol >", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolGreaterThanOrEqualTo(String value) {
            addCriterion("protocol >=", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolLessThan(String value) {
            addCriterion("protocol <", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolLessThanOrEqualTo(String value) {
            addCriterion("protocol <=", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolLike(String value) {
            addCriterion("protocol like", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotLike(String value) {
            addCriterion("protocol not like", value, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolIn(List<String> values) {
            addCriterion("protocol in", values, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotIn(List<String> values) {
            addCriterion("protocol not in", values, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolBetween(String value1, String value2) {
            addCriterion("protocol between", value1, value2, "protocol");
            return (Criteria) this;
        }

        public Criteria andProtocolNotBetween(String value1, String value2) {
            addCriterion("protocol not between", value1, value2, "protocol");
            return (Criteria) this;
        }

        public Criteria andContainerPortIsNull() {
            addCriterion("container_port is null");
            return (Criteria) this;
        }

        public Criteria andContainerPortIsNotNull() {
            addCriterion("container_port is not null");
            return (Criteria) this;
        }

        public Criteria andContainerPortEqualTo(String value) {
            addCriterion("container_port =", value, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortNotEqualTo(String value) {
            addCriterion("container_port <>", value, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortGreaterThan(String value) {
            addCriterion("container_port >", value, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortGreaterThanOrEqualTo(String value) {
            addCriterion("container_port >=", value, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortLessThan(String value) {
            addCriterion("container_port <", value, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortLessThanOrEqualTo(String value) {
            addCriterion("container_port <=", value, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortLike(String value) {
            addCriterion("container_port like", value, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortNotLike(String value) {
            addCriterion("container_port not like", value, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortIn(List<String> values) {
            addCriterion("container_port in", values, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortNotIn(List<String> values) {
            addCriterion("container_port not in", values, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortBetween(String value1, String value2) {
            addCriterion("container_port between", value1, value2, "containerPort");
            return (Criteria) this;
        }

        public Criteria andContainerPortNotBetween(String value1, String value2) {
            addCriterion("container_port not between", value1, value2, "containerPort");
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

        public Criteria andServicePortEqualTo(String value) {
            addCriterion("service_port =", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotEqualTo(String value) {
            addCriterion("service_port <>", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortGreaterThan(String value) {
            addCriterion("service_port >", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortGreaterThanOrEqualTo(String value) {
            addCriterion("service_port >=", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLessThan(String value) {
            addCriterion("service_port <", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLessThanOrEqualTo(String value) {
            addCriterion("service_port <=", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLike(String value) {
            addCriterion("service_port like", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotLike(String value) {
            addCriterion("service_port not like", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortIn(List<String> values) {
            addCriterion("service_port in", values, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotIn(List<String> values) {
            addCriterion("service_port not in", values, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortBetween(String value1, String value2) {
            addCriterion("service_port between", value1, value2, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotBetween(String value1, String value2) {
            addCriterion("service_port not between", value1, value2, "servicePort");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andTargetPortIsNull() {
            addCriterion("target_port is null");
            return (Criteria) this;
        }

        public Criteria andTargetPortIsNotNull() {
            addCriterion("target_port is not null");
            return (Criteria) this;
        }

        public Criteria andTargetPortEqualTo(String value) {
            addCriterion("target_port =", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortNotEqualTo(String value) {
            addCriterion("target_port <>", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortGreaterThan(String value) {
            addCriterion("target_port >", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortGreaterThanOrEqualTo(String value) {
            addCriterion("target_port >=", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortLessThan(String value) {
            addCriterion("target_port <", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortLessThanOrEqualTo(String value) {
            addCriterion("target_port <=", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortLike(String value) {
            addCriterion("target_port like", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortNotLike(String value) {
            addCriterion("target_port not like", value, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortIn(List<String> values) {
            addCriterion("target_port in", values, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortNotIn(List<String> values) {
            addCriterion("target_port not in", values, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortBetween(String value1, String value2) {
            addCriterion("target_port between", value1, value2, "targetPort");
            return (Criteria) this;
        }

        public Criteria andTargetPortNotBetween(String value1, String value2) {
            addCriterion("target_port not between", value1, value2, "targetPort");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityIsNull() {
            addCriterion("session_affinity is null");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityIsNotNull() {
            addCriterion("session_affinity is not null");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityEqualTo(String value) {
            addCriterion("session_affinity =", value, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityNotEqualTo(String value) {
            addCriterion("session_affinity <>", value, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityGreaterThan(String value) {
            addCriterion("session_affinity >", value, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityGreaterThanOrEqualTo(String value) {
            addCriterion("session_affinity >=", value, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityLessThan(String value) {
            addCriterion("session_affinity <", value, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityLessThanOrEqualTo(String value) {
            addCriterion("session_affinity <=", value, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityLike(String value) {
            addCriterion("session_affinity like", value, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityNotLike(String value) {
            addCriterion("session_affinity not like", value, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityIn(List<String> values) {
            addCriterion("session_affinity in", values, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityNotIn(List<String> values) {
            addCriterion("session_affinity not in", values, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityBetween(String value1, String value2) {
            addCriterion("session_affinity between", value1, value2, "sessionAffinity");
            return (Criteria) this;
        }

        public Criteria andSessionAffinityNotBetween(String value1, String value2) {
            addCriterion("session_affinity not between", value1, value2, "sessionAffinity");
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

        public Criteria andKindIsNull() {
            addCriterion("kind is null");
            return (Criteria) this;
        }

        public Criteria andKindIsNotNull() {
            addCriterion("kind is not null");
            return (Criteria) this;
        }

        public Criteria andKindEqualTo(String value) {
            addCriterion("kind =", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotEqualTo(String value) {
            addCriterion("kind <>", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThan(String value) {
            addCriterion("kind >", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindGreaterThanOrEqualTo(String value) {
            addCriterion("kind >=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThan(String value) {
            addCriterion("kind <", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLessThanOrEqualTo(String value) {
            addCriterion("kind <=", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindLike(String value) {
            addCriterion("kind like", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotLike(String value) {
            addCriterion("kind not like", value, "kind");
            return (Criteria) this;
        }

        public Criteria andKindIn(List<String> values) {
            addCriterion("kind in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotIn(List<String> values) {
            addCriterion("kind not in", values, "kind");
            return (Criteria) this;
        }

        public Criteria andKindBetween(String value1, String value2) {
            addCriterion("kind between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andKindNotBetween(String value1, String value2) {
            addCriterion("kind not between", value1, value2, "kind");
            return (Criteria) this;
        }

        public Criteria andMetadataIsNull() {
            addCriterion("metadata is null");
            return (Criteria) this;
        }

        public Criteria andMetadataIsNotNull() {
            addCriterion("metadata is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataEqualTo(String value) {
            addCriterion("metadata =", value, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataNotEqualTo(String value) {
            addCriterion("metadata <>", value, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataGreaterThan(String value) {
            addCriterion("metadata >", value, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataGreaterThanOrEqualTo(String value) {
            addCriterion("metadata >=", value, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataLessThan(String value) {
            addCriterion("metadata <", value, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataLessThanOrEqualTo(String value) {
            addCriterion("metadata <=", value, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataLike(String value) {
            addCriterion("metadata like", value, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataNotLike(String value) {
            addCriterion("metadata not like", value, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataIn(List<String> values) {
            addCriterion("metadata in", values, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataNotIn(List<String> values) {
            addCriterion("metadata not in", values, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataBetween(String value1, String value2) {
            addCriterion("metadata between", value1, value2, "metadata");
            return (Criteria) this;
        }

        public Criteria andMetadataNotBetween(String value1, String value2) {
            addCriterion("metadata not between", value1, value2, "metadata");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("spec is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("spec =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("spec <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("spec >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("spec >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("spec <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("spec <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLike(String value) {
            addCriterion("spec like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("spec not like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<String> values) {
            addCriterion("spec in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<String> values) {
            addCriterion("spec not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("spec between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("spec not between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andApiVersionIsNull() {
            addCriterion("api_version is null");
            return (Criteria) this;
        }

        public Criteria andApiVersionIsNotNull() {
            addCriterion("api_version is not null");
            return (Criteria) this;
        }

        public Criteria andApiVersionEqualTo(String value) {
            addCriterion("api_version =", value, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionNotEqualTo(String value) {
            addCriterion("api_version <>", value, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionGreaterThan(String value) {
            addCriterion("api_version >", value, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionGreaterThanOrEqualTo(String value) {
            addCriterion("api_version >=", value, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionLessThan(String value) {
            addCriterion("api_version <", value, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionLessThanOrEqualTo(String value) {
            addCriterion("api_version <=", value, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionLike(String value) {
            addCriterion("api_version like", value, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionNotLike(String value) {
            addCriterion("api_version not like", value, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionIn(List<String> values) {
            addCriterion("api_version in", values, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionNotIn(List<String> values) {
            addCriterion("api_version not in", values, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionBetween(String value1, String value2) {
            addCriterion("api_version between", value1, value2, "apiVersion");
            return (Criteria) this;
        }

        public Criteria andApiVersionNotBetween(String value1, String value2) {
            addCriterion("api_version not between", value1, value2, "apiVersion");
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

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("project not between", value1, value2, "project");
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