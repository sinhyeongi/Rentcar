<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<jsp:include page="header.jsp" />
<jsp:include page="${page }" />
<jsp:include page="footer.jsp" />
<script>
$("#subPage").click(function(){
	Changef();
});
function Changef(){
	if($("#footer").hasClass("onSubPage")){
		$("#footer").removeClass("onSubPage");
		$("#footer_View").empty();
		return true;
	}
	$("#footer").addClass("onSubPage");
}
$("#main_btn").click(function(){
	location.href="${ctx}/Main.do";
});
$("#login_btn").click(function(){
	location.href="${ctx}/Login.do";
});
</script>
		
