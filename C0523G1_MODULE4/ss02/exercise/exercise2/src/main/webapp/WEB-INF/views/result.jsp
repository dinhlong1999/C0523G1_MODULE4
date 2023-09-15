<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/09/2023
  Time: 7:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<hr>
<form action="/calculator" method="post">
    <label>First number:</label>
    <input type="text" name="firstNumber" placeholder="Enter first number">
    <label>Second number:</label>
    <input type="text" name="secondNumber" placeholder="Enter second number"><br>
    <input type="submit" name="calculation" value="+">
    <input type="submit" name="calculation" value="-">
    <input type="submit" name="calculation" value="*">
    <input type="submit" name="calculation" value="/"><br>
    <br>
    <input type="submit"value="calculator">
</form>
<div>Result : ${result}</div>

</body>
</html>
