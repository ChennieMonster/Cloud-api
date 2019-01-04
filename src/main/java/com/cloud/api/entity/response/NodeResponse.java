/**
 * 
 */
package com.cloud.api.entity.response;

import java.util.Date;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import com.cloud.api.dto.MonitorPhysicalNodesDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author zhao_pengchen
 *
 */
public class NodeResponse {

	private String name;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdtime;

    private String internalIp;

    private Integer podsNo;
    
    private Map<String, String> labels;
    
    private MonitorPhysicalNodesDTO monitorPhysicalNodesDTO;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		this.createdtime = createdtime;
	}

	public String getInternalIp() {
		return internalIp;
	}

	public void setInternalIp(String internalIp) {
		this.internalIp = internalIp;
	}

	public Integer getPodsNo() {
		return podsNo;
	}

	public void setPodsNo(Integer podsNo) {
		this.podsNo = podsNo;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

	public MonitorPhysicalNodesDTO getMonitorPhysicalNodesDTO() {
		return monitorPhysicalNodesDTO;
	}

	public void setMonitorPhysicalNodesDTO(MonitorPhysicalNodesDTO monitorPhysicalNodesDTO) {
		this.monitorPhysicalNodesDTO = monitorPhysicalNodesDTO;
	}
    
}
