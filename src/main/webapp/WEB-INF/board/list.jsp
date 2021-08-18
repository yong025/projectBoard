<%--
  Created by IntelliJ IDEA.
  User: stell
  Date: 2021-08-17
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        textarea{
            width: 80%;
            height: 100px;
        }
    </style>
    <title>List</title>
</head>
<body>
<h1>List JSP Page</h1>
<c:forEach items="${list}" var="list">
    <p>
    번호: ${list.bno}
    제목:<a href="/board/read?bno=${list.bno}"> ${list.title}</a>
    작성자: ${list.writer}
    작성일: ${list.regdate}
    조회수: ${list.viewcount}
    </p>
</c:forEach>
<form action="/board/write" method="get">
<button type="submit">글쓰기</button>
</form>
</body>
</html>
