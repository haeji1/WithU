<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/include/head.jsp"></jsp:include>
	<script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a289b07bb234441b0c8a3328b907b1d8&libraries=services,clusterer,drawing"
    ></script>
</head>
<body>
	<jsp:include page="/include/nav.jsp"></jsp:include>
	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
		<jsp:include page="/include/map.jsp"></jsp:include>
	</div>
	
<jsp:include page="/include/footer.jsp"></jsp:include>
