/**
 * 
 */
package com.cloud.api.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.exception.ParamInvalidException;
import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.dto.DeploymentDTOExample;
import com.cloud.api.dto.DeploymentDTOExample.Criteria;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.dto.RegistryDTO;
import com.cloud.api.dto.RegistryDTOExample;
import com.cloud.api.dto.ResourceQuotaDTO;
import com.cloud.api.dto.ResourceQuotaDTOExample;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.ContainersDO;
import com.cloud.api.entity.ResourcesDO;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.mapper.DeploymentMapper;
import com.cloud.api.mapper.RegistryMapper;
import com.cloud.api.mapper.ResourceQuotaMapper;
import com.cloud.api.service.ProjectService;

/**
 * 校验工具
 * @author zhao_pengchen
 *
 */
@Component
public class InvalidationUtils {
	@Autowired
	private ResourceQuotaMapper resourceQuotaMapper;
	
	@Autowired
	private ResourceValidUtils resourceValidUtils;
	
	@Autowired
	private DeploymentMapper deploymentMapper;
	
	@Autowired
	private RegistryMapper registryMapper;
	
	@Autowired
	private ProjectService projectService;
	
	public void checkInstance(AppInstanceDetailDO insDetailDO, String project) {

		String matchLabels = "";
		String appName = "";
		if ("Deployment".equals(insDetailDO.getKind())) {
			/*
			 * Deployment中matchLables与labels必须一致
			 */
			if (insDetailDO.getSpec() != null && insDetailDO.getSpec().getSelector() != null
					&& insDetailDO.getSpec().getSelector().get(Constants.SPEC_SELECTOR_MATCHLABELS) != null) {
				matchLabels = JsonUtils
						.objectToJson(insDetailDO.getSpec().getSelector().get(Constants.SPEC_SELECTOR_MATCHLABELS))
						.replaceAll("\\s*", "");
			}
			if (insDetailDO.getSpec() != null && insDetailDO.getSpec().getTemplate() != null
					&& insDetailDO.getSpec().getTemplate().getMetadata() != null
					&& insDetailDO.getSpec().getTemplate().getMetadata().getLabels() != null) {
				appName = JsonUtils
						.objectToJson(insDetailDO.getSpec().getTemplate().getMetadata().getLabels())
						.replaceAll("\\s*", "");
			}
			if (!"".equals(matchLabels+appName)&&(!matchLabels.equals(appName))) {
				throw new ParamInvalidException(MessageUtils.getMessage("apps.are.mismatched"));
			}
			/*
			 * apiVersion必须为extensions/v1beta1
			 */
			if (!(Constants.DEPLOYMENT_APIVERSION_3.equals(insDetailDO.getApiVersion()))) {
				throw new ParamInvalidException(MessageUtils.getMessage("deployment.apiversion.is.invalid"));
			}

			/*
			 * 检查image是否为本地添加的三方仓库
			 */
//			ProjectDTO projectDto = projectService.queryProjectByName(project);
//			List<ContainersDO> containersList = insDetailDO.getSpec().getTemplate().getSpec().getContainers();
//			for (ContainersDO container : containersList) {
//				String image = container.getImage().substring(0, container.getImage().indexOf("/"));
//				RegistryDTOExample exampleRegistry = new RegistryDTOExample();
//				com.cloud.api.dto.RegistryDTOExample.Criteria criteriaRegistry = exampleRegistry.createCriteria();
//				criteriaRegistry.andUrlLike("%"+image+"%");
//				List<String> projectIdList = new ArrayList<>();
//				projectIdList.add("0"); //0表示平台
//				projectIdList.add(projectDto.getUuid());
//				criteriaRegistry.andProjectIdIn(projectIdList);
//				List<RegistryDTO> registryList = registryMapper.selectByExample(exampleRegistry);
//				if(registryList.size()<=0) {
//					throw new ParamInvalidException(MessageUtils.getMessage("image.is.invalid"));
//				}
//			}

			// check resource
			if (insDetailDO.getSpec() != null && insDetailDO.getSpec().getTemplate() != null
					&& insDetailDO.getSpec().getTemplate().getSpec() != null
					&& insDetailDO.getSpec().getTemplate().getSpec().getContainers() != null) {
				List<ContainersDO> containerList = insDetailDO.getSpec().getTemplate().getSpec().getContainers();
				if (containerList != null && !containerList.isEmpty()) {
					ResourcesDO resourcesDO = containerList.get(0).getResources();
					if (resourcesDO == null) {
						throw new ParamInvalidException(MessageUtils.getMessage("resources.is.null"));
					} else {
						if (resourcesDO.getLimits() == null) {
							throw new ParamInvalidException(MessageUtils.getMessage("resources.limits.is.null"));
						} else {
							if (resourcesDO.getLimits().get("cpu") == null) {
								throw new ParamInvalidException(
										MessageUtils.getMessage("resources.limits.cpu.is.null"));
							}
							if (resourcesDO.getLimits().get("memory") == null) {
								throw new ParamInvalidException(
										MessageUtils.getMessage("resources.limits.memory.is.null"));
							}
						}
						if (resourcesDO.getRequests() == null) {
							throw new ParamInvalidException(MessageUtils.getMessage("resources.requests.is.null"));
						} else {
							if (resourcesDO.getRequests().get("cpu") == null) {
								throw new ParamInvalidException(
										MessageUtils.getMessage("resources.requests.cpu.is.null"));
							}
							if (resourcesDO.getRequests().get("memory") == null) {
								throw new ParamInvalidException(
										MessageUtils.getMessage("resources.requests.memory.is.null"));
							}
						}
					}
				}
			}

		}
			
			/*
			 * apiVersion必须为v1
			 */
			if("Service".equals(insDetailDO.getKind())) {
				if(!(Constants.SERVICE_APIVERSION.equals(insDetailDO.getApiVersion()))) {
					throw new ParamInvalidException(MessageUtils.getMessage("service.apiversion.is.invalid"));
				}
			}
			
			/*
			 * apiVersion必须为v1或者route.openshift.io
			 */
			if("Route".equals(insDetailDO.getKind())) {
				if(!(Constants.ROUTE_APIVERSION.equals(insDetailDO.getApiVersion()))) {
						throw new ParamInvalidException(MessageUtils.getMessage("route.apiversion.is.invalid"));
				}
				/*
				 * Spec中的to中的kind必須為service
				 */
				//to不为空
			if (insDetailDO.getSpec().getTo() == null || insDetailDO.getSpec().getTo().getKind() == null
					|| insDetailDO.getSpec().getTo().getName() == null) {
				throw new ParamInvalidException(MessageUtils.getMessage("to.is.invalid"));
			}
				if(insDetailDO.getSpec()!=null
						&&insDetailDO.getSpec().getTo()!=null
						&&insDetailDO.getSpec().getTo().getKind()!=null) {
					if(!(Constants.ROUTE_TO_KIND.equals(insDetailDO.getSpec().getTo().getKind()))) {
						throw new ParamInvalidException(MessageUtils.getMessage("to.kind.is.invalid"));
					}
				}
			}
		
	}

	//add check
	public void checkQuota(AppInstanceDetailDO insDetailDO, String regionId , String projectId) {
		//均为limits值
		double cpuRest = 0;
		double memoryRest = 0;
		int podsRest=0;
		double cpuReq = 0;
		double memoryReq = 0;
		double cpuLim = 0;
		double memoryLim = 0;
		int pods=0;
		
		ResourceQuotaDTOExample example = new ResourceQuotaDTOExample();
		com.cloud.api.dto.ResourceQuotaDTOExample.Criteria criteria = example.createCriteria();
		criteria.andProjectEqualTo(projectId);
		criteria.andRegionIdEqualTo(regionId);
		List<ResourceQuotaDTO> resourceQuotaDTOs = resourceQuotaMapper.selectByExample(example);
	
		if (resourceQuotaDTOs != null && !resourceQuotaDTOs.isEmpty()) {
			cpuRest = resourceQuotaDTOs.get(0).getCpuRest();
			memoryRest = resourceQuotaDTOs.get(0).getMemoryRest();
			podsRest=resourceQuotaDTOs.get(0).getPodsRest();
		}
		
		//pods
		if(insDetailDO.getSpec().getReplicas()==null) {
			throw new ParamInvalidException(MessageUtils.getMessage("replicas.is.null"));
		}
		pods= insDetailDO.getSpec().getReplicas();
		
		//request 不需要校验 只需要校验limits
		//get request
		String cpuReqStr = "";
		String memoryReqStr = "";
		try {
			if(cpuRest>0) {
				
			}
			cpuReqStr = insDetailDO.getSpec().getTemplate().getSpec().getContainers().get(0).getResources()
					.getRequests().get("cpu");
			memoryReqStr = insDetailDO.getSpec().getTemplate().getSpec().getContainers().get(0).getResources()
					.getRequests().get("memory");
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		cpuReq = resourceValidUtils.cpuUnit(cpuReqStr, Constants.RESOURCE_REQUESTS) * pods;
		memoryReq = resourceValidUtils.memoryUnit(memoryReqStr, Constants.RESOURCE_REQUESTS) * pods;
		
		//get limits
		String cpuLimStr = "";
		String memoryLimStr = "";
		try {
			cpuLimStr = insDetailDO.getSpec().getTemplate().getSpec().getContainers().get(0).getResources()
					.getLimits().get("cpu");
		} catch (NullPointerException e) {
			throw new ParamInvalidException(MessageUtils.getMessage("resources.limits.cpu.is.null"));
		}
		try {
			memoryLimStr = insDetailDO.getSpec().getTemplate().getSpec().getContainers().get(0).getResources()
					.getLimits().get("memory");
		} catch (NullPointerException e) {
			throw new ParamInvalidException(MessageUtils.getMessage("resources.limits.memory.is.null"));
		}
		cpuLim = resourceValidUtils.cpuUnit(cpuLimStr, Constants.RESOURCE_LIMITS) * pods;
		memoryLim = resourceValidUtils.memoryUnit(memoryLimStr, Constants.RESOURCE_LIMITS) * pods;
		
		//check pods
		if(pods>podsRest) {
			throw new ParamInvalidException(MessageUtils.getMessage("replicas.is.too.large"));
		}
		
		//check less than 0
		if(pods<=0) {
			throw new ParamInvalidException(MessageUtils.getMessage("replicas.less.than.zero"));
		}
//		if(cpuReq<0) {
//			throw new ParamInvalidException(MessageUtils.getMessage("resource.requests.cpu.less.than.zero"));
//		}
//		if(memoryReq<0) {
//			throw new ParamInvalidException(MessageUtils.getMessage("resource.requests.memory.less.than.zero"));
//		}
		
		//check request less than limits
		if(cpuReq>cpuLim) {
			throw new ParamInvalidException(MessageUtils.getMessage("resource.requests.cpu.less.than.limits"));
		}
		if(memoryReq>memoryLim) {
			throw new ParamInvalidException(MessageUtils.getMessage("resource.requests.memory.less.than.limits"));
		}

		// check Limit less than rest
		if (cpuLim > cpuRest) {
			throw new ParamInvalidException(MessageUtils.getMessage("resource.limits.cpu.is.too.large"));
		}
		if (memoryLim > memoryRest) {
			throw new ParamInvalidException(MessageUtils.getMessage("resource.limits.memory.is.too.large"));
		}
	}
	
	//update check
	public void checkQuotaUpdate(AppInstanceDetailDO insDetailDO, String project,String instanceId) {
		//均为limits值
		double cpuRest = 0;
		double memoryRest = 0;
		int podsRest=0;
		double cpuReq = 0;
		double memoryReq = 0;
		double cpuLim = 0;
		double memoryLim = 0;
		double cpuOld=0;
		double memoryOld = 0;
		int podsOld=0;
		
		//到db查下实际的deployment的资源数
		DeploymentDTOExample exampleDep = new DeploymentDTOExample();
		Criteria criteriaDep = exampleDep.createCriteria();
		criteriaDep.andInstanceIdEqualTo(instanceId);
		List<DeploymentDTO> deploymentList = deploymentMapper.selectByExample(exampleDep);
		if (deploymentList != null && !deploymentList.isEmpty()) {
			SpecDO spec = JsonUtils.jsonToObject(deploymentList.get(0).getSpec(), SpecDO.class);
			podsOld=spec.getReplicas();
			cpuOld=resourceValidUtils.cpuUnit(spec.getTemplate().getSpec().getContainers().get(0).getResources().getLimits().get(Constants.RESOURCE_CPU), "");
			memoryOld=resourceValidUtils.memoryUnit(spec.getTemplate().getSpec().getContainers().get(0).getResources().getLimits().get(Constants.RESOURCE_MEMORY), "");
		}
		
		ResourceQuotaDTOExample example = new ResourceQuotaDTOExample();
		com.cloud.api.dto.ResourceQuotaDTOExample.Criteria criteria = example.createCriteria();
		criteria.andProjectEqualTo(project);
		List<ResourceQuotaDTO> resourceQuotaDTOs = resourceQuotaMapper.selectByExample(example);
	
		//rest+old check update
		if (resourceQuotaDTOs != null && !resourceQuotaDTOs.isEmpty()) {
			cpuRest = resourceQuotaDTOs.get(0).getCpuRest()+cpuOld;
			memoryRest = resourceQuotaDTOs.get(0).getMemoryRest()+memoryOld;
			podsRest=resourceQuotaDTOs.get(0).getPodsRest()+podsOld;
		}
		
		//pods
		int pods= insDetailDO.getSpec().getReplicas();
		
		//get request
		String cpuReqStr = insDetailDO.getSpec().getTemplate().getSpec().getContainers().get(0).getResources()
				.getRequests().get("cpu");
		String memoryReqStr = insDetailDO.getSpec().getTemplate().getSpec().getContainers().get(0).getResources()
				.getRequests().get("memory");
		cpuReq = resourceValidUtils.cpuUnit(cpuReqStr, Constants.RESOURCE_REQUESTS) * pods;
		memoryReq = resourceValidUtils.memoryUnit(memoryReqStr, Constants.RESOURCE_REQUESTS) * pods;
		
		//get limits
		String cpuLimStr = insDetailDO.getSpec().getTemplate().getSpec().getContainers().get(0).getResources()
				.getLimits().get("cpu");
		String memoryLimStr = insDetailDO.getSpec().getTemplate().getSpec().getContainers().get(0).getResources()
				.getLimits().get("memory");
		cpuLim = resourceValidUtils.cpuUnit(cpuLimStr, Constants.RESOURCE_LIMITS) * pods;
		memoryLim = resourceValidUtils.memoryUnit(memoryLimStr, Constants.RESOURCE_LIMITS) * pods;
		
		//check pods
		if(pods>podsRest) {
			throw new ParamInvalidException(MessageUtils.getMessage("replicas.is.too.large"));
		}
		
		//check less than 0
		if(pods<0) {
			throw new ParamInvalidException(MessageUtils.getMessage("replicas.less.than.zero"));
		}
		if(cpuReq<0) {
			throw new ParamInvalidException(MessageUtils.getMessage("resource.requests.cpu.less.than.zero"));
		}
		if(memoryReq<0) {
			throw new ParamInvalidException(MessageUtils.getMessage("resource.requests.memory.less.than.zero"));
		}
		
		
		//check request less than limits
		if(cpuReq>cpuLim) {
			throw new ParamInvalidException(MessageUtils.getMessage("resource.requests.cpu.less.than.limits"));
		}
		if(memoryReq>memoryLim) {
			throw new ParamInvalidException(MessageUtils.getMessage("resource.requests.memory.less.than.limits"));
		}

		
		// check Limit less than rest
		if (cpuLim > cpuRest) {
			throw new ParamInvalidException(MessageUtils.getMessage("resource.limits.cpu.is.too.large"));
		}
		if (memoryLim > memoryRest) {
			throw new ParamInvalidException(MessageUtils.getMessage("resource.limits.memory.is.too.large"));
		}
	}
}
