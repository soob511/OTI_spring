
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--
    include 지시자의 역할: 외부의 파일의 내용을 가져와서 삽입시켜줌 --%>
    <%--소스복사 --%>
    <%@include file="/WEB-INF/views/common/top.jsp" %>
<div class="card">
	<div class="card-header">
		장바구니
	</div>
	<div class = "card-body">	
		<div class= "m-3">
			<ul>
				<!--<cart : session에 저장된 key 값
				get컨텐츠 호출해서 리턴값을 사용
				var 어떤변수에 저장할것이냐 -->
				<!--  items: 배열 리스트 등을 참조-->
				<c:forEach items="${cart.contents}" var="item"> 
			
					<li class="m-2"><span>${item.pname}</span><a href="deleteitem?pno=${item.pno}" class="btn btn-danger btn-sm">삭제</a></li>
				</c:forEach>
			</ul>
		</div>
		
	</div>
</div>
	  <%--include 액션의 역할: 외부의 JSP를 실행하고 그 결과를 삽입시켜줌--%>
	  <%-- 나중에 java코드로 바뀜--%>
	  <jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include> 