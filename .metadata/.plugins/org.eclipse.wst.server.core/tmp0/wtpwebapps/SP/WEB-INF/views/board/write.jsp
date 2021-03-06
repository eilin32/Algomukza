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
<link href="<c:url value="/resources/assets/css/main.css" />"
	rel="stylesheet">
<jsp:include page="/WEB-INF/views/include/setting.jsp" />
<script>
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
			<h2>게시판 등록폼</h2>
			<form method="post"
				action="${ pageContext.request.contextPath }/board/write" name="inputForm"
				onsubmit="return checkForm()">

				<!--<div>
                <input type="file" name="file" id="exampleInputFile" placeholder="파일을 업로드" aria-describedby="fileHelp">
            </div>-->
				<table>
					<tr>
						<th width="23%">제목</th>
						<td><input type="text" name="title" size="80"
							autofocus="autofocus"></td>
					</tr>
					<tr>
						<th width="23%">글쓴이</th>
						<td>${loginSucessVO.id}</td>
					</tr>
					<tr>
						<th width="23%">내용</th>
						<td><textarea rows="5" cols="80" name="content"></textarea></td>
					</tr>
				</table>
				<button type="submit" style="float: right">save</button>
			</form>

		</div>
	</section>
	<br>
	<br>
	<br>
	<!-- Footer -->
	<footer>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</footer>

</body>
</html>
