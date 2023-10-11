<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 14/09/2023
  Time: 5:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/customer/list"></a>
<form action="/customer/create" method="post">
  <fieldSet>
    <legend>Add customer</legend>
    <table>
      <tr>
        <td><label>ID: </label></td>
        <td><input type="text" name="id" placeholder="Enter id"></td>
      </tr>
      <tr>
        <td><label>Name: </label></td>
        <td><input type="text" name="name" placeholder="Enter Name"></td>
      </tr>
      <tr>
        <td><label>Email: </label></td>
        <td><input type="text" name="email" placeholder="Enter Email"></td>
      </tr>
      <tr>
        <td><label>Address: </label></td>
        <td><input type="text" name="address" placeholder="Enter Address"></td>
      </tr>
      <tr>
        <td><input type="submit" value="Add"></td>
      </tr>
    </table>
  </fieldSet>
</form>
</body>
</html>
