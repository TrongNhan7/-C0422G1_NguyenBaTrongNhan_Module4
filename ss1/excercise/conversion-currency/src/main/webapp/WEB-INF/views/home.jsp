<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/14/2022
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="calculate" >
    <h3>Nhập USD</h3>
    <input type="number" name="usd" value="${usd}">
    <h3>Tỷ giá</h3>
    <input type="number" name="rate" value="${rate}">

    <button type="submit">Quy đổi</button>
</form>
<h1>Kết quả: ${result} VNĐ</h1>
</body>
</html>
