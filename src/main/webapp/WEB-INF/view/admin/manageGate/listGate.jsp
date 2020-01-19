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
            </tr>
            <c:forEach items="${listOfGate}" var="g">
                <c:url var="updateLink" value="/admin/manage-gate/update">
                    <c:param name="gateId" value="${g.id}" />
                </c:url>
                <c:url var="deleteLink" value="/admin/manage-gate/delete">>
                    <c:param name="gateId" value="${g.id}" />
                </c:url>

                <tr>
                    <td>${g.id}</td>
                    <td>${g.gateNo}</td>
                    <td>${g.station.getId()}</td>
                    <td>${g.employee.getId()}</td>
                    <td>${g.isEntry}</td>
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
