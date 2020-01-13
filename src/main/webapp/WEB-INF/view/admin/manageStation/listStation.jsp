<%-- 
    Document   : listStation
    Created on : Jan 12, 2020, 9:51:32 AM
    Author     : jimmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Stations</title>
    </head>
    <body>
        <h1>List of Stations</h1>
        <a href="${pageContext.request.contextPath}/admin/manage-station/create">Add Station</a>
        <table border="1">
            <c:forEach items="${listOfStation}" var="s">
                <c:url var="updateLink" value="/admin/manage-station/update">
                    <c:param name="stationId" value="${s.id}" />
                </c:url>
                <c:url var="deleteLink" value="/admin/manage-station/delete">>
                    <c:param name="stationId" value="${s.id}" />
                </c:url>     
                <tr>
                    <td>${s.id}</td>
                    <td>${s.stationName}</td>
                    <td>${s.distance}</td>
                    <td>${s.road.getId()}</td>
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
