package com.cloud.api.core.exception;

/**
 * Base Cloud API Exception 
 * 
 * @author zhang feng
 */
public class CloudAPIException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CloudAPIException(String message) {
        super(message);
    }
    
    public CloudAPIException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CloudAPIException(Throwable cause) {
        super(cause);
    }
}
