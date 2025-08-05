<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/05
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/MovieListServlet?action=addMovie" method="post">
    <label for="title"></label>
    <input type="text" id="title" name="title" placeholder="title">
    <label for="director"></label>
    <input type="text" id="director" name="director" placeholder="director">
    <label for="genre"></label>
    <input type="text" id="genre" name="genre" placeholder="genre">
    <label for="description"></label>
    <input type="text" id="description" name="description" placeholder="description">
    <label for="duration"></label>
    <input type="text" id="duration" name="duration" placeholder="duration">
    <label for="language"></label>
    <input type="text" id="language" name="language" placeholder="language">
    <button type="submit">submit</button>
</form>
</body>
</html>
