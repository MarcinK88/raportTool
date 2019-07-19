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
logged user: ${sessionScope.get("loggedUser")}<br>
<a href="/">Homepage</a>
<table border="1">
    <tr>
        <th>id</th>
        <th>number</th>
        <th>open_time</th>
        <th>opened_by</th>
        <th>assignment</th>
        <th>status</th>
        <th>close_time</th>
        <th>resolution_code</th>
        <th>location</th>
        <th>assignee_name</th>
        <th>contact_name</th>
        <th>company</th>
        <th>brief_description</th>
        <th>problem_status</th>
        <th>request_type</th>
        <th>product_type</th>
        <th>resolved_by</th>
        <th>resolved_time</th>
        <th>contact_service</th>
        <th>tk_contact_fullname</th>
        <th>tk_contact_email</th>
        <th>tk_sap_company_full_name</th>
        <th>tk_assignee_name_fullname</th>
        <th>tk_contact_service_fullname</th>
        <th>tk_callback_contact_ldap_ba</th>
        <th>ba</th>
        <th>tk_country_fullname</th>
        <th>dim_regions_id</th>
        <th>tk_company_id</th>
    </tr>
    <c:forEach items="${tickets}" var="ticket">
    <tr>
        <td>${ticket.id}</td>
        <td>${ticket.number}</td>
        <td>${ticket.open_time}</td>
        <td>${ticket.opened_by}</td>
        <td>${ticket.assignment}</td>
        <td>${ticket.status}</td>
        <td>${ticket.close_time}</td>
        <td>${ticket.resolution_code}</td>
        <td>${ticket.location}</td>
        <td>${ticket.assignee_name}</td>
        <td>${ticket.contact_name}</td>
        <td>${ticket.company}</td>
        <td>${ticket.brief_description}</td>
        <td>${ticket.problem_status}</td>
        <td>${ticket.request_type}</td>
        <td>${ticket.product_type}</td>
        <td>${ticket.resolved_by}</td>
        <td>${ticket.resolved_time}</td>
        <td>${ticket.contact_service}</td>
        <td>${ticket.tk_contact_fullname}</td>
        <td>${ticket.tk_contact_email}</td>
        <td>${ticket.tk_sap_company_full_name}</td>
        <td>${ticket.tk_assignee_name_fullname}</td>
        <td>${ticket.tk_contact_service_fullname}</td>
        <td>${ticket.tk_callback_contact_ldap_ba}</td>
        <td>${ticket.ba}</td>
        <td>${ticket.tk_country_fullname}</td>
        <td>${ticket.dim_regions_id}</td>
        <td>${ticket.tk_company_id}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
