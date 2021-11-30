<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body{
            background-color: antiquewhite;
            margin: 0 10%;
        }
    </style>
</head>
<body>
<div style="text-align: center;">
    <img src="bankingPic.jpeg" height="200" width="400" alt="Banking Network">
    <h1>Banking Network</h1>
</div>



<form action="hello-servlet" method="post">
    <p>
        Enter your name:
        <label>
            <input type="text" name="name">
        </label>
    </p>
    <p>
        Enter your password:
        <label>
            <input type="text" name="password">
        </label>
    </p>
    <input type="submit">
</form>
<p>
     Create a new account if you are not a user<br>
    <a href="newAccount.jsp">New Account</a>
</p>
<br/>
</body>
</html>