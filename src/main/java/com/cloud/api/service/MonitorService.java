package com.cloud.api.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.cloud.api.dto.MonitorAlarmDTO;
import com.cloud.api.dto.MonitorPhysicalNodesDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.request.ExportMonitorRequest;
import com.cloud.api.entity.request.MonitorRuleRequestData;
import com.cloud.api.entity.response.ApplicationMonitorResponse;
import com.cloud.api.entity.response.ContainerMonitorResponse;
import com.cloud.api.entity.response.MonitorAlarmApplyResponse;
import com.cloud.api.entity.response.NodeMonitorResponse;

public interface MonitorService {
	
	NodeMonitorResponse queryMoniorHostByNodeId(Map<String,Object> param);
	
	void addMonitorAlarm(MonitorRuleRequestData requestData);
	
	void editMonitorAlarmRule(MonitorRuleRequestData requestData);
	
	List<MonitorPhysicalNodesDTO> getAllHostMonitors();
	
	MonitorPhysicalNodesDTO getMonitorDetail(String nodeId);
	
	void applyMonitorAlarm(String monitorAlarmId, String monitorObjId);
	
	List<MonitorAlarmDTO> queryAllMonitorAlarm();
	
	MonitorRuleRequestData queryMonitorAlarmById(String monitorAlarmId);
	
	ContainerMonitorResponse queryMonitorContainer(Map<String,Object> param);
	
	List<MonitorAlarmApplyResponse> getMonitorAlarmApplyObj(List<GetListParamElement> filterList);
	
	ApplicationMonitorResponse queryMonitorApplicationLatest(String applicationId);
	
	void deleteMonitorAlarms(List<String> ids);
	
	void cancelApplyMonitorAlarm(List<String> ids);
	
	HSSFWorkbook exportMonitorData(ExportMonitorRequest request);
	
	ContainerMonitorResponse queryMonitorApplicationList(Map<String,Object> param);
}
