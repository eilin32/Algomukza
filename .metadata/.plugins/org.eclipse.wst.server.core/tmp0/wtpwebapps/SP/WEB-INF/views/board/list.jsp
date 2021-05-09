<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
 --><script>

	function doAction(boardNo) {
		 <c:if test="${ empty loginSucessVO }">
			if(confirm('로그인후 사용할수 있습니다\n로그인하시겠습니까?'))
				location.href = "${ pageContext.request.contextPath }/login";
		</c:if>
		
		<c:if test="${ not empty loginSucessVO }">
			location.href = "${ pageContext.request.contextPath }/board/" + boardNo;
		</c:if> 
		
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
			<header class="align-center">
				<h1>자유게시판</h1>

			</header>
			<br> <br>
			<div>
				<div style="float: right">
					<form>
						<ul class="actions">
							<li><select name="category" id="category">
									<option value="">제목+내용</option>
									<option value="1">제목만</option>
									<option value="1">글작성자</option>
							</select></li>
							<li><input type="text" name="name" id="name" value=""
								placeholder="Name" /></li>
							<li>
								<button type="submit" class="button">Search</button>
							</li>
						</ul>
					</form>

				</div>
				<article style="width: 100%;">
					<table>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>날짜</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>


							<c:forEach items="${ boardList }" var="board">
								<tr>
									<td>${ board.no }</td>
									<td><a href="${pageContext.request.contextPath }/board/${board.no}" style="text-decoration: none">${board.title }</a></td>
									<td>${ board.writer }</td>
									<td>${ board.regDate }</td>
									<td>${ board.viewCnt }</td>
								</tr>
							</c:forEach>


						</tbody>
					</table>
					<div style="float: right">
					<c:if test="${ not empty loginSucessVO }">
						<a href="${ pageContext.request.contextPath }/board/write"
							class="button small">글쓰기</a>
						 </c:if>
					</div>
				</article>

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



</body>

</html>
