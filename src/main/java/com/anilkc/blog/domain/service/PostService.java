package com.anilkc.blog.domain.service;

import java.util.List;

import com.anilkc.blog.domain.Post;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.exception.PostException;

public interface PostService {

	
	Post addPost(Post post);
	
	List<Post> getPostsByUser(User user);

	Post getPostById(Long postId) throws PostException;
}
