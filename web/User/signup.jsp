<!--
Created by IntelliJ IDEA.
User: Avsek
Date: 3/23/2017
Time: 6:47 PM
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>-->
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">

    <title>Register</title>
</head>
<body>
<div class="row" style="background-color: #7F8C8D">
    <div class="col-md-offset-3 col-md-6" style="background-color: #B3B6B7">
        <h1 class="text-center">Registration Form </h1>

        <form method="post" action="signup">
            <input type="hidden" name="page" value="logout">
            <div class="form-group">
                <label for="exampleInputName">Name</label>
                <input type="text" class="form-control" id="exampleInputName" placeholder="First and Last Name">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
            </div>
            <div class="form-group">
                <label for="exampleInputUsername1">Create a Username</label>
                <input type="text" class="form-control" id="exampleInputUsername1" placeholder="Username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Create a Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword2">Confirm Your Password</label>
                <input type="email" class="form-control" id="exampleInputPassword2">
            </div>
            <hr>
            <h3 class="text-center" style="margin-bottom: 20px">Personal Details</h3>

            <div class="form-group form-inline">
                <label for="birthday">Birthday</label>
                <select style="margin-left: 10px">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                    <option>7</option>
                    <option>8</option>
                    <option>9</option>
                    <option>10</option>
                    <option>11</option>
                    <option>12</option>
                </select>
                <label  style="margin-left: 20px">Day </label>
                <input type="text" class="form-control" placeholder="Day" style="margin-left: 15px">
                <label style="margin-left: 20px">Year</label>
                <input type="number" class="form-control" placeholder="Year" style="margin-left: 15px">
            </div>
            <div class="form-inline form-group">
                <label for="gender">Gender</label>
                <input type="text" class="form-control" placeholder="i am.." style="margin-left: 44px">
            </div>
            <div class="form-inline form-group">
                <label for="country">Country</label>
                <input type="text" class="form-control" placeholder="Country" style="margin-left: 39px">
            </div>

            <div class="form-group form-inline">
                <label for="exampleInputNumber2">Mobile Phone</label>
                <input type="email" class="form-control" id="exampleInputNumber2" placeholder="Phone number">
            </div>
            <button type="submit" class="btn btn-primary" style="margin-top: 15px" onclick="getAlert()">Sign me up</button>
        </form>
    </div>

</div>

</body>
</html>
<script>
    function getAlert(){
        alert("Congratulations!! You are registered as a user.")
    }
</script>