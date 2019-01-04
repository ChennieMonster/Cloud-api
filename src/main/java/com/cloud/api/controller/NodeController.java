/**
 * 
 */
package com.cloud.api.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.NodeDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.LabelRequest;
import com.cloud.api.entity.response.NodeResponse;
import com.cloud.api.service.NodeService;
import com.cloud.api.util.annotation.TokenParam;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zhao_pengchen
 *
 */
@Validated
@Controller
@RequestMapping("/nodes")
public class NodeController {

	@Autowired
	private NodeService nodeService;
	
	/**
	 * 获取node一览
	 * @param token
	 * @return
	 */
	@GetMapping("")
	@ResponseBody
	public Result<List<NodeDTO>> nodeList(@RequestBody GuiRequestBody<?> requestBody, @ApiIgnore @TokenParam TokenDO token) {
		List<NodeDTO> nodeList = nodeService.getNodeList(requestBody.getRegion());
		return ResultGenerator.genGetOkResult(nodeList);
	}
	
	/**
	 * 获取node详细
	 * @param token
	 * @return
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public Result<NodeResponse> nodeDetail(@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		NodeResponse nodeRes = nodeService.getNodeDetail(id);
		return ResultGenerator.genGetOkResult(nodeRes);
	}
	
	/**
	 * 修改node-label
	 * @param token
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result<?> updateLabels(@Valid @RequestBody GuiRequestBody<LabelRequest> requestBody, @ApiIgnore @TokenParam TokenDO token) {
		nodeService.updateLabels(requestBody.getData(), token);
		return ResultGenerator.genOkResult();
	}
	
}
