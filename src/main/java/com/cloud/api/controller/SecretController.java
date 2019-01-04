/**
 * 
 */
package com.cloud.api.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.SecretDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.SecretRequest;
import com.cloud.api.service.SecretService;
import com.cloud.api.util.annotation.Operation;
import com.cloud.api.util.annotation.TokenParam;
import com.github.pagehelper.PageInfo;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zhao_pengchen
 *
 */
@RestController
@RequestMapping("/secrets")
public class SecretController {

	@Resource
	private SecretService secretService;
	
	/**
	 * 添加secret
	 */
	@PostMapping
	@ResponseBody
	@Operation(action="add secret", resourceType="secret")
	public Result<?> addApplication(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<SecretRequest> requestBody) {
		SecretRequest secretRequest = requestBody.getData();
		secretService.createSecretByUserNameAndPasswd(token, requestBody.getProject(), secretRequest.getSecretName(), 
				secretRequest.getUserName(), secretRequest.getPassword(), secretRequest.getUrl());
		return ResultGenerator.genOkResult();
	}
	
	/**
	 * 删除secret
	 */
	@DeleteMapping("/{id}")
	@Operation(action="delete secret", resourceType="secret")
	public Result<?> deleteSecret(@RequestBody GuiRequestBody<?> requestBody,@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		secretService.deleteSecret(token, id, requestBody.getProject());
		return ResultGenerator.genOkResult();
	}

	/**
	 * 查看secret一览
	 */
	@GetMapping
	@ResponseBody
	public Result<List<SecretDTO>> secrets(@RequestBody GuiRequestBody<SecretRequest> requestBody, @ApiIgnore @TokenParam TokenDO token){
		//过滤
		List<GetListParamElement> filterList = requestBody.getData().getFilter();
		List<SecretDTO> secretList = secretService.secrets(filterList,requestBody.getRegion(), requestBody.getProject());
		//分页
		PageInfo<SecretDTO> page = new PageInfo<SecretDTO>(secretList);
		long filterCount = page.getTotal();
		List<SecretDTO> pageList = page.getList();
		return ResultGenerator.genListOkResult(secretList.size(), filterCount, pageList);
	}
	
	/**
	 * 查看secret详细
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public Result<SecretDTO> secret(@RequestBody GuiRequestBody<?> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id){
		SecretDTO secret = secretService.secret(id);
		return ResultGenerator.genGetOkResult(secret);
	}
	
	/**
	 * 修改应用市场应用
	 */
	@PutMapping("/{id}")
	@ResponseBody
	public Result<?> updateSecret(@Valid @RequestBody GuiRequestBody<SecretRequest> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id){
		secretService.updateSecret(requestBody.getData(), token, id, requestBody.getProject());
		return ResultGenerator.genOkResult();
	}
	
}
