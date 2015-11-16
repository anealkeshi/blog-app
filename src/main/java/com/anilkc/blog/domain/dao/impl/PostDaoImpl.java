package com.anilkc.blog.domain.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Post;
import com.anilkc.blog.domain.dao.PostDao;

@Repository("postDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class PostDaoImpl extends BaseDaoImpl<Post, Long>implements PostDao {

}