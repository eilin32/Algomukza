<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="chkModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalCenterTitle">경고</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p id="content"></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="button alt small" data-dismiss="modal">Close</button>
				<button type="button" class="button small" id="OK">OK</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="savepillModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalCenterTitle">내 알약 추가</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form method="post"
					action="${ pageContext.request.contextPath }/addmypillM"
					id="inputForm">
					<input type="hidden" name="uId" id="userid">
					<div class="col-3">약 이름:</div>
					<div class="col">
						<input type="text" name="pName" id="pillname" />
					</div>
					<div class="col-3">제조사:</div>
					<div class="col">
						<input type="text" name="pCom" id="pillcom" />
					</div>
					<div class="col-3">1회 복용량:</div>
					<div class="col">
						<input type="text" name="pCnt" />
					</div>
					<div class="col-3">복용 주기:</div>
					<div class="col">
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
					</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="button alt small" data-dismiss="modal">취소</button>
				<button type="button" class="button small" id="save">저장</button>
			</div>
		</div>
	</div>
</div>