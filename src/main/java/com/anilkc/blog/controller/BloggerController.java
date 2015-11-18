package com.anilkc.blog.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anilkc.blog.domain.Post;
import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.domain.service.PostService;
import com.anilkc.blog.domain.service.TagService;
import com.anilkc.blog.domain.service.UserService;
import com.anilkc.blog.exception.PostException;
import com.anilkc.blog.exception.UserException;

@Controller
@RequestMapping("/blogger")
public class BloggerController {

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

	@Autowired
	private TagService tagService;

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public String landing(Principal principal, Model model) throws UserException {
		List<Post> posts  = postService.getPostsByUser(userService.getUserByUsername(principal.getName()));
		model.addAttribute("posts", posts);
		return "bloggerLanding";
	}

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String getPostForm(@ModelAttribute("post") Post post, Model model) {
		Set<Tag> tags = new HashSet<>(tagService.getAll());
		post.setTags(tags);
		return "bloggerPost";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String getPostForm(@ModelAttribute("post") Post post, Principal principal) throws UserException {
		post.setAuthor(userService.getUserByUsername(principal.getName()));
		postService.addPost(post);
		return "redirect:/blogger";
	}
	
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
	public String readMore(@PathVariable Long postId, Model model) throws PostException {
		Post post = postService.getPostById(postId);
		model.addAttribute("post", post);
		return "readMore";
	}

}
