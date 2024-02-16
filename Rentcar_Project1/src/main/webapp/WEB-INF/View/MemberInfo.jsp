<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<main class="MemberInfo_main">
<h2>${vo.id }님의 회원 정보</h2>
<form method="post">
<input type="hidden" name="id" id="id" value="${vo.id }">
<table>
	<tr>
		<th>아이디</th><td>${vo.id }</td>
	</tr>
	<tr>
		<th>이메일</th><td><input type="text" name="email" id="email" value="${vo.email }" placeholder="sample@sample.com"></td>
	</tr>
	<tr>
		<th>전화번호</th><td><input type="text" name="tel" id="tel" value="${vo.tel }" placeholder="010-1111-1111"></td>
	</tr>
	<tr>
		<th>취미</th><td><input type="text" name="hobby" id="hobby" value="${vo.hobby }"></td>
	</tr>
	<tr>
		<th>직 업</th><td><input type="text" name="job" id="job" value="${vo.job }"></td>
	</tr>
	<tr>
		<th>나 이</th><td><input type="number" name="age" id="age" value="${vo.age }"></td>
	</tr>
	<tr>
		<th colspan="2">자기소개</th>
	</tr>
	<tr>
		<td colspan="2"><textarea rows="3" cols="12" name="info" id="info">${vo.info }</textarea></td>
	</tr>
	<tr>
	<td colspan="2"><input type="button" id="MemberInfo_submit" value="수정하기"></td>
	</tr>
	<tr>
	<td colspan="2"><input type="button" id="MemberDelete_btn" value="회원 탈퇴"></td>
	</tr>
</table>
</form>
</main>