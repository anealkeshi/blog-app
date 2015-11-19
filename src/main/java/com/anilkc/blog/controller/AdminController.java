package com.anilkc.blog.controller;

import java.util.EnumSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anilkc.blog.custom.AsidePass;
import com.anilkc.blog.custom.LogBeforeMethod;
import com.anilkc.blog.domain.Credential;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.UserRole;
import com.anilkc.blog.domain.UserRoleType;
import com.anilkc.blog.domain.service.CredentialService;
import com.anilkc.blog.domain.service.UserRoleService;
import com.anilkc.blog.domain.service.UserService;
import com.anilkc.blog.exception.UserRoleException;

@Controller
@LogBeforeMethod
@RequestMapping("/admin")
@AsidePass
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private CredentialService credentialService;

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

	@RequestMapping(value = "/updateRole", method = RequestMethod.GET)
	@ResponseBody
	public String updateRoles(@RequestParam("id") Long userId, @RequestParam("event") String event,
			@RequestParam("role") String role) throws UserRoleException {

		User user = userService.getUserById(userId);
		Credential credential = user.getCredential();
		if (event.equalsIgnoreCase("Add")) {
			userRoleService.addUserRole(new UserRole(credential, role));
		}else{
			UserRole userRole = userRoleService.getUserRoleByRoleName(role);
			credential.removeUserRole(userRole);
		}
		credentialService.updateCredential(credential);
		return "completed";
	}
}
