<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<jsp:include page="/WEB-INF/views/include/setting.jsp"></jsp:include>

<title>비밀번호 변경</title>

<script>
$(document).ready(function(){
	$('#npwd2').keyup(function(){
		var pwd=$('#npwd').val();
		var pwd2=$('#npwd2').val();		
		if(pwd==pwd2){
			$('#pwdCheck').html("비밀번호확인완료");
		}else if(pwd2==""){
			$('#pwdCheck').html(" ");
		}else{
			$('#pwdCheck').html("비밀번호 확인실패!");
		}
	})
	
	function checkForm(){
		
		var signupFrom=document.signupFrom;
		
		if(isNull(signupFrom.pwd,"비밀번호를 입력하세요")){
			return false;
		}
		if(isNull(signupFrom.npwd,"새 비밀번호를 입력하세요")){
			return false;
		}
		if(isNull(signupFrom.npwd2,"새 비밀번호 확인을 입력하세요")){
			return false;
		}
					
		if($('#pwdCheck').html()!="비밀번호확인완료"){
			alert("새 비밀번호 입력을 확인하세요");
			return false;
		}
		
		return true;		
	}
	
});

if("${msg}"){
	alert("${msg}")
}

</script>
</head>
<body class="subpage">

	<header>
		<jsp:include page="/WEB-INF/views/include/top.jsp" />
	</header>

	<!-- Main -->
	<section id="main" class="wrapper">
		<div class="inner">
			<div>

				<form enctype="multipart/form-data" method="POST"
					action="${pageContext.request.contextPath}/changePwd/${loginSucessVO.id}"
					name="signupFrom" onsubmit="return checkForm()">
					<table>
						<tr>
							<td><label>기존 비밀번호</label></td>
							<td><input type="password" name="pwd" id="pwd" /></td>
						</tr>
						<tr>
							<td><label>새 비밀번호</label></td>
							<td><input type="password" name="npwd" id="npwd"
								placeholder="최소 8자 최대 15자 비밀번호를 입력해주세요" /></td>
						</tr>

						<tr>
							<td><label>새 비밀번호확인</label></td>
							<td><input type="password" name="npwd2" id="npwd2" /></td>
							<td>
								<p id="pwdCheck"></p>
							</td>
						</tr>

					</table>
					<a href="${pageContext.request.contextPath}/myinfo" class="button small">취소</a>
					<button id="submit" type="submit" class="button small">변경하기</button>
				</form>
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
