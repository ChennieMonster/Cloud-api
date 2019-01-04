package com.cloud.api.dto;

import java.math.BigDecimal;

public class QuotaDTO {
    /**
	 */
	private String uuid;

	/**
	 */
	private String regionId;

	/**
	 */
	private BigDecimal cpuTotal;

	/**
	 */
	private BigDecimal cpuUsed;

	/**
	 */
	private BigDecimal cpuRest;

	/**
	 */
	private BigDecimal memoryTotal;

	/**
	 */
	private BigDecimal memoryUsed;

	/**
	 */
	private BigDecimal memoryRest;

	/**
	 */
	private Integer podsTotal;

	/**
	 */
	private Integer podsUsed;

	/**
	 */
	private Integer podsRest;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public BigDecimal getCpuTotal() {
		return cpuTotal;
	}

	public void setCpuTotal(BigDecimal cpuTotal) {
		this.cpuTotal = cpuTotal;
	}

	public BigDecimal getCpuUsed() {
		return cpuUsed;
	}

	public void setCpuUsed(BigDecimal cpuUsed) {
		this.cpuUsed = cpuUsed;
	}

	public BigDecimal getCpuRest() {
		return cpuRest;
	}

	public void setCpuRest(BigDecimal cpuRest) {
		this.cpuRest = cpuRest;
	}

	public BigDecimal getMemoryTotal() {
		return memoryTotal;
	}

	public void setMemoryTotal(BigDecimal memoryTotal) {
		this.memoryTotal = memoryTotal;
	}

	public BigDecimal getMemoryUsed() {
		return memoryUsed;
	}

	public void setMemoryUsed(BigDecimal memoryUsed) {
		this.memoryUsed = memoryUsed;
	}

	public BigDecimal getMemoryRest() {
		return memoryRest;
	}

	public void setMemoryRest(BigDecimal memoryRest) {
		this.memoryRest = memoryRest;
	}

	public Integer getPodsTotal() {
		return podsTotal;
	}

	public void setPodsTotal(Integer podsTotal) {
		this.podsTotal = podsTotal;
	}

	public Integer getPodsUsed() {
		return podsUsed;
	}

	public void setPodsUsed(Integer podsUsed) {
		this.podsUsed = podsUsed;
	}

	public Integer getPodsRest() {
		return podsRest;
	}

	public void setPodsRest(Integer podsRest) {
		this.podsRest = podsRest;
	}

}