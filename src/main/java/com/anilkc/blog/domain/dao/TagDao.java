package com.anilkc.blog.domain.dao;

import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.exception.TagException;

public interface TagDao extends BaseDao<Tag, Long> {

	Tag findTagByName(String tagName) throws TagException;

}
