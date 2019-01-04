package com.cloud.api.core.exception;

/**
 * Service 异常
 *
 * @author zhao_pengchen
 * @date 2018/05/27
 */
public class ServiceException extends RuntimeException {
    public ServiceException(final String message) {
        super(message);
    }

    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
