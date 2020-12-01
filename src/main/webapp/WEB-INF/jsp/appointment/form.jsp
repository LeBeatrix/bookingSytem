<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create Appoint</title>
</head>
<body>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<form:form method="post" action="${path}/appointment/create" modelAttribute="appointmentForm">

    <p>Date : <form:input path="localDate" placeholder="Enter Dater"/></p>
    <p>Time : <form:input path="localTime" placeholder="Enter Time"/></p>
    <p>User:
        <form:select path="user.id">
            <c:forEach items="${users}" var="user">
                <form:option value="${user.id}">${user.name}</form:option>
            </c:forEach>
        </form:select>
    </p>
    <p>
        <form:button value="Save">Save</form:button>
        <a href="${path}/appointment/list">List Of Appointments</a>
    </p>
</form:form>
</body>
</html>