<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<c:url value="/css/blog.css" var="appCss" />
<link rel="stylesheet" href="${appCss}">
<script src="<c:url value="/js/jquery-2.1.4.js" />"></script>
<script src="<c:url value="/js/blog.js" />"></script>

<title><tiles:insertAttribute name="title" /></title>


</head>

<body>
	<main id="container"> <header>
		<tiles:insertAttribute name="heading" />
	</header>

	<div id="main" class="centering">
		<section id="content">
			<tiles:insertAttribute name="body" />
		</section>

		
			<tiles:insertAttribute name="aside" />
	</div>

	<footer>
		<tiles:insertAttribute name="footer" />
	</footer> </main>
</body>
</html>
