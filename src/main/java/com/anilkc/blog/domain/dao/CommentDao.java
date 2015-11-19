package com.anilkc.blog.domain.dao;

import java.util.List;

import com.anilkc.blog.domain.Comment;

public interface CommentDao extends BaseDao<Comment, Long>{

	List<Comment> getRecentComments(Integer i);

}
