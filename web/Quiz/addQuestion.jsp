<%--
  Created by IntelliJ IDEA.
  User: Avsek
  Date: 4/9/2017
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>Add Questions</title>
</head>
<body>
<%@include file="../includes/menu.jsp"%>
<form class="form-horizontal" method="post" action="question2add">
    <input type="hidden" name="page" value="addTheseQuestions">
    <div class="form-group">
        <label class="col-sm-2 control-label">Question</label>
        <div class="col-sm-6"><textarea class="form-control" rows="3" name="question"></textarea></div>
        <%--<div class="col-sm-6">
            <input type="text" class="form-control" id="question" placeholder="Question" name="question">
        </div>--%>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Option1</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" name="option1"></textarea>
            <%--<input type="text" class="form-control" id="option1" placeholder="option1" name="option1">--%>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Option2</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" name="option2"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Option3</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" name="option3"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Option4</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" name="option4"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Correct Answer</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" name="correctAns"></textarea>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">Category</label>
        <div class="col-sm-6">
            <textarea class="form-control" rows="3" name="category"></textarea>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Add Question</button>
        </div>
    </div>
</form>
</body>
</html>