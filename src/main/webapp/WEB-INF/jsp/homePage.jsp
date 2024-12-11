<%--
  Created by IntelliJ IDEA.
  User: saiva
  Date: 07-11-2024
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Journal Actions</title>
    <style>
        /* Body Styling */
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #76b852, #8DC26F);
        }

        /* Container for the Buttons */
        .button-container {
            text-align: center;
            background: white;
            padding: 40px 20px;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
            width: 320px;
        }

        /* Header Styling */
        .button-container h2 {
            color: #76b852;
            margin-bottom: 20px;
            font-size: 24px;
        }

        /* Button Styling */
        .button-container button {
            width: 100%;
            padding: 15px;
            margin: 10px 0;
            border: none;
            border-radius: 25px;
            font-size: 16px;
            color: white;
            background-color: #76b852;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.2s;
        }

        /* Hover and Active Effects */
        .button-container button:hover {
            background-color: #5f9f43;
        }

        .button-container button:active {
            transform: scale(0.98);
        }

        /* Button Color Variations */
        .post-journal { background-color: #4e54c8; }
        .view-journals { background-color: #f39c12; }
        .get-journal { background-color: #e74c3c; }

        /* Hover Color Variations */
        .post-journal:hover { background-color: #3b43a2; }
        .view-journals:hover { background-color: #e67e22; }
        .get-journal:hover { background-color: #c0392b; }
    </style>
</head>
<body>

<div class="button-container">
    <h2>Journal Actions</h2>
<form action="newJournal.jsp">
    <button class="post-journal">Post Journal</button>
</form>
    <button class="view-journals">View My Journals</button>
    <button class="get-journal">Get Journal</button>
</div>

</body>
</html>