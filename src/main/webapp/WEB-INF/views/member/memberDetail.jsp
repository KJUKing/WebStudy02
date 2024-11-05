<%--
  Created by IntelliJ IDEA.
  User: PC-14
  Date: 2024-11-04
  Time: 오전 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>


<table class="table table-bordered">
    <tr>
        <th>회원아이디</th>
        <td>${member.memId }</td>
    </tr>
    <tr>
        <th>이름</th>
        <td>${member.memName }</td>
    </tr>
    <tr>
        <th>주민번호 1</th>
        <td>${member.memRegno1 }</td>
    </tr>
    <tr>
        <th>주민번호 2</th>
        <td>${member.memRegno2 }</td>
    </tr>
    <tr>
        <th>생일</th>
        <td>${member.memBir }</td>
    </tr>
    <tr>
        <th>우편번호</th>
        <td>${member.memZip }</td>
    </tr>
    <tr>
        <th>주소1</th>
        <td>${member.memAdd1 }</td>
    </tr>
    <tr>
        <th>주소2</th>
        <td>${member.memAdd2 }</td>
    </tr>
    <tr>
        <th>집전화번호</th>
        <td>${member.memHometel }</td>
    </tr>
    <tr>
        <th>회사번호</th>
        <td>${member.memComtel }</td>
    </tr>
    <tr>
        <th>휴대폰</th>
        <td>${member.memHp }</td>
    </tr>
    <tr>
        <th>이메일</th>
        <td>${member.memMail }</td>
    </tr>
    <tr>
        <th>직업</th>
        <td>${member.memJob }</td>
    </tr>
    <tr>
        <th>취미</th>
        <td>${member.memLike }</td>
    </tr>
    <tr>
        <th>기념일</th>
        <td>${member.memMemorial }</td>
    </tr>
    <tr>
        <th>기념일자</th>
        <td>${member.memMemorialday }</td>
    </tr>
    <tr>
        <th>마일리지</th>
        <td>${member.memMileage }</td>
    </tr>
    <tr>
        <th>탈퇴여부</th>
        <td>${member.memDelete }</td>
    </tr>
    <tr>
        <th>회원권한</th>
        <td>${member.memRole }</td>
    </tr>
    <c:set value="${pageContext.request.userPrincipal}" var="userPrincipal"/>
    <c:if test="${userPrincipal.name eq member.memId}">
    <tr>
            <td colspan="2">
                    <a class="btn btn-primary" href="<c:url value='/member/memberUpdate.do'/>"> 수정</a>
                    <button type="button" class="btn btn-danger"
                            data-bs-toggle="modal" data-bs-target="#exampleModal">탈퇴</button>
            </td>
    </tr>
    </c:if>

</table>

<c:if test="${userPrincipal.name eq member.memId}">
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="<c:url value="/member/memberDelete.do"/>" method="post">
            <div class="modal-body">
                <input type="password" name="memPass" class="form-control" required/>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-danger">탈퇴</button>
            </div>
            </form>
        </div>
    </div>
</div>
</c:if>