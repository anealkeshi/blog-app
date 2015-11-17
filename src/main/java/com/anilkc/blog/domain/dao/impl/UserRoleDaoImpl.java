package com.anilkc.blog.domain.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.UserRole;
import com.anilkc.blog.domain.dao.UserRoleDao;

@Repository("userRoleDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserRoleDaoImpl extends BaseDaoImpl<UserRole, Long>implements UserRoleDao {

}
