<%--
  Created by IntelliJ IDEA.
  User: PC-14
  Date: 2024-11-04
  Time: 오전 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h4>회원 목록 조회</h4>
<table class="table table-bordered">
    <thead class="table-dark">
        <tr>
            <th>이름</th>
            <th>휴대전화</th>
            <th>이메일</th>
            <th>거주지</th>
            <th>마일리지</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${not empty list }">
            <c:forEach items="${list }" var="member">
        <tr>
            <td>
                <c:url value="/member/memberDetail.do" var="detailUrl">
                    <c:param name="who" value="${member.memId}"/>
                </c:url>
                <a href="${detailUrl}">${member.memName}</a>
            </td>
            <td>${member.memHp}</td>
            <td>${member.memMail}</td>
            <td>${member.memAdd1}</td>
            <td>${member.memMileage}</td>
        </tr>
         </c:forEach>
        </c:if>
        <c:if test="${empty list }">
            <tr>
                <td colspan="5"> 데이터가 없음</td>
            </tr>
        </c:if>
    </tbody>
</table>
