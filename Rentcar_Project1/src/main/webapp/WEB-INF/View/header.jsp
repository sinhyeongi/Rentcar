<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<!-- jquert  --> 
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<c:if test="${page eq 'Carreserve.jsp' }">
<!-- flatpickr js import	 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
<script src="https://cdn.jsdelivr.net/npm/flatpickr/dist/l10n/ko.js"></script>
</c:if>
<script defer="defer" type="text/javascript" src="${ctx }/js/header.js?dsddssaa"></script>
<c:if test="${page eq 'Main.jsp' }">
<script defer="defer" type="text/javascript" src="${ctx }/js/Mainjs.js?ddsa"></script>
</c:if>
<c:if test="${page eq 'Login.jsp' }">
<script defer="defer" type="text/javascript" src="${ctx }/js/Login.js?d1adddsa"></script>
</c:if>
<c:if test="${page eq 'Carreserve.jsp' }">
<script defer="defer" type="text/javascript" src="${ctx }/js/Carreserve.js?ds32dsd3a"></script>
</c:if>
<c:if test="${page eq 'Carreserve_option.jsp' }">
<script defer="defer" type="text/javascript" src="${ctx }/js/Carreserve_option.js?dadsdsa"></script>
</c:if>
<c:if test="${page eq 'Car_Infomation.jsp' }">
<script defer="defer" type="text/javascript" src="${ctx }/js/Car_Infomation.js?s32sa"></script>
</c:if>
<c:if test="${page eq 'MemberInfo.jsp' }">
<script defer="defer" type="text/javascript" src="${ctx }/js/MemberInfo.js?ddsda"></script>
</c:if>
<c:if test="${page eq 'CarreserveInfo.jsp' }">
<script defer="defer" type="text/javascript" src="${ctx }/js/CarreserveInfo.js?ddsddsa"></script>
</c:if>
<c:if test="${page eq 'MemberInsert.jsp' }">
<script defer="defer" type="text/javascript" src="${ctx }/js/MemberInsert.js?dda"></script>
</c:if>
<c:if test="${page eq 'addCar.jsp' }">
<script defer="defer" type="text/javascript" src="${ctx }/js/addCar.js?dddsdsdsadsaa"></script>
</c:if>
<!-- css link -->
<link href="${ctx }/css/header.css?d3dddsdsda" rel="stylesheet" type="text/css">
<c:if test="${page eq 'Login.jsp' }">
<link href="${ctx }/css/Login.css?dddd3" rel="stylesheet" type="text/css">
</c:if>
<c:if test="${page eq 'Carreserve.jsp' }">
<link href="${ctx }/css/CarReserve.css?ddddsd3" rel="stylesheet" type="text/css">
</c:if>
<c:if test="${page eq 'Carreserve_option.jsp' }">
<link href="${ctx }/css/CarReserve_option.css?ddddsd3" rel="stylesheet" type="text/css">
</c:if>
<c:if test="${page eq 'Car_Infomation.jsp' }">
<link href="${ctx }/css/Car_Infomation.css?dddd3" rel="stylesheet" type="text/css">
</c:if>
<c:if test="${page eq 'MemberInfo.jsp' }">
<link href="${ctx }/css/MemberInfo.css?dd323" rel="stylesheet" type="text/css">
</c:if>
<c:if test="${page eq 'CarreserveInfo.jsp' }">
<link href="${ctx }/css/CarreserveInfo.css?dd231ds" rel="stylesheet" type="text/css">
</c:if>
<c:if test="${page eq 'MemberInsert.jsp' }">
<link href="${ctx }/css/MemberInsert.css?ddd32sa3" rel="stylesheet" type="text/css">
</c:if>
<c:if test="${page eq 'addCar.jsp' }">
<link href="${ctx }/css/addCar.css?ddd32sa3" rel="stylesheet" type="text/css">
</c:if>
</head>
<body>
<input type="hidden" value="${log }" id="Main_log_session">
<header>
<div>
<span id="Main_img_span"><img src="${ctx }/img/rent_logo.jpg" alt="log" id="Main_log_header"></span>
<button id="main_btn">메인으로</button>
<c:if test="${log eq null }">
<button id="login_btn">로그인</button>
<button id="member_insert_btn">회원가입</button>
</c:if>
<c:if test="${log ne null and log ne 'admin'}">
<button id="logout_btn">로그아웃</button>
<button id="car_btn">차량 예약</button>
</c:if>
<c:if test="${log ne 'admin'}">
<button id="search_btn">예약 정보</button>
<button id="memberinfo_btn">나의 정보</button>
</c:if>
<c:if test="${log eq 'admin'}">
	<button id="logout_btn">로그아웃</button>
	<button id="admin_Carreserve_all">예약 목록 보기</button>
	<button id="admin_car_add">차량 추가하기</button>
	<button id="admin_member">멤버 관리하기</button>
	<button id="admin_car">차량 관리하기</button>
</c:if>
</div>
</header>
<script>

</script>