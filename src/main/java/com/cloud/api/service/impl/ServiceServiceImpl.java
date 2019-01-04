package com.cloud.api.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.exception.ResourcesNotFoundException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.ServiceDTO;
import com.cloud.api.dto.ServiceDTOExample;
import com.cloud.api.dto.ServiceDTOExample.Criteria;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.MqMessage;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.response.AppinstanceResponse;
import com.cloud.api.entity.response.ServiceDetailResponse;
import com.cloud.api.mapper.ServiceMapper;
import com.cloud.api.service.MQMessageService;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.ServiceService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.annotation.Operation;

@Service
@Transactional
public class ServiceServiceImpl extends BaseService implements ServiceService {

	private final static Logger logger = LoggerFactory.getLogger(ServiceServiceImpl.class);

	@Autowired
	private MQMessageService mqMessageService;

	@Autowired
	private ServiceMapper serviceMapper;
	
	@Autowired
	private ProjectService projectService;

	@Override
	public List<ServiceDTO> queryAllServices() {
		List<ServiceDTO> list = serviceMapper.selectByExample(new ServiceDTOExample());
		return list;
	}

	@Override
	@Operation(action = "add service", resourceType = "service")
	public int insertService(AppInstanceDetailDO appInstanceDetail, String instanceId, TokenDO token, String project) {

		String returnMessage = "";
		try {
			// 发送openshift请求
			String url = "/api/v1/namespaces/" + project + "/services";
			Invocation<AppInstanceDetailDO> invocation = post(AppInstanceDetailDO.class, url, token)
					.entity(appInstanceDetail);
			CloseableHttpResponse response = invocation.executeWithResponseNotClose();
			returnMessage = EntityUtils.toString(response.getEntity());
			response.close();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		JsonNode node = JsonUtils.strToJsonNode(returnMessage);
		String ip = "";
		if(node!=null) {
			ip = node.path("spec").path("clusterIP").toString().replace("\"", "");
		}
		// 插入DB
		ServiceDTO serviceDTO = new ServiceDTO();
		serviceDTO.setApiVersion(appInstanceDetail.getApiVersion());
		serviceDTO.setKind(appInstanceDetail.getKind());
		serviceDTO.setMetadata(JsonUtils.objectToJson(appInstanceDetail.getMetadata()));
		serviceDTO.setSpec(JsonUtils.objectToJson(appInstanceDetail.getSpec()));
		serviceDTO.setUuid(IdGen.uuid());
		serviceDTO.setCreatedTime(new Date());
		serviceDTO.setInstanceId(instanceId);
		serviceDTO.setIp(ip);
		serviceDTO.setName(appInstanceDetail.getMetadata().getName());
		String projectId=projectService.queryProjectByRegionIdAndProjectName(MDC.get(MDCConstants.REGION_ID), project).getUuid();
		serviceDTO.setProject(projectId);

		int ret = serviceMapper.insertSelective(serviceDTO);

		// 发送rabbitmq消息
		MqMessage msg = new MqMessage();
		msg.setSercviceName(appInstanceDetail.getMetadata().getName());
		msg.setUuid(serviceDTO.getUuid());
		msg.setTokenDO(token);
		msg.setKind(appInstanceDetail.getKind());
		msg.setProject(project);
		msg.setRegion(MDC.get(MDCConstants.REGION_ID));
		mqMessageService.sendMqMessage(msg);
		logger.warn("=====================发送消息add Service" + msg.getSercviceName());
		return ret;
	}

	@Override
	@Operation(action = "delete service", resourceType = "service")
	public int deleteService(String instanceId, String serviceName, TokenDO token, String project) {

		// 发送openshift请求
		try {
			Invocation<ServiceDTO> invocation = delete(ServiceDTO.class,
					"/api/v1/namespaces/" + project + "/services/" + serviceName, token);
			invocation.executeWithResponse();
		} catch (ResourcesNotFoundException e) {
			// log
			logger.warn("delete service 404");
		}

		// 删除DB
		ServiceDTOExample example = new ServiceDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstanceIdEqualTo(instanceId);
		criteria.andNameEqualTo(serviceName);
		return serviceMapper.deleteByExample(example);

	}

	@Override
	public ServiceDTO queryServiceByInstanceId(String instanceId) {
		ServiceDTOExample example = new ServiceDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstanceIdEqualTo(instanceId);
		List<ServiceDTO> list = serviceMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	@Operation(action = "edit service", resourceType = "service")
	public ServiceDetailResponse updateServiceByInstanceId(String instanceId, AppInstanceDetailDO appInstanceDetail, TokenDO token,
			String project) {
		// get servcieName from instanceId
		ServiceDTOExample exampleName = new ServiceDTOExample();
		Criteria criteria2 = exampleName.createCriteria();
		criteria2.andInstanceIdEqualTo(instanceId);
		List<ServiceDTO> serviceList = serviceMapper.selectByExample(exampleName);
		String serviceName = "";
		// 获取serviceName和DTO
		ServiceDTO serviceDB = new ServiceDTO();
		if (serviceList != null && !serviceList.isEmpty()) {
			serviceName = serviceList.get(0).getName();
			serviceDB = serviceList.get(0);
		}
		// set a full AppInstanceDetailDO
		// 将DTO组装成DO
		AppInstanceDetailDO updateDO = new AppInstanceDetailDO();
		updateDO.setApiVersion(serviceDB.getApiVersion());
		updateDO.setKind(serviceDB.getKind());
		updateDO.setMetadata(JsonUtils.jsonToObject(serviceDB.getMetadata(), MetaDataDO.class));

		// 将portsDO赋值
		SpecDO updateSpecDO = JsonUtils.jsonToObject(serviceDB.getSpec(), SpecDO.class);
//		List<PortsDO> posts=new ArrayList<PortsDO>();
		if (appInstanceDetail.getSpec() != null) {
			updateSpecDO.setPorts(appInstanceDetail.getSpec().getPorts());
//			posts=appInstanceDetail.getSpec().getPorts();
		}
		updateDO.setSpec(updateSpecDO);
		AppinstanceResponse serviceResponse=null;
		// 发送openshift请求
		try {
			// put时service的resourceVersion必须与之前相同，patch过复杂
			Invocation<AppInstanceDetailDO> invocation = put(AppInstanceDetailDO.class,
					"/api/v1/namespaces/" + project + "/services/" + serviceName, token).entity(updateDO);
			CloseableHttpResponse response = invocation.executeWithResponseNotClose();
			String responseStr = EntityUtils.toString(response.getEntity());
			response.close();
			 serviceResponse = JsonUtils.jsonToObject(responseStr, AppinstanceResponse.class);

			// 从openshift更新新的数据到DB
			serviceDB.setApiVersion(serviceResponse.getApiVersion());
			serviceDB.setKind(serviceResponse.getKind());
			serviceDB.setMetadata(JsonUtils.objectToJson(serviceResponse.getMetadata()));
			serviceDB.setSpec(JsonUtils.objectToJson(serviceResponse.getSpec()));
			serviceDB.setUpdatedTime(new Date());
			// 更新DB
			ServiceDTOExample example = new ServiceDTOExample();
			Criteria criteria = example.createCriteria();
			criteria.andInstanceIdEqualTo(instanceId);
			serviceMapper.updateByExampleSelective(serviceDB, example);
		} catch (ResourcesNotFoundException | ParseException | IOException e) {
			logger.warn("openshift 404");
		}
		ServiceDetailResponse response =new ServiceDetailResponse();
		if(serviceResponse!=null&&serviceResponse.getMetadata()!=null&&serviceResponse.getSpec()!=null) {
			response.setInstanceId(instanceId);
			response.setIp(serviceResponse.getSpec().getClusterIP());
			if(serviceResponse.getMetadata().getLabels()!=null) {
				response.setLabels(serviceResponse.getMetadata().getLabels().get("app"));
			}
			response.setName(serviceResponse.getMetadata().getName());
			response.setPorts(serviceResponse.getSpec().getPorts());
			response.setSessionAffinity(serviceResponse.getSpec().getSessionAffinity());
			response.setType(serviceResponse.getSpec().getType());
		}
		return response;
	}

	@Override
	public ServiceDTO queryServiceByName(String name) {
		ServiceDTOExample example = new ServiceDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<ServiceDTO> list = serviceMapper.selectByExample(example);
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<ServiceDTO> queryServiceByProject(String project) {
		// TODO Auto-generated method stub
		ServiceDTOExample example = new ServiceDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andProjectEqualTo(project);
		return serviceMapper.selectByExample(example);
	}

	@Override
	public ServiceDTO queryServiceById(String uuid) {
		return serviceMapper.selectByPrimaryKey(uuid);
	}
}
