/**
 * 
 */
package com.cloud.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cloud.api.dto.UserDTO;
import com.cloud.api.dto.UserDTOExample;

/**
 * @author zhao_pengchen
 *
 */
public interface UserMapper {

	List<Map<String, Object>> queryUserList(Map<String, Object> paramMap);
	
	List<Map<String, Object>> queryProjectRoleUser(Map<String, Object> paramMap);

	List<Map<String, Object>> queryUserRoleInfo(Map<String, Object> paramMap);

	List<Map<String, Object>> queryUserProInfo(Map<String, Object> paramMap);
	
	List<Map<String,Object>> userDetailById(String uuid);
	
	Map<String, Object> queryUserByName(String userName);

	int modifyUser(Map<String, Object> paramMap);

	int deleteUserRole(Map<String, Object> paramMap);

	int insertAllUserRole(Map<String, Object> paramMap);
	
	int deleteUserProject(Map<String, Object> paramMap);

	int insertUserProject(Map<String, Object> paramMap);//新增project用户

	int deleteProjectUser(Map<String, Object> paramMap);
	
	int delAllRoleUser(Map<String, Object> paramMap);

	int delAllProUser(Map<String, Object> paramMap);

	int addProjectUser(Map<String, Object> paramMap);
	
	int addProjectRoleUser(Map<String, Object> paramMap);

	int addUserInfo(Map<String, Object> paramMap);
	
	int deleteProjectRoleUser(Map<String, Object> paramMap);

	long countUserProjectRole(Map<String, Object> paramMap);
	
	
	//Mybatis
	
    long countByExample(UserDTOExample example);

    List<UserDTO> selectByExample(UserDTOExample example);

    int deleteByExample(UserDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(UserDTO record);

    int insertSelective(UserDTO record);

    UserDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") UserDTO record, @Param("example") UserDTOExample example);

    int updateByExample(@Param("record") UserDTO record, @Param("example") UserDTOExample example);

    int updateByPrimaryKeySelective(UserDTO record);

    int updateByPrimaryKey(UserDTO record);


	
}
