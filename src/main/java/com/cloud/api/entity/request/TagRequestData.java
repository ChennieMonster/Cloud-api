package com.cloud.api.entity.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TagRequestData {
	
	@NotEmpty(message = "{tag.name.is.not.null}")
	@Size(max = 32, message = "{tag.name.length}")
	@Pattern(regexp="[a-z0-9]([.0-9]*[0-9])?", message="{tag.name.invalid}")
	private String tagName;
	
//	private List<String> volume;

//	private List<Map<String, String>> env;

	private String changelog;
	
//	@NotEmpty(message = "{tag.file.is.not.null}")
	private String file;
	
	private List<String> ids;
	
	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getChangelog() {
		return changelog;
	}

	public void setChangelog(String changelog) {
		this.changelog = changelog;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
