<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<h2>User Registration</h2>
	<form:form action="register" modelAttribute="user">
		<fieldset>
			<table>
				<tr>
					<td class="label"><label for="firstName"><spring:message code="register.firsname.label" /></label></td>

					<td class="data"><form:input id="firstName" path="firstName" type="text" /> <form:errors path="firstName"
							cssStyle="color:red;" /></td>
				</tr>
				<tr>

					<td class="label"><label for="lastName"><spring:message code="register.lastname.label" /></label></td>

					<td class="data"><form:input id="lastName" path="lastName" type="text" /> <form:errors path="lastName"
							cssStyle="color:red;" /></td>
				</tr>
				<tr>

					<td class="label"><label for="email"><spring:message code="register.email.label" /></label></td>

					<td class="data"><form:input id="email" path="email" type="text" /> <form:errors path="email"
							cssStyle="color:red;" /></td>
				</tr>
				<tr>

					<td class="label"><label for="displayName"><spring:message code="register.displayName.label" /></label></td>

					<td class="data"><form:input id="displayName" path="displayName" type="text" /> <form:errors
							path="displayName" cssStyle="color:red;" /></td>
				</tr>
				<tr>

					<td class="label"><label for="userImage"><spring:message code="register.userimage.label" /></label></td>

					<td class="data"><form:input id="userImage" path="userImage" type="file" /></td>
				</tr>
				<tr>

					<td class="label"><label for="profile"><spring:message code="register.profile.label" /></label></td>

					<td class="data"><form:textarea id="profile" path="profile" type="text" /> <form:errors path="profile"
							cssStyle="color:red;" /></td>
				</tr>
				<tr>

					<td class="label"><label for="credential.username"><spring:message
								code="register.credential.username.label" /></label></td>

					<td class="data"><form:input id="credential.username" path="credential.username" type="text" /> <form:errors
							path="credential.username" cssStyle="color:red;" /></td>
				</tr>
				<tr>

					<td class="label"><label for="credential.password"><spring:message
								code="register.credential.password.label" /></label></td>

					<td class="data"><form:input id="credential.password" path="credential.password" type="password" /> <form:errors
							path="credential.password" cssStyle="color:red;" /></td>
				</tr>
				<tr>
					<td class="label"></td>

					<td class="data"><input type="submit" id="btnAdd" value="<spring:message code="register.add.btn"/>" /></td>
				</tr>
			</table>
		</fieldset>
	</form:form>
</div>