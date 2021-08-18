<%--
  Created by IntelliJ IDEA.
  User: stell
  Date: 2021-08-17
  Time: 오후 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <style>
        textarea{
            width: 80%;
            height: 100px;
        }
    </style>
    <title>Title</title>
</head>
<body>
<h1>WRITE JSP Page</h1>

<form action="/board/write" method="post">

    제목:<input type="text" name="title"><br>
    내용:<textarea placeholder="본문 입력" name="content"></textarea><br>
    작성자:<input type="text" name="writer"><br>
    <button type="submit">Write</button>

</form>
</body>
</html>
