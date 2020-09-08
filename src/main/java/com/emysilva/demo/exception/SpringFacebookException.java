package com.emysilva.demo.exception;

public class SpringFacebookException extends RuntimeException {
	public SpringFacebookException(String message, Exception cause) {
		super(message, cause);
	}

	public SpringFacebookException(String message) {
		super(message);
	}
}
