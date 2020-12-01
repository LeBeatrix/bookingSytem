<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Appointments</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>Id</td>
        <td>Appointment Id</td>
        <td>Patient No</td>
        <td>Doctor Id</td>
        <td>Date</td>
        <td>Time</td>
        <td></td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="appointment" items="${appointments}">
        <tr>
            <td>${appointment.id}</td>
            <td>${appointment.appointID}</td>
            <td>${appointment.patientNo}</td>
            <td>${appointment.docID}</td>
            <td>${appointment.localDate}</td>
            <td>${appointment.localTime}</td>
            <td><a href="${path}/appointment/edit/${appointment.id}">Edit</a></td>
            <td><a href="${path}/appointment/delete/${appointment.id}">Delete</a></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
