<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>Messages</title>
</head>
<body>
    <p>${messages}</p>
    <p><a href="${path}/user/list"/>User List</p>
    <p><a href="${path}/user/form"/>Uer Form</p>
    <p><a href="${path}/appointment/list"/>Appointment List</p>
    <p><a href="${path}/appointment/form"/>Appointment From</p>
</body>
</html>
