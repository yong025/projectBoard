
<%--
  Created by IntelliJ IDEA.
  User: stell
  Date: 2021-08-17
  Time: 오후 5:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Read Page</h1>
<div>

    번호: <input type="text" name="bno" value="${dto.bno}" readonly><br>
    작성일:  <input type="text" name="regdate" value="${dto.regdate}" readonly><br>
    제목: <input type="text" name="title" value="${dto.title}" readonly><br>
    내용:  <input type="text" name="content" value="${dto.content}" readonly><br>
    작성자: <input type="text" name="writer" value="${dto.writer}" readonly><br>
    조회수:  <input type="text" name="viewcount" value="${dto.viewcount}" readonly><br>
    <a href="/board/modify?bno=${dto.bno}"><button type="submit">수정/삭제</button></a>
    <a href="/board/list"><button type="submit">목록</button></a>

</div>
</body>
</html>
