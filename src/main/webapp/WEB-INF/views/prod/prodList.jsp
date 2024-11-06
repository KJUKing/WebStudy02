<%--
  Created by IntelliJ IDEA.
  User: PC-14
  Date: 2024-11-06
  Time: 오후 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4>상품 목록 조회</h4>
<table class="table table-bordered">
    <thead>
        <tr>
            <th>상품명</th>
            <th>상품분류이름</th>
            <th>상품제조사이름</th>
            <th>구매가</th>
            <th>판매가</th>
            <th>입고일</th>
            <th>소재지</th>
        </tr>
    </thead>
    <tbody>
    <c:if test="${not empty prodList }">
        <c:forEach items="${prodList }" var="prod">
            <tr>
                <td>
                    <c:url value="/prod/prodDetail.do" var="detailUrl">
                        <c:param name="what" value="${prod.prodId}"/>
                    </c:url>
                    <a href="${detailUrl}">${prod.prodName}</a>
                </td>
<%--                <td>${prod.prodName}</td>--%>
                <td>${prod.lprod.lprodNm}</td>
                <td>${prod.buyer.buyerName}</td>
                <td>${prod.prodCost}</td>
                <td>${prod.prodPrice}</td>
                <td>${prod.prodInsdate}</td>
                <td>${prod.buyer.buyerAdd1}</td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty prodList }">
        <tr>
            <td colspan="7"> 데이터가 없음</td>
        </tr>
    </c:if>
    </tbody>
</table>
