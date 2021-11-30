<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25-11-2021
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deposit</title>
    <style>
        body{
            background-color: antiquewhite;
            margin: 0 10%;
        }
    </style>
</head>
<body>
<div style="text-align: center;">
    <h1>Deposit Window</h1>
</div>
<form action="depositServlet" method="post">
    <p>
        Enter deposit amount:
        <label>
            <input type="text" name="dAmount">
        </label>
    </p>
    <input type="submit" name="Deposit">
</form>

</body>
</html>
