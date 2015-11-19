package com.anilkc.blog.domain.service;

import com.anilkc.blog.domain.UserRole;
import com.anilkc.blog.exception.UserRoleException;

public interface UserRoleService {

	UserRole addUserRole(UserRole userRole);
	
	UserRole getUserRoleByRoleName(String roleName) throws UserRoleException;

}
