<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-11-08
  Time: 오전 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-bordered">
  <thead>
  <tr>
    <th>제조사명</th>
    <th>상품 분류</th>
    <th>은행명</th>
    <th>메일</th>
  </tr>
  </thead>
  <tbody>
  <c:if test="${not empty buyerList }">
    <c:forEach items="${buyerList }" var="buyer">
      <tr>
        <td>
          <c:if test="${buyer eq lastCreated }">
            <c:set var="idExpr" value="id='lastCreated'" />
            <c:remove var="lastCreated" scope="session"/>
          </c:if>
          <c:url value="/buyer/buyerDetail.do" var="detailUrl">
            <c:param name="what" value="${buyer.buyerId }"/>
          </c:url>
          <a ${idExpr } data-href="${detailUrl }" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample">${buyer.buyerName }</a>
        </td>
        <td>${buyer.buyerLgu }</td>
        <td>${buyer.buyerBankname }</td>
        <td>${buyer.buyerMail }</td>
      </tr>
    </c:forEach>
  </c:if>
  <c:if test="${empty buyerList }">
    <tr>
      <td colspan="4"> 구매처 없음. </td>
    </tr>
  </c:if>
  </tbody>
  <tr>
    <td colspan="1">
      <a class="btn btn-primary" href="<c:url value='/buyer/buyerInsert.do'/>"> 추가</a>
    </td>
  </tr>
</table>

<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasExampleLabel">Offcanvas</h5>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">
    asdfsad
  </div>
</div>

<script src="${pageContext.request.contextPath }/resources/js/app/buyer/buyerList.js"></script>


