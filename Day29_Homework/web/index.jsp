<%@ page import="com.lanou3g.dao.BookDao" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lanou3g.bean.Book" %><%--
  Created by IntelliJ IDEA.
  User: zyf
  Date: 2018/1/3
  Time: 上午9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>主页</title>
    <script src="js/jquery-3.2.1.min.js"></script>
  </head>
  <body>
    <h1>用户名：<span id="username"></span></h1>
    <h1>密码：<span id="password"></span></h1>
    <%--<%--%>
      <%--if (session.getAttribute("username") != null){--%>
    <%--%>--%>
    <%--<h1>登陆成功，显示主页信息</h1>--%>
    <%--<%--%>
    <%--}else {--%>
    <%--%>--%>
    <%--<h1><a href="login.html">请去登录</a></h1>--%>
    <%--<%--%>
      <%--}--%>
    <%--%>--%>
    <table border="1">
      <tr>
        <th>bookName</th>
        <th>author</th>
        <th>price</th>
      </tr>
    <%
      BookDao bookDao = new BookDao();
      List<Book> books = bookDao.query();
      for (int i = 0;i < books.size();i++){
        Book  book =  books.get(i);
    %>
      <tr>
    <td><%=book.getBookname()%></td>
    <td><%=book.getAuthor()%></td>
    <td><%=book.getPrice()%></td>
      </tr>
    <%
      }
    %>
    </table>

  <a href="Login.jsp"><button>退出</button></a>

  </body>
  <%--<script type="text/javascript">--%>
    <%--$.getJSON("http://localhost:8080/day299/show",--%>
        <%--function (json,status) {--%>
        <%--if(status == "success"){--%>
            <%--$('#username').text(json['username']);--%>
            <%--$('#password').text(json['password']);--%>
        <%--}--%>
    <%--})--%>
  <%--</script>--%>
</html>
