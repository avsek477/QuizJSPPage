<%--
  Created by IntelliJ IDEA.
  User: Avsek
  Date: 4/9/2017
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>Quiz List</title>
</head>
<body>
<%@include file="../includes/menu.jsp"%>
<a class="btn btn-default" href="addQuestion?page=addQuestion"> <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Questions</a>
<div class="container">
    <table class="table table-bordered table-hover">
        <tr>
            <th class = "text-center">S.no.</th>
            <th class = "text-center">Questions</th>
            <th class = "text-center">Option1</th>
            <th class = "text-center">Option2</th>
            <th class = "text-center">Option3</th>
            <th class = "text-center">Option4</th>
            <th class = "text-center">Correct Answer</th>
            <th class = "text-center">Category</th>
            <th class = "text-center">Action</th>
        </tr>
        <c:forEach items="${questionList}" var="question">
            <tr>
                <td class = "text-center">${question.id}</td>
                <td class = "text-center">${question.question}</td>
                <td class = "text-center">${question.option1}</td>
                <td class = "text-center">${question.option2}</td>
                <td class = "text-center">${question.option3}</td>
                <td class = "text-center">${question.option4}</td>
                <td class = "text-center">${question.correctAns}</td>
                <td class = "text-center">${question.category}</td>
                <td class = "text-center"><a class="btn btn-success" href="editQuestion?page=editTheseQuestion&id=${question.id}"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Edit</a>
                    <a class="btn btn-danger" href="deleteQuestion?page=deleteTheseQuestions&id=${question.id}"> <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
