<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>

<jsp:include page="/WEB-INF/views/include/setting.jsp" />

<style>
#search {
	background-image: url("./resources/images/aa.jpg");

}

.pname{
	font-weight: bold;
}
</style>
<script>
	$(document).ready(function() { //jquery 시작
		$('#savepillModal').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget) // Button that triggered the modal
			var userid = button.data('userid')
			var pillname = button.data('pillname')
			var pillcom = button.data('pillcom')
			console.log(userid)
			// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			var modal = $(this)
			modal.find('#userid').val(userid)
			modal.find('#pillname').val(pillname)
			modal.find('#pillcom').val(pillcom)
		})
		$('#inputForm').on("submit", function(e) {
			var postData = $(this).serializeArray();
			$.ajax({
				url : "${ pageContext.request.contextPath }/addmypillM",
				type : "POST",
				data : postData,
				success : function(data) {
					console.log(data);
					console.log("제출 완료");
					let jsonData = JSON.parse(JSON.stringify(data));
					if (jsonData.flag) {
						$('#savepillModal').modal("hide");
						alert("약 정보가 추가되었습니다!");
					}
				}

			})
			e.preventDefault();
		})

		$('#save').click(function() {
			$('#inputForm').submit();
		});

	});

	//     $('#searchBtn').click(function(){
	function moreList(btn) {
		var p_Name = "${pillListVO.p_Name}";
		var p_Com = "${pillListVO.p_Com}";
		var p_ColorF = "${pillListVO.p_ColorF}";
		var p_ColorB = "${pillListVO.p_ColorB}";
		var p_Shape = "${pillListVO.p_Shape}";
		var p_ShapeType = "${pillListVO.p_ShapeType}";

		if (p_Shape == '') {
			p_Shape = null;
		}

		var value = $("#searchBtn").val();
		value = value * 1;
		value = value + 20;
		$("#searchBtn").remove();

		//   var params = $("#searchInfo").serialize()         
		var params = {
			"p_Name" : p_Name,
			"p_Com" : p_Com,
			"p_Shape" : p_Shape,
			"p_ColorF" : p_ColorF,
			"p_ColorB" : p_ColorB,
			"p_ShapeType" : p_ShapeType
		}

		$
				.ajax({
					type : "POST",
					data : params,
					url : "${ pageContext.request.contextPath }/searchPill/"
							+ value,
					success : function(data) {
						var content = "";
						console.log(data);
						var pillList = data.pillList;
						var pillDiv = data.pillDiv;
						var pillOld = data.pillOld;
						var pillPreg = data.pillPreg;
						var pillAge = data.pillAge;

						if (pillList.length == 0) {
							alert("더이상 불러올 항목이 없습니다.");
						}

						for (var i = 0; i < pillList.length; i++) {
							content += '<tr name="lastTr">'
							content += '<td><img src=' + pillList[i].p_Img + ' height="200" width="200"/></td><td style="vertical-align: top">'

							content += '<li class="pname">이름 : ' + pillList[i].p_Name
									+ '</li>'
							content += '<li>제조사 : ' + pillList[i].p_Com
									+ '</li>'
							content += '<li>효능 : ' + pillList[i].p_TypeN
									+ '</li>'
							content += '<li>처방유무 : ' + pillList[i].p_Tc
									+ '</li><br>'
							if (pillDiv[i] != null) {
								content += '<li style="color: red; font-size:20px">분할 금기 약품</li>'
										+ '<li>내용 : '
										+ pillDiv[i].pd_Content
										+ '</li>'
								if (pillDiv[i].pd_Etc != null) {
									content += '<li>기타 : ' + pillDiv[i].pd_Etc
											+ '</li>'
								}

							}

							if (pillOld[i] != null) {
								content += '<li style="color: red; font-size:20px">노인 금기 약품</li>'
										+ '<li>내용 : '
										+ pillOld[i].po_Content
										+ '</li>'

							}

							if (pillPreg[i] != null) {
								content += '<li style="color: red; font-size:20px">임산부 금기 약품</li>'
								if (pillPreg[i].pp_Content != null) {
									content += '<li>내용 : '
											+ pillPreg[i].pp_Content + '</li>'
								}
							}

							if (pillAge[i] != null) {
								content += '<li style="color: red; font-size:20px">특정연령 금기 약품</li>'
								if (pillAge[i].pa_Content != null) {
									content += '<li>내용 : '
											+ pillAge[i].pa_Content + '</li>'
								}
							}

							+'</td>'
							content += '<td><button type="button" class="button small"'
							+'data-toggle="modal"'
							+'data-target="#savepillModal"'
							+'data-userid="${loginSucessVO.id }"'
							+'data-pillname="'+pillList[i].p_Name+'"'
							+'data-pillcom="'+pillList[i].p_Com+'"'
							+'>내 알약 추가</button></td></tr>'
						}

						// 기존 버튼을 지우고 새로 만들어줄때 value 값을 1 증가시켜서 다음 10개를 불러올 페이징넘버를 기억하게함.
						var pagingNum = value;

						content += '<tr id="lastTr"><td>'
								+ '<button type="button" id="searchBtn" onclick="javascript:moreList(this);"'
								+ 'value="' + value + '">'
								+ '더보기</button></td></tr>"';

						console.log("content : " + content);

						var last_tr = $('tr[name=lastTr]:last');
						last_tr.after(content)
					},
					error : function(error) {
						console.log(error);
						alert("실패");
					}
				})
	}
</script>

</head>

<body>

	<header>
		<jsp:include page="/WEB-INF/views/include/top.jsp" />
	</header>

	<!-- Banner -->
	<section id="banner">
		<div class="content">
			<h1>알고먹자</h1>
			<p style="color: white">알약의 이름, 제조사, 모양, 색상, 제형 등을 입력하여 제품명을 검색할 수
				있습니다<br>나만의 알약 리스트를 만들어 약 복용을 보다 더 쉽게 관리해보세요!</p>
			<ul class="actions">
				<li><a href="#search" class="button scrolly">시작하기</a></li>
			</ul>
		</div>
	</section>
	<!-- Search -->
	<section id="search" class="wrapper style1 special">
		<jsp:include page="/WEB-INF/views/include/search.jsp" />
	</section>

	<section id="result" class="wrapper">
		<div class="inner">
			<h2>검색 결과</h2>
			<table id="more_list">
				<c:choose>
					<c:when test="${empty result.pillListVo }">
						<tr>
							<td colspan="3" style="text-align: center">검색 결과가 없습니다</td>
						</tr>
					</c:when>

					<c:otherwise>
						<c:forEach items="${result.pillListVo}" var="pillListVO"
							varStatus="status">
							<tr name="lastTr">
								<td><img src="${pillListVO.p_Img}" height="200" width="200" /></td>
								<td style="vertical-align: top">
									<ul>
										<li class="pname">이름 : ${pillListVO.p_Name}</li>
										<li>제조사 : ${pillListVO.p_Com}</li>
										<li>효능 :${pillListVO.p_TypeN}</li>
										<li>처방유무 : ${pillListVO.p_Tc}</li>

										<br />

										<c:if test="${not empty result.pillDiv[status.index].pd_Id}">
											<li style="color: red; font-size: 20px">분할 금기 약품</li>
											<li>내용 : ${result.pillDiv[status.index].pd_Content}</li>
											<c:if test="${not empty result.pillDiv[status.index].pd_Etc}">
												<li>기타 : ${result.pillDiv[status.index].pd_Etc}</li>
											</c:if>
										</c:if>

										<c:if test="${not empty result.pillOld[status.index].po_Id}">
											<li style="color: red; font-size: 20px">노인 금기 약품</li>
											<li>내용 : ${result.pillOld[status.index].po_Content}</li>
										</c:if>

										<c:if test="${not empty result.pillPreg[status.index].pp_Id}">
											<li style="color: red; font-size: 20px">임산부 금기 약품</li>
											<c:if
												test="${not empty result.pillPreg[status.index].pp_Content}">
												<li>내용 : ${result.pillPreg[status.index].pp_Content}</li>
											</c:if>
										</c:if>

										<c:if test="${not empty result.pillAge[status.index].pa_Id}">
											<li style="color: red; font-size: 20px">특정연령 금기 약품</li>
											<c:if
												test="${not empty result.pillAge[status.index].pa_Content}">
												<li>내용 : ${result.pillAge[status.index].pa_Content}</li>
											</c:if>
										</c:if>


									</ul>
								</td>
								<td><button class="button small" data-toggle="modal"
										data-target="#savepillModal"
										data-userid="${loginSucessVO.id }"
										data-pillname="${pillListVO.p_Name}"
										data-pillcom="${pillListVO.p_Com}">내 알약 추가</button></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</table>
			<button value="1" id="searchBtn" name="searchBtn"
				onclick="javascript:moreList(this);">더보기</button>
		</div>
	</section>



	<footer>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</footer>

	<!-- Modal -->
	<jsp:include page="/WEB-INF/views/include/modal.jsp" />
</body>
</html>