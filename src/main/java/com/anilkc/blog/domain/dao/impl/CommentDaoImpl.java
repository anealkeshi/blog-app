package com.anilkc.blog.domain.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Comment;
import com.anilkc.blog.domain.dao.CommentDao;

@Repository("commentDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class CommentDaoImpl extends BaseDaoImpl<Comment, Long>implements CommentDao {

		@SuppressWarnings("unchecked")
		@Override
		public List<Comment> getRecentComments(Integer limit){
			Query query = currentSession().createQuery("SELECT distinct c from Comment c order by c.createdDate DESC");
			query.setFirstResult(0).setMaxResults(limit);
			return query.list();
		}

}
