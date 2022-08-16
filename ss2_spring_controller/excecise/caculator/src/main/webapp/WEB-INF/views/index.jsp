<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/16/2022
  Time: 1:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/caculator" method="post">
  <h1>Caculator</h1>
    <input type="text" name="number1" value="${number1}" placeholder="Nhập number 1">

    <input type="text" name="number2" value="${number2}" placeholder="Nhập number 2">
    <br>
    <br>
    <button name="operator" value="+">Addition(+)</button>
    <button name="operator" value="-">Subtraction(-)</button>
    <button name="operator" value="*">Multiplication(X)</button>
    <button name="operator" value="/">Division(/)</button>
  </form>
  <p>Result: ${result} </p>
  </body>
</html>
