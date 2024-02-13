<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<link href="${ctx }/css/header.css?d321" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script defer="defer" type="text/javascript" src="${ctx }/js/Main.js"></script>
<script defer="defer" type="text/javascript" src="${ctx }/js/Login.js"></script>
</head>
<body>
<header>
<div>
<button id="main_btn">메인으로</button>
<c:if test="${log eq null }">
<button id="login_btn">로그인</button>
</c:if>
<c:if test="${log ne null }">
<button id="logout_btn">로그아웃</button>
</c:if>
<button id="car_btn">차량 에약</button>
<button id="search_btn">검색</button>
<button id="QA_btn">Q&A</button>
</div>
</header>
