/**
 * 
 */
package com.cloud.api.entity.request;

/**
 * @author zhao_pengchen
 *
 */
public class ProcessRequest {

	private String name;
	
	private String description;
	
	private String used;
	
	private String type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
