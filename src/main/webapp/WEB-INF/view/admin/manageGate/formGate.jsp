
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Gate Page</title>
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
    crossorigin="anonymsus"></script>
    <section style="margin-top: 100px;">
        <div class="container  pt-3 pb-3 pl-5 pr-5 shadow extra-margin" style="box-sizing: border-box;">
            <div class="row">
                <div class="col-12 p-4 border border-dark bg-light shadow">
                    <h1>Add Gate</h1>
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
                        Username : <form:input path="terminal.username" class="form-control" placeholder="username"/>
                        <form:errors path="terminal.username" cssClass="error"/>
                        ${wrapperGateTerminalExistsError}
                        <label for="password">Password</label>
                        <form:input type="password" class="form-control" path="terminal.password" placeholder="password"/>
                        <form:errors path="terminal.password" cssClass="error"/>
                        <br/>
                        <button type="submit" class="btn btn-primary">Create</button>
                    </form:form>
                    <br/>
                    <a href ="${pageContext.request.contextPath}/admin/manage-gate/list">Return to list</a>
                </div>

            </div>
        </div>
    </section>
</body>
</html>
