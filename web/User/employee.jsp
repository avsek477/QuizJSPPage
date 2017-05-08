<%--
  Created by IntelliJ IDEA.
  User: Avsek
  Date: 3/23/2017
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Employee Table</title>
</head>
<body>
<%@include file="../includes/menu.jsp"%>
<%--<h2 class="text-center"><button type="button" class="btn btn-default" aria-label="Left Align">
    <span class="glyphicon glyphicon-plus" aria-hidden="true"><a href="addUser?page=addUser"> Add New User</a></span>
</button> </h2>--%>
<h2 class="text-center"><a class="btn btn-default" href="addUser?page=addUser"> <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add User</a></h2>

<div class="container">
    <table class="table table-bordered table-hover">
        <tr>
            <th class = "text-center">Username</th>
            <th class = "text-center">Password</th>
            <th class = "text-center">Role</th>
            <th class = "text-center">Action</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td class = "text-center">${user.username}</td>
                <td class = "text-center">${user.password}</td>
                <td class = "text-center">${user.role}</td>
                <td class = "text-center"><a class="btn btn-success" href="edit?page=edit&id=${user.id}"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Edit</a>
                    <a class="btn btn-danger" href="delete?page=delete&id=${user.id}"> <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
