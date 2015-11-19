<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div align="center">
	<h2>Articles</h2>

	<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_BLOGGER')">
		<a href='<c:url value="/blogger/post" />'>Create Post</a>
		<a href='<c:url value="/subscribe" />'>Manage Subscription</a>
	</security:authorize>

	<c:if test="${fn:length(posts) eq 0}">
		<h3>No posts to show</h3>
	</c:if>

	<c:forEach items="${posts}" var="post">
		<article class="post">
			<div class="post-title">
				<h2>
					<a href="<c:url value="/blogger/post/${post.id}/" />">${post.title}</a>
				</h2>
			</div>
			<div class="comment-box">
				<a href="<c:url value="/blogger/post/${post.id}/" />">${fn:length(post.comments)}</a>
			</div>
			<p class="date">
				<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${post.createdDate}" />
				, Author: <a href="#">${post.author.displayName}</a>
			</p>
			<a href="#"><img src="<c:url value="/images/preview.jpg" />" class="thumb" /></a>
			<div>
				<p>${post.content}</p>
			</div>
			<a href='<c:url value="/blogger/post/${post.id}/" />' class="more-link"><span class="fullpost">Read more
					&raquo;</span></a>
			<hr />
		</article>
	</c:forEach>
</div>