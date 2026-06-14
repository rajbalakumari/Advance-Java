<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Example</title>
</head>
<body>

	<h1>Welcome to JSP...</h1>

	<%
	String name = "RajBala;
	out.println(name + "<br>");
	%>

	Welcome:
	<%=name%><br>
	<br>

	<%
	String name1 = "Krishna";
	int age = 12;
	String loc = "Haven";
	String branch = "CSE";
	long num = 7682000235L;

	out.println("Name is: " + name1 + "<br>");
	out.println("Age is: " + age + "<br>");
	out.println("Location is: " + loc + "<br>");
	out.println("Branch is: " + branch + "<br>");
	out.println("Mobile No is: " + num + "<br><br>");
	%>

	<h2>JSP Method Declaration</h2>

	<%!public String getMessage(String name) {
		return "Hello " + name + "!";
	}%>

	<%
	String result = getMessage("Subham");
	out.println(result + "<br><br>");
	%>

	<%
	int a = 10;
	%>

	Value of a:
	<%=a%><br>
	<br>

	<%!public String working() {
	return "I am RajBala";
}%>

	<%=working()%><br>

	<h1>Current Date And Time..</h1>

	<%
	Date d = new Date();
	out.println("Current Date: " + d + "<br><br>");
	%>

	<!-- ✅ Footer at Bottom -->
	<%@ include file="footer.jsp"%>

</body>
</html>
