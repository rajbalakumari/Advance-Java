<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome To ProFile Page...</h1>

<%
  String myname=(String) session.getAttribute("name");
  String myemail=(String) session.getAttribute("email");
  int mynumber=(int) session.getAttribute("mob");
%>
    <h3>
     Welcome to profile Page:<%=myname%>  <br> 
     My Email Is :<%=myemail%>  <br> 
     My Number Is:<%=mynumber%><br> 
     
   </h3>
</body>
</html>
