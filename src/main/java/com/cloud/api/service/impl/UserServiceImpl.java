package com.cloud.api.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.controller.UserController;
import com.cloud.api.core.constant.Constants;
import com.cloud.api.dto.UserDTO;
import com.cloud.api.dto.UserDTOExample;
import com.cloud.api.dto.UserDTOExample.Criteria;
import com.cloud.api.dto.UserRoleProDTO;
import com.cloud.api.dto.UserSessionDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.UserProjectRoleRequest;
import com.cloud.api.entity.request.UserRequest;
import com.cloud.api.entity.request.UserSessionRequest;
import com.cloud.api.mapper.UserMapper;
import com.cloud.api.mapper.UserRoleProMapper;
import com.cloud.api.mapper.UserSessionMapper;
import com.cloud.api.service.UserService;
import com.cloud.api.util.CamelToUnderline;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;
import com.github.pagehelper.PageHelper;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserSessionMapper userSessionMapper;
	
	@Autowired
	private UserRoleProMapper userRoleProMapper ;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Override
	public List<UserDTO> queryUserByName(String userName) {
		// TODO Auto-generated method stub
		UserDTOExample example = new UserDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		return userMapper.selectByExample(example);
	}

	@Override
	public UserDetails loadUserByUsername(String paramString)
			throws UsernameNotFoundException {
		return null;
	}

	@Override
	public UserDTO findByUserName(String userName) {
		UserDTO user = new UserDTO();
		try {
			UserDTOExample example = new UserDTOExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserNameEqualTo(userName);
			List<UserDTO> userlist = userMapper.selectByExample(example);
			if(userlist!=null&&!userlist.isEmpty()) {
				user = userlist.get(0);
			}else {
				logger.warn("Query data is empty.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public UserDTO queryUserById(String Id) {
		UserDTO user = new UserDTO();
		UserDTOExample example =new UserDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.andUuidEqualTo(Id);
		List<UserDTO> userlist = userMapper.selectByExample(example);
		if(userlist.size()>0) {
			user = userlist.get(0);
		}else {
			logger.warn("Query data is empty.");
		}
		return user;
	}
	
	@Override
	public long countUser() {
		UserDTOExample example =new UserDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.getAllCriteria();
		return userMapper.countByExample(example);
	}
	
	@Override
	public long countUserProjectRole() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return userMapper.countUserProjectRole(paramMap);
	}
	
	@Override
	public List<Map<String, Object>> queryUserList(TokenDO token,UserRequest user) {

		String sortStr = "";
		List<GetListParamElement> filterList = user.getFilter();
		List<GetListParamElement> sortList = user.getSort();
		if (sortList != null && !sortList.isEmpty()) {
			for (int i = 0; i < sortList.size(); i++) {
				sortStr += CamelToUnderline.camelToUnderline(sortList.get(i)
						.getKey()) + " " + sortList.get(i).getValue() + ",";
			}
			sortStr = sortStr.substring(0, sortStr.length() - 1);
			PageHelper.startPage(user.getCurrentPage(), user.getPageSize(),sortStr);
		} else {
			PageHelper.startPage(user.getCurrentPage(), user.getPageSize());
		}
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(filterList != null && !filterList.isEmpty()) {
			for (GetListParamElement element : filterList) {
				String key =element.getKey();
				switch (key) {
				case "user_name":
					paramMap.put("userName", element.getValue());
					break;
				case "emp_id":
					paramMap.put("empId", element.getValue());
					break;
				case "dept":
					paramMap.put("dept", element.getValue());
					break;
				default:
					break;
				}
			}
		}
		List<Map<String,Object>> userList = userMapper.queryUserList(paramMap);
		return userList;
	}
	
	@Override
	public List<Map<String, Object>> queryProjectRoleUser(TokenDO token,UserProjectRoleRequest user) {

		String sortStr = "";
		List<GetListParamElement> filterList = user.getFilter();
		List<GetListParamElement> sortList = user.getSort();
		if (sortList != null && !sortList.isEmpty()) {
			for (int i = 0; i < sortList.size(); i++) {
				sortStr += CamelToUnderline.camelToUnderline(sortList.get(i)
						.getKey()) + " " + sortList.get(i).getValue() + ",";
			}
			sortStr = sortStr.substring(0, sortStr.length() - 1);
			PageHelper.startPage(user.getCurrentPage(), user.getPageSize(),sortStr);
		} else {
			PageHelper.startPage(user.getCurrentPage(), user.getPageSize());
		}
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(filterList != null && !filterList.isEmpty()) {
			for (GetListParamElement element : filterList) {
				String key =element.getKey();
				switch (key) {
				case "pro_id":
					paramMap.put("projectId", element.getValue());
					break;
				case "user_name":
					paramMap.put("userName", element.getValue());
					break;
				case "role_id":
					paramMap.put("roleId", element.getValue());
					break;
				case "user_id":
					paramMap.put("userId", element.getValue());
					break;
				default:
					break;
				}
			}
		}
		paramMap.put("rstatus", "0");
		List<Map<String,Object>> userList = userMapper.queryProjectRoleUser(paramMap);
		return userList;
	}

	@Override
	public Map<String, Object> userDetailById(String userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> userMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("rstatus", "0");
		List<Map<String,Object>> userList = userMapper.queryUserList(paramMap);
		if(userList.size()>0){
			userMap=userList.get(0);
		}
		return userMap;
	}
	
	@Override
	public int modifyUser(TokenDO token, UserRequest requestData) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String userId = requestData.getUuid();//待修改用户
		paramMap.put("userId", userId);
		logger.info("modifyUser, uuid="+userId);
		paramMap.put("displayName", requestData.getDisplayName());
		paramMap.put("telephone", requestData.getTelephone());
		paramMap.put("mail", requestData.getMail());
		paramMap.put("dept", requestData.getDept());
		paramMap.put("empId", requestData.getEmpId());

		int returnNum = userMapper.modifyUser(paramMap);
		return returnNum;
	}
	
	public int modifyUserProject(Map<String, Object> paramMap){
//		paramMap.put("projectId", paramMap.get("projectId"));
//		paramMap.put("userId", paramMap.get("userId"));
//		paramMap.put("creater", paramMap.get("creater"));
//		paramMap.put("projectName", paramMap.get("projectName"));
		userMapper.deleteUserProject(paramMap);
		int returnNum = userMapper.insertUserProject(paramMap);
		return returnNum;
	}
	
	@Override
	public boolean deleteProjectUser(TokenDO token, List<String> uuids) {
		logger.info("delete project user, ids="+JsonUtils.objectToJson(uuids));
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String records = getRecordStr(uuids);
//		String[] ids = new String[uuids.size()];
//		uuids.toArray(ids);
		paramMap.put("uuid", records);
		int i = userMapper.deleteProjectRoleUser(paramMap);
		if (i != uuids.size()) {
			return false;
		}
		logger.info("deleteProjectUser end");
		return true;
	}
	
	private String getRecordStr(List<String> ids) {
		String roleStr = "'";
		for(int i = 0; i < ids.size(); i++){
			String productId = ids.get(i);
			roleStr += productId+"','";
		}
		if (roleStr.endsWith("','")) {
			roleStr = roleStr.substring(0,roleStr.length()-2);
		}
		return roleStr;
	}
	
	@Override
	public boolean addProjectRoleUser(TokenDO token, UserProjectRoleRequest requestData) {
		String creater = token.getUserName();
		int insertNum=0;
		List<Map<String,Object>> insertList = requestData.getInsertList();
		for (Map<String,Object> proRoleMap : insertList) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("creater", creater);
			paramMap.put("userId", proRoleMap.get("userId"));
			paramMap.put("roleId", proRoleMap.get("roleId"));
			paramMap.put("projectId", proRoleMap.get("projectId"));
			paramMap.put("regionId", proRoleMap.get("regionId"));
			paramMap.put("rstatus", "0");

			userMapper.deleteProjectRoleUser(paramMap);//先删除
			insertNum = userMapper.addProjectRoleUser(paramMap);
			if (insertNum != 1) {
				return false;
			}
		}
		logger.info("addProjectRoleUser end");
		return true;
	}

	@Override
	public Map<String, Object> queryUserInfo(Map<String, Object> paramMap) {
		String userName = paramMap.get("userName").toString();
		Map<String, Object> userMap = userMapper.queryUserByName(userName);
		List<Map<String,Object>> userList = userMapper.queryUserList(paramMap);
		if(userList.size()>0){
			userMap = userList.get(0);
			paramMap.put("rstatus", Constants.DEFAULT_ROLE_STATUS);
			List<Map<String,Object>> roleList = userMapper.queryProjectRoleUser(paramMap);
			String userId =  userMap.get("uuid").toString();
			if(roleList.size()<1){//配置默认角色
				logger.info("addDefaultUserRole, uuid="+userId);
				paramMap.put("userId",userId);
				paramMap.put("creater", userName);
				paramMap.put("roleId", Constants.DEFAULT_ROLE_ID);
				paramMap.put("rstatus", Constants.DEFAULT_ROLE_STATUS);
				userMapper.addProjectRoleUser(paramMap);
			}
			UserSessionDTO userSessionDTO =  userSessionMapper.selectByPrimaryKey(userId);
			if(userSessionDTO!=null){
				userMap.put("region", userSessionDTO.getRegionId());
				userMap.put("project", userSessionDTO.getProjectId());
			}

		}
		return userMap;
	}

	@Override
	public int addUserInfo(Map<String, Object> map) {
		map.put("roleId", Constants.DEFAULT_ROLE_ID);
		map.put("roleName", Constants.DEFAULT_ROLE_NAME);
		map.put("rstatus", Constants.DEFAULT_ROLE_STATUS);
		userMapper.addProjectRoleUser(map);
		return userMapper.addUserInfo(map);
	}

	@Override
	public boolean delAllRoleUser(Map<String, Object> map) {
		int i = userMapper.delAllRoleUser(map);//roleId,roleName,userId
		logger.info("deleteAllRoleUser end,num:" + i);
		return true;
	}

	@Override
	public boolean delAllProUser(Map<String, Object> map) {
		int i = userMapper.delAllProUser(map);//projectId,projectName,userId
		logger.info("deleteAllProUser end,num:" + i);
		return true;
	}

	@Override
	public void updateUserSession(UserSessionRequest request,String userId) {
		UserSessionDTO userSessionDTO1 =  userSessionMapper.selectByPrimaryKey(userId);
		UserSessionDTO userSessionDTO = new UserSessionDTO();
		if(userSessionDTO1==null){
			String uuid = IdGen.uuid();
			userSessionDTO.setUserId(userId);
			userSessionDTO.setRegionId(request.getRegionId());
			userSessionDTO.setProjectId(request.getProjectId());
			userSessionDTO.setCreatedTime(new Date());
			userSessionDTO.setUuid(uuid);
			userSessionMapper.insert(userSessionDTO);
		}else{
			userSessionDTO.setUserId(userId);
			userSessionDTO.setRegionId(request.getRegionId());
			userSessionDTO.setProjectId(request.getProjectId());
			userSessionDTO.setCreatedTime(new Date());
			userSessionMapper.updateByPrimaryKeySelective(userSessionDTO);
		}
	}

	@Override
	public int  editUser(UserDTO user,String userId) {
		// TODO Auto-generated method stub
		UserDTO useredit = new UserDTO();
		useredit.setUuid(userId);
		useredit.setDisplayName(user.getDisplayName());
		useredit.setDept(user.getDept());
		useredit.setEmpId(user.getEmpId());
		useredit.setLanguage(user.getLanguage());
		useredit.setMail(user.getMail());
		useredit.setTelephone(user.getTelephone());
		return userMapper.updateByPrimaryKeySelective(useredit);
	}

	@Override
	public UserDTO queryUserDetail(String id) {
		// TODO Auto-generated method stub
		UserDTO user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	@Override
	public void insertUser(String userName ,String password) {
		// TODO Auto-generated method stub
		UserDTO user  = new UserDTO();
		user.setUuid(IdGen.uuid());
		user.setUserName(userName);
		user.setDisplayName(userName);
		user.setPassword(password);
		user.setCreatedTime(new Date());
		userMapper.insertSelective(user);
		//添加默认权限
		UserRoleProDTO userRole =new UserRoleProDTO();
		userRole.setCreatedTime(user.getCreatedTime());
		userRole.setRoleId("00011122233344455566677788899902");
		userRole.setUserId(user.getUuid());
		userRoleProMapper.insertSelective(userRole);
	}

	@Override
	public void updateUserByName(String userName ,String password) {
		// TODO Auto-generated method stub
		//更新密码
		UserDTOExample example = new UserDTOExample();
		Criteria criteria =example.createCriteria();
		criteria.andUserNameEqualTo(userName);
		UserDTO user = new UserDTO();
		user.setPassword(password);
		userMapper.updateByExampleSelective(user, example);
	}
	

}
