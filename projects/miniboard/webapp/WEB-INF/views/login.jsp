<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>로그인</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="/css/main.css" />
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Song+Myung|Yeon+Sung" rel="stylesheet">
</head>
<body class="bg">
    <div class="list-wrapper">
        <div class="list-body">
            <form method="post" action="/miniboard/login" class="login-form">
                아이디 : <input type="text" name="name" required><br>
                암호 : <input type="password" name="password" required><br><br>

                <input type="submit" value="로그인">
            </form>

            <a href="/miniboard/signup"><button>회원 가입</button></a><br>

            <c:if test="${isIdNull == true}">
                <p style="color: red; font-weight: bold">존재하지 않는 아이디입니다.</p>
            </c:if>

            <c:if test="${wrongPw == true}">
                <p style="color: red; font-weight: bold">비밀번호를 확인하세요.</p>
            </c:if>

        </div>
    </div>
</body>
</html>
