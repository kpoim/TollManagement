<%-- 
    Document   : formStation
    Created on : Jan 12, 2020, 9:56:19 AM
    Author     : jimmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Station Page</title>
        <style>
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${station.id ne 0}">
                <h1>Update Station</h1>
            </c:when>
            <c:otherwise>
                <h1>Add Station</h1>
            </c:otherwise>
        </c:choose>
        
        <form:form 
            action="${pageContext.request.contextPath}/admin/manage-station/create" 
            method="POST"
            modelAttribute="station">
            <form:hidden path="id"/>
            Station Name: : <form:input path="stationName" placeholder="Station Name"/>
            <form:errors path="stationName" cssClass="error"/>
            <br/>
            Distance: : <form:input path="distance" placeholder="Distance"/>
            <form:errors path="distance" cssClass="error"/>
            <br/>
            Road Id : 
            <form:input path="road.id" placeholder="Road id"/>
            <form:errors path="road.id" cssClass="error"/>
            <br/>
            <input type="submit" value="Submit">
        </form:form>
            <br/>
            <a href ="${pageContext.request.contextPath}/admin/manage-station/list">Return to list</a>
    </body>
</html>
