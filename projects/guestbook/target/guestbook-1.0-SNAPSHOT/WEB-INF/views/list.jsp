<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- JSP도 결국은 Servlet이다! --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST</title>
</head>
<body style="margin: 50px 200px;">
    <h1>LIST</h1>

    <c:if test="${sessionScope.admin != 'true'}">
        <a href="/guestbook/login">관리자 로그인</a>
    </c:if>
    <c:if test="${sessionScope.admin == 'true'}">
        <a href="/guestbook/logout">관리자 로그아웃</a>
    </c:if>
    <br><br>

    방명록 건수: ${requestScope.guestbookSize}<br>

    <form method="POST" action="/guestbook/write">
        이름: <input type="text" name="name"><br>
        내용: <br>
        <textarea name="content" id="content" cols="30" rows="10"></textarea>
        <input type="submit">
    </form>

    <%-- 방명록 목록을 출력한다(EL/JSTL 사용). --%>
    <c:forEach items="${requestScope.guestbookList}" var="guestbook">
        이름 : ${guestbook.name}<br>
        내용 : ${guestbook.content}<br>
        작성시간 : ${guestbook.regdate}<br>
        <%--관리자만 삭제 가능--%>
        <c:if test="${sessionScope.admin == 'true'}">
            <a href="/guestbook/delete?id=${guestbook.id}">삭제</a><br><br>
        </c:if>
    </c:forEach>

    <%-- 방명록 목록을 출력한다. --%>
    <%--이름 : 홍길동 <br>--%>
    <%--내용 : 자바가 ... <br>--%>
    <%--<a href="/guestbook/delete?id=1">삭제</a><br><br>--%>
    <%--이름 : 고길동 <br>--%>
    <%--내용 : 하하  ... <br>--%>
    <%--<a href="/guestbook/delete?id=2">삭제</a><br>--%>
</body>
</html>
