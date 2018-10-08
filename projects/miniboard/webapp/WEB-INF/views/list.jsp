<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

게시글 수 : ${requestScope.articleListSize}<br>


<!-- 게시글 목록을 출력한다. -->
<c:forEach items="${requestScope.articleList}" var="article">
    이름 : ${article.title} <br>
    내용 : ${article.content} <br>
</c:forEach>


</body>
</html>
