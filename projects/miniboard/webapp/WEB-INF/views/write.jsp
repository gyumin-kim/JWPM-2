<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글 작성하기</title>
</head>
<body>
<form method="POST" action="/miniboard/write">
    <%-- userId는 sessionScope로 가져온다. --%>
    <%-- country, category, title, content --%>
    제목: <input type="text" name="title"><br>
    내용: <br>
    <textarea name="content" id="content" cols="50" rows="30"></textarea>
    <br>
    <input type="submit">
</form>
</body>
</html>