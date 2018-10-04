<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>LOG IN</title>
    </head>

    <body>
        <h1>관리자 로그인 페이지입니다.</h1><br>
        <form method="POST" action="/guestbook/login">
            암호: <input type="password" name="password"><br>
            <input type="submit">
        </form>
    </body>
</html>
