package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.ServiceDTO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.response.ServiceDetailResponse;

public interface ServiceService {

	/**
	 * 根据实例ID查询实例下的所有service
	 * 
	 * @param instanceId 实例ID
	 * @return
	 */
	List<ServiceDTO> queryAllServices();

	/**
	 * 新增service
	 * 
	 * @param serviceDTO service对象
	 * @return
	 */
	int insertService(AppInstanceDetailDO appInstanceDetail, String instanceId, TokenDO token,String project);

	/**
	 * 根据实例Id删除service
	 * 
	 * @param instanceId 实例ID
	 * @return
	 */
	int deleteService(String instanceId, String serviceName, TokenDO token, String project);

	/**
	 * 查询所有service
	 * 
	 * @param token
	 * @return
	 */
	ServiceDTO queryServiceByInstanceId(String instanceId);

	/**
	 * 修改service
	 * 
	 * @param routeName
	 * @param token
	 * @return
	 */
	ServiceDetailResponse updateServiceByInstanceId(String instanceId,  AppInstanceDetailDO appInstanceDetail,
			TokenDO token,String project);
	
	ServiceDTO queryServiceByName(String name);
	
	List<ServiceDTO> queryServiceByProject(String project);
	
	ServiceDTO queryServiceById(String uuid);
	
}
