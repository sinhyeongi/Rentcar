<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<main>
<!--  이미지 영역 -->
<div><img src="${ctx }/img/rent_logo.jpg" id="Main_log"/></div>
<!--  메인 소개 영역 -->

<button class="car_btn">차량 보기</button>

<div class="category_select" style="visibility:hidden;">
차량 종류 선택&nbsp;&nbsp;&nbsp;&nbsp;<select>
<option value="0">전체 선택</option>
<option value="1">소형</option>
<option value="2">중형</option>
<option value="3">대형</option>
</select>
</div>
<div class="car_table" style="display: none;">
<table>
<tr>
<th>차량 번호</th>
<th>이름 </th>
<th>종류</th>
<th>가격</th>
<th>승차 인원</th>
<th>남은 수량</th>
<th>이미지</th>
<th>회사 정보</th>
<th>차량 정보</th>
</tr>
<c:forEach var="car" items="${Carlist }">
<tr>
<td>${car.no }</td>
<td>${car.name }</td>
<td>
<c:if test="${car.category eq 1}">
소형
</c:if>
<c:if test="${car.category eq 2}">
중형
</c:if>
<c:if test="${car.category eq 3}">
대형
</c:if>
</td>
<td>${car.price }원 / 1시간</td>

<td>${car.usepeople }명</td>
<td>
<c:if test="${car.total_qty ne 0 }">
${car.total_qty }대
</c:if>
<c:if test="${car.total_qty eq 0 }">
매진
</c:if>
</td>
<td class="img_session">
<c:if test="${car.img eq null }">
<img src="http://placehold.it/50x50" alt="no img"/>
</c:if>
<c:if test="${car.img ne null }">
<img src="${ctx }/img/${car.img}" alt="${car.img }" />
</c:if>
<td>${car.company }</td>
<td>${car.info }</td>
</tr>
</c:forEach>
</table>
</div>
</main>
