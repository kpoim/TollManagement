<%-- 
    Document   : formGate
    Created on : Jan 11, 2020, 10:35:30 AM
    Author     : jimmi
--%>

<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Gate Page</title>
        <style>
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Add Gate</h1>
        <form:form 
            action="${pageContext.request.contextPath}/admin/manage-gate/create" 
            method="POST"
            modelAttribute="wrapperGateTerminal">
            Gate Number: : <form:input path="gate.gateNo" placeholder="Gate Number"/>
            <form:errors path="gate.gateNo" cssClass="error"/>
            <br/>
            Station Id: : <form:input path="gate.station.id" placeholder="Station id"/>
            <form:errors path="gate.station.id" cssClass="error"/>
            <br/>
            Is Entry : <form:input path="gate.isEntry"/>
            <form:errors path="gate.isEntry" cssClass="error"/>
            <br/>
            Username : <form:input path="terminal.username" placeholder="username"/>
            <form:errors path="terminal.username" cssClass="error"/>
            ${wrapperGateTerminalExistsError}
            <br/>
            Password : <form:input type="password" path="terminal.password" placeholder="password"/>
            <form:errors path="terminal.password" cssClass="error"/>
            <br/>
            <input type="submit" value="Submit">
        </form:form>
        <br/>
        <a href ="${pageContext.request.contextPath}/admin/manage-gate/list">Return to list</a>
    </body>
</html>
