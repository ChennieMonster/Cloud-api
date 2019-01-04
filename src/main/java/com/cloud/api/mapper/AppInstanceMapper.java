/**
 * 
 */
package com.cloud.api.mapper;

import java.util.List;


import com.cloud.api.dto.AppInstanceDTO;
import com.cloud.api.dto.AppInstanceDTOExample;
import com.cloud.api.dto.ApplicationDTOExample;

/**
 * @author zhao_pengchen
 *
 */
public interface AppInstanceMapper {

	List<AppInstanceDTO> queryAppInstanceList(String userID, String type);
	
	int insertAppInstance(AppInstanceDTO appInstanceDto);
	
	int deleteAppInstances(List<String> ids);
	
	int deleteAppInstance(String uuid);
	
	int updateAppInstanceByAppId(AppInstanceDTO appInstanceDTO);
	
	int updateAppInstanceByTempId(AppInstanceDTO appInstanceDTO);
	
	int updateInstanceById(AppInstanceDTO appInstanceDTO);
	
	List<AppInstanceDTO> queryByTemplateId(String templateId);
	
	List<AppInstanceDTO> queryByApplicationId(String applicationId);
	
	AppInstanceDTO queryByName(String name);
	
	AppInstanceDTO queryById(String uuid);

	long countByExample(AppInstanceDTOExample example);

	List<AppInstanceDTO> selectByExample(AppInstanceDTOExample example);

}
