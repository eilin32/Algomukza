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
<title>Signup</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<jsp:include page="/WEB-INF/views/include/setting.jsp"></jsp:include>




<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#pwd2').keyup(function() {
							var pwd = $('#pwd').val();
							var pwd2 = $('#pwd2').val();
							if (pwd == pwd2) {
								$('#pwdCheck').html("비밀번호확인완료");
							} else if (pwd2 == "") {
								$('#pwdCheck').html(" ");
							} else {
								$('#pwdCheck').html(" ");
							}
						})

						$("#profile").change(
								function() {
									if (this.files && this.files[0]) {
										var reader = new FileReader;
										reader.onload = function(data) {
											$("#replaceMe").attr("src",
													data.target.result).width(
													300).height(300);
										}
										reader.readAsDataURL(this.files[0]);
									}
								});

						$('#checkId')
								.click(
										function() {
											var checkId = $('#id').val();
											$
													.ajax({
														type : "POST",
														url : "${ pageContext.request.contextPath }/checkId/"
																+ checkId,
														success : checkSuccess,
														error : function() {
															alert("아이디를 입력해주세요");
															$('#idCheck').html(
																	"");
														}
													})

										})
						$('#id').keyup(function() { //중복체크하고 아이디를 바꾸면 다시 공백으로바꿈
							$('#idCheck').html(" ");
						})
						$('#pwd').keyup(function() { //중복체크하고 아이디를 바꾸면 다시 공백으로바꿈
							$('#pwdCheck').html(" ");
						})

						function checkSuccess(data) { //중복체크성공
							if (data.cnt == 0) {
								alert("사용가능합니다.");
								$('#idCheck').html("중복확인완료");
							} else {
								alert("중복된 항목입니다.");
								$('#idCheck').html("");
							}
						}

						function isNull(obj, msg) { //빈칸으로 가입하기를 하게되면 막아주기
							if (!obj.value) {
								alert(msg);
								obj.focus();
								return true;
							}
							return false;
						}

						function checkForm() {

							var signupFrom = document.signupFrom;
							if (isNull(signupFrom.id, "ID을 입력하세요")) {
								return false;
							}

							if (isNull(signupFrom.pwd, "비밀번호를 입력하세요")) {
								return false;
							}

							if (isNull(signupFrom.pwd2, "비밀번호 확인을 입력하세요")) {
								return false;
							}

							if (isNull(signupFrom.name, "이름을 입력하세요")) {
								return false;
							}
							if (isNull(signupFrom.email, "Email 입력하세요")) {
								return false;
							}
							if (isNull(signupFrom.phone, "전화번호를  입력하세요")) {
								return false;
							}

							if ($('#idCheck').html() != "중복확인완료") {
								alert("ID 중복확인 해주세요");
								return false;
							}

							if ($('#pwdCheck').html() != "비밀번호확인완료") {
								alert("Password 확인해주세요");
								return false;
							}

							return true;
						}

					});
</script>
</head>

<body class="subpage">

	<header>
		<jsp:include page="/WEB-INF/views/include/top.jsp"></jsp:include>
	</header>
	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="inner">
			<br> <br> <br>
			<!-- 회원등록 화면 -->
			<div>

				<form enctype="multipart/form-data" method="POST"
					action="${pageContext.request.contextPath}/signup"
					name="signupFrom" onsubmit="return checkForm()">
					<table>
						<tr>
							<td><label>프로필사진</label></td>
							<td><img
								src="${ pageContext.request.contextPath }/resources/images/profile.png"
								id="replaceMe" width="200px" height="200px" /></td>
							<td><input type="file" name="profile" id="profile"></td>
						</tr>

						<tr>
							<td><label>ID</label></td>
							<td><input type="text" name="id" id="id" /></td>
							<td><button type="button" name="checkId" id="checkId">중복확인</button>
								<p id="idCheck"></p></td>
						</tr>

						<tr>
							<td><label>비밀번호</label></td>
							<td><input type="password" name="pwd" id="pwd"
								placeholder="최소 8자 최대 15자 비밀번호를 입력해주세요" /></td>
						</tr>

						<tr>
							<td><label>비밀번호확인</label></td>
							<td><input type="password" name="pwd2" id="pwd2" /></td>
							<td>
								<p id="pwdCheck"></p>
							</td>
						</tr>


						<tr>
							<td><label>이름</label></td>
							<td><input type="text" name="name" id="name" /></td>
							<td></td>
						</tr>

						<tr>
							<td><label>Email</label></td>
							<td><input type="text" name="email" id="email" /></td>
							<td></td>
						</tr>

						<tr>
							<td><label>전화번호</label></td>
							<td><input type="text" name="phone" id="phone" /></td>
							<td></td>
						</tr>

						<tr>
							<td><label>해당사항체크</label></td>
							<td>
								<table>
									<tr>
										<td><input type="radio" id="not" name="chk" value="n"
											checked="checked" /> <label for="not">없음</label></td>
										<td><input type="radio" id="preg" name="chk" value="p" />
											<label for="preg">임신여부</label></td>
										<td><input type="radio" id="old" name="chk" value="o" />
											<label for="old">노인</label></td>
										<td><input type="radio" id="age" name="chk" value="a" />
											<label for="age">유아</label></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
								</table>
							</td>
						</tr>
					</table>
					<div style="text-align:center;">
						<button id="submit" type="submit">가입하기</button>
					</div>

				</form>
			</div>

		</div>
	</section>





	<br>
	<br>
	<br>
	<!-- Footer -->

	<footer>
		<jsp:include page="/WEB-INF/views/include/top.jsp"></jsp:include>
	</footer>
</body>
</html>
