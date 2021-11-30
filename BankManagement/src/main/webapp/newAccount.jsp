<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23-11-2021
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create Account</title>
  <style>
    body{
      background-color: antiquewhite;
      margin: 0 10%;
    }
  </style>
</head>
<body>
  Your networking bank account provides many facilities like:
  <ul>
    <li>Transfer money to another person in our secured network.</li>
    <li>Deposit money without delay</li>
    <li>View your balance and all transaction details within seconds</li>
  </ul>
<form action="create_AccountServlet" method="post">
  <p>
    Enter your Name:
    <label>
      <input type="text" name="Name">
    </label>
  </p>
  <p>
    Enter your Password:
    <label>
      <input type="text" name="Password">
    </label>
  </p>

  Account id will be provided by the bank<br>
  <input type="submit" name="Create my account">
</form>
</body>
</html>

