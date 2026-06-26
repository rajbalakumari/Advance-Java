<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result Page</title>
</head>
<body>

<h2>Result</h2>

<%
    int a = Integer.parseInt(request.getParameter("num1"));
    int b = Integer.parseInt(request.getParameter("num2"));

    int c = a / b;   // ArithmeticException if b = 0

    out.println("Result: " + c);
%>

</body>
</html>
