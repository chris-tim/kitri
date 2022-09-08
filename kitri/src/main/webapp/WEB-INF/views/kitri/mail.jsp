<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/inc/summernote.jsp" %>

<h2>메일 전송 테스트</h2>

<form action="${ pageContext.request.contextPath }/admin/mailSend" method="post" name="mail" enctype="multipart/form-data">
	<input type="text" name="replayTo" value="khala0017@gmail.com" placeholder="수신메일">
	<br>
	<input type="text" name="fromName" value="스프링 테스트" placeholder="발송자이름">
	<br>
	<input type="text" name="to" value="hsyeom@wemaginesoft.co.kr" placeholder="받는사람">
	<br>
	<input type="text" name="to" value="khala0017@gmail.com" placeholder="받는사람">
	<br>
	<input type="text" name="cc" value="hsyeom@wemaginesoft.co.kr" placeholder="참조자">
	<br>
	<input type="text" name="cc" value="khala0017@gmail.com" placeholder="참조자">
	<br>
	<input type="text" name="bcc" value="hsyeom@wemaginesoft.co.kr" placeholder="숨은참조">
	<br>
	<input type="text" name="bcc" value="khala0017@gmail.com" placeholder="숨은참조">
	<br>
	<input type="text" name="subject" value="스프링 테스트" placeholder="제목">
	<br>
	<input type="checkbox" id="simple" name="simple" value="1">
	<label for="simple">단순 텍스트</label>
	<br>
	<input type="file" name="attachments">
	<input type="file" name="attachments">
	<input type="file" name="attachments">
	
	<br>
	<textarea class="summernote" name="content"></textarea>
	<br>
	<button type="submit">전송</button>
</form>