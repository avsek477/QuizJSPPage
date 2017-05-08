<%--
  Created by IntelliJ IDEA.
  User: Avsek
  Date: 4/9/2017
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>Edit Question</title>
</head>
<body>
<%@include file="../includes/menu.jsp"%>
<form class="form-horizontal" method="post" action="question2update">
    <input type="hidden" name="page" value="updateTheseQuestions">
    <input type="hidden" name="id" value="${newQuestion.id}">
    <div class="form-group">
        <label for="question" class="col-sm-2 control-label">Question</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="question" value="${newQuestion.question}" name="question">
        </div>
    </div>
    <div class="form-group">
        <label for="option1" class="col-sm-2 control-label">Option1</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="option1" value="${newQuestion.option1}" name="option1">
        </div>
    </div>
    <div class="form-group">
        <label for="option2" class="col-sm-2 control-label">Option2</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="option2" value="${newQuestion.option2}" name="option2">
        </div>
    </div>
    <div class="form-group">
        <label for="option3" class="col-sm-2 control-label">Option3</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="option3" value="${newQuestion.option3}" name="option3">
        </div>
    </div>
    <div class="form-group">
        <label for="option4" class="col-sm-2 control-label">Option4</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="option4" value="${newQuestion.option4}" name="option4">
        </div>
    </div>
    <div class="form-group">
        <label for="correctAns" class="col-sm-2 control-label">Correct Answer</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="correctAns" value="${newQuestion.correctAns}" name="correctAns">
        </div>
    </div>
    <div class="form-group">
        <label for="category" class="col-sm-2 control-label">Category</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="category" value="${newQuestion.category}" name="category">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Update Question</button>
        </div>
    </div>
</form>
</body>
</html>
