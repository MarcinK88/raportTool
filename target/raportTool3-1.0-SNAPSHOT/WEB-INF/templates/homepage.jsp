<%--
  Created by IntelliJ IDEA.
  User: 10619730
  Date: 17.07.2019
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
logged user: ${sessionScope.get("loggedUser")}
<ul>
    <li><a href="/tickets">Tickets</a></li>
    <li><a href="/importlist">Import file</a></li>
    <li><a href="">Generate charts</a></li>
    <li><a href="/test">Test page</a></li>

</ul>
</body>
</html>
