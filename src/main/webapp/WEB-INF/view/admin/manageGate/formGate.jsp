<%-- 
    Document   : formGate
    Created on : Jan 11, 2020, 10:35:30 AM
    Author     : jimmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Gate Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${gate.id ne 0}">
                <h1>Update Gate</h1>
            </c:when>
            <c:otherwise>
                <h1>Add Gate</h1>
            </c:otherwise>
        </c:choose>
        
        <form:form 
            action="${pageContext.request.contextPath}/admin/manage-gate/create" 
            method="POST"
            modelAttribute="gate">
            <form:hidden path="id"/>
            Gate Number: : <form:input path="gateNo"/>
            <form:errors path="gateNo" cssClass="error"/>
            <br/>
            Station Id: : <form:input path="station.id"/>
            <form:errors path="station.id" cssClass="error"/>
            <br/>
            Employee Id : <form:input path="employee.id"/>
            <form:errors path="employee.id" cssClass="error"/>
            <br/>
            Is Entry : <form:input path="isEntry"/>
            <form:errors path="isEntry" cssClass="error"/>
            <br/>
            <input type="submit" value="Submit">
        </form:form>
            <br/>
            <a href ="${pageContext.request.contextPath}/admin/manage-gate/list">Return to list</a>
    </body>
</html>
