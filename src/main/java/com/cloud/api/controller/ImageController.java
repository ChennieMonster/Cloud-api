
/**
 * 
 */
package com.cloud.api.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.ImageDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.ImageRequestData;
import com.cloud.api.service.ImageService;
import com.cloud.api.service.RoleService;
import com.cloud.api.util.CamelToUnderline;
import com.cloud.api.util.annotation.Operation;
import com.cloud.api.util.annotation.TokenParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zhao_pengchen
 *
 */
@RestController
public class ImageController {

	private final static Logger log = LoggerFactory.getLogger(ImageController.class);

	@Resource
	private ImageService imageService;
	
	@Resource
	private RoleService roleService;
	
	@GetMapping("registries/{registryId}/images")
	public Result<?> getImageList(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<ImageRequestData> requestBody, @PathVariable String registryId) {
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "Images", "query");
		
		long allCount;
		long filterCount;
		List<ImageDTO> pageList = null;
		String sortStr = "";
		try {
//		allCount
			allCount = imageService.countImage();
//		Sort
			ImageRequestData dataDO = requestBody.getData();
			List<GetListParamElement> filterList = dataDO.getFilter();
			List<GetListParamElement> sortList = dataDO.getSort();
			if (sortList != null && !sortList.isEmpty()) {
				for (int i = 0; i < sortList.size(); i++) {
					sortStr += CamelToUnderline.camelToUnderline(sortList.get(i).getKey()) + " "
							+ sortList.get(i).getValue() + ",";
				}
				sortStr = sortStr.substring(0, sortStr.length() - 1);
				PageHelper.startPage(dataDO.getCurrentPage(), dataDO.getPageSize(), sortStr);
			} else {
				PageHelper.startPage(dataDO.getCurrentPage(), dataDO.getPageSize());
			}
//		Filter-----Display Name
			List<ImageDTO> imageList = imageService.filterImage(filterList, registryId);
			log.info("size:" + imageList.size());
//		Page
			PageInfo<ImageDTO> page = new PageInfo<ImageDTO>(imageList);
			filterCount = page.getTotal();
			pageList = page.getList();
			return ResultGenerator.genListOkResult(allCount, filterCount, pageList);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.toString());
			return ResultGenerator.genFailedResult();
		}
	}

	@GetMapping("registries/{registryId}/images/{imageId}")
	public Result<ImageDTO> getImageDetail(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<ImageRequestData> requestBody,@PathVariable String imageId) {
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "Image", "query");
		ImageDTO image = imageService.queryImageById(imageId);
		return ResultGenerator.genGetOkResult(image);
	}

	/**
	 * 添加Image
	 */
	@PostMapping("registries/{registryId}/images")
	@Operation(action="add image", resourceType="image")
	public Result<?> addImage(@ApiIgnore @TokenParam TokenDO token, @Valid @RequestBody GuiRequestBody<ImageRequestData> requestBody,
			@PathVariable String registryId) {
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "Images", "add");
		// 入库
		ImageDTO image = imageService.addImage(requestBody.getData(), registryId, requestBody.getProject(),requestBody.getRegion());
		if (image != null) {
			return ResultGenerator.genGetOkResult(image);
		} else {
			return ResultGenerator.genFailedResult();
		}

	}

	/**
	 * 删除Image
	 */
	@DeleteMapping("registries/{registryId}/images")
	@Operation(action="delete image", resourceType="image")
	public Result<?> deleteImage(@ApiIgnore @TokenParam TokenDO token,@RequestBody GuiRequestBody<ImageRequestData> requestBody) {
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "Images", "delete");
		// 从库中删除
		if (imageService.deleteImage(requestBody.getData().getIds())) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}

	}

	/**
	 * 编辑Image
	 */
	@PutMapping("registries/{registryId}/images/{imageId}")
	@Operation(action="edit image", resourceType="image")
	public Result<?> editImage(@ApiIgnore @TokenParam TokenDO token,@Valid @RequestBody GuiRequestBody<ImageRequestData> requestBody,
			@PathVariable String imageId) {
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "Images", "modify");
		// 从库中修改
		if (imageService.editImage(requestBody.getData(), imageId)) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}

	}

}
