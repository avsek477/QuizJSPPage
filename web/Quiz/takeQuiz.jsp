<%--
  Created by IntelliJ IDEA.
  User: Avsek
  Date: 4/11/2017
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>Take Quiz</title>
</head>
<body>
<%@include file="../includes/menu.jsp"%>
<div class="container" style="background-color: #ffffff">
    <c:choose>
    <c:when test="${newQuestion != null}">
    <form method="post" action="nextQuestion">
        <input type="hidden" name="id" value="${newQuestion.id}">
        <input type="hidden" name="page" value="nextQuestion">
        <input type="hidden" name="correctAns" value="${newQuestion.correctAns}">
        <p>${newQuestion.question}</p>
        <div class="radio">
            <label>
                <input type="radio" name ="choice" value="${newQuestion.option1}">
                    ${newQuestion.option1}
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name ="choice" value="${newQuestion.option2}">
                    ${newQuestion.option2}
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name ="choice" value="${newQuestion.option3}">
                    ${newQuestion.option3}
            </label>
        </div>
        <div class="radio">
            <label>
                <input type="radio" name ="choice" value="${newQuestion.option4}">
                    ${newQuestion.option4}
            </label>
        </div>
        <button type="submit" value="Next Question">Next Question</button>
        </c:when>
        <c:otherwise>
        <h2 class="text-center">Thank you for taking the test.</h2>
        <div class="text-center"><a class="btn btn-primary" href="showResults?page=showResults"> Show Results</a></div>
        </c:otherwise>
        </c:choose>
</div>
</body>
</html>
