package com.cloud.api.entity.response;

import java.util.List;

import com.cloud.api.dto.MonitorBlockIoDTO;
import com.cloud.api.dto.MonitorContainerDTO;
import com.cloud.api.dto.MonitorHistoryDTO;
import com.cloud.api.dto.MonitorNetworkDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContainerMonitorResponse {
	
	private  MonitorContainerDTO monitorContainer;
	
	private List<MonitorNetworkDTO> netList;
	
	private List<MonitorBlockIoDTO> ioList;
	
	private List<MonitorHistoryDTO> cpuUtilList;
	
	private List<MonitorHistoryDTO> memoryUtilList;

	public MonitorContainerDTO getMonitorContainer() {
		return monitorContainer;
	}

	public void setMonitorContainer(MonitorContainerDTO monitorContainer) {
		this.monitorContainer = monitorContainer;
	}

	public List<MonitorNetworkDTO> getNetList() {
		return netList;
	}

	public void setNetList(List<MonitorNetworkDTO> netList) {
		this.netList = netList;
	}

	public List<MonitorBlockIoDTO> getIoList() {
		return ioList;
	}

	public void setIoList(List<MonitorBlockIoDTO> ioList) {
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
