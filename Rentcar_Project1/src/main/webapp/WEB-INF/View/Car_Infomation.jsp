<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<input type="hidden" id="target" name="target" value="${target }">
<input type="hidden" id="log" name="log" value="${log }">
<main class="car_infomation_main">
<table>
	<tr>
		<th colspan="2">차랑 정보</th>
	</tr>
	<tr>
		<td colspan="2">
		<c:if test="${vo.img ne null }">
		<img alt="${vo.name }" src="${ctx }/img/${ vo.img}" >
		</c:if>
		<c:if test="${vo.img eq null }">
		<img alt="no img" src="http://placehold.it/150x150" >
		</c:if>
		</td>
	</tr>
	<tr>
		<td>차랑 이름</td><td>${vo.name }</td>
	</tr>
	<tr>
		<td>차량 종류</td>
		<td>
			<c:if test="${vo.category eq 1}">소형</c:if>
			<c:if test="${vo.category eq 2}">중형</c:if>
			<c:if test="${vo.category eq 3}">대형</c:if>
		</td>
	</tr>
	<tr>
		<td>1일 렌트 비용</td><td>${vo.price }원</td>
	</tr>
	<tr>
		<td>탑승 가능 인원</td><td>${vo.usepeople }명</td>
	</tr>
	<tr>
		<td>남은 차량</td>
		<td>
			<c:if test="${vo.total_qty eq 0}">
			매진
			</c:if>
			<c:if test="${vo.total_qty ne 0}">
			${vo.total_qty }대
			</c:if>
		</td>
	</tr>
	<tr>
		<td>제작 회사</td><td>${vo.company }</td>
	</tr>
	<tr>
		<td>세부 정보</td><td>${vo.info }</td>
	</tr>
	<tr>
		<td colspan="2"><button class="info_reserve"> 예약 하러가기 </button></td>
	</tr>
</table>
</main>