package com.anilkc.blog.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anilkc.blog.custom.LogBeforeMethod;

@Controller
@LogBeforeMethod
public class HomeController {

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String getHome(Principal principal) {
		if (principal == null) {
			return "home";
		} else {
			return "redirect:/landing";
		}
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied() {
		return "resourceNotFound";
	}
}
