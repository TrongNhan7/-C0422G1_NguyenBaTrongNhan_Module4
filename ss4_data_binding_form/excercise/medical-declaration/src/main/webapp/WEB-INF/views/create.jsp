<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: This PC
  Date: 8/17/2022
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/showList">SHOW LIST</a>

<form:form method="post" action="/addMedical" modelAttribute="medical">
    <div>
        <form:label path="name">Họ tên (ghi chữ IN HOA)</form:label>
        <br>
        <form:input path="name"/>
    </div>

    <div>
        <form:label path="birthday">Năm sinh</form:label>
        <br>
        <form:select path="birthday" items="${listBirthYear}"/>
    </div>

    <div>
        <form:label path="gender">Giới tính</form:label>
        <br>
        <form:select path="gender" items="${listGender}"/>
    </div>

    <div>
        <form:label path="nation">Quốc tịch</form:label>
        <br>
        <form:select path="nation" items="${listNation}"/>
    </div

    <div>
        <form:label path="idCard">Sô hộ chiếu hoặc CMND</form:label>
        <br>
        <form:input path="idCard"/>
    </div>

    <div>
        <form:label path="travelInformation">Thông tin đi lại</form:label>
        <br>
        <form:checkboxes path="travelInformation" items="${listTravelInformation}"/>
    </div>

    <div>
        <form:label path="vehicleId">Số hiệu phương tiện</form:label>
        <br>
        <form:input path="vehicleId"/>
    </div>

    <div>
        <form:label path="seats">Số ghế</form:label>
        <br>
        <form:input path="seats"/>
    </div>

    <div>
        <h5>Ngày khởi hành</h5>
        <span>Ngày<form:select path="startDay" items="${listDay}"/></span>
        <span>Tháng<form:select path="startMonth" items="${listMonth}"/></span>
        <span>Năm<form:select path="startYear" items="${listYear}"/></span>
    </div>

    <div>
        <h5>Ngày kết thúc</h5>
        <span>Ngày<form:select path="endDay" items="${listDayEnd}"/></span>
        <span>Tháng<form:select path="endMonth" items="${listMonthEnd}"/></span>
        <span>Năm<form:select path="endYear" items="${listYearEnd}"/></span>
    </div>

    <div>
        <form:label path="goArea">Trong vòng 14 ngày qua, Anh/Chị có đi đâu ?</form:label>
        <br>
        <form:textarea path="goArea"/>
    </div>

    <button type="submit">Save</button>
</form:form>
</body>
</html>
