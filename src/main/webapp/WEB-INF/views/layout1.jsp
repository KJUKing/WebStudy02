<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <jsp:include page="/WEB-INF/includee/preScript.jsp" />
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/includee/header.jsp" />
</header>
<main>
    <jsp:include page="${viewName}" />
</main>

<jsp:include page="/WEB-INF/includee/postScript.jsp" />
</body>
</html>