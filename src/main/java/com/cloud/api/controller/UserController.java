package com.cloud.api.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultCode;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.UserDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.UserProjectRoleRequest;
import com.cloud.api.entity.request.UserRequest;
import com.cloud.api.entity.request.UserSessionRequest;
import com.cloud.api.service.RoleService;
import com.cloud.api.service.UserService;
import com.cloud.api.util.DateUtils;
import com.cloud.api.util.annotation.Operation;
import com.cloud.api.util.annotation.TokenParam;
import com.github.pagehelper.PageInfo;

/**
 * @author huang_kefei
 * @date 2018年10月10日 类说明
 */
@Validated
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	@Resource
	private RoleService roleService;

	// url /api/users/{name} GET /api/user/{name} PUT
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	protected static final ObjectMapper mapper = new ObjectMapper();

//	@GetMapping
//	@ResponseBody
//	public Result<?> userInfo(@RequestParam String id) {
//		try {
//			if (id != null && id != "") {
//				logger.info("queryUserById");
//				UserDTO userDTO = userService.queryUserById(id);
//				UserRequest userVO = new UserRequest();
//				userVO.setUuid(userDTO.getUuid());
//				userVO.setDisplayName(userDTO.getDisplayName());
//				userVO.setName(userDTO.getUserName());
//				userVO.setTelephone(userDTO.getTelephone());
//				userVO.setMail(userDTO.getMail());
//				return ResultGenerator.genGetOkResult(userVO);
//			}
//			return ResultGenerator.genFailedResult(ResultCode.ARGS_NO_VALID);
//		} catch (Exception e) {
//			return ResultGenerator.genFailedResult(ResultCode.SERVICE_EXCEPTION);
//		}
//	}

	@GetMapping("")
	@ResponseBody
	public Result<?> getUserList(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<UserRequest> requestBody) {
		roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(),
				Constants.MODULES_USERS, Constants.ACTION_QUERY);
		long allCount;
		long filterCount;
		try {
			allCount = userService.countUser();
			List<Map<String, Object>> pageList = null;
			List<Map<String, Object>> userList = userService.queryUserList(token, requestBody.getData());
			logger.info("userListTotal:" + allCount);
			PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(userList);
			filterCount = page.getTotal();
			pageList = page.getList();
			for (Map<String, Object> map : pageList) {
				if (map.get("created_time") == null || "".equals(map.get("created_time"))) {
					continue;
				}
				String dateTime = map.get("created_time").toString();
				String formatTime = DateUtils.getGMTTime(dateTime);
				map.put("created_time", formatTime);
			}
			return ResultGenerator.genListOkResult(allCount, filterCount, pageList);
		} catch (Exception e) {
			logger.error(e.toString());
			return ResultGenerator.genFailedResult();
		}
	}

	/**
	 * 查询用户信息ById
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unused")
	@GetMapping("/{id}")
	@ResponseBody
	public Result<?> userDetailById(@ApiIgnore @TokenParam TokenDO token, @RequestBody GuiRequestBody<?> requestBody,
			@PathVariable String id) {
		roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(),
				Constants.MODULES_USERS, Constants.ACTION_QUERY);
		UserDTO user = userService.queryUserDetail(id);
		user.setRstatus(null);
		user.setPassword(null);
		if (user != null) {
			return ResultGenerator.genGetOkResult(user);
		} else {
			return ResultGenerator.genFailedResult();
		}
	}

	/**
	 * 编辑用户
	 * 
	 * @param token
	 * @param requestBody
	 * @param id
	 * @return
	 */
	@PutMapping("{id}")
	@Operation(action = "edit user", resourceType = "user")
	@ResponseBody
	public Result<?> editUser(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<UserDTO> requestBody, @PathVariable String id) {
		roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(),
				Constants.MODULES_USERS, Constants.ACTION_MODIFY);
		int flag = userService.editUser(requestBody.getData(), id);
		if (flag != 0) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}
	}

	/**
	 * 查询用户信息ById
	 * 
	 * @param id
	 * @return
	 */
//	@GetMapping("/{id}")
//	@ResponseBody
//	public Result<?> userDetailById(@ApiIgnore @TokenParam TokenDO token,@RequestBody GuiRequestBody<?> requestBody,
//			@PathVariable String id) {
//			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(),Constants.MODULES_USERS, Constants.ACTION_QUERY);
//				Map<String, Object> userMap = userService.userDetailById(id);
//				if (userMap.get("created_time") != null&& !"".equals(userMap.get("created_time"))) {
//					String dateTime = userMap.get("created_time").toString();
//					String formatTime = DateUtils.getGMTTime(dateTime);
//					userMap.put("created_time", formatTime);
//				return ResultGenerator.genGetOkResult(userMap);
//			}else{
//				return ResultGenerator.genFailedResult(ResultCode.SERVICE_EXCEPTION);
//			}
//	}

	/**
	 * 编辑用户
	 * 
	 * @param token
	 * @param requestBody
	 * @param id
	 * @return
	 */
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	@Operation(action="edit user", resourceType="user")
//	@ResponseBody
//	public Result<?> modifyUser(@ApiIgnore @TokenParam TokenDO token,
//			@RequestBody GuiRequestBody<UserRequest> requestBody) {
//		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(),Constants.MODULES_USERS, Constants.ACTION_MODIFY);
//		try {
//			int returnNum = userService.modifyUser(token, requestBody.getData());
//			if (returnNum == 1) {
//				return ResultGenerator.genOkResult();
//			} else {
//				return ResultGenerator.genFailedResult();
//			}
//		} catch (Exception e) {
//			return ResultGenerator.genFailedResult(ResultCode.SERVICE_EXCEPTION);
//		}
//	}

	/**
	 * 新增project用户
	 */
	@RequestMapping(value = "/project", method = RequestMethod.POST)
	@Operation(action = "add project user", resourceType = "project")

	@ResponseBody
	public Result<?> addProjectRoleUser(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<UserProjectRoleRequest> requestBody) {
		roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(),
				Constants.MODULES_PROJECTUSERS, Constants.ACTION_ADD);

		boolean ifSuccess = userService.addProjectRoleUser(token, requestBody.getData());
		if (ifSuccess) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}
	}

	/**
	 * 批量删除project用户
	 */
	@RequestMapping(value = "/project", method = RequestMethod.DELETE)
	@Operation(action = "delete project user", resourceType = "project")
	@ResponseBody
	public Result<?> deleteProjectUser(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<UserProjectRoleRequest> requestBody) {
		roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(),
				Constants.MODULES_PROJECTUSERS, Constants.ACTION_DELETE);

		List<String> ids = (requestBody.getData()).getIds();

		boolean ifSuccess = userService.deleteProjectUser(token, ids);
		if (ifSuccess) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}
	}

	/**
	 * 查询当前project下用户
	 * 
	 * @param token
	 * @param requestBody
	 * @return
	 */
	@GetMapping("/project")
	@ResponseBody
	public Result<?> getProjectUserList(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<UserProjectRoleRequest> requestBody) {

		roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(),
				Constants.MODULES_PROJECTUSERS, Constants.ACTION_QUERY);

		long allCount;
		long filterCount;
		try {
			allCount = userService.countUserProjectRole();
			List<Map<String, Object>> pageList = null;
			List<Map<String, Object>> userList = userService.queryProjectRoleUser(token, requestBody.getData());
			logger.info("userListTotal:" + allCount);
			PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(userList);
			filterCount = page.getTotal();
			pageList = page.getList();
			for (Map<String, Object> map : pageList) {
				if (map.get("created_time") == null || "".equals(map.get("created_time"))) {
					continue;
				}
				String dateTime = map.get("created_time").toString();
				String formatTime = DateUtils.getGMTTime(dateTime);
				map.put("created_time", formatTime);
			}
			return ResultGenerator.genListOkResult(allCount, filterCount, pageList);
		} catch (Exception e) {
			logger.error(e.toString());
			return ResultGenerator.genFailedResult();
		}
	}

	/**
	 * 更改userSession
	 */
	@RequestMapping(value = "/session/{userId}", method = RequestMethod.PUT)
	@ResponseBody
	public Result<Object> editProject(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<UserSessionRequest> requestBody, @PathVariable String userId) {
		userService.updateUserSession(requestBody.getData(), userId);
		return ResultGenerator.genOkResult();
	}
}
