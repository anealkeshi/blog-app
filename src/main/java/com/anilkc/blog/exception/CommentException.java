package com.anilkc.blog.exception;

public class CommentException extends BlogException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -89386923382825279L;

	public CommentException() {
	}

	public CommentException(String message) {
		super(message);
	}

	public CommentException(Throwable cause) {
		super(cause);
	}

	public CommentException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
