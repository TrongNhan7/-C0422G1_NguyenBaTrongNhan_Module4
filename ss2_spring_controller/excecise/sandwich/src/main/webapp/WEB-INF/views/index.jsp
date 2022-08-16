<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/16/2022
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich">
    <c:forEach var="listCondiment" items="${listCondiment}">
        <input type="checkbox" name="condiments" value="${listCondiment}">${listCondiment}
    </c:forEach>
    <br><br>
    <button>Choose</button>
</form>

</body>
</html>
