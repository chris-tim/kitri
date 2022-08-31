<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="baseLink" value="${ pageContext.request.contextPath }/kitri" />

<div class="">
	<div>
		<c:forEach var="tap" items="${ nav }">
			<p style="display:inline-block; vertical-align:top; margin : auto 20px;">
				<c:out value="${tap.key}" />
				<br>
				<c:forEach var="page" items="${ tap.value }">
					<c:set var="link" value="${ baseLink }/${ page.path_value }/${ page.view_name }" />
					<a href="${ link }"> ${ page.name }</a>
					<br>
				</c:forEach>
			</p>
		</c:forEach>
	</div>
</div>
<footer>
	<p>
		<a href="${ baseLink }/">개인정보보호정책</a>
		|
		<a href="${ baseLink }/">이용약관</a>
		|
		<a href="${ baseLink }/">업무제휴신청</a>
		|
		<a href="${ baseLink }/">찾아오시는 길</a>
	</p>
</footer>