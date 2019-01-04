package com.cloud.api.core.exception;

public class AuthException extends ResponseException {

	private static final long serialVersionUID = 1L;

	public AuthException(String message, int status, Throwable cause) {
		super(message, status, cause);
	}

	public AuthException(String message, int status) {
		super(message, status);
	}
}
