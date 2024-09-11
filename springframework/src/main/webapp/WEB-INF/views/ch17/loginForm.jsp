
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--
    include 지시자의 역할: 외부의 파일의 내용을 가져와서 삽입시켜줌 --%>
    <%--소스복사 --%>
    <%@include file="/WEB-INF/views/common/top.jsp" %>
<div class="card">
	<div class="card-header">
		로그인
	</div>
	<div class = "card-body">	
	 		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
          		<div class="alert alert-danger mt-2" role="alert">
          		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message =='Bad username'}">
          			 	아이또는 비밀번호가 틀립니다.
          		</c:if>
          		</div>
          	</c:if> 
            <form method="post" action="${pageContext.request.contextPath}/login"><!-- 모든요청에서 로그인 -->
        <%--      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
             <div class="form-group mb-2">
                 <label for="mid">Member ID</label>
                 <input type="text" class="form-control" id="mid" name="mid">
             </div>
             <div class="form-group mb-2">
                <label for="mpassword">Member Password</label>
                <input type="password" class="form-control" id="mpassword" name="mpassword">
             </div>
             <button type="submit" class="btn btn-info btn-sm mt-2">로그인</button>
          </form>  
          
    
	</div>
</div>
	  <%--include 액션의 역할: 외부의 JSP를 실행하고 그 결과를 삽입시켜줌--%>
	  <%-- 나중에 java코드로 바뀜--%>
	  <jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include> 
