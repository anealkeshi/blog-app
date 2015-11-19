<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<aside>
	<h2>Search</h2>
	<div>
		<c:url value="/blogger/post/search/" var="searchUrl" />
		<form:form action="${searchUrl}" method="GET">
			<input type="text" id="searchbox" onBlur="if (this.value == '') {this.value = 'search...';}"
				onFocus="if (this.value == 'search...') {this.value = '';}" value="search..." name="search" />
			<input id="searchbutton" type="submit" value=" " />
		</form:form>
	</div>
	<h2>Categories</h2>
	<ul>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Articles</a>
				<p class="popup">Just some web related stuff.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Freebies</a>
				<p class="popup">Everything we want to give away, it is free go on take it.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Personal</a>
				<p class="popup">All our site updates and personal interests.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Resources</a>
				<p class="popup">Tools, Fonts, Plug-ins, Add-ons, Downloads, and more.</p>
			</div>
		</li>
		<li>
			<div class="bubbleInfo">
				<a href="#" class="trigger">Tutorials</a>
				<p class="popup">Learn from our tutorials, tricks, tips, and more.</p>
			</div>
		</li>
	</ul>
	<h2>Popular Posts</h2>
	<ul>
		<c:forEach items="${recentPosts}" var="post">
			<li>
				<div class="bubbleInfo">
					<a href='<c:url value="/blogger/post/${post.id}/" />' class="trigger">${post.title}</a>
					<p class="popup">This is a post with ${fn:length(post.comments)} comments.</p>
				</div>
			</li>
		</c:forEach>
	</ul>
	<h2>Recent Comments</h2>
	<ul class="recent-comment">
		<c:forEach items="${recentComments}" var="comment">
			<li>
				<div class="bubbleInfo">
					<a href="#"><img src='<c:url value="/images/avatar.gif" />'></a> <a href='<c:url value="/blogger/post/${post.id}/" />' class="trigger">${fn:substring(comment.content, 0, 50)}"</a> <span class="commenter">- ${comment.author.displayName} @ ${comment.createdDate}</span>
					<p class="popup">"This is one of the most recent comments to a post"</p>
				</div>
			</li>
		</c:forEach>
	</ul>
</aside>
<!-- End Aside !-->

