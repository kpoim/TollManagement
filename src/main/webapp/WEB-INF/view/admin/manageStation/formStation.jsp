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

        <title>Manage Station Page</title>
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
                        <c:choose>
                            <c:when test="${station.id != null}">
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
                            <label for="stationName">Station Name</label>
                            <form:input path="stationName" class="form-control" placeholder="Station Name"/>
                            <form:errors path="stationName" cssClass="error"/>
                            <br/>
                            <label for="distance">Distance</label>
                            <form:input path="distance" class="form-control" placeholder="Distance"/>
                            <form:errors path="distance" cssClass="error"/>
                            <br/>
                            <label for="distance">Road ID</label> 
                            <form:input path="road.id" class="form-control"  placeholder="Road id"/>
                            <form:errors path="road.id" cssClass="error"/>
                            <br/>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form:form>
                            <br/>
                        <a href ="${pageContext.request.contextPath}/admin/manage-station/list">Return to list</a>
                    </div>

                </div>
            </div>
        </section>
        
    </body>
</html>
