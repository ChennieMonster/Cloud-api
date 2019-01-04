package com.cloud.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourcesDTO implements Comparable<ResourcesDTO>{
	
	private String name;
	
	private float cpuTotal;
	
	private float cpuUsage;
	
	private long memoryTotal;
	
	private long memoryUsage;
	
	private Integer podTotal;
	
	private Integer podUsage;
	
	private String displayName;
	
	private String description;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCpuTotal() {
		return cpuTotal;
	}

	public void setCpuTotal(float cpuTotal) {
		this.cpuTotal = cpuTotal;
	}

	public long getMemoryTotal() {
		return memoryTotal;
	}

	public void setMemoryTotal(long memoryTotal) {
		this.memoryTotal = memoryTotal;
	}

	public Integer getPodTotal() {
		return podTotal;
	}

	public void setPodTotal(Integer podTotal) {
		this.podTotal = podTotal;
	}

	public float getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(float cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public long getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(long memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public Integer getPodUsage() {
		return podUsage;
	}

	public void setPodUsage(Integer podUsage) {
		this.podUsage = podUsage;
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(ResourcesDTO o) {
		
		return (int) (o.memoryTotal - this.memoryTotal);
	}

}
