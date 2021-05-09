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

<header>
	<jsp:include page="/WEB-INF/views/include/setting.jsp"></jsp:include>
</header>	
	
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

				<form method="POST"
					action="${pageContext.request.contextPath}/searchPwd">
					<table>
							
							<tr>
							<td><label>ID</label></td>
							<td><input type="text" name="id" id="id" /></td>
							<td></td>
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
				

					</table>
					<button id="submit" type="submit">비밀번호 찾기</button>
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
