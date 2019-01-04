package com.cloud.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.TagDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.ImageRequestData;
import com.cloud.api.entity.request.TagRequestData;
import com.cloud.api.entity.response.TagResponseData;
import com.cloud.api.service.RoleService;
import com.cloud.api.service.TagService;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.annotation.Operation;
import com.cloud.api.util.annotation.TokenParam;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author huang_kefei
 * @date 2018年9月30日 类说明
 */
@RestController
public class TagController {
//	private final static Logger log = LoggerFactory.getLogger(TagController.class);

	@Resource
	private TagService tagService;
	
	@Resource
	private RoleService roleService;

	/**
	 * 打开页面默认查询全部
	 * 
	 * @param userID
	 * @param model
	 * @return
	 */
	@GetMapping("/images/{imageId}/tags")
	public Result<?> tagIndex(@ApiIgnore @TokenParam TokenDO token,@RequestBody GuiRequestBody<ImageRequestData> requestBody,@PathVariable String imageId) {
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "Tags", "query");
		// 查询用户所拥有权限能操作的tag
		List<TagDTO> tagList = tagService.queryTagList(imageId);
		List<TagResponseData> tagReqList = new ArrayList<TagResponseData>();
		for (TagDTO tagDTO : tagList) {
			TagResponseData responseData = new TagResponseData();
			responseData.setChangelog(tagDTO.getChangelog());
			if(tagDTO.getEnv() != null) {
				responseData.setEnv(JsonUtils.jsonToObject(tagDTO.getEnv(), List.class, Map.class));
			}
			if(tagDTO.getVolume() != null) {
				responseData.setVolume(JsonUtils.jsonToObject(tagDTO.getVolume(), List.class, String.class));
			}
			responseData.setImageId(tagDTO.getImageId());
			responseData.setLayers(tagDTO.getLayers());
			responseData.setName(tagDTO.getName());
			responseData.setSize(tagDTO.getSize());
			responseData.setUuid(tagDTO.getUuid());
			responseData.setCmd(tagDTO.getCmd());
			responseData.setPort(tagDTO.getPort());
			tagReqList.add(responseData);
		}
		return ResultGenerator.genListOkResult(tagList.size(), tagList.size(), tagReqList);
	}

	@GetMapping("/images/{imageId}/tags/{tagId}")
	public Result<TagResponseData> getTagDetail(@ApiIgnore @TokenParam TokenDO token,@RequestBody GuiRequestBody<ImageRequestData> requestBody,@PathVariable String tagId) {
		
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "Tag", "query");
		TagDTO tagDTO = tagService.queryTagDetailById(tagId);
		TagResponseData responseData = new TagResponseData();
		responseData.setChangelog(tagDTO.getChangelog());
		if(tagDTO.getEnv() != null) {
			responseData.setEnv(JsonUtils.jsonToObject(tagDTO.getEnv(), List.class, Map.class));
		}
		if(tagDTO.getVolume() != null) {
			responseData.setVolume(JsonUtils.jsonToObject(tagDTO.getVolume(), List.class, String.class));
		}
		responseData.setImageId(tagDTO.getImageId());
		responseData.setLayers(tagDTO.getLayers());
		responseData.setName(tagDTO.getName());
		responseData.setSize(tagDTO.getSize());
		responseData.setCmd(tagDTO.getCmd());
		responseData.setPort(tagDTO.getPort());
		responseData.setUuid(tagDTO.getUuid());
		return ResultGenerator.genGetOkResult(responseData);
	}

	/**
	 * 添加tag
	 */
	@PostMapping("/images/{imageId}/tags")
	@Operation(action="add tag", resourceType="tag")
	public Result<?> addTag(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<TagRequestData> requestBody, @PathVariable String imageId) {
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "Tags", "upload");
		// 入库
		if (tagService.addTag(token, requestBody.getData(), imageId, requestBody.getProject())) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}

	}

	/**
	 * 删除tag
	 */
	@DeleteMapping("/images/{imageId}/tags")
	@Operation(action="delete tag", resourceType="tag")
	public Result<?> deleteTag(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<TagRequestData> requestBody, @PathVariable String imageId) {
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "Tags", "delete");
		// 从库中删除
		if (tagService.deleteTag(token, requestBody.getData().getIds(), imageId, requestBody.getProject())) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}

	}

	/**
	 * 编辑tag
	 */
	@PutMapping("/images/{imageId}/tags/{tagId}")
	@Operation(action="edit tag", resourceType="tag")
	public Result<?> editTag(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<TagRequestData> requestBody, @PathVariable String tagId) {
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "Tags", "modify");
		// 从库中修改
		if (tagService.editTag(token, requestBody.getData(), tagId)) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}

	}

}
