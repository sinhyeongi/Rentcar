<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script defer="defer" type="text/javascript" src="${ctx }/js/Carlist.js?dsa"></script>
</head>
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
<td>${car.price }</td>
<td>${car.usepeople }</td>
<td>${car.total_qty }</td>
<td class="img_session">
<c:if test="${car.img eq null }">
<img src="http://placehold.it/50x50" alt="no img"/>
</c:if>
<c:if test="${car.img ne null }">
<img src="${ctx }/img/${car.img}" alt="${car.img }" />
</c:if>
</td>
<td>${car.company }</td>
<td>${car.info }</td>
</tr>
</c:forEach>
</table>

