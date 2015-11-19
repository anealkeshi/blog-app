package com.anilkc.blog.domain.dao;

import com.anilkc.blog.domain.UserRole;
import com.anilkc.blog.exception.UserRoleException;

public interface UserRoleDao extends BaseDao<UserRole, Long> {

	UserRole getUserRoleByRoleName(String roleName) throws UserRoleException;
	
}
