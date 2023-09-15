<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>

<hr>
<form action="/showList" method="post">
  <input type="checkbox" id="lettuce" name="spice" value="lettuce">
  <label for="lettuce"> lettuce</label>
  <input type="checkbox" id="Tomato" name="spice" value="Tomato">
  <label for="Tomato"> Tomato</label>
  <input type="checkbox" id="Mustard" name="spice" value="Mustard">
  <label for="Mustard"> Mustard</label>
  <input type="checkbox" id="Sprouts" name="spice" value="Sprouts">
  <label for="Sprouts">Sprouts</label><br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>