<%--
  Created by IntelliJ IDEA.
  User: Avsek
  Date: 4/6/2017
  Time: 8:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>Edit User</title>
</head>
<body>
<%@include file="../includes/menu.jsp"%>
<div class="row" style="margin: 50px">
    <div class="col-md-offset-4 col-md-4 form-group" style="background-color: lightgray;">
        <h1>Update User</h1>
        <hr>
        <form method="post" action="update">
            <input type="hidden" name="page" value="editByAdmin">
            <input type="hidden" name="userId" value="${user.id}">
            <div class="form-group">
                <label for="exampleInputUsername1">Username</label>
                <input type="text" class="form-control" id="exampleInputUsername1" value="${user.username}" name="username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" value="${user.password}" name="password">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Role</label>
                <input type="text" class="form-control" id="exampleInputRole1" value="${user.role}" name="role">
            </div>
            <button type="Submit" class="btn btn-primary btn-lg btn-block" >Update User</button>
        </form>
    </div>
</div>

</body>
</html>
