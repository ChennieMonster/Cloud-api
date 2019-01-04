package com.cloud.api.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.ProjectRequest;
import com.cloud.api.entity.response.QuotaResponse;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.RoleService;
import com.cloud.api.util.annotation.TokenParam;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author huang_kefei
 * @date 2018年10月10日 类说明
 */
@Validated
@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private RoleService roleService;

	/*
	 * @GetMapping
	 * 
	 * @ResponseBody public Result projectInfo(Model model) { // TODO try { int
	 * projectLevel=11; List<ProjectDTO> list=projectService.queryProjectByLevel(projectLevel);
	 * model.addAttribute("project", list); logger.info("selectProject"); } catch
	 * (Exception e) { // TODO: handle exception return
	 * ResultGenerator.genFailedResult(); } return
	 * ResultGenerator.genOkResult(model); }
	 */

	@GetMapping("")
	@ResponseBody
	public Result<List<ProjectDTO>> projectList(@RequestBody GuiRequestBody<ProjectRequest> requestBody, @ApiIgnore @TokenParam TokenDO token) {
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_PROJECTS,Constants.ACTION_QUERY);
		List<ProjectDTO> list = projectService.queryAllProject(requestBody.getRegion(), token.getUserName());
		return ResultGenerator.genGetOkResult(list);
	}
	
	@GetMapping("/quotas")
	@ResponseBody
	public Result<QuotaResponse> getQuotas(@RequestBody GuiRequestBody<?> requestBody,@ApiIgnore @TokenParam TokenDO token) {
		QuotaResponse quotaResponse =  projectService.quotas(requestBody.getRegion());
		return ResultGenerator.genGetOkResult(quotaResponse);
	}
	
	/**
	 * 获取project详细
	 * @param token
	 * @return
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public Result<ProjectDTO> projectDetail(@RequestBody GuiRequestBody<ProjectRequest> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_PROJECT,Constants.ACTION_QUERY);
		ProjectDTO project = projectService.queryProjectById(id);
		return ResultGenerator.genGetOkResult(project);
	}
	
	/**
	 * 添加project
	 */
	@PostMapping("")
	@ResponseBody
	public Result<String> addProject(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<ProjectRequest> requestBody) {
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_PROJECTS,Constants.ACTION_ADD);
		projectService.addProject(requestBody.getRegion(), requestBody.getData(), token);
		
		return ResultGenerator.genOkResult();
	}
	
	/**
	 * 删除project
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<?> deleteProject(@RequestBody GuiRequestBody<ProjectRequest> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id){
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_PROJECTS,Constants.ACTION_DELETE);
		projectService.deleteProject(id, token);
		return ResultGenerator.genOkResult();
	}
	
	/**
	 * 编辑模板
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Result<Object> editProject(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<ProjectRequest> requestBody, @PathVariable String id){
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_PROJECTS,Constants.ACTION_MODIFY);
		projectService.updateProject(id, requestBody.getData(), token.getUserName());
		return ResultGenerator.genOkResult();
	}
	
	
	
	
}
