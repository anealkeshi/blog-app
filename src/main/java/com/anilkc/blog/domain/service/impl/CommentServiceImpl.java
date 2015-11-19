package com.anilkc.blog.domain.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Comment;
import com.anilkc.blog.domain.CommentStatus;
import com.anilkc.blog.domain.dao.CommentDao;
import com.anilkc.blog.domain.service.CommentService;
import com.anilkc.blog.exception.BlogException;

@Service("commentService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BlogException.class)
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public Comment saveUserComment(Comment comment) {
		comment.setCreatedDate(new Date());
		comment.setStatus(CommentStatus.PENDING);
		return commentDao.add(comment);
	}

	@Override
	public List<Comment> getRecentComment(Integer i) {
		return commentDao.getRecentComments(i);
	}


}
