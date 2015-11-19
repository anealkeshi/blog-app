package com.anilkc.blog.exception;

public class UserRoleException extends BlogException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7242514110036553023L;

	public UserRoleException() {
	}

	public UserRoleException(String message) {
		super(message);
	}

	public UserRoleException(Throwable cause) {
		super(cause);
	}

	public UserRoleException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserRoleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
