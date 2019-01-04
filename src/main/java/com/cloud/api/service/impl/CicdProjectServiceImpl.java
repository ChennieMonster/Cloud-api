package com.cloud.api.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.dto.CicdProcessInfoDTO;
import com.cloud.api.dto.CicdProcessInfoDTOExample;
import com.cloud.api.dto.CicdProcessInfoDTOExample.Criteria;
import com.cloud.api.dto.CicdProjectDTO;
import com.cloud.api.dto.CicdProjectDTOExample;
import com.cloud.api.dto.CicdStageInfoDTOExample;
import com.cloud.api.dto.CicdStageInfoDTOWithBLOBs;
import com.cloud.api.entity.request.CicdProjectRequest;
import com.cloud.api.mapper.CicdProcessInfoMapper;
import com.cloud.api.mapper.CicdProjectMapper;
import com.cloud.api.mapper.CicdStageInfoMapper;
import com.cloud.api.mapper.UserMapper;
import com.cloud.api.service.CicdProjectService;
import com.cloud.api.util.IdGen;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CicdProjectServiceImpl implements CicdProjectService {

	@Autowired
	private CicdProjectMapper CicdProjectMapper;
	
	@Autowired
	private CicdProcessInfoMapper cicdProcessInfoMapper;
	
	@Autowired
	private CicdStageInfoMapper cicdStageInfoMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void addCicdProject(CicdProjectRequest cicdProjectRequest, String userName) {
		
		CicdProjectDTO cicdProjectDTO = new CicdProjectDTO();
		try {
			BeanUtils.copyProperties(cicdProjectDTO, cicdProjectRequest);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String, Object> idMap = userMapper.queryUserByName(userName);
		String userId = (String) idMap.get("uuid");
		cicdProjectDTO.setCreateTime(new Date());
		cicdProjectDTO.setCreateUserId(userId);
		cicdProjectDTO.setUuid(IdGen.uuid());
		CicdProjectMapper.insertSelective(cicdProjectDTO);
		
	}

	@Override
	public List<CicdProjectDTO> cicdProjectList() {
		CicdProjectDTOExample example = new CicdProjectDTOExample();
		List<CicdProjectDTO> cicdProjectList = CicdProjectMapper.selectByExample(example );
		return cicdProjectList;
	}

	@Override
	public List<CicdProcessInfoDTO> cicdProcessInfoList(String cicdProjectId) {
		CicdProcessInfoDTOExample example = new CicdProcessInfoDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andProjectIdEqualTo(cicdProjectId);
		List<CicdProcessInfoDTO> cicdProcessInfoList = cicdProcessInfoMapper.selectByExample(example);
		return cicdProcessInfoList;
	}

	@Override
	public List<CicdStageInfoDTOWithBLOBs> cicdStageInfoList(String processId) {
		CicdStageInfoDTOExample example = new CicdStageInfoDTOExample();
		com.cloud.api.dto.CicdStageInfoDTOExample.Criteria criteria = example.createCriteria();
		criteria.andProcessIdEqualTo(processId);
		List<CicdStageInfoDTOWithBLOBs> cicdStageInfoList = cicdStageInfoMapper.selectByExampleWithBLOBs(example);
		return cicdStageInfoList;
	}

}
