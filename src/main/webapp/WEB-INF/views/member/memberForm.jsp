<%--
  Created by IntelliJ IDEA.
  User: PC-14
  Date: 2024-11-04
  Time: 오후 4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" enctype="application/x-www-form-urlencoded">
    <table class="table">
        <tr><th>아이디</th><td><input class="form-control" type="text" name="memId" /></td>
        <tr><th>비빌번호</th><td><input class="form-control" type="password" name="memPass" /></td></tr>
        <tr><th>이름</th><td><input class="form-control" type="text" name="memName" /></td></tr>
        <tr><th>주민번호 1</th><td><input class="form-control" type="number" name="memRegno1" /></td></tr>
        <tr><th>주민번호 2</th><td><input class="form-control" type="number" name="memRegno2" /></td></tr>
<%--        <tr><th>생일</th><td><input class="form-control" type="text" name="memBir" /></td></tr>--%>
        <tr><th>우편번호</th><td><input class="form-control" type="text" name="memZip" /></td></tr>
        <tr><th>주소1</th><td><input class="form-control" type="text" name="memAdd1" /></td></tr>
        <tr><th>주소2</th><td><input class="form-control" type="text" name="memAdd2" /></td></tr>
        <tr><th>집전화번호</th><td><input class="form-control" type="tel" name="memHometel" /></td></tr>
        <tr><th>회사번호</th><td><input class="form-control" type="tel" name="memComtel" /></td></tr>
        <tr><th>휴대폰</th><td><input class="form-control" type="tel" name="memHp" /></td></tr>
        <tr><th>이메일</th><td><input class="form-control" type="email" name="memMail" /></td></tr>
        <tr><th>직업</th><td><input class="form-control" type="text" name="memJob" /></td></tr>
        <tr><th>취미</th><td><input class="form-control" type="text" name="memLike" /></td></tr>
        <tr><th>기념일</th><td><input class="form-control" type="text" name="memMemorial" /></td></tr>
<%--        <tr><th>기념일자</th><td><input class="form-control" type="text" name="member.memMemorialday" /></td></tr>--%>
    </table>
    <button type="submit">회원가입</button>
</form>
