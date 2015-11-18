package com.anilkc.blog.domain.dao;

import java.util.List;

import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.exception.TagException;

public interface TagDao extends BaseDao<Tag, Long> {

	Tag findTagByName(String tagName) throws TagException;

	List<Tag> getUserTags(User user);

}
