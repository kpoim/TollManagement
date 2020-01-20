<%-- 
    Document   : formRoad
    Created on : Jan 12, 2020, 9:19:16 AM
    Author     : jimmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Road Page</title>
        <style>
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${road.id ne 0}">
                <h1>Update Road</h1>
            </c:when>
            <c:otherwise>
                <h1>Add Road</h1>
            </c:otherwise>
        </c:choose>
        
        <form:form 
            action="${pageContext.request.contextPath}/admin/manage-road/create" 
            method="POST"
            modelAttribute="road">
            <form:hidden path="id"/>
            Road Name : <form:input path="roadName" placeholder="Road Name"/>
            <form:errors path="roadName" cssClass="error"/>
            <br/>
            <input type="submit" value="Submit">
        </form:form>
            <br/>
            <a href ="${pageContext.request.contextPath}/admin/manage-road/list">Return to list</a>
    </body>
</html>
