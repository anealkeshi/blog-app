package com.anilkc.blog.exception;

public class PostException extends BlogException {

	private static final long serialVersionUID = -3878249869619746062L;

	public PostException() {
	}

	public PostException(String message) {
		super(message);
	}

	public PostException(Throwable cause) {
		super(cause);
	}

	public PostException(String message, Throwable cause) {
		super(message, cause);
	}

	public PostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
