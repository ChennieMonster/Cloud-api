/**
 * 
 */
package com.cloud.api.entity.response;

import java.util.List;

import com.cloud.api.entity.AppInstanceDO;
import com.cloud.api.entity.TemplateDetailDO;

/**
 * @author zhao_pengchen
 *
 */
public class EditMarketResponse {

	private String name;
	
	private String displayName;
	
	private String description;
	
	private String introduce;
	
	private String version;
	
	private String versionIntroduce;
	
	private String templateId;
	
	private TemplateDetailDO template;

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

	public TemplateDetailDO getTemplate() {
		return template;
	}

	public void setTemplate(TemplateDetailDO template) {
		this.template = template;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
