/**
 * 
 */
package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.ApplicationDTO;
import com.cloud.api.entity.ApplicationDetailDO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ApplicationRequest;
import com.cloud.api.entity.request.TemplateRequest;

/**
 * @author zhao_pengchen
 *
 */
public interface ApplicationService {

	ApplicationDetailDO getApplicationDetail(String uuid);
	
	List<ApplicationDTO> getApplications();
	
	void addApplication(ApplicationRequest requestData, TokenDO token,String regionId, String project);
	
	boolean deleteApplications(TokenDO token, List<String> ids, String project);
	
	void updateApplication(TokenDO token, ApplicationRequest requestData, String uuid, String project);
	
	List<ApplicationDTO> filterApplication(List<GetListParamElement> filterList, String regionId, String project);
	
	long countApplication();
	
}
