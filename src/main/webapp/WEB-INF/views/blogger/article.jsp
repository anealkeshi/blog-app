<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div align="center">
	<h2>Blogger Landing</h2>

	<a href='<c:url value="/" />'>Home</a>

	<article class="post">
		<div class="post-title">
			<h2>
				<a href="<c:url value="/blogger/post/${post.id}/" />">${post.title}</a>
			</h2>
		</div>
		<div class="comment-box"><a href="<c:url value="/blogger/post/${post.id}/" />">${fn:length(post.comments)}</a></div>
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
	<section>
		<h2>Comments</h2>
		<div class="bubble-list">
			<div class="bubble clearfix">
				<a href="#"><img src='<c:url value="/images/avatar.gif" />'></a>
				<div class="bubble-content">
					<div class="point"></div>
					<p>This is one static comment. You can comment below.</p>
				</div>
			</div>
		</div>
		<c:forEach items="${post.comments}" var="comm">
			<div class="bubble-list">
				<div class="bubble clearfix">
					<a href="#"><img src='<c:url value="/images/avatar.gif" />'></a>
					<div class="bubble-content">
						<div class="point"></div>
						<p>${comm.content} <span style="color: blue;">- <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${comm.createdDate}" />
			, by : <a href="#">${comm.author.displayName}</a></span></p>
					</div>
				</div>
			</div>

		</c:forEach>

		<c:url value="/blogger/post/${post.id}/comment" var="commentAction" />
		<form:form action="${commentAction}" modelAttribute="comment">
			<fieldset>
				<a href="#"><img src='<c:url value="/images/avatar.gif" />'></a>
				<div class="point"></div>
				<form:textarea id="comment" path="content" type="text" />
				<form:errors path="content" cssStyle="color:red;" />
				<input type="submit" id="btnAdd" value="<spring:message code="comment.btn"/>" />
			</fieldset>
		</form:form>
	</section>
</div>