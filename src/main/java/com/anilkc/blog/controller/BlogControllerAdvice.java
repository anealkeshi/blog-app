package com.anilkc.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.anilkc.blog.exception.BlogException;

@ControllerAdvice
public class BlogControllerAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogControllerAdvice.class);

	@ExceptionHandler(value = AccessDeniedException.class)
	public String accessDenied(HttpServletRequest httpServletRequest) {
		return "error-forbidden";
	}

	@ExceptionHandler(value = BlogException.class)
	public String error(HttpServletRequest httpServletRequest, BlogException e) {
		LOGGER.error("Blog exception: {} class: {}", e.getMessage(), e.getClass());
		return "error";
	}

}
