package com.cloud.api.mapper;

import java.util.List;
import java.util.Map;

import com.cloud.api.dto.ResourcesDTO;

public interface ResourcesMapper {
	
	ResourcesDTO selectHostResourcesByRegionId(String regionId);
	
	List<Map<String,Object>> selectProjectAppTotal(Map<String,Object> param);
	
	Integer selectAllAppTotalByRegionId(String regionId);
	
	List<ResourcesDTO> selectProjectResourceByRegionId(Map<String,Object> param);
	
	ResourcesDTO selectProjectResourceDetail(Map<String,Object> param);
	
	Integer selectProjectAppStatus(Map<String,Object> param);
	
	int selectAppCountDailyCreate(String regionId);
	
	Integer selectRegionAppStatus(Map<String,Object> param);
}
