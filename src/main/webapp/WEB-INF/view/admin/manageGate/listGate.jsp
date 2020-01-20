<%-- 
    Document   : listGate
    Created on : Jan 10, 2020, 8:18:05 PM
    Author     : jimmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Gates</title>
    </head>
    <body>
        <h1>List of Gates</h1>
        <a href="${pageContext.request.contextPath}/admin/manage-gate/create">Add Gate</a>
        <table border="1">
            <tr>
                <td>Gate id</td>
                <td>Gate Number</td>
                <td>Station id</td>
                <td>Employee id</td>
                <td>Entry Gate</td>
                <td>Terminal</td>
            </tr>
            <c:forEach items="${listOfTerminal}" var="t">
                <c:url var="updateLink" value="/admin/manage-gate/update">
                    <c:param name="gateId" value="${t.gate.id}" />
                </c:url>
                <c:url var="deleteLink" value="/admin/manage-gate/delete">>
                    <c:param name="gateId" value="${t.gate.id}" />
                </c:url>

                <tr>
                    <td>${t.gate.id}</td>
                    <td>${t.gate.gateNo}</td>
                    <td>${t.gate.station.getId()}</td>
                    <td>${t.gate.employee.getId()}</td>
                    <td>${t.gate.isEntry}</td>
                    <td>${t.username}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                    </td>
                    <td>
                        <a href="${deleteLink}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
