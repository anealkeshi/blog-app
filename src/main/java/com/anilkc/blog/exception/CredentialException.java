package com.anilkc.blog.exception;

public class CredentialException extends BlogException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6243297000381549067L;

	public CredentialException() {
	}

	public CredentialException(String message) {
		super(message);
	}

	public CredentialException(Throwable cause) {
		super(cause);
	}

	public CredentialException(String message, Throwable cause) {
		super(message, cause);
	}

	public CredentialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
