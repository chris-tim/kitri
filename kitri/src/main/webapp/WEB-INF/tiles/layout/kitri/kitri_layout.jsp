<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>테스트</title>
	
	<script src="<c:url value="/resources/js/jquery-1.8.2.js" />"></script>
</head>
<body>

	<tiles:insertAttribute name="gnv" />
	
	<div>
		<div>
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<br>
	<br>
	<br>
	
	<tiles:insertAttribute name="footer" />
</body>
</html>