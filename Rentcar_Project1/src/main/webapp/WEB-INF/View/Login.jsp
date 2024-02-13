<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

</head>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<main class="login_main">
<form method="post">
<table>
<tr>
<th>아이디</th><td><input type="text" name="id" id="id" style="width:100%; box-sizing:border-box;" /></td>
</tr>
<tr>
<th>비밀번호</th><td><input type="password" name="pw" id="pw" style="width:100%; box-sizing:border-box;" /></td>
</tr>
<tr>
<td colspan="2">
<input type="button" value="제출" style="width:50%;" id="login_submit">
</td>
</tr>
</table>
</form>
</main>