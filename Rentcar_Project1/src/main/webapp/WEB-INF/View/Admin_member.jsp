<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<main class="Admin_member_main">
	<h2>전체 회원 정보</h2>
	<table>
		<tr>
			<th>아이디</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>취미</th>
			<th>직업</th>
			<th>나이</th>
			<th>자기 소개 글</th>
			<th>회원 삭제</th>
		</tr>
		<c:forEach var="vo" items="${list }">
			<c:if test="${vo.id ne 'admin' }">
				<tr>
					<td><span>${vo.id }</span></td>
					<td><span>${vo.email }</span></td>
					<td><span>${vo.tel }</span></td>
					<td><span>${vo.hobby }</span></td>
					<td><span>${vo.job }</span></td>
					<td><span>${vo.age }</span></td>
					<td><span>${vo.info }</span></td>
					<td><button class="deleteuser_ad_btn">삭제하기</button></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</main>