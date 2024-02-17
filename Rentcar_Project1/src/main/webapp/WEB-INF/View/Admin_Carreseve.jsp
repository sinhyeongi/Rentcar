<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
	
<main class="admin_carreserve_main">
	<h2>전체 예약 목록</h2>
	<table>
		<tr>
			<th>예약 번호</th>
			<th>차량 고유 번호</th>
			<th>렌트 날짜</th>
			<th>렌트 시간</th>
			<th>렌트 수량</th>
			<th>선택 옵션</th>
			<th>총 금액</th>
			<th>예약 취소하기</th>
		</tr>
		<c:forEach var="item" items="${list }">
			<tr>
				<td>${item.reserve_seq }</td>
				<td>${item.no }</td>
				<td>${item.dday }</td>
				<td>${item.rday } 시간</td>
				<td>${item.qty } 대</td>
				<td>
					<c:if test="${item.usein == 1 }">
					운전자 보험
				</c:if>
				<c:if test="${item.usewifi == 1 }">
					<br/>인터넷
				</c:if>
				<c:if test="${item.usenavi == 1 }">
					<br/>네비게이션
				</c:if>
				<c:if test="${item.useseat == 1 }">
					<br/>베이비 시트
				</c:if>
				<c:if test="${item.usein == 0 and item.usewifi == 0 and item.usenavi == 0 and item.useseat == 0}">
					옵션	선택 없음
				</c:if>
				</td>
				<td>${item.price }</td>
				<td><button id="Admin_Carreseve_cancle">취소하기</button></td>
			</tr>
		</c:forEach>
	</table>
</main>