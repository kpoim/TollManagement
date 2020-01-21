<%-- 
    Document   : listGate
    Created on : Jan 10, 2020, 8:18:05 PM
    Author     : jimmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <title>List Gates</title>
    </head>
    <body>
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
        <%@include file="../../misc/navbars/nav-admin.jsp" %>
        <h1>List of Gates</h1>
        <a href="${pageContext.request.contextPath}/admin/manage-gate/create">Add Gate</a>
        <table border="1">
            <tr>
                <td>Gate id</td>
                <td>Gate Number</td>
                <td>Station id</td>
                <td>Employee id</td>
                <td>Entry Gate</td>
                <td>Terminal</td>
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
        <%@include file="./../../misc/footer.jsp" %>

    </body>
</html>
