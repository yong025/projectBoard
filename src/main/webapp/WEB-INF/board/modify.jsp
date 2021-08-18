<%--
  Created by IntelliJ IDEA.
  User: stell
  Date: 2021-08-17
  Time: 오후 7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<style>
    .modify{
        background-color: lightgray;
    }
</style>
<head>
    <title>Modify page</title>
</head>
<body>
<h1>Modify Page</h1>
<form action="/board/modify" method="post">
    번호: <input type="text" name="bno" value="${dto.bno}" class="modify" readonly><br>
    작성일:  <input type="text" name="regdate" value="${dto.regdate}" class="modify" readonly><br>
    제목: <input type="text" name="title" value="${dto.title}" ><br>
    내용:  <input type="textarea" name="content" value="${dto.content}" ><br>
    작성자: <input type="text" name="writer" value="${dto.writer}" class="modify" readonly><br>
    조회수:  <input type="text" name="viewcount" value="${dto.viewcount}" class="modify" readonly><br>
<button type="submit">수정</button>
</form>
<form action="/board/remove?bno=${dto.bno}" method="post">
    <button type="submit">삭제</button>
</form>
</body>
</html>
