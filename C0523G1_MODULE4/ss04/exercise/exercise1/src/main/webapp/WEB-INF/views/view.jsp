<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 18/09/2023
  Time: 11:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h3>Information config mail</h3>
<table border="1px">
    <tr>
        <th>STT</th>
        <th>Languages</th>
        <th>Page size</th>
        <th>Spams Filter</th>
        <th>Signature</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${mailList}" var="mail" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${mail.languages}</td>
            <td>${mail.pageSize}</td>
            <c:if test="${mail.spams == true}">
                <td><c:out value="Enable spams filter"/></td>
            </c:if>
            <c:if test="${mail.spams == false}">
                <td><c:out value=" No Enable spams filter"/></td>
            </c:if>
            <td>${mail.signature}</td>
            <td><a href="/edit/${mail.id}">Edit config</a></td>
        </tr>
    </c:forEach>
</table>
${message}
</body>
</html>
