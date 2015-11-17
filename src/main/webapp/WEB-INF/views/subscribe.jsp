<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
	<p>Subscribe to Tags available</p>
	<form:form action="subscribe" modelAttribute="user">
		<fieldset>
			<table>
				<c:forEach items="${tags}" var="tag">
					<tr>
						<td class="data"><form:checkbox path="tags" value="${tag.tagName}" label="${tag.tagName}" /> <form:errors
								path="tags" cssStyle="color:red;" /></td>
					</tr>
				</c:forEach>
				<tr>
					<td class="label"></td>

					<td class="data"><input type="submit" id="btnAdd" value="<spring:message code="register.add.btn"/>" /></td>
				</tr>
			</table>
		</fieldset>
	</form:form>
</div>