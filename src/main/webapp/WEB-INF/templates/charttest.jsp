<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 10619730
  Date: 22.07.2019
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="tableWriter">

    Select Year: <form:select path="selectedYear"><form:options items="${tableWriter.years}"/></form:select> <br>
    Select Month: <form:select path="selectedMonth"><form:options items="${tableWriter.months}"/></form:select><br>
    <input type="submit" value="generate">


</form:form>
</body>
</html>
