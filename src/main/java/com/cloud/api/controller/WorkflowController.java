/**
 * 
 */
package com.cloud.api.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.entity.ProcessTodoWorkflowRes;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.ProcessRequest;
import com.cloud.api.entity.request.ProcessStepRequest;
import com.cloud.api.entity.request.WorkflowRequest;
import com.cloud.api.entity.response.DefProcessResponse;
import com.cloud.api.entity.response.InsProcessResponse;
import com.cloud.api.entity.response.ProcessMyApplyResponse;
import com.cloud.api.entity.response.ProcessResponse;
import com.cloud.api.entity.response.ProcessStepReponse;
import com.cloud.api.entity.response.ProcessTodoResponse;
import com.cloud.api.service.RoleService;
import com.cloud.api.service.WorkflowService;
import com.cloud.api.util.annotation.TokenParam;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zhao_pengchen
 *
 */
@Validated
@RestController
@RequestMapping("/workflow")
public class WorkflowController {

	@Autowired
	private WorkflowService workflowService;
	
	@Resource
	private RoleService roleService;
	
	/**
	 * 查看待办一览
	 */
	@GetMapping("/todo")
	@ResponseBody
	public Result<List<ProcessTodoResponse>> getTodoList(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<WorkflowRequest> requestBody) {
		
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TODOLIST,Constants.ACTION_QUERY);
		List<ProcessTodoResponse> responseList = workflowService.getTodoList(token.getUserName());
		return ResultGenerator.genGetOkResult(responseList);
	}
	
	/**
	 * 查看我的申请一览
	 */
	@GetMapping("/myApply")
	@ResponseBody
	public Result<List<ProcessMyApplyResponse>> getmyApplyList(@RequestBody GuiRequestBody<ProcessStepRequest> requestBody,@ApiIgnore @TokenParam TokenDO token) {
		
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_APPLY,Constants.ACTION_QUERY);
		
		List<ProcessMyApplyResponse> myApplyList = workflowService.getmyApplyList(token.getUserName());
		return ResultGenerator.genGetOkResult(myApplyList);
	}
	
	/**
	 * 查看代办流程详细
	 */
	@GetMapping("/todo/{id}")
	@ResponseBody
	public Result<ProcessTodoWorkflowRes> getWorkflowDetail(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<WorkflowRequest> requestBody, @PathVariable String id) {
		ProcessTodoWorkflowRes processTodoWorkflowRes = workflowService.getTodoDetail(id);
		return ResultGenerator.genGetOkResult(processTodoWorkflowRes);
	}
	
	/**
	 * 查看申请流程详细
	 */
	@GetMapping("/myApply/{id}")
	@ResponseBody
	public Result<ProcessTodoWorkflowRes> getMyApplyDetail(@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		ProcessTodoWorkflowRes processTodoWorkflowRes = workflowService.getMyApplyDetail(id);
		return ResultGenerator.genGetOkResult(processTodoWorkflowRes);
	}
	
	/**
	 * 审批
	 */
	@PostMapping("")
	@ResponseBody
	public Result<Boolean> approvalWorkflow(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<WorkflowRequest> requestBody) {
		
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TODOLIST,Constants.ACTION_APPROVE);
		
		workflowService.approval(requestBody.getData(), token);
		boolean success = true;
		return ResultGenerator.genGetOkResult(success);
	}
	
	/**
	 * 查看流程定义
	 */
	@GetMapping("/defProcess")
	@ResponseBody
	public Result<List<DefProcessResponse>> defProcess() {
		List<DefProcessResponse> responseList = workflowService.defProcess();
		return ResultGenerator.genGetOkResult(responseList);
	}
	
	/**
	 * 查看流程数据
	 */
	@GetMapping("/insProcess/{id}")
	@ResponseBody
	public Result<List<InsProcessResponse>> insProcess(@PathVariable String id) {
		List<InsProcessResponse> insProcessResponseList = workflowService.insProcess(id);
		return ResultGenerator.genGetOkResult(insProcessResponseList);
	}
	
	/**
	 * 查看审批历史一览
	 */
	@GetMapping("/applyHistory")
	@ResponseBody
	public Result<List<ProcessTodoWorkflowRes>> applyHistory(@RequestBody GuiRequestBody<ProcessStepRequest> requestBody,@ApiIgnore @TokenParam TokenDO token) {
		
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_APPROVEHISTORY,Constants.ACTION_QUERY);
		
		List<ProcessTodoWorkflowRes> resList = workflowService.applyHistory(token.getUserName());
		return ResultGenerator.genGetOkResult(resList);
	}
	
	/**
	 * 查看申请历史详细
	 */
	@GetMapping("/applyHistory/{id}")
	@ResponseBody
	public Result<ProcessTodoWorkflowRes> applyHistoryDetail(@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		ProcessTodoWorkflowRes processTodoWorkflowRes = workflowService.applyHistoryDetail(id);
		return ResultGenerator.genGetOkResult(processTodoWorkflowRes);
	}
	
	/**
	 * 查看process一览
	 */
	@GetMapping("/processes")
	@ResponseBody
	public Result<List<ProcessResponse>> processes(@RequestBody GuiRequestBody<ProcessStepRequest> requestBody,@ApiIgnore @TokenParam TokenDO token) {
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_PROCESS_SETTINGS,Constants.ACTION_QUERY);
		List<ProcessResponse> resList = workflowService.processes();
		return ResultGenerator.genGetOkResult(resList);
	}
	
	/**
	 * 查看process详细
	 */
	@GetMapping("/processes/{id}")
	@ResponseBody
	public Result<ProcessResponse> process(@RequestBody GuiRequestBody<ProcessStepRequest> requestBody,@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		//权限校验
	    roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_PROCESS_SETTINGS,Constants.ACTION_QUERY);
		ProcessResponse processRequest = workflowService.getProcess(id);
		return ResultGenerator.genGetOkResult(processRequest);
	}
	
	/**
	 * 获取process的步骤
	 */
	@GetMapping("/processes/{id}/steps")
	@ResponseBody
	public Result<List<ProcessStepReponse>> processStep(@RequestBody GuiRequestBody<ProcessStepRequest> requestBody,@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		//权限校验
	    roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_PROCESS_SETTINGS,Constants.ACTION_QUERY);
		List<ProcessStepReponse> stepList = workflowService.processesStep(id);
		return ResultGenerator.genGetOkResult(stepList);
	}
	
	/**
	 * 更新process
	 */
	@RequestMapping(value = "/processes/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result<?> updateProcess(@RequestBody GuiRequestBody<ProcessRequest> requestBody,
			@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		workflowService.updateProcess(requestBody.getData(), id);
		return ResultGenerator.genOkResult();
	}
	
	/**
	 * 更新process step
	 */
	@RequestMapping(value = "/processes/{id}/steps", method = RequestMethod.PUT)
	@ResponseBody
	public Result<?> updateProcessStep(@RequestBody GuiRequestBody<ProcessStepRequest> requestBody,
			@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		workflowService.updateProcessStep(requestBody.getData(), id);
		return ResultGenerator.genOkResult();
	}
	
	
}
