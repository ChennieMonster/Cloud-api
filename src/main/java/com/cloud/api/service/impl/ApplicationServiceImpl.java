/**
 * 
 */
package com.cloud.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.exception.ParamInvalidException;
import com.cloud.api.core.exception.ServiceException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.AppInstanceDTO;
import com.cloud.api.dto.ApplicationDTO;
import com.cloud.api.dto.ApplicationDTOExample;
import com.cloud.api.dto.ApplicationDTOExample.Criteria;
import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.dto.RegistryDTO;
import com.cloud.api.dto.RegistryDTOExample;
import com.cloud.api.dto.RouteDTO;
import com.cloud.api.dto.ServiceDTO;
import com.cloud.api.entity.AppInstanceDO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.ApplicationDetailDO;
import com.cloud.api.entity.ContainersDO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.ImagePullSecretsDO;
import com.cloud.api.entity.PodDO;
import com.cloud.api.entity.PodSpecDO;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ApplicationRequest;
import com.cloud.api.mapper.AppInstanceMapper;
import com.cloud.api.mapper.ApplicationMapper;
import com.cloud.api.mapper.RegistryMapper;
import com.cloud.api.mapper.ResourceQuotaMapper;
import com.cloud.api.service.ApplicationService;
import com.cloud.api.service.DeploymentService;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.RouteService;
import com.cloud.api.service.ServiceService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.InvalidationUtils;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.MessageUtils;
import com.cloud.api.util.StringToUTCDate;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ApplicationServiceImpl extends BaseService implements ApplicationService {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

	@Resource
	private ApplicationMapper applicationMapper;
	
	@Resource
    private AppInstanceMapper instanceMapper;
	
	@Resource
    private RouteService routeService;
	
	@Resource
    private ServiceService serviceService;
	
	@Resource
    private DeploymentService deploymentService;
	
	@Resource
	private InvalidationUtils invalidationUtils;
	
	@Resource
    private ResourceQuotaMapper resourceQuotaMapper;
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private RegistryMapper registryMapper;
	
	@Override
	public List<ApplicationDTO> getApplications() {
		logger.info("getApplications begin");
		logger.info("getApplications end");
		return applicationMapper.getApplications();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ApplicationDetailDO getApplicationDetail(String uuid) {
		logger.info("getApplicationDetail begin; uuid =" + uuid);
		ApplicationDTO applicationDTO = applicationMapper.queryApplicationByUuid(uuid);
		List<AppInstanceDTO> appInstanceDTOList = instanceMapper.queryByApplicationId(uuid);
		
		ApplicationDetailDO applicationDetailDO = new ApplicationDetailDO();
		List<AppInstanceDO> appInstanceDOList = new ArrayList<>();
		for (AppInstanceDTO appInstanceDTO : appInstanceDTOList) {
			AppInstanceDO appInstanceDO = new AppInstanceDO();
			appInstanceDO.setInstanceName(appInstanceDTO.getName());
			appInstanceDO.setInstanceDisplayName(appInstanceDTO.getDisplayName());
			appInstanceDO.setInstanceDescription(appInstanceDTO.getDescription());
			List<AppInstanceDetailDO> list = JsonUtils.jsonToObject(appInstanceDTO.getObjects(), List.class,AppInstanceDetailDO.class);
			appInstanceDO.setObjects(list);
			appInstanceDOList.add(appInstanceDO);
		}
		
		applicationDetailDO.setApplicationName(applicationDTO.getName());
		applicationDetailDO.setApplicationDisplayName(applicationDTO.getDisplayName());
		applicationDetailDO.setApplicationDescription(applicationDTO.getDescription());
		applicationDetailDO.setInstances(appInstanceDOList);
		applicationDetailDO.setParameters(JsonUtils.jsonToObject(applicationDTO.getParameters(), List.class));
		logger.info("getApplicationDetail end");
		return applicationDetailDO;
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addApplication(ApplicationRequest requestData, TokenDO token,String regionId, String project) {
		
		logger.info("addApplication begin, name = " +requestData.getApplicationName());
		// 校验application是否有instance，instance中是否有object
		if (requestData.getInstances() == null) {
			throw new ServiceException(MessageUtils.getMessage("instance.is.not.null"));
		} else {
			List<AppInstanceDO> instanceDOList = requestData.getInstances();
			for (AppInstanceDO appInstanceDO : instanceDOList) {
				if (appInstanceDO.getObjects() == null) {
					throw new ServiceException(MessageUtils.getMessage("instance.objects.are.not.null"));
				}
			}
		}
		
		ApplicationDTO applicationInTable = applicationMapper.queryApplicationByUuidByName(requestData.getApplicationName());
		if(applicationInTable!=null) {
			throw new ServiceException(MessageUtils.getMessage("application.name.has.exist"));
		}
		
		ProjectDTO projectDto = projectService.queryProjectByRegionIdAndProjectName(regionId, project);
		ApplicationDTO applicationDTO = new ApplicationDTO();
		applicationDTO.setCreatedTime(new Date());
		applicationDTO.setDescription(requestData.getApplicationDescription());
		applicationDTO.setDisplayName(requestData.getApplicationDisplayName());
		applicationDTO.setName(requestData.getApplicationName());
		applicationDTO.setUuid(IdGen.uuid());
		applicationDTO.setProject(projectDto.getUuid());
		applicationDTO.setIsRegistry(requestData.getIsRegistry());
		if(requestData.getParameters()!=null) {
			applicationDTO.setParameters(JsonUtils.objectToJson(requestData.getParameters()));
		}
		applicationDTO.setStatus(Constants.STATUS);
		applicationMapper.insertApplication(applicationDTO);
		
		/*
		 * 校验instanceName不能重复
		 */
		List<String> instanceNameList = new ArrayList<>();
		for(AppInstanceDO instanceDO : requestData.getInstances()) {
			instanceNameList.add(instanceDO.getInstanceName());
		}
		Set nameSet = new HashSet(instanceNameList);
		if (nameSet.size()<instanceNameList.size()) {
			throw new ParamInvalidException(MessageUtils.getMessage("instance.name.can't.be.same"));
		}
		
		for(AppInstanceDO instanceDO : requestData.getInstances()) {
			
			AppInstanceDTO instanceDTO = new AppInstanceDTO();
			instanceDTO.setName(instanceDO.getInstanceName());
			instanceDTO.setDisplayName(instanceDO.getInstanceDisplayName());
			instanceDTO.setDescription(instanceDO.getInstanceDescription());
			instanceDTO.setCreatedTime(new Date());
			instanceDTO.setUuid(IdGen.uuid());
			instanceDTO.setApplicationId(applicationDTO.getUuid());
			
			//存在数据库中的object不应该带有parameters
			int times = -1;
			List<AppInstanceDetailDO> instanceDetailDOList = instanceDO.getObjects();
			/*
			 * 解析parameters
			 */
			for(AppInstanceDetailDO insDetailDO : instanceDetailDOList) {
				times++;
				String instanceStr = JsonUtils.objectToJson(insDetailDO);
				if(requestData.getParameters()!=null) {
					for(Map<String, String> map : requestData.getParameters()) {
						String originStr = map.get("name");
						String startStr = "${"+originStr+"}";
						instanceStr = instanceStr.replace(startStr, map.get("value"));
					}
				}
				
				insDetailDO = JsonUtils.jsonToObject(instanceStr, AppInstanceDetailDO.class);
				//存在数据库中的object不应该带有parameters
				instanceDetailDOList.set(times, insDetailDO);
				
				//参数校验
				invalidationUtils.checkInstance(insDetailDO, project);
				
				/*
				 * 为deployment的container添加imagePullSecrets -start
				 */
				if("Deployment".equals(insDetailDO.getKind())) {/*
					List<ContainersDO> containersList = insDetailDO.getSpec().getTemplate().getSpec().getContainers();
					ContainersDO container = containersList.get(0);
					String image = container.getImage().substring(0, container.getImage().indexOf("/"));
					
					RegistryDTOExample exampleRegistry = new RegistryDTOExample();
					com.cloud.api.dto.RegistryDTOExample.Criteria criteriaRegistry = exampleRegistry.createCriteria();
					List<String> projectIdList = new ArrayList<>();
					projectIdList.add("0"); //0表示平台
					projectIdList.add(projectDto.getUuid());
					criteriaRegistry.andUrlLike("%" + image + "%");
					criteriaRegistry.andProjectIdIn(projectIdList);
					List<RegistryDTO> registryList = registryMapper.selectByExample(exampleRegistry);
					
					if (registryList.size() > 0) {
						String secretName = registryList.get(0).getSecretName();
						List<ImagePullSecretsDO> imagePullSecrets = new ArrayList<>();
						ImagePullSecretsDO ImagePullSecretsDO = new ImagePullSecretsDO();
						ImagePullSecretsDO.setName(secretName);
						imagePullSecrets.add(ImagePullSecretsDO);
						container.setImagePullSecrets(imagePullSecrets);
						containersList.set(0, container);
						SpecDO spec = insDetailDO.getSpec();
						PodDO pod = spec.getTemplate();
						PodSpecDO podSpec = pod.getSpec();
						podSpec.setContainers(containersList);
						pod.setSpec(podSpec);
						spec.setTemplate(pod);
						insDetailDO.setSpec(spec);
					}
				*/}
				
				/*
				 * 为deployment的container添加imagePullSecrets -end
				 */
				
				if("Route".equals(insDetailDO.getKind())) {
					routeService.insertRoute(insDetailDO, instanceDTO.getUuid(), token, project);
				}else if("Service".equals(insDetailDO.getKind())) {
					serviceService.insertService(insDetailDO, instanceDTO.getUuid(), token, project);
				}else if("Deployment".equals(insDetailDO.getKind())) {
					//check quota
					invalidationUtils.checkQuota(insDetailDO,regionId, projectDto.getUuid());
					deploymentService.addOpenShiftDeployment(insDetailDO, instanceDTO.getUuid(), token, project);
				}
			}
			
			instanceDTO.setObjects(JsonUtils.objectToJson(instanceDO.getObjects()));
			instanceMapper.insertAppInstance(instanceDTO);
		}
		logger.info("addApplication end");
	}

	@Override
	public void updateApplication(TokenDO token, ApplicationRequest requestData, String uuid, String project) {
		
		logger.info("updateApplication begin, uuid="+uuid);
		ApplicationDTO applicationDTO = applicationMapper.queryApplicationByUuid(uuid);
		applicationDTO.setUpdatedTime(new Date());
		applicationDTO.setDescription(requestData.getApplicationDescription());
		applicationDTO.setDisplayName(requestData.getApplicationDisplayName());
		applicationMapper.updateApplication(applicationDTO);
		
		logger.info("updateApplication end");
	}

	@Override
	public boolean deleteApplications(TokenDO token, List<String> ids, String project) {
		logger.info("deleteApplications begin, ids="+JsonUtils.objectToJson(ids));
		for (String id : ids) {
			ApplicationDTO application = applicationMapper.queryApplicationByUuid(id);
			List<AppInstanceDTO> instanceList = instanceMapper.queryByApplicationId(application.getUuid());
			List<String> instanceIds = new ArrayList<>();
			if(!(instanceList.size()==0||instanceList ==null)) {
				for (AppInstanceDTO instance : instanceList) {
					RouteDTO route = routeService.queryRouteByInstanceId(instance.getUuid());
					ServiceDTO service = serviceService.queryServiceByInstanceId(instance.getUuid());
					DeploymentDTO deployment = deploymentService.getDeploymentByInstanceId(instance.getUuid());
					if (route != null) {

						routeService.deleteRoute(instance.getUuid(), route.getName(), token, project);

					}
					if (service != null) {
						serviceService.deleteService(instance.getUuid(), service.getName(), token, project);

					}
					if (deployment != null) {
						deploymentService.deleteOpenShiftDeployment(instance.getUuid(), token, deployment.getName(),
								project);

					}
					instanceIds.add(instance.getUuid());
				}
				instanceMapper.deleteAppInstances(instanceIds);
			}
		}
		
		int i = applicationMapper.deleteApplications(ids);
		if (i != ids.size()) {
			return false;
		}
		logger.info("deleteApplications end");
		return true;
	}

	@Override
	public List<ApplicationDTO> filterApplication(List<GetListParamElement> filterList, String regionId, String project) {
		logger.info("filterApplication begin:"+JsonUtils.objectToJson(filterList));
		// TODO Auto-generated method stub
		//Display Name,Status,Description,CreatedTime
		logger.info("==========进入filterApplication");
		ProjectDTO projectDto = projectService.queryProjectByRegionIdAndProjectName(regionId, project);
		ApplicationDTOExample example =new ApplicationDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.andIsRegistryEqualTo(Constants.IS_NOT_A_REGISTRY);
		if(filterList != null && !filterList.isEmpty()) {
			criteria.andProjectEqualTo(projectDto.getUuid());
			for(int i = 0 ; i<filterList.size() ; i++) {
				String key =filterList.get(i).getKey();
				if(key.equals(Constants.FILTER_NAME_DISPLAYNAME)) {
					String value=filterList.get(i).getValue();
					criteria.andDisplayNameLike("%"+value+"%");
				}else if(key.equals(Constants.FILTER_NAME_STATUS)) {
					String value=filterList.get(i).getValue();
					//解析value中的逗号
					String a []  = value.split(",");
					List<String> valueList =new ArrayList<>();
					for(int j=0;j<a.length;j++) {
						valueList.add(a[j]);
					}
					criteria.andStatusIn(valueList);
				}else if(key.equals(Constants.FILTER_NAME_DESCRIPTION)) {
					String value=filterList.get(i).getValue();
					criteria.andDescriptionLike("%"+value+"%");
				}else if(key.equals(Constants.FILTER_NAME_CREATEDTIME)) {
					String value=filterList.get(i).getValue();
					String str1=value.substring(0,value.indexOf("~"));
					String str2=value.substring(value.indexOf("~")+1,value.length());
					logger.info(str1+"====="+str2);
					if(str1.equals("*")&&!str2.equals("*")) {
						Date time=StringToUTCDate.toDate(str2);
						criteria.andCreatedTimeLessThanOrEqualTo(time);
					}else if(!str1.equals("*")&&str2.equals("*")) {
						Date time=StringToUTCDate.toDate(str1);
						criteria.andCreatedTimeGreaterThanOrEqualTo(time);
					}else if(str1.equals(str2)&&!str2.equals("*")) {
						Date time=StringToUTCDate.toDate(str1);
						criteria.andCreatedTimeEqualTo(time);
					}else if(!str1.equals("*")&&!str2.equals("*")) {
						logger.info("进入==");
						Date time1=StringToUTCDate.toDate(str1);
						Date time2=StringToUTCDate.toDate(str2);
						logger.info(time1+"==time=="+time2);
						criteria.andCreatedTimeGreaterThanOrEqualTo(time1);
						criteria.andCreatedTimeLessThanOrEqualTo(time2);
					}
				}
			}
		}else {
			criteria.andProjectEqualTo(projectDto.getUuid());
		}
		logger.info("filterApplication end");
		return applicationMapper.selectByExample(example);
	}

	@Override
	public long countApplication() {
		// TODO Auto-generated method stub
		ApplicationDTOExample example =new ApplicationDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.getAllCriteria();
		return applicationMapper.countByExample(example);
	}

}
