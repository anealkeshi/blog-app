<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<table style="width: 100%" border="1">
	<caption>Manage Users</caption>
		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Email</td>
				<td>Display Name</td>
				<td>Status</td>
				<td>Roles</td>
			</tr>
		</thead>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.displayName}</td>
				<td><input id="userStatus" type="checkbox"  <c:if test="${user.credential.enabled eq true}">checked="checked"</c:if>>
						<label for="userStatus">Active</label></td>
				<td><c:forEach items="${user.credential.userRole}" var="userRole">
						<input id="ROLE_ADMIN" type="checkbox" value="${ROLE_ADMIN}" onclick="changeUserRole(${user.id},event, 'ROLE_ADMIN')"  <c:if test="${userRole.role == 'ROLE_ADMIN'}">checked="checked"</c:if>>
						<label for="ROLE_ADMIN">ROLE_ADMIN</label>
						<br>
						<input id="ROLE_BLOGGER" type="checkbox" value="${ROLE_BLOGGER}" onclick="changeUserRole(${user.id},event, 'ROLE_BLOGGER')" <c:if test="${userRole.role == 'ROLE_BLOGGER'}">checked="checked"</c:if>>
						<label for="ROLE_BLOGGER">ROLE_BLOGGER</label>
						<br>
						<input id="ROLE_READER" type="checkbox" value="${ROLE_READER}" onclick="changeUserRole(${user.id},event, 'ROLE_READER')" <c:if test="${userRole.role == 'ROLE_READER'}">checked="checked"</c:if>>
						<label for="ROLE_READER">ROLE_READER</label>
					</c:forEach></td>
			</tr>
		</c:forEach>
	</table>
</div>