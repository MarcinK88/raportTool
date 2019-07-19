<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 10619730
  Date: 19.07.2019
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <form:hidden path="id" />
    login: <form:input path="login" /><br>
    password: <form:input path="password" />
    <input type="submit" value="login" />

</form:form>
</body>
</html>
