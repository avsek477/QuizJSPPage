<%--
  Created by IntelliJ IDEA.
  User: Avsek
  Date: 3/22/2017
  Time: 7:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Login Page</title>
</head>
<body style="background-color: cadetblue">

<div class="row" style="margin: 50px">
    <div class="col-md-offset-4 col-md-4 form-group" style="background-color: lightgray;">
        <h1>Login Page</h1>
        ${msg}
        <hr>
        <form method="post" action="login">
            <input type="hidden" name="page" value="log">
            <div class="form-group">
                <label for="exampleInputUsername1">Username</label>
                <input type="text" class="form-control" id="exampleInputUsername1" placeholder="Email" name="username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
            </div>
            <button type="Submit" class="btn btn-primary btn-lg btn-block" onclick="getAlert()">Log in</button>
            <p style="margin: 10px 0 10px 70px">Not registered?<a href="register?page=signup"> Create an account</a></p>
        </form>
    </div>
</div>
</body>
</html>
<script>
    function getAlert(){

        var un = document.getElementById("exampleInputUsername1").value;
        var pw = document.getElementById("exampleInputPassword1").value;
        if (un == "")
            alert("Please enter the username");
        if(pw=="")
            alert("Please enter the password");
    }
</script>