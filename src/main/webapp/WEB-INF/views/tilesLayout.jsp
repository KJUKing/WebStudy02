
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>tilesLayout.jsp</title>
    <tiles:insertAttribute name="preScript"/>
</head>
<body>
<h1>타일즈 레이아웃 동작</h1>
<header>
    <tiles:insertAttribute name="header"/>
</header>
<main>
    <tiles:insertAttribute name="content"/>
</main>
    <tiles:insertAttribute name="postScript"/>
</body>
</html>
