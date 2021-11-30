<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24-11-2021
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Successful Login</title>
    <style>
        body{
            background-color: antiquewhite;
            margin: 0 10%;
        }
    </style>
</head>
<body>
    <form action="functionServlet" method="post">
        <br><br>Your Account Provides the following functionalities:
        <ul>
            <li><label>
                <input type="radio" name="choice" value="checkBalance">
            </label>Check current balance</li>
            <li><label>
                <input type="radio" name="choice" value="viewTransactions">
            </label>View all transactions</li>
            <li><label>
                <input type="radio" name="choice" value="transferMoney">
            </label>Transfer money</li>
            <li><label>
                <input type="radio" name="choice" value="depositMoney">
            </label>Deposit money</li>
        </ul>
        <input type="submit" name="Proceed" value="Proceed">
    </form>
</body>
</html>
