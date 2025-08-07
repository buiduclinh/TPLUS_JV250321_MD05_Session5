<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/05
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/MovieListServlet?action=updateMovie" method="post">
    <label for="id"></label>
    <input type="text" id="id" name="id" value="${movie.id}" placeholder="${movie.id}" readonly>
    <label for="title"></label>
    <input type="text" id="title" name="title" placeholder="${movie.title}" value="${movie.title}">
    <label for="director"></label>
    <input type="text" id="director" name="director" placeholder="${movie.director}" value="${movie.director}">
    <label for="genre"></label>
    <input type="text" id="genre" name="genre" placeholder="${movie.genre}" value="${movie.genre}">
    <label for="description"></label>
    <input type="text" id="description" name="description" placeholder="${movie.description}" value="${movie.description}"
    >
    <label for="duration"></label>
    <input type="text" id="duration" name="duration" placeholder="${movie.duration}" value="${movie.duration}">
    <label for="language"></label>
    <input type="text" id="language" name="language" placeholder="${movie.language}" value="${movie.language}">
    <button type="submit">submit</button>
</form>
</body>
</html>
