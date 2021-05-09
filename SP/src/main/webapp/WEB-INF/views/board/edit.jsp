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
<title>게시판1</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href='<c:url value="/resources/assets/css/main.css" />'
	rel="stylesheet">
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
			location.href = "${ pageContext.request.contextPath }/board/${board.no}";
		});
	});
</script>
<script type="text/javascript">
	function checkForm() {
		var form = document.inputForm;

		if (!form.title.value) {
			alert('제목은 필수항목입니다');
			form.title.focus();
			return false;
		}

		if (!form.content.value) {
			alert('내용은 필수항목입니다');
			form.content.focus();
			return false;
		}

		return true;
	}
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
			<h2>게시판 수정</h2>
			<form method="post"
				action="${ pageContext.request.contextPath }/board/edit/${board.no}"
				name="inputForm" onsubmit="return checkForm()">

				<!--<div>
                <input type="file" name="file" id="exampleInputFile" placeholder="파일을 업로드" aria-describedby="fileHelp">
            </div>-->
				<table>
					<tr>
						<th width="23%">제목</th>
						<td><input type="text" value="${board.title }" name="title"
							size="80" autofocus="autofocus"></td>
					</tr>
					<tr>
						<th width="23%">글쓴이</th>
						<td><input type="text" name="writer" size="80"
							value="${loginSucessVO.id}" readonly></td>
					</tr>
					<tr>
						<th width="23%">내용</th>
						<td><textarea rows="5" cols="80" name="content">${board.content } </textarea></td>
					</tr>
				</table>
				<div style="float: right">	
					<button type="submit" class="button small">저장</button>
					<button type="button" class="button small" id="ChkBtn" data-toggle="modal" data-target="#chkModal" data-whatever="편집을 그만두고 이 페이지를 나가시겠습니까?">뒤로</button>
				</div>
			</form>

		</div>
	</section>

	<!-- Footer -->
	<footer>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</footer>

	<!-- Modal -->
	<jsp:include page="/WEB-INF/views/include/modal.jsp" />
</body>
</html>
