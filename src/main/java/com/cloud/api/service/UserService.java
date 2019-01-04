package com.cloud.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cloud.api.dto.UserDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.UserProjectRoleRequest;
import com.cloud.api.entity.request.UserRequest;
import com.cloud.api.entity.request.UserSessionRequest;

public interface UserService extends UserDetailsService {

	List<UserDTO> queryUserByName(String userName);
	
	UserDTO findByUserName(String userName); 
	
	UserDTO queryUserById(String Id);
	
	long countUser();
	
	long countUserProjectRole();

	List<Map<String,Object>> queryUserList(TokenDO token, UserRequest requestData);
	
	List<Map<String,Object>> queryProjectRoleUser(TokenDO token, UserProjectRoleRequest requestData);

	Map<String, Object> queryUserInfo(Map<String,Object> map);

	Map<String, Object> userDetailById(String Id);

	int modifyUser(TokenDO token, UserRequest requestData);

	boolean delAllRoleUser(Map<String,Object> map);//删除任一角色下所有用户或删除任一用户所有角色

	boolean deleteProjectUser(TokenDO token, List<String> ids);////同一project下批量删除用户
	
	boolean delAllProUser(Map<String,Object> map);//删除任一project下所有用户或删除任一用户所有project
	
	int addUserInfo(Map<String,Object> map);

	boolean addProjectRoleUser(TokenDO token, UserProjectRoleRequest requestData);

	void updateUserSession(UserSessionRequest request, String userId);
	
	int  editUser(UserDTO user,String userId);

	UserDTO  queryUserDetail(String id);
	
	void insertUser(String userName ,String password);
	
	void updateUserByName(String userName ,String password);
}
