<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25-11-2021
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer Money</title>
    <style>
        body{
            background-color: antiquewhite;
            margin: 0 10%;
        }
    </style>
</head>
<body>
    <h1>Transfer Money Window</h1>
    <br>
    <form action="transactionServlet" method="post">
        <p>
            Receiver:
            <label>
                <input type="text" name="receiver">
            </label>
        </p>
        <p>
            Amount
            <label>
                <input type="text" name="amount">
            </label>
        </p>
        <input type="submit" name="transfer">
    </form>
</body>
</html>
