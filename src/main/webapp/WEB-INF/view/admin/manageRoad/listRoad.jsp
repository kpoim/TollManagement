<%-- 
    Document   : listRoad
    Created on : Jan 11, 2020, 12:12:05 PM
    Author     : jimmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Roads</title>
    </head>
    <body>
        <h1>List of Roads</h1>
        <a href="${pageContext.request.contextPath}/admin/manage-road/create">Add Road</a>
        <table border="1">
            <c:forEach items="${listOfRoad}" var="r">
                <c:url var="updateLink" value="/admin/manage-road/update">
                    <c:param name="roadId" value="${r.id}" />
                </c:url>
                <c:url var="deleteLink" value="/admin/manage-road/delete">>
                    <c:param name="roadId" value="${r.id}" />
                </c:url>     
                <tr>
                    <td>${r.id}</td>
                    <td>${r.roadName}</td>
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
