<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: linear-gradient(to right, #74ebd5, #ACB6E5);
    text-align: center;
    margin-top: 100px;
}

.container {
    background-color: white;
    padding: 30px;
    display: inline-block;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
}

h2 {
    color: #333;
}

p {
    font-size: 16px;
    color: #555;
}

a {
    display: inline-block;
    margin-top: 15px;
    text-decoration: none;
    background-color: #f44336;
    color: white;
    padding: 10px 20px;
    border-radius: 5px;
}

a:hover {
    background-color: #d32f2f;
}
</style>

</head>
<body>

<div class="container">

<%
String user = (String) session.getAttribute("username");

if(user != null) {
%>

    <h2>Welcome: <%= user %></h2>
    <p>Email: <%= session.getAttribute("email") %></p>

    <a href="logout.jsp">Logout</a>

<%
} else {
    response.sendRedirect("index.html"); // if no session
}
%>

</div>

</body>
</html>
