<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie List</title>
</head>
<body>
<form action="">
    <table border="1">
        <thead>
        <tr>
            <th>No</th>
            <th>ID</th>
            <th>Title</th>
            <th>Director</th>
            <th>Genre</th>
            <th>Description</th>
            <th>Duration</th>
            <th>Language</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${movieList}" var="movie" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${movie.id}</td>
                <td>${movie.title}</td>
                <td>${movie.director}</td>
                <td>${movie.genre}</td>
                <td>${movie.description}</td>
                <td>${movie.duration}</td>
                <td>${movie.language}</td>
                <td>
                    <a href="<%=request.getContextPath()%>/MovieListServlet?action=getMovieById&id=${movie.id}">update</a>
                </td>
                <td><a href="<%=request.getContextPath()%>/MovieListServlet?action=deleteMovie&id=${movie.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="<%=request.getContextPath()%>/view/addMovie.jsp">add Movie</a>
</form>
</body>
</html>