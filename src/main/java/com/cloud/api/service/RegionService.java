package com.cloud.api.service;

import java.util.List;



import com.cloud.api.dto.RegionDTO;


/**
 * @author huang_kefei
 * @date 2018年10月9日 类说明
 */
public interface RegionService {

	int addRegion(RegionDTO regionDTO);
	
	int deleteRegion(String  regionId);
	
	RegionDTO queryRegionById(String regionId);

	int updateRegion(RegionDTO regionDTO);
	
	List<RegionDTO> queryAllRegion();
	
	String queryOpenshiftUrl(String id);
}
