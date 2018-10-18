<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>글 작성하기</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="/css/main.css" />
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Song+Myung|Yeon+Sung" rel="stylesheet">
</head>
<body class="bg">
    <div class="top-header">
        <a href="/" class="home-link"><span class="logo">성수동 맛집 아카이브</span></a>
        <%-- 로그인 되어 있으면 로그아웃 버튼 보이게 --%>
        <c:if test="${sessionScope.authUser != null}">
            <a href="/miniboard/logout"><button class="logout-button">로그아웃</button></a>
        </c:if>
    </div>

    <div class="list-wrapper">
        <div class="write-body">
            <form method="POST" action="/miniboard/write">
                <%-- userId는 sessionScope로 가져온다. --%>
                <%-- country, category, title, content --%>
                <select name="country" required>
                    <option value="" selected disabled hidden>음식 종류</option>
                    <option value="korean">한식</option>
                    <option value="chinese">중식</option>
                    <option value="western">양식</option>
                    <option value="japanese">일식</option>
                </select>
                <select name="category" required>
                    <option value="" selected disabled hidden>글 종류</option>
                    <option value="promotion">홍보</option>
                    <option value="review">후기</option>
                </select><br><br>

                <span>제목</span>
                <div><input type="text" name="title" required><br></div><br>
                <span>내용</span><br>
                <textarea name="content" id="content" cols="120" rows="20" required></textarea>
                <br><br>
                <input type="submit">
            </form>
        </div>
    </div>
</body>
</html>