<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15/09/2023
  Time: 4:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="/">Go back</a></h3>
<div style="color: red">Spice you choose: </div>
<c:forEach var="list" items="${list1}">
  <div>-<c:out value="${list}"/></div>
</c:forEach>
</body>
</html>
