<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/07
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="schedule" type=""--%>
<form:form method="post" modelAttribute="schedule">
    <label for="movieId">movieId</label>
    <form:input id="movieId" path="movieId"/>
    <br>
    <label for="showTime">showTime</label>
    <form:input type="date" id="showTime" path="showTime"/>
    <br>
    <label for="screenRoomId">screenRoomId</label>
    <form:input id="screenRoomId" path="screenRoomId"/>
    <br>
    <label for="availableSeats">availableSeats</label>
    <form:input id="availableSeats" path="availableSeats"/>
    <br>
    <label for="format">format</label>
    <form:input id="format" path="format"/>
    <br>
    <button type="submit">Lưu</button>
</form:form>
</body>
</html>
