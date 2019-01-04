package com.cloud.api.service;

import com.cloud.api.entity.response.ProjectResourceResponse;
import com.cloud.api.entity.response.RegionResourceResponse;

public interface ResourcesService {
	
	RegionResourceResponse queryResourceByRegion(String regionId);
	
	ProjectResourceResponse queryResourceByProject(String regionId,String project);
}
