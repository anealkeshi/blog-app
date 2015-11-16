package com.anilkc.blog.exception;

public class UserException extends BlogException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2420021075025443076L;

	public UserException() {
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
