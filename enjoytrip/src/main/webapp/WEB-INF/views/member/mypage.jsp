<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/include/head.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row justify-content-center">
		<div class="col-lg-8 col-md-10 col-sm-12">
			<h2 class="my-3 py-3 shadow-sm bg-light text-center">
				<mark class="orange">마이페이지</mark>
			</h2>
		</div>
		<div class="col-lg-8 col-md-10 col-sm-12">
			<form action="${root }/member/modify" method="get">
				<div class="mb-3">
					<label for="id" class="form-label">아이디:</label> <input
						readonly="readonly" value="${info.userId }" name="userId"
						class="form-control">
				</div>
				<div class="mb-3">
					<label for="id" class="form-label">이름:</label> <input
						readonly="readonly" value="${info.userName }" class="form-control">
				</div>
				<div class="mb-3">
					<label for="id" class="form-label">비밀번호:</label> <input
						type="password" name="userPwd" class="form-control" placeholder="변경할 비밀번호를 입력하세요">
				</div>
				<div class="mb-3">
					<label for="id" class="form-label">이메일:</label> <input readonly="readonly"
						value="${info.emailId }" class="form-control">
				</div>
				<div class="mb-3">
					<label for="id" class="form-label">도메인:</label> <input readonly="readonly"
						value="${info.emailDomain }" class="form-control">
				</div>
				<button type="submit" class="btn btn-outline-primary mb-3">비밀번호 수정</button>
			</form>
			<form action="${root }/member/delete" method="post">
				<input type="hidden" name="id" value="${info.userId }">
				<button type="submit" onclick="confirm('정말 탈퇴하시겠습니까?')" class="btn btn-outline-success mb-3">회원
					탈퇴</button>
			</form>
		</div>
	</div>
</body>
</html>