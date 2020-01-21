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
        <title>ERROR 404</title>
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <title>New Employee</title>
    </head>
    <body>
        <%@include file="../../misc/navbars/nav-admin.jsp" %>
        <section class="main-container">
            <div class="content">
                <div class="form sign-in">
                        <h2>New Admin</h2>
                        <form:form method='post' action="${path}/admin/new-admin" modelAttribute="admin">
                            <div class="form-group ">
                                <label for="username">Username</label>
                                <form:input type="text" class="form-control" path="username"/>
                            </div>
                            <div class="form-group ">
                                <label for="password">Password</label>
                                <form:input type="password" class="form-control" path="password"/>
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
                            <a href ="${pageContext.request.contextPath}/admin/list-admin">Return to list</a>
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
