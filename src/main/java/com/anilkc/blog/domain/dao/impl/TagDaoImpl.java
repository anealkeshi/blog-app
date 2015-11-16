package com.anilkc.blog.domain.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.Tag;
import com.anilkc.blog.domain.dao.TagDao;

@Repository("tagDao")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class TagDaoImpl extends BaseDaoImpl<Tag, Long>implements TagDao {

}
