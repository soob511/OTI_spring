
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
    <%--
    include 지시자의 역할: 외부의 파일의 내용을 가져와서 삽입시켜줌 --%>
    <%--소스복사 --%>
    <%@include file="/WEB-INF/views/common/top.jsp" %>
<div class="card">
	<div class="card-header">
		권한별 내용보기
	</div>
	<div class = "card-body">	
			<ul>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li>ROLE_ADMIN이 볼 수 있는 내용</li>
				</sec:authorize>
				
				<sec:authorize access="hasRole('ROLE_MANAGER')">
					<li>ROLE_MANAGER가 볼 수 있는 내용</li>
				</sec:authorize>
				
				<sec:authorize access="hasRole('ROLE_USER')">
					<li>ROLE_USER가 볼 수 있는 내용</li>
				</sec:authorize>
			</ul>
			<hr>
			
			<a href="admin/page">ROLE_ADMIN권한으로 요청</a><br/>
			<a href="manager/page">ROLE_MANAGER권한으로 요청</a><br/>
			<a href="user/page">ROLE_USGER권한으로 요청</a><br/>
	</div>
</div>
	  <%--include 액션의 역할: 외부의 JSP를 실행하고 그 결과를 삽입시켜줌--%>
	  <%-- 나중에 java코드로 바뀜--%>
	  <jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include> 