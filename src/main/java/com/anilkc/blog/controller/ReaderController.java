package com.anilkc.blog.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anilkc.blog.custom.AsidePass;
import com.anilkc.blog.custom.LogBeforeMethod;
import com.anilkc.blog.domain.Post;
import com.anilkc.blog.domain.service.PostService;
import com.anilkc.blog.domain.service.UserService;
import com.anilkc.blog.exception.UserException;

@Controller
@RequestMapping("/reader")
@LogBeforeMethod
@AsidePass
public class ReaderController {

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String landing(Principal principal, Model model) throws UserException {
		List<Post> posts = postService.getAll();
		model.addAttribute("posts", posts);
		return "bloggerLanding";
	}
}
