package com.anilkc.blog.domain.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Comment;
import com.anilkc.blog.domain.dao.CommentDao;

@Repository("commentDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class CommentDaoImpl extends BaseDaoImpl<Comment, Long>implements CommentDao {

}
