<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<main class="MemberInsert_main">
<h2>회원가입</h2>
<table>
	<tr>
		<td>아이디</td><td><input type="text" required="required" name="id" id="id" placeholder="아이디를 입력해주세요"><input type="button" id="id_check" value="중복체크"></td>
	</tr>
	<tr>
		<td>비밀번호</td><td><input type="password" required="required" name="pw" id="pw" placeholder="비밀번호를 입력해주세요"></td>
	</tr>
	<tr>
		<td>이메일</td><td><input type="text" required="required" name="email" id="email" placeholder="sample@sample.com"></td>
	</tr>
	<tr>
		<td>전화번호</td><td><input type="text" required="required" name="tel" id="tel" placeholder="010-1234-1234"></td>
	</tr>
	<tr>
		<td>취미</td><td><input type="checkbox" name="hobby" id="hobby" value="게임"><span>게임</span>
		<input type="checkbox" name="hobby" id="hobby" value="스포츠"><span>스포츠</span>
		<input type="checkbox" name="hobby" id="hobby" value="공부"><span>공부</span></td>
	</tr>
	<tr>
		<td>직업</td><td><input type="text" required="required" name="job" id="job" placeholder="직업"></td>
	</tr>
	<tr>
		<td>나이</td><td><input type="number" required="required" name="age" id="age" placeholder="나이를 입력해주세요"></td>
	</tr>
	<tr>
		<td>자기소개</td><td><textarea rows="5" cols="30" name="info" id="info" placeholder="자기소개 글"></textarea> </td>
	</tr>
	<tr>
	<td><input type="button" value="회원가입 하기" class="memberinsert_btn"></td>
	</tr>
</table>
</main>