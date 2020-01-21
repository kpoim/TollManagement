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
        
        <title>List Gates</title>
    </head>
    <body>
        <%@include file="../../misc/navbars/nav-admin.jsp" %>
        <section class="main-container">
            <div class="content">
                <div class="form sign-in">
                        <h1 class="text-center">List of Gates</h1>
                        <p class="text-center">
                         <a href="${pageContext.request.contextPath}/admin/manage-gate/create" >Add Gate</a>   
                        </p>
                        
                        <table class="table">
                            <tr>
                                <th>Gate id</th>
                                <th>Gate Number</th>
                                <th>Station id</th>
                                <th>Employee id</th>
                                <th>Entry Gate</th>
                                <th>Terminal</th>
                                <th colspan="2" class="text-center">Actions</th>
                            </tr>
                            <c:forEach items="${listOfTerminal}" var="t">
                                <c:url var="updateLink" value="/admin/manage-gate/update">
                                    <c:param name="gateId" value="${t.gate.id}" />
                                </c:url>
                                <c:url var="deleteLink" value="/admin/manage-gate/delete">>
                                    <c:param name="gateId" value="${t.gate.id}" />
                                </c:url>

                                <tr>
                                    <td>${t.gate.id}</td>
                                    <td>${t.gate.gateNo}</td>
                                    <td>${t.gate.station.getId()}</td>
                                    <td>${t.gate.employee.getId()}</td>
                                    <td>${t.gate.isEntry}</td>
                                    <td>${t.username}</td>
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
