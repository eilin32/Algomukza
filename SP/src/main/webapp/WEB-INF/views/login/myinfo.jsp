<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</style>
<script>
	$(document)
			.ready(
					function() {
						$(
								"input:radio[name ='chk']:input[value='${loginSucessVO.chk}']")
								.prop('checked', true);
					});
</script>
<title>회원정보</title>
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

							<li><a href="${pageContext.request.contextPath}/myinfo">회원
									정보</a></li>
							<li><a href="${pageContext.request.contextPath}/mypage/${loginSucessVO.id}"
								style="color: gray;">복용 약 목록</a></li>
							<li><a href="${pageContext.request.contextPath}/mypage2" style="color: gray;">My
									Calendar</a></li>
						</ul>

					</aside>
				</div>
				<div class="10u 12u$">
					<form id="info" enctype="multipart/form-data" method="POST"
						action="${pageContext.request.contextPath}/changeMyinfo">
						<table>
							<tbody>
								<tr>
									<td><label>프로필사진</label></td>
									<td><img
										src="${pageContext.request.contextPath}/resources/assets/profileImg/${loginSucessVO.thum}"
										id="replaceMe" width="100px" height="100px" /></td>
								</tr>
								<tr>
									<td><label>아이디</label></td>
									<td><input type="text" name="id" size="80"
										value="${loginSucessVO.id}" readonly></td>
								</tr>
								<tr>
									<td><label>비밀번호</label></td>
									<td><a href="${pageContext.request.contextPath}/changePwd"
										class="button small">비밀번호 변경</a></td>
								<tr>
									<td><label>이름</label></td>
									<td><input type="text" name="name" size="80"
										value="${loginSucessVO.name}"></td>
								</tr>
								<tr>
									<td><label>이메일</label></td>
									<td><input type="text" name="email" size="80"
										value="${loginSucessVO.email}"></td>
								</tr>
								<tr>
									<td><label>전화번호</label></td>
									<td><input type="text" name="phone" size="80"
										value="${loginSucessVO.phone}"></td>
								</tr>
								<tr>
									<td><label>해당사항체크</label></td>
									<td>
										<table>
											<tr>
												<td><input type="radio" id="not" name="chk" value="n" />
													<label for="not">없음</label></td>
												<td><input type="radio" id="preg" name="chk" value="p" />
													<label for="preg">임신여부</label></td>
												<td><input type="radio" id="old" name="chk" value="o" />
													<label for="old">노인</label></td>
												<td><input type="radio" id="age" name="chk" value="a" />
													<label>유아</label></td>

												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										</table>
									</td>
								</tr>
							</tbody>
						</table>

						<button id="submit" type="submit" style="float: right;"
							class="button small">확인</button>
						<a href="${pageContext.request.contextPath}/mypage"
							class="button small" style="float: right; margin-right: 10px;">뒤로</a>
					</form>
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
