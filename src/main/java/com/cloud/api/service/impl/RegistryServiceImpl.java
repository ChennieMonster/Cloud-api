/**
 * 
 */
package com.cloud.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.exception.ParamInvalidException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.ApplicationDTO;
import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.dto.ImageDTO;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.dto.RegistryDTO;
import com.cloud.api.dto.RegistryDTOExample;
import com.cloud.api.dto.RegistryDTOExample.Criteria;
import com.cloud.api.dto.ServiceDTO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.MqMessage;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.TemplateDetailDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ApplicationRequest;
import com.cloud.api.entity.request.RegistryRequestData;
import com.cloud.api.mapper.ApplicationMapper;
import com.cloud.api.mapper.RegistryMapper;
import com.cloud.api.mapper.TemplateMapper;
import com.cloud.api.service.ApplicationService;
import com.cloud.api.service.DeploymentService;
import com.cloud.api.service.ImageService;
import com.cloud.api.service.LayerService;
import com.cloud.api.service.MQMessageService;
import com.cloud.api.service.PodService;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.RegistryService;
import com.cloud.api.service.RoleService;
import com.cloud.api.service.SecretService;
import com.cloud.api.service.ServiceService;
import com.cloud.api.service.TagService;
import com.cloud.api.service.TemplateService;
import com.cloud.api.util.ClientConstants;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.MessageUtils;
import com.cloud.api.util.SecretUtils;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RegistryServiceImpl extends BaseService implements RegistryService {

	@Resource
	private RegistryMapper registryMapper;

	@Resource
	private TemplateMapper templateMapper;

	@Resource
	private ApplicationService applicationService;

	@Resource
	private TemplateService templateService;

	@Resource
	private ImageService imageService;

	@Resource
	private MQMessageService mqMessageService;

	@Resource
	private ApplicationMapper applicationMapper;

	@Resource
	private PodService podService;

	@Resource
	private DeploymentService deploymentService;

	@Resource
	private ProjectService projectService;

	@Resource
	private ServiceService serviceService;

	@Resource
	private SecretService secretService;
	
	@Resource
	private LayerService layerService;
	
	@Resource
	private TagService tagService;
	
	@Resource
	private RoleService roleService;
	
	@Override
	public boolean addRegistry(TokenDO token, RegistryRequestData requestData, String project,String regionId) {
		if (countByName(requestData.getRegistryName()) > 0) {
			throw new ParamInvalidException(MessageUtils.getMessage("registry.name.already.exists"));
		}
		
		RegistryDTO registry = new RegistryDTO();
		
		ProjectDTO projectDTO = projectService.queryProjectByRegionIdAndProjectName(regionId,project);
		
		if (Constants.REGISTRY_TYPE_PRIVATE.equalsIgnoreCase(requestData.getRegistryType())) {
			if (requestData.getRegistryCpu() <= 0) {
				throw new ParamInvalidException(MessageUtils.getMessage("registry.cpu.min"));
			}
			// 创建service
			createApp(token, requestData, project, Constants.REGISTRY_CREATE_NAME_SERVICE,regionId);

			// 创建route
			createApp(token, requestData, project, Constants.REGISTRY_CREATE_NAME_ROUTE,regionId);

			ServiceDTO serviceDTO = serviceService.queryServiceByName(requestData.getRegistryName());
			// 创建secret
			String serviceIp = serviceDTO.getIp();
			Map<String, String> map = SecretUtils.createTls(serviceIp, requestData.getRegistryName(),
					requestData.getRegistryName(), project);
			secretService.createSecret(token, project, requestData.getRegistryName(), map.get("tls.crt"),
					map.get("tls.key"));

			// 创建deployment
			createApp(token, requestData, project, Constants.REGISTRY_CREATE_NAME_DEPLOYMENT,regionId);
			
			// deployment创建成功后，删除备份文件
//			FileUtil.deleteFileDirectory(map.get("path"));
			
			requestData.setUrl(ClientConstants.URL_HTTPS + requestData.getRegistryName() + Constants.ROUTE_HOST_SUFFIX);
			registry.setCpuCore(requestData.getRegistryCpu());
			registry.setDisk(requestData.getRegistryDisk());
			registry.setMemory(requestData.getRegistryMemory());
		}else if(Constants.REGISTRY_TYPE_THIRD.equalsIgnoreCase(requestData.getRegistryType())) {
			if(!requestData.getUrl().startsWith("https://")) {
				throw new ParamInvalidException("url master start with 'https://'");
			}
//			secretService.createSecretByUserNameAndPasswd(token, project, "secret-" + requestData.getRegistryName(), requestData.getUserName(), requestData.getPassword(), requestData.getUrl());
//			registry.setSecretName("secret-" + requestData.getRegistryName());
			registry.setUserName(requestData.getUserName());
			registry.setPassword(requestData.getPassword());
		}else if(Constants.REGISTRY_TYPE_PLATFORM.equalsIgnoreCase(requestData.getRegistryType())) {
			registry.setUserName(Constants.REGISTRY_PLATFORM_USERNAME);
			registry.setPassword(Constants.REGISTRY_PLATEFORM_PASSWORD);
		}
		
		// 添加registry
		registry.setName(requestData.getRegistryName());
		registry.setDescription(requestData.getRegistryDescription());
		registry.setDisplayName(requestData.getRegistryDisplayName());
		registry.setUrl(requestData.getUrl());
		registry.setProjectId(projectDTO.getUuid());
		registry.setType(requestData.getRegistryType());
		registry.setUuid(IdGen.uuid());
		int ret = registryMapper.insertSelective(registry);
//		if (ret == 1 && Constants.REGISTRY_TYPE_THIRD.equals(requestData.getRegistryType())) {
//			// 发送mq给同步模块 ，创建定时任务，同步第三方仓库镜像
//			MqMessage message = new MqMessage();
//			message.setRegistryId(registry.getUuid());
//			message.setKind(Constants.MQ_ROUTEKEY_REGISTRY);
//			mqMessageService.sendMqMessage(message);
//		}

		return ret == 1;
	}

	@Override
	public boolean deleteRegistry(List<String> ids, TokenDO token, String project, String region) {

		RegistryDTOExample example = new RegistryDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andUuidIn(ids);
		List<RegistryDTO> list = registryMapper.selectByExample(example);
		List<String> applicationIds = new ArrayList<String>();

		for (RegistryDTO registryDTO : list) {
			if (Constants.REGISTRY_TYPE_PRIVATE.equalsIgnoreCase(registryDTO.getType())) {
				
				roleService.isHaveActionAuth(token.getUserName(),region, project, "RegistriesSettings", "delete");
				
				List<ImageDTO> imageDTOs = imageService.queryImageList(registryDTO.getUuid());
				if (imageDTOs != null && imageDTOs.size() > 0) {
					throw new ParamInvalidException(MessageUtils.getMessage("registry.has.image"));
				}
				// 查询serviceApplication
				ApplicationDTO serviceApplication = applicationMapper
						.queryApplicationByUuidByName(registryDTO.getName() + "-" +Constants.REGISTRY_CREATE_NAME_SERVICE);
				// 查询routeApplicaton
				ApplicationDTO routeApplicaton = applicationMapper
						.queryApplicationByUuidByName(registryDTO.getName() + "-" + Constants.REGISTRY_CREATE_NAME_ROUTE);
				// 查询deploymentApplication
				ApplicationDTO deploymentApplication = applicationMapper
						.queryApplicationByUuidByName(registryDTO.getName() + "-" + Constants.REGISTRY_CREATE_NAME_DEPLOYMENT);
				if (serviceApplication != null) {
					applicationIds.add(serviceApplication.getUuid());
				}
				if (routeApplicaton != null) {
					applicationIds.add(routeApplicaton.getUuid());
				}
				if (deploymentApplication != null) {
					applicationIds.add(deploymentApplication.getUuid());
				}
				secretService.deleteSecret(token, registryDTO.getName(), project);

			}else if(Constants.REGISTRY_TYPE_THIRD.equalsIgnoreCase(registryDTO.getType())) {
				
				roleService.isHaveActionAuth(token.getUserName(),region, project, "RegistriesSettings", "remove");
				
				//删除layer
				layerService.deleteLayerByRegistryId(registryDTO.getUuid());
				//删除tag
				tagService.deleteTagByRegistryId(registryDTO.getUuid());
				//删除image
				imageService.deleteImageByRegistryId(registryDTO.getUuid());
				
			}
		}
		if (applicationIds == null || applicationIds.size() > 0) {
			applicationService.deleteApplications(token, applicationIds, project);
		}
		return registryMapper.deleteByExample(example) == ids.size();
	}

	@Override
	public boolean editRegistry(RegistryRequestData requestData, String registryId, TokenDO token, String project) {
		RegistryDTO registryOriginal = queryRegistryById(registryId);
		boolean flag = (registryOriginal.getDisk() == requestData.getRegistryDisk()
				&& registryOriginal.getCpuCore() == requestData.getRegistryCpu()
				&& registryOriginal.getMemory() == requestData.getRegistryMemory());
		if (!flag && Constants.REGISTRY_TYPE_PRIVATE.equalsIgnoreCase(requestData.getRegistryType())) {
			DeploymentDTO deploymentDTO = deploymentService.getDeploymentByName(requestData.getRegistryName());
			AppInstanceDetailDO appInstanceDetailDO = new AppInstanceDetailDO();
			appInstanceDetailDO.setApiVersion(deploymentDTO.getApiVersion());
			appInstanceDetailDO.setKind(deploymentDTO.getKind());
			appInstanceDetailDO.setMetadata(JsonUtils.jsonToObject(deploymentDTO.getMetaData(), MetaDataDO.class));
			SpecDO specDO = JsonUtils.jsonToObject(deploymentDTO.getSpec(), SpecDO.class);
			Map<String, String> requestMap = new HashMap<String, String>();
			requestMap.put("cpu", requestData.getRegistryCpu() + "");
			requestMap.put("memory", requestData.getRegistryMemory() + "Mi");
			specDO.getTemplate().getSpec().getContainers().get(0).getResources().setRequests(requestMap);
			specDO.getTemplate().getSpec().getContainers().get(0).getResources().setLimits(requestMap);
			appInstanceDetailDO.setSpec(specDO);
//			deploymentService.updateOpenShiftDeployment(appInstanceDetailDO, deploymentDTO.getInstanceId(), token, project);
		}
		RegistryDTO registry = new RegistryDTO();
		registry.setName(requestData.getRegistryName());
		registry.setCpuCore(requestData.getRegistryCpu());
		registry.setDescription(requestData.getRegistryDescription());
		registry.setDisk(requestData.getRegistryDisk());
		registry.setDisplayName(requestData.getRegistryDisplayName());
		registry.setMemory(requestData.getRegistryMemory());
		registry.setUserName(requestData.getUserName());
		registry.setPassword(requestData.getPassword());
		registry.setType(requestData.getRegistryType());
		registry.setUrl(requestData.getUrl());
		registry.setUuid(registryId);

		return 1 == registryMapper.updateByPrimaryKeySelective(registry);
	}

	@Override
	public List<RegistryDTO> queryRegistryList(String project) {
		List<String> projectList = new ArrayList<String>();
		ProjectDTO projectDTO = projectService.queryProjectByRegionIdAndProjectName(MDC.get(MDCConstants.REGION_ID),project);
		projectList.add(projectDTO.getUuid());
		projectList.add("0");
		RegistryDTOExample example = new RegistryDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andProjectIdIn(projectList);
		example.setOrderByClause("created_time desc");
		List<RegistryDTO> registryList = registryMapper.selectByExample(example);
		for (int i = 0; i < registryList.size(); i++) {
			registryList.get(i).setImageCount(imageService.queryCountByRegistryId(registryList.get(i).getUuid()));
		}
		return registryList;
	}

	@Override
	public RegistryDTO queryRegistryById(String registryID) {
		return registryMapper.selectByPrimaryKey(registryID);
	}

	public int countByName(String name) {
		RegistryDTOExample example = new RegistryDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		return (int) registryMapper.countByExample(example);
	}

	public void createApp(TokenDO token, RegistryRequestData requestData, String project, String createName,String regionId) {

		// 查询template
		ProjectDTO projectDTO = projectService.queryProjectByRegionIdAndProjectName(regionId,project);
		TemplateDetailDO templateDetail = templateService.getTemplateDetailByName(projectDTO.getUuid(), createName);
		if (templateDetail == null) {
			throw new ParamInvalidException("The template to create registry does not exist");
		}
		List<Map<String, String>> paramList = templateDetail.getParameters();
		for (Map<String, String> paramMap : paramList) {
			String paramName = paramMap.get("name");
			if (Constants.PARAM_KEY_NAME.equalsIgnoreCase(paramName)) {
				paramMap.put("value", requestData.getRegistryName());
			} else if (Constants.PARAM_KEY_APPLICATION_DOMAIN.equalsIgnoreCase(paramName)) {
				paramMap.put("value", requestData.getRegistryName() + Constants.ROUTE_HOST_SUFFIX);
			} else if (Constants.PARAM_KEY_IMAGE.equalsIgnoreCase(paramName)) {
				paramMap.put("value", Constants.REGISTRY_PRIVATE_IMAGE);
			} else if (Constants.PARAM_KEY_CPU.equalsIgnoreCase(paramName)) {
				paramMap.put("value", requestData.getRegistryCpu() + "");
			} else if (Constants.PARAM_KEY_MEMORY.equalsIgnoreCase(paramName)) {
				paramMap.put("value", requestData.getRegistryMemory() + "Mi");
			} else if (Constants.PARAM_KEY_NAMESPACE.equalsIgnoreCase(paramName)) {
				paramMap.put("value", project);
			} else if (Constants.PARAM_KEY_SECRETNAME.equalsIgnoreCase(paramName)) {
				paramMap.put("value", requestData.getRegistryName());
			}
		}

		ApplicationRequest appRequestData = new ApplicationRequest();
		appRequestData.setIsRegistry(1);
		appRequestData.setParameters(paramList);
		appRequestData.setInstances(templateDetail.getInstances());
		appRequestData.setApplicationName(requestData.getRegistryName() + "-" + createName);
		appRequestData.setApplicationDisplayName(requestData.getRegistryName() + "-" + createName);
		appRequestData.getInstances().get(0).setInstanceName(requestData.getRegistryName() + "-" + createName);
		appRequestData.getInstances().get(0).setInstanceDisplayName(requestData.getRegistryName() + "-" + createName);
		// 添加application
		applicationService.addApplication(appRequestData, token,regionId, project);
	}

//	public void createSecret(TokenDO token, String project, String name, String tlsCrt, String tlsKey) {
//		System.out.println("====================开始创建secret====================");
//		SecretDO secretDO = new SecretDO(name, tlsCrt, tlsKey);
////		///api/v1/namespaces/cloud-api-test/secrets
//		Invocation<SecretDO> invocation = post(SecretDO.class, "/api/v1/namespaces/" + project + "/secrets", token)
//				.entity(secretDO);
//		invocation.executeWithResponse();
//	}

}
