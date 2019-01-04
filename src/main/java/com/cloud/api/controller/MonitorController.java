
/**
 * 
 */
package com.cloud.api.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.MonitorAlarmDTO;
import com.cloud.api.dto.MonitorPhysicalNodesDTO;
import com.cloud.api.entity.request.ExportMonitorRequest;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.MonitorRuleRequestData;
import com.cloud.api.entity.request.RequestData;
import com.cloud.api.entity.response.ApplicationMonitorResponse;
import com.cloud.api.entity.response.ContainerMonitorResponse;
import com.cloud.api.entity.response.MonitorAlarmApplyResponse;
import com.cloud.api.entity.response.NodeMonitorResponse;
import com.cloud.api.service.MonitorService;

/**
 * @author shi_lin
 *
 */
@RestController
@RequestMapping("/monitor")
public class MonitorController {

	@Resource
	private MonitorService monitorService;
	

	@GetMapping("/hostMonitorData")
	public Result<NodeMonitorResponse> getHostMonitorDataDetail(@RequestBody GuiRequestBody<Map<String,Object>> requestBody) {

		NodeMonitorResponse response = monitorService.queryMoniorHostByNodeId(requestBody.getData());
		return ResultGenerator.genGetOkResult(response);
	}
	
	@GetMapping
	public Result<List<MonitorPhysicalNodesDTO>> getAllHostMonitors(){
		List<MonitorPhysicalNodesDTO> list = monitorService.getAllHostMonitors();
		return ResultGenerator.genListOkResult(list.size(), list.size(), list);
	}
	
	@GetMapping("/{nodeId}")
	public Result<MonitorPhysicalNodesDTO> getMonitorDetail(@PathVariable String nodeId){
		MonitorPhysicalNodesDTO physicalNodesDTO = monitorService.getMonitorDetail(nodeId);
		return ResultGenerator.genGetOkResult(physicalNodesDTO);
	}
	
	@PostMapping
	public Result<?> addMonitorAlarm(@RequestBody GuiRequestBody<MonitorRuleRequestData> requestBody){
		monitorService.addMonitorAlarm(requestBody.getData());
		return ResultGenerator.genOkResult();
	}
	
	@GetMapping("/monitorAlarm")
	public Result<List<MonitorAlarmDTO>> getMonitorAlarmAll(){
		List<MonitorAlarmDTO> list = monitorService.queryAllMonitorAlarm();
		return ResultGenerator.genListOkResult(list.size(), list.size(), list);
	}
	
	@GetMapping("/monitorAlarm/{id}")
	public Result<MonitorRuleRequestData> getMonitorAlarmDetail(@PathVariable String id){
		MonitorRuleRequestData response = monitorService.queryMonitorAlarmById(id);
		return ResultGenerator.genGetOkResult(response);
	}
	
	@PostMapping("/monitorAlarm/{id}/{monitorObjId}")
	public Result<?> applyMonitorAlarm(@PathVariable String id, @PathVariable String monitorObjId){
		monitorService.applyMonitorAlarm(id, monitorObjId);
		return ResultGenerator.genOkResult();
	}
	
//	@PutMapping("/monitorTemplate/{id}/{monitorObjId}/{status}")
//	public Result<?> updateMonitorTemplate(@PathVariable String id, @PathVariable String monitorObjId){
//		monitorService.applyMonitorTemplate(id, monitorObjId);
//		return ResultGenerator.genOkResult();
//	}
	
	@DeleteMapping("/monitorAlarm")
	public Result<?> deleteMonitorAlarm(@RequestBody GuiRequestBody<RequestData> requestBody){
		monitorService.deleteMonitorAlarms(requestBody.getData().getIds());
		return ResultGenerator.genOkResult();
	}
	
	@GetMapping("containerMonitorData")
	public Result<ContainerMonitorResponse> getContainerMonitorData(@RequestBody GuiRequestBody<Map<String,Object>> requestBody){
		ContainerMonitorResponse response = monitorService.queryMonitorContainer(requestBody.getData());
		return ResultGenerator.genGetOkResult(response);
	}
	
	@GetMapping("applicationMonitorLatest/{applicationId}")
	public Result<ApplicationMonitorResponse> getApplicationMonitorDataLatest(@PathVariable String applicationId){
		ApplicationMonitorResponse response = monitorService.queryMonitorApplicationLatest(applicationId);
		return ResultGenerator.genGetOkResult(response);
	}
	
	@GetMapping("applicationMonitorList/{applicationId}")
	public Result<ContainerMonitorResponse> getApplicationMonitorDataList(@PathVariable String applicationId,@RequestBody GuiRequestBody<Map<String,Object>> requestBody){
		ContainerMonitorResponse response = monitorService.queryMonitorApplicationList(requestBody.getData());
		return ResultGenerator.genGetOkResult(response);
	}
	
	@GetMapping("monitorAlarmApplyDetail")
	public Result<List<MonitorAlarmApplyResponse>> getMonitorAlarmApplyDetail(@RequestBody GuiRequestBody<RequestData> requestBody){
		List<MonitorAlarmApplyResponse> list = monitorService.getMonitorAlarmApplyObj(requestBody.getData().getFilter());
		return ResultGenerator.genListOkResult(list.size(), list.size(), list);
	}
	
	@PutMapping("/monitorAlarm/{id}")
	public Result<?> cancelApplyMonitorAlarm(@RequestBody GuiRequestBody<RequestData> requestBody){
		monitorService.cancelApplyMonitorAlarm(requestBody.getData().getIds());
		return ResultGenerator.genOkResult();
	}
	
	@GetMapping("/exportMonitorData")
    public void exportMonitorData(HttpServletResponse response,@RequestBody GuiRequestBody<ExportMonitorRequest> requestBody) throws Exception  {
		try {
			HSSFWorkbook hwb = monitorService.exportMonitorData(requestBody.getData());
			OutputStream output=response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename=monitorData.xls");
			response.setContentType("application/msexcel");
			hwb.write(output);
			output.close();
		} catch (Exception e) {
			throw e;
		}
    }
}
