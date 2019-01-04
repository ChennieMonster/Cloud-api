/**
 * 
 */
package com.cloud.api.entity;

import java.util.List;
import java.util.Map;

/**
 * @author zhao_pengchen
 *
 */
public class HttpGetDO {

	private String path;
	
	private int port;
	
	private List<Map<String, String>> httpHeaders;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public List<Map<String, String>> getHttpHeaders() {
		return httpHeaders;
	}

	public void setHttpHeaders(List<Map<String, String>> httpHeaders) {
		this.httpHeaders = httpHeaders;
	}
	
}
