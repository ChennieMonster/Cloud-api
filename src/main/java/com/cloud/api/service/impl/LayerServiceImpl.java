package com.cloud.api.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloud.api.dto.LayerDTO;
import com.cloud.api.dto.LayerDTOExample;
import com.cloud.api.dto.LayerDTOExample.Criteria;
import com.cloud.api.mapper.LayerMapper;
import com.cloud.api.service.LayerService;

@Service
public class LayerServiceImpl implements LayerService {
	
	@Resource
	private LayerMapper layerMapper;
	
	@Override
	public List<LayerDTO> queryLayerListByTagId(String tagId) {
		LayerDTOExample example = new LayerDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andTagIdEqualTo(tagId);
		return layerMapper.selectByExample(example);
	}
	
	@Override
	public int deleteLayerByRegistryId(String registryId) {
		
		return layerMapper.deleteLayerByRegistryId(registryId);
	}
}
