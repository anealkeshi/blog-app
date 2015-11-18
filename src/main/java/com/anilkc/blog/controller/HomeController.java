package com.anilkc.blog.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String getHome(Principal principal) {
		if (principal == null) {
			return "home";
		} else {
			return "redirect:/landing";
		}
	}
}
