package com.anilkc.blog.domain.dao;

import java.util.List;

import com.anilkc.blog.domain.Post;
import com.anilkc.blog.domain.User;

public interface PostDao extends BaseDao<Post, Long> {

	List<Post> getPostByUser(User user);

}
