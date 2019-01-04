package com.cloud.api.service;


import java.util.List;



import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.TokenDO;


/**
* @author huang_kefei
* @date 2018年9月28日
* 类说明
*/
public interface DeploymentService {

	int addOpenShiftDeployment(AppInstanceDetailDO appInstanceDetailDO,String instanceId,TokenDO token,String project);
	
//	String getOpenShiftDeployment(String instanceId,TokenDO token ,String DeploymentName);
	
	AppInstanceDetailDO updateOpenShiftDeployment(AppInstanceDetailDO appInstanceDetailDO,String instanceId,TokenDO token,String project);
	
	int deleteOpenShiftDeployment(String instanceId,TokenDO token ,String DeploymentName,String project);
	
	DeploymentDTO getDeploymentByInstanceId(String instanceId);
	
	List<DeploymentDTO> getAllDeployment();
	
	DeploymentDTO getDeploymentByName(String name);
	
	AppInstanceDetailDO getDeploymentDO(String instanceId);
	
	AppInstanceDetailDO getOpenshiftDeployment(String project,String deploymentName,TokenDO token);
	
}
