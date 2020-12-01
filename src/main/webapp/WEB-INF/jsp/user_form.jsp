<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add Student</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>


</head>
<body>
<div class="container">
    <spring:url value="/user/create" var="addURL" />
    <h2>Create User</h2>

<%--    <form:form method="post" modelAttribute="userForm"  action="${addURL}" cssClass="form" >--%>
<%--        <form:hidden path="userId"/>--%>
        <div class="form-group">
            <label>User Name</label>
            <input type="text" id="username" path="username" cssClass="form-control"/>
<%--            <form:input path="username" cssClass="form-control"  />--%>
        </div>
        <div class="form-group">
            <label>first Name</label>
            <input type="text" id="firstname" path="name" cssClass="form-control"/>
<%--            <form:input path="name" cssClass="form-control"  />--%>
        </div>
        <div class="form-group">
            <label>Last Name</label>
            <input type="text" id="surname" path="surname" cssClass="form-control"/>
<%--            <form:input path="surname" cssClass="form-control"  />--%>
        </div>
        <div class="form-group">
            <label>Cell Number</label>
            <input type="text" id="cellNo" path="cellNo" cssClass="form-control"/>
<%--            <form:input path="cellNo" cssClass="form-control"  />--%>
        </div>
        <div class="form-group">
            <label>Email Address</label>
            <input type="text" id="emailAddress" path="emailAddress" cssClass="form-control"/>
<%--            <form:input path="emailAddress" cssClass="form-control"  />--%>
        </div>
        <button id="test"  class="btn btn-success">Create User</button>
<%--    </form:form>--%>

</div>

<script>

    $("#test").on("click", function (){
        var username = $("#username").val();
        var firstname = $("#firstname").val();
        var surname = $("#surname").val();
        var cellNo = $("#cellNo").val();
        var emailAddress = $("#emailAddress").val();

        alert(username + "\n"
            + firstname + "\n"
            + surname + "\n"
            + cellNo + "\n"
            + emailAddress + "\n" );

        // $.ajax({
        //     type: "POST",
        //     url: "someaction.do?action=saveData",
        //     data: {username:username, name:firstname, surname:surname, cellNo:cellNo, emailAddress:emailAddress},
        //     dataType: "text",
        //     success: function(resultData){
        //         alert("Save Complete");
        //     }
        // });
    });


</script>
</body>
</html>