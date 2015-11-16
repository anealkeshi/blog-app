package com.anilkc.blog.domain.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.dao.UserDao;

@Repository("userDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserDaoImpl extends BaseDaoImpl<User, Long>implements UserDao {

}
