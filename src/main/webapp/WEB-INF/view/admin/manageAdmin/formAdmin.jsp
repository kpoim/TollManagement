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
        
        <title>New Admin</title>
    </head>
    <body>
        <%@include file="../../misc/navbars/newjsp.jsp" %>
        <section class="main-container">
            <div class="content">
                <div class="form sign-in">
                    
                        <h2>Create New Admin</h2>
                        
                        <form:form method='post' action='${pageContext.request.contextPath}/newAdmin' modelAttribute="admin">
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
                                <form:input type="text" class="form-control" path="firstName"/>

                            </div>
                            <div class="form-group">
                                <label for="lastName">Last Name</label>
                                <form:input type="text" class="form-control" path="lastName"/>

                            </div>
                            <div class="form-group">
                                <label for="phone">phone</label>
                                <form:input type="text" class="form-control" path="phone"/>
                            </div>
                            
                            <button type="submit" class="btn btn-primary ">Create</button>
                        </form:form>

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
