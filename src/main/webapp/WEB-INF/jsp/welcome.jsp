<%--
  Created by IntelliJ IDEA.
  User: Bezui
  Date: 2020/12/01
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
    <div class="">
        <div class="">
            <h1>${message}</h1>
        </div>


        <c:set var="path" value="${pageContext.request.contextPath}"></c:set>

        <div class="">
            <a href="${path}/user/list">User list</a>
        </div>
        <div class="">
            <a href="${path}/user/form">Create User</a>
        </div>

        <div class="">
            <a href="${path}/appointment/list">Appointment List</a>
        </div>
        <div class="">
            <a href="${path}/appointment/form">Create Appointment</a>
        </div>

        <div class="">
            <a href="${path}/bill/list">Bill List</a>
        </div>
    </div>


</body>
</html>
