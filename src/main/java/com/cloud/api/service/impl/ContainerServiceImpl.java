/**
 * 
 */
package com.cloud.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.ContainerDTO;
import com.cloud.api.dto.ContainerDTOExample;
import com.cloud.api.dto.ContainerDTOExample.Criteria;
import com.cloud.api.dto.EventDTO;
import com.cloud.api.dto.RegionDTO;
import com.cloud.api.entity.ContainerDO;
import com.cloud.api.entity.MqMessage;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ContainerRequestData;
import com.cloud.api.mapper.ContainerMapper;
import com.cloud.api.mapper.RegionMapper;
import com.cloud.api.service.ContainerService;
import com.cloud.api.service.EventService;
import com.cloud.api.service.MQMessageService;
import com.cloud.api.util.ClientConstants;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ContainerServiceImpl extends BaseService implements ContainerService {

	@Resource
	private ContainerMapper containerMapper;
	
	@Resource
	private EventService eventService;
	
	@Resource
	private RegionMapper regionMapper;
	
	@Resource
	private MQMessageService messageService;
	
	private final static Logger log = LoggerFactory.getLogger(ContainerServiceImpl.class); 
	
	@Override
	public int updateContainer(ContainerDO containerDO, String containerId, String containerName, TokenDO token) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addContainer(ContainerDO containerDO, String podId, TokenDO token) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public ContainerDTO queryContainerById(String containerId) {
		ContainerDTO container = containerMapper.selectByPrimaryKey(containerId);
		return container;
	}
	
	@Override
	public ContainerDTO queryContainerByConId(String containerId) {
		ContainerDTOExample example =new ContainerDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andConIdEqualTo(containerId);
		List<ContainerDTO> containers = containerMapper.selectByExample(example);
		ContainerDTO containDTO =new ContainerDTO();
		if(containers!=null&&!containers.isEmpty()) {
			containDTO=containers.get(0);
		}
		return containDTO;
	}
	
	@Override
	public List<ContainerDTO> queryContainerByPodId(String podId) {
		ContainerDTOExample example = new ContainerDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andPodIdEqualTo(podId);
		return containerMapper.selectByExample(example);
	}
	
	@Override
	public int deleteContainer(String podId) {
		// TODO Auto-generated method stub
		ContainerDTOExample example = new ContainerDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andPodIdEqualTo(podId);
		return containerMapper.deleteByExample(example);
	}
	
	@Override
	public int editContainer(String containerId, ContainerRequestData requestData) {
		ContainerDTO container = containerMapper.selectByPrimaryKey(containerId);
		return containerMapper.updateByPrimaryKeySelective(container);
	}
	
	
	@Override
	public int operateContainer(String containerId, ContainerRequestData requestData,String project) {
		String type = requestData.getOperateType();
		ContainerDTO container = queryContainerByConId(containerId);
		String nodeName = "";
		String conId = "";
		if (container != null) {
			nodeName = container.getNodeName();
			conId = container.getConId();
		}
		RegionDTO regionDTO = regionMapper.selectByPrimaryKey(MDC.get(MDCConstants.REGION_ID));
		String containerUrl = "";
		if (regionDTO != null) {
			containerUrl = regionDTO.getContainerUrl();
		}
		int ret = 0;
		switch (type) {
		case Constants.CONTAINER_OPERATE_STOP:
			ret = stopContainer(conId, nodeName,containerUrl,project);
			break;
		case Constants.CONTAINER_OPERATE_RECOVERY:
			ret = startContainer(conId, nodeName,containerUrl,project);
			break;
		case Constants.CONTAINER_OPERATE_DELETE:
			ret = deleteContainer(conId, nodeName,containerUrl,project);
			break;
		case Constants.CONTAINER_OPERATE_RESTART:
			ret = restartContainer(conId, nodeName,containerUrl,project);
			break;
		default:
			log.warn("this type:" + type + " is no match with container's operation");
		}
		
		//记录容器事件
//		EventDTO eventDTO = new EventDTO();
//		eventDTO.setUuid(IdGen.uuid());
//		eventDTO.setType(type);
//		eventDTO.setMessage("");
////		eventDTO.setStatus("");
////		eventDTO.setContainerId(containerId);
//		eventService.addEvent(eventDTO);
		
		return ret;
	}
	
	private int stopContainer(String conId, String nodeName, String containerUrl,String project) {
		// api
		Map<String,String> bodyMap = new HashMap<String,String>();
		bodyMap.put("action", "stop");
		Invocation<ContainerDTO> invocation = put(ContainerDTO.class, "/tools/docker/containers/" + conId, null)
				.endpoint(containerUrl).header(ClientConstants.NODE, nodeName)
				.header(ClientConstants.CONTENT_TYPE, ClientConstants.CONTENT_TYPE_JSON).json(JsonUtils.objectToJson(bodyMap));
		CloseableHttpResponse response = invocation.executeWithResponse();
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode==200||statusCode==202) {
			//同步
			MqMessage msg  = new MqMessage();
			msg.setKind(Constants.MQ_ROUTEKEY_CONTAINER);
			msg.setProject(project);
			msg.setRegion(MDC.get(MDCConstants.REGION_ID));
			messageService.sendMqMessage(msg);
			//等待1s给同步模块同步container
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return statusCode;
	}

	private int startContainer(String conId, String nodeName, String containerUrl,String project) {
		// api
		Map<String,String> bodyMap = new HashMap<String,String>();
		bodyMap.put("action", "start");
		Invocation<ContainerDTO> invocation = put(ContainerDTO.class, "/tools/docker/containers/" + conId, null)
				.endpoint(containerUrl).header(ClientConstants.NODE, nodeName)
				.header(ClientConstants.CONTENT_TYPE, ClientConstants.CONTENT_TYPE_JSON).json(JsonUtils.objectToJson(bodyMap));
		CloseableHttpResponse response = invocation.executeWithResponse();
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode==200||statusCode==202) {
			//同步
			MqMessage msg  = new MqMessage();
			msg.setKind(Constants.MQ_ROUTEKEY_CONTAINER);
			msg.setProject(project);
			msg.setRegion(MDC.get(MDCConstants.REGION_ID));
			messageService.sendMqMessage(msg);
			//等待1s给同步模块同步container
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return statusCode;
	}

	private int deleteContainer(String conId, String nodeName, String containerUrl,String project) {
		// api
		Invocation<ContainerDTO> invocation = delete(ContainerDTO.class, "/tools/docker/containers/" + conId, null)
				.endpoint(containerUrl).header(ClientConstants.NODE, nodeName);
		CloseableHttpResponse response = invocation.executeWithResponse();
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode==200||statusCode==202) {
			//同步
			MqMessage msg  = new MqMessage();
			msg.setKind(Constants.MQ_ROUTEKEY_CONTAINER);
			msg.setProject(project);
			msg.setRegion(MDC.get(MDCConstants.REGION_ID));
			messageService.sendMqMessage(msg);
			//等待1s给同步模块同步container
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return statusCode;
	}

	private int restartContainer(String conId, String nodeName, String containerUrl,String project) {
		// api
		Map<String,String> bodyMap = new HashMap<String,String>();
		bodyMap.put("action", "restart");
		Invocation<ContainerDTO> invocation = put(ContainerDTO.class, "/tools/docker/containers/" + conId, null)
				.endpoint(containerUrl).header(ClientConstants.NODE, nodeName)
				.header(ClientConstants.CONTENT_TYPE, ClientConstants.CONTENT_TYPE_JSON).json(JsonUtils.objectToJson(bodyMap));
		CloseableHttpResponse response = invocation.executeWithResponse();
		int statusCode = response.getStatusLine().getStatusCode();
		if(statusCode==200||statusCode==202) {
			//同步
			MqMessage msg  = new MqMessage();
			msg.setKind(Constants.MQ_ROUTEKEY_CONTAINER);
			msg.setProject(project);
			msg.setRegion(MDC.get(MDCConstants.REGION_ID));
			messageService.sendMqMessage(msg);
			//等待1s给同步模块同步container
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return statusCode;
	}
}
