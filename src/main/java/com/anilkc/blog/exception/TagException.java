package com.anilkc.blog.exception;

public class TagException extends BlogException {

	private static final long serialVersionUID = 3722432625935547935L;

	public TagException() {
	}

	public TagException(String message) {
		super(message);
	}

	public TagException(Throwable cause) {
		super(cause);
	}

	public TagException(String message, Throwable cause) {
		super(message, cause);
	}

	public TagException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
