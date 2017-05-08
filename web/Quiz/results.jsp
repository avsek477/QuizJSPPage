<%--
  Created by IntelliJ IDEA.
  User: Avsek
  Date: 4/16/2017
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>Results</title>
</head>
<body>
<%@include file="../includes/menu.jsp"%>
    <div class="container" style="background-color: #ffffff">
        <table class="table table-bordered table-hover">
            <tr>
                <th class="text-center">User Id</th>
                <th class="text-center">Question Number</th>
                <th class="text-center">Marks</th>
            </tr>
            <c:forEach items="${resultList}" var="result">
            <tr>
                <td class="text-center">${result.user_id}</td>
                <td class="text-center">${result.q_id}</td>
                <td class="text-center">${result.marks}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
