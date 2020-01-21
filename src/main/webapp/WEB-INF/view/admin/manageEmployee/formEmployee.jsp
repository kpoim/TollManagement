<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <title>New Employee</title>
    </head>
    <body>
        <%@include file="../../misc/navbars/nav-admin.jsp" %>
        <section class="main-container">
            <div class="content">
                <div class="form sign-in">
                        <h2 class="text-center">New Employee</h2>
                        <form:form method='post' action="${path}/admin/manage-employee/create" modelAttribute="employee">
                            <div class="form-group ">
                                <label for="username">Username</label>
                                <form:input type="text" class="form-control" path="username"/>
                                <form:errors path="username" cssClass="error"/>
                                ${employeeExistsError}
                            </div>
                            <div class="form-group ">
                                <label for="password">Password</label>
                                <form:input type="password" class="form-control" path="password"/>
                                <form:errors path="password" cssClass="error"/>
                            </div>
                            <div class="form-group">
                                <label for="firstName">First name</label>
                                <form:input type="text" class="form-control" path="fname"/>
                            </div>
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <form:input type="text" class="form-control" path="lname"/>
                            </div>
                            <div class="form-group">
                                <label for="phone">phone</label>
                                <form:input type="text" class="form-control" path="phone"/>
                            </div>
                            <div class="form-group">
                                <label for="phone">e-mail</label>
                                <form:input type="text" class="form-control" path="email"/>
                            </div>
                            <button type="submit" class="submit submit-button">Create</button>
                        </form:form>
                            <p class="text-center">
                            <a href ="${pageContext.request.contextPath}/admin/manage-employee/list-employee">Return to list</a>
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
                <%@include file="./../../misc/footer.jsp" %>
                
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

    </body>
</html>
