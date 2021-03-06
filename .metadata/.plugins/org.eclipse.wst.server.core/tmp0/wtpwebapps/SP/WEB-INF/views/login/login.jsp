<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Intensify by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>

<head>
    <title>login</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <header>
		<jsp:include page="/WEB-INF/views/include/setting.jsp"></jsp:include>
	</header>
	
	<script>
	if("${msg}"){
		alert("${msg}")
	}
	
	if("${searchId}"){
		alert("${searchId}")
	}
	if("${searchPwd}"){
		alert("${searchPwd}")
	}
		</script>
</head>

<body class="subpage">

    <header>
    	<jsp:include page="/WEB-INF/views/include/top.jsp"/>
    </header>
    
    <!-- Main -->
    <section id="main" class="wrapper">
        <div class="inner">
            <br><br><br>
            <div class="table-wrapper">
                <form method="post" action="${pageContext.request.contextPath}/login">
                    <table class="alt">
                        <tr>
                            <td><label>ID</label></td>
                            <td><input type="text" name="id" /></td>
                        </tr>
                        <tr>
                            <td><label>비밀번호</label></td>
                            <td><input type="password" name="pwd" /></td>
                        </tr>
                    </table>
                    
                     <div>
                        <a href="${pageContext.request.contextPath}/searchId" class="button alt small">아이디 찾기</a>
                        <a href="${pageContext.request.contextPath}/searchPwd" class="button alt small">비밀번호 찾기</a>
                    </div>
                    
                    <div>
                        <span class="txt1">Don’t have an account?</span>
                        <a class="txt2" href="/signup">Sign Up</a>

                    </div>
                   <div style="float: right">
                        <button type="submit" class="button">Login</button>

                    </div>
                </form>
            </div>

        </div>
    </section>
    <br><br><br>
    <!-- Footer -->
    <footer>
    	<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    </footer>
    
    </body></html>
