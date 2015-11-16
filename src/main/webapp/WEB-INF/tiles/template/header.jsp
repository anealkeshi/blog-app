<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div class="centering">
	<a href="<spring:url value="/"></spring:url>"> <img src='<spring:url value="/images/blog.png"></spring:url>'
		alt="Blog" height="50" width="100">
	</a>
	<security:authorize access="isAuthenticated()">
					
  					Welcome username :  ${pageContext.request.userPrincipal.name}
  					
  					<br />
		<a href='<spring:url value="/doLogout"></spring:url>'>Logout</a>

	</security:authorize>
	<security:authorize access="isAnonymous()">
		<div class="header-login" style="color: #339900">
			<a href="<spring:url value="/registration"/>"> <spring:message code="register.add.btn" />
			</a>| <a href="<spring:url value="/login"></spring:url>"><spring:message code="login.btn">
				</spring:message></a>
		</div>
	</security:authorize>
	<div class="language">
		<spring:message code="language" />
		: <a href="?lang=en_US">English</a> | <a href="?lang=np_NP">Nepali</a>
	</div>
	<nav>
		<ul>
			<li><a href="#"><spring:message code="nav.home" /></a></li>
			<li><a href="#"><spring:message code="nav.about.us" /></a></li>
			<li><a href="#"><spring:message code="nav.contact" /></a></li>
		</ul>
	</nav>
</div>
