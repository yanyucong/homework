<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2018/1/16
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style type="text/css">
        label{
            display: inline-block;
            color: chocolate;
        }
    </style>
</head>
<body>
    <form action="register.action" method="post">
        用户名：<input type="text" name="user.username"><label><s:fielderror fieldName="user.username"/></label>  <br>
        密码：<input type="password" name="user.password"><label><s:fielderror fieldName="user.password"/></label><br>
        确认密码：<input type="password" name="re_password"><label><s:fielderror fieldName="re_password"/> </label><br>
        电话号：<input type="text" name="user.phone"><label><s:fielderror fieldName="user.phone"/></label><br>
        邮箱：<input type="text" name="user.email"><label><s:fielderror fieldName="user.email"/></label><br>
        <%--验证码：<input >--%>
        <input type="submit" value="注册">
    </form>
</body>
</html>
