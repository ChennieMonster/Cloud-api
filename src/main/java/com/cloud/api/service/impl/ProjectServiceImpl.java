package com.cloud.api.service.impl;

import java.io.IOException;
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
import com.cloud.api.core.exception.ParamInvalidException;
import com.cloud.api.core.exception.ServiceException;
import com.cloud.api.core.http.HttpAgent;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.dto.ProjectDTOExample;
import com.cloud.api.dto.ProjectDTOExample.Criteria;
import com.cloud.api.dto.ProjectForUpdateDTO;
import com.cloud.api.dto.QuotaDTO;
import com.cloud.api.dto.QuotaDTOExample;
import com.cloud.api.dto.UserRoleProDTO;
import com.cloud.api.dto.UserRoleProDTOExample;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.ProjectHard;
import com.cloud.api.entity.ProjectPostDetailDO;
import com.cloud.api.entity.ProjectSpecDO;
import com.cloud.api.entity.QuotasPostDetailDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.AddProjectApplyRequest;
import com.cloud.api.entity.request.DeleteProjectToOSReq;
import com.cloud.api.entity.request.ProjectRequest;
import com.cloud.api.entity.response.QuotaResponse;
import com.cloud.api.mapper.ProjectForUpdateMapper;
import com.cloud.api.mapper.ProjectMapper;
import com.cloud.api.mapper.QuotaMapper;
import com.cloud.api.mapper.UserMapper;
import com.cloud.api.mapper.UserRoleProMapper;
import com.cloud.api.service.ProjectService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;

/**
 * @author huang_kefei
 * @date 2018年10月9日 类说明
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectServiceImpl extends BaseService implements ProjectService {

	private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectMapper projectMapper;

	@Autowired
	private QuotaMapper quotaMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ProjectForUpdateMapper projectForUpdateMapper;
	
	@Autowired
	private UserRoleProMapper userRoleProMapper;

	@Value("${cloud.workflow.url}")
	private String workflowUrl;
	
	@Value("${EMailHost}")
	private String emailHost;
	
	@Value("${EMailUser}")
	private String emailUser;
	
	@Value("${EMailPWD}")
	private String emailPwd;
	
	@Value("${EMailFrom}")
	private String emailFrom;

	@Override
	public void deleteProject(String projectId, TokenDO token) {

		ProjectDTO project = projectMapper.selectByPrimaryKey(projectId);
		projectMapper.deleteByPrimaryKey(projectId);
		
		UserRoleProDTOExample example = new UserRoleProDTOExample();
		com.cloud.api.dto.UserRoleProDTOExample.Criteria criteria = example.createCriteria();
		criteria.andProIdEqualTo(projectId);
		userRoleProMapper.deleteByExample(example);

		DeleteProjectToOSReq deleteProjectToOSReq = new DeleteProjectToOSReq();
		deleteProjectToOSReq.setOrphanDependents(true);

		try {
			Invocation<DeleteProjectToOSReq> project_invocation = delete(DeleteProjectToOSReq.class,
					"/apis/project.openshift.io/v1/projects/" + project.getName(), token).entity(deleteProjectToOSReq);
			project_invocation.executeWithResponse();
		} catch (Exception e) {
			//openshift 删除失败，不影响本地删除
		}
		

	}

	@Override
	public ProjectDTO queryProjectById(String projectId) {
		return projectMapper.selectByPrimaryKey(projectId);
	}

	@Override
	public void updateProject(String projectId, ProjectRequest request, String userName) {
		ProjectDTO projectDto = projectMapper.selectByPrimaryKey(projectId);
		if(projectDto.getUpdateStatus()==1) {
			throw new ServiceException("The project is in the process of being modified!");
		}
		// 如果修改了资源数据要走流程
		if (projectDto.getCpuQuota().compareTo(request.getCpuQuota())!=0 || projectDto.getMemoryQuota().compareTo(request.getMemoryQuota())!=0
				|| projectDto.getPodsQuota()!=request.getPodsQuota()) {
			// 先判断是否是admin修改,是不走流程
			String resJson = "";
			try {
				resJson = HttpAgent.doGet(workflowUrl + "/workflow/auth", "userName=" + userName, "UTF-8");
			} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                        + resJson.toString());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if (!((boolean) JsonUtils.jsonToObject(resJson, Map.class).get("isAdmin"))) {
				// 流程是新建的，但是project还是在原基础上修改
				AddProjectApplyRequest applyRequest = new AddProjectApplyRequest();
				applyRequest.setApplyUser(userName);
				applyRequest.setReason(request.getReason());
				applyRequest.setApplyType(Constants.PROJECT_APPLY_TYPE);
				applyRequest.setStatus(Constants.PROJECT_APPLY_STATUS);
				applyRequest.setActionType(Constants.ACTION_TYPE_EDIT);
				applyRequest.setApplyTitle("Apply " + projectDto.getName() + " " + Constants.PROJECT_APPLY_TYPE);
				String reqJson = JsonUtils.objectToJson(applyRequest);
				String respJson = "";
				try {
					respJson = new HttpAgent(workflowUrl + "/workflow/applyProcess").doPost(reqJson);
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				ProjectForUpdateDTO projectForUpdate = new ProjectForUpdateDTO();
				projectForUpdate.setUuid(IdGen.uuid());
				projectForUpdate.setName(request.getName());
				projectForUpdate.setDisplayName(request.getDisplayName());
				projectForUpdate.setCpuQuota(request.getCpuQuota());
				projectForUpdate.setMemoryQuota(request.getMemoryQuota());
				projectForUpdate.setPodsQuota(request.getPodsQuota());
				projectForUpdate.setApproveStatus(0); // 0-申请中待审批 ；1-审批中；2-审批结束；3驳回
				projectForUpdate.setCreatedTime(new Date());
				projectForUpdate.setDescription(request.getDescription());
				projectForUpdate.setApplyUser(userName);
				projectForUpdate.setTaskId((String) JsonUtils.jsonToObject(respJson, Map.class).get("processId"));
				projectForUpdate.setOriginTaskId(projectDto.getTaskId());
				projectForUpdateMapper.insertSelective(projectForUpdate);
				projectDto.setUpdateStatus(1); //0-未修改；1-申请修改中；2-修改审批结束
				
				//发邮件
//				UserRoleProDTOExample example = new UserRoleProDTOExample();
//				com.cloud.api.dto.UserRoleProDTOExample.Criteria criteria = example.createCriteria();
//				criteria.andRoleIdEqualTo(Constants.ADMIN_ROLE_ID);
//				List<UserRoleProDTO> userRoleProList= userRoleProMapper.selectByExample(example);
//				for(UserRoleProDTO userRoleProDTO : userRoleProList) {
//					UserDTO user = userMapper.selectByPrimaryKey(userRoleProDTO.getUserId());
//					String notifiSubject = "You have a new process to deal with!";
//					StringBuilder rs = new StringBuilder();
//					rs.append("Dear "+ user.getUserName());
//					rs.append("\r\n");
//					rs.append(userName+" has updated a project,please deal with it in time.");
//					rs.append("\r\n");
//					rs.append("\r\n");
//					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//					rs.append(formatter.format(new Date()));
//					EmailUtils.sendEmail(emailHost, emailUser, emailPwd, emailFrom, user.getMail(), notifiSubject, rs.toString());
//				}
				
			}

		}else {
			// 否则直接修改
			projectDto.setDisplayName(request.getDisplayName());
			projectDto.setDescription(request.getDescription());
		}
		projectMapper.updateByPrimaryKeySelective(projectDto);
	}

	@Override
	public List<ProjectDTO> queryAllProject(String regionId, String userName) {
		Map<String, Object> idMap = userMapper.queryUserByName(userName);
		String userId = (String) idMap.get("uuid");
		
		UserRoleProDTOExample example = new UserRoleProDTOExample();
		com.cloud.api.dto.UserRoleProDTOExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<UserRoleProDTO> userRoleProList= userRoleProMapper.selectByExample(example);
		for(UserRoleProDTO userRoleProDTO : userRoleProList) {
			//是管理员则查该region下的所有project
			if(Constants.ADMIN_ROLE_ID.equals(userRoleProDTO.getRoleId())) {
				ProjectDTOExample exampleAll = new ProjectDTOExample();
				Criteria criteriaAll = exampleAll.createCriteria();
				criteriaAll.andRegionIdEqualTo(regionId);
				criteriaAll.andApproveStatusEqualTo(2);
				List<ProjectDTO> projectAllList = projectMapper.selectByExample(exampleAll);
				return projectAllList;
			}
		}
		List<ProjectDTO> projectList = projectMapper.queryAllProjectByUserAndRegion(regionId, 2, userId);
		return projectList;
	}

	@Override
	public ProjectDTO queryProjectByName(String name) {
		ProjectDTOExample example = new ProjectDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<ProjectDTO> projectList = projectMapper.selectByExample(example);
		if (projectList.size() > 0) {
			return projectList.get(0);
		}
		return null;
	}

	@Override
	public void addProject(String regionId, ProjectRequest request, TokenDO token) {

		// 判断用户是否为最终审批人，若是，不走流程
		String resJson = "";
		try {
			resJson = HttpAgent.doGet(workflowUrl + "/workflow/auth", "userName=" + token.getUserName(),
					"UTF-8");
			//判断流程是否启用，used=0 不启用，used=1 启用
			String resUsedJson = HttpAgent.doGet(workflowUrl + "/workflow/processes", "type=" + Constants.PROJECT_APPLY_TYPE, "UTF-8");
			if ((boolean) JsonUtils.jsonToObject(resJson, Map.class).get("isAdmin")
					||JsonUtils.jsonToObject(resUsedJson, Map.class).get("used").equals("0")) {
				QuotaDTOExample example = new QuotaDTOExample();
				com.cloud.api.dto.QuotaDTOExample.Criteria criteria = example.createCriteria();
				criteria.getAllCriteria();
				List<QuotaDTO> quotaList = quotaMapper.selectByExample(example);
				// 不走流程，所以要判断
				if (quotaList.size() > 0) {
					QuotaDTO quota = quotaList.get(0);
					if (quota.getCpuRest().compareTo(request.getCpuQuota()) > 0
							&& quota.getMemoryRest().compareTo(request.getMemoryQuota()) > 0
							&& quota.getPodsRest().compareTo(request.getPodsQuota()) > 0) {

						ProjectDTO project = new ProjectDTO();
						project.setUuid(IdGen.uuid());
						project.setName(request.getName());
						project.setDisplayName(request.getDisplayName());
						project.setCpuQuota(request.getCpuQuota());
						project.setMemoryQuota(request.getMemoryQuota());
						project.setPodsQuota(request.getPodsQuota());
						project.setApproveStatus(2); // 0-申请中待审批 ；1-审批中；2-审批结束；3驳回
						project.setCreatedTime(new Date());
						project.setDescription(request.getDescription());
						project.setApplyUser(token.getUserName());
						project.setRegionId(regionId);
						projectMapper.insertSelective(project);
						
						Map<String, Object> idMap = userMapper.queryUserByName(token.getUserName());
						UserRoleProDTO userRoleProDTO = new UserRoleProDTO();
						userRoleProDTO.setCreatedTime(new Date());
						userRoleProDTO.setCreater(token.getUserName());
						userRoleProDTO.setProId(project.getUuid());
						userRoleProDTO.setRoleId(Constants.PROJECT_ROLE_ID);
						userRoleProDTO.setRstatus(0);
						userRoleProDTO.setUserId((String) idMap.get("uuid"));
						userRoleProMapper.insertSelective(userRoleProDTO);
						
						approveProject(project, token, token, Constants.ACTION_TYPE);
					}
				}
			} else {
				// 不是最终审批者，走流程
				AddProjectApplyRequest applyRequest = new AddProjectApplyRequest();
				applyRequest.setApplyUser(token.getUserName());
				applyRequest.setReason(request.getReason());
				applyRequest.setApplyType(Constants.PROJECT_APPLY_TYPE);
				applyRequest.setStatus(Constants.PROJECT_APPLY_STATUS);
				applyRequest.setActionType(Constants.ACTION_TYPE);
				applyRequest.setApplyTitle("Apply " + request.getName() + " " + Constants.PROJECT_APPLY_TYPE);
				try {
					// taskid为空就是首次申请
					if (request.getTaskId() == null || request.getTaskId() == "") {
						String reqJson = JsonUtils.objectToJson(applyRequest);
						String respJson = new HttpAgent(workflowUrl + "/workflow/applyProcess").doPost(reqJson);
						
						ProjectDTO project = new ProjectDTO();
						project.setUuid(IdGen.uuid());
						project.setName(request.getName());
						project.setDisplayName(request.getDisplayName());
						project.setCpuQuota(request.getCpuQuota());
						project.setMemoryQuota(request.getMemoryQuota());
						project.setPodsQuota(request.getPodsQuota());
						project.setTaskId((String) JsonUtils.jsonToObject(respJson, Map.class).get("processId"));
						project.setApproveStatus(0); // 0-申请中待审批 ；1-审批中；2-审批结束；3驳回
						project.setCreatedTime(new Date());
						project.setDescription(request.getDescription());
						project.setApplyUser(token.getUserName());
						project.setRegionId(regionId);
						projectMapper.insertSelective(project);
						
						Map<String, Object> idMap = userMapper.queryUserByName(token.getUserName());
						UserRoleProDTO userRoleProDTO = new UserRoleProDTO();
						userRoleProDTO.setCreatedTime(new Date());
						userRoleProDTO.setCreater(token.getUserName());
						userRoleProDTO.setProId(project.getUuid());
						userRoleProDTO.setRoleId(Constants.PROJECT_ROLE_ID);
						userRoleProDTO.setRstatus(0);
						userRoleProDTO.setUserId((String) idMap.get("uuid"));
						userRoleProMapper.insertSelective(userRoleProDTO);
						
					} else {// 不为空就是拒绝后再申请

						ProjectDTOExample example = new ProjectDTOExample();
						Criteria criteria = example.createCriteria();
						criteria.andTaskIdEqualTo(request.getProcessId());
						List<ProjectDTO> projectList = projectMapper.selectByExample(example);
						ProjectDTO project = new ProjectDTO();
						if (projectList.size() > 0) {
							project = projectList.get(0);
						}
						project.setName(request.getName());
						project.setDisplayName(request.getDisplayName());
						project.setCpuQuota(request.getCpuQuota());
						project.setMemoryQuota(request.getMemoryQuota());
						project.setPodsQuota(request.getPodsQuota());
						project.setApproveStatus(0); // 0-申请中待审批 ；1-审批中；2-审批结束；3驳回
						project.setUpdatedTime(new Date());
						project.setDescription(request.getDescription());
						project.setApplyUser(token.getUserName());
						projectMapper.updateByExampleSelective(project, example);

						applyRequest.setTaskId(request.getTaskId());
						String reqJson = JsonUtils.objectToJson(applyRequest);
						new HttpAgent(workflowUrl + "/workflow/applyProcess").doPost(reqJson);
					}
					
					//发邮件
//					UserRoleProDTOExample example = new UserRoleProDTOExample();
//					com.cloud.api.dto.UserRoleProDTOExample.Criteria criteria = example.createCriteria();
//					criteria.andRoleIdEqualTo(Constants.ADMIN_ROLE_ID);
//					List<UserRoleProDTO> userRoleProList= userRoleProMapper.selectByExample(example);
//					for(UserRoleProDTO userRoleProDTO : userRoleProList) {
//						UserDTO user = userMapper.selectByPrimaryKey(userRoleProDTO.getUserId());
//						String notifiSubject = "You have a new process to deal with!";
//						StringBuilder rs = new StringBuilder();
//						rs.append("Dear "+ user.getUserName());
//						rs.append("\r\n");
//						rs.append(token.getUserName()+" has applyed a project,please deal with it in time.");
//						rs.append("\r\n");
//						rs.append("\r\n");
//						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//						rs.append(formatter.format(new Date()));
//						EmailUtils.sendEmail(emailHost, emailUser, emailPwd, emailFrom, user.getMail(), notifiSubject, rs.toString());
//					}
					
				} catch (ClientProtocolException e) {
					logger.error(e.getMessage());
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		} catch (ServiceException e) {
			throw new ServiceException("Invalide response from Api!"
                    + resJson.toString());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public QuotaResponse quotas(String regionId) {
		QuotaDTOExample example = new QuotaDTOExample();
		com.cloud.api.dto.QuotaDTOExample.Criteria criteria = example.createCriteria();
		criteria.andRegionIdEqualTo(regionId);
		List<QuotaDTO> quotaList = quotaMapper.selectByExample(example);
		QuotaDTO quota = new QuotaDTO();
		if (quotaList.size() > 0) {
			quota = quotaList.get(0);
		}

		QuotaResponse quotaResponse = new QuotaResponse();
		quotaResponse.setCpuRest(quota.getCpuRest());
		quotaResponse.setMemoryRest(quota.getMemoryRest());
		quotaResponse.setPodsRest(quota.getPodsRest());
		quotaResponse.setCpuTotal(quota.getCpuTotal());
		quotaResponse.setMemoryTotal(quota.getMemoryTotal());
		quotaResponse.setPodsTotal(quota.getPodsTotal());
		return quotaResponse;
	}

	@Override
	public void approveProject(ProjectDTO project, TokenDO tokenQuota, TokenDO tokenProject, String actionType) {
		ProjectPostDetailDO projectPostDO = new ProjectPostDetailDO();
		QuotasPostDetailDO quotaPostDO = new QuotasPostDetailDO();

		projectPostDO.setKind(Constants.PROJECT_KIND);
		projectPostDO.setApiVersion(Constants.PORJECT_APIVERSION);
		MetaDataDO metadata_project = new MetaDataDO();
		metadata_project.setName(project.getName());
		projectPostDO.setMetadata(metadata_project);

		quotaPostDO.setApiVersion(Constants.SERVICE_APIVERSION);
		quotaPostDO.setKind(Constants.RESOURCEQUOTA_KIND);

		MetaDataDO metadata_quota = new MetaDataDO();
		metadata_quota.setName(project.getName() + "-quota");
		metadata_quota.setNamespace(project.getName());
		quotaPostDO.setMetadata(metadata_quota);

		ProjectSpecDO projectSpec = new ProjectSpecDO();
		ProjectHard hard = new ProjectHard();
		hard.setLimitsMemory(project.getMemoryQuota().toString() + "Mi");
		hard.setLimitsCpu(project.getCpuQuota().toString());
		hard.setPods(project.getPodsQuota().toString());
		hard.setRequestsCpu(project.getCpuQuota().toString());
		hard.setRequestsMemory(project.getMemoryQuota().toString() + "Mi");
		projectSpec.setHard(hard);
		quotaPostDO.setSpec(projectSpec);
		String quotaPostDOJson = JsonUtils.objectToJson(quotaPostDO);

		if(Constants.ACTION_TYPE.equals(actionType)) {
			Invocation<ProjectPostDetailDO> invocation_p = post(ProjectPostDetailDO.class,
					"/apis/project.openshift.io/v1/projectrequests", tokenProject).entity(projectPostDO);
			invocation_p.executeWithResponse();

			Invocation<QuotasPostDetailDO> invocation_q = post(QuotasPostDetailDO.class,
					"/api/v1/namespaces/" + project.getName() + "/resourcequotas", tokenQuota).json(quotaPostDOJson);
			invocation_q.executeWithResponse();
		}else if(Constants.ACTION_TYPE_EDIT.equals(actionType)) {
			
			Invocation<QuotasPostDetailDO> invocation_q = put(QuotasPostDetailDO.class,
					"/api/v1/namespaces/" + project.getName() + "/resourcequotas/"+project.getName() + "-quota", tokenQuota).json(quotaPostDOJson);
			invocation_q.executeWithResponse();
		}

	}

	@Override
	public ProjectDTO queryProjectByRegionIdAndProjectName(String regionId, String projectName) {
		ProjectDTOExample example =new ProjectDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.andRegionIdEqualTo(regionId);
		criteria.andNameEqualTo(projectName);
		List<ProjectDTO> projects = projectMapper.selectByExample(example);
		if(projects!=null&&!projects.isEmpty()) {
			return projects.get(0);
		}else {
			throw new ParamInvalidException("Can not find project in this region!");
		}
		
	}

}
