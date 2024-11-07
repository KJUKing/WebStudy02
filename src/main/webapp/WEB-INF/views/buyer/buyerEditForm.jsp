<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-11-08
  Time: 오전 1:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="post">
  <table class="table table-bordered">
    <tr>
      <th>제조사 ID</th>
      <td>
        <input type="text" name="buyerId" class="form-control"
               value="${buyer.buyerId }" readonly />
        <span class="text-danger">${errors.buyerId }</span>
      </td>
    </tr>
    <tr>
      <th>제조사명</th>
      <td>
        <input type="text" name="buyerName" class="form-control"
               value="${buyer.buyerName }" />
        <span class="text-danger">${errors.buyerName }</span>
      </td>
    </tr>
    <tr>
      <th>상품 분류</th>
      <td>
        <select name="buyerLgu" class="form-select">
          <option value="">분류 선택</option>
          <c:forEach items="${lprodList }" var="lprod">
            <option value="${lprod.lprodGu }"
              ${lprod.lprodGu eq buyer.buyerLgu ? "selected" : "" }>
                ${lprod.lprodNm }
            </option>
          </c:forEach>
        </select>
        <span class="text-danger">${errors.buyerLgu }</span>
      </td>
    </tr>
    <tr>
      <th>은행명</th>
      <td>
        <input type="text" name="buyerBankname" class="form-control"
               value="${buyer.buyerBankname }" />
        <span class="text-danger">${errors.buyerBankname }</span>
      </td>
    </tr>
    <tr>
      <th>은행 계좌번호</th>
      <td>
        <input type="text" name="buyerBankno" class="form-control"
               value="${buyer.buyerBankno }" />
        <span class="text-danger">${errors.buyerBankno }</span>
      </td>
    </tr>
    <tr>
      <th>우편번호</th>
      <td>
        <input type="text" name="buyerZip" class="form-control"
               value="${buyer.buyerZip }" />
        <span class="text-danger">${errors.buyerZip }</span>
      </td>
    </tr>
    <tr>
      <th>주소</th>
      <td>
        <input type="text" name="buyerAdd1" class="form-control"
               value="${buyer.buyerAdd1 }" />
        <span class="text-danger">${errors.buyerAdd1 }</span>
      </td>
    </tr>
    <tr>
      <th>상세 주소</th>
      <td>
        <input type="text" name="buyerAdd2" class="form-control"
               value="${buyer.buyerAdd2 }" />
        <span class="text-danger">${errors.buyerAdd2 }</span>
      </td>
    </tr>
    <tr>
      <th>전화번호</th>
      <td>
        <input type="text" name="buyerComtel" class="form-control"
               value="${buyer.buyerComtel }" />
        <span class="text-danger">${errors.buyerComtel }</span>
      </td>
    </tr>
    <tr>
      <th>팩스</th>
      <td>
        <input type="text" name="buyerFax" class="form-control"
               value="${buyer.buyerFax }" />
        <span class="text-danger">${errors.buyerFax }</span>
      </td>
    </tr>
    <tr>
      <th>이메일</th>
      <td>
        <input type="email" name="buyerMail" class="form-control"
               value="${buyer.buyerMail }" />
        <span class="text-danger">${errors.buyerMail }</span>
      </td>
    </tr>
    <tr>
      <th>담당자</th>
      <td>
        <input type="text" name="buyerCharger" class="form-control"
               value="${buyer.buyerCharger }" />
        <span class="text-danger">${errors.buyerCharger }</span>
      </td>
    </tr>
    <tr>
      <th>내선번호</th>
      <td>
        <input type="text" name="buyerTelext" class="form-control"
               value="${buyer.buyerTelext }" />
        <span class="text-danger">${errors.buyerTelext }</span>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <button type="submit" class="btn btn-primary">전송</button>
        <button type="reset" class="btn btn-warning">취소</button>
      </td>
    </tr>
  </table>
</form>
