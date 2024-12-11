<%--
  Created by IntelliJ IDEA.
  User: saiva
  Date: 07-11-2024
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>
  <style>
    /* Body Styling */
    body {
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
      margin: 0;
      font-family: Arial, sans-serif;
      background: linear-gradient(to right, #4e54c8, #8f94fb);
    }

    /* Login Form Container */
    .login-container {
      width: 360px;
      padding: 40px;
      border-radius: 8px;
      box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
      background-color: #ffffff;
    }

    /* Header Styling */
    .login-container h2 {
      margin: 0;
      margin-bottom: 20px;
      color: #4e54c8;
      text-align: center;
    }

    /* Input Fields Styling */
    .login-container input[type="text"],
    .login-container input[type="password"] {
      width: 100%;
      padding: 12px;
      margin: 8px 0 16px;
      border: 1px solid #ccc;
      border-radius: 4px;
      font-size: 16px;
    }

    /* Submit Button Styling */
    .login-container button {
      width: 100%;
      padding: 12px;
      background-color: #4e54c8;
      color: white;
      border: none;
      border-radius: 4px;
      font-size: 16px;
      cursor: pointer;
      transition: background-color 0.3s;
    }

    /* Hover Effect */
    .login-container button:hover {
      background-color: #3b43a2;
    }

    /* Additional Links Styling */
    .login-container .forgot-password {
      text-align: center;
      display: block;
      margin-top: 16px;
      color: #4e54c8;
      text-decoration: none;
      font-size: 14px;
    }

    .login-container .forgot-password:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

<div class="login-container">
  <h2>Login</h2>
  <form >
    <label>
      <input type="text" id="username" name="username" required>
    </label>
    <label>
      <input type="password" id="password" name="password" required>
    </label>
    <button type="submit">Login</button>
    <a href="#" class="forgot-password">Forgot Password?</a>
  </form>
</div>
</body>
</html>


