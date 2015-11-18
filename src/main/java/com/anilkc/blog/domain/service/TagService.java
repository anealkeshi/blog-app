package com.anilkc.blog.domain.service;

import java.util.List;

import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.exception.TagException;

public interface TagService {

	List<Tag> getAll();
	
	Tag getTagByName(String tagName) throws TagException;
	
	Tag addtag(Tag tag);

	List<Tag> getUserTags(User user);

}
