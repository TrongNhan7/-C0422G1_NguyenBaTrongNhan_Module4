<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/showList">SHOW LIST</a>

<form:form method="post" action="/editMedical" modelAttribute="medical">
    <div>
        <form:label path="name">Họ tên (ghi chữ IN HOA)</form:label>
        <br>
        <form:input path="name" value="${medicalEdit.name}"/>
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
        <form:select path="nation" items="${listNation}" value="${medicalEdit.nation}"/>
    </div

    <div>
        <form:label path="idCard">Sô hộ chiếu hoặc CMND</form:label>
        <br>
        <form:input path="idCard" value="${medicalEdit.idCard}"/>
    </div>

    <div>
        <form:label path="travelInformation">Thông tin đi lại</form:label>
        <br>
        <form:checkboxes path="travelInformation" items="${listTravelInformation}"/>
    </div>

    <div>
        <form:label path="vehicleId">Số hiệu phương tiện</form:label>
        <br>
        <form:input path="vehicleId" value="${medicalEdit.vehicleId}"/>
    </div>

    <div>
        <form:label path="seats">Số ghế</form:label>
        <br>
        <form:input path="seats" value="${medicalEdit.seats}"/>
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
