<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
	<ul class="navbar-nav me-auto">
		<li class="nav-item"><a class="nav-link" href="${root}/board/list">게시판</a></li>
	</ul>
	<c:choose>
		<%-- session에 userInfo 객체 없는 경우(로그인 X) --%>
		<c:when test="${empty userinfo }">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="${root }/member/login">로그인</a></li>
			</ul>
		</c:when>
		<%-- session에 userInfo 객체 있는 경우(로그인 O) --%>
		<c:otherwise>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link disabled">${userinfo.userId }님
						반갑습니다.</a></li>
				<li class="nav-item"><a class="nav-link" href="${root }/member/logout">로그아웃</a></li>
				<li style="align-self: center">				
					<form action="${root }/member/mypage" method="post">					
						<input type="hidden" value="${userinfo.userId }" name="id">
						<button style="background-color: #212529; border: none; color: #ffffff8c;" type="submit">마이페이지</button>
					</form>
				</li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>