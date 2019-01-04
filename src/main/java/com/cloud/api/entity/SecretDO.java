package com.cloud.api.entity;

import java.util.HashMap;
import java.util.Map;

import com.cloud.api.model.ModelEntity;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.SecretUtils;

public class SecretDO implements ModelEntity{
	
	private static final long serialVersionUID = -2094083360064748055L;

	private String kind;
	
	private String apiVersion;
	
	private MetaDataDO metadata;
	
	private Map<String,Object> data;
	
	private String type;
	
	public SecretDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SecretDO(String name,String tlsCrt,String tlsKey) {
		super();
		this.kind = "Secret";
		this.apiVersion = "v1";
		this.type = "kubernetes.io/tls";
		
		// set metadata
		MetaDataDO md = new MetaDataDO();
		md.setName(name);
		md.setCreationTimestamp(null);
		this.metadata = md;
		
		// set data
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("tls.crt", tlsCrt);
		map.put("tls.key", tlsKey);
		this.data = map;
	}
	
	public SecretDO(String name,Map<String,Object> param) {
		super();
		this.kind = "Secret";
		this.apiVersion = "v1";
		this.type = "kubernetes.io/dockerconfigjson";
		
		// set metadata
		MetaDataDO md = new MetaDataDO();
		md.setName(name);
		md.setCreationTimestamp(null);
		this.metadata = md;
		// set data
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("auths", param);
		String jsonStr = JsonUtils.objectToJson(map2);
		String baseStr = SecretUtils.getBase64(jsonStr);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put(".dockerconfigjson", baseStr);
		this.data = map;
	}
	
	public SecretDO(Map<String,Object> param) {
		super();
		// set data
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("auths", param);
		String jsonStr = JsonUtils.objectToJson(map2);
		String baseStr = SecretUtils.getBase64(jsonStr);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put(".dockerconfigjson", baseStr);
		this.data = map;
	}
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public MetaDataDO getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaDataDO metadata) {
		this.metadata = metadata;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
