<%-- 
    Document   : listEmployee
    Created on : Jan 10, 2020, 6:46:41 PM
    Author     : jimmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
    </head>
    <body>
        <h1>List of Employee</h1>
        <a href="${pageContext.request.contextPath}/admin/manage-employee/create">Add Employee</a>
        <table border="1">
            <c:forEach items="${listOfEmployee}" var="e">
                 
                <tr>
                    <td>${e.fname}</td>
                    <td>${e.lname}</td>
                    <td>${e.phone}</td>
                    <td>${e.email}</td>
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
