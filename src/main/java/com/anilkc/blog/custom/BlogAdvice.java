package com.anilkc.blog.custom;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.anilkc.blog.domain.service.CommentService;
import com.anilkc.blog.domain.service.PostService;

@Aspect
@Component
public class BlogAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogAdvice.class);
	
	@Autowired
	private PostService postService;

	@Autowired
	private CommentService commentService;

	@Before(value = "@within(com.anilkc.blog.custom.LogBeforeMethod) || @annotation(com.anilkc.blog.custom.LogBeforeMethod)")
	public void logBefore(JoinPoint joinPoint) {
		LOGGER.info("Method Name :" + joinPoint.getSignature().toShortString() + "| Args => "
				+ Arrays.asList(joinPoint.getArgs()));
	}

	@Around(value = "@within(com.anilkc.blog.custom.AsidePass) || @annotation(com.anilkc.blog.custom.AsidePass)")
	public Object handleAsidePass(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();

		if (args != null) {
			for (Object object : args) {
				if(object instanceof Model){
					Model model = (Model) object;
					model.addAttribute("recentPosts", postService.getRecentPost(5));
					model.addAttribute("recentComments", commentService.getRecentComment(5));
				}
			}
		}
		Object obj = pjp.proceed();
		return obj;
	}
}
