package com.cloud.api.core.http;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.MDC;

import com.cloud.api.core.Config;
import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.type.ServiceType;
import com.cloud.api.dto.RegionDTOExample;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.model.ModelEntity;
import com.cloud.api.model.common.Payload;
import com.cloud.api.service.impl.RegionServiceImpl;
import com.cloud.api.util.ClientConstants;
import com.cloud.api.util.ContextUtils;
import com.google.common.collect.Maps;

/**
 * A Request Delegate which aids in building the request that is compatible with
 * the OpenStack Rest API. The request is used to encoding as well as keeping
 * reference to the return type
 * 
 * @param <R> the entity return type
 * @author zhang.feng
 */
public class HttpOpenSClient<R> {

	String endpoint;
	String path;
	String tokenid;
	Class<R> returnType;
	Object entity;
	String contentType = ClientConstants.CONTENT_TYPE_JSON;
	HttpMethod method = HttpMethod.GET;
	String json;
	private Config config;
	private Map<String, List<Object>> queryParams;
	private Map<String, Object> headers = new HashMap<String, Object>();

	public HttpOpenSClient() {
	}

	/**
	 * Creates a new HttpRequest
	 *
	 * @param endpoint   the endpoint URI
	 * @param path       the path which will be appended to the endpoint URI
	 * @param method     the method the method type to invoke
	 * @param entity     the entity (used for posts)
	 * @param returnType the expected return type
	 */
	public HttpOpenSClient(String endpoint, String path, HttpMethod method, ModelEntity entity, Class<R> returnType) {
		this.endpoint = endpoint;
		this.path = path;
		this.method = method;
		this.entity = entity;
	}

	/**
	 * A build for creating HttpRequest objects
	 *
	 * @return the request builder
	 */
	public static OpenSClientBuilder<Void> builder() {
		return new OpenSClientBuilder<Void>(Void.class);
	}

	/**
	 * A build for creating HttpRequest objects
	 *
	 * @param            <R> the expected return type
	 * @param returnType the return type
	 * @return the request builder
	 */
	public static <R> OpenSClientBuilder<R> builder(Class<R> returnType) {
		return new OpenSClientBuilder<R>(returnType);
	}

	/**
	 * @return the method this request will use
	 */
	public HttpMethod getMethod() {
		return method;
	}

	/**
	 * @return the content type for the request
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @return the endpoint URI
	 */
	public String getEndpoint() {
		return endpoint;
	}

	/**
	 * @return the tokenid
	 */
	public String tokenid() {
		return tokenid;
	}

	/**
	 * @return the http path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * If JSON is explicitly set vs an entity then this method will return a JSON
	 * String otherwise Empty
	 * 
	 * @return JSON String form or Empty
	 */
	public String getJson() {
		return (json == null) ? "" : json;
	}

	/**
	 * @return true, if a JSON Object has been set
	 */
	public boolean hasJson() {
		return (json != null);
	}

	/**
	 * @return the return type expected after invocation
	 */
	public Class<R> getReturnType() {
		return returnType;
	}

	/**
	 * @return the entity to post
	 */
	public Object getEntity() {
		return entity;
	}

	/**
	 * @return true, if query params have been added
	 */
	public boolean hasQueryParams() {
		return queryParams != null && !queryParams.isEmpty();
	}

	/**
	 * @return the request query params
	 */
	public Map<String, List<Object>> getQueryParams() {
		return queryParams;
	}

	/**
	 * @return the headers to apply
	 */
	public Map<String, Object> getHeaders() {
		return headers;
	}

	/**
	 * @return true, if headers have been added
	 */
	public boolean hasHeaders() {
		return !headers.isEmpty();
	}

	/**
	 * @return the client configuration associated with this request
	 */
	public Config getConfig() {
		return config != null ? config : Config.DEFAULT;
	}

	public static final class OpenSClientBuilder<R> {

		HttpOpenSClient<R> client;
		ServiceType service;

		public OpenSClientBuilder(HttpOpenSClient<R> client) {
			this.client = client;
		}

		public OpenSClientBuilder(Class<R> returnType) {
			client = new HttpOpenSClient<R>();
			client.returnType = returnType;
		}

		/**
		 * @see HttpRequest#getEndpoint()
		 */
		public OpenSClientBuilder<R> endpoint(String endpoint) {
			client.endpoint = endpoint;
			return this;
		}

		/**
		 * @see HttpRequest#getPath()
		 */
		public OpenSClientBuilder<R> path(String path) {
			client.path = path;
			return this;
		}

		/**
		 * @see HttpRequest#getMethod()
		 */
		public OpenSClientBuilder<R> method(HttpMethod method) {
			client.method = method;
			return this;
		}

		/**
		 * Flags the request method as PUT
		 *
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> methodPut() {
			client.method = HttpMethod.PUT;
			return this;
		}

		/**
		 * Flags the request method as GET
		 *
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> methodGet() {
			client.method = HttpMethod.GET;
			return this;
		}

		/**
		 * Flags the request method as DELETE
		 *
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> methodDelete() {
			client.method = HttpMethod.DELETE;
			return this;
		}

		/**
		 * Flags the request method as POST
		 *
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> methodPost() {
			client.method = HttpMethod.POST;
			return this;
		}

		/**
		 * @see HttpRequest#getEntity()
		 */
		public OpenSClientBuilder<R> entity(ModelEntity entity) {
			client.entity = entity;
			return this;
		}

		/**
		 * @see HttpRequest#getEntity()
		 */
		public OpenSClientBuilder<R> entity(Payload<?> entity) {
			if (entity != null)
				client.entity = entity.open();
			return this;
		}

		/**
		 * Pushes the Map of Headers into the existing headers for this request
		 * 
		 * @param headers the headers to append
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> headers(Map<String, ? extends Object> headers) {
			client.getHeaders().putAll(headers);
			return this;
		}

		/**
		 * Adds a new Header to the request
		 * 
		 * @param name  the header name
		 * @param value the header value
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> header(String name, Object value) {
			client.getHeaders().put(name, value);
			return this;
		}

		/**
		 * The endpoint Service Type
		 *
		 * @param service the service type
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> serviceType(ServiceType service) {
			this.service = service;
			return this;
		}

		/**
		 * Adds a Key/Value based Query Param
		 *
		 * @param key   the key
		 * @param value the value
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> queryParam(String key, Object value) {
			if (value == null)
				return this;

			if (client.queryParams == null)
				client.queryParams = Maps.newHashMap();

			if (client.queryParams.containsKey(key)) {
				List<Object> values = client.queryParams.get(key);
				values.add(value);
			} else {
				List<Object> values = new ArrayList<Object>();
				values.add(value);
				client.queryParams.put(key, values);
			}
			return this;
		}

		/**
		 * AdHoc JSON object to Post/Put
		 *
		 * @param json the JSON object in String form
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> json(String json) {
			client.json = json;
			return this;
		}

		/**
		 * Overrides the default content type for the request
		 * 
		 * @param contentType the content type to use in the request
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> contentType(String contentType) {
			if (contentType != null)
				client.contentType = contentType;
			return this;
		}

		/**
		 * Overrides the default content type for the request
		 * 
		 * @param contentType the content type to use in the request
		 * @return the request builder
		 */
		public OpenSClientBuilder<R> token(TokenDO token) {
			StringBuffer tokenData = new StringBuffer(ClientConstants.AUTHORIZATION_HEADER_PREFIX);
			if (token != null && token.getTokenId() != null) {
				tokenData = tokenData.append(token.getTokenId());
				client.getHeaders().put(ClientConstants.HEADER_AUTHORIZATION, tokenData);
			}
			return this;
		}

		/**
		 * Builds the HttpRequest
		 *
		 * @return HttpRequest
		 */
		public HttpOpenSClient<R> build() {
			if(client.endpoint==null) {
				String regionId=MDC.get(MDCConstants.REGION_ID);
				if(ContextUtils.getApplicationContext()!=null&&ContextUtils.getApplicationContext().getBean(RegionServiceImpl.class)!=null) {
					client.endpoint=ContextUtils.getApplicationContext().getBean(RegionServiceImpl.class).queryOpenshiftUrl(regionId);	
				}
//				client.endpoint=ClientConstants.OPENSHIFT_ENDPOINT;
			}
			return client;
		}
		
		public HttpOpenSClient<R> buildWithRegion() {
			if(client.endpoint==null) {
				String regionId="1";
				if(ContextUtils.getApplicationContext()!=null&&ContextUtils.getApplicationContext().getBean(RegionServiceImpl.class)!=null) {
					client.endpoint=ContextUtils.getApplicationContext().getBean(RegionServiceImpl.class).queryOpenshiftUrl(regionId);	
				}
//				client.endpoint=ClientConstants.OPENSHIFT_ENDPOINT;
			}
			return client;
		}
	}
}