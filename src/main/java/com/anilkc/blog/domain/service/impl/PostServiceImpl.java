package com.anilkc.blog.domain.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Post;
import com.anilkc.blog.domain.PostStatus;
import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.dao.PostDao;
import com.anilkc.blog.domain.service.PostService;
import com.anilkc.blog.domain.service.TagService;
import com.anilkc.blog.exception.BlogException;
import com.anilkc.blog.exception.PostException;

@Service("postService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BlogException.class)
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;
	
	@Autowired
	private TagService tagService;
	
	@Override
	public Post addPost(Post post) {
		post.setStatus(PostStatus.PENDING);
		post.setCreatedDate(new Date());
		for (Tag tag : post.getTags()) {
			tagService.addtag(tag);
		}
		return postDao.add(post);
	}

	@Override
	public List<Post> getPostsByUser(User user) {
		return postDao.getPostByUser( user);
	}

	@Override
	public Post getPostById(Long postId) throws PostException {
		Post post = postDao.find(postId);
		if(post == null){
			throw new PostException("Post not found with provided id: " + postId);
		}
		
		return post;
	}

}
