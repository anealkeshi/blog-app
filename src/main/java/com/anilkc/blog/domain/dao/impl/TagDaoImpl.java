package com.anilkc.blog.domain.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.dao.TagDao;
import com.anilkc.blog.exception.TagException;

@Repository("tagDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class TagDaoImpl extends BaseDaoImpl<Tag, Long>implements TagDao {

	public Tag findTagByName(String tagName) throws TagException {
		Query query = currentSession().createQuery("SELECT t from Tag t where t.tagName=:tagName");
		query.setParameter("tagName", tagName);
		@SuppressWarnings("unchecked")
		List<Tag> tag = query.list();

		if (tag == null || tag.isEmpty()) {
			throw new TagException("Tag not found with provided tagName: " + tagName);
		}

		return tag.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> getUserTags(User user) {
		System.out.println(user.getTags());
		Query query = currentSession().createQuery("SELECT t from Tag t join User us where us.credential.username=:username");
		query.setParameter("username", user.getCredential().getUsername());
		return query.list();
	}

}
