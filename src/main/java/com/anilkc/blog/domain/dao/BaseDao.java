package com.anilkc.blog.domain.dao;

import java.util.List;

public interface BaseDao<E, K> {

	E add(E entity);

	E update(E entity);

	E remove(E entity);

	E find(K key);

	List<E> list();

}
