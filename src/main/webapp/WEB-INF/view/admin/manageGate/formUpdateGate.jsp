<%-- 
    Document   : formUpdateGate
    Created on : Jan 14, 2020, 8:19:20 PM
    Author     : jimmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Gate Page</title>
    </head>
    <body>
        <h1>Update Gate</h1>
        <form:form 
            action="${pageContext.request.contextPath}/admin/manage-gate/update" 
            method="POST"
            modelAttribute="gate">
            Gate id: <form:input path="id" readonly="true" />
            <br/>
            Gate Number: : <form:input path="gateNo" placeholder="Gate number"/>
            <form:errors path="gateNo" cssClass="error"/>
            <br/>
            Station Id: : <form:select path="station.id"/>
            <form:errors path="station.id" cssClass="error"/>
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
