package com.anilkc.blog.domain.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Credential;
import com.anilkc.blog.domain.UserRole;
import com.anilkc.blog.domain.dao.CredentialDao;
import com.anilkc.blog.domain.service.CredentialService;
import com.anilkc.blog.exception.BlogException;

/**
 * Spring Security Dependent class
 * 
 * @author Anil
 *
 */
@Service("credentialService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BlogException.class)
public class CredentialServiceImpl implements CredentialService {

	@Autowired
	@Qualifier("credentialDao")
	private CredentialDao credentialDao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		com.anilkc.blog.domain.Credential user = credentialDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

		return buildUserForAuthentication(user, authorities);

	}

	// Converts com.anilkc.blog.domain.Credential credential to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.anilkc.blog.domain.Credential credential, List<GrantedAuthority> authorities) {
		return new User(credential.getUsername(), credential.getPassword(), credential.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	@Override
	public Credential updateCredential(Credential credential) {
		return credentialDao.update(credential);
	}

}
