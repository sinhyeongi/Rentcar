<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<main>
<!--  이미지 영역 -->
<div><img src="http://placehold.it/150x150"/></div>
<!--  메인 소개 영역 -->
<div>
<table>
<tr>
<th>아이디</th>
<th>비밀번호</th>
<th>이메일</th>
<th>전화번호</th>
<th>취미</th>
<th>직업</th>
<th>나이</th>
<th>Info</th>
</tr>
<c:forEach items="${list }" var="vo">
<tr>
<td>${vo.id }</td>
<td>${vo.pw }</td>
<td>${vo.email }</td>
<td>${vo.tel }</td>
<td>${vo.hobby }</td>
<td>${vo.job }</td>
<td>${vo.age }</td>
<td>${vo.info }</td>
<td>
</tr>
</c:forEach>
</table> 
</div>
<div>
<table>
<tr>
<th>차량 번호</th>
<th>이름 </th>
<th>종류</th>
<th>가격</th>
<th>승차 인원</th>
<th>남은 수량</th>
<th>회사 정보</th>
<th>이미지</th>
<th>차량 정보</th>
</tr>
<c:forEach var="car" items="${Carlist }">
<tr>
<td>${car.no }</td>
<td>${car.name }</td>
<td>${car.category }</td>
<td>${car.price }</td>
<td>${car.usepeople }</td>
<td>${car.total_qty }</td>
<c:if test="${car.img eq null }">
<td><img src="http://placehold.it/50x50" alt="no img"/></td>
</c:if>
<c:if test="${car.img ne null }">
<td><img src="${ctx }/img/${car.img}" alt="${car.img }" /></td>
</c:if>
<td>${car.company }</td>
<td>${car.info }</td>
</tr>
</c:forEach>
</table>
</div>
</main>