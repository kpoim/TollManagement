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
        <%@include file="../../misc/navbars/nav-admin.jsp" %>
        <h1>List of Employee</h1>
        <a href="${pageContext.request.contextPath}/admin/create">Add Admin</a>
        <table border="1">
            <c:forEach items="${listOfAdmin}" var="admin">
                 
                <tr>
                    
                    <td>${admin.fname}</td>
                    <td>${admin.lname}</td>
                    <td>${admin.phone}</td>
                    <td>${admin.email}</td>
                    <td>${admin.role.rname}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/update/${admin.id}">Update</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/delete/${admin.id}">Delete</a>
                    </td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
