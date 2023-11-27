<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp"></jsp:include>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="row justify-content-center">
		<div class="col-lg-8 col-md-10 col-sm-12">
			<h2 class="my-3 py-3 shadow-sm bg-light text-center">
				<mark class="orange">비밀번호 찾기</mark>
			</h2>
		</div>
		<div class="col-lg-8 col-md-10 col-sm-12">
			<form action="${root }/user?action=findPw" method="post">
				<div class="mb-3">
					<label for="id" class="form-label">아이디:</label> <input type="text"
						name="id" class="form-control">
				</div>
				<div class="mb-3">
					<label for="id" class="form-label">이름:</label> <input type="text"
						name="name" class="form-control">
				</div>
				<button type="submit" class="btn btn-outline-primary mb-3">비밀번호 찾기</button>
			</form>
		</div>
	</div>
</body>
</html>