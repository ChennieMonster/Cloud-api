package com.cloud.api.entity.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistryRequestData {
	
	@NotEmpty(message = "{registry.name.is.not.null}")
	@Size(max = 32, message = "{registry.name.length}")
	@Pattern(regexp="[a-z]([-a-z0-9]*[a-z0-9])?", message = "{registry.name.invalid}")
	private String registryName;
	
	@NotEmpty(message = "{registry.displayName.is.not.null}")
	@Size(max = 64, message = "{registry.displayName.length}")
	private String registryDisplayName;
	
	@Size(max = 256, message = "{registry.description.length}")
	private String registryDescription;
	
	private String registryType;
	
//	@Min(value=1, message = "{registry.cpu.min}")
	private int registryCpu;
	
//	@Min(value=1, message = "{registry.memory.min}")
//	@Max(value=4096, message = "{registry.memory.max}")
	private int registryMemory;
	
//	@Min(value=1, message = "{registry.disk.min}")
//	@Max(value=1000, message = "{registry.disk.max}")
	private int registryDisk;
	
	private String url;
	
	@Size(max = 32, message = "{registry.userName.length}")
	private String userName;
	
	@Size(max = 32, message = "{registry.password.length}")
	private String password;
	
	private List<String> ids;
	
	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getRegistryName() {
		return registryName;
	}

	public void setRegistryName(String registryName) {
		this.registryName = registryName;
	}

	public String getRegistryDisplayName() {
		return registryDisplayName;
	}

	public void setRegistryDisplayName(String registryDisplayName) {
		this.registryDisplayName = registryDisplayName;
	}

	public String getRegistryDescription() {
		return registryDescription;
	}

	public void setRegistryDescription(String registryDescription) {
		this.registryDescription = registryDescription;
	}

	public String getRegistryType() {
		return registryType;
	}

	public void setRegistryType(String registryType) {
		this.registryType = registryType;
	}

	public int getRegistryCpu() {
		return registryCpu;
	}

	public void setRegistryCpu(int registryCpu) {
		this.registryCpu = registryCpu;
	}

	public int getRegistryMemory() {
		return registryMemory;
	}

	public void setRegistryMemory(int registryMemory) {
		this.registryMemory = registryMemory;
	}

	public int getRegistryDisk() {
		return registryDisk;
	}

	public void setRegistryDisk(int registryDisk) {
		this.registryDisk = registryDisk;
	}
}
