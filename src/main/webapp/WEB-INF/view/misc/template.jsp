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
    </head>
    <body>

        <%@include file="./navbars/nav-template.jsp" %>
        <section class="main-container">
            <div class="content">
                <h1 style="color:red;">Header</h1>
                <div class="form sign-in">
                    <h2>Welcome back,</h2>
                    <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
                        <h2 class="text-center">Log in</h2>       
                        <label>
                            <span>Username</span>
                            <input type="text"  name="username" required="required">
                        </label>
                        <label>
                            <span>Password</span>
                            <input type="password" name="password" required="required">
                        </label>
                        <div class="form-group">
                            <!--<button type="submit" class="btn btn-primary btn-block">Log in</button>-->
                            <button type="submit" class="submit submit-button">Sign In</button>
                        </div>
                        <c:if test="${param.error !=null}">
                            <div class="alert alert-danger text-center">
                                <i>Invalid username/password</i>
                            </div>
                        </c:if>
                        <c:if test="${param.logout !=null}">
                            <div class="alert alert-success">
                                <i>Logout succesfully</i>
                            </div>
                        </c:if>
                    </form:form >
                    <spring:hasBindErrors name="proClient">
                        <h2 style="color:red">Failed to Sign Up</h2>
                        <ul>
                            <c:forEach var="error" items="${errors.allErrors}">
                                <li><b style="color:red" ><spring:message  message="${error}" /></b></li>
                                <br />
                            </c:forEach>
                        </spring:hasBindErrors>
                    </ul>
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
    </body>
</html>
