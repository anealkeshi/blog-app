package com.anilkc.blog.domain.service;

import java.security.Principal;
import java.util.List;

import com.anilkc.blog.domain.Comment;
import com.anilkc.blog.domain.Post;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.exception.BlogException;
import com.anilkc.blog.exception.PostException;

public interface PostService {

	
	Post addPost(Post post);
	
	List<Post> getPostsByUser(User user);

	Post getPostById(Long postId) throws PostException;
	
	Post updatePost(Post post);

	Post addUserCommentToPost(Long postId, Comment comment, Principal principal) throws BlogException;
	
	List<Post> getAll();
	
	List<Post> searchPostByTitle(String searchQuery);

	List<Post> getRecentPost(Integer number);
}
