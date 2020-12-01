<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Bills</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>Bill Number</td>
        <td>Appointment Id</td>
        <td>Patient Id</td>
        <td>Amount Due</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="bill" items="${bills}">
        <tr>
            <td>${bill.billNo}</td>
            <td>${bill.appointId}</td>
            <td>${bill.patientId}</td>
            <td>R ${bill.amount}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
