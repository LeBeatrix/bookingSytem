<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <td>Id</td>
                <td>User Id</td>
                <td>User Name</td>
                <td>First Name</td>
                <td>last Name</td>
                <td>Cellphone Number</td>
                <td>Email Address</td>
                <td></td>
                <td></td>
            </tr>
        </thead>
        <tbody>
         <c:forEach var="user" items="${users}">
             <tr>
                 <td>${user.id}</td>
                 <td>${user.userId}</td>
                 <td>${user.username}</td>
                 <td>${user.name}</td>
                 <td>${user.surname}</td>
                 <td>${user.cellNo}</td>
                 <td>${user.emailAddress}</td>
                 <td><a href="${path}/user/edit/${user.id}">Edit</a></td>
                 <td><a href="${path}/user/delete/${user.id}">Delete</a></td>
             </tr>
         </c:forEach>
            <tr>
                <p>
                    <a href="${path}/">Home</a>
                </p>
            </tr>
        </tbody>
    </table>
</body>
</html>
