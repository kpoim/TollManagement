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
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Gate Page</title>
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
                        <h1>Update Gate</h1>
                        <form:form 
                            action="${pageContext.request.contextPath}/admin/manage-gate/update" 
                            method="POST"
                            modelAttribute="gate">
                            <label for="gateid">Gate ID</label>
                            <form:input path="id" class="form-control" readonly="true" />
                            <br/>
                            <label for="gateNo">Gate Number</label>
                            <form:input path="gateNo" class="form-control" placeholder="Gate number"/>
                            <form:errors path="gateNo" cssClass="error"/>
                            <br/>
                            <label for="stationid">Station ID</label>
                            <form:input path="station.id" class="form-control" placeholder="Station id"/>
                            <form:errors path="station.id" cssClass="error"/>
                            <br/>
                            <label for="isEntry">Entry/Exit</label>
                            <form:input path="isEntry" class="form-control"/>
                            <form:errors path="isEntry" cssClass="error"/>
                            <br/>
                            <button type="submit" class="btn btn-primary">Update</button>
                        </form:form>
                        <br/>
                        <a href ="${pageContext.request.contextPath}/admin/manage-gate/list">Return to list</a>
                    </div>

                </div>
            </div>
        </section>
    </body>
</html>
