<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Result</title>

<style>
body {
    font-family: Arial, sans-serif;
    background: linear-gradient(to right, #74ebd5, #ACB6E5);
    text-align: center;
    margin-top: 100px;
}

.box {
    background-color: white;
    padding: 30px;
    display: inline-block;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
}

h2 {
    color: red;
}

.success {
    color: green;
}

.error {
    color: red;
}

/* 🔥 Button Style */
.btn {
    display: inline-block;
    margin-top: 15px;
    text-decoration: none;
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border-radius: 5px;
}

.btn:hover {
    background-color: #45a049;
}
</style>

</head>
<body>

<div class="box">

<%
String name = request.getParameter("name");
String email = request.getParameter("email");
String password = request.getParameter("password");

if(email != null && password != null) {

    if(email.equals("sb@gmail.com") && password.equals("sb12")) {

        // ✅ Create Session
        session.setAttribute("username", name);
        session.setAttribute("email", email);

        // ✅ Redirect to another page
        response.sendRedirect("home.jsp");

    } else {
%>
        <h2 class="error">Login Failed</h2>
        <h3>Invalid Email or Password</h3>

        <!-- ✅ Back Button -->
        <a href="index.html" class="btn">Try Again</a>

<%
    }

} else {
%>
    <h3 class="error">Missing Input</h3>

    <!-- ✅ Back Button -->
    <a href="index.html" class="btn">Go to Login</a>

<%
}
%>

</div>

</body>
</html>
