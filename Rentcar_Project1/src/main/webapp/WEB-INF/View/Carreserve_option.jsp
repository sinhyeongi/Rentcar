<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<main class="carreserve_option_main">
<form method="get" action = "${ctx }/CarReseveOption.do">
	<input type="hidden" value="${vo.no }" name="no">
	<input type="hidden" value="${vo.id }" name="id">
	<input type="hidden" value="${vo.qty }" name="qty">
	<input type="hidden" value="${vo.dday }" name="dday"> <!-- 대여 시작 일 -->
	<input type="hidden" value="${vo.rday }" name="rday"> <!-- 대여 시간 -->
	<input type="hidden" value="${price }" name="price" id="hidden_price">
	<table>
	<tr>
		<td> 운전자 보험 가입 여부 (5,000원 / 1일)</td>
		<td><input type="radio" value="1" name="usein">O</td>
		<td><input type="radio" value="0" name="usein" checked>X</td>
		
	</tr>
	<tr>
		<td>인터넷(와이파이) 대여 여부 (5,000원 / 1시간)</td>
		<td><input type="radio" value="1" name="usewifi">O</td>
		<td><input type="radio" value="0" name="usewifi" checked>X</td>
	</tr>
	<tr>
	<td>네비게이션 대여 여부(5,000원 / 1시간)</td>
	<td><input type="radio" value="1" name="usenavi">O</td>
	<td><input type="radio" value="0" name="usenavi" checked>X</td>
	</tr>
	<tr>
	<td>베이비시트 적용 여부 (10,000원 / 1일)</td>
	<td><input type="radio" value="1" name="useseat">O</td>
	<td><input type="radio" value="0" name="useseat" checked>X
	</td>
	</tr>
	<tr class="carreserve_option_price_tr">
	<td class="carreserve_option_price_td" colspan="2">총 금액 :<span class="carreserve_option_price_span">${price }</span>원</td>
	</tr>
	<tr>
	<td colspan="2"><input type="button" id="carreserve_option_submit" value="완료!"></td>
	</tr>
	</table>
</form>
</main>