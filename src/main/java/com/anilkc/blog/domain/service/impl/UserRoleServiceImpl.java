package com.anilkc.blog.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anilkc.blog.domain.UserRole;
import com.anilkc.blog.domain.dao.UserRoleDao;
import com.anilkc.blog.domain.service.UserRoleService;
import com.anilkc.blog.exception.UserRoleException;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;

	public UserRole addUserRole(UserRole userRole) {
		return userRoleDao.add(userRole);
	}

	@Override
	public UserRole getUserRoleByRoleName(String roleName) throws UserRoleException {
		return userRoleDao.getUserRoleByRoleName(roleName);
	}

	

}
