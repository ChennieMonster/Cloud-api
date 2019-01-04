package com.cloud.api.entity.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cloud.api.entity.GetListParamElement;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author huang_kefei
 * @date 2018年10月25日 类说明
 */
public class UserRequest {
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "sUuid")
	@NotEmpty(message = "{user.uuid.null}")
	@Size(max = 128, message = "{user.sUuid.length}")
	private String uuid;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "name")
	@Size(max = 32, message = "{user.name.length}")
	private String name;

	/**
	 * 用户昵称
	 */
	@ApiModelProperty(value = "display_name")
	@Size(max = 32, message = "{user.name.length}")
	private String displayName;

	@ApiModelProperty(value = "telephone")
	@Size(min = 8,max = 32, message = "{user.telephone.length}")
    private String telephone;

	@ApiModelProperty(value = "mail")
	@Size(min = 8,max = 64, message = "{user.mail.length}")
    private String mail;

	
	@ApiModelProperty(value = "dept")
	@Size(max = 32, message = "{user.dept.length}")
    private String dept;

	@ApiModelProperty(value = "empId")
	@Size(max = 32, message = "{user.empId.length}")
    private String empId;

	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	private List<GetListParamElement> sort;
	
	private List<GetListParamElement> filter;
	
	private Integer currentPage;
	
	private Integer pageSize;
	
	private List<String> ids;
	
}
