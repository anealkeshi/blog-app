package com.anilkc.blog.domain.dao;

import com.anilkc.blog.domain.User;
import com.anilkc.blog.exception.UserException;

public interface UserDao extends BaseDao<User, Long> {

	User getUserByUsername(String username) throws UserException;

}
