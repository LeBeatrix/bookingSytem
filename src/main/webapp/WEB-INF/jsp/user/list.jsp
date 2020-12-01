<%--
  Created by IntelliJ IDEA.
  User: Bezui
  Date: 2020/12/01
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
             </tr>
         </c:forEach>

        </tbody>
    </table>
</body>
</html>
