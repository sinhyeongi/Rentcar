<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<main class="CarReserve_main">
<form method="post" action="${ctx }/Carreserve.do">
<input type="hidden" name="car_rent_time" id="car_rent_time">
<input type="hidden" name="price" class="input_price">
<table class="CarReserve_table">
<tr>
<td>오늘 날 짜 </td>
<td>${today }</td>
</tr>
<tr>
<td>시작 날짜</td><td><input type="text" id="startDate" placeholder="날짜를 선택해 주세요" name="startDate" required="required"></td>
<td class="startH_td">시작 시간</td><td><input type="text" id="startH" style="visibility: hidden;" placeholder="시간을 선택해 주세요" required="required" name="startH"></td>
</tr>
<tr>
<td>종료 날짜</td>
<td><input type="text" id="endDate" readonly="readonly" name="endDate" required="required" name="endDate"></td>
<td class="endH_td">종료 시간</td><td><input type="text" id="endH" style="visibility: hidden;" placeholder="시간을 선택해 주세요" required="required" name="endDate"></td>
</tr>
<tr>
<td colspan="2">자동차 선택</td>
</tr>
<tr>
<td colspan="4" style="border:1px solid green;" id="CarReserve_view">
<table class="car_view_table">
<tr>
<td colspan="6" class="car_view_header">수량 <input type="number" name="car_count" id="car_count" value="1" min="1"></td>
</tr>
<c:forEach var="item" items="${list }">
<c:if test="${item.total_qty ne 0 }">
<tr>
<td><input type="radio" name="car" value="${item.no }/${item.price}"<c:if test="${target eq item.no }">checked</c:if>></td>
<c:if test="${item.img ne null }">
<td><img src="${ctx }/img/${item.img }"></td>
</c:if>
<c:if test="${item.img eq null }">
<td><img src="http://placehold.it/100x100" alt="no img"></td>
</c:if>
<td>${item.name }</td>
<td>${item.price }원 / 1시간</td>
<td>탑승 가능 인원 : ${item.usepeople } 명</td>
<td>남은 수량 : ${item.total_qty } 대<input type="hidden" class="car_max${item.no }" value="${item.total_qty }"></td>
</tr>
</c:if>
</c:forEach>
</table>
</td>
</tr>
<tr>
<td><input type="button" value="계산 하기" class="price_btn"></td>
</tr>
<!-- 요금 계산 -->
<tr>
<td class="total_price">
총 금액
</td>
<td class="total_price">0원</td>
</tr>
<tr>

<td colspan="4"><input type="submit" class="car_submit" value="옵션 고르러 가기" style="width:100%;"></td>
</tr>
</table>
</form>

</main>
