package com.anilkc.blog.domain.service.impl;

import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.UserRole;
import com.anilkc.blog.domain.UserRoleType;
import com.anilkc.blog.domain.dao.UserDao;
import com.anilkc.blog.domain.service.TagService;
import com.anilkc.blog.domain.service.UserRoleService;
import com.anilkc.blog.domain.service.UserService;
import com.anilkc.blog.exception.BlogException;
import com.anilkc.blog.exception.UserException;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BlogException.class)
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource(name = "userDao")
	private UserDao userDao;

	@Resource(name = "userRoleService")
	private UserRoleService userRoleService;

	@Autowired
	private TagService tagService;

	public User registerUser(User user) {
		user.setCreatedOn(new Date());
		user.getCredential().setEnabled(true);

		// Set user role
		//UserRole userRole = new UserRole(user.getCredential(), UserRoleType.ROLE_ADMIN.getValue());
		//user.getCredential().addUserRole(userRole);

		return userDao.add(user);

	}

	public User updateUser(User user) {
		return userDao.update(user);
	}

	public User subscribeOnTags(User user) {
		return userDao.update(user);
	}

	public User getUserByUsername(String username) throws UserException {
		return userDao.getUserByUsername(username);
	}

	public void setUserTags(User user, Principal principal) throws BlogException {
		User savedUser = getUserByUsername(principal.getName());
		Set<Tag> tags = new HashSet<Tag>();
		for (Tag tag : user.getTags()) {
			tags.add(tagService.getTagByName(tag.getTagName()));
		}
		savedUser.setTags(tags);
		updateUser(savedUser);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.list();
	}

}
