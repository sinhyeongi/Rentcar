<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main class="addcar_admin">
	<h1>차량 추가 하기</h1>
	<form method="post" id="addCar_form" enctype="multipart/form-data">
		<table>
			<tr>
				<td>차량 이름</td><td><input type="text" required="required" id="name" name="name"></td>
			</tr>
			<tr>
				<td>차량 종류</td>
				<td>
					<input type="radio" name="category" value="1"><span>소형</span>
					<input type="radio" name="category" value="2"><span>중형</span>
					<input type="radio" name="category" value="3"><span>대형</span>
				</td>
			</tr>
			<tr>
				<td>1시간 당 렌트 비용</td>
				<td><input type="number" name="price" id="price"></td>
			</tr>
			<tr>
				<td>승차 인원</td>
				<td><input type="number" name="usepeople" id="usepeople" min="1"></td>
			</tr>
			<tr>
				<td>렌트 카 총 수량</td>
				<td><input type="number" name="total_qty" id="total_qty"></td>
			</tr>
			<tr>
				<td>차량 회사 정보</td>
				<td><input type="text" name="company" id="company"></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="img" id="img" accept="image/*"></td>
			</tr>
			<tr>
				<td>차량 정보</td>
				<td><textarea rows="3" cols="10" name="info" id="info"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="addCar_submit" value="추가하기"></td>
			</tr>
		</table>
	</form>
</main>