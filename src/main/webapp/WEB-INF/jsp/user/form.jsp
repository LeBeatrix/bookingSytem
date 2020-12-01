<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>Create User</title>
</head>
<body>


    <form:form method="post" action="${path}/user/add" modelAttribute ="userForm">
        <form:hidden path="id"/>
        <p>User Id : <form:input path="userId" placeholder="Enter User Id"/></p>
        <p>User Name : <form:input path="username" placeholder="Enter User Name"/></p>
        <p>First Name  : <form:input  path="name" placeholder="Enter First Name"/></p>
        <p>Last Name : <form:input path="surname" placeholder="Enter Last Name"/></p>
        <p>Cellphone Number :<form:input path="cellNo" placeholder="Enter Cellphone Number"/></p>
        <p>Email Address : <form:input path="emailAddress" placeholder="Enter Email Address"/></p>
        <p>Password : <form:input path="password" placeholder="Enter Password"/></p>
        <p>Role:
            <form:select path="role.id">
                <c:forEach items="${roles}" var="role">
                    <form:option value="${role.id}">${role.name}</form:option>
                </c:forEach>
            </form:select>
        </p>
        <p>
            <form:button value="Save">Save</form:button>
            <a href="${path}/user/list">List Of Users</a>
        </p>
    </form:form>
</body>
</html>
