<%@ page import="Domain.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Avsek
  Date: 4/11/2017
  Time: 8:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Domain.User"%>
<%
    User user =(User)session.getAttribute("user");
    if(user==null){
        response.sendRedirect("index.jsp");
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title></title>
</head>
<body>
<%--<%@ page import="Domain.User"%>                 getting User form Domain--%>

<div class="header">
    ${msg}
    ${sessionScope.user.username}
    <h1> WELCOME!! </h1>
</div>
<ul id="nav">
    <li><a class="active" href="home?page=home">${sessionScope.user.username}</a></li>
    <c:if test="${sessionScope.user.role=='administrator'}">
        <li><a href="employee?page=employeeList">Employee</a></li>
        <li><a href="quiz?page=quizList">Quiz</a></li>
    </c:if>
    <li><a href="takeQuiz?page=takeQuiz">Take Quiz</a></li>
    <li><a href="logout?page=logout">Log out</a></li>
</ul>
</body>
</html>
