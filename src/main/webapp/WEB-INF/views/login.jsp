<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<div id="login-box" onload='document.loginForm.username.focus();'>

	<h3><spring:message	code="login.with.username" /></h3>

	<c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>

	<form name='loginForm'
		action="<c:url value='/j_spring_security_check' />" method='POST'>

		<table>
			<tr>
				<td><spring:message	code="login.username" />:</td>
				<td><input type='text' name='username'></td>
			</tr>
			<tr>
				<td><spring:message	code="login.password" />:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value='<spring:message code="login.btn"/>'/></td>
			</tr>
		</table>

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

	</form>
</div>