<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#buy {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -902px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#buy:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -938px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
<h1>购物车</h1>

<table border="1" width="100%" cellspacing="0" background="black">
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a href="<c:url value='/cart?method=clearCart'/>">清空购物车</a>
		</td>
	</tr>
	<tr>
		<th>图片</th>
		<th>书名</th>
		<th>作者</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
		<th>操作</th>
	</tr>

	<%--<c:if test="${sessionScope.cart != null}">--%>
	<c:set var="money" value="0"/>
		<c:forEach items="${sessionScope.cart}" var="cart">
			<%--<input type="hidden" name="bid" value="${cart.book.bid}">--%>
			<tr>
			<td><div><img src="<c:url value='../../${cart.book.image}'/> "/></div></td>
			<td>${cart.book.bname}</td>
			<td>${cart.book.author}</td>
			<td>${cart.book.price}</td>
			<td>${cart.count}</td>
			<td>${cart.count * cart.book.price}</td>
			<c:set var="money" value="${money + (cart.count * cart.book.price)}"/>
			<td><a href="<c:url value='/cart?method=deleteCartltem&bid=${cart.book.bid}'/>">删除</a></td>
			</tr>
		</c:forEach>

	<%--</c:if>--%>

	<%--<tr>--%>
		<%--<td><div><img src="<c:url value='/book_img/8758723-1_l.jpg'/>"/></div></td>--%>
		<%--<td>Java详解</td>--%>
		<%--<td>张孝祥</td>--%>
		<%--<td>39.9元</td>--%>
		<%--<td>2</td>--%>
		<%--<td>79.8元</td>--%>
		<%--<td><a href="javascript:alert('删除购物项成功！');">删除</a></td>--%>
	<%--</tr>--%>
	<%--<tr>--%>
		<%--<td><div><img src="<c:url value='/book_img/8991366-1_l.jpg'/>"/></div></td>--%>
		<%--<td>Java详解</td>--%>
		<%--<td>张孝祥</td>--%>
		<%--<td>39.9元</td>--%>
		<%--<td>2</td>--%>
		<%--<td>79.8元</td>--%>
		<%--<td><a href="javascript:alert('删除购物项成功！');">删除</a></td>--%>
	<%--</tr>--%>
	<%--<tr>--%>
		<%--<td><div><img src="<c:url value='/book_img/9265169-1_l.jpg'/>"/></div></td>--%>
		<%--<td>Java详解</td>--%>
		<%--<td>张孝祥</td>--%>
		<%--<td>39.9元</td>--%>
		<%--<td>2</td>--%>
		<%--<td>79.8元</td>--%>
		<%--<td><a href="javascript:alert('删除购物项成功！');">删除</a></td>--%>
	<%--</tr>--%>
	<%--<tr>--%>
		<%--<td><div><img src="<c:url value='/book_img/9317290-1_l.jpg'/>"/></div></td>--%>
		<%--<td>Java详解</td>--%>
		<%--<td>张孝祥</td>--%>
		<%--<td>39.9元</td>--%>
		<%--<td>2</td>--%>
		<%--<td>79.8元</td>--%>
		<%--<td><a href="javascript:alert('删除购物项成功！');">删除</a></td>--%>
	<%--</tr>--%>

	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			合计：${money}
			${pageContext.session.setAttribute("money",money)}
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right" style="font-size: 15pt; font-weight: 900">
			<a id="buy" href="<c:url value='/order?method=add'/>"></a>
		</td>
	</tr>
</table>

  </body>
</html>
