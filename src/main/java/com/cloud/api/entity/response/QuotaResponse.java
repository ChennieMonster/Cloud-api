/**
 * 
 */
package com.cloud.api.entity.response;

import java.math.BigDecimal;

/**
 * @author zhao_pengchen
 *
 */
public class QuotaResponse {

	/**
     * 
     */
    private BigDecimal cpuRest;
    
    /**
     * 
     */
    private BigDecimal memoryRest;
    
    /**
     * 
     */
    private Integer podsRest;
    
    /**
     * 
     */
    private BigDecimal cpuTotal;
    
    /**
     * 
     */
    private BigDecimal memoryTotal;
    
    /**
     * 
     */
    private Integer podsTotal;

	public BigDecimal getCpuRest() {
		return cpuRest;
	}

	public void setCpuRest(BigDecimal cpuRest) {
		this.cpuRest = cpuRest;
	}

	public BigDecimal getMemoryRest() {
		return memoryRest;
	}

	public void setMemoryRest(BigDecimal memoryRest) {
		this.memoryRest = memoryRest;
	}

	public Integer getPodsRest() {
		return podsRest;
	}

	public void setPodsRest(Integer podsRest) {
		this.podsRest = podsRest;
	}

	public BigDecimal getCpuTotal() {
		return cpuTotal;
	}

	public void setCpuTotal(BigDecimal cpuTotal) {
		this.cpuTotal = cpuTotal;
	}

	public BigDecimal getMemoryTotal() {
		return memoryTotal;
	}

	public void setMemoryTotal(BigDecimal memoryTotal) {
		this.memoryTotal = memoryTotal;
	}

	public Integer getPodsTotal() {
		return podsTotal;
	}

	public void setPodsTotal(Integer podsTotal) {
		this.podsTotal = podsTotal;
	}
    
}
