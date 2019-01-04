/**
 * 
 */
package com.cloud.api.service;

import java.util.List;

import com.cloud.api.entity.ProcessTodoWorkflowRes;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ProcessRequest;
import com.cloud.api.entity.request.ProcessStepRequest;
import com.cloud.api.entity.request.WorkflowRequest;
import com.cloud.api.entity.response.DefProcessResponse;
import com.cloud.api.entity.response.InsProcessResponse;
import com.cloud.api.entity.response.ProcessMyApplyResponse;
import com.cloud.api.entity.response.ProcessResponse;
import com.cloud.api.entity.response.ProcessStepReponse;
import com.cloud.api.entity.response.ProcessTodoResponse;

/**
 * @author zhao_pengchen
 *
 */
public interface WorkflowService {

	void approval(WorkflowRequest request, TokenDO token);
	
	List<ProcessTodoResponse> getTodoList(String userName);
	
	ProcessTodoWorkflowRes getTodoDetail(String taskId);
	
	ProcessTodoWorkflowRes getMyApplyDetail(String processId);
	
	List<ProcessMyApplyResponse> getmyApplyList(String userName);
	
	List<DefProcessResponse> defProcess();
	
	List<InsProcessResponse> insProcess(String processId);
	
	List<ProcessTodoWorkflowRes> applyHistory(String userName);
	
	ProcessTodoWorkflowRes applyHistoryDetail(String processId);
	
	List<ProcessResponse> processes();
	
	ProcessResponse getProcess(String processId);
	
	List<ProcessStepReponse> processesStep(String processId);
	
	void updateProcess(ProcessRequest request, String processId);
	
	void updateProcessStep(ProcessStepRequest processStep, String processId);
	
}
