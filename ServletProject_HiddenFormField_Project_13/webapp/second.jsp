<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is Second Page..</h1>
<form action="second" method="post">
<input type="hidden" name="uname" value="${name}">
<input type="submit" value="Go To Next Page">
</form>
</body>
</html>
