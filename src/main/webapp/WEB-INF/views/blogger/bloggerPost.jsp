<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div align="center">
	<h2>Post Article</h2>

	<form:form action="post" modelAttribute="post">
		<fieldset>
			<table>
				<tr>
					<td class="label"><label for="title"><spring:message code="post.title.label" />:</label></td>

					<td class="data"><form:input id="title" path="title" type="text" /> <form:errors path="title"
							cssStyle="color:red;" /></td>
				</tr>
				<tr>

					<td class="label"><label for="content"><spring:message code="post.content.label" />:</label></td>

					<td class="data"><form:input id="content" path="content" type="text" /> <form:errors path="content"
							cssStyle="color:red;" /></td>
				</tr>
				<tr>
				<tr>
					<td class="label"></td>

					<td class="data"><input type="submit" id="btnAdd" value="<spring:message code="post.add.btn"/>" /></td>
				</tr>
			</table>
		</fieldset>
	</form:form>
</div>