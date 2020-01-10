<%-- 
    Document   : formEmployee
    Created on : Jan 10, 2020, 7:21:34 PM
    Author     : jimmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${employee.id ne 0}">
                <h1>Update Employee</h1>
            </c:when>
            <c:otherwise>
                <h1>Add Employee</h1>
            </c:otherwise>
        </c:choose>
        
        <form:form 
            action="${pageContext.request.contextPath}/admin/manage-employee/create" 
            method="POST"
            modelAttribute="employee">
            <form:hidden path="id"/>
            First Name : <form:input path="fname"/>
            <form:errors path="fname" cssClass="error"/>
            <br/>
            Last Name : <form:input path="lname"/>
            <form:errors path="lname" cssClass="error"/>
            <br/>
            Phone : <form:input path="phone"/>
            <form:errors path="phone" cssClass="error"/>
            <br/>
            Email : <form:input path="email"/>
            <form:errors path="email" cssClass="error"/>
            <br/>
            <input type="submit" value="Submit">
        </form:form>
            <br/>
            <a href ="${pageContext.request.contextPath}/admin/manage-employee/listEmployee">Return to list</a>
    </body>
</html>
