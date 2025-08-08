<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/07
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>No</th>
        <th>ID</th>
        <th>movieId</th>
        <th>movieTitle</th>
        <th>showTime</th>
        <th>screenRoomId</th>
        <th>availableSeats</th>
        <th>format</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${schedules}" var="schedule" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${schedule.id}</td>
            <td>${schedule.movieId}</td>
            <td>${schedule.movieTitle}</td>
            <td>${schedule.showTime}</td>
            <td>${schedule.screenRoomId}</td>
            <td>${schedule.availableSeats}</td>
            <td>${schedule.format}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="<%=request.getContextPath()%>/ScheduleServlet/addSchedule">addSchedule</a>
</body>
</html>
