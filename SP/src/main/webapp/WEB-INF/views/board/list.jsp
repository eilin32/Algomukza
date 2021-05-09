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
 -->
<style>
section {
	background-image: url("./resources/images/aa.jpg");
}
</style>
<script>
	function doAction(boardNo,url) {
		<c:if test="${ empty loginSucessVO }">
		if (confirm('로그인후 사용할수 있습니다\n로그인하시겠습니까?'))
			location.href = "${ pageContext.request.contextPath }/login";
		</c:if>

		<c:if test="${ not empty loginSucessVO }">
		location.href = "${ pageContext.request.contextPath }/board/" + boardNo;
		</c:if>

	}
	function doAction2(url) {
		<c:if test="${ empty loginSucessVO }">
		if (confirm('로그인후 사용할수 있습니다\n로그인하시겠습니까?'))
			location.href = "${ pageContext.request.contextPath }/login";
		</c:if>

		<c:if test="${ not empty loginSucessVO }">
		location.href = url;
		</c:if>

	}
	function list(page) {
		console.log(page);
		location.href = "${pageContext.request.contextPath}/board?curPage="
				+ page + "&name=${map.name}" + "&category=${map.category}";
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
				<!-- <div style="float: left">
				<p>총  개의 게시물</p>
				</div> -->
				<div style="float: right">
					<form action="${pageContext.request.contextPath}/board"
						method="POST">
						<ul class="actions">
							<li><select name="category" id="category"
								style="background-color: rgba(255, 255, 255, 0.55)">
									<option value="titlecontent">제목+내용</option>
									<option value="title">제목만</option>
									<option value="writer">글작성자</option>
							</select></li>

							<li><input type="text" name="name" id="name" value=""
								placeholder="전체검색"
								style="background-color: rgba(255, 255, 255, 0.55)" /></li>
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
								<th width="7%">번호</th>
								<th>제목</th>
								<th width="13%">작성자</th>
								<th width="20%">날짜</th>
								<th width="7%">조회수</th>
							</tr>
						</thead>
						<tbody>

							<c:choose>
								<c:when test="${ empty map.boardList }">

									<tr>
										<td colspan="5" style="text-align: center">게시물이 없습니다</td>
									</tr>
								</c:when>
								<c:otherwise>

									<c:forEach items="${ map.boardList }" var="list">
										<tr>
											<td>${ list.no }</td>
											<td><a href="#" onclick="doAction(${list.no})"
												style="text-decoration: none">${list.title } <c:if
														test="${list.reCnt>0 }">
														<span>(${list.reCnt})</span>
													</c:if>
											</a></td>
											<td>${ list.writer }</td>
											<td>${ list.regDate }</td>
											<td>${ list.viewCnt }</td>
										</tr>
									</c:forEach>

								</c:otherwise>
							</c:choose>
							<tr>
								<td colspan="5" style="text-align: center"><c:if
										test="${map.boardPager.curBlock > 1 }">
										<a href="javascript:list('1')">[처음]</a>
									</c:if> <c:if test="${map.boardPager.curBlock>1 }">
										<a href="javascript:list('${map.boardPager.prevPage }')">[이전]</a>

									</c:if> <c:forEach var="num" begin="${map.boardPager.blockBegin }"
										end="${map.boardPager.blockEnd}">
										<c:choose>
											<c:when test="${num==map.boardPager.curPage }">
												<span style="color: red">${num}</span>
											</c:when>
											<c:otherwise>
												<a href="javascript:list('${num }')">${num }</a>
											</c:otherwise>
										</c:choose>

									</c:forEach> <c:if
										test="${map.boardPager.curBlock <=map.boardPager.totBlock }">
										<a href="javascript:list('${map.boardPager.nextPage}')">[다음]</a>
									</c:if> <c:if
										test="${map.boardPager.curPage <=map.boardPager.totPage }">
										<a href="javascript:list('${map.boardPager.totPage}')">[끝]</a>
									</c:if></td>

							</tr>

						</tbody>
					</table>
					<div style="float: right">

						<a href="#"
							onclick="doAction2('${ pageContext.request.contextPath }/board/write')"
							class="button small">글쓰기</a>

					</div>
				</article>

			</div>

		</div>
	</section>

	<!-- Footer -->
	<footer>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</footer>



</body>

</html>
