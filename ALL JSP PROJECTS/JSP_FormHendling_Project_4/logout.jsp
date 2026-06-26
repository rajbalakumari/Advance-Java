<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: linear-gradient(to right, #74ebd5, #ACB6E5);
    text-align: center;
    margin-top: 120px;
}

.box {
    background-color: white;
    padding: 30px;
    display: inline-block;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
}

h2 {
    color: green;
}

a {
    display: inline-block;
    margin-top: 15px;
    text-decoration: none;
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border-radius: 5px;
}

a:hover {
    background-color: #45a049;
}
</style>

</head>
<body>

<div class="box">

<%
    // ✅ Destroy session
    session.invalidate();
%>

<h2>You have been logged out successfully...</h2>

<a href="index.html">Go to Login Page</a>

</div>

</body>
</html>
