/**
 * 
 */
package com.cloud.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.CicdProcessInfoDTO;
import com.cloud.api.dto.CicdProjectDTO;
import com.cloud.api.dto.CicdStageInfoDTOWithBLOBs;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.CicdProjectRequest;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.service.CicdProjectService;
import com.cloud.api.util.annotation.TokenParam;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zhao_pengchen
 *
 */
@Controller
@RequestMapping("/cicdProjects")
public class CicdProjectController {

	@Autowired
	private CicdProjectService cicdProjectService;
	
	/**
	 * 添加cicdProject
	 */
	@PostMapping
	@ResponseBody
	public Result<?> addCicdProject(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<CicdProjectRequest> requestBody) {
		cicdProjectService.addCicdProject(requestBody.getData(), token.getUserName());
		return ResultGenerator.genOkResult();
		
	}
	
	/**
	 * cicdProject一览
	 */
	@GetMapping
	@ResponseBody
	public Result<List<CicdProjectDTO>> cicdProjectList(@ApiIgnore @TokenParam TokenDO token){
		List<CicdProjectDTO> cicdProjectList = cicdProjectService.cicdProjectList();
		return ResultGenerator.genGetOkResult(cicdProjectList);
	}
	
	/**
	 * cicdProject详细/cicd_process_info一览
	 */
	@GetMapping("/{cicdProjectId}")
	@ResponseBody
	public Result<List<CicdProcessInfoDTO>> cicdProcessInfoList(@ApiIgnore @TokenParam TokenDO token, @PathVariable String cicdProjectId){
		List<CicdProcessInfoDTO> cicdProcessInfoList = cicdProjectService.cicdProcessInfoList(cicdProjectId);
		return ResultGenerator.genGetOkResult(cicdProcessInfoList);
	}
	
	/**
	 * cicd_process_info详细/cicd_stage_info一览
	 */
	@GetMapping("/{cicdProjectId}/stageInfo/{processId}")
	@ResponseBody
	public Result<List<CicdStageInfoDTOWithBLOBs>> cicdStageInfoList(@ApiIgnore @TokenParam TokenDO token, @PathVariable String processId){
		List<CicdStageInfoDTOWithBLOBs> cicdStageInfoList = cicdProjectService.cicdStageInfoList(processId);
		return ResultGenerator.genGetOkResult(cicdStageInfoList);
	}
	
	
}
