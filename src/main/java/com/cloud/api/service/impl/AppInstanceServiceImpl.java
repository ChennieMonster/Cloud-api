/**
 * 
 */
package com.cloud.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.exception.ServiceException;
import com.cloud.api.dto.AppInstanceDTO;
import com.cloud.api.dto.AppInstanceDTOExample;
import com.cloud.api.dto.AppInstanceDTOExample.Criteria;
import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.dto.DeploymentDTOExample;
import com.cloud.api.dto.PodDTO;
import com.cloud.api.dto.PodDTOExample;
import com.cloud.api.dto.ReplicasetDTO;
import com.cloud.api.dto.ReplicasetDTOExample;
import com.cloud.api.dto.RouteDTO;
import com.cloud.api.dto.ServiceDTO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.InstanceRequest;
import com.cloud.api.mapper.AppInstanceMapper;
import com.cloud.api.mapper.DeploymentMapper;
import com.cloud.api.mapper.PodMapper;
import com.cloud.api.mapper.ReplicasetMapper;
import com.cloud.api.service.AppInstanceService;
import com.cloud.api.service.DeploymentService;
import com.cloud.api.service.RouteService;
import com.cloud.api.service.ServiceService;
import com.cloud.api.util.InvalidationUtils;
import com.cloud.api.util.JsonUtils;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AppInstanceServiceImpl implements AppInstanceService {

	private final static Logger logger = LoggerFactory.getLogger(AppInstanceServiceImpl.class);
	
	@Resource
    private AppInstanceMapper appInstanceMapper;
	
	@Resource
    private DeploymentMapper deploymentMapper;
	
	@Resource
    private ReplicasetMapper replicasetMapper;
	
	@Resource
    private PodMapper podMapper;
	
	@Resource
    private RouteService routeService;
	
	@Resource
    private ServiceService serviceService;
	
	@Resource
    private DeploymentService deploymentService;
	
	@Resource
	private InvalidationUtils invalidationUtils;
	
	@Override
	public void deleteAppInstance(String id, TokenDO token, String project) {
	    appInstanceMapper.deleteAppInstance(id);
	    RouteDTO route = routeService.queryRouteByInstanceId(id);
		ServiceDTO service = serviceService.queryServiceByInstanceId(id);
		DeploymentDTO deployment = deploymentService.getDeploymentByInstanceId(id);
		if(route!=null) {
			routeService.deleteRoute(id, route.getName(), token, project);
		}
		if(service!=null) {
			serviceService.deleteService(id, service.getName(), token, project);
		}
		if(deployment!=null) {
			deploymentService.deleteOpenShiftDeployment(id, token, deployment.getName(), project);
		}
	}

	@Override
	public void editAppInstanceByAppId(TokenDO token, InstanceRequest requestData, String uuid, String project) {
		logger.info("editAppInstance begin");
		AppInstanceDTO appInstanceDTO = appInstanceMapper.queryById(uuid);
		appInstanceDTO.setDisplayName(requestData.getInstanceDisplayName());
		appInstanceDTO.setDescription(requestData.getInstanceDescription());
		appInstanceDTO.setObjects(JsonUtils.objectToJson(requestData.getObjects()));
		
		for(AppInstanceDetailDO insDetailDO : requestData.getObjects()) {
			
			//参数校验
			invalidationUtils.checkInstance(insDetailDO, project);
			
			if("Route".equals(insDetailDO.getKind())) {
				//name属性不允许被改变
				RouteDTO routeDTO = routeService.queryRouteByInstanceId(uuid);
				if(!(routeDTO.getName().equals(insDetailDO.getMetadata().getName()))) {
					throw new ServiceException("route'name is not allowed to be changed! ");
				}else {
					routeService.updateRoute(uuid, routeDTO.getName(), insDetailDO, token, project);
				}
			}else if("Service".equals(insDetailDO.getKind())) {
				ServiceDTO serviceDTO = serviceService.queryServiceByInstanceId(uuid);
				//name属性不允许被改变
				if(!(serviceDTO.getName().equals(insDetailDO.getMetadata().getName()))) {
					throw new ServiceException("service'name is not allowed to be changed! ");
				}else {
					serviceService.updateServiceByInstanceId(uuid, insDetailDO, token, project);
				}
			}else if("Deployment".equals(insDetailDO.getKind())) {
				DeploymentDTO deploymentDTO = deploymentService.getDeploymentByInstanceId(uuid);
				//name属性不允许被改变
				if(!(deploymentDTO.getName().equals(insDetailDO.getMetadata().getName()))) {
					throw new ServiceException("deployment's name is not allowed to be changed! ");
				}else {
					deploymentService.updateOpenShiftDeployment(insDetailDO, uuid, token, project);
				}
			}
		}
		
		appInstanceMapper.updateAppInstanceByAppId(appInstanceDTO);
	}

	@Override
	public List<AppInstanceDTO> queryByTemplateId(String templateId) {
		logger.info("queryByTemplateId begin, templateId = "+templateId);
		return appInstanceMapper.queryByTemplateId(templateId);
	}

	@Override
	public DeploymentDTO getInstanceDeployment(String instanceId) {
		DeploymentDTO deployment = deploymentService.getDeploymentByInstanceId(instanceId);
		return deployment;
	}

	@Override
	public RouteDTO getInstanceRoute(String instanceId) {
		RouteDTO route = routeService.queryRouteByInstanceId(instanceId);
		return route;
	}

	@Override
	public ServiceDTO getInstanceService(String instanceId) {
		ServiceDTO service = serviceService.queryServiceByInstanceId(instanceId);
		return service;
	}
	
	@Override
	public long countAppInstance(String applicationId) {
		// TODO Auto-generated method stub
		AppInstanceDTOExample example =new AppInstanceDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.getAllCriteria();
		criteria.andApplicationIdEqualTo(applicationId);
		return appInstanceMapper.countByExample(example);
	}

	@Override
	public List<AppInstanceDTO> filterInstance(List<GetListParamElement> filterList, String applicationId) {

		logger.info("filterAppInstance begin:"+JsonUtils.objectToJson(filterList));
		AppInstanceDTOExample example =new AppInstanceDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.andApplicationIdEqualTo(applicationId);
		if(filterList != null && !filterList.isEmpty()) {
			//暂无过滤
		}else {
			criteria.getAllCriteria();
		}
		logger.info("filterAppInstance end");
		List<AppInstanceDTO> instanceList = appInstanceMapper.selectByExample(example);
		int podsCount = 0;
		int index = -1;
		for(AppInstanceDTO appinstanceDTO : instanceList) {
			index++;
			DeploymentDTOExample exampleDM = new DeploymentDTOExample();
			com.cloud.api.dto.DeploymentDTOExample.Criteria criteriaDM = exampleDM.createCriteria();
			criteriaDM.andInstanceIdEqualTo(appinstanceDTO.getUuid());
			List<DeploymentDTO> dmlist = deploymentMapper.selectByExample(exampleDM);
			for(DeploymentDTO deploymentDTO : dmlist) {
				ReplicasetDTOExample exampleSet = new ReplicasetDTOExample();
				com.cloud.api.dto.ReplicasetDTOExample.Criteria criteriaSet = exampleSet.createCriteria();
				criteriaSet.andDeploymentIdEqualTo(deploymentDTO.getUuid());
				List<ReplicasetDTO> setList = replicasetMapper.selectByExample(exampleSet);
				for(ReplicasetDTO replicasetDTO : setList) {
					PodDTOExample examplePod = new PodDTOExample();
					com.cloud.api.dto.PodDTOExample.Criteria criteriaPod = examplePod.createCriteria();
					criteriaPod.andSet_idEqualTo(replicasetDTO.getUuid());
					List<PodDTO> podList = podMapper.selectByExample(examplePod);
					podsCount = podList.size();
				}
			}
			appinstanceDTO.setPodsCount(podsCount);
			instanceList.set(index, appinstanceDTO);
		}
		
		
		return instanceList;
	
	}

}
