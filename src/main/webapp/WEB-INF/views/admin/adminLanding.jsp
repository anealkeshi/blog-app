<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<p>Admin Landing</p>
	
	
	<a href="<c:url value="/admin/manageUsers"/>" >Manage Users</a>
	
	<a href="<c:url value="/admin/managePosts"/>" >Manage Posts</a>
	
	<a href="<c:url value="/admin/manageTags"/>" >Manage Tags</a>
</div>