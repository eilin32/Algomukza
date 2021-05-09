<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Header -->
<header id="header">
	<nav class="left">
		<a href="#menu"><span>Menu</span></a>
	</nav>
	<a href="${pageContext.request.contextPath}/" class="logo">algomuckja</a>
	<nav class="right">

		<c:choose>
			<c:when test="${empty loginSucessVO}">
				<a href="${pageContext.request.contextPath }/login"
					class="button alt">Log in</a>
			</c:when>
			<c:otherwise>
				<img
					src="${pageContext.request.contextPath}/resources/assets/profileImg/${loginSucessVO.thum}" width="30px" height="30px">						
							${loginSucessVO.id } 님 
							<a href="${pageContext.request.contextPath}/myinfo">마이페이지</a>
				<a href="${pageContext.request.contextPath}/logout"
					class="button alt" style="margin-left: 20px">Log Out</a>
			</c:otherwise>
		</c:choose>

		<c:if test="${empty loginSucessVO}">
			<a href="${pageContext.request.contextPath }/signup"
				class="button alt">Sign Up</a>
		</c:if>
	</nav>
	<div class="bottom">
		<ul class="links">

			<li><a href="${pageContext.request.contextPath}/#search">알약검색</a></li>
			<li><a href="${pageContext.request.contextPath}/board">게시판</a>
				<%-- <ul>
					<li><a href="${pageContext.request.contextPath}/board">자유게시판</a>
					<li><a href="${pageContext.request.contextPath}/board">정보게시판</a>
				</ul> --%>
			</li>
			<li><a href="${pageContext.request.contextPath}/map">의료시설 검색</a></li>
		</ul>
	</div>
</header>


<nav id="menu">
	<ul class="links">
		<c:if test="${not empty loginSucessVO}">
			<hr />
			<li><img
				src="${pageContext.request.contextPath}/resources/assets/profileImg/${loginSucessVO.thum}" width="30px" height="30px">${loginSucessVO.name}님</li>
			<li><a href="${pageContext.request.contextPath}/myinfo">마이페이지</a></li>
		</c:if>
		<li><a href="${pageContext.request.contextPath}/#search" >알약검색</a></li>
		<li><a href="${pageContext.request.contextPath}/board">자유게시판</a></li>
		<li><a href="${pageContext.request.contextPath}/map">의료시설 검색</a></li>


	</ul>
	<ul class="actions vertical">
		<c:choose>
			<c:when test="${empty loginSucessVO}">
				<li><a href="${pageContext.request.contextPath }/login"
					class="button">Log in</a></li>
			</c:when>
			<c:otherwise>

				<li><a href="${pageContext.request.contextPath}/logout"
					class="button">Log Out</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
