<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 18/09/2023
  Time: 11:22 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
</head>
<body>
<h3>Settings</h3>
<form:form action="/edit" method="post" modelAttribute="mail">
    <table>
        <tr>
            <td><form:label path="languages"/>Languages: </td>
            <td>
                <form:select path="languages">
                    <form:options items="${languagesList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page size: </form:label></td>
            <td>
                <form:select path="pageSize">
                    <form:options items="${pageSizeList}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="spams">Spams filter: </form:label></td>
            <td>
                <form:checkbox path="spams"/>
                <label> Enable spams filter</label>
            </td>
        </tr>
        <tr>
            <td><form:label path="Signature">Signature: </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button class="btn btn-primary" type="submit">Save</button>
                <a class="btn btn-light" href="/showForm" role="button">Cancel</a>
            </td>

        </tr>
    </table>
</form:form>







<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
</body>
</html>
