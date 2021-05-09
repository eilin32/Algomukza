<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<div class="inner">
		<h2 style="color:#25a2c3;">내가 먹는 약 찾기</h2>

		<form action="${pageContext.request.contextPath}/searchPill2"
			method="POST">
			<table>


				<tr>
					<td>약 이름</td>
					<td><input type="text" name="p_Name" id="pillName" /></td>
				</tr>
				<tr>
					<td>제조 회사</td>
					<td><input type="text" name="p_Com" id="pillCom" /></td>
				</tr>
				<tr>
					<td>약 색깔(앞)</td>
					<td><select name="p_ColorF" id="p_ColorF">
							<option value="frontAll" style="color: black">색깔(앞)</option>
							<option value="갈색" style="color: brown">갈색</option>
							<option value="남색" style="color: navy">남색</option>
							<option value="노랑" style="color: yellow">노랑</option>
							<option value="보라" style="color: purple">보라</option>
							<option value="분홍" style="color: pink">분홍</option>
							<option value="빨강" style="color: red">빨강</option>
							<option value="연두" style="color: yellowgreen">연두</option>
							<option value="자주" style="color: violet">자주</option>
							<option value="주황" style="color: orange">주황</option>
							<option value="청록" style="color: teal">청록</option>
							<option value="초록" style="color: green">초록</option>
							<option value="투명" style="color: black">투명</option>
							<option value="파랑" style="color: blue">파랑</option>
							<option value="하양" style="color: black">하양</option>
							<option value="회색" style="color: gray">회색</option>
					</select></td>
				</tr>


				<tr>
					<td>약 색깔(뒤)</td>
					<td> <select name="p_ColorB" id="p_ColorB">
							<option value="behindAll" style="color: black">색깔(뒤)</option>
							<option value="갈색" style="color: brown">갈색</option>
							<option value="남색" style="color: navy">남색</option>
							<option value="노랑" style="color: yellow">노랑</option>
							<option value="보라" style="color: purple">보라</option>
							<option value="분홍" style="color: pink">분홍</option>
							<option value="빨강" style="color: red">빨강</option>
							<option value="연두" style="color: yellowgreen">연두</option>
							<option value="자주" style="color: violet">자주</option>
							<option value="주황" style="color: orange">주황</option>
							<option value="청록" style="color: teal">청록</option>
							<option value="초록" style="color: green">초록</option>
							<option value="투명" style="color: black">투명</option>
							<option value="파랑" style="color: blue">파랑</option>
							<option value="하양" style="color: black">하양</option>
							<option value="회색" style="color: gray">회색</option>
					</select></td>
				</tr>

				<tr>
					<td>약 모양</td>
					<td>
						<table>

							<tr>
								<td><input type="radio" id="one" name="p_Shape" value="기타" />
									<label for="one">기타</label></td>
								<td><input type="radio" id="two" name="p_Shape" value="반원형" />
									<label for="two">반원형</label></td>

								<td><input type="radio" id="three" name="p_Shape"
									value="사각형" /> <label for="three">사각형</label></td>

								<td><input type="radio" id="five" name="p_Shape"
									value="삼각형" /> <label for="five">삼각형</label></td>

								<td><input type="radio" id="six" name="p_Shape" value="오각형" />
									<label for="six">오각형</label></td>
							</tr>
							<tr>
								<td><input type="radio" id="seven" name="p_Shape"
									value="원형" /> <label for="seven">원형</label></td>

								<td><input type="radio" id="eight" name="p_Shape"
									value="육각형 " /> <label for="eight">육각형</label></td>

								<td><input type="radio" id="nine" name="p_Shape"
									value="장방형" /> <label for="nine">장방형</label></td>

								<td><input type="radio" id="ten" name="p_Shape" value="타원형" />
									<label for="ten">타원형</label></td>

								<td><input type="radio" id="eleven" name="p_Shape"
									value="팔각형" /> <label for="eleven">팔각형</label></td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td>제형</td>
					<td><select id="p_ShapeType" name="p_ShapeType">
							<option style="color: black" value="all">전체</option>
							<option style="color: black" value="정제">정제</option>
							<option style="color: black" value="경질캡슐">경질캡슐</option>
							<option style="color: black" value="연질캡슐">연질캡슐</option>
					</select></td>
				</tr>
			</table>
			<button type="submit" class="button special">search</button>

		</form>

	</div>


