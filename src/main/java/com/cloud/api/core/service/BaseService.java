package com.cloud.api.core.service;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;

import com.cloud.api.controller.UserController;
import com.cloud.api.core.exception.ConnectionException;
import com.cloud.api.core.exception.ResourcesNotFoundException;
import com.cloud.api.core.exception.ResponseException;
import com.cloud.api.core.exception.ServiceException;
import com.cloud.api.core.http.HttpMethod;
import com.cloud.api.core.http.HttpOpenSClient;
import com.cloud.api.core.http.HttpOpenSClient.OpenSClientBuilder;
import com.cloud.api.core.http.HttpOpenSExecutor;
import com.cloud.api.core.type.ServiceType;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.model.ModelEntity;
import com.cloud.api.model.common.Payload;
import com.cloud.api.util.ClientConstants;
import com.cloud.api.util.MessageUtils;

public class BaseService {
	
    ServiceType serviceType = ServiceType.OPENSHIFT;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    protected BaseService() {
    }

    protected <R> Invocation<R> get(Class<R> returnType, String path, TokenDO token) {
        return builder(returnType, path, token, HttpMethod.GET);
    }

    protected <R> Invocation<R> post(Class<R> returnType, String path, TokenDO token) {
        return builder(returnType, path, token, HttpMethod.POST);
    }

    protected <R> Invocation<R> put(Class<R> returnType, String path, TokenDO token) {
        return builder(returnType, path, token, HttpMethod.PUT);
    }

    protected <R> Invocation<R> patch(Class<R> returnType, String path, TokenDO token) {
        return builder(returnType, path, token, HttpMethod.PATCH);
    }

    protected <R> Invocation<R> delete(Class<R> returnType, String path, TokenDO token) {
        return builder(returnType, path, token, HttpMethod.DELETE);
    }

    protected <R> Invocation<R> head(Class<R> returnType, String path, TokenDO token) {
        return builder(returnType, path, token, HttpMethod.HEAD);
    }

    protected <R> Invocation<R> request(HttpMethod method, Class<R> returnType, TokenDO token,String path) {
        return builder(returnType, path, token,method);
    }

    protected String uri(String path, Object... params) {
        if (params.length == 0)
            return path;
        return String.format(path, params);
    }

    private <R> Invocation<R> builder(Class<R> returnType, String path, TokenDO token, HttpMethod method) {
    	OpenSClientBuilder<R> clientBuilder = HttpOpenSClient.builder(returnType)
                .method(method).path(path).token(token);
        return new Invocation<R>(clientBuilder, serviceType);
    }
    
    protected static class Invocation<R> {
    	OpenSClientBuilder<R> clientBuiler;

        protected Invocation(OpenSClientBuilder<R> client, ServiceType serviceType) {
            this.clientBuiler = client;
            client.serviceType(serviceType);
        }

        public HttpOpenSClient<R> getClient() {
            return clientBuiler.build();
        }

        public Invocation<R> serviceType(ServiceType serviceType) {
        	clientBuiler.serviceType(serviceType);
            return this;
        }

        public Invocation<R> entity(ModelEntity entity) {
        	clientBuiler.entity(entity);
            return this;
        }

        public Invocation<R> entity(Payload<?> entity) {
        	clientBuiler.entity(entity);
        	clientBuiler.contentType(ClientConstants.CONTENT_TYPE_JSON);
            return this;
        }

        public Invocation<R> contentType(String contentType) {
        	clientBuiler.contentType(contentType);
            return this;
        }

        public Invocation<R> json(String json) {
        	clientBuiler.json(json);
            return this;
        }

        public Invocation<R> endpoint(String endpoint) {
        	clientBuiler.endpoint(endpoint);
            return this;
        }
        
        public Invocation<R> headers(Map<String, ? extends Object> headers) {
            if (headers != null)
            	clientBuiler.headers(headers);
            return this;
        }

        public Invocation<R> header(String name, Object value) {
        	clientBuiler.header(name, value);
            return this;
        }
        
        public Invocation<R> params(Map<String, ? extends Object> params) {
            if (params != null) {
                for (String name : params.keySet())
                	clientBuiler.queryParam(name, params.get(name));
            }
            return this;
        }
		
        public CloseableHttpResponse executeWithResponse() {
        	HttpOpenSExecutor<R> executor = HttpOpenSExecutor.create(clientBuiler.build());
        	CloseableHttpResponse response = null;
			try {
				response = executor.execute();
			} catch (ResponseException re) {
				throw re;
			} catch (Exception pe) {
				throw new ConnectionException(pe.getMessage(), 0, pe);
			}finally {
				try {
					if (null == response) {
						logger.warn("response is null");
						return null;
					}
					int httpCode = response.getStatusLine().getStatusCode();
					switch (httpCode) {
					   case HttpStatus.SC_OK:
					   case HttpStatus.SC_CREATED:
					   case HttpStatus.SC_ACCEPTED:
					   case HttpStatus.SC_NO_CONTENT:
					   case HttpStatus.SC_MOVED_TEMPORARILY:
						   break;
					   case HttpStatus.SC_BAD_REQUEST:
						   throw new ServiceException(EntityUtils.toString(response.getEntity()));
					   case HttpStatus.SC_UNAUTHORIZED:
						   throw new BadCredentialsException(EntityUtils.toString(response.getEntity()));
					   case HttpStatus.SC_FORBIDDEN:
						   throw new AccessDeniedException(EntityUtils.toString(response.getEntity()));
					   case HttpStatus.SC_NOT_FOUND:
						   throw new ResourcesNotFoundException(EntityUtils.toString(response.getEntity()));
					   case HttpStatus.SC_INTERNAL_SERVER_ERROR:
						   throw new ServiceException(MessageUtils.getMessage(MessageUtils.ERR_INTERNAL));
					   default:
						   throw new ServiceException(EntityUtils.toString(response.getEntity()));
					}
					if (null != response) response.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
			    }
			}
            return response;
        }
        
        public CloseableHttpResponse executeWithResponseNotClose() {
        	HttpOpenSExecutor<R> executor = HttpOpenSExecutor.create(clientBuiler.build());
        	CloseableHttpResponse response = null;
			try {
				response = executor.execute();
			} catch (ResponseException re) {
				throw re;
			} catch (Exception pe) {
				throw new ConnectionException(pe.getMessage(), 0, pe);
			}
			
			if (null == response) {
				logger.warn("response is null");
				return null;
			}
			int httpCode = response.getStatusLine().getStatusCode();
			try {
				switch (httpCode) {
				   case HttpStatus.SC_OK:
				   case HttpStatus.SC_CREATED:
				   case HttpStatus.SC_ACCEPTED:
				   case HttpStatus.SC_NO_CONTENT:
				   case HttpStatus.SC_MOVED_TEMPORARILY:
					   break;
				   case HttpStatus.SC_BAD_REQUEST:
					   throw new ServiceException(EntityUtils.toString(response.getEntity()));
				   case HttpStatus.SC_UNAUTHORIZED:
					   throw new BadCredentialsException(EntityUtils.toString(response.getEntity()));
				   case HttpStatus.SC_FORBIDDEN:
					   throw new AccessDeniedException(EntityUtils.toString(response.getEntity()));
				   case HttpStatus.SC_NOT_FOUND:
					   throw new ResourcesNotFoundException(EntityUtils.toString(response.getEntity()));
				   case HttpStatus.SC_INTERNAL_SERVER_ERROR:
					   throw new ServiceException(MessageUtils.getMessage(MessageUtils.ERR_INTERNAL));
				   default:
					   throw new ServiceException(EntityUtils.toString(response.getEntity()));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
            return response;
        }
        
        public CloseableHttpResponse executeWithResponseWithRegion() {
        	HttpOpenSExecutor<R> executor = HttpOpenSExecutor.create(clientBuiler.buildWithRegion());
        	CloseableHttpResponse response = null;
			try {
				response = executor.execute();
			} catch (ResponseException re) {
				throw re;
			} catch (Exception pe) {
				throw new ConnectionException(pe.getMessage(), 0, pe);
			}finally {
				try {
					if (null == response) {
						logger.warn("response is null");
						return null;
					}
					int httpCode = response.getStatusLine().getStatusCode();
					switch (httpCode) {
					   case HttpStatus.SC_OK:
					   case HttpStatus.SC_CREATED:
					   case HttpStatus.SC_ACCEPTED:
					   case HttpStatus.SC_NO_CONTENT:
					   case HttpStatus.SC_MOVED_TEMPORARILY:
						   break;
					   case HttpStatus.SC_BAD_REQUEST:
						   throw new ServiceException(EntityUtils.toString(response.getEntity()));
					   case HttpStatus.SC_UNAUTHORIZED:
						   throw new BadCredentialsException(EntityUtils.toString(response.getEntity()));
					   case HttpStatus.SC_FORBIDDEN:
						   throw new AccessDeniedException(EntityUtils.toString(response.getEntity()));
					   case HttpStatus.SC_NOT_FOUND:
						   throw new ResourcesNotFoundException(EntityUtils.toString(response.getEntity()));
					   case HttpStatus.SC_INTERNAL_SERVER_ERROR:
						   throw new ServiceException(MessageUtils.getMessage(MessageUtils.ERR_INTERNAL));
					   default:
						   throw new ServiceException(EntityUtils.toString(response.getEntity()));
					}
					if (null != response) response.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
			    }
			}
            return response;
        }
        
    }
}
