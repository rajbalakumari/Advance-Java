<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String name=request.getParameter("name");
  session.setAttribute("user", name);
  out.println(name);
%>
Session Value is:<%=session.getAttribute("user")%>
Hello:<%=name %>

</body>
</html>
