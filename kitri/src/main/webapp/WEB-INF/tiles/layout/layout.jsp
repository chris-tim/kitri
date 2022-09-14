<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no">
    
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/reset.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/base.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/global.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/responsive.css" />">
    
	<script type="text/javascript" src="<c:url value="/js/wemaginesoft.js" />"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-1.8.2.js" />"></script>
	<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type="text/javascript" src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	
    
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