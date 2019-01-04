/**
 * 
 */
package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.AppInstanceDTO;
import com.cloud.api.dto.ApplicationDTO;
import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.dto.RouteDTO;
import com.cloud.api.dto.ServiceDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.InstanceRequest;
import com.cloud.api.entity.request.TemplateRequest;

/**
 * @author zhao_pengchen
 *
 */
public interface AppInstanceService {
	
	void deleteAppInstance(String uuid, TokenDO token, String project);

	void editAppInstanceByAppId(TokenDO token, InstanceRequest requestData, String uuid, String project);
	
	List<AppInstanceDTO> queryByTemplateId(String templateId);
	
	DeploymentDTO getInstanceDeployment(String instanceId);
	
	RouteDTO getInstanceRoute(String instanceId);
	
	ServiceDTO getInstanceService(String instanceId);

	long countAppInstance(String applicationId);

	List<AppInstanceDTO> filterInstance(List<GetListParamElement> filterList, String applicationId);
	
}
