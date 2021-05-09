<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<!--
	Intensify by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>

<head>
<title>게시판글쓰기</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<jsp:include page="/WEB-INF/views/include/setting.jsp" />

<script>
	$(document)
			.ready(
					function() {

						$('#chkModal').on('show.bs.modal', function(event) {
							var button = $(event.relatedTarget) // Button that triggered the modal
							var rep = button.data('whatever') // Extract info from data-* attributes
							// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
							// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
							var modal = $(this)
							modal.find('#content').text(rep)
						})

						$('#OK').click(
								function() {
											// 동기식 삭제
											// location.href = "${ pageContext.request.contextPath }/board/remove/${board.no}"; 

											// 비동기 삭제
											$.ajax({
														type : "delete",
														url : "${ pageContext.request.contextPath }/board/${ board.no }/delete",
														success : function(data) {
															console.log(data);
															let jsonData = JSON.parse(JSON.stringify(data));
															if (jsonData.flag) {
																location.href = "${ pageContext.request.contextPath }/board";
															}
														}
													});
										});
					});

	function checkForm() {
		var form = document.inputForm;

		if (!form.recontent.value) {
			alert('댓글을 입력해주세요');
			form.recontent.focus();
			return false;
		}

		return true;
	}

	function hideDiv(id) {
		var div = document.getElementById(id);
		div.style.display = "none";
		document.body.appendChild(div);
	}

	function fn_replyReply(reno) {
		var form = document.form3;
		var reply = document.getElementById("reply" + reno);
		var replyDia = document.getElementById("replyDialog");
		replyDia.style.display = "";

		form.recontent.value = "";
		form.repno.value = reno;
		reply.appendChild(replyDia);
		form.rewriter.focus();
	}
	function fn_replyReplyCancel() {
		hideDiv("replyDialog");
	}

	function fn_replyReplySave() {
		var form = document.form3;

		if (form.rewriter.value == "") {
			alert("작성자를 입력해주세요.");
			form.rewriter.focus();
			return;
		}
		if (form.recontent.value == "") {
			alert("글 내용을 입력해주세요.");
			form.recontent.focus();
			return;
		}

		form.submit();
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
			<header>
				<h1>자유게시판</h1>
				<strong>${ board.title }</strong>
				<div style="display: flex; justify-content: space-between;">
					<p>${ board.regDate}</p>
					<p>조회수 : ${board.viewCnt }</p>
				</div>

			</header>
			<%pageContext.setAttribute("newLineChar","\r\n"); %>
			<p>${fn:replace(board.content, newLineChar, "<br/>") }</p>

			<div style="float: right">
			<c:if test="${not empty loginSucessVO}">
				<a href="${ pageContext.request.contextPath }/board/write"
					class="button small">글쓰기</a>
		</c:if>
				<c:if test="${board.writer eq loginSucessVO.id }">
					<a
						href="${ pageContext.request.contextPath }/board/edit/${board.no}"
						class="button small">수정</a>
					<button class="button small" data-toggle="modal"
						data-target="#chkModal" data-whatever="정말 이 게시물을 삭제하시겠습니까?">삭제</button>
				</c:if>
				<a href="${ pageContext.request.contextPath }/board"
					class="button small">목록으로</a>
			</div>

			<br>
			<hr />
			<div style="clear: both;">
				<h5>댓글</h5>
				<c:choose>
					<c:when test="${empty loginSucessVO}">
						<p>
							<a href="${ pageContext.request.contextPath }/login">로그인</a> 후 댓글
							작성이 가능합니다
						</p>
					</c:when>
					<c:otherwise>
						<form style="display: flex" method="post"
							action="${ pageContext.request.contextPath }/insertReply/${board.no}"
							name="inputForm" onsubmit="return checkForm()">
							<table id="replytable">
								<tbody>
									<tr>
										<td><input type="hidden" name="bno" value="${board.no}" />
											<input type="hidden" name="rewriter" size="20" maxlength="20"
											value="${loginSucessVO.id}" readonly> <textarea
												rows="2" cols="80" name="recontent" placeholder="댓글을 입력해주세요"></textarea>
										</td>
										<td><button type="submit" class="button small">댓글작성</button></td>
									</tr>
									<c:forEach var="replylist" items="${replylist}"
										varStatus="status">
										<tr>
											<td>
												<div
													style=" width: 600px; padding: 5px; margin-top: 5px; margin-left: <c:out value="${20*replylist.redepth}"/>px; display: inline-block">
													<c:choose>
														<c:when test="${replylist.redeleted eq 'Y' }">
															<p>삭제된 댓글 입니다</p>
														</c:when>
														<c:otherwise>
															<c:out value="${replylist.rewriter}" />
															<c:out value="${replylist.reregdate}" />
															<c:if test="${replylist.rewriter eq loginSucessVO.id }">
																<a
																	href="${pageContext.request.contextPath }/deleteReply/${board.no }/${replylist.reno}">삭제</a>
																
															</c:if>
															<c:if test="${not empty loginSucessVO}">
																<a href="#"
																	onclick="fn_replyReply('<c:out value="${replylist.reno}"/>')">답장</a>
															</c:if>
															<br />
															<div id="reply<c:out value="${replylist.reno}"/>">
																<c:out value="${replylist.recontent}" />
															</div>
														</c:otherwise>
													</c:choose>
												</div>
											</td>
										</tr>


									</c:forEach>
								</tbody>
							</table>
						</form>
					</c:otherwise>
				</c:choose>

			</div>
			<div>
				<div id="replyDialog" style="width: 99%; display: none">
					<form name="form3"
						action="${ pageContext.request.contextPath }/insertReply/${board.no}"
						method="post">
						<table >
							<tbody>
								<tr>
									<td><input type="hidden" name="bno"
										value="<c:out value="${board.no}"/>"> <input
										type="hidden" name="repno" /><input type="hidden"
										name="rewriter" value="${loginSucessVO.id}" readonly /> <textarea
											name="recontent" rows="3" cols="60" maxlength="500"></textarea>
									</td>

									<td>
										<div style="float: right;">
											<a href="#replytable" onclick="fn_replyReplySave()">작성</a> <a href="#"
												onclick="fn_replyReplyCancel()">취소</a>
										</div>
									</td>
							</tbody>
						</table>



					</form>
				</div>

				<br />
			</div>
		</div>
	</section>
	
	<!-- Footer -->
	<footer>
		<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	</footer>

	<!-- Modal -->
	<jsp:include page="/WEB-INF/views/include/modal.jsp" />
</body>
</html>
