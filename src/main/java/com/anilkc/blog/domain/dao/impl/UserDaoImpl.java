package com.anilkc.blog.domain.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.dao.UserDao;
import com.anilkc.blog.exception.UserException;

@Repository("userDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserDaoImpl extends BaseDaoImpl<User, Long>implements UserDao {

	public User getUserByUsername(String username) throws UserException {
		Query query = currentSession().createQuery("SELECT u from User u where u.credential.username=:username");
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<User> user = query.list();

		if (user == null || user.isEmpty()) {
			throw new UserException("User not found with provided username: " + username);
		}

		return user.get(0);
	}

}
