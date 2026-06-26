<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
</head>
<body>

<h2>Error Occurred</h2>

<%
    if (exception instanceof ArithmeticException) {
%>
        <p>Cannot divide by zero. Please enter a valid number.</p>
<%
    } else {
%>
        <p>Error Message: <%= exception.getMessage() %></p>
<%
    }
%>

</body>
</html>
