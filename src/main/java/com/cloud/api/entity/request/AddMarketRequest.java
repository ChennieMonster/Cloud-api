/**
 * 
 */
package com.cloud.api.entity.request;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author zhao_pengchen
 *
 */
public class AddMarketRequest {

	private String uuid;
	
	@NotEmpty(message = "name can't be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
    @NotEmpty(message = "displayName can't be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String displayName;
	
	private String description;
	
	@NotEmpty(message = "introduce can't be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String introduce;
	
	@NotEmpty(message = "version can't be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String version;
	
	@NotEmpty(message = "version introduce can't be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String versionIntroduce;
	
	//修改market时使用
	private String templateId;
    
    private TemplateRequest templateRequest;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TemplateRequest getTemplateRequest() {
		return templateRequest;
	}

	public void setTemplateRequest(TemplateRequest templateRequest) {
		this.templateRequest = templateRequest;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersionIntroduce() {
		return versionIntroduce;
	}

	public void setVersionIntroduce(String versionIntroduce) {
		this.versionIntroduce = versionIntroduce;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
    
}
