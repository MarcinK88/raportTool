<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10619730
  Date: 17.07.2019
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>number</th>
        <th>assigneeName</th>
        <th>openTime</th>
        <th>closeTime</th>
        <th>ba</th>
        <th>status</th>
    </tr>
    <c:forEach items="${tickets}" var="ticket">
    <tr>
        <td>${ticket.number}</td>
        <td>${ticket.assignee_name}</td>
        <td>${ticket.open_time}</td>
        <td>${ticket.close_time}</td>
        <td>${ticket.ba}</td>
        <td>${ticket.status}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
