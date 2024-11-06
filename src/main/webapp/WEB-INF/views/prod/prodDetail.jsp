<%--
  Created by IntelliJ IDEA.
  User: PC-14
  Date: 2024-11-06
  Time: 오후 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4>상품 상세 조회</h4>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>상품명</th>
        <th>상품분류이름</th>
        <th>제조사</th>
        <th>구매가</th>
        <th>판매가</th>
        <th>입고일</th>
        <th>소재지</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${not empty prod }">
        <c:forEach items="${prod }" >
            <tr>
                <td>${prod.prodName}</td>
                <td>
                    <c:url value="/buyer/buyerDetail.do" var="detailUrl">
                        <c:param name="what" value="${prod.buyer.buyerId}"/>
                    </c:url>
                    <a href="${detailUrl}">${prod.buyer.buyerName}</a>
                </td>
                <td>${prod.lprod.lprodNm}</td>
                <td>${prod.prodCost}</td>
                <td>${prod.prodPrice}</td>
                <td>${prod.prodInsdate}</td>
                <td>${prod.buyer.buyerAdd1}</td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${empty prod }">
        <tr>
            <td colspan="7"> 데이터가 없음</td>
        </tr>
    </c:if>
    </tbody>
</table>
