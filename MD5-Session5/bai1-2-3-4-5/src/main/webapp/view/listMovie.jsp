<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2025/08/05
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="">
    <table>
        <thead>
        <tr>
            <th>No</th>
            <th>id</th>
            <th>title</th>
            <th>director</th>
            <th>genre</th>
            <th>description</th>
            <th>duration</th>
            <th>language</th>
        </tr>
        </thead>
        <tbody>
        <c:foreach item="${}" var="" varStatus="loop">
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </c:foreach>
        </tbody>
    </table>
</form>
</body>
</html>
