<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>list</title>
</head>
<body style="margin: 0 50px;">
    <h1>LIST</h1>
    <c:forEach items="${products}" var="product">
        <p>${board.id}</p>
        <p>${board.name}</p>
        <%--<p>${board.category.name}</p>--%>
        <p>${board.description}</p>
    </c:forEach>
</body>
</html>