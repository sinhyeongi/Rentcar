<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<form method="post">
<table>
<tr>
<th>이름</th><td><input type="text" name="name" style="width:100%; box-sizing:border-box;" required="required"></td>
</tr>
<tr>
<th>아이디</th><td><input type="text" name="id" id="id" style="width:100%; box-sizing:border-box;" required="required"></td>
</tr>
<tr>
<th>비밀번호</th><td><input type="password" name="pw" id="pw" style="width:100%; box-sizing:border-box;" required="required"></td>
</tr>
<tr>
<th>이메일</th><td><input type="text" name="pw" id="pw" style="width:45%; box-sizing:border-box;" required="required"> @ <select style="width:45%; box-sizing:border-box; text-align:center;">
<option value="gmail.com">gmail.com</option>
<option value="naver.com">naver.com</option>
<option value="daum.net">daum.net</option>
</select> 
</td>
</tr>
</table>
</form>