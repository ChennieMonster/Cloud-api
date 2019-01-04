/**
 * 
 */
package com.cloud.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.exception.ServiceException;
import com.cloud.api.dto.AppInstanceDTO;
import com.cloud.api.dto.AppMarketVersionDTO;
import com.cloud.api.dto.AppMarketVersionDTOExample;
import com.cloud.api.dto.ApplicationMarketDTO;
import com.cloud.api.dto.ApplicationMarketDTOExample;
import com.cloud.api.dto.ApplicationMarketDTOExample.Criteria;
import com.cloud.api.entity.AppInstanceDO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.ContainersDO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.PodDO;
import com.cloud.api.entity.PodSpecDO;
import com.cloud.api.entity.ResourcesDO;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.TemplateDetailDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.AddMarketRequest;
import com.cloud.api.entity.request.AppFromMarketInfo;
import com.cloud.api.entity.request.ApplicationRequest;
import com.cloud.api.entity.request.DeployAppFromMarketReq;
import com.cloud.api.entity.request.TemplateRequest;
import com.cloud.api.entity.response.EditMarketResponse;
import com.cloud.api.entity.response.OpenAppPageResponse;
import com.cloud.api.mapper.AppInstanceMapper;
import com.cloud.api.mapper.AppMarketVersionMapper;
import com.cloud.api.mapper.ApplicationMarketMapper;
import com.cloud.api.service.ApplicationMarketService;
import com.cloud.api.service.ApplicationService;
import com.cloud.api.service.TemplateService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.ResourceValidUtils;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ApplicationMarketServiceImpl implements ApplicationMarketService {

	@Autowired
	private ApplicationMarketMapper appMarketMapper;
	
	@Autowired
	private AppInstanceMapper instanceMapper;
	
	@Autowired
	private AppMarketVersionMapper versionMapper;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private TemplateService templateService;
	
	@Autowired
	private ResourceValidUtils resourceValidUtils;
	
	@Override
	public List<ApplicationMarketDTO> getApplicationMarkets(List<GetListParamElement> filterList, String project) {
		ApplicationMarketDTOExample example = new ApplicationMarketDTOExample();
		Criteria criteria = example.createCriteria();
		if(filterList != null && !filterList.isEmpty()) {
			for(int i = 0 ; i<filterList.size() ; i++) {
				String key =filterList.get(i).getKey();
				if(key.equals(Constants.FILTER_NAME_DISPLAYNAME)) {
					String value=filterList.get(i).getValue();
					criteria.andDisplayNameLike("%"+value+"%");
				}
			}
		}
		List<ApplicationMarketDTO> appMarketList = appMarketMapper.selectByExample(example);
		return appMarketList;
	}
	
	@Override
	public ApplicationMarketDTO getApplicationMarket(String uuid) {
		ApplicationMarketDTO appMarket = appMarketMapper.selectByPrimaryKey(uuid);
		return appMarket;
	}

	@Override
	public List<OpenAppPageResponse> openAppPage(String uuid) {
		List<OpenAppPageResponse> appPageResList = new ArrayList<>();
		ApplicationMarketDTO appMarket = appMarketMapper.selectByPrimaryKey(uuid);
		//查询出template中instance集合
		List<AppInstanceDTO> instanceList = instanceMapper.queryByTemplateId(appMarket.getTemplateId());
		//遍历instance集合，取出instance中的object，就是一个instance
		for(AppInstanceDTO instance : instanceList) {
			List<AppInstanceDetailDO> appInstanceDetailList = JsonUtils.jsonToObject(instance.getObjects(), List.class, AppInstanceDetailDO.class);
			OpenAppPageResponse appPage = new OpenAppPageResponse();
			for(AppInstanceDetailDO appInstanceDetail : appInstanceDetailList) {
				appPage.setDeploymentName(appInstanceDetail.getMetadata().getName());
				if(Constants.INSTANCE_DEPLOYMENT.equals(appInstanceDetail.getKind())) {
					try {
						appPage.setCpu(resourceValidUtils.cpuUnit(appInstanceDetail.getSpec().getTemplate().getSpec().getContainers().get(0).getResources().getLimits().get("cpu"), Constants.RESOURCE_LIMITS));
						appPage.setMemory(resourceValidUtils.memoryUnit(appInstanceDetail.getSpec().getTemplate().getSpec().getContainers().get(0).getResources().getLimits().get("memory"), Constants.RESOURCE_LIMITS));
					} catch (NullPointerException e) {
						appPage.setCpu(0);
						appPage.setMemory(0);
					}
					appPage.setReplicas(appInstanceDetail.getSpec().getReplicas());
				}else if(Constants.INSTANCE_ROUTE.equals(appInstanceDetail.getKind())) {
					appPage.setHost(appInstanceDetail.getSpec().getHost());
				}
			}
			appPageResList.add(appPage);
		}
		return appPageResList;
	}

	@Override
	public void deployApp(DeployAppFromMarketReq request, TokenDO token,String regionId , String project) {
		ApplicationMarketDTO appMarket = appMarketMapper.selectByPrimaryKey(request.getAppMarketId());
		List<AppInstanceDTO> instanceList = instanceMapper.queryByTemplateId(appMarket.getTemplateId());
		List<AppFromMarketInfo> appFromMarketInfoList = request.getAppFromMarketInfoList();
		List<AppInstanceDetailDO> appInstanceDetailList = new ArrayList<>();
		List<AppInstanceDO> instances = new ArrayList<>();
		
		int instanceNo = -1;
		//将页面上的信息修改到instance中
		for(AppInstanceDTO instance : instanceList) {
			String instanceName = "";
			String instanceDisplayName = "";
			instanceNo++;
			appInstanceDetailList = JsonUtils.jsonToObject(instance.getObjects(), List.class, AppInstanceDetailDO.class);
			int instanceDetailNo = -1;
			for(AppInstanceDetailDO appInstanceDetail : appInstanceDetailList) {
				instanceDetailNo++;
				try {
					if(Constants.INSTANCE_DEPLOYMENT.equals(appInstanceDetail.getKind())) {
						//设置spec
						SpecDO spec = appInstanceDetail.getSpec();
						PodDO pod = spec.getTemplate();
						PodSpecDO podSpec = pod.getSpec();
						ContainersDO containersDO = podSpec.getContainers().get(0);
						ResourcesDO resourceDO = containersDO.getResources();
						Map<String, String> limits = new HashMap<>();
						//前端给的单位固定为Core，转换为m要*1000
						limits.put("cpu", appFromMarketInfoList.get(instanceNo).getCpu()*1000+"m");
						limits.put("memory", appFromMarketInfoList.get(instanceNo).getMemory()+"Mi");
						resourceDO.setLimits(limits);
						containersDO.setResources(resourceDO);
						containersDO.setEnv(appFromMarketInfoList.get(instanceNo).getEnv());
						List<ContainersDO> containers = new ArrayList<ContainersDO>();
						containers.add(containersDO);
						podSpec.setContainers(containers);
						pod.setSpec(podSpec);
						spec.setTemplate(pod);
						spec.setReplicas(appFromMarketInfoList.get(instanceNo).getReplicas());
						appInstanceDetail.setSpec(spec);
						//设置metadata
						MetaDataDO metaData = appInstanceDetail.getMetadata();
						metaData.setName(appFromMarketInfoList.get(instanceNo).getDeploymentName());
						appInstanceDetail.setMetadata(metaData);
						
						appInstanceDetailList.set(instanceDetailNo, appInstanceDetail);
						instanceName = appInstanceDetail.getMetadata().getName();
						instanceDisplayName = appInstanceDetail.getMetadata().getName();
					}else if(Constants.INSTANCE_ROUTE.equals(appInstanceDetail.getKind())) {
						SpecDO spec = appInstanceDetail.getSpec();
						spec.setHost(appFromMarketInfoList.get(instanceNo).getHost());
						appInstanceDetail.setSpec(spec);
						appInstanceDetailList.set(instanceDetailNo, appInstanceDetail);
					}
				} catch (NullPointerException e) {
					throw new ServiceException("Template has some error!");
				}
			}
			
			AppInstanceDO instanceDO = new AppInstanceDO();
			instanceDO.setInstanceName(instanceName);
			instanceDO.setInstanceDisplayName(instanceDisplayName);
			instanceDO.setObjects(appInstanceDetailList);
			instances.add(instanceDO);
		}
		
		//准备application信息
		ApplicationRequest requestData = new ApplicationRequest();
		requestData.setApplicationName(request.getName());
		requestData.setApplicationDisplayName(request.getDisplayName());
		requestData.setApplicationDescription(request.getDescription());
		requestData.setInstances(instances);
		requestData.setIsRegistry(0);
		
		applicationService.addApplication(requestData, token,regionId, project);
		
	}

	@Override
	public void addMarket(AddMarketRequest request, TokenDO token,String regionId, String project) {
		//添加template
		TemplateRequest templateRequest = request.getTemplateRequest();
		templateRequest.setType("market");
		templateRequest.setIsMarket(1); //1-应用市场专用
		String templateUuid = templateService.addTemplate(templateRequest, token,regionId, project);
		//添加market
		ApplicationMarketDTO applicationMarket = new ApplicationMarketDTO();
		applicationMarket.setName(request.getName());
		applicationMarket.setDisplayName(request.getDisplayName());
		applicationMarket.setDescription(request.getDescription());
		applicationMarket.setUuid(IdGen.uuid());
		applicationMarket.setTemplateId(templateUuid);
		applicationMarket.setCreatedTime(new Date());
		applicationMarket.setIntroduce(request.getIntroduce());
		applicationMarket.setVersion(request.getVersion());
		appMarketMapper.insertSelective(applicationMarket);
		
		//添加版本
		AppMarketVersionDTO appMarketVersion = new AppMarketVersionDTO();
		appMarketVersion.setCreatedTime(new Date());
		appMarketVersion.setUuid(IdGen.uuid());
		appMarketVersion.setMarketId(applicationMarket.getUuid());
		appMarketVersion.setVersion(request.getVersion());
		appMarketVersion.setIntroduce(request.getVersionIntroduce());
		versionMapper.insertSelective(appMarketVersion);
		
	}

	@Override
	public void deleteMarket(String uuid, TokenDO token,String regionId, String project) {
		//删除template
		List<String> ids = new ArrayList<>();
		ids.add(uuid);
		templateService.deleteTemplates(token, ids,regionId, project);
		
		//删除market
		appMarketMapper.deleteByPrimaryKey(uuid);
		
		//删除版本
		AppMarketVersionDTOExample example = new AppMarketVersionDTOExample();
		com.cloud.api.dto.AppMarketVersionDTOExample.Criteria criteria = example.createCriteria();
		criteria.andMarketIdEqualTo(uuid);
		versionMapper.deleteByExample(example);
	}

	@Override
	public void updateMarket(AddMarketRequest request, TokenDO token, String project) {
		//更新template
		templateService.editTemplate(token, request.getTemplateRequest(), request.getTemplateId(), project);
		
		ApplicationMarketDTO applicationMarket = appMarketMapper.selectByPrimaryKey(request.getUuid());
		applicationMarket.setName(request.getName());
		applicationMarket.setDisplayName(request.getDisplayName());
		applicationMarket.setDescription(request.getDescription());
		applicationMarket.setUpdatedTime(new Date());
		applicationMarket.setIntroduce(request.getIntroduce());
		//版本号变更则需要在版本表里加一条数据
		if(!request.getVersion().equals(applicationMarket.getVersion())) {
			applicationMarket.setVersion(request.getVersion());
			AppMarketVersionDTO appMarketVersion = new AppMarketVersionDTO();
			appMarketVersion.setCreatedTime(new Date());
			appMarketVersion.setUuid(IdGen.uuid());
			appMarketVersion.setMarketId(applicationMarket.getUuid());
			appMarketVersion.setVersion(request.getVersion());
			appMarketVersion.setIntroduce(request.getVersionIntroduce());
			versionMapper.insertSelective(appMarketVersion);
		}
		
		appMarketMapper.updateByPrimaryKeySelective(applicationMarket);
		
	}

	@Override
	public EditMarketResponse openEditPage(String uuid) {
		EditMarketResponse market = new EditMarketResponse();
		ApplicationMarketDTO applicationMarket = appMarketMapper.selectByPrimaryKey(uuid);
		market.setName(applicationMarket.getName());
		market.setDisplayName(applicationMarket.getDisplayName());
		market.setIntroduce(applicationMarket.getIntroduce());
		market.setDescription(applicationMarket.getDescription());
		market.setVersion(applicationMarket.getVersion());
		
		AppMarketVersionDTOExample example = new AppMarketVersionDTOExample();
		com.cloud.api.dto.AppMarketVersionDTOExample.Criteria criteria = example.createCriteria();
		criteria.andMarketIdEqualTo(uuid);
		criteria.andVersionEqualTo(applicationMarket.getVersion());
		List<AppMarketVersionDTO> versionList = versionMapper.selectByExample(example);
		if(versionList.size()>0) {
			market.setVersionIntroduce(versionList.get(0).getIntroduce());
		}
		
		TemplateDetailDO templateDetailDO = templateService.getTemplateDetail(applicationMarket.getTemplateId());
		market.setTemplate(templateDetailDO);
		market.setTemplateId(applicationMarket.getTemplateId());
		return market;
	}

}
