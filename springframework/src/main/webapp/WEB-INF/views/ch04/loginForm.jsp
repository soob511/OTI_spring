<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%--라이브러리가 제공해주는 태그를 쓸수 있게 해줌 접두사로 form을 붙여줘야함!--%>
    <%--
    include 지시자의 역할: 외부의 파일의 내용을 가져와서 삽입시켜줌 --%>
    <%--소스복사 --%>
    <%@include file="/WEB-INF/views/common/top.jsp" %>
        <div class="card">
           <div class="card-header">로그인 양식</div>
           <div class="card-body">
              <form class="m-2" method="post" action="login">
                 <div class="form-group mb-2">
                     <label for="mid">아이디</label>
                     <input type="text" class="form-control" id="mid" name="mid"  value="${ch04LoginForm.mid}">
                     <div class="text-danger" style="font-size: 0.7rem">
                     	<form:errors path="ch04LoginForm.mid"/> <!-- path = dto의 어떤 필드 이름이냐 -->
                     </div>
                 </div>
                 
                 <div class="form-group mb-2">
                     <label for="mpassword">패스워드</label>
                     <input type="password" class="form-control" id="mpassword" name="mpassword"  value="${ch04LoginForm.mpassword}">
                    <div class="text-danger" style="font-size: 0.7rem">
                    	<form:errors path="ch04LoginForm.mpassword"/>
                    </div>
                 </div>
                 
                 <!-- 제출 버튼: 양식의 데이터를 서버로 보내겠다. -->
                 <button type="submit" class="btn btn-info btn-sm">로그인</button> 
              </form>
           </div>
        </div>
	  <%--include 액션의 역할: 외부의 JSP를 실행하고 그 결과를 삽입시켜줌--%>
	  <%-- 나중에 java코드로 바뀜--%>
	  <jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include> 