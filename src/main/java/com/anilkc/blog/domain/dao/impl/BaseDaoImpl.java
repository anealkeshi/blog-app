package com.anilkc.blog.domain.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.dao.BaseDao;

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public abstract class BaseDaoImpl<E, K extends Serializable> implements BaseDao<E, K> {

	private SessionFactory sessionFactory;
	protected Class<? extends E> type;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		type = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public E add(E entity) {
		currentSession().save(entity);
		return entity;
	}

	public E update(E entity) {
		currentSession().saveOrUpdate(entity);
		return entity;
	}

	public E remove(E entity) {
		currentSession().delete(entity);
		return entity;
	}

	public E find(K key) {
		return (E) currentSession().get(type, key);
	}

	@SuppressWarnings("unchecked")
	public List<E> list() {
		return currentSession().createCriteria(type).list();
	}
}