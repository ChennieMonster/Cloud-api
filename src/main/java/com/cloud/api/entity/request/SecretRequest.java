/**
 * 
 */
package com.cloud.api.entity.request;

import java.util.List;

import com.cloud.api.entity.GetListParamElement;

/**
 * @author zhao_pengchen
 *
 */
public class SecretRequest {

	private String userName;
	
	private String password;
	
	private String secretName;
	
	private String url;
	
	private List<GetListParamElement> sort;
	
	private List<GetListParamElement> filter;

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

	public String getSecretName() {
		return secretName;
	}

	public void setSecretName(String secretName) {
		this.secretName = secretName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
	
}
