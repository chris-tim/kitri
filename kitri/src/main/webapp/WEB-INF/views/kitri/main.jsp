<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/inc/summernote.jsp" %> 

<h2>
	메인 페이지
</h2>

<form method="post" enctype="multipart/form-data">
	<textarea class="summernote"></textarea>
</form>

<br>
<img src="${ pageContext.request.contextPath }/resources/155548.jpg">