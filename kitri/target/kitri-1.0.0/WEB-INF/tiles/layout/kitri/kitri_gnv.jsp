<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="baseLink" value="${ pageContext.request.contextPath }/kitri" />


<h1>변경 전</h1>

<div>
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
