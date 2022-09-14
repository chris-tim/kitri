<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="<c:url value="/plugin/slick/slick.min.js" />"></script>
<link rel="stylesheet" href="<c:url value="/plugin/slick/slick.css" />">
<link rel="stylesheet" href="<c:url value="/plugin/slick/slick-theme.css" />">

<script type="text/javascript">
	$(document).ready(function() {
		$('.main_slider').slick({
			autoplay : true,
			fade : true,
			dots : true,
			autoplaySpeed : 3000,
			speed : 1000
		});
		$('.footer_banner').slick({
			autoplay : true,
			fade : false,
			dots : true,
			arrows : false,
			autoplaySpeed : 3000,
			speed : 1000
		});
		$('.footer_partners').slick({
			slidesToShow : 7,
			slidesToScroll : 1,
			autoplay : true,
			arrows : true,
			pauseOnFocus : false,
			autoplaySpeed : 2000,
			responsive : [ {
				breakpoint : 768,
				settings : {
					arrows : false,
					slidesToShow : 4,
				}
			}, {
				breakpoint : 500,
				settings : {
					arrows : false,
					slidesToShow : 3,
				}
			} ]
		});
	});
</script>