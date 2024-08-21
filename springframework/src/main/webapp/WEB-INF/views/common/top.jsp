
<!-- 태그주석(응답에 포함) -->
<%--jsp주석 (응답에 포함 안됨)--%>
<%-- page 지시자 
	language : 프로그래밍 언어의 종류
	pageEncoding: JSP 소스를 작성할때 사용할 문자셋(다국어 이용 => UTF-8)
	contentType: JSP의 실행결과(응답내용)의 종류(MIME타입; charset= 응답을 구성하는 문자셋)
  	jsp에서 사용할수있는 프로그래밍 언어는 자바밖에 없기때문에 language 생략가능
	pageEncoding을 생략하면 contentType의 charset따라감
--%>
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
	<div class="d-flex flex-column vh-100">
   
   <jsp:include page="/WEB-INF/views/common/nav.jsp"></jsp:include>
   
      <div class="flex-grow-1 m-2">
         <div class="d-flex row">
            <div class="col-md-4">
            
               <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>

            </div>
            <div class="col-md-8">