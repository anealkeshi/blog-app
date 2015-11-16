package com.anilkc.blog.domain.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anilkc.blog.domain.service.TagService;
import com.anilkc.blog.exception.BlogException;

@Service("tagService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = BlogException.class)
public class TagServiceImpl implements TagService {

}
