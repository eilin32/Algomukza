<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<jsp:include page="/WEB-INF/views/include/setting.jsp"></jsp:include>

<style type="text/css">
#sidemenu>ul>li>a {
	text-decoration: none;
	display: block;
}

#sidemenu {
	width: 200px;
	float: left;
	padding-right: 40px;
}

.pilllist {
	border-radius: 10px;
	height: inherit;
	padding: 20px;
	margin-bottom: 20px;
	font-size: 15px;
}

.toggle_container {
	font-size: 15px;
}

.toggle_container input[type="text"], select {
	line-height: 2.5em;
	height: 2.5em;
}
</style>
<script>
	$(document).ready(function() {
		$(".toggle_container").hide();
		$("#addpill").click(function() {
			$(this).toggleClass("active").next().slideToggle("fast");

			if ($.trim($(this).text()) === "사용자 지정 추가") {
				$(this).text("추가 취소");
			} else {
				$(this).text("사용자 지정 추가");
			}

			return false;
		});
		$("a[href='" + window.location.hash + "']").parent("#addpill").click();
	});
</script>
<title>마이페이지</title>
</head>
<body class="subpage">

	<header>
		<jsp:include page="/WEB-INF/views/include/top.jsp" />
	</header>

	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="inner">
			<div class="row">
				<div class="2u 12u$">
					<aside id="sidemenu">
						<ul class="alt">
							<li><a href="${pageContext.request.contextPath}/myinfo"
								style="color: gray;">회원 정보</a></li>
							<li><a
								href="${pageContext.request.contextPath}/mypage/${loginSucessVO.id}">복용
									약 목록</a></li>
							<li><a href="${pageContext.request.contextPath}/mypage2"
								style="color: gray;">My Calendar</a></li>
						</ul>
					</aside>
				</div>
				<div class="10u 12u$">
					<div class="pilllist">

						<table>
							<thead>
								<tr>
									<th>약 이름</th>
									<th>제약 회사</th>
									<th>1회 복용량</th>
									<th>복용주기</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty mypills }">
										<tr>
											<td colspan="5" style="text-align: center">저장된 약 정보가
												없습니다</td>
										</tr>
									</c:when>

									<c:otherwise>
										<c:forEach items="${mypills }" var="mypills">
											<tr>
												<td>${mypills.pName }</td>
												<td>${mypills.pCom }</td>
												<td>${mypills.pCnt }알씩</td>
												<td>${mypills.pPer }${mypills.pTnum }번</td>
												<td><a
													href="${pageContext.request.contextPath}/deletemypill/${loginSucessVO.id }/${mypills.pNum}">삭제</a>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>

							</tbody>

						</table>
					</div>
					<div>
						<button id="addpill" class='button small' style="float: right">사용자 지정 추가</button>
						<div class="toggle_container">
							<div>
								<form method="post"
									action="${ pageContext.request.contextPath }/addmypill/${loginSucessVO.id }"
									name="inputForm">
									<input type="hidden" name="uId" value="${loginSucessVO.id }">
									<div class="container">
										<div class="justify-content-md-center">
											<div class="col-3">약 이름:</div>
											<div class="col-5">
												<input type="text" name="pName" />
											</div>
											<div class="col-3">제조사:</div>
											<div class="col-5">
												<input type="text" name="pCom" />
											</div>
											<div class="col-3">1회 복용량:</div>
											<div class="col-5">
												<input type="text" name="pCnt" />
											</div>
											<div class="col-3">복용 주기:</div>
											<div class="col-5">
												<div style="display: flex;">
													<select name="pPer" id="pPer">
														<option value="미지정">선택안함</option>
														<option value="식후" selected="selected">식후에</option>
														<option value="하루">하루에</option>
														<option value="일주일">일주일에</option>
														<option value="한 달">한 달에</option>
														<option value="일년">일년에</option>
													</select><select name="pTnum" id="pTnum">
														<option value="0" selected="selected">선택안함</option>
														<option value="1">1번</option>
														<option value="2" selected="selected">2번</option>
														<option value="3">3번</option>
														<option value="4">4번</option>
														<option value="5">5번</option>
													</select>
												</div>
											</div>
											<div>
												<br>
												<button class="button small" type="submit">저장</button>
											</div>
										</div>

									</div>
								</form>
							</div>
						</div>
					</div>

				</div>


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
