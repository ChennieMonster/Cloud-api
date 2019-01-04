package com.cloud.api.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloud.api.dto.ApplicationDTO;
import com.cloud.api.dto.ResourcesDTO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.ContainerDO;
import com.cloud.api.entity.ContainersDO;
import com.cloud.api.entity.response.ProjectResourceResponse;
import com.cloud.api.entity.response.RegionResourceResponse;
import com.cloud.api.mapper.ApplicationMapper;
import com.cloud.api.mapper.ResourcesMapper;
import com.cloud.api.service.ResourcesService;
import com.cloud.api.util.JsonUtils;

@Service
public class ResourcesServiceImpl implements ResourcesService {
	
	@Resource
	private ResourcesMapper resourcesMapper;
	
	@Resource
	private ApplicationMapper applicationMapper;
	
	private String statusArr[] = {"Running","Pending","Warning","Error"};
	
	@Override
	public RegionResourceResponse queryResourceByRegion(String regionId) {
		ResourcesDTO hostResourcesDTO = resourcesMapper.selectHostResourcesByRegionId(regionId);
		if(hostResourcesDTO == null) {
			hostResourcesDTO = new ResourcesDTO();
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("regionId", regionId);
		param.put("limit", 5);
		List<Map<String, Object>> appTotalList = resourcesMapper.selectProjectAppTotal(param);
		if(appTotalList == null || appTotalList.size() == 0) {
			appTotalList = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("appTotal", 0);
			map.put("name", null);
			map.put("displayName", null);
			map.put("description", null);
			appTotalList.add(map);
		}
		
		int count = resourcesMapper.selectAllAppTotalByRegionId(regionId);
		int dailyCreate = resourcesMapper.selectAppCountDailyCreate(regionId);
		Map<String,Object> appInfo = new HashMap<String,Object>();
		appInfo.put("total", count);
		appInfo.put("dailyCreate", dailyCreate);
		
		for (String status : this.statusArr) {
			param.put("status", status);
			int appCount = resourcesMapper.selectRegionAppStatus(param);
			appInfo.put(status, appCount);
		}
		
		List<ResourcesDTO> projectResourcesList = resourcesMapper.selectProjectResourceByRegionId(param);
		if(projectResourcesList == null || projectResourcesList.size() == 0) {
			projectResourcesList = new ArrayList<ResourcesDTO>();
			ResourcesDTO dto = new ResourcesDTO();
			dto.setPodTotal(0);
			dto.setPodUsage(0);
			projectResourcesList.add(dto);
		}
		RegionResourceResponse regionResourceResponse = new RegionResourceResponse(hostResourcesDTO, projectResourcesList, appTotalList, appInfo);
		return regionResourceResponse;
	}

	@Override
	public ProjectResourceResponse queryResourceByProject(String regionId, String project) {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("regionId", regionId);
		param.put("project", project);
		ResourcesDTO projectResourcesDetail = resourcesMapper.selectProjectResourceDetail(param);
		if(projectResourcesDetail == null) {
			projectResourcesDetail = new ResourcesDTO();
			projectResourcesDetail.setPodTotal(0);
			projectResourcesDetail.setPodUsage(0);
		}
		List<Map<String,Object>> projectAppStatusList = new ArrayList<Map<String,Object>>();
		int appTotal = 0;
		for (String status : this.statusArr) {
			Map<String,Object> statusMap = new HashMap<String,Object>();
			param.put("status", status);
			int appCount = resourcesMapper.selectProjectAppStatus(param);
			statusMap.put("status", status);
			statusMap.put("count", appCount);
			appTotal += appCount;
			projectAppStatusList.add(statusMap);
		}
		
		List<ResourcesDTO> appResourcesList = queryAppResource(regionId, project);
		List<Map<String,Object>> appResources = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < appResourcesList.size(); i++) {
			if(i >= 5) {
				break;
			}
			ResourcesDTO resourcesDTO = appResourcesList.get(i);
			Map<String,Object> resourceMap = new HashMap<String,Object>();
			resourceMap.put("cpu", resourcesDTO.getCpuTotal());
			resourceMap.put("memory", resourcesDTO.getMemoryTotal());
			resourceMap.put("pod", resourcesDTO.getPodTotal());
			resourceMap.put("name", resourcesDTO.getName());
			resourceMap.put("displayName", resourcesDTO.getName());
			resourceMap.put("description", resourcesDTO.getDescription());
			appResources.add(resourceMap);
		}
		if(appResources.size() == 0) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("cpu", 0);
			map.put("memory", 0);
			map.put("pod", 0);
			map.put("name", null);
			map.put("displayName", null);
			map.put("description", null);
			appResources.add(map);
		}
		ProjectResourceResponse response = new ProjectResourceResponse(projectResourcesDetail, projectAppStatusList, appResources);
		return response;
	}
	
	private List<ResourcesDTO> queryAppResource(String regionId, String project) {
		List<ApplicationDTO> applicationLists = applicationMapper.selectAppResourceByProject(project);
		List<ResourcesDTO> appResourcesList = new ArrayList<ResourcesDTO>();
		for (ApplicationDTO applicationDTO : applicationLists) {
			List<String> objList = applicationDTO.getObjectList();
			float cpu = 0;
			long memory = 0;
			int pod = 0;
			for (String objects : objList) {
				try {
					List<AppInstanceDetailDO> instanceList = JsonUtils.jsonToObject(objects, List.class, AppInstanceDetailDO.class);
					for (AppInstanceDetailDO instance : instanceList) {
						if ("Deployment".equals(instance.getKind())) {
							List<ContainersDO> conList = instance.getSpec().getTemplate().getSpec().getContainers();
							for (ContainersDO con : conList) {
								Map<String, String> limitMap = con.getResources().getLimits();
								String cpuStr = limitMap.get("cpu");
								String memoryStr = limitMap.get("memory");
								
								if (cpuStr.contains("m")) {
									cpu += Float.parseFloat(cpuStr.replace("m", "")) / 1000;
								} else {
									cpu += Float.parseFloat(cpuStr);
								}
								memory += Float.parseFloat(memoryStr.replace("Mi", ""));
								pod += instance.getSpec().getReplicas();
							}
						}
					}
				} catch (Exception e) {
					//log
					e.printStackTrace();
				}
			}
			ResourcesDTO appResource = new ResourcesDTO();
			appResource.setCpuTotal(cpu);
			appResource.setMemoryTotal(memory);
			appResource.setPodTotal(pod);
			appResource.setName(applicationDTO.getName());
			appResource.setDisplayName(applicationDTO.getDisplayName());
			appResource.setDescription(applicationDTO.getDescription());
			appResourcesList.add(appResource);
		}
		Collections.sort(appResourcesList);
		
		return appResourcesList;
	}
}
