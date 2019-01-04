package com.cloud.api.entity.response;

public class ProjectResponse {

	/**
	 * uuid
	 */
    private String uuid;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 展示名称
     */
    private String displayName;

    /**
     * 
     */
    private String description;
    
    private int cpuQuata;
	
	private int memoryQuota;
	
	private int podsQuota;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getCpuQuata() {
		return cpuQuata;
	}

	public void setCpuQuata(int cpuQuata) {
		this.cpuQuata = cpuQuata;
	}

	public int getMemoryQuota() {
		return memoryQuota;
	}

	public void setMemoryQuota(int memoryQuota) {
		this.memoryQuota = memoryQuota;
	}

	public int getPodsQuota() {
		return podsQuota;
	}

	public void setPodsQuota(int podsQuota) {
		this.podsQuota = podsQuota;
	}
	
	
    
}
