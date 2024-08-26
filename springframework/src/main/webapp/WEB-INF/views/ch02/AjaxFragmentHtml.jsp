
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap.bundle.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
	</head>
	<body>
		<div class="card">
			<div class="card-header">
				AJAX의 HTML조각 응답
			</div>
			<div class = "card-body">
				<img height="100" src="${pageContext.request.contextPath}/resources/image/photos/photo1.jpg" class="me-2/">
				<img height="100" src="${pageContext.request.contextPath}/resources/image/photos/photo2.jpg" class="me-2/">
				<img height="100" src="${pageContext.request.contextPath}/resources/image/photos/photo3.jpg" class="me-2/">
			</div>
		</div>
	</body>
</html>