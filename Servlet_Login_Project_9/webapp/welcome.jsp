<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>

<style>
    body {
        font-family: Arial;
        background: linear-gradient(to right, #74ebd5, #ACB6E5);
        text-align: center;
        padding-top: 50px;
    }
    .card {
        background: white;
        width: 350px;
        margin: auto;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px gray;
    }
</style>

</head>
<body>

<div class="card">
<h1>Welcome To Profile Page</h1>

<%
    String myname = (String) session.getAttribute("name");
    String myemail = (String) session.getAttribute("email");
    Integer mynumber = (Integer) session.getAttribute("mob");

    // 🔐 Session validation
    if(myname == null || myemail == null){
        response.sendRedirect("index.html");
        return;
    }
%>

<h3>
    Welcome: <%= myname %> <br><br>
    Email: <%= myemail %> <br><br>
    Mobile: <%= mynumber %>
</h3>

<br>

<form action="Logout" method="post">
    <input type="submit" value="Logout">
</form>

</div>

</body>
</html>
