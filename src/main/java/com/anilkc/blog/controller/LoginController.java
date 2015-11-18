package com.anilkc.blog.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
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

import com.anilkc.blog.domain.Credential;
import com.anilkc.blog.domain.Post;
import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.UserRole;
import com.anilkc.blog.domain.UserRoleType;
import com.anilkc.blog.domain.service.PostService;
import com.anilkc.blog.domain.service.TagService;
import com.anilkc.blog.domain.service.UserService;
import com.anilkc.blog.exception.BlogException;
import com.anilkc.blog.exception.UserException;

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
	
	@Autowired
	private PostService postService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/landing", method = RequestMethod.GET)
	public String loginLanding(Principal principal) throws BlogException {

		if (principal == null) {
			return "redirect:/login";
		}

		User user = userService.getUserByUsername(principal.getName());
		Set<UserRole> roles = user.getCredential().getUserRole();

		for (UserRole role : roles) {

			if (role.getRole().equals(UserRoleType.ROLE_ADMIN.getValue())) {
				return "redirect:/admin";
			}

			if (role.getRole().equals(UserRoleType.ROLE_BLOGGER.getValue())) {
				return "redirect:/blogger";
			}

			if (role.getRole().equals(UserRoleType.ROLE_READER.getValue())) {
				return "redirect:/reader";
			}

		}
		return "redirect:/error";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registration(@ModelAttribute("user") User user) {
		return "register";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String handleError() {
		return "error";
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
	public String subscribe(Principal principal, Model model) throws UserException {
		User user = userService.getUserByUsername(principal.getName());
		List<Tag> tags = tagService.getAll();
		Map<Tag, Boolean> tagMap = new HashMap<>();

		for (Tag tag : tags) {
			tagMap.put(tag, Boolean.FALSE);
		}
		for (Tag tag : tags) {
			for (Tag userTag : user.getTags()) {
				if (tag.getTagName().equalsIgnoreCase(userTag.getTagName())) {
					tagMap.put(tag, Boolean.TRUE);
				}
			}
		}

		for (Entry<Tag, Boolean> tag : tagMap.entrySet()) {
			System.out.println(tag.getKey().getTagName() + " = " + tag.getValue());
		}
		model.addAttribute("tags", tagMap);
		model.addAttribute("user", user);
		return "subscribe";
	}

	@RequestMapping(value = "/subscribe", method = RequestMethod.POST)
	public String saveSubscription(@ModelAttribute("user") User user, Model model, Principal principal)
			throws BlogException {
		userService.setUserTags(user, principal);
		return "redirect:/landing";
	}

	@PostConstruct
	public void populateUsers() {
		User user = new User("Anil", "K C", "akc@mum.edu", "anealkeshi", "This is just a dummy profile");
		Credential credential = new Credential("admin", "admin", true);
		Set<UserRole> roles = new HashSet<UserRole>() {
			{
				add(new UserRole(credential, UserRoleType.ROLE_ADMIN.getValue()));
			}
		};
		credential.setUserRole(roles);
		user.setCredential(credential);
		userService.registerUser(user);

		User user1 = new User("Nitesh", "Basnet", "nitesh@mum.edu", "nitesh", "This is just a dummy profile");
		Credential credential1 = new Credential("blogger", "blogger", true);
		Set<UserRole> roles1 = new HashSet<UserRole>() {
			{
				add(new UserRole(credential1, UserRoleType.ROLE_BLOGGER.getValue()));
			}
		};
		credential1.setUserRole(roles1);
		user1.setCredential(credential1);
		userService.registerUser(user1);

		User user2 = new User("Jimmy", "Franco", "jimmy@mum.edu", "jimmy", "This is just a dummy profile");
		Credential credential2 = new Credential("reader", "reader", true);
		Set<UserRole> roles2 = new HashSet<UserRole>() {
			{
				add(new UserRole(credential2, UserRoleType.ROLE_READER.getValue()));
			}
		};
		credential2.setUserRole(roles2);
		user2.setCredential(credential2);
		userService.registerUser(user2);

		Post post = new Post("This is a dummy Post",
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
				user1);
		Tag tag = new Tag("Lorem Ipsum");
		tag.addUser(user1);
		tag.addPost(post);
		
		user1.addTag(tag);
		
		
		post.addTag(tag);
		
		postService.addPost(post);
		userService.updateUser(user1);
		
		
	}

}
