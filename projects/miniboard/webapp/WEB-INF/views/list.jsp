<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>성수동 맛집 아카이브</title>
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
    <div class="list-body">
        <form>
            <select id="country" name="country">
                <option value="" selected disabled>음식 종류</option>
                <option value="korean">한식</option>
                <option value="chinese">중식</option>
                <option value="western">양식</option>
                <option value="japanese">일식</option>
            </select>

            <select id="category" name="category">
                <option value="" selected disabled>글 종류</option>
                <option value="promotion">홍보</option>
                <option value="review">후기</option>
            </select>
            <input type="submit" value="선택조건으로 검색"/>
        </form>
        <br>

        <!-- 게시글 목록을 출력한다. -->
        <table class="list-table">
            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>등록일</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.articleList}" var="article">
                <tr>
                    <td>${article.id}</td>
                    <td>
                        <span>[${article.country}] [${article.category}] </span>
                        <a href="/miniboard/detail?id=${article.id}">${article.title}</a>
                    </td>
                    <td>${article.userId}</td>
                    <td>${article.regDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>

        게시글 수 : ${requestScope.articleListSize}&nbsp;
        <a href="/miniboard/write"><button>글쓰기</button></a>
    </div>
</div>
</body>
</html>