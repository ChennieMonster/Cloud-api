/**
 * 
 */
package com.cloud.api.dto;


import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhao_pengchen
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	/**
	 * 用户ID
	 */
	@ApiModelProperty(value = "uuid",hidden=true)
	@NotEmpty(message = "{user.uuid.null}")
	@Size(max = 128, message = "{user.uuid.length}")
	private String uuid;

	/**
	 * 用户名
	 */
	@ApiModelProperty(value = "userName")
	@NotEmpty(message = "{user.userName.null}")
	@Size(min = 5, max = 32, message = "{user.userName.length}")
	private String userName;

	/**
	 * 密码
	 */
	@ApiModelProperty(value = "password")
	@NotEmpty(message = "{user.password.null}")
	@Size(min = 8,max = 128, message = "{user.password.length}")
	private String password;

	/**
	 * 角色
	 */
	@ApiModelProperty(value = "role")
	@NotEmpty(message = "{user.role.null}")
	@Size(max = 64, message = "{user.role.length}")
	private String role;

	/**
	 * 语言
	 */
	@ApiModelProperty(value = "language")
	@Size(max = 32, message = "{user.language.length}")
	private String language;
	
	@ApiModelProperty(value = "telephone")
	@Size(min = 8,max = 32, message = "{user.telephone.length}")
    private String telephone;

	@ApiModelProperty(value = "mail")
	@Size(min = 8,max = 64, message = "{user.mail.length}")
    private String mail;

	@ApiModelProperty(value = "displayName")
	@Size(min = 5, max = 32, message = "{user.displayName.length}")
    private String displayName;

	@ApiModelProperty(value = "dept")
	@Size(max = 32, message = "{user.dept.length}")
    private String dept;

	@ApiModelProperty(value = "empId")
	@Size(max = 32, message = "{user.empId.length}")
    private String empId;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @ApiModelProperty(hidden=true)
    private Date createdTime;

    /**
     * 
     */
    private Integer rstatus;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    @ApiModelProperty(hidden=true)
    private Date updatedTime; 
    
    
   
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Integer getRstatus() {
		return rstatus;
	}

	public void setRstatus(Integer rstatus) {
		this.rstatus = rstatus;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}