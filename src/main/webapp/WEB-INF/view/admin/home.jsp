<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Document</title>
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

        <%@include file="../misc/navbars/nav-admin.jsp" %>  

        <section style="margin-top: 100px;">
            <div class="container  pt-3 pb-3 pl-5 pr-5 shadow extra-margin" style="box-sizing: border-box;">
                <div class="row">
                    <div class="col-12 border border-dark bg-light shadow">
                        <h2>Admin Panel</h2>
                        <p>Admin  Name : ${admin.fname}  ${admin.lname}</p>

                        <a href="${path}/admin/manageAdmin/update/${admin.id}"> Manage your account </a>
                        <a href="${path}/admin/list-admin"> List of Administrators </a>
                        <a href="${path}/admin/manage-employee/list-employee"> List of All employees </a>
                        <a href="${path}/admin/change-password-form/${admin.id}"> Change Password </a>
                        <div class="mt-3">
                            <p><a href="${pageContext.request.contextPath}/admin/manage-employee/list-employee">Manage Employee</a> | 
                                <a href="${pageContext.request.contextPath}/admin/manage-station/list">Manage Station</a> | 
                                <a href="${pageContext.request.contextPath}/admin/manage-road/list">Manage Road</a> | 
                                <a href="${pageContext.request.contextPath}/admin/manage-gate/list">Manage Gate</a></p>

                        </div>

                    </div>

                </div>
            </div>
        </section>


    </body>

</html>