/**
 * 
 */
package com.cloud.api.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.exception.ServiceException;
import com.cloud.api.core.http.HttpAgent;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.dto.ProjectDTOExample;
import com.cloud.api.dto.ProjectDTOExample.Criteria;
import com.cloud.api.dto.ProjectForUpdateDTO;
import com.cloud.api.dto.ProjectForUpdateDTOExample;
import com.cloud.api.dto.QuotaDTO;
import com.cloud.api.dto.QuotaDTOExample;
import com.cloud.api.dto.UserDTO;
import com.cloud.api.dto.UserRoleProDTO;
import com.cloud.api.dto.UserRoleProDTOExample;
import com.cloud.api.entity.ProcessTodoWorkflowRes;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ApprovalRequest;
import com.cloud.api.entity.request.ProcessRequest;
import com.cloud.api.entity.request.ProcessStepRequest;
import com.cloud.api.entity.request.WorkflowRequest;
import com.cloud.api.entity.response.DefProcessResponse;
import com.cloud.api.entity.response.InsProcessResponse;
import com.cloud.api.entity.response.ProcessMyApplyResponse;
import com.cloud.api.entity.response.ProcessResponse;
import com.cloud.api.entity.response.ProcessStepReponse;
import com.cloud.api.entity.response.ProcessTodoResponse;
import com.cloud.api.mapper.ProjectForUpdateMapper;
import com.cloud.api.mapper.ProjectMapper;
import com.cloud.api.mapper.QuotaMapper;
import com.cloud.api.mapper.UserMapper;
import com.cloud.api.mapper.UserRoleProMapper;
import com.cloud.api.service.AuthOpenShiftService;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.WorkflowService;
import com.cloud.api.util.EmailUtils;
import com.cloud.api.util.JsonUtils;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkflowServiceImpl extends BaseService implements WorkflowService {

	private static final Logger logger = LoggerFactory.getLogger(WorkflowServiceImpl.class);

	@Value("${cloud.workflow.url}")
	private String workflowUrl;

	@Autowired
	private ProjectMapper projectMapper;

	@Autowired
	private QuotaMapper quotaMapper;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private AuthOpenShiftService authOpenShiftService;
	
	@Autowired
	private ProjectForUpdateMapper projectForUpdateMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Value("${EMailHost}")
	private String emailHost;
	
	@Value("${EMailUser}")
	private String emailUser;
	
	@Value("${EMailPWD}")
	private String emailPwd;
	
	@Value("${EMailFrom}")
	private String emailFrom;

	@Override
	public void approval(WorkflowRequest request, TokenDO token) {
		ApprovalRequest approvalRequest = new ApprovalRequest();

		ProjectDTOExample example = new ProjectDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andTaskIdEqualTo(request.getProcessId());
		List<ProjectDTO> projectList = projectMapper.selectByExample(example);
		List<ProjectForUpdateDTO> projectForUpdateList = new ArrayList<>();
		ProjectDTO project = new ProjectDTO();
		ProjectForUpdateDTO projectForUpdate = new ProjectForUpdateDTO();
		if (projectList.size() > 0) {
			project = projectList.get(0);
		} else {
			//如果通过流程id查不到project信息，存在project已被申请修改的情况，查流程修改记录表
			ProjectForUpdateDTOExample exampleForUpdate = new ProjectForUpdateDTOExample();
			com.cloud.api.dto.ProjectForUpdateDTOExample.Criteria criteriaForUpdate = exampleForUpdate.createCriteria();
			criteriaForUpdate.andTaskIdEqualTo(request.getProcessId());
			projectForUpdateList = projectForUpdateMapper.selectByExample(exampleForUpdate);
			if (projectForUpdateList.size() > 0) {
				projectForUpdate = projectForUpdateList.get(0);
			}
		}

		String isAgree = "";
		// 同意
		if (request.isAgree()) {

			isAgree = "approved";
			QuotaDTOExample example_quota = new QuotaDTOExample();
			com.cloud.api.dto.QuotaDTOExample.Criteria criteria_quota = example_quota.createCriteria();
			criteria_quota.getAllCriteria();
			List<QuotaDTO> quotaList = quotaMapper.selectByExample(example_quota);
			QuotaDTO quota = new QuotaDTO();
			if (quotaList.size() > 0) {
				quota = quotaList.get(0);
			} else {
				throw new ServiceException("Table Quota has no datas!");
			}
			/*
			 * 校验
			 */
			if (projectList.size() > 0) {
				if (quota.getCpuRest().compareTo(project.getCpuQuota()) < 0) {
					throw new ServiceException("Too many CPU applications!");
				}
				if (quota.getMemoryRest().compareTo(project.getMemoryQuota()) < 0) {
					throw new ServiceException("Too many memory applications!");
				}
				if (quota.getPodsRest().compareTo(project.getPodsQuota()) < 0) {
					throw new ServiceException("Too many Pods applications!");
				}
			} else {
				if(projectForUpdateList.size()>0) {
					if (quota.getCpuRest().compareTo(projectForUpdate.getCpuQuota()) < 0) {
						throw new ServiceException("Too many CPU applications!");
					}
					if (quota.getMemoryRest().compareTo(projectForUpdate.getMemoryQuota()) < 0) {
						throw new ServiceException("Too many memory applications!");
					}
					if (quota.getPodsRest().compareTo(projectForUpdate.getPodsQuota()) < 0) {
						throw new ServiceException("Too many Pods applications!");
					}
				}
			}

			approvalRequest.setReason(request.getSuggestions());
			approvalRequest.setStatus(Constants.PASS_PROCESS_STATUS);
			approvalRequest.setTaskId(request.getTaskId());
			approvalRequest.setApplyUser(token.getUserName());
			String reqJson = JsonUtils.objectToJson(approvalRequest);

			String respJson ="";
			try {
				respJson = new HttpAgent(workflowUrl + "/workflow/passProcess").doPost(reqJson);
				if ((boolean) JsonUtils.jsonToObject(respJson, Map.class).get("success")) {
					//如果project更新表有记录，表示审批的是更新的申请，将project表的资源申请数据放入project表中
					if(projectForUpdateList.size()>0) {
						project.setName(projectForUpdate.getName());
						project.setCpuQuota(projectForUpdate.getCpuQuota());
						project.setMemoryQuota(projectForUpdate.getMemoryQuota());
						project.setPodsQuota(projectForUpdate.getPodsQuota());
						project.setDisplayName(projectForUpdate.getDisplayName());
						project.setDescription(projectForUpdate.getDescription());
						project.setUpdateStatus(2);  //0-未修改；1-申请修改中；2-修改审批结束
						projectForUpdate.setApproveStatus(2);
						projectForUpdateMapper.updateByPrimaryKeySelective(projectForUpdate);
						
						ProjectDTOExample exampleForUpdate = new ProjectDTOExample();
						Criteria criteriaForUpdate = exampleForUpdate.createCriteria();
						criteriaForUpdate.andNameEqualTo(project.getName());
						projectMapper.updateByExampleSelective(project, exampleForUpdate);
					}else {
						project.setApproveStatus(2);
						projectMapper.updateByPrimaryKeySelective(project);
					}

					// 接收状态，如果成功则调openshift
					if ((boolean) JsonUtils.jsonToObject(respJson, Map.class).get("processEnd")) {
						// 调openshift添加 openshift新建quota的token用admin用户, project创建的token用申请人用户
						TokenDO tokenQuota = authOpenShiftService
								.getOpenShiftToken(token.getUserName());
						TokenDO tokenProject = authOpenShiftService.getOpenShiftToken(project.getApplyUser());
						projectService.approveProject(project, tokenQuota, tokenProject, request.getActionType());

					}
				}
			} catch (ServiceException e) {
				throw new ServiceException("Invalide response from Api!"
	                    + respJson.toString());
			} catch (ClientProtocolException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else { // 拒绝
			isAgree = "rejected";
			approvalRequest.setReason(request.getSuggestions());
			approvalRequest.setStatus(Constants.REVOKE_PROCESS_STATUS);
			approvalRequest.setTaskId(request.getTaskId());
			approvalRequest.setApplyUser(token.getUserName());
			String reqJson = JsonUtils.objectToJson(approvalRequest);
			try {
				String respJson = new HttpAgent(workflowUrl + "/workflow/revokeProcess").doPost(reqJson);
				if ((boolean) JsonUtils.jsonToObject(respJson, Map.class).get("success")) {
					if(projectList.size() > 0) {
						ProjectDTOExample examplePro = new ProjectDTOExample();
						Criteria criteriaPro = examplePro.createCriteria();
						criteriaPro.andApproveStatusEqualTo(3); // '审批状态：0-申请中待审批；1-审批中；2-审批结束；3-驳回'
						projectMapper.updateByExample(project, examplePro);
					}else {
						if(projectForUpdateList.size()>0) {
							projectForUpdate.setApproveStatus(3);
							projectForUpdateMapper.updateByPrimaryKeySelective(projectForUpdate);
						}
					}			
					
				}
			} catch (ClientProtocolException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}

		// 发邮件
//		Map<String, Object> idMap = userMapper.queryUserByName(request.getApplyUser());
//		String notifiSubject = "Your project apply has be" + isAgree + "!";
//		StringBuilder rs = new StringBuilder();
//		rs.append("Dear " + request.getApplyUser());
//		rs.append("\r\n");
//		rs.append(token.getUserName() + " has "+isAgree+"your project apply.");
//		rs.append("\r\n");
//		rs.append("\r\n");
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//		rs.append(formatter.format(new Date()));
//		EmailUtils.sendEmail(emailHost, emailUser, emailPwd, emailFrom, (String) idMap.get("mail"), notifiSubject, rs.toString());

	}

	@Override
	public List<ProcessTodoResponse> getTodoList(String userName) {

		List<ProcessTodoResponse> responseList = new ArrayList<>();
		List<ProcessTodoWorkflowRes> workflowResList = new ArrayList<ProcessTodoWorkflowRes>();
		String respJson = "";
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/ApproveTask", "userName=" + userName, "UTF-8");
			workflowResList = JsonUtils.jsonToObject(respJson, List.class, ProcessTodoWorkflowRes.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (ProcessTodoWorkflowRes processTodoWorkflowRes : workflowResList) {
			ProcessTodoResponse response = new ProcessTodoResponse();
			response.setApplicant(processTodoWorkflowRes.getApplyUser());
			response.setUpdatedTime(processTodoWorkflowRes.getApplyTime());
			response.setProcessId(processTodoWorkflowRes.getProcessId());
			response.setTaskId(processTodoWorkflowRes.getTaskId());
			response.setApplyTitle(processTodoWorkflowRes.getApplyTitle());
			responseList.add(response);
		}

		return responseList;
	}

	@Override
	public ProcessTodoWorkflowRes getTodoDetail(String taskId) {
		ProcessTodoWorkflowRes processTodoWorkflowRes = new ProcessTodoWorkflowRes();
		String respJson = "";
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/ApproveTask/" + taskId, null, "UTF-8");
			processTodoWorkflowRes = JsonUtils.jsonToObject(respJson, ProcessTodoWorkflowRes.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                        + respJson.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ProjectDTOExample example = new ProjectDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andTaskIdEqualTo(processTodoWorkflowRes.getProcessId());
		List<ProjectDTO> projectList = projectMapper.selectByExample(example);
		ProjectDTO project = new ProjectDTO();
		List<ProjectForUpdateDTO> projectForUpdateList = new ArrayList<>();
		ProjectForUpdateDTO projectForUpdate = new ProjectForUpdateDTO();
		if (projectList.size() > 0) {
			project = projectList.get(0);
		}else {
			ProjectForUpdateDTOExample exampleForUpdate = new ProjectForUpdateDTOExample();
			com.cloud.api.dto.ProjectForUpdateDTOExample.Criteria criteriaForUpdate = exampleForUpdate.createCriteria();
			criteriaForUpdate.andTaskIdEqualTo(processTodoWorkflowRes.getProcessId());
			projectForUpdateList = projectForUpdateMapper.selectByExample(exampleForUpdate);
			if (projectForUpdateList.size() > 0) {
				projectForUpdate = projectForUpdateList.get(0);
				project.setName(projectForUpdate.getName());
				project.setCpuQuota(projectForUpdate.getCpuQuota());
				project.setMemoryQuota(projectForUpdate.getMemoryQuota());
				project.setPodsQuota(projectForUpdate.getPodsQuota());
				project.setDisplayName(projectForUpdate.getDisplayName());
				project.setDescription(projectForUpdate.getDescription());
				project.setApplyUser(projectForUpdate.getApplyUser());
			}
		}

		processTodoWorkflowRes.setApplyDetail(project);
		return processTodoWorkflowRes;
	}

	@Override
	public List<DefProcessResponse> defProcess() {

		List<DefProcessResponse> defProcessResponseLisy = new ArrayList<>();
		String respJson = "";
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/defProcess", null, "UTF-8");
			defProcessResponseLisy = JsonUtils.jsonToObject(respJson, List.class, DefProcessResponse.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return defProcessResponseLisy;
	}

	@Override
	public List<InsProcessResponse> insProcess(String processId) {

		List<InsProcessResponse> insProcessResponseList = new ArrayList<>();
		String respJson = "";
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/insProcess", "processInstanceId=" + processId, "UTF-8");
			insProcessResponseList = JsonUtils.jsonToObject(respJson, List.class, InsProcessResponse.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insProcessResponseList;
	}

	@Override
	public List<ProcessMyApplyResponse> getmyApplyList(String userName) {
		List<ProcessMyApplyResponse> myApplyList = new ArrayList<>();
		String respJson = "";
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/ApplyTask", "userName=" + userName, "UTF-8");
			myApplyList = JsonUtils.jsonToObject(respJson, List.class, ProcessMyApplyResponse.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myApplyList;
	}

	@Override
	public ProcessTodoWorkflowRes getMyApplyDetail(String processId) {
		ProcessTodoWorkflowRes processTodoWorkflowRes = new ProcessTodoWorkflowRes();
		String respJson = "";
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/ApplyTask/" + processId, null, "UTF-8");
			processTodoWorkflowRes = JsonUtils.jsonToObject(respJson, ProcessTodoWorkflowRes.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ProjectDTOExample example = new ProjectDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andTaskIdEqualTo(processTodoWorkflowRes.getProcessId());
		List<ProjectDTO> projectList = projectMapper.selectByExample(example);
		ProjectDTO project = new ProjectDTO();
		List<ProjectForUpdateDTO> projectForUpdateList = new ArrayList<>();
		ProjectForUpdateDTO projectForUpdate = new ProjectForUpdateDTO();
		if (projectList.size() > 0) {
			project = projectList.get(0);
		}else {
			ProjectForUpdateDTOExample exampleForUpdate = new ProjectForUpdateDTOExample();
			com.cloud.api.dto.ProjectForUpdateDTOExample.Criteria criteriaForUpdate = exampleForUpdate.createCriteria();
			criteriaForUpdate.andTaskIdEqualTo(processTodoWorkflowRes.getProcessId());
			projectForUpdateList = projectForUpdateMapper.selectByExample(exampleForUpdate);
			if (projectForUpdateList.size() > 0) {
				projectForUpdate = projectForUpdateList.get(0);
				project.setName(projectForUpdate.getName());
				project.setCpuQuota(projectForUpdate.getCpuQuota());
				project.setMemoryQuota(projectForUpdate.getMemoryQuota());
				project.setPodsQuota(projectForUpdate.getPodsQuota());
				project.setDisplayName(projectForUpdate.getDisplayName());
				project.setDescription(projectForUpdate.getDescription());
				project.setApplyUser(projectForUpdate.getApplyUser());
			}
		}

		processTodoWorkflowRes.setApplyDetail(project);
		return processTodoWorkflowRes;
	}

	@Override
	public List<ProcessTodoWorkflowRes> applyHistory(String userName) {

		String respJson = "";
		List<ProcessTodoWorkflowRes> resList = new ArrayList<>();
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/HisApproveTask", "userName=" + userName, "UTF-8");
			resList = JsonUtils.jsonToObject(respJson, List.class, ProcessTodoWorkflowRes.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resList;
	}

	@Override
	public ProcessTodoWorkflowRes applyHistoryDetail(String processId) {
		ProcessTodoWorkflowRes processTodoWorkflowRes = new ProcessTodoWorkflowRes();
		String respJson = "";
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/HisApproveTask/" + processId, null, "UTF-8");
			processTodoWorkflowRes = JsonUtils.jsonToObject(respJson, ProcessTodoWorkflowRes.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processTodoWorkflowRes;
	}

	@Override
	public List<ProcessResponse> processes() {
		String respJson = "";
		List<ProcessResponse> processList = new ArrayList<>();
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/processes", null, "UTF-8");
			processList = JsonUtils.jsonToObject(respJson, List.class, ProcessResponse.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processList;

	}

	@Override
	public ProcessResponse getProcess(String processId) {
		ProcessResponse process = new ProcessResponse();
		String respJson = "";
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/processes/" + processId, null, "UTF-8");
			process = JsonUtils.jsonToObject(respJson, ProcessResponse.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return process;
	}

	@Override
	public List<ProcessStepReponse> processesStep(String processId) {
		String respJson = "";
		List<ProcessStepReponse> stepList = new ArrayList<>();
		try {
			respJson = HttpAgent.doGet(workflowUrl + "/workflow/processes/" + processId + "/steps", null, "UTF-8");
			stepList = JsonUtils.jsonToObject(respJson, List.class, ProcessStepReponse.class);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stepList;
	}

	@Override
	public void updateProcess(ProcessRequest request, String processId) {
		String respJson = "";
		String reqJson = JsonUtils.objectToJson(request);
		try {
			respJson = HttpAgent.httpPut(workflowUrl + "/workflow/processes/"+processId, reqJson, "UTF-8");
			System.out.println(respJson);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProcessStep(ProcessStepRequest processStep, String processId) {
		String respJson = "";
		String reqJson = JsonUtils.objectToJson(processStep);
		try {
			respJson = HttpAgent.httpPut(workflowUrl + "/workflow/processes/"+processId+ "/steps", reqJson, "UTF-8");
			System.out.println(respJson);
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + respJson.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
