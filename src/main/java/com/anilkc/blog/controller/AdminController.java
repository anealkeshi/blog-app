package com.anilkc.blog.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anilkc.blog.domain.UserRoleType;
import com.anilkc.blog.domain.service.UserRoleService;
import com.anilkc.blog.domain.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value = { "/landing", "/", "" }, method = RequestMethod.GET)
	public String adminLanding() {
		return "adminLanding";
	}

	@RequestMapping(value = "/manageUsers", method = RequestMethod.GET)
	public String managerUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		EnumSet<UserRoleType> userRoles = EnumSet.allOf(UserRoleType.class);
		model.addAttribute("roles", userRoles);

		return "manageUser";
	}
}
