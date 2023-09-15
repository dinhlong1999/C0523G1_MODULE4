<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/09/2023
  Time: 8:40 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="dictionary" method="post">
    <fieldSet>
        <legend>Dictionary</legend>
        <table>
            <tr>
                <td>Enter word</td>
                <td><input type="text" name="text" placeholder="Enter word"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Send"></td>
            </tr>
        </table>
    </fieldSet>
</form>
${result}
${message}
</body>
</html>
