<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h4>웰컴 페이지</h4>
<!-- 현재 사용자가 인증된 상태라면 신원 정보를 출력하고, -->
<!-- 인증되지 않은 사용자에게는 로그인 페이지 링크를 출력함. -->
<c:set var="userPrincipal" value="${pageContext.request.userPrincipal }" />
<c:if test="${empty userPrincipal }">
    <a href="${pageContext.request.contextPath }/login/loginForm.jsp">로그인</a>
</c:if>
<c:if test="${not empty userPrincipal }">
    <h4>현재 사용자 : ${userPrincipal.realUser.memName }, ${userPrincipal.realUser.memRole }</h4>
    <form id="logoutForm" method="post" action="${pageContext.request.contextPath }/login/logout.do"></form>
    <a href="javascript:logoutForm.requestSubmit();">로그아웃</a>
</c:if>

<!-- 1. 인덱스로 들어가고 보안 로그인 넣을려면 webxml에서 설정해줘야됨 -->

<!-- 2. 로그아웃이 되지않으면 로그인 페이지로 들어가야함 -->

<!-- 3. 로그인이 됬으면  pricipal을 사용해서 사용자 정보를 보여주어야함 -->
</body>
</html>