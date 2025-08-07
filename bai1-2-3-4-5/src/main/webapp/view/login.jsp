<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/05
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đăng nhập</h1>
<form action="<%=request.getContextPath()%>/LoginServlet?action=login" method="post">
    <input type="text" placeholder="Username" id="username" name="username">
    <input type="password" placeholder="Password" id="password" name="password">
    <button type="submit">submit</button>
</form>
</body>
</html>
