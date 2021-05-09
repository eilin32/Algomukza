<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>

<jsp:include page="/WEB-INF/views/include/setting.jsp" />
<style type="text/css">
option {
	color: gray;
}

p {
	color: white;
}

/* .tabcontent {
	display: none;
}

.tabcontent.active {
	display: block;
} */
</style>
<%-- <link rel="stylesheet" type="text/css"
	href="${ pageContext.request.contextPath }/resources/assets/css/tab.css">
<script src="${ pageContext.request.contextPath }/resources/assets/js/tab.js"></script>
<script>
		
</script> --%>

</head>

<body>

	<header>
		<jsp:include page="/WEB-INF/views/include/top.jsp" />
	</header>

	<!-- Banner -->
	<section id="banner">
		<div class="content">
			<h1>알고먹자</h1>
			<p>알약의 모양, 색상, 마크, 문자 등을 입력하여 제품명을 검색할 수 있습니다</p>
			<ul class="actions">
				<li><a href="#search" class="button scrolly">검색 하기</a></li>
			</ul>
		</div>
	</section>
	<!-- Search -->

	<section id="search" class="wrapper style1 special">
		<div class="inner">
			<!-- <div class='tabbed round'>
				<ul class="tab">
					<li data-tab="tab2"><a href="#search"></a>부작용 검색</li>
					<li class='active' data-tab="tab1"><a href="#search"></a>모양 검색</li>
				</ul>
			</div> -->
			<h2>모양으로 검색하기</h2>
			<div id="tab1" class="tabcontent active">
				<form>
					<table>
						<tr>
							<td>약 이름</td>
							<td><input type="text" name="pillName" id="pillName" /></td>
						</tr>

						<tr>
							<td>제조 회사</td>
							<td><input type="text" name="pillCom" id="pillCom" /></td>
						</tr>

						<tr>
							<td>약 색깔(앞)</td>
							<td><select name="job">
									<option value="">전체</option>
									<option value="brown">갈색</option>
									<option value="browntm">갈색|투명</option>
									<option value="navy">남색</option>
									<option value="yellow">노랑</option>
									<option value="yellowtm">노랑|투명</option>
									<option value="purple">보라</option>
									<option value="pink">분홍</option>
									<option value="red">빨강</option>
									<option value="redtm">빨강|투명</option>
									<option value="yellowgreen">연두</option>
									<option value="violet">자주</option>
									<option value="orange">주황</option>
									<option value="orangetm">주황|투명</option>
									<option value="bluegreen">청록</option>
									<option value="gr">초록</option>
									<option value="red">빨강</option>
									<option value="red">빨강</option>
									<option value="red">빨강</option>
									<option value="red">빨강</option>

							</select></td>
						</tr>

						<tr>
							<td>약 색깔(뒤)</td>
							<td><input type="text" name="pillColorB" id="pillColorB" /></td>
						</tr>
						<tr>
							<td>약 모양</td>
							<td>
								<table style="background: white">
									<tr>
										<td><input type="radio" id="all" name="shape" value=""
											checked="checked" /> <label for="all">전체</label></td>
									</tr>
									<tr>
										<td><input type="radio" id="one" name="shape" value="1" />
											<label for="one">기타</label></td>
										<td><input type="radio" id="two" name="shape" value="2" />
											<label for="two">반원형</label></td>

										<td><input type="radio" id="three" name="shape" value="3" />
											<label for="three">사각형</label></td>

										<td><input type="radio" id="four" name="shape" value="4" />
											<label for="four">삼각형</label></td>

										<td><input type="radio" id="six" name="shape" value="5" />
											<label for="six">오각형</label></td>
									</tr>
									<tr>
										<td><input type="radio" id="seven" name="shape" value="6" />
											<label for="seven">원형</label></td>

										<td><input type="radio" id="eight" name="shape" value="7" />
											<label for="eight">육각형</label></td>

										<td><input type="radio" id="nine" name="shape" value="8" />
											<label for="nine">장방형</label></td>

										<td><input type="radio" id="ten" name="shape" value="9" />
											<label for="ten">타원형</label></td>

										<td><input type="radio" id="eleven" name="shape"
											value="11" /> <label for="eleven">팔각형</label></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td>해당사항체크</td>
							<td>
								<table style="background: white">
									<tr>
										<td><input type="radio" id="none" name="chk" value="n"
											checked="checked" /> <label for="none">없음</label></td>
										<td><input type="radio" id="preg" name="chk" value="p" />
											<label for="preg">임신여부</label></td>
										<td><input type="radio" id="old" name="chk" value="o" />
											<label for="old">노인</label></td>

										<td><input type="radio" id="age" name="chk" value="a" />
											<label for="age">유아</label></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</form>
			</div>
		<!-- 	<div id="tab2" class="tabcontent">부작용 검색</div> -->
		</div>
		<a href="#result" class="button special scrolly">search</a>
	</section>

	<!-- Result -->
	<section id="result" class="wrapper">
		<div class="inner" id="searchResult"></div>
	</section>

	<footer>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</footer>

</body>
</html>