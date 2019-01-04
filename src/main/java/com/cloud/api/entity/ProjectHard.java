/**
 * 
 */
package com.cloud.api.entity;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author zhao_pengchen
 *
 */
public class ProjectHard {

	@JsonProperty("limits.cpu")
	private String limitsCpu;
	
	@JsonProperty("limits.memory")
	private String limitsMemory;
	
	private String pods;
	
	@JsonProperty("requests.cpu")
	private String requestsCpu;
	
	@JsonProperty("requests.memory")
	private String requestsMemory;

	public String getLimitsCpu() {
		return limitsCpu;
	}

	public void setLimitsCpu(String limitsCpu) {
		this.limitsCpu = limitsCpu;
	}

	public String getPods() {
		return pods;
	}

	public void setPods(String pods) {
		this.pods = pods;
	}

	public String getRequestsCpu() {
		return requestsCpu;
	}

	public void setRequestsCpu(String requestsCpu) {
		this.requestsCpu = requestsCpu;
	}

	public String getRequestsMemory() {
		return requestsMemory;
	}

	public void setRequestsMemory(String requestsMemory) {
		this.requestsMemory = requestsMemory;
	}

	public String getLimitsMemory() {
		return limitsMemory;
	}

	public void setLimitsMemory(String limitsMemory) {
		this.limitsMemory = limitsMemory;
	}
	
}
