<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST</title>
</head>
<body style="margin: 40px 300px;">
    <h1>LIST</h1>

    <a href="/guestbook/login">관리자 로그인</a><br>
    <a href="/guestbook/logout">관리자 로그아웃</a>
    <br><br>

    <form method="POST" action="/guestbook/write">
        이름: <input type="name" name="name"><br>
        내용: <br>
        <textarea name="content" id="content" rows="10" cols="50"></textarea><br>
        <input type="submit">
    </form><br>

    <%-- 방명록 목록을 출력한다. --%>
    이름 : 홍길동 <br>
    내용 : 자바가 ... <br>
    <a href="/guestbook/delete?num=1">삭제</a><br><br>
    이름 : 고길동 <br>
    내용 : 하하  ... <br>
    <a href="/guestbook/delete?num=2">삭제</a><br>
</body>
</html>
