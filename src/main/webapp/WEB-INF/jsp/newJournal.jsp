<%--
  Created by IntelliJ IDEA.
  User: saiva
  Date: 07-11-2024
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Journal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }

        form {
            display: inline-block;
            text-align: left;
            padding: 20px;
            border:
                    1px solid #ccc;
            border-radius: 5px;
            background-color: #f2f2f2;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"],

        input[type="email"] {
            width: 200px;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius:
                    3px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius:
                    4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #3e8e41;
        }
    </style>
</head>
<body>
<form action="journals/postJournal" method="post">
    <h2>User Registration</h2>
    <label for="id">Username:</label>
    <input type="text" id="id" name="id" required><br><br>

    <label for="author">Password:</label>
    <input type="text" id="author" name="author" required><br><br>

    <label for="year">Email:</label>
    <input type="number" id="year" name="year" required><br><br>

    <input type="submit" value="Register">
</form>
</body>
</html>