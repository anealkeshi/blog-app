package com.anilkc.blog.domain.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.anilkc.blog.domain.Credential;

/**
 * Spring Security Dependent class
 * 
 * @author Anil
 *
 */
public interface CredentialService extends UserDetailsService{


	Credential updateCredential(Credential credential);
}
