/**
 * 
 */
package com.cloud.api.entity.request;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.cloud.api.entity.AppInstanceDO;
import com.cloud.api.entity.GetListParamElement;

/**
 * @author zhao_pengchen
 *
 */
public class TemplateRequest {
	
	@Valid
	private List<AppInstanceDO> instances;
	
	@NotEmpty(message = "{TemplateRequest.templateName.null}")
	@Size(max = 32, message = "{TemplateRequest.templateName.length}")
	@Pattern(regexp="[a-z0-9]([-a-z0-9]*[a-z0-9])?(\\.[a-z0-9]([-a-z0-9]*[a-z0-9])?)*", message="{name.pattern}")
	private String templateName;
	
	@NotEmpty(message = "{TemplateRequest.templateDisplayName.null}")
	@Size(max = 64, message = "{TemplateRequest.templateDisplayName.length}")
	private String templateDisplayName;
	
	@Size(max = 256, message = "{TemplateRequest.templateDescription.length}")
	private String templateDescription;
	
	private String type;
	
	private String uuid;
	
	private List<String> ids;
	
	private String fileName;
	
	private List<GetListParamElement> sort;
	
	private List<GetListParamElement> filter;
	
	private Integer currentPage;
	
	@JsonIgnore
	private Integer pageSize;
	
	private List<Map<String, String>> parameters;
	
	private int isMarket;
	
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getTemplateDisplayName() {
		return templateDisplayName;
	}

	public void setTemplateDisplayName(String templateDisplayName) {
		this.templateDisplayName = templateDisplayName;
	}

	public String getTemplateDescription() {
		return templateDescription;
	}

	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}

	public List<Map<String, String>> getParameters() {
		return parameters;
	}

	public void setParameters(List<Map<String, String>> parameters) {
		this.parameters = parameters;
	}

	public List<AppInstanceDO> getInstances() {
		return instances;
	}

	public void setInstances(List<AppInstanceDO> instances) {
		this.instances = instances;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getIsMarket() {
		return isMarket;
	}

	public void setIsMarket(int isMarket) {
		this.isMarket = isMarket;
	}

}
