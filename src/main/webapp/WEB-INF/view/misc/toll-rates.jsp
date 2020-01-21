<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR 404</title>
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            table{
                display: flex;
                align-items: center;
                justify-content: space-evenly;
                border: 0;
            }
            td , tr{
                padding: 10px;
            }
            .sub-content {
                background-image: url(/static/images/toll-station2.jpg);
            }
        </style>
    </head>

    <body>
        <!-- bootstrap javascript -->
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

        <security:authorize access="(!hasAnyRole('ADMIN','CLIENT', 'EMPLOYEE' , 'TERMINAL'))">
            <%@include file="./navbars/nav-template.jsp" %>
        </security:authorize>
        <security:authorize access="hasRole('ADMIN')">
            <%@include file="./navbars/nav-admin.jsp" %>
        </security:authorize>
        <security:authorize access="hasRole('CLIENT')">
            <%@include file="./navbars/nav-client.jsp" %>
        </security:authorize>
        <security:authorize access="hasRole('TERMINAL')">
            <%@include file="./navbars/nav-terminal.jsp" %>
        </security:authorize>
        <security:authorize access="hasRole('EMPLOYEE')">
            <%@include file="./navbars/nav-employee.jsp" %>
        </security:authorize>

        <section class="main-container">
            <div class="content">
                <h1 style="color:#083b4c;" class="font-weight-light">TOLL RATES</h1>
                <div class="form sign-in">
                    <h4 class="text-center">Find out the rates about every Vehicle</h4>
                    <table class="text-center p-3" border="1">


                        <tr class="p-3">
                            <td>Category</td>

                            <c:forEach items="${listOfVehicle}" var="vehicle">
                                <td>${vehicle.name}</td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td>Description</td>
                            <c:forEach items="${listOfVehicle}" var="vehicle">
                                <td><c:if test="${vehicle.name=='Bus'}"><img src="${pageContext.request.contextPath}/static/images/vehicles/bus.png"></c:if>
                                    <c:if test="${vehicle.name=='Motorcycle'}"><img src="${pageContext.request.contextPath}/static/images/vehicles/motorcycle.png"></c:if>
                                    <c:if test="${vehicle.name=='Passenger car'}"><img src="${pageContext.request.contextPath}/static/images/vehicles/passenger-car.png"></c:if>
                                    <c:if test="${vehicle.name=='Truck'}"><img src="${pageContext.request.contextPath}/static/images/vehicles/truck.png"></c:if>

                                    </td>

                            </c:forEach>
                        </tr>
                        <tr>
                            <td>Price per Km</td>
                            <c:forEach items="${listOfVehicle}" var="vehicle">

                                <td>${vehicle.price}</td>
                            </c:forEach>

                        </tr>

                    </table>
                </div>
            </div>
            <div class="sub-content">
                <div class="side-shadow">
                    <div class="img-text">
                        <!--                        <h2>ATC</h2>
                                                <p>Awesome Toll Company</p>-->
                    </div>
                </div>
            </div>
        </section>
        <%@include file="./../misc/footer.jsp" %>
        <!-- Full Page Image Header with Vertically Centered Content -->


        <script>
            let listOfa = document.querySelectorAll(".nav-link");
            listOfa.forEach(function (a) {

                if (a.href === window.location.href) {
                    a.classList.toggle('active');
                }
            });
        </script>
    </body>
</html>
