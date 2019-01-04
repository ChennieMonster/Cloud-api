package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ProjectRequest;
import com.cloud.api.entity.response.QuotaResponse;


/**
 * @author huang_kefei
 * @date 2018年10月9日 类说明
 */
public interface ProjectService {
	
	ProjectDTO queryProjectById(String projectId);

	void updateProject(String projectId, ProjectRequest request, String userName);
	
	List<ProjectDTO> queryAllProject(String regionId, String userName);
	
	ProjectDTO queryProjectByName(String name);
	
	void addProject(String regionId, ProjectRequest request, TokenDO token);
	
	void deleteProject(String projectId, TokenDO token);
	
	QuotaResponse quotas(String regionId);
	
	void approveProject(ProjectDTO project,TokenDO tokenApply, TokenDO token, String actionType);
	
	ProjectDTO queryProjectByRegionIdAndProjectName(String regionId , String projectName);
}
