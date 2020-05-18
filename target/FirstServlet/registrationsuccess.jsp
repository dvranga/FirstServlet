<%--
  Created by IntelliJ IDEA.
  User: Heros
  Date: 5/17/2020
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Success Page</title>
</head>
<body>
<h1>Hi <%=request.getAttribute("user")%>,Registration Successful.</h1>
<a href="login.html">Login Page</a>
</body>
</html>
