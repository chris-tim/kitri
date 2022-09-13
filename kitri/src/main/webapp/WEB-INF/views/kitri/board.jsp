<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/inc/summernote.jsp" %>
    
<h2>공통 게시판 테스트</h2>
<form method="post" action="${ pageContext.request.contextPath }/kitri/boardTest" enctype="multipart/form-data" name="board">
	<input type="text" name="userName" value="작성자" placeholder="작성자">
	<br>
	<br>
	<input type="text" name="title" value="제목" placeholder="제목" />
	<br>
	<br>
	<input type="checkbox" id="head" name="head" value="1">
	<label for="head">머릿글</label>
	<br>
	<input type="checkbox" id="open" name="open" value="1" checked>
	<label for="open">공개여부</label>
	<br>
	<br>
	<textarea class="summernote" name="content" placeholder="내용"></textarea>
	<br>
	<br>
	<input type="file" name="attachments"> 첨부파일1
	<br>
	<br>
	<input type="file" name="attachments"> 첨부파일2
	<br>
	<br>
	<input type="file" name="attachments"> 첨부파일3
	<br>
	<br>
	<input type="file" name="attachments"> 첨부파일4
	<br>
	<br>
	<input type="file" name="attachments"> 첨부파일5
	<br>
	<br>
	<button type="submit">전송</button>
</form>