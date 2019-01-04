package com.cloud.api.entity.response;

import java.util.List;

import com.cloud.api.dto.MonitorDiskIoDTO;
import com.cloud.api.dto.MonitorHistoryDTO;
import com.cloud.api.dto.MonitorNetworkDTO;
import com.cloud.api.dto.MonitorPhysicalNodesDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NodeMonitorResponse {
	
	private MonitorPhysicalNodesDTO physicalNodesDTO;
	
	private List<MonitorNetworkDTO> netList;
	
	private List<MonitorDiskIoDTO> ioList;
	
	private List<MonitorHistoryDTO> cpuUtilList;
	
	private List<MonitorHistoryDTO> memoryUtilList;
	
	public MonitorPhysicalNodesDTO getPhysicalNodesDTO() {
		return physicalNodesDTO;
	}

	public void setPhysicalNodesDTO(MonitorPhysicalNodesDTO physicalNodesDTO) {
		this.physicalNodesDTO = physicalNodesDTO;
	}

	public List<MonitorNetworkDTO> getNetList() {
		return netList;
	}

	public void setNetList(List<MonitorNetworkDTO> netList) {
		this.netList = netList;
	}

	public List<MonitorDiskIoDTO> getIoList() {
		return ioList;
	}

	public void setIoList(List<MonitorDiskIoDTO> ioList) {
		this.ioList = ioList;
	}

	public List<MonitorHistoryDTO> getCpuUtilList() {
		return cpuUtilList;
	}

	public void setCpuUtilList(List<MonitorHistoryDTO> cpuUtilList) {
		this.cpuUtilList = cpuUtilList;
	}

	public List<MonitorHistoryDTO> getMemoryUtilList() {
		return memoryUtilList;
	}

	public void setMemoryUtilList(List<MonitorHistoryDTO> memoryUtilList) {
		this.memoryUtilList = memoryUtilList;
	}

}
