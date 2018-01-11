<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'msg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

<h1>${msg}</h1>
<ul>
<c:forEach items="${book_count}" var="book_count">
    <tr bordercolor="gray" align="center">
        <td width="15%">
            <div><img src="<c:url value='../../${book_count.image}'/>" height="75"/></div>
        </td>
        <td>书名：${book_count.bname}</td>
        <td>单价：${book_count.price}</td>
        <td>作者：${book_count.author}</td>
        <td>数量：${book_count.count}</td>
        <td>小计：${book_count.count * book_count.price}</td>
    </tr>
</c:forEach>
</ul>
  </body>
</html>
