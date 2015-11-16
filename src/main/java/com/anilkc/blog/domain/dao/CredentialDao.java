package com.anilkc.blog.domain.dao;

import com.anilkc.blog.domain.Credential;

public interface CredentialDao extends BaseDao<Credential, Long> {

	Credential findByUserName(String username);

}