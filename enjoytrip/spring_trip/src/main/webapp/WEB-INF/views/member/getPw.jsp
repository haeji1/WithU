<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	��й�ȣ�� '${pw }' �Դϴ�
	<form action="${root }/user?action=mvlogin" method="post">
		<button type="submit">�α����ϱ�</button>
	</form>

</body>
</html>