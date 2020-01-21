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
        
        <title>List Roads</title>
    </head>
    <body>
        <%@include file="../../misc/navbars/newjsp.jsp" %>
        <section class="main-container">
            <div class="content">
                <div class="form sign-in">
                        <h1 class="text-center">List of Roads</h1>
                        <p class="text-center">
                            <a href="${pageContext.request.contextPath}/admin/manage-road/create">Add Road</a>
                        </p>
                        
                        <table class="table" >
                            <tr>
                                <th>Road id</th>
                                <th>Road Name</th>
                                <th colspan="2" class="text-center">Actions</th>
                            </tr>
                            <c:forEach items="${listOfRoad}" var="r">
                                <c:url var="updateLink" value="/admin/manage-road/update">
                                    <c:param name="roadId" value="${r.id}" />
                                </c:url>
                                <c:url var="deleteLink" value="/admin/manage-road/delete">>
                                    <c:param name="roadId" value="${r.id}" />
                                </c:url>   

                                <tr>
                                    <td>${r.id}</td>
                                    <td>${r.roadName}</td>
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
            </div>
        </section>
    </body>
</html>
