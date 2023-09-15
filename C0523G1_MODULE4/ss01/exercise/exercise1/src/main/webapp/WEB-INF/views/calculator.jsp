<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/09/2023
  Time: 5:20 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/exchange/calculator" method="post">
  <fieldSet>
    <legend>Exchange Money</legend>
    <table>
      <tr>
        <td>Enter money </td>
        <td><input type="text" name="money">USD</td>
      </tr>
      <tr>
        <td><input type="submit" value="Exchange"></td>
      </tr>
    </table>
  </fieldSet>
</form>
<div>Result = <fmt:formatNumber value="${result}"/> VND</div>
</body>
</html>
