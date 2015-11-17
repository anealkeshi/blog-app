package com.anilkc.blog.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.service.TagService;
import com.anilkc.blog.domain.service.UserService;
import com.anilkc.blog.exception.BlogException;

@Controller
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private AuthenticationManager authMgr;
	@Autowired
	private UserDetailsService userDetailsSvc;

	@Autowired
	private UserService userService;

	@Autowired
	private TagService tagService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration(@ModelAttribute("user") User user) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "register";
		} else {

			redirectAttributes.addFlashAttribute("user", user);
			user = userService.registerUser(user);
			// perform login authentication
			try {
				UserDetails userDetails = userDetailsSvc.loadUserByUsername(user.getCredential().getUsername());
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails,
						user.getCredential().getPassword(), userDetails.getAuthorities());
				authMgr.authenticate(auth);

				// redirect into secured main page if authentication successful
				if (auth.isAuthenticated()) {
					SecurityContextHolder.getContext().setAuthentication(auth);
					return "redirect:/subscribe";
				}
			} catch (UsernameNotFoundException e) {
				LOGGER.error("Problem authenticating user" + user.getCredential().getUsername(), e);
			}
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/subscribe", method = RequestMethod.GET)
	public String subscribe(@ModelAttribute("user") User user, Model model) {
		List<Tag> tags = tagService.getAll();
		model.addAttribute("tags", tags);
		return "subscribe";
	}

	@RequestMapping(value = "/subscribe", method = RequestMethod.POST)
	public String saveSubscription(@ModelAttribute("user") User user, Model model, Principal principal) {
		try {
			userService.setUserTags(user, principal);
		} catch (BlogException e) {
			LOGGER.error("Exception while  seting user tags username: {}, message: {}, class: {}", principal.getName(),
					e.getMessage(), e.getClass());
		}

		return "redirect:/";
	}

}
