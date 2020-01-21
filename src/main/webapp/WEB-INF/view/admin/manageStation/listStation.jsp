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
        
        <title>Stations</title>
    </head>
    <body>
    <body>
        <body>
            <%@include file="../../misc/navbars/nav-admin.jsp" %>
        <section class="main-container">
            <div class="content">
                <div class="form sign-in">
                        <h1 class="text-center">List of Stations</h1>
                        <p class="text-center">
                          <a href="${pageContext.request.contextPath}/admin/manage-station/create">Add Station</a>  
                        </p>
                        <br/>
                        <form:form action="${pageContext.request.contextPath}/admin/manage-station/search" method="GET">
                            <label for="search" >Search By Name:</label>
                            <input type="text" class="form-control"  name="search" size="8">
                            <br/>
                            <button type="submit" class="submit submit-button">Search</button>
                            <br/>
                        </form:form>
                        <table class="table" >
                            <tr>
                                <th>Station id</th>
                                <th>Station Name</th>
                                <th>Distance</th>
                                <th>Road id</th>
                                <th colspan="2" class="text-center">Actions</th>
                            </tr>
                            <c:forEach items="${listOfStation}" var="s">
                                <c:url var="updateLink" value="/admin/manage-station/update">
                                    <c:param name="stationId" value="${s.id}" />
                                </c:url>
                                <c:url var="deleteLink" value="/admin/manage-station/delete">>
                                    <c:param name="stationId" value="${s.id}" />
                                </c:url>  


                                <tr>
                                    <td>${s.id}</td>
                                    <td>${s.stationName}</td>
                                    <td>${s.distance}</td>
                                    <td>${s.road.getId()}</td>
                                    <td>
                                        <a href="${updateLink}">Update</a>
                                    </td>
                                    <td>
                                        <a href="${deleteLink}">Delete</a>
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
