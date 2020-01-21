<%-- 
    Document   : formGate
    Created on : Jan 11, 2020, 10:35:30 AM
    Author     : jimmi
--%>


<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <title>Add Gates</title>

        <style>
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        <%@include file="../../misc/navbars/nav-admin.jsp" %>
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

        <%@include file="./../../misc/footer.jsp" %>
    </body>
</html>
