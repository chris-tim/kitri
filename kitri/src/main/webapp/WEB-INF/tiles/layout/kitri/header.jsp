<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="main_slider">
	<c:forEach var="slide" items="${ slider }">
		<div class="slider_box">
			<div class="slider_ab">
				<div class="slider_rel" style="background-image: url('${ slide.img }');">
					<div class="visual_main_copy">
						<div>
							<c:out value="${ slide.mainCopy }" />
						</div>
						<div>
							<c:out value="${ slide.subCopy }" />
						</div>
					</div>
					<div class="visual_main_con_wrap">
						<div class="visual_main_con_tit">
							<c:out value="${ slide.contentTitle }" />
						</div>
						<div class="visual_main_con cl">
							<div class="visual_main_con_txt">
								${ slide.contentText }
							</div>
							<c:if test='${ slide.link ne null && slide.link ne ""}'>
								<div class="visual_main_con_btn" onclick="location.href='<c:out value="${ slide.link }" />';" >more</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>