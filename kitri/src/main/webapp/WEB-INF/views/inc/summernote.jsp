<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/plugin/summernote/summernote-lite.js" />"></script>
<script src="<c:url value="/plugin/summernote/summernote-ko-KR.js" />"></script>
<link rel="stylesheet" href="<c:url value="/plugin/summernote/summernote-lite.css" />">

<script>
$(document).ready(function(){
	$('.summernote').summernote({
		toolbar: [
		['fontname', ['fontname']],
		['fontsize', ['fontsize']],
		['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
		['color', ['forecolor','color']],
		['table', ['table']],
		['para', ['ul', 'ol', 'paragraph']],
		['height', ['height']],
		['insert',['picture','link','video']],
		['view', ['fullscreen', 'help']]
		 ],
		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
		lineHeights: ['0.2', '0.3', '0.4', '0.5', '0.6', '0.8', '1.0', '1.2', '1.4', '1.5', '2.0', '3.0'],
		height:550,
		lang : "ko-KR",
		spellCheck : false,
		callbacks:{
			onImageUpload: function(files) {
				editor = $(this);
				summernoteImageUpload(files[0], editor);
			}
		}
	});
});


function summernoteImageUpload(file, editor) {
	data = new FormData();
	data.append("file", file);
	$.ajax({
		data : data,
		type : "POST",
		url : '<c:url value="/summernote_image_upload" />',
		contentType : false,
		processData : false,
		success : function (data) {
			$(editor).summernote('insertImage', data.url);
		}
	});
}
</script>