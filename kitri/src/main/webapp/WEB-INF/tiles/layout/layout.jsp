<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<script src="<c:url value="/js/jquery-1.8.2.js" />"></script>
	<tiles:insertAttribute name="head" />
</head>
<body>

	<header>
		<tiles:insertAttribute name="header" />
	</header>
	
	<div>
		<div>
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	
	<br>
	<br>
	<br>
	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>