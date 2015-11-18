package com.anilkc.blog.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.dao.TagDao;
import com.anilkc.blog.domain.service.TagService;
import com.anilkc.blog.exception.BlogException;
import com.anilkc.blog.exception.TagException;

@Service("tagService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BlogException.class)
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;

	public List<Tag> getAll() {
		return tagDao.list();
	}

	public Tag getTagByName(String tagName) throws TagException {
		return tagDao.findTagByName(tagName);
	}

	@Override
	public Tag addtag(Tag tag) {
		return tagDao.add(tag);
	}

	@Override
	public List<Tag> getUserTags(User user) {
		return tagDao.getUserTags(user);
	}

}
