package com.anilkc.blog.domain.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Post;
import com.anilkc.blog.domain.User;
import com.anilkc.blog.domain.dao.PostDao;

@Repository("postDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class PostDaoImpl extends BaseDaoImpl<Post, Long>implements PostDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getPostByUser(User user) {
		Query query = currentSession().createQuery("SELECT p from Post p where p.author.credential.username=:username");
		query.setParameter("username", user.getCredential().getUsername());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> searchPostByTitle(String searchQuery) {
		Query query = currentSession().createQuery("SELECT p from Post p where p.title like :searchQuery");
		query.setParameter("searchQuery", "%" + searchQuery + "%");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getPostFromDate(Integer limit){
		Query query = currentSession().createQuery("SELECT distinct p from Post p order by p.createdDate DESC");
		query.setFirstResult(0).setMaxResults(limit);
		return query.list();
	}

}
