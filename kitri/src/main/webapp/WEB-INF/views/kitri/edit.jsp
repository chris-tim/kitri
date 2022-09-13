<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/inc/summernote.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ boardData.head > 0 }">
	<c:set var="head" value="checked" />
</c:if>

<c:if test="${ boardData.open > 0 }">
	<c:set var="open" value="checked" />
</c:if>


<h2>수정 테스트</h2>
<form method="post" action="${ pageContext.request.contextPath }/kitri/editTest" enctype="multipart/form-data" name="edit">

	<input type="text" hidden="hidden" name="bid" value="${ boardData.bid }">

	<input type="text" name="userName" placeholder="작성자" value="${ boardData.userName }">
	<br>
	<br>
	<input type="text" name="title" placeholder="제목" value="${ boardData.title }" />
	<br>
	<br>
	<input type="checkbox" id="head" name="head" value="1" ${ head }>
	<label for="head">머릿글</label>
	<br>
	<input type="checkbox" id="open" name="open" value="1" ${ open }>
	<label for="open">공개여부</label>
	<br>
	<br>
	<textarea class="summernote" name="content" placeholder="내용">${ boardData.content }</textarea>
	<br>
	<br>
	첨부파일1 <input type="file" name="attachments">
	<br>
	<c:if test="${ boardData.file1 != null }">
		<a href="${ boardData.file1 }" target="_blank">확인</a>
		<br>
	</c:if>
	<br>
	첨부파일2 <input type="file" name="attachments">
	<br>
	<c:if test="${ boardData.file2 != null }">
		<a href="${ boardData.file2 }" target="_blank">확인</a>
		<br>
	</c:if>
	<br>
	첨부파일3 <input type="file" name="attachments">
	<br>
	<c:if test="${ boardData.file3 != null }">
		<a href="${ boardData.file3 }" target="_blank">확인</a>
		<br>
	</c:if>
	<br>
	첨부파일4 <input type="file" name="attachments">
	<br>
	<c:if test="${ boardData.file4 != null }">
		<a href="${ boardData.file4 }" target="_blank">확인</a>
		<br>
	</c:if>
	<br>
	첨부파일5 <input type="file" name="attachments">
	<br>
	<c:if test="${ boardData.file5 != null }">
		<a href="${ boardData.file5 }" target="_blank">확인</a>
		<br>
	</c:if>
	<br>
	<button type="submit">전송</button>
</form>