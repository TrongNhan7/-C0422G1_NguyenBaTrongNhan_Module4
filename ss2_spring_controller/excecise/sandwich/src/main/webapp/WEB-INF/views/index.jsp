<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/16/2022
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich">
    <input type="checkbox" id="lettuce" name="condiments" value="lettuce">
    <label for="lettuce">Lettuce</label>
    <input type="checkbox" id="tomato" name="condiments" value="tomato">
    <label for="tomato">Tomato</label>
    <input type="checkbox" id="mustard" name="condiments" value="mustard">
    <label for="mustard">Mustard</label>
    <input type="checkbox" id="sprouts" name="condiments" value="sprouts">
    <label for="sprouts">Sprouts</label><br><br>
    <button type="submit">Save</button>
</form>
<h3>${listCondiment}</h3>
</body>
</html>
