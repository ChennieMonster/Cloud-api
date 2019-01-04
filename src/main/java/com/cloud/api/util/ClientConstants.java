package com.cloud.api.util;

public final class ClientConstants {

	public static final String HEADER_AUTHORIZATION = "Authorization";

	public static final String CONTENT_TYPE_JSON = "application/json";

	public static final String CONTENT_UTF8_TYPE_JSON = "application/json";

	public static final String OPENSHIFT_ENDPOINT = "https://master.example.com:8443";
//	public static final String OPENSHIFT_ENDPOINT = "https://10.196.100.82:8443";
	
	public static final String REGISTRY_ENDPOINT = "http://192.168.122.217:8080";
	
	public static final String CONTAINER_ENDPOINT = "http://192.168.122.217:8080";
	
	public static final String OPENSHIFT_REGISTRY_URL = "docker-registry-default.apps.example.com";
	
	public static final String URL_HTTPS = "https://";
	
	public static final String REGISTRY_URL = "REGISTRY_URL";
	
	public static final String NODE = "NODE";
	
	public static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";

	public static final String ENCODING_UTF8 = "UTF-8";

	public static final String RESPONSE_MSG_KEY = "message";
	// Paths
	public static final String URI_SEP = "/";
	
	public static final String CONTENT_TYPE = "Content-Type";

	public static final int NORMAL_RESPONSE_CODE = 200;
	public static final int NORMAL_CREATE_RESPONSE_CODE = 201;
	public static final int NORMAL_GET_RESPONSE_CODE = 203;
	public static final int NORMAL_CREATE_RESPONSE_CODE_WITHOUT_RESPONSE = 204;
	public static final int NORMAL_DELETE_RESPONSE_CODE = 204;
	public static final int NORMAL_ASYNC_RESPONSE_CODE = 202;
	public static final int BAD_REQUEST_RESPONSE_CODE = 400;
	public static final int UN_AUTHHORIZED_RESPONSE_CODE = 401;
	public static final int SERVICE_FORBIDDEN_RESPONSE_CODE = 403;
	public static final int NOT_FOUND_RESPONSE_CODE = 404;
	public static final int ALREADLAY_EXIST_RESPONSE_CODE = 409;
	public static final int UNPROCESSSABLE_ENTITY = 422;
	public static final int SERVICE_UNAVAILABLE_RESPONSE_CODE = 503;
	public static final int SERVICE_ERROR_RESPONSE_CODE = 500;
}
