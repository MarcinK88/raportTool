<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 10619730
  Date: 17.07.2019
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <th>id</th>
    <th>Request ID</th>
    <th>Request type</th>
    <th>Certificate name</th>
    <th>Domain total number/tag</th>
    <th>Request owner</th>
    <th>Request contributor</th>
    <th>Request status</th>
    <th>Year</th>
    <th>Open date</th>
    <th>Open CW</th>
    <th>Open month</th>
    <th>Close date</th>
    <th>Close CW</th>
    <th>Close month</th>
    <th>Resolution Time (in days)</th>
    <th>Region</th>
    <th>BA</th>
    <th>Size</th>
    <th>Provider Name</th>
    <th>Provider Ref.NO</th>
    <th>Requester</th>
    <th>Comments</th>
    <c:forEach items="${converted}" var="ticket"><tr>
        <td>${ticket.id}</td>
        <td>${ticket.requestId}</td>
        <td>${ticket.requestType}</td>
        <td>${ticket.certificateName}</td>
        <td>${ticket.domainTotalNumberTag}</td>
        <td>${ticket.requestOwner}</td>
        <td>${ticket.requestContributor}</td>
        <td>${ticket.requestStatus}</td>
        <td>${ticket.year}</td>
        <td>${ticket.openDate}</td>
        <td>${ticket.openCw}</td>
        <td>${ticket.openMonth}</td>
        <td>${ticket.closeDate}</td>
        <td>${ticket.closeCw}</td>
        <td>${ticket.closeMonth}</td>
        <td>${ticket.resolutionTimeInDays}</td>
        <td>${ticket.region}</td>
        <td>${ticket.ba}</td>
        <td>${ticket.size}</td>
        <td>${ticket.providerName}</td>
        <td>${ticket.providerRefNo}</td>
        <td>${ticket.requester}</td>
        <td>${ticket.comments}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
