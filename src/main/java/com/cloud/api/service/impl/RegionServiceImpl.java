package com.cloud.api.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.dto.RegionDTO;
import com.cloud.api.dto.RegionDTOExample;
import com.cloud.api.dto.RegionDTOExample.Criteria;
import com.cloud.api.mapper.RegionMapper;
import com.cloud.api.service.RegionService;

/**
* @author huang_kefei
* @date 2018年10月9日
* 类说明
*/
@Service
@Transactional(rollbackFor = Exception.class)
public class RegionServiceImpl implements RegionService {
	
	private final static Logger logger = LoggerFactory.getLogger(RegionServiceImpl.class);
	
	@Autowired
	private RegionMapper regionMapper;

	@Override
	public int addRegion(RegionDTO regionDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRegion(String regionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RegionDTO queryRegionById(String regionId) {
		// TODO Auto-generated method stub
		return regionMapper.selectByPrimaryKey(regionId);
	}

	@Override
	public int updateRegion(RegionDTO regionDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RegionDTO> queryAllRegion() {
		// TODO Auto-generated method stub
		System.out.println("Mdc:"+MDC.get(MDCConstants.REGION_ID));
		RegionDTOExample example =new RegionDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.getAllCriteria();
		return regionMapper.selectByExample(example);
	}

	@Override
	public String queryOpenshiftUrl(String id) {
		// TODO Auto-generated method stub
		RegionDTO region =regionMapper.selectByPrimaryKey(id);
		String url="";
		if(region!=null) {
			url=region.getOpenshiftUrl();
		}else {
			logger.error("regionId can not found url!");
		}
		return url;
	}

}
