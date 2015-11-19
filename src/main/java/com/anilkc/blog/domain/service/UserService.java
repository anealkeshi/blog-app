package com.anilkc.blog.domain.service;

import java.security.Principal;
import java.util.List;

import com.anilkc.blog.domain.User;
import com.anilkc.blog.exception.BlogException;
import com.anilkc.blog.exception.UserException;

public interface UserService {

	User registerUser(User user);

	User updateUser(User user);

	User subscribeOnTags(User user);

	User getUserByUsername(String username) throws UserException;

	void setUserTags(User user, Principal principal) throws BlogException;
	
	List<User> getAllUsers();

	User getUserById(Long id);
}
