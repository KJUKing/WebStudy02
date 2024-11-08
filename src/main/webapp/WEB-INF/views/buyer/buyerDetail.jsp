<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-11-08
  Time: 오전 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-bordered">
    <tr>
        <th>제조사명</th>
        <td>${buyer.buyerName }</td>
    </tr>
    <tr>
        <th>상품 분류</th>
        <td>${buyer.buyerLgu }</td>
    </tr>
    <tr>
        <th>은행명</th>
        <td>${buyer.buyerBankname }</td>
    </tr>
    <tr>
        <th>은행 계좌번호</th>
        <td>${buyer.buyerBankno }</td>
    </tr>
    <tr>
        <th>우편번호</th>
        <td>${buyer.buyerZip }</td>
    </tr>
    <tr>
        <th>주소</th>
        <td>${buyer.buyerAdd1 }</td>
    </tr>
    <tr>
        <th>상세 주소</th>
        <td>${buyer.buyerAdd2 }</td>
    </tr>
    <tr>
        <th>전화번호</th>
        <td>${buyer.buyerComtel }</td>
    </tr>
    <tr>
        <th>팩스</th>
        <td>${buyer.buyerFax }</td>
    </tr>
    <tr>
        <th>이메일</th>
        <td>${buyer.buyerMail }</td>
    </tr>
    <tr>
        <th>담당자</th>
        <td>${buyer.buyerCharger }</td>
    </tr>
    <tr>
        <th>내선번호</th>
        <td>${buyer.buyerTelext }</td>
    </tr>
    <tr>
        <td colspan="1">
            <c:url var="updateUrl" value="/buyer/buyerUpdate.do">
                <c:param name="prodId" value="${buyer.buyerId }" />
            </c:url>
            <a class="btn btn-primary" href="${updateUrl}">수정</a>
        </td>
    </tr>
</table>
