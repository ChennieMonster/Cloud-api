package com.cloud.api.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class QuotaDTOExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public QuotaDTOExample() {
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

		public Criteria andRegionIdIsNull() {
			addCriterion("region_id is null");
			return (Criteria) this;
		}

		public Criteria andRegionIdIsNotNull() {
			addCriterion("region_id is not null");
			return (Criteria) this;
		}

		public Criteria andRegionIdEqualTo(String value) {
			addCriterion("region_id =", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdNotEqualTo(String value) {
			addCriterion("region_id <>", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdGreaterThan(String value) {
			addCriterion("region_id >", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdGreaterThanOrEqualTo(String value) {
			addCriterion("region_id >=", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdLessThan(String value) {
			addCriterion("region_id <", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdLessThanOrEqualTo(String value) {
			addCriterion("region_id <=", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdLike(String value) {
			addCriterion("region_id like", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdNotLike(String value) {
			addCriterion("region_id not like", value, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdIn(List<String> values) {
			addCriterion("region_id in", values, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdNotIn(List<String> values) {
			addCriterion("region_id not in", values, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdBetween(String value1, String value2) {
			addCriterion("region_id between", value1, value2, "regionId");
			return (Criteria) this;
		}

		public Criteria andRegionIdNotBetween(String value1, String value2) {
			addCriterion("region_id not between", value1, value2, "regionId");
			return (Criteria) this;
		}

		public Criteria andCpuTotalIsNull() {
			addCriterion("cpu_total is null");
			return (Criteria) this;
		}

		public Criteria andCpuTotalIsNotNull() {
			addCriterion("cpu_total is not null");
			return (Criteria) this;
		}

		public Criteria andCpuTotalEqualTo(BigDecimal value) {
			addCriterion("cpu_total =", value, "cpuTotal");
			return (Criteria) this;
		}

		public Criteria andCpuTotalNotEqualTo(BigDecimal value) {
			addCriterion("cpu_total <>", value, "cpuTotal");
			return (Criteria) this;
		}

		public Criteria andCpuTotalGreaterThan(BigDecimal value) {
			addCriterion("cpu_total >", value, "cpuTotal");
			return (Criteria) this;
		}

		public Criteria andCpuTotalGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("cpu_total >=", value, "cpuTotal");
			return (Criteria) this;
		}

		public Criteria andCpuTotalLessThan(BigDecimal value) {
			addCriterion("cpu_total <", value, "cpuTotal");
			return (Criteria) this;
		}

		public Criteria andCpuTotalLessThanOrEqualTo(BigDecimal value) {
			addCriterion("cpu_total <=", value, "cpuTotal");
			return (Criteria) this;
		}

		public Criteria andCpuTotalIn(List<BigDecimal> values) {
			addCriterion("cpu_total in", values, "cpuTotal");
			return (Criteria) this;
		}

		public Criteria andCpuTotalNotIn(List<BigDecimal> values) {
			addCriterion("cpu_total not in", values, "cpuTotal");
			return (Criteria) this;
		}

		public Criteria andCpuTotalBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cpu_total between", value1, value2, "cpuTotal");
			return (Criteria) this;
		}

		public Criteria andCpuTotalNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cpu_total not between", value1, value2, "cpuTotal");
			return (Criteria) this;
		}

		public Criteria andCpuUsedIsNull() {
			addCriterion("cpu_used is null");
			return (Criteria) this;
		}

		public Criteria andCpuUsedIsNotNull() {
			addCriterion("cpu_used is not null");
			return (Criteria) this;
		}

		public Criteria andCpuUsedEqualTo(BigDecimal value) {
			addCriterion("cpu_used =", value, "cpuUsed");
			return (Criteria) this;
		}

		public Criteria andCpuUsedNotEqualTo(BigDecimal value) {
			addCriterion("cpu_used <>", value, "cpuUsed");
			return (Criteria) this;
		}

		public Criteria andCpuUsedGreaterThan(BigDecimal value) {
			addCriterion("cpu_used >", value, "cpuUsed");
			return (Criteria) this;
		}

		public Criteria andCpuUsedGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("cpu_used >=", value, "cpuUsed");
			return (Criteria) this;
		}

		public Criteria andCpuUsedLessThan(BigDecimal value) {
			addCriterion("cpu_used <", value, "cpuUsed");
			return (Criteria) this;
		}

		public Criteria andCpuUsedLessThanOrEqualTo(BigDecimal value) {
			addCriterion("cpu_used <=", value, "cpuUsed");
			return (Criteria) this;
		}

		public Criteria andCpuUsedIn(List<BigDecimal> values) {
			addCriterion("cpu_used in", values, "cpuUsed");
			return (Criteria) this;
		}

		public Criteria andCpuUsedNotIn(List<BigDecimal> values) {
			addCriterion("cpu_used not in", values, "cpuUsed");
			return (Criteria) this;
		}

		public Criteria andCpuUsedBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cpu_used between", value1, value2, "cpuUsed");
			return (Criteria) this;
		}

		public Criteria andCpuUsedNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cpu_used not between", value1, value2, "cpuUsed");
			return (Criteria) this;
		}

		public Criteria andCpuRestIsNull() {
			addCriterion("cpu_rest is null");
			return (Criteria) this;
		}

		public Criteria andCpuRestIsNotNull() {
			addCriterion("cpu_rest is not null");
			return (Criteria) this;
		}

		public Criteria andCpuRestEqualTo(BigDecimal value) {
			addCriterion("cpu_rest =", value, "cpuRest");
			return (Criteria) this;
		}

		public Criteria andCpuRestNotEqualTo(BigDecimal value) {
			addCriterion("cpu_rest <>", value, "cpuRest");
			return (Criteria) this;
		}

		public Criteria andCpuRestGreaterThan(BigDecimal value) {
			addCriterion("cpu_rest >", value, "cpuRest");
			return (Criteria) this;
		}

		public Criteria andCpuRestGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("cpu_rest >=", value, "cpuRest");
			return (Criteria) this;
		}

		public Criteria andCpuRestLessThan(BigDecimal value) {
			addCriterion("cpu_rest <", value, "cpuRest");
			return (Criteria) this;
		}

		public Criteria andCpuRestLessThanOrEqualTo(BigDecimal value) {
			addCriterion("cpu_rest <=", value, "cpuRest");
			return (Criteria) this;
		}

		public Criteria andCpuRestIn(List<BigDecimal> values) {
			addCriterion("cpu_rest in", values, "cpuRest");
			return (Criteria) this;
		}

		public Criteria andCpuRestNotIn(List<BigDecimal> values) {
			addCriterion("cpu_rest not in", values, "cpuRest");
			return (Criteria) this;
		}

		public Criteria andCpuRestBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cpu_rest between", value1, value2, "cpuRest");
			return (Criteria) this;
		}

		public Criteria andCpuRestNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("cpu_rest not between", value1, value2, "cpuRest");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalIsNull() {
			addCriterion("memory_total is null");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalIsNotNull() {
			addCriterion("memory_total is not null");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalEqualTo(BigDecimal value) {
			addCriterion("memory_total =", value, "memoryTotal");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalNotEqualTo(BigDecimal value) {
			addCriterion("memory_total <>", value, "memoryTotal");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalGreaterThan(BigDecimal value) {
			addCriterion("memory_total >", value, "memoryTotal");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("memory_total >=", value, "memoryTotal");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalLessThan(BigDecimal value) {
			addCriterion("memory_total <", value, "memoryTotal");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalLessThanOrEqualTo(BigDecimal value) {
			addCriterion("memory_total <=", value, "memoryTotal");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalIn(List<BigDecimal> values) {
			addCriterion("memory_total in", values, "memoryTotal");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalNotIn(List<BigDecimal> values) {
			addCriterion("memory_total not in", values, "memoryTotal");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("memory_total between", value1, value2, "memoryTotal");
			return (Criteria) this;
		}

		public Criteria andMemoryTotalNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("memory_total not between", value1, value2, "memoryTotal");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedIsNull() {
			addCriterion("memory_used is null");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedIsNotNull() {
			addCriterion("memory_used is not null");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedEqualTo(BigDecimal value) {
			addCriterion("memory_used =", value, "memoryUsed");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedNotEqualTo(BigDecimal value) {
			addCriterion("memory_used <>", value, "memoryUsed");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedGreaterThan(BigDecimal value) {
			addCriterion("memory_used >", value, "memoryUsed");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("memory_used >=", value, "memoryUsed");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedLessThan(BigDecimal value) {
			addCriterion("memory_used <", value, "memoryUsed");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedLessThanOrEqualTo(BigDecimal value) {
			addCriterion("memory_used <=", value, "memoryUsed");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedIn(List<BigDecimal> values) {
			addCriterion("memory_used in", values, "memoryUsed");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedNotIn(List<BigDecimal> values) {
			addCriterion("memory_used not in", values, "memoryUsed");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("memory_used between", value1, value2, "memoryUsed");
			return (Criteria) this;
		}

		public Criteria andMemoryUsedNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("memory_used not between", value1, value2, "memoryUsed");
			return (Criteria) this;
		}

		public Criteria andMemoryRestIsNull() {
			addCriterion("memory_rest is null");
			return (Criteria) this;
		}

		public Criteria andMemoryRestIsNotNull() {
			addCriterion("memory_rest is not null");
			return (Criteria) this;
		}

		public Criteria andMemoryRestEqualTo(BigDecimal value) {
			addCriterion("memory_rest =", value, "memoryRest");
			return (Criteria) this;
		}

		public Criteria andMemoryRestNotEqualTo(BigDecimal value) {
			addCriterion("memory_rest <>", value, "memoryRest");
			return (Criteria) this;
		}

		public Criteria andMemoryRestGreaterThan(BigDecimal value) {
			addCriterion("memory_rest >", value, "memoryRest");
			return (Criteria) this;
		}

		public Criteria andMemoryRestGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("memory_rest >=", value, "memoryRest");
			return (Criteria) this;
		}

		public Criteria andMemoryRestLessThan(BigDecimal value) {
			addCriterion("memory_rest <", value, "memoryRest");
			return (Criteria) this;
		}

		public Criteria andMemoryRestLessThanOrEqualTo(BigDecimal value) {
			addCriterion("memory_rest <=", value, "memoryRest");
			return (Criteria) this;
		}

		public Criteria andMemoryRestIn(List<BigDecimal> values) {
			addCriterion("memory_rest in", values, "memoryRest");
			return (Criteria) this;
		}

		public Criteria andMemoryRestNotIn(List<BigDecimal> values) {
			addCriterion("memory_rest not in", values, "memoryRest");
			return (Criteria) this;
		}

		public Criteria andMemoryRestBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("memory_rest between", value1, value2, "memoryRest");
			return (Criteria) this;
		}

		public Criteria andMemoryRestNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("memory_rest not between", value1, value2, "memoryRest");
			return (Criteria) this;
		}

		public Criteria andPodsTotalIsNull() {
			addCriterion("pods_total is null");
			return (Criteria) this;
		}

		public Criteria andPodsTotalIsNotNull() {
			addCriterion("pods_total is not null");
			return (Criteria) this;
		}

		public Criteria andPodsTotalEqualTo(Integer value) {
			addCriterion("pods_total =", value, "podsTotal");
			return (Criteria) this;
		}

		public Criteria andPodsTotalNotEqualTo(Integer value) {
			addCriterion("pods_total <>", value, "podsTotal");
			return (Criteria) this;
		}

		public Criteria andPodsTotalGreaterThan(Integer value) {
			addCriterion("pods_total >", value, "podsTotal");
			return (Criteria) this;
		}

		public Criteria andPodsTotalGreaterThanOrEqualTo(Integer value) {
			addCriterion("pods_total >=", value, "podsTotal");
			return (Criteria) this;
		}

		public Criteria andPodsTotalLessThan(Integer value) {
			addCriterion("pods_total <", value, "podsTotal");
			return (Criteria) this;
		}

		public Criteria andPodsTotalLessThanOrEqualTo(Integer value) {
			addCriterion("pods_total <=", value, "podsTotal");
			return (Criteria) this;
		}

		public Criteria andPodsTotalIn(List<Integer> values) {
			addCriterion("pods_total in", values, "podsTotal");
			return (Criteria) this;
		}

		public Criteria andPodsTotalNotIn(List<Integer> values) {
			addCriterion("pods_total not in", values, "podsTotal");
			return (Criteria) this;
		}

		public Criteria andPodsTotalBetween(Integer value1, Integer value2) {
			addCriterion("pods_total between", value1, value2, "podsTotal");
			return (Criteria) this;
		}

		public Criteria andPodsTotalNotBetween(Integer value1, Integer value2) {
			addCriterion("pods_total not between", value1, value2, "podsTotal");
			return (Criteria) this;
		}

		public Criteria andPodsUsedIsNull() {
			addCriterion("pods_used is null");
			return (Criteria) this;
		}

		public Criteria andPodsUsedIsNotNull() {
			addCriterion("pods_used is not null");
			return (Criteria) this;
		}

		public Criteria andPodsUsedEqualTo(Integer value) {
			addCriterion("pods_used =", value, "podsUsed");
			return (Criteria) this;
		}

		public Criteria andPodsUsedNotEqualTo(Integer value) {
			addCriterion("pods_used <>", value, "podsUsed");
			return (Criteria) this;
		}

		public Criteria andPodsUsedGreaterThan(Integer value) {
			addCriterion("pods_used >", value, "podsUsed");
			return (Criteria) this;
		}

		public Criteria andPodsUsedGreaterThanOrEqualTo(Integer value) {
			addCriterion("pods_used >=", value, "podsUsed");
			return (Criteria) this;
		}

		public Criteria andPodsUsedLessThan(Integer value) {
			addCriterion("pods_used <", value, "podsUsed");
			return (Criteria) this;
		}

		public Criteria andPodsUsedLessThanOrEqualTo(Integer value) {
			addCriterion("pods_used <=", value, "podsUsed");
			return (Criteria) this;
		}

		public Criteria andPodsUsedIn(List<Integer> values) {
			addCriterion("pods_used in", values, "podsUsed");
			return (Criteria) this;
		}

		public Criteria andPodsUsedNotIn(List<Integer> values) {
			addCriterion("pods_used not in", values, "podsUsed");
			return (Criteria) this;
		}

		public Criteria andPodsUsedBetween(Integer value1, Integer value2) {
			addCriterion("pods_used between", value1, value2, "podsUsed");
			return (Criteria) this;
		}

		public Criteria andPodsUsedNotBetween(Integer value1, Integer value2) {
			addCriterion("pods_used not between", value1, value2, "podsUsed");
			return (Criteria) this;
		}

		public Criteria andPodsRestIsNull() {
			addCriterion("pods_rest is null");
			return (Criteria) this;
		}

		public Criteria andPodsRestIsNotNull() {
			addCriterion("pods_rest is not null");
			return (Criteria) this;
		}

		public Criteria andPodsRestEqualTo(Integer value) {
			addCriterion("pods_rest =", value, "podsRest");
			return (Criteria) this;
		}

		public Criteria andPodsRestNotEqualTo(Integer value) {
			addCriterion("pods_rest <>", value, "podsRest");
			return (Criteria) this;
		}

		public Criteria andPodsRestGreaterThan(Integer value) {
			addCriterion("pods_rest >", value, "podsRest");
			return (Criteria) this;
		}

		public Criteria andPodsRestGreaterThanOrEqualTo(Integer value) {
			addCriterion("pods_rest >=", value, "podsRest");
			return (Criteria) this;
		}

		public Criteria andPodsRestLessThan(Integer value) {
			addCriterion("pods_rest <", value, "podsRest");
			return (Criteria) this;
		}

		public Criteria andPodsRestLessThanOrEqualTo(Integer value) {
			addCriterion("pods_rest <=", value, "podsRest");
			return (Criteria) this;
		}

		public Criteria andPodsRestIn(List<Integer> values) {
			addCriterion("pods_rest in", values, "podsRest");
			return (Criteria) this;
		}

		public Criteria andPodsRestNotIn(List<Integer> values) {
			addCriterion("pods_rest not in", values, "podsRest");
			return (Criteria) this;
		}

		public Criteria andPodsRestBetween(Integer value1, Integer value2) {
			addCriterion("pods_rest between", value1, value2, "podsRest");
			return (Criteria) this;
		}

		public Criteria andPodsRestNotBetween(Integer value1, Integer value2) {
			addCriterion("pods_rest not between", value1, value2, "podsRest");
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