package com.cloud.api.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.exception.ParamInvalidException;
import com.cloud.api.core.exception.ResourcesNotFoundException;
import com.cloud.api.core.exception.ServerResponseException;
import com.cloud.api.core.exception.ServiceException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.dto.DeploymentDTOExample;
import com.cloud.api.dto.DeploymentDTOExample.Criteria;
import com.cloud.api.dto.PodDTO;
import com.cloud.api.dto.PodDTOExample;
import com.cloud.api.dto.ReplicasetDTO;
import com.cloud.api.dto.ReplicasetDTOExample;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.ContainersDO;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.MqMessage;
import com.cloud.api.entity.PodDO;
import com.cloud.api.entity.ScaleDO;
import com.cloud.api.entity.SetDO;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.response.DeploymentResponse;
import com.cloud.api.mapper.ContainerMapper;
import com.cloud.api.mapper.DeploymentMapper;
import com.cloud.api.mapper.PodMapper;
import com.cloud.api.mapper.ReplicasetMapper;
import com.cloud.api.service.ContainerService;
import com.cloud.api.service.DeploymentService;
import com.cloud.api.service.MQMessageService;
import com.cloud.api.service.PodService;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.ReplicasetService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.annotation.Operation;

/**
 * @author huang_kefei
 * @date 2018年9月28日 类说明
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DeploymentServiceImpl extends BaseService implements DeploymentService {
	@Autowired
	private MQMessageService mqMessageService;

	@Resource
	private DeploymentMapper deploymentMapper;

	@Resource
	private ReplicasetMapper replicasetMapper;

	@Resource
	private PodMapper podMapper;

	@Resource
	private ContainerMapper containerMapper;

	@Resource
	private ReplicasetService replicasetService;

	@Resource
	private PodService podService;
	
	@Resource
	private ProjectService projectService;

	@Resource
	private ContainerService containerService;

	private final static Logger logger = LoggerFactory.getLogger(TemplateServiceImpl.class);

	@Override
	@Operation(action = "add deployment", resourceType = "deployment")
	public int addOpenShiftDeployment(AppInstanceDetailDO appInstanceDetailDO, String instanceId,TokenDO token,
			String project) {
		// TODO Auto-generated method stub
		String projectId = projectService.queryProjectByRegionIdAndProjectName(MDC.get(MDCConstants.REGION_ID), project)
				.getUuid();
		String deploymentName =appInstanceDetailDO.getMetadata().getName();
		//校验name是否重复
		DeploymentDTOExample exampleName=new DeploymentDTOExample();
		Criteria criteria =exampleName.createCriteria();
		criteria.andNameEqualTo(deploymentName);
		criteria.andProjectEqualTo(projectId);
		long count =deploymentMapper.countByExample(exampleName);
		if(count>0) {
			logger.warn("count>0");
			throw new ParamInvalidException("deployment name has already exist!");
		}else {
			logger.warn("count<=0");
		}
		
		String url = "/apis/extensions/v1beta1/namespaces/" + project + "/deployments";
		logger.warn("==========进入addOpenShiftDeployment");
		Invocation<AppInstanceDetailDO> invocation = post(AppInstanceDetailDO.class, url, token)
				.entity(appInstanceDetailDO);
		CloseableHttpResponse response = invocation.executeWithResponse();

//			更新本地DB DeploymentDTO ReplicasetDTO PodDTO
		DeploymentDTO deploymentDTO = new DeploymentDTO();
		deploymentDTO.setName(appInstanceDetailDO.getMetadata().getName());
		deploymentDTO.setApiVersion(appInstanceDetailDO.getApiVersion());
		deploymentDTO.setMetaData(JsonUtils.objectToJson(appInstanceDetailDO.getMetadata()));
		deploymentDTO.setKind(appInstanceDetailDO.getKind());
		deploymentDTO.setSpec(JsonUtils.objectToJson(appInstanceDetailDO.getSpec()));
		deploymentDTO.setInstanceId(instanceId);
		deploymentDTO.setCreatedTime(new Date());
		deploymentDTO.setUuid(IdGen.uuid());
		deploymentDTO.setProject(projectId);

		ReplicasetDTO replicasetDTO = new ReplicasetDTO();
		SpecDO setDO = appInstanceDetailDO.getSpec();
		PodDO podDO = setDO.getTemplate();
//		List<ContainersDO> containerDOList= podDO.getSpec().getContainers();
		replicasetDTO.setSelector(JsonUtils.objectToJson(setDO.getSelector()));
		replicasetDTO.setStrategy(JsonUtils.objectToJson(setDO.getStrategy()));
		replicasetDTO.setProgressDeadlineSeconds(setDO.getProgressDeadlineSeconds());
		replicasetDTO.setRevisionHistoryLimit(setDO.getRevisionHistoryLimit());
		replicasetDTO.setReplicas(setDO.getReplicas());
		replicasetDTO.setCreatedTime(new Date());
		replicasetDTO.setUuid(IdGen.uuid());
		replicasetDTO.setDeploymentId(deploymentDTO.getUuid());
		replicasetDTO.setTemplate(JsonUtils.objectToJson(podDO));
		deploymentMapper.insertSelective(deploymentDTO);
		replicasetMapper.insertSelective(replicasetDTO);

		List<String> podIdList = new ArrayList<String>();
		int replicas = setDO.getReplicas();
		for (int a = 0; a < replicas; a++) {
			logger.warn("=====================================================replicas"+replicas);
			PodDTO podDTO = new PodDTO();
			podDTO.setMetaData(JsonUtils.objectToJson(podDO.getMetadata()));
			podDTO.setSpec(JsonUtils.objectToJson(podDO.getSpec()));
			podDTO.setCreatedTime(new Date());
			podDTO.setUuid(IdGen.uuid());
			podDTO.setSetId(replicasetDTO.getUuid());
			podIdList.add(podDTO.getUuid());
			podMapper.insertSelective(podDTO);
		}

		// 发送同步deployment rabbitmq消息
		String geturl="/apis/extensions/v1beta1/namespaces/" + project + "/deployments/"+deploymentName;
		MqMessage msg = new MqMessage();
		msg.setUrl(geturl);
		msg.setUuid(deploymentDTO.getUuid());
		msg.setKind(appInstanceDetailDO.getKind());
		msg.setTokenDO(token);
		msg.setProject(project);
		msg.setDeploymentName(deploymentName);
		msg.setRegion(MDC.get(MDCConstants.REGION_ID));
		mqMessageService.sendMqMessage(msg);
		
		// 发送同步Pod rabbitmq消息
		MqMessage podMsg = new MqMessage();
		podMsg.setKind("Pod");
		podMsg.setTokenDO(token);
		podMsg.setDeploymentName(deploymentDTO.getName());
		podMsg.setPodId(podIdList);
		podMsg.setProject(project);
		podMsg.setInstanceId(instanceId);
		podMsg.setRegion(MDC.get(MDCConstants.REGION_ID));
		mqMessageService.sendMqMessage(podMsg);
		
		//发送消息更新quota
		MqMessage quotaMsg = new MqMessage();
		quotaMsg.setKind("Quota");
		quotaMsg.setTokenDO(token);
		quotaMsg.setProject(project);
		quotaMsg.setRegion(MDC.get(MDCConstants.REGION_ID));
		mqMessageService.sendMqMessage(quotaMsg);
		
		return 1;
	}

	@Override
	@Operation(action = "edit deployment", resourceType = "deployment")
	public AppInstanceDetailDO updateOpenShiftDeployment(AppInstanceDetailDO appInstanceDetailDO, String instanceId, TokenDO token,
			String project) {
		// TODO Auto-generated method stub
		String deploymentName=appInstanceDetailDO.getMetadata().getName();
		logger.warn("==========进入updateOpenShiftDeployment");
		String url = "";
		//将DO直接patch即可更新
		Invocation<AppInstanceDetailDO> invocation=null;
		AppInstanceDetailDO instanceResponse =new AppInstanceDetailDO();
		//resourceVersion null
		MetaDataDO metaDataDO = appInstanceDetailDO.getMetadata();
		metaDataDO.setResourceVersion(null);
		appInstanceDetailDO.setMetadata(metaDataDO);
		try {
			url = "/apis/extensions/v1beta1/namespaces/" + project + "/deployments/" + deploymentName;
//			invocation = patch(AppInstanceDetailDO.class, url, token)
//					.entity(appInstanceDetailDO).contentType("application/strategic-merge-patch+json");
			invocation = put(AppInstanceDetailDO.class, url, token)
					.entity(appInstanceDetailDO);
			CloseableHttpResponse response = invocation.executeWithResponseNotClose();
			String responseStr = EntityUtils.toString(response.getEntity());
			response.close();
			DeploymentResponse deploymentResponse=JsonUtils.jsonToObject(responseStr, DeploymentResponse.class);
			instanceResponse.setApiVersion(deploymentResponse.getApiVersion());
			instanceResponse.setKind(deploymentResponse.getKind());
			instanceResponse.setMetadata(deploymentResponse.getMetadata());
			instanceResponse.setSpec(deploymentResponse.getSpec());
		} catch (ResourcesNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("update openshift error 404");
		}catch (ServiceException e) {
			e.printStackTrace();
			throw new ServiceException("update deployment error,please check!");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
//		更新DB
//			DeploymentDTO deploymentDTO = new DeploymentDTO();
//			deploymentDTO.setApiVersion(appInstanceDetailDO.getApiVersion());
//			deploymentDTO.setMetaData(JsonUtils.objectToJson(appInstanceDetailDO.getMetadata()));
//			deploymentDTO.setKind(appInstanceDetailDO.getKind());
//			deploymentDTO.setSpec(JsonUtils.objectToJson(appInstanceDetailDO.getSpec()));
//			DeploymentDTOExample example = new DeploymentDTOExample();
//			Criteria criteria = example.createCriteria();
//			criteria.andInstanceIdEqualTo(instanceId);
//			deploymentMapper.updateByExampleSelective(deploymentDTO, example);
//			List<DeploymentDTO> deploymentList = deploymentMapper.selectByExample(example);
//
//			DeploymentDTO selectDTO = deploymentList.get(0);
//			SpecDO set = appInstanceDetailDO.getSpec();
//			ReplicasetDTO replicasetDTO = new ReplicasetDTO();
//			replicasetDTO.setProgressDeadlineSeconds(set.getProgressDeadlineSeconds());
//			replicasetDTO.setReplicas(set.getReplicas());
//			replicasetDTO.setRevisionHistoryLimit(set.getRevisionHistoryLimit());
//			replicasetDTO.setSelector(JsonUtils.objectToJson(set.getSelector()));
//			replicasetDTO.setStrategy(JsonUtils.objectToJson(set.getStrategy()));
//			replicasetDTO.setTemplate(JsonUtils.objectToJson(set.getTemplate()));
//			ReplicasetDTOExample setExample = new ReplicasetDTOExample();
//			com.cloud.api.dto.ReplicasetDTOExample.Criteria setCriteria = setExample.createCriteria();
//			setCriteria.andDeploymentIdEqualTo(selectDTO.getUuid());
////			replicasetMapper.updateByExampleSelective(replicasetDTO, setExample);
//			List<ReplicasetDTO> setList = replicasetMapper.selectByExample(setExample);
//
//			ReplicasetDTO setDTO = setList.get(0);
//			PodDO pod = set.getTemplate();
//			PodDTO podDTO = new PodDTO();
//			podDTO.setMetaData(JsonUtils.objectToJson(pod.getMetadata()));
//			podDTO.setSpec(JsonUtils.objectToJson(pod.getSpec()));
//			PodDTOExample podExample = new PodDTOExample();
//			com.cloud.api.dto.PodDTOExample.Criteria podCriteria = podExample.createCriteria();
//			podCriteria.andSet_idEqualTo(setDTO.getUuid());
//			podMapper.updateByExampleSelective(podDTO, podExample);
			
			// 发送rabbitmq 更新deployment和set
			//instanceId查deploymentId
			DeploymentDTOExample example =new DeploymentDTOExample();
			Criteria criteria =example.createCriteria();
			criteria.andInstanceIdEqualTo(instanceId);
			List<DeploymentDTO> deployments = deploymentMapper.selectByExample(example);
			if(deployments!=null&&!deployments.isEmpty()) {
				String deploymentId =deployments.get(0).getUuid();
				MqMessage msg = new MqMessage();
				msg.setUuid(deploymentId);
				msg.setKind(Constants.MQ_ROUTEKEY_DEPLOYMENT);
				msg.setTokenDO(token);
				msg.setProject(project);
				msg.setRegion(MDC.get(MDCConstants.REGION_ID));
				mqMessageService.sendMqMessage(msg);
			}
			
			//发送mq 更新quota
			MqMessage quotaMsg = new MqMessage();
			quotaMsg.setKind("Quota");
			quotaMsg.setTokenDO(token);
			quotaMsg.setProject(project);
			quotaMsg.setRegion(MDC.get(MDCConstants.REGION_ID));
			mqMessageService.sendMqMessage(quotaMsg);
			
			// 获取podId list
//			List<String> podIdList = new ArrayList<String>();
//			int replicas = set.getReplicas();
//			for (int a = 0; a < replicas; a++) {
//				podIdList.add(podDTO.getUuid());
//			}
			// 发送rabbitmq消息 pod
			/*
			 * MqMessage podMsg = new MqMessage(); podMsg.setKind("Pod");
			 * podMsg.setUuid(deploymentDTO.getUuid()); podMsg.setTokenDO(token);
			 * podMsg.setDeploymentName(deploymentDTO.getName());
			 * podMsg.setPodId(podIdList); podMsg.setProject(project);
			 * podMsg.setInstanceId(instanceId); mqMessageService.sendMqMessage(podMsg);
			 */
		}
		return instanceResponse;
	}

	@Override
	@Operation(action = "delete deployment", resourceType = "deployment")
	public int deleteOpenShiftDeployment(String instanceId, TokenDO token, String deploymentName, String project) {
		// TODO Auto-generated method stub、
		logger.info("==========进入deleteOpenShiftDeployment");
		
		// get db Set
		String deploymentId;
		String setId = null;
		String setName;
		DeploymentDTOExample example2 = new DeploymentDTOExample();
		Criteria criteria2 = example2.createCriteria();
		criteria2.andInstanceIdEqualTo(instanceId);
		List<DeploymentDTO> depList = deploymentMapper.selectByExample(example2);
		if (depList != null && !depList.isEmpty()) {
			deploymentId = depList.get(0).getUuid();
			ReplicasetDTOExample example3 = new ReplicasetDTOExample();
			com.cloud.api.dto.ReplicasetDTOExample.Criteria criteria3 = example3.createCriteria();
			criteria3.andDeploymentIdEqualTo(deploymentId);
			List<ReplicasetDTO> setList = replicasetMapper.selectByExample(example3);
			if (setList != null && !setList.isEmpty()) {
				setName = setList.get(0).getName();
				setId = setList.get(0).getUuid();
			}else{
				throw new ResourcesNotFoundException("set db not found!++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}
		}else {
			throw new ResourcesNotFoundException("deployment db not found!++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}


		// openshift
		//get deployment
		String url = "/apis/extensions/v1beta1/namespaces/" + project + "/deployments/" + deploymentName;
		try {
			//get deployment
			Invocation<DeploymentResponse> invocation = get(DeploymentResponse.class, url, token);
			CloseableHttpResponse responseDep = invocation.executeWithResponseNotClose();
			String responseDepStr = EntityUtils.toString(responseDep.getEntity());
			responseDep.close();
			logger.warn("get  deployment end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			//replicas—>0
			DeploymentResponse deploymentDO =JsonUtils.jsonToObject(responseDepStr, DeploymentResponse.class);
			AppInstanceDetailDO deployPutDO =new AppInstanceDetailDO();
			SpecDO specDO=deploymentDO.getSpec();
			specDO.setReplicas(0);
			deploymentDO.setSpec(specDO);
			deployPutDO.setApiVersion(deploymentDO.getApiVersion());
			deployPutDO.setKind(deploymentDO.getKind());
			deployPutDO.setMetadata(deploymentDO.getMetadata());
			deployPutDO.setSpec(deploymentDO.getSpec());
			
			Invocation<AppInstanceDetailDO> invocation2 = put(AppInstanceDetailDO.class,"/apis/extensions/v1beta1/namespaces/" + project + "/deployments/" + deploymentName, token).entity(deployPutDO);
			CloseableHttpResponse responseDep2 = invocation2.executeWithResponseNotClose();
			responseDep2.close();
			logger.warn("put  deployment end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
			int replicasScale=1;
			int replicasSet=1;
			//判断replicas 是否为0
			ScaleDO scaleDO =new ScaleDO();
			SetDO setDO=new SetDO();
			for(int num=0;num<40;num++) {
				//get scale
				//每次等待0.5s查询scale
				Thread.sleep(500);
				//set
				logger.warn("循环 getset+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				Invocation<SetDO> invocationSet1 = get(SetDO.class, "apis/extensions/v1beta1/namespaces/"+project+"/replicasets/"+setName, token);
				CloseableHttpResponse responseSet1 = invocationSet1.executeWithResponseNotClose();
				String responseSetStr = EntityUtils.toString(responseSet1.getEntity());
				responseSet1.close();
				setDO= JsonUtils.jsonToObject(responseSetStr, SetDO.class);
				if(setDO.getSpec()!=null) {
					replicasSet=setDO.getSpec().getReplicas();
				}
				//scale
				logger.warn("循环 getscale+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				Invocation<ScaleDO> invocationScale1 = get(ScaleDO.class, "apis/extensions/v1beta1/namespaces/"+project+"/replicasets/"+setName+"/scale", token);
				CloseableHttpResponse responseScale = invocationScale1.executeWithResponseNotClose();
				String responseScaleStr = EntityUtils.toString(responseScale.getEntity());
				responseScale.close();
				scaleDO = JsonUtils.jsonToObject(responseScaleStr, ScaleDO.class);
				if(scaleDO.getStatus()!=null) {
					replicasScale=scaleDO.getStatus().getReplicas();
				}
				if(replicasScale==0&&replicasSet==0) {
					break;
				}
				if(num==40) {
					throw new ServerResponseException(" scale replicas=0 time out",408);
				}
			}
			logger.warn("get  scale end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			//put scale
			Invocation<ScaleDO> invocationScale2 = put(ScaleDO.class, "apis/extensions/v1beta1/namespaces/"+project+"/replicasets/"+setName+"/scale", token).entity(scaleDO);
			CloseableHttpResponse responseScale2 = invocationScale2.executeWithResponseNotClose();
			responseScale2.close();
			logger.warn("put  scale end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			//delete set
			Invocation<DeploymentResponse> invocationSet = delete(DeploymentResponse.class, "/apis/extensions/v1beta1/namespaces/"+project+"/replicasets/" + setName, token);
			CloseableHttpResponse responseSet = invocationSet.executeWithResponseNotClose();
			responseSet.close();
			logger.warn("delete  set end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			//delete deployment
			Invocation<DeploymentResponse> invocationDep = delete(DeploymentResponse.class, "/apis/extensions/v1beta1/namespaces/" + project + "/deployments/" + deploymentName, token);
			CloseableHttpResponse responseDeleteDep = invocationDep.executeWithResponseNotClose();
			responseDeleteDep.close();
			logger.warn("delete  deployment end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
		} catch (ResourcesNotFoundException e) {
			// TODO: handle exception
			// 404不处理
			logger.warn("delete resourse 404");
		}catch ( ParseException | IOException e) {
			logger.warn("delete resourse error");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//DB
		// delete pod
		podService.deletePod(setId, token, project);
		// delete set
		replicasetService.deleteSet(deploymentId, setName, token, project);
		// delete deployment
		DeploymentDTOExample example = new DeploymentDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstanceIdEqualTo(instanceId);
		deploymentMapper.deleteByExample(example);

		
		//发送消息更新quota
		MqMessage quotaMsg = new MqMessage();
		quotaMsg.setKind("Quota");
		quotaMsg.setTokenDO(token);
		quotaMsg.setProject(project);
		quotaMsg.setRegion(MDC.get(MDCConstants.REGION_ID));
		mqMessageService.sendMqMessage(quotaMsg);
		return 1;
	}

	@Override
	public DeploymentDTO getDeploymentByInstanceId(String instanceId) {
		// TODO Auto-generated method stub
		DeploymentDTOExample example = new DeploymentDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstanceIdEqualTo(instanceId);
		List<DeploymentDTO> list = deploymentMapper.selectByExample(example);
		if (list.size() > 0) {
			DeploymentDTO deploymentDTO = list.get(0);
			return deploymentDTO;
		} else {
			logger.warn("query deployment is null");
			return null;
		}

	}

	@Override
	public DeploymentDTO getDeploymentByName(String name) {
		DeploymentDTOExample example = new DeploymentDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<DeploymentDTO> list = deploymentMapper.selectByExample(example);
		if (list.size() > 0) {
			DeploymentDTO deploymentDTO = list.get(0);
			return deploymentDTO;
		} else {
			logger.warn("query deployment is null");
			return null;
		}
	}

	@Override
	public List<DeploymentDTO> getAllDeployment() {
		// TODO Auto-generated method stub
		DeploymentDTOExample example = new DeploymentDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.getAllCriteria();
		List<DeploymentDTO> list = deploymentMapper.selectByExample(example);
		return list;
	}

	@Override
	public AppInstanceDetailDO getDeploymentDO(String instanceId) {
		// TODO Auto-generated method stub
		DeploymentDTOExample example = new DeploymentDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andInstanceIdEqualTo(instanceId);
		List<DeploymentDTO> depList = deploymentMapper.selectByExample(example);
		if (depList != null && !depList.isEmpty()) {
			DeploymentDTO deploymentDTO = depList.get(0);
			AppInstanceDetailDO depDO = new AppInstanceDetailDO();
//			DeploymentConfigurationData data =new DeploymentConfigurationData();
			try {
				depDO.setApiVersion(deploymentDTO.getApiVersion());
				depDO.setKind(deploymentDTO.getKind());
				depDO.setMetadata(JsonUtils.jsonToObject(deploymentDTO.getMetaData(), MetaDataDO.class));
				depDO.setSpec(JsonUtils.jsonToObject(deploymentDTO.getSpec(), SpecDO.class));
			} catch (Exception e) {
				// TODO: handle exception
				logger.error("parse to json error");
			}
			return depDO;
		}
		return null;
	}
	
	
	@Override
	public AppInstanceDetailDO getOpenshiftDeployment(String project,String deploymentName,TokenDO token) {
		// TODO Auto-generated method stub
		AppInstanceDetailDO deployment =null;
		try {
			Invocation<AppInstanceDetailDO> invocation = get(AppInstanceDetailDO.class, "/apis/extensions/v1beta1/namespaces/" + project + "/deployments/"+deploymentName,token);
			CloseableHttpResponse response = invocation.executeWithResponseNotClose();
			String responseStr = EntityUtils.toString(response.getEntity());
			response.close();
			 deployment=JsonUtils.jsonToObject(responseStr, AppInstanceDetailDO.class);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourcesNotFoundException e) {
			e.printStackTrace();
		}
		return deployment;
	}
	/*
	 * @Override public List<DeploymentDTO> getDeploymentByCondition(String
	 * condition) { // TODO Auto-generated method stub DeploymentDTOExample example
	 * =new DeploymentDTOExample(); Criteria criteria1 =example.createCriteria();
	 * Criteria criteria2 =example.createCriteria();
	 * criteria1.andApi_versionLike("%"+condition+"%");
	 * criteria2.andLast_versionLike("%"+condition+"%"); example.or(criteria1);
	 * example.or(criteria2); List<DeploymentDTO> list
	 * =deploymentMapper.selectByExample(example); return list; }
	 * 
	 * @Override public long countDeployment() { // TODO Auto-generated method stub
	 * DeploymentDTOExample example =new DeploymentDTOExample(); Criteria criteria
	 * =example.createCriteria(); criteria.getAllCriteria(); long count
	 * =deploymentMapper.countByExample(example); return count; }
	 */

}
