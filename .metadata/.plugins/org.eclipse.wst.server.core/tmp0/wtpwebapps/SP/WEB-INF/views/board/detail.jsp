<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Intensify by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>

<head>
<title>게시판글쓰기</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<jsp:include page="/WEB-INF/views/include/setting.jsp" />

<script>

	$(document).ready(function() {

		$('#chkModal').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var rep = button.data('whatever') // Extract info from data-* attributes
			// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			var modal = $(this)
			modal.find('#content').text(rep)
		})
			
		$('#OK').click(function() {
			// 동기식 삭제
			// location.href = "${ pageContext.request.contextPath }/board/remove/${board.no}"; 

			// 비동기 삭제
			$.ajax({
				type : "delete",
				url : "${ pageContext.request.contextPath }/board/${ board.no }",
				success : function(data) {
					let jsonData = JSON.parse(data);
					if (jsonData.flag) {
						location.href = "${ pageContext.request.contextPath }/board";
					}
				}
			});
		}); 
	});
	
</script>
</head>

<body class="subpage">

	<!-- Header -->
	<header>
		<jsp:include page="/WEB-INF/views/include/top.jsp" />
	</header>

	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="inner">
			<header>
				<h3>${ board.title }</h3>
				<p style="float: right">${ board.regDate}</p>
				<p>조회수 : ${board.viewCnt }</p>
			</header>

			<p>${ board.content }</p>

			<hr class="major" />
			<div style="float: right">
				<a href="${ pageContext.request.contextPath }/board/write"
					class="button small">글쓰기</a> <a
					href="${ pageContext.request.contextPath }/board/edit/${board.no}"
					class="button small">수정</a>
				<button class="button small"
					data-toggle="modal" data-target="#chkModal" data-whatever="정말 이 게시물을 삭제하시겠습니까?">삭제</button>
				<a href="${ pageContext.request.contextPath }/board"
					class="button small">목록으로</a>
			</div>

		</div>
	</section>
	<br>
	<br>
	<br>
	<!-- Footer -->
	<footer>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</footer>

	<!-- Modal -->
	<jsp:include page="/WEB-INF/views/include/modal.jsp" />
</body>
</html>
