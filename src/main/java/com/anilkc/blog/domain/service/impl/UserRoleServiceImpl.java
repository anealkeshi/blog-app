package com.anilkc.blog.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anilkc.blog.domain.UserRole;
import com.anilkc.blog.domain.dao.UserRoleDao;
import com.anilkc.blog.domain.service.UserRoleService;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;

	public UserRole addUserRole(UserRole userRole) {
		return userRoleDao.add(userRole);
	}
	

}
