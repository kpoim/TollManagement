<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR 404</title>
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <title>Manage Gate Page</title>
    </style>
</head>
<body>
    <%@include file="../../misc/navbars/newjsp.jsp" %>
        <section class="main-container">
            <div class="content">
                <div class="form sign-in">
                    <h1 class="text-center">Add Gate</h1>
                    <form:form 
                        action="${pageContext.request.contextPath}/admin/manage-gate/create" 
                        method="POST"
                        modelAttribute="wrapperGateTerminal">
                        <label for="gateNo">Gate Number</label>
                        <form:input path="gate.gateNo" class="form-control" placeholder="Gate Number"/>
                        <form:errors path="gate.gateNo" cssClass="error"/>
                        <label for="stationid">Station ID</label>
                        <form:input path="gate.station.id" class="form-control" placeholder="Station id"/>
                        <form:errors path="gate.station.id" cssClass="error"/>
                        <label for="isEntry">Entry/Exit</label>
                        <form:input path="gate.isEntry" class="form-control"/>
                        <form:errors path="gate.isEntry" cssClass="error"/>
                        <label for="username">Username</label>
                        <form:input path="terminal.username" class="form-control" placeholder="username"/>
                        <form:errors path="terminal.username" cssClass="error"/>
                        ${wrapperGateTerminalExistsError}
                        <label for="password">Password</label>
                        <form:input type="password" class="form-control" path="terminal.password" placeholder="password"/>
                        <form:errors path="terminal.password" cssClass="error"/>
                        <br/>
                        <button type="submit" class="submit submit-button">Create</button>
                    </form:form>
                    <br/>
                    <p class="text-center">
                        <a href ="${pageContext.request.contextPath}/admin/manage-gate/list">Return to list</a>
                    </p>
                </div>
            </div>
            <div class="sub-content">
                <div class="side-shadow">
                    <div class="img-text">
                        <h2>ATC</h2>
                        <p>Awesome Toll Company</p>
                    </div>
                </div>
            </div>
        </section>
        <footer>
            footer
        </footer>
</body>
</html>
