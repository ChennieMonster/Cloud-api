/**
 * 
 */
package com.cloud.api.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.ho.yaml.Yaml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.exception.ParamInvalidException;
import com.cloud.api.core.exception.ResourcesNotFoundException;
import com.cloud.api.core.exception.ServiceException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.AppInstanceDTO;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.dto.TemplateDTO;
import com.cloud.api.dto.TemplateDTOExample;
import com.cloud.api.dto.TemplateDTOExample.Criteria;
import com.cloud.api.entity.AppInstanceDO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.TemplateDetailDO;
import com.cloud.api.entity.TemplatePostDetailDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.TemplateRequest;
import com.cloud.api.mapper.AppInstanceMapper;
import com.cloud.api.mapper.DeploymentMapper;
import com.cloud.api.mapper.RouteMapper;
import com.cloud.api.mapper.ServiceMapper;
import com.cloud.api.mapper.TemplateMapper;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.RoleService;
import com.cloud.api.service.TemplateService;
import com.cloud.api.util.FileDownloadUtil;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.InvalidationUtils;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.MessageUtils;
import com.cloud.api.util.StringToInteger;
import com.cloud.api.util.StringToUTCDate;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TemplateServiceImpl extends BaseService implements TemplateService {

	private final static Logger log = LoggerFactory.getLogger(TemplateServiceImpl.class);
	
	@Resource
    private TemplateMapper templateMapper;
	
	@Resource
    private AppInstanceMapper instanceMapper;
	
	@Resource
    private ServiceMapper serviceMapper;
    
	@Resource
    private RouteMapper routeMapper;
	
	@Resource
    private DeploymentMapper deploymentMapper;
	
	@Resource
	private InvalidationUtils invalidationUtils;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private ProjectService projectService;
	
	@Value("${exportFile.path}")
	private String path;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String addTemplate(TemplateRequest requestData, TokenDO token,String regionId, String project) {
		log.info("addTemplate begin, name = "+requestData.getTemplateName());
		
		//校验template是否有instance，instance中是否有object
		if(requestData.getInstances()==null) {
			throw new ServiceException(MessageUtils.getMessage("instance.is.not.null"));
		}else {
			List<AppInstanceDO> instanceDOList = requestData.getInstances();
			for(AppInstanceDO appInstanceDO : instanceDOList) {
				if(appInstanceDO.getObjects()==null) {
					throw new ServiceException(MessageUtils.getMessage("instance.objects.are.not.null"));
				}
			}
		}
		ProjectDTO projectDto = projectService.queryProjectByRegionIdAndProjectName(regionId, project);
		TemplateDTO templateInTable = templateMapper.queryTemplateByName(projectDto.getUuid(), requestData.getTemplateName());
		if(templateInTable !=null) {
			throw new ServiceException(MessageUtils.getMessage("template.name.has.exist"));
		}
		
		List<AppInstanceDetailDO> appInstanceDetailDOObjects = new ArrayList<AppInstanceDetailDO>();
		MetaDataDO metaDataDO = new MetaDataDO();
		metaDataDO.setName(requestData.getTemplateName());
		if(Constants.REGISTRY_TYPE_PRIVATE.equals(requestData.getType())) {
			metaDataDO.setNamespace(project);
		}else if(Constants.REGISTRY_TYPE_PLATFORM.equals(requestData.getType())) {
			metaDataDO.setNamespace(Constants.NAMESPACE_OPENSHIFT);
		}
		
		TemplatePostDetailDO templatePostDetailDO = new TemplatePostDetailDO();
		//将TemplateDetailDO中的InstanceList中的Objects给将要传给openshift的对象中
		for(AppInstanceDO instanceDO : requestData.getInstances()) {
			appInstanceDetailDOObjects.addAll(instanceDO.getObjects());
		}
		templatePostDetailDO.setApiVersion(Constants.APIVERSION);
		templatePostDetailDO.setObjects(appInstanceDetailDOObjects);
		templatePostDetailDO.setKind(Constants.TEMPLATE_KIND);
		templatePostDetailDO.setMetadata(metaDataDO);
		
		templatePostDetailDO.setParameters(requestData.getParameters());
		
		TemplateDTO templateDTO = new TemplateDTO();
		templateDTO.setName(requestData.getTemplateName());
		templateDTO.setDisplayName(requestData.getTemplateDisplayName());
		templateDTO.setDescription(requestData.getTemplateDescription());
		templateDTO.setType(requestData.getType());
		templateDTO.setInstanceCount(requestData.getInstances().size());
		templateDTO.setUuid(IdGen.uuid());
		templateDTO.setCreatedTime(new Date());
		if(Constants.REGISTRY_TYPE_PRIVATE.equals(requestData.getType())) {
			templateDTO.setProject(projectDto.getUuid());
		}else if(Constants.REGISTRY_TYPE_PLATFORM.equals(requestData.getType())) {
			ProjectDTO projectDtoDefault = projectService.queryProjectByRegionIdAndProjectName(regionId, Constants.NAMESPACE_OPENSHIFT);
			templateDTO.setProject(projectDtoDefault.getUuid());
		}
		templateDTO.setObjects(JsonUtils.objectToJson(requestData.getInstances()));
		if(requestData.getParameters()!=null) {
			templateDTO.setParameters(JsonUtils.objectToJson(requestData.getParameters()));
		}
		templateDTO.setApiVersion(Constants.APIVERSION);
		templateDTO.setMetadata(JsonUtils.objectToJson(metaDataDO));
		
		//判断是否是应用商店的专用template 0-非专用 1-专用
		if(requestData.getIsMarket()==1) {
			templateDTO.setIsMarket(1);
		}else {
			templateDTO.setIsMarket(0);
		}
		
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
		
		List<AppInstanceDetailDO> insDetailDOWithoutParamList = new ArrayList<>();
		for(AppInstanceDO instanceDO : requestData.getInstances()) {
			
			for(AppInstanceDetailDO insDetailDO : instanceDO.getObjects()) {
				
				String instanceStr = JsonUtils.objectToJson(insDetailDO);
				if(requestData.getParameters()!=null) {
					for(Map<String, String> map : requestData.getParameters()) {
						String originStr = map.get("name");
						String startStr = "${"+originStr+"}";
						instanceStr = instanceStr.replace(startStr, map.get("value"));
					}
				}
				
				insDetailDO = JsonUtils.jsonToObject(instanceStr, AppInstanceDetailDO.class);
				insDetailDOWithoutParamList.add(insDetailDO);
				/*
				 * service,route,deployment都在application创建时插入库中
				 * 这里可以做一些校验
				 */
				invalidationUtils.checkInstance(insDetailDO, project);
			}
			
			AppInstanceDTO instanceDTO = new AppInstanceDTO();
			instanceDTO.setName(instanceDO.getInstanceName());
			instanceDTO.setDisplayName(instanceDO.getInstanceDisplayName());
			instanceDTO.setDescription(instanceDO.getInstanceDescription());
			instanceDTO.setCreatedTime(new Date());
			instanceDTO.setUuid(IdGen.uuid());
			instanceDTO.setTemplateId(templateDTO.getUuid());
			if(instanceDO.getObjects()!=null) {
				instanceDTO.setObjects(JsonUtils.objectToJson(insDetailDOWithoutParamList));
			}
			instanceMapper.insertAppInstance(instanceDTO);
			
		}
		
		/*
		 * 发送OpenShift请求
		 */
		if(Constants.REGISTRY_TYPE_PRIVATE.equals(requestData.getType())) {
			Invocation<TemplatePostDetailDO> invocation = post(TemplatePostDetailDO.class, "/apis/template.openshift.io/v1/namespaces/"+project+"/templates", token).entity(templatePostDetailDO);
			invocation.executeWithResponse();
		}else if(Constants.REGISTRY_TYPE_PLATFORM.equals(requestData.getType())) {
			Invocation<TemplatePostDetailDO> invocation = post(TemplatePostDetailDO.class, "/apis/template.openshift.io/v1/namespaces/"+Constants.NAMESPACE_OPENSHIFT+"/templates", token).entity(templatePostDetailDO);
			invocation.executeWithResponse();
		}
		
		//插入template
		templateMapper.insertTemplate(templateDTO);
		
		log.info("addTemplate end");
		return templateDTO.getUuid();
	}

	@Override
	public boolean deleteTemplates(TokenDO token, List<String> ids,String regionId, String project) {
		log.info("deleteTemplates begin, ids="+JsonUtils.objectToJson(ids));
		for (String id : ids) {
			TemplateDTO templateDto = templateMapper.queryTemplateByUuid(id);
			if(templateDto!=null) {
				try {
					if(Constants.REGISTRY_TYPE_PRIVATE.equals(templateDto.getType())) {
						//先权限校验
						roleService.isHaveActionAuth(token.getUserName(),regionId, project, Constants.MODULES_TEMPLATES_PRIVATE,Constants.ACTION_DELETE);
						Invocation<TemplateDTO> template = delete(TemplateDTO.class,
								"/apis/template.openshift.io/v1/namespaces/"+project+"/templates/" + templateDto.getName(), token);
						template.executeWithResponse();
					}else if(Constants.REGISTRY_TYPE_PLATFORM.equals(templateDto.getType())) {
						//先权限校验
						roleService.isHaveActionAuth(token.getUserName(),regionId, project, Constants.MODULES_TEMPLATES_PLATFORM,Constants.ACTION_DELETE);
						Invocation<TemplateDTO> template = delete(TemplateDTO.class,
								"/apis/template.openshift.io/v1/namespaces/"+Constants.NAMESPACE_OPENSHIFT+"/templates/" + templateDto.getName(), token);
						template.executeWithResponse();
					}
					
				} catch (ResourcesNotFoundException e) {
					//log
				}
				
			}
		}
		int i = templateMapper.deleteTemplates(ids);
		if (i != ids.size()) {
			return false;
		}
		log.info("deleteTemplates end");
		return true;
	}

	@Override
	public TemplateDTO queryTemplateByUuid(String uuid) {
		return templateMapper.queryTemplateByUuid(uuid);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void editTemplate(TokenDO token, TemplateRequest requestData, String uuid, String project) {
		log.info("editTemplate begin, uuid="+uuid);
		// 校验template是否有instance，instance中是否有object
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
		
		List<AppInstanceDetailDO> appInstanceDetailDOObjects = new ArrayList<AppInstanceDetailDO>();
		MetaDataDO metaDataDO = new MetaDataDO();
		metaDataDO.setName(requestData.getTemplateName());
		if(Constants.REGISTRY_TYPE_PRIVATE.equals(requestData.getType())) {
			metaDataDO.setNamespace(project);
		}else if(Constants.REGISTRY_TYPE_PLATFORM.equals(requestData.getType())) {
			metaDataDO.setNamespace(Constants.NAMESPACE_OPENSHIFT);
		}

		TemplatePostDetailDO templatePostDetailDO = new TemplatePostDetailDO();
		// 将TemplateDetailDO中的InstanceList中的Objects给将要传给openshift的对象中
		for (AppInstanceDO instanceDO : requestData.getInstances()) {
			appInstanceDetailDOObjects.addAll(instanceDO.getObjects());
		}
		templatePostDetailDO.setApiVersion(Constants.APIVERSION);
		templatePostDetailDO.setObjects(appInstanceDetailDOObjects);
		templatePostDetailDO.setKind(Constants.TEMPLATE_KIND);
		templatePostDetailDO.setMetadata(metaDataDO);

		templatePostDetailDO.setParameters(requestData.getParameters());
		
		TemplateDTO templateDTO = templateMapper.queryTemplateByUuid(uuid);
		templateDTO.setDisplayName(requestData.getTemplateDisplayName());
		templateDTO.setDescription(requestData.getTemplateDescription());
		templateDTO.setInstanceCount(requestData.getInstances().size());
		templateDTO.setUpdatedTime(new Date());
		templateDTO.setObjects(JsonUtils.objectToJson(requestData.getInstances()));
		if(requestData.getParameters()!=null) {
			templateDTO.setParameters(JsonUtils.objectToJson(requestData.getParameters()));
		}
		templateDTO.setApiVersion(Constants.APIVERSION);
		templateDTO.setMetadata(JsonUtils.objectToJson(metaDataDO));
		
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
		
		//查询原有instance
		List<AppInstanceDTO> instanceDTOList = instanceMapper.queryByTemplateId(uuid);
		
		for(AppInstanceDO instanceDO : requestData.getInstances()) {
			
			for(AppInstanceDetailDO insDetailDO : instanceDO.getObjects()) {
				
				String instanceStr = JsonUtils.objectToJson(insDetailDO);
				if(requestData.getParameters()!=null) {
					for(Map<String, String> map : requestData.getParameters()) {
						String originStr = map.get("name");
						String startStr = "${"+originStr+"}";
						instanceStr = instanceStr.replace(startStr, map.get("value"));
					}
				}
				insDetailDO = JsonUtils.jsonToObject(instanceStr, AppInstanceDetailDO.class);
				/*
				 * service,route,deployment都在application创建时插入库中
				 * 这里可以做一些校验
				 */
				invalidationUtils.checkInstance(insDetailDO, project);
			}
			
			/*
			 * 编辑除了编辑原有的instance之外，还可以添加或者删除instance，都需要在instance表里做修改，只需要在instance表里改即可，template详细直接查instance
			 */
			/*
			 * 1.添加了instance
			 */
			boolean exist = false;
			for(AppInstanceDTO instanceDTO : instanceDTOList) {
				if(instanceDO.getInstanceName().equals(instanceDTO.getName())) {
					instanceDTO.setDisplayName(instanceDO.getInstanceDisplayName());
					instanceDTO.setDescription(instanceDO.getInstanceDescription());
					instanceDTO.setUpdatedTime(new Date());
					instanceDTO.setObjects(JsonUtils.objectToJson(instanceDO.getObjects()));
					instanceMapper.updateInstanceById(instanceDTO);
					exist = true;
				}
			}
			if(!exist) {
				AppInstanceDTO instanceDTO_new = new AppInstanceDTO();
				instanceDTO_new.setName(instanceDO.getInstanceName());
				instanceDTO_new.setDisplayName(instanceDO.getInstanceDisplayName());
				instanceDTO_new.setDescription(instanceDO.getInstanceDescription());
				instanceDTO_new.setCreatedTime(new Date());
				instanceDTO_new.setUuid(IdGen.uuid());
				instanceDTO_new.setTemplateId(templateDTO.getUuid());
				if(instanceDO.getObjects()!=null) {
					instanceDTO_new.setObjects(JsonUtils.objectToJson(instanceDO.getObjects()));
				}
				instanceMapper.insertAppInstance(instanceDTO_new);
			}
			
		}
		
		/*
		 * 2.删除了instance，因为会出现既增加又删除的情况，所以添加完以后要重新查一遍
		 */
		//定义查询次数，如果在最后一次之后仍然未在页面上找对对应的instance，表示已删除
		int findTimes = 0;
		List<AppInstanceDTO> instanceDTOList2 = instanceMapper.queryByTemplateId(uuid);
		for(AppInstanceDTO instanceDTO2 : instanceDTOList2) {
			for(AppInstanceDO instanceDO2 : requestData.getInstances()) {
				if(instanceDO2.getInstanceName().equals(instanceDTO2.getName())) {
					findTimes++;
				}else {
					if(findTimes==requestData.getInstances().size()) {
						instanceMapper.deleteAppInstance(instanceDTO2.getUuid());
					}
				}
			}
		}

		if(Constants.REGISTRY_TYPE_PRIVATE.equals(requestData.getType())) {
			Invocation<TemplateDTO> templateList = patch(TemplateDTO.class,
					"/apis/template.openshift.io/v1/namespaces/"+project+"/templates/"
							+ templatePostDetailDO.getMetadata().getName(),
					token).entity(templatePostDetailDO).contentType("application/strategic-merge-patch+json");
			templateList.executeWithResponse();
		}else if(Constants.REGISTRY_TYPE_PLATFORM.equals(requestData.getType())) {
			Invocation<TemplateDTO> templateList = patch(TemplateDTO.class,
					"/apis/template.openshift.io/v1/namespaces/"+Constants.NAMESPACE_OPENSHIFT+"/templates/"
							+ templatePostDetailDO.getMetadata().getName(),
					token).entity(templatePostDetailDO).contentType("application/strategic-merge-patch+json");
			templateList.executeWithResponse();
		}
		
		
		
		templateMapper.updateTemplateById(templateDTO);
		
		log.info("editTemplate end");
	}

	@Override
	public List<TemplateDTO> queryTemplateList(String type) {
		log.info("queryTemplateList begin, type ="+type);
		log.info("queryTemplateList end");
		return templateMapper.queryTemplateList(type);
	}

	@SuppressWarnings("unchecked")
	@Override
	public TemplateDetailDO getTemplateDetail(String uuid) {
		log.info("getTemplateDetail begin, uuid ="+uuid);
		TemplateDetailDO templateDetailDO = new TemplateDetailDO();
		TemplateDTO template = templateMapper.queryTemplateByUuid(uuid);
		templateDetailDO.setInstances(JsonUtils.jsonToObject(template.getObjects(), List.class, AppInstanceDO.class));
		if(template.getParameters()!=null) {
			templateDetailDO.setParameters(JsonUtils.jsonToObject(template.getParameters(), List.class));
		}
		templateDetailDO.setTemplateDescription(template.getDescription());
		templateDetailDO.setTemplateDisplayName(template.getDisplayName());
		templateDetailDO.setTemplateName(template.getName());
		templateDetailDO.setType(template.getType());
		log.info("getTemplateDetail end");
		return templateDetailDO;

	}


	@Override
	public List<TemplateDTO> filterTemplate(List<GetListParamElement> filterList,String regionId, String project) {
		log.info("filterTemplate begin: "+JsonUtils.objectToJson(filterList));
		// TODO Auto-generated method stub
		log.info("==========进入filterApplication");
		ProjectDTO projectDto = projectService.queryProjectByRegionIdAndProjectName(regionId, project);
		TemplateDTOExample example =new TemplateDTOExample();
		Criteria criteria=example.createCriteria();
		criteria.andProjectEqualTo(projectDto.getUuid());
		criteria.andIsMarketEqualTo(0);
		if(filterList != null && !filterList.isEmpty()) {
			for(int i = 0 ; i<filterList.size() ; i++) {
				String key =filterList.get(i).getKey();
				if(key.equals("displayName")) {
					String value=filterList.get(i).getValue();
					criteria.andDisplayNameLike("%"+value+"%");
				}else if(key.equals("instanceCount")) {
					String value=filterList.get(i).getValue();
					String str1=value.substring(0,value.indexOf("~"));
					String str2=value.substring(value.indexOf("~")+1,value.length());
					Integer int1 =StringToInteger.toInteger(str1);
					Integer int2 =StringToInteger.toInteger(str2);
					if(str1.equals("*")&&!str2.equals("*")) {
						criteria.andInstanceCountLessThanOrEqualTo(int2);
					}else if(!str1.equals("*")&&str2.equals("*")) {
						criteria.andInstanceCountGreaterThanOrEqualTo(int1);
					}else if(str1.equals(str2)&&!str2.equals("*")) {
						criteria.andInstanceCountEqualTo(int1);
					}else if(!str1.equals("*")&&!str2.equals("*")) {
						criteria.andInstanceCountGreaterThanOrEqualTo(int1);
						criteria.andInstanceCountLessThanOrEqualTo(int2);
					}
				}else if(key.equals("createdTime")) {
					String value=filterList.get(i).getValue();
					String str1=value.substring(0,value.indexOf("~"));
					String str2=value.substring(value.indexOf("~")+1,value.length());
					log.info(str1+"====="+str2);
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
						Date time1=StringToUTCDate.toDate(str1);
						Date time2=StringToUTCDate.toDate(str2);
						log.info(time1+"==time=="+time2);
						criteria.andCreatedTimeGreaterThanOrEqualTo(time1);
						criteria.andCreatedTimeLessThanOrEqualTo(time2);
					}
				}
			}
		}
		log.info("filterTemplate end");
		return templateMapper.selectByExample(example);
	}


	@Override
	public List<TemplateDTO> filterTemplateAndType(List<GetListParamElement> filterList, String type,String regionId, String project) {
		log.info("filterTemplateAndType begin: type="+type+", filterList:"+JsonUtils.objectToJson(filterList));
		// TODO Auto-generated method stub
		log.info("==========进入filterApplicationAndType");
		ProjectDTO projectDto = projectService.queryProjectByRegionIdAndProjectName(regionId, project);
		ProjectDTO projectDefault = projectService.queryProjectByRegionIdAndProjectName(regionId, Constants.NAMESPACE_OPENSHIFT);
		TemplateDTOExample example =new TemplateDTOExample();
		Criteria criteria=example.createCriteria();
		if(Constants.REGISTRY_TYPE_PRIVATE.equals(type)) {
			criteria.andProjectEqualTo(projectDto.getUuid());
		}else if(Constants.REGISTRY_TYPE_PLATFORM.equals(type)) {
			criteria.andProjectEqualTo(projectDefault.getUuid());
		}
		criteria.andTypeEqualTo(type);
		criteria.andIsMarketEqualTo(0);
		if(filterList != null && !filterList.isEmpty()) {
			for(int i = 0 ; i<filterList.size() ; i++) {
				String key =filterList.get(i).getKey();
				if(key.equals(Constants.FILTER_NAME_DISPLAYNAME)) {
					String value=filterList.get(i).getValue();
					criteria.andDisplayNameLike("%"+value+"%");
				}else if(key.equals(Constants.FILTER_NAME_INSTANCECOUNT)) {
					String value=filterList.get(i).getValue();
					String str1=value.substring(0,value.indexOf("~"));
					String str2=value.substring(value.indexOf("~")+1,value.length());
					Integer int1 =StringToInteger.toInteger(str1);
					Integer int2 =StringToInteger.toInteger(str2);
					if(str1.equals("*")&&!str2.equals("*")) {
						criteria.andInstanceCountLessThanOrEqualTo(int2);
					}else if(!str1.equals("*")&&str2.equals("*")) {
						criteria.andInstanceCountGreaterThanOrEqualTo(int1);
					}else if(str1.equals(str2)&&!str2.equals("*")) {
						criteria.andInstanceCountEqualTo(int1);
					}else if(!str1.equals("*")&&!str2.equals("*")) {
						criteria.andInstanceCountGreaterThanOrEqualTo(int1);
						criteria.andInstanceCountLessThanOrEqualTo(int2);
					}
				}else if(key.equals(Constants.FILTER_NAME_CREATEDTIME)) {
					String value=filterList.get(i).getValue();
					String str1=value.substring(0,value.indexOf("~"));
					String str2=value.substring(value.indexOf("~")+1,value.length());
					log.info(str1+"====="+str2);
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
						Date time1=StringToUTCDate.toDate(str1);
						Date time2=StringToUTCDate.toDate(str2);
						log.info(time1+"==time=="+time2);
						criteria.andCreatedTimeGreaterThanOrEqualTo(time1);
						criteria.andCreatedTimeLessThanOrEqualTo(time2);
					}
				}
			}
		}
		log.info("filterTemplateAndType end");
		return templateMapper.selectByExample(example);
	}
	
	@Override
	public long countTemplate() {
		// TODO Auto-generated method stub
		TemplateDTOExample example =new TemplateDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.getAllCriteria();
		return templateMapper.countByExample(example);
	}
	
	@Override
	public TemplateDetailDO getTemplateDetailByName(String project, String name) {
		TemplateDTO template = templateMapper.queryTemplateByName(project, name);

		TemplateDetailDO templateDetailDO = new TemplateDetailDO();
		List<AppInstanceDO> appInstanceDOList = JsonUtils.jsonToObject(template.getObjects(), List.class,
				AppInstanceDO.class);

		templateDetailDO.setInstances(appInstanceDOList);
		templateDetailDO.setParameters(JsonUtils.jsonToObject(template.getParameters(), List.class, Map.class));
		templateDetailDO.setTemplateDescription(template.getDescription());
		templateDetailDO.setTemplateDisplayName(template.getDisplayName());
		templateDetailDO.setTemplateName(template.getName());
		templateDetailDO.setType(template.getType());
		
		return templateDetailDO;

	}

	@Override
	public void uploadTemplate(TemplateRequest requestData, TokenDO token,String regionId, String project) {

		File file = new File(path+"/"+requestData.getFileName());
		if (!file.isDirectory()) {
			// 获取test.yaml文件中的配置数据，然后转换为obj，
			TemplatePostDetailDO templatePostDetailDO = new TemplatePostDetailDO();
			try {
				templatePostDetailDO = Yaml.loadType(file, TemplatePostDetailDO.class);
			} catch (Exception e) {
				throw new ServiceException("File has Formatting error!");
			}
			
//			Yaml yaml = new Yaml();
//			TemplatePostDetailDO templatePostDetailDO = new TemplatePostDetailDO();
//			Map<String, Object> map = new HashMap<>();
//			try {
//				map = yaml.load(new FileInputStream(file));
//				String mapJson = JsonUtils.objectToJson(map);
//				templatePostDetailDO = JsonUtils.jsonToObject(mapJson, TemplatePostDetailDO.class);
//			} catch (Exception e) {
//				throw new ServiceException("File has Formatting error!");
//			}
			
			List<AppInstanceDO> instances = new ArrayList<>();
			
			int insSize = 0;
			for(AppInstanceDetailDO appInstanceDetailDO : templatePostDetailDO.getObjects()) {
				if(Constants.INSTANCE_DEPLOYMENT.equals(appInstanceDetailDO.getKind())) {
					insSize++;
					List<AppInstanceDetailDO> instanceDetailDOList = new ArrayList<>();
					instanceDetailDOList.add(appInstanceDetailDO);
					
					AppInstanceDO appInstanceDO = new AppInstanceDO();
					appInstanceDO.setInstanceName(appInstanceDetailDO.getMetadata().getName());
					appInstanceDO.setInstanceDisplayName(appInstanceDetailDO.getMetadata().getName());
					appInstanceDO.setObjects(instanceDetailDOList);
					instances.add(appInstanceDO);
					
				}
				
				if(Constants.INSTANCE_SERVICE.equals(appInstanceDetailDO.getKind())) {
					AppInstanceDO appInstance = instances.get(insSize-1);
					List<AppInstanceDetailDO> detail = appInstance.getObjects();
					detail.add(appInstanceDetailDO);
					appInstance.setObjects(detail);
					instances.set(insSize-1, appInstance);
				}
				
				if(Constants.INSTANCE_ROUTE.equals(appInstanceDetailDO.getKind())) {
					AppInstanceDO appInstance = instances.get(insSize-1);
					List<AppInstanceDetailDO> detail = appInstance.getObjects();
					detail.add(appInstanceDetailDO);
					appInstance.setObjects(detail);
					instances.set(insSize-1, appInstance);
				}
				
			}
			
			/*
			 * 遍历，将service放入对应的instanceList中
			 * appInstanceDetailDOFromFile-文件中传过来的object
			 * appInstanceDetailDOOnlyDM -经过遍历出deployment的只含有deployment的object
			 */
//			List<AppInstanceDO> instancesForSerivice = new ArrayList<>();
//			instancesForSerivice.addAll(instances);
//			for (AppInstanceDetailDO appInstanceDetailDOFromFile : templatePostDetailDO.getObjects()) {
//
//				if (Constants.INSTANCE_SERVICE.equals(appInstanceDetailDOFromFile.getKind())) {
//					//i : 需要为哪一个instance重新赋值
//					int i = -1;
//					boolean isOk = false;
//					try {
//						for(AppInstanceDO appInstanceDO : instances) {
//							i++;
//							ListIterator lit = appInstanceDO.getObjects().listIterator();
//							while (lit.hasNext()) {
//								AppInstanceDetailDO appInstanceDetailDOOnlyDM = (AppInstanceDetailDO) lit.next();
//								if (appInstanceDetailDOFromFile.getSpec().getSelector() != null
//										&& appInstanceDetailDOOnlyDM.getSpec().getSelector() != null
//										&& appInstanceDetailDOFromFile.getSpec().getSelector()
//												.equals(appInstanceDetailDOOnlyDM.getSpec().getSelector()
//														.get(Constants.SPEC_SELECTOR_MATCHLABELS))) {
//									List<AppInstanceDetailDO> originInstanceDetailList = appInstanceDO.getObjects();
//									// 将满足条件的service的detail插入准备好的objectlist
//									originInstanceDetailList.add(appInstanceDetailDOFromFile);
//									appInstanceDO.setObjects(originInstanceDetailList);
//									instancesForSerivice.set(i, appInstanceDO);
//									isOk = true;
//								}
//							}
//						}
//					} catch (Exception e) {
//						System.out.println("eee");
//					}
//					
//					if(!isOk) {
//						throw new ServiceException(MessageUtils.getMessage("service.selector.mismatch"));
//					}
//				}
//
//			}
//			
//			instances = instancesForSerivice;
//			
//			/*
//			 * 遍历，将route放入对应的instanceList中
//			 * 
//			 */
//			for (AppInstanceDetailDO appInstanceDetailDOFromFile : templatePostDetailDO.getObjects()) {
//
//				if (Constants.INSTANCE_ROUTE.equals(appInstanceDetailDOFromFile.getKind())) {
//					//i : 需要为哪一个instance重新赋值
//					int i = -1;
//					boolean isOk = false;
//					for (AppInstanceDO appInstanceDO : instances) {
//						i++;
//						for (AppInstanceDetailDO appInstanceDetailDOServiceDM : appInstanceDO.getObjects()) {
//							if(Constants.INSTANCE_SERVICE.equals(appInstanceDetailDOServiceDM.getKind())
//									&&appInstanceDetailDOServiceDM.getMetadata()!=null
//									&&appInstanceDetailDOServiceDM.getMetadata().getName().
//									equals(appInstanceDetailDOFromFile.getSpec().getTo().get(Constants.ROUTE_TO_NAME))) {
//								List<AppInstanceDetailDO> originInstanceDetailList = appInstanceDO.getObjects();
//								//将满足条件的service的detail插入准备好的objectlist
//								originInstanceDetailList.add(appInstanceDetailDOFromFile);
//								appInstanceDO.setObjects(originInstanceDetailList);
//								instances.set(i, appInstanceDO);
//								isOk = true;
//							}
//
//						}
//
//					}
//					if(!isOk) {
//						throw new ServiceException(MessageUtils.getMessage("route.to.name.mismatch"));
//					}
//				}
//
//			}
			
			requestData.setTemplateName(templatePostDetailDO.getMetadata().getName());
			requestData.setInstances(instances);
			requestData.setParameters(templatePostDetailDO.getParameters());
			
			addTemplate(requestData, token,regionId, project);
			
		}else {
			throw new ServiceException("Can't find file, please check path.");
		}

	}

	@Override
	public void exportTemplate(TemplateRequest data, TokenDO token, HttpServletResponse response) {

		String id = data.getUuid();
		TemplateDTO templateDto = templateMapper.queryTemplateByUuid(id);
		List<AppInstanceDTO> instanceList= instanceMapper.queryByTemplateId(id);
		
		List<AppInstanceDetailDO> appInstanceDetailDOList = new ArrayList<>();
		List<AppInstanceDO> instanceDOList = new ArrayList<>();
		
		for(AppInstanceDTO appinstance : instanceList) {
			AppInstanceDO instanceDO = new AppInstanceDO();
			instanceDO.setObjects(JsonUtils.jsonToObject(appinstance.getObjects(), List.class, AppInstanceDetailDO.class));
			instanceDOList.add(instanceDO);
		}
		
		for(AppInstanceDO instanceDO : instanceDOList) {
			appInstanceDetailDOList.addAll(instanceDO.getObjects());
		}
		
		TemplatePostDetailDO templatePostDetailDO = new TemplatePostDetailDO();
		templatePostDetailDO.setApiVersion(templateDto.getApiVersion());
		templatePostDetailDO.setKind(Constants.TEMPLATE_KIND);
		templatePostDetailDO.setMessage(templateDto.getMessage());
		if (templateDto.getLabels() != null) {
			templatePostDetailDO.setLabels(JsonUtils.jsonToObject(templateDto.getLabels(), Map.class));
		}
		if (templateDto.getMetadata() != null) {
			templatePostDetailDO.setMetadata(JsonUtils.jsonToObject(templateDto.getMetadata(), MetaDataDO.class));
		}
		if (templateDto.getObjects() != null) {
			templatePostDetailDO.setObjects(appInstanceDetailDOList);
		}
		if (templateDto.getParameters() != null) {
			templatePostDetailDO
					.setParameters(JsonUtils.jsonToObject(templateDto.getParameters(), List.class, Map.class));
		}

		File dumpFile = new File(System.getProperty("user.dir") + "\\" + templateDto.getDisplayName() + ".yaml");
		try {
			if (!dumpFile.exists()) {
				dumpFile.createNewFile();
			}
			Yaml.dump(templatePostDetailDO, dumpFile, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileDownloadUtil.download(dumpFile, templateDto.getDisplayName() + ".yaml", response, false);

	}
}
