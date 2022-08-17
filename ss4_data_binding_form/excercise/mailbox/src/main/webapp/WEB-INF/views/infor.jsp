<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/17/2022
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Languages</td>
        <td>Page Size</td>
        <td>Spams filter</td>
        <td>Signature</td>
    </tr>
    <c:forEach items="${mailBox}" var="mailBox">
        <tr>
            <td>${mailBox.languages}</td>
            <td>${mailBox.pageSize}</td>
            <td>${mailBox.spamFillter}</td>
            <td>${mailBox.signature}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
