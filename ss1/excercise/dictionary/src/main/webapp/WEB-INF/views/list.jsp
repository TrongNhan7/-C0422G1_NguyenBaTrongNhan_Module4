<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/15/2022
  Time: 6:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="post">
    <h3>Enter word</h3>
    <input type="text"  name="word" value="${keyWord}">
    <button type="submit" >search</button>
</form>

<h3>${keyWord} : ${result}</h3>
</body>
</html>
