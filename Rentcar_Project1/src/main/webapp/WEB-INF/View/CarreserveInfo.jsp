<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<main class="CarreserveInfo_main">
<input type="hidden" value="${log }" id="log">
<h2>${log }님 예약 정보</h2>
<table>
	<tr>
		<th>렌트 차량</th>
		<th>렌트날짜</th>
		<th>렌트 시간</th>
		<th>렌트 수량</th>
		<th>선택 옵션</th>
		<th>총 금액</th>
		<th>예약 취소하기</th>
	</tr>
	<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.name }<input type="hidden" value="${vo.no }" name="no"><input type="hidden" value="${vo.reserve_seq }" name="seq"></td>
			<td>${vo.dday }</td>
			<td>${vo.rday }시간</td>
			<td class="count">${vo.qty }대</td>
			<td>
				<c:if test="${vo.usein == 1 }">
					운전자 보험
				</c:if>
				<c:if test="${vo.usewifi == 1 }">
					<br/>인터넷
				</c:if>
				<c:if test="${vo.usenavi == 1 }">
					<br/>네비게이션
				</c:if>
				<c:if test="${vo.useseat == 1 }">
					<br/>베이비 시트
				</c:if>
				<c:if test="${vo.usein == 0 and vo.usewifi == 0 and vo.usenavi == 0 and vo.useseat == 0}">
					옵션	선택 없음
				</c:if>
			</td>
			<td>${vo.price }원</td>
			<td><button class="Carreserve_cancel">취소하기</button></td>
		</tr>
		
	</c:forEach>
</table>
</main>