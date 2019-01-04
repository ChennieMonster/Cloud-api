package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.RouteDTO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.TokenDO;

public interface RouteService {
	/**
	 * 根据实例ID和route名称查询route
	 * 
	 * @param instanceId 实例ID
	 * @param routeName route名称
	 * @return
	 */
	RouteDTO queryRouteByInstanceId(String instanceId);

	/**
	 * 查询实例下的所有route
	 * 
	 * @param instanceId
	 * @return
	 */
	List<RouteDTO> queryAllRoutes();

	/**
	 * 新增route
	 * 
	 * @param routeDTO route对象
	 * @param token
	 * @return
	 */
	int insertRoute(AppInstanceDetailDO appInstanceDetail, String instanceId, TokenDO token, String project);

	/**
	 * 根据实例ID删除route
	 * 
	 * @param instanceId 实例ID
	 * @return
	 */
	int deleteRoute(String instanceId,String routeName, TokenDO token,String project);

	/**
	 * 修改route
	 * 
	 * @param routeName
	 * @return
	 */
	int updateRoute(String instanceId, String routeName, AppInstanceDetailDO appInstanceDetail,
			TokenDO token,String project);

	List<RouteDTO> queryRouteByProject(String project);
	
	RouteDTO queryRouteById(String uuid);
}
