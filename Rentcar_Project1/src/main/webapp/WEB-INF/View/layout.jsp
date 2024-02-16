<%@ page pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<c:if test="${page ne 'Carlist.jsp' }">
<jsp:include page="header.jsp" />
</c:if>
<jsp:include page="${page }" />
<c:if test="${page ne 'Carlist.jsp' }">
<jsp:include page="footer.jsp" />
</c:if>
