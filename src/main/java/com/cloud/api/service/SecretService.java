package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.SecretDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.SecretRequest;

public interface SecretService {
	
	int deleteSecret(TokenDO token, String uuid, String project);
	
	int createSecret(TokenDO token,String project,String name,String tlsCrt,String tlsKey);
	
	int createSecretByUserNameAndPasswd(TokenDO token,String project,String secretName,String userName,String password,String url);
	
	List<SecretDTO> secrets(List<GetListParamElement> filterList,String region, String project);
	
	SecretDTO secret(String uuid);
	
	void updateSecret(SecretRequest request, TokenDO token, String uuid, String project);
}
