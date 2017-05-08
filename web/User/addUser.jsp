<!--
  Created by IntelliJ IDEA.
  User: Avsek
  Date: 3/23/2017
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>Add User</title>
</head>
<body>
<%@include file="../includes/menu.jsp"%>
<div class="row" style="margin: 50px">
    <div class="col-md-offset-4 col-md-4 form-group" style="background-color: lightgray;">
        <h1>Add User</h1>
        <hr>
        <form method="post" action="employee">
            <input type="hidden" name="page" value="userByAdmin">
            <div class="form-group">
                <label for="exampleInputUsername1">Username</label>
                <input type="text" class="form-control" id="exampleInputUsername1" placeholder="Username" name="username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Role</label>
                <input type="text" class="form-control" id="exampleInputRole1" placeholder="Role" name="role">
            </div>
            <button type="Submit" class="btn btn-primary btn-lg btn-block" >Add User</button>
        </form>
    </div>
</div>

</body>
</html>
