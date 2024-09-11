
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    <%--
    include 지시자의 역할: 외부의 파일의 내용을 가져와서 삽입시켜줌 --%>
    <%--소스복사 --%>
    <%@include file="/WEB-INF/views/common/top.jsp" %>
<div class="card">
	<div class="card-header">
		Home
	</div>
	<div class = "card-body">	
		로그인이 되어있지 않거나
		 현재 로그인한 사용자는 접근할 수 없습니다.
	</div>
</div>
	  <%--include 액션의 역할: 외부의 JSP를 실행하고 그 결과를 삽입시켜줌--%>
	  <%-- 나중에 java코드로 바뀜--%>
	  <jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include> 