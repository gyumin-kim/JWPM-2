<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>성수동 맛집 아카이브</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="/css/main.css" />
    <link href="https://fonts.googleapis.com/css?family=Do+Hyeon|Song+Myung|Yeon+Sung|Noto+Serif+KR" rel="stylesheet">
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
        <div class="detail-body">
            <div class="article-info">
                글쓴이 : ${requestScope.article.userId}<br>
                등록일 : ${requestScope.article.regDate} <br><br>
            </div>
            <h1 class="article-title">${requestScope.article.title}</h1>
            <p>[${requestScope.article.country}] [${requestScope.article.category}]</p>
            <p class="article-content">${requestScope.article.content}</p><br>

            <%-- 댓글 목록 --%>
            <c:forEach items="${requestScope.commentList}" var="comment">
                <div class="comment">
                    댓글 id: ${comment.id}
                    글 번호 : ${comment.articleId}
                    댓글 쓴 id : ${comment.userId}
                    <p>${comment.userId} (${comment.regDate})</p>
                    <p>${comment.content}</p>
                </div>
                <%--댓글 id: ${comment.id}--%>
                <%--article_id: ${comment.articleId}--%>
                <%--자신이 입력한 댓글일 경우 삭제버튼 보임 --%>
                <c:if test="${comment.userId == sessionScope.authUser.id}">
                    <a href="/miniboard/delete?article1=${requestScope.article.id}&comment1=${comment.id}"><button>삭제</button></a>
                </c:if><br>
            </c:forEach>

            <%-- 댓글 입력창 --%>
            <c:if test="${sessionScope.authUser != null}">
                <form method="POST" action="/miniboard/detail">
                    <input type="hidden" name="articleId" value="${requestScope.article.id}">
                    <input type="hidden" name="userId" value="${sessionScope.authUser.id}">
                    <%--<div>${requestScope.article.userId}</div>--%>
                    <textarea id="content" name="content" rows="4" cols="70"></textarea>
                    <div><input type="submit" value="댓글 등록"/></div>
                </form><br>
            </c:if>

            <a href="/miniboard/list"><button>목록</button></a>
        </div>
    </div>
</body>
</html>
