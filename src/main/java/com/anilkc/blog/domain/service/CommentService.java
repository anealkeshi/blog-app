package com.anilkc.blog.domain.service;

import java.util.List;

import com.anilkc.blog.domain.Comment;

public interface CommentService {

	
	Comment saveUserComment(Comment comment);

	List<Comment> getRecentComment(Integer i);
}
