<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div align="center">
	<h2>Blogger Landing</h2>

	<a href='<c:url value="/blogger/" />'>Blogger Home</a>

	<article class="post">
		<div class="post-title">
			<h2>
				<a href="<c:url value="/blogger/post/${post.id}/" />">${post.title}</a>
			</h2>
		</div>
		<p class="date">
			<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${post.createdDate}" />
			, Author: <a href="#">${post.author.displayName}</a>
		</p>
		<a href="#"><img src="<c:url value="/images/preview.jpg" />" class="thumb" /></a>
		<div>
			<p>${post.content}</p>
		</div>
		<hr />
	</article>
</div>