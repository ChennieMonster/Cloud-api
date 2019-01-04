package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.LayerDTO;

public interface LayerService {
	
	/**
	 * 查询tagId下的所有layer
	 * @param tagId
	 * @return
	 */
	List<LayerDTO> queryLayerListByTagId(String tagId);
	
	/**
	 * 根据registryID删除layer
	 * @param registryId
	 * @return
	 */
	int deleteLayerByRegistryId(String registryId);
}
