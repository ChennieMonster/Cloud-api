package com.cloud.api.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.exception.ResourcesNotFoundException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.RouteDTO;
import com.cloud.api.dto.RouteDTOExample;
import com.cloud.api.dto.RouteDTOExample.Criteria;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.MqMessage;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.mapper.RouteMapper;
import com.cloud.api.service.MQMessageService;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.RouteService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.annotation.Operation;

@Service
@Transactional(rollbackFor = Exception.class)
public class RouteServiceImpl extends BaseService implements RouteService {
	@Autowired
	private MQMessageService mqMessageService;

	@Autowired
	private RouteMapper routeMapper;
	
	@Autowired
	private ProjectService projectService;

	@Override
	public RouteDTO queryRouteByInstanceId(String instanceId) {
		RouteDTOExample example = new RouteDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstanceIdEqualTo(instanceId);
		List<RouteDTO> list = routeMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Operation(action = "add route", resourceType = "route")
	public int insertRoute(AppInstanceDetailDO appInstanceDetail, String instanceId, TokenDO token, String project) {

		// 发送openshift请求
		String url = "/apis/route.openshift.io/v1/namespaces/" + project + "/routes";
		Invocation<AppInstanceDetailDO> invocation = post(AppInstanceDetailDO.class, url, token)
				.entity(appInstanceDetail);
		CloseableHttpResponse response = invocation.executeWithResponse();

		// 插入DB
		RouteDTO routeDTO = new RouteDTO();
		routeDTO.setApiVersion(appInstanceDetail.getApiVersion());
		routeDTO.setKind(appInstanceDetail.getKind());
		routeDTO.setMetadata(JsonUtils.objectToJson(appInstanceDetail.getMetadata()));
		routeDTO.setSpec(JsonUtils.objectToJson(appInstanceDetail.getSpec()));
		routeDTO.setInstanceId(instanceId);
		routeDTO.setUuid(IdGen.uuid());
		routeDTO.setCreatedTime(new Date());
		routeDTO.setName(appInstanceDetail.getMetadata().getName());
		String projectId = projectService.queryProjectByRegionIdAndProjectName(MDCConstants.REGION_ID, project).getUuid();
		routeDTO.setProject(projectId);
		routeMapper.insertSelective(routeDTO);

		// 发送rabbitmq消息
		MqMessage msg = new MqMessage();
		msg.setRoutName(appInstanceDetail.getMetadata().getName());
		msg.setProject(project);
		msg.setUuid(routeDTO.getUuid());
		msg.setKind(routeDTO.getKind());
		msg.setTokenDO(token);
		msg.setRegion(MDC.get(MDCConstants.REGION_ID));
		mqMessageService.sendMqMessage(msg);
		return 1;
	}

	@Override
	@Operation(action = "delete route", resourceType = "route")
	public int deleteRoute(String instanceId, String routeName, TokenDO token, String project) {

		// 发送openshift请求
		try {
			Invocation<AppInstanceDetailDO> invocation = delete(AppInstanceDetailDO.class,
					"/apis/route.openshift.io/v1/namespaces/" + project + "/routes/" + routeName, token);
			System.out.println("##########################invocation:" + invocation);
			CloseableHttpResponse response = invocation.executeWithResponse();
			System.out.println("####################reponse" + response.toString());
		} catch (ResourcesNotFoundException e) {
			// log
		}

		// 删除DB中对应的route
		RouteDTOExample example = new RouteDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstanceIdEqualTo(instanceId);
		criteria.andNameEqualTo(routeName);
		return routeMapper.deleteByExample(example);
//		return 0;
	}

	@Override
	@Operation(action = "edit route", resourceType = "route")
	public int updateRoute(String instanceId, String routeName, AppInstanceDetailDO appInstanceDetail, TokenDO token,
			String project) {

		// 发送openshift请求
		Invocation<AppInstanceDetailDO> invocation = put(AppInstanceDetailDO.class,
				"/apis/route.openshift.io/v1/namespaces/" + project + "/routes/" + routeName, token)
						.entity(appInstanceDetail);
		System.out.println("##########################invocation:" + invocation);
		CloseableHttpResponse response = invocation.executeWithResponse();
		System.out.println("####################reponse" + response.toString());

		// 更新DB
		RouteDTO routeDTO = new RouteDTO();
		routeDTO.setApiVersion(appInstanceDetail.getApiVersion());
		routeDTO.setKind(appInstanceDetail.getKind());
		routeDTO.setMetadata(JsonUtils.objectToJson(appInstanceDetail.getMetadata()));
		routeDTO.setSpec(JsonUtils.objectToJson(appInstanceDetail.getSpec()));
		routeDTO.setUpdatedTime(new Date());

		RouteDTOExample example = new RouteDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstanceIdEqualTo(instanceId);
		return routeMapper.updateByExampleSelective(routeDTO, example);
	}

	@Override
	public List<RouteDTO> queryAllRoutes() {
		RouteDTOExample example = new RouteDTOExample();
		List<RouteDTO> list = routeMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<RouteDTO> queryRouteByProject(String project) {
		// TODO Auto-generated method stub
		RouteDTOExample example = new RouteDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andProjectEqualTo(project);
		return routeMapper.selectByExample(example);
	}

	@Override
	public RouteDTO queryRouteById(String uuid) {
		// TODO Auto-generated method stub
		return routeMapper.selectByPrimaryKey(uuid);
	}

}
