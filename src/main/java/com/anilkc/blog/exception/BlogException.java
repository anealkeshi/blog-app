package com.anilkc.blog.exception;

public class BlogException extends Exception {

	private static final long serialVersionUID = 340362586382815418L;

	public BlogException() {
	}

	public BlogException(String message) {
		super(message);
	}

	public BlogException(Throwable cause) {
		super(cause);
	}

	public BlogException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}