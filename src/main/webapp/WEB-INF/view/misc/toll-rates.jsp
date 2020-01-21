<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <title>ATR</title>
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
        

<!--        <nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#"><img src="${path}/static/images/logo.png" alt="logo" width="80" height="60"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item ">
                            <a class="nav-link" href="#">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <security:authorize access="hasRole('ADMIN')">
                        <li class="nav-item">
                            
                                <a  class="nav-link" href="${pageContext.request.contextPath}/admin">Admin Page</a>
                            
                        </li>
                        </security:authorize>
                        <security:authorize access="hasRole('CLIENT')">
                        <li class="nav-item">
                            
                                <a  class="nav-link" href="${pageContext.request.contextPath}/user">Client Page</a>
                            
                        </li>
                        </security:authorize>
                        <security:authorize access="hasRole('EMPLOYEE')">
                        <li class="nav-item">
                            
                                <a  class="nav-link" href="${pageContext.request.contextPath}/employee">Employee Page</a>
                            
                        </li>
                        </security:authorize>
                        <security:authorize access="hasRole('TERMINAL')">
                        <li class="nav-item">
                            
                                <a  class="nav-link" href="${pageContext.request.contextPath}/terminal">Terminal Page</a>
                            
                        </li>
                        </security:authorize>
                        <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${path}/toll-rates">Toll Rates</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${path}/donation">Donation</a>
                        </li>
                        
                        <security:authorize access="(!hasAnyRole('ADMIN','CLIENT', 'EMPLOYEE' , 'TERMINAL'))">
                        <li class="nav-item">
                            
                                <a class="nav-link" href="${path}/login">Sign in/Sign up</a>
                            
                        </li>
                        </security:authorize>
                        <security:authorize access="(hasAnyRole('ADMIN','CLIENT', 'EMPLOYEE' , 'TERMINAL'))">
                        <li class="nav-item">
                            
                                <a class="nav-link" href="${path}/logout">Logout</a>
                            
                        </li>
                        </security:authorize>
                    </ul>
                </div>
            </div>
        </nav>-->

        <!-- Full Page Image Header with Vertically Centered Content -->
        <header class="masthead">
            <div class="container container-fluid col-12 text-center banner w-auto">
        <img src="${pageContext.request.contextPath}/static/images/toll-station.jpg" class="img-fluid "  alt="photo of toll station">
        
    </div>
            
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12 text-center">

                        <h1 class="font-weight-light">TOLL RATES
                        </h1>
                        <p class="lead">Find out the rates about every Vehicle</p>
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
            </div>
        </header>

        <script>
            let listOfa = document.querySelectorAll(".nav-link");
            listOfa.forEach(function (a) {
                console.log(a.href);
                console.log("=============================")
                console.log(window.location.href);
                if (a.href === window.location.href) {
                    a.classList.toggle('active');
                }
            });
        </script>
    </body>
</html>
