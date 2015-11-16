package com.anilkc.blog.domain.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Credential;
import com.anilkc.blog.domain.dao.CredentialDao;

/**
 * Spring Security Dependent class
 * 
 * @author Anil
 *
 */
@Repository("credentialDao")
@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class CredentialDaoImpl extends BaseDaoImpl<Credential, Long> implements CredentialDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public Credential findByUserName(String username) {

		List<Credential> credentials = new ArrayList<Credential>();

		Query query = sessionFactory.getCurrentSession().createQuery("from Credential where username=:username");
		query.setParameter("username", username);
		credentials = query.list();

		if (credentials.isEmpty()) {
			throw new UsernameNotFoundException("Credential not found with username: " + username);
		}

		return credentials.get(0);

	}

}