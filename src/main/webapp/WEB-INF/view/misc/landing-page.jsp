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
        

        <!-- Full Page Image Header with Vertically Centered Content -->
        <header class="masthead">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12 text-center">
                        <img class="img-fluid " src="${path}/static/images/Tolls.jpg" alt="photo of highway tolls">
                        <h1 class="font-weight-light">AWESOME TOLL COMPANY
                        </h1>
                        <p class="lead">Make your highway experience easier</p>
                    </div>
                </div>
            </div>
        </header>

        <!-- Page Content -->
        <section class="py-5">
            <div class="container">

                <h2 class="font-weight-light">Page Content</h2>
                <p>We transform mobility through comprehensive tolling systems for road infrastructures, integrating business-specific disciplines with effective solutions, which enables us to offer comprehensive projects with a high added value.</p>
                <p>The company that makes your highway experience easier is here. By using our <strong>freely</strong> supplied card you can venture Greece’s highways without having to stop all the time and lose time. 
The company started from our will to offer our customers the best possible service and experience. 
</p>
            </div>
        </section>
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
