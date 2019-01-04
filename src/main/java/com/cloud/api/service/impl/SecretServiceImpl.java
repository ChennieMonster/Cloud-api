package com.cloud.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.exception.ResourcesNotFoundException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.dto.SecretDTO;
import com.cloud.api.dto.SecretDTOExample;
import com.cloud.api.dto.SecretDTOExample.Criteria;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.SecretDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.SecretRequest;
import com.cloud.api.mapper.SecretMapper;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.SecretService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.SecretUtils;

@Service
public class SecretServiceImpl extends BaseService implements SecretService {

	@Autowired
	private SecretMapper secretMapper;
	
	@Resource
	private ProjectService projectService;
	
	@Override
	public int deleteSecret(TokenDO token,String uuid, String project) {
		// TODO Auto-generated method stub
		//DELETE https://master.example.com:8443/api/v1/namespaces/cloud-api-test/secrets/ssssslll
		
		String secretName = secretMapper.selectByPrimaryKey(uuid).getName();
		
		//删除secret表
		secretMapper.deleteByPrimaryKey(uuid);
//		try {
//			Invocation<SecretDO> invocation = delete(SecretDO.class, "/api/v1/namespaces/" + project + "/secrets/" + secretName, token);
//			invocation.executeWithResponse();
//		} catch (ResourcesNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return 0;
	}

	@Override
	public int createSecret(TokenDO token,String project,String name,String tlsCrt,String tlsKey) {
		System.out.println("====================开始创建secret====================");
		SecretDO secretDO = new SecretDO(name, tlsCrt, tlsKey);
		Invocation<SecretDO> invocation = post(SecretDO.class, "/api/v1/namespaces/" + project + "/secrets", token).entity(secretDO);
		invocation.executeWithResponse();
		return 0;
	}

	@Override
	public int createSecretByUserNameAndPasswd(TokenDO token, String project, String secretName, String userName,
			String password,String url) {
		System.out.println("====================开始创建secret====================");
		ProjectDTO projectDTO = projectService.queryProjectByRegionIdAndProjectName(MDC.get(MDCConstants.REGION_ID),project);
		//入secret表
		SecretDTO secret = new SecretDTO();
		secret.setName(secretName);
		secret.setUuid(IdGen.uuid());
		secret.setPassword(password);
		secret.setUrl(url);
		secret.setUserName(userName);
		secret.setProject(projectDTO.getUuid());
		secret.setType(Constants.SECRET_TYPE_NAMEPW);
		secretMapper.insertSelective(secret);
		
		Map<String,Object> param1 = new HashMap<String,Object>(); 
		Map<String,String> param2 = new HashMap<String,String>();
		param2.put("username", userName);
		param2.put("password", password);
		param2.put("email", "");
		String auth = SecretUtils.getBase64(userName + ":" + password);
		param2.put("auth", auth);
		param1.put(url, param2);
		SecretDO secretDO = new SecretDO(secretName, param1);
		Invocation<SecretDO> invocation = post(SecretDO.class, "/api/v1/namespaces/" + project + "/secrets", token).entity(secretDO);
		invocation.executeWithResponse();
		return 0;
	}
	
	
	public static void main(String[] args) {
		Map<String,Map<String,String>> param1 = new HashMap<String,Map<String,String>>(); 
		Map<String,String> param2 = new HashMap<String,String>();
		param2.put("username", "admin");
		param2.put("password", "asdf1234");
		param2.put("email", "");
		String auth = SecretUtils.getBase64("admin" + ":" + "asdf1234");
		param2.put("auth", auth);
		param1.put("https://192.168.122.217:5000", param2);
	}

	@Override
	public List<SecretDTO> secrets(List<GetListParamElement> filterList,String region, String project) {
		ProjectDTO projectDto = projectService.queryProjectByRegionIdAndProjectName(region, project);
		SecretDTOExample example = new SecretDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andProjectEqualTo(projectDto.getUuid());
		if(filterList != null && !filterList.isEmpty()) {
			for(int i = 0 ; i<filterList.size() ; i++) {
				String key =filterList.get(i).getKey();
				if(key.equals(Constants.PARAM_KEY_NAME)) {
					String value=filterList.get(i).getValue();
					criteria.andNameLike("%"+value+"%");
				}
			}
		}
		List<SecretDTO> secretList = secretMapper.selectByExample(example);
		return secretList;
	}

	@Override
	public SecretDTO secret(String uuid) {
		return secretMapper.selectByPrimaryKey(uuid);
	}

	@Override
	public void updateSecret(SecretRequest request, TokenDO token, String uuid, String project) {
		SecretDTO secret = secretMapper.selectByPrimaryKey(uuid);
		secret.setName(request.getSecretName());
		secret.setPassword(request.getPassword());
		secret.setUrl(request.getUrl());
		secret.setUserName(request.getUserName());
		secretMapper.updateByPrimaryKeySelective(secret);
		
		Map<String,Object> param1 = new HashMap<String,Object>(); 
		Map<String,String> param2 = new HashMap<String,String>();
		param2.put("username", request.getUserName());
		param2.put("password", request.getPassword());
		param2.put("email", "");
		String auth = SecretUtils.getBase64(request.getUserName() + ":" + request.getPassword());
		param2.put("auth", auth);
		param1.put(request.getUrl(), param2);
		SecretDO secretDO = new SecretDO(param1);
		Invocation<SecretDO> invocation = patch(SecretDO.class, "/api/v1/namespaces/" + project + "/secrets"+request.getSecretName(), token).entity(secretDO);
		invocation.executeWithResponse();
	}

}
