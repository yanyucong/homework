<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/4
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="login" method="post">
    <input type="text"
           id="username"
           name="username" <%if (application.getAttribute("username")!=null){%>placeholder="${username}" <%}%>>
    <%--<label>${username}</label>--%>
    <input type="text"
           name="password"
           id="password">
    <input type="submit">
</form>
<h1><a href="register.html">去注册</a></h1>
</body>
</html>
