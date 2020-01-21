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

        <title>Employee Page</title>
    </head>
    <body>
        <%@include file="../../misc/navbars/nav-admin.jsp" %>
        <section class="main-container">
            <div class="content">
                <div class="form sign-in">
                    <h1 class="text-center">List of Administrators</h1>
                    <p class="text-center">
                        <a href="${pageContext.request.contextPath}/admin/create">Add Admin</a>
                    </p>

                    <table class="table">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Phone</th>
                            <th>Email</th>
                            <th>Role</th>
                            <th colspan="2" class="text-center">Actions</th>
                        </tr>
                        <c:forEach items="${listOfAdmin}" var="admin">

                            <tr>

                                <td>${admin.fname}</td>
                                <td>${admin.lname}</td>
                                <td>${admin.phone}</td>
                                <td>${admin.email}</td>
                                <td>${admin.role.rname}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/update/${admin.id}">Update</a>
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/delete/${admin.id}">Delete</a>
                                </td>

                            </tr>
                        </c:forEach>
                    </table>
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
