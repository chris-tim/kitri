<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/inc/summernote.jsp" %> 

<h2>파일 업로드 테스트</h2>
<form method="post" action="${ pageContext.request.contextPath }/kitri/uploadTest" enctype="multipart/form-data">
	<input type="text" name="replayTo" value="khala0017@gmail.com" placeholder="수신메일">
	<br>
	<button type="submit">전송</button>
</form>