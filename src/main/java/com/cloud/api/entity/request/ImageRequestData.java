package com.cloud.api.entity.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cloud.api.entity.GetListParamElement;

public class ImageRequestData {
	
	@NotEmpty(message = "{image.name.is.not.null}")
	@Size(max = 32, message = "{image.name.length}")
	@Pattern(regexp="[a-z]([a-z0-9]*[a-z0-9])?", message="{image.name.invalid}")
	private String imageName;
	
	@NotEmpty(message = "{image.displayName.is.not.null}")
	@Size(max = 64, message = "{image.displayName.length}")
	private String imageDisplayName;
	
	@Size(max = 256, message = "{image.description.length}")
	private String imageDescription;

	private String imageIcon;
	
	private String imageType;
	
	private List<String> ids;
	
	private List<GetListParamElement> sort;
	
	private List<GetListParamElement> filter;
	
	private Integer currentPage;
	
	private Integer pageSize;
	
	
	public List<GetListParamElement> getSort() {
		return sort;
	}

	public void setSort(List<GetListParamElement> sort) {
		this.sort = sort;
	}

	public List<GetListParamElement> getFilter() {
		return filter;
	}

	public void setFilter(List<GetListParamElement> filter) {
		this.filter = filter;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageDisplayName() {
		return imageDisplayName;
	}

	public void setImageDisplayName(String imageDisplayName) {
		this.imageDisplayName = imageDisplayName;
	}

	public String getImageDescription() {
		return imageDescription;
	}

	public void setImageDescription(String imageDescription) {
		this.imageDescription = imageDescription;
	}

	public String getImageIcon() {
		return imageIcon;
	}

	public void setImageIcon(String imageIcon) {
		this.imageIcon = imageIcon;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

}
