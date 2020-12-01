<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>Create User</title>
</head>
<body>


<form method="post" action="${path}" commandName="billForm">
    <p>User Name : <input type="text" id="username" name="username" path="" placeholder="Enter User Name"></p>
    <p>First Name  : <input type="text" id="name" name="name" path="" placeholder="Enter First Name"></p>
    <p>Last Name : <input type="text" id="surname" name="surname" path="" placeholder="Enter Last Name"></p>
    <p>Cellphone Number :<input type="text" id="cellNo" name="cellNo" path="" placeholder="Enter Cellphone Number"></p>
    <p>Email Address : <input type="text" id="emailAddress" name="emailAddress" path="" placeholder="Enter Email Address"></p>
    <p>
        <input type="submit" value="Save">
        <a href="${path}/bill/list">List Of Bills</a>
    </p>
</form>
</body>
</html>
