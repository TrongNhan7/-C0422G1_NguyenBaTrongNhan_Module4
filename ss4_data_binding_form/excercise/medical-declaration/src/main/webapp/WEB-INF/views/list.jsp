<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/17/2022
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <p style="color: red">${mess}</p>
</div>
<table border="1">
    <tr>
        <td>Họ tên</td>
        <td>Năm sinh</td>
        <td>Giới tính</td>
        <td>Quốc tịch</td>
        <td>Số hộ chiếu</td>
        <td>Thông tin đi lại</td>
        <td>Số hiệu phương tiện</td>
        <td>Số ghế</td>
        <td colspan="3">Ngày khởi hành</td>
        <td colspan="3">Ngày kết thúc</td>
        <td>Thông tin trong 14 ngày</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${medicalList}" var="medical">
        <tr>
            <td>${medical.name}</td>
            <td>${medical.birthday}</td>
            <td>${medical.gender}</td>
            <td>${medical.nation}</td>
            <td>${medical.idCard}</td>
            <td>${medical.travelInformation}</td>
            <td>${medical.vehicleId}</td>
            <td>${medical.seats}</td>
            <td>${medical.startDay}</td>
            <td>${medical.startMonth}</td>
            <td>${medical.startYear}</td>
            <td>${medical.endDay}</td>
            <td>${medical.endMonth}</td>
            <td>${medical.endYear}</td>
            <td>${medical.goArea}</td>
            <td>
                <a href="/showEditMedical/${medical.idCard}">Edit</a>
            </td>
            <td>
                <a href="/deleteMedical/${medical.idCard}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
