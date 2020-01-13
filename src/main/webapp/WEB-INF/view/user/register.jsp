<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>New Client</title>
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



        <section style="margin-top: 100px;">
            <div class="container  pt-3 pb-3 pl-5 pr-5 shadow extra-margin" style="box-sizing: border-box;">
                <div class="row">
                    <div class="col-12 p-4 border border-dark bg-light shadow">
                        <h2>New Client</h2>
                        <label style="white-space: nowrap;">
                            <input type="radio" name="choose-one" value="ProClient" checked required class="chooseOne  "
                                   id="choose-one">Pro Client</label>
                        <label style="white-space: nowrap;">
                            <input type="radio" name="choose-one" value="RetailClient" required class="chooseOne required"
                                   id="choose-one">Retail Client</label>
                            <form:form method="post" action="${path}/newProClient" modelAttribute="proClient">
                            <div class="form-group resultDetail proClient">
                                <label for="username">Username</label>
                                <form:input type="text" class="form-control" path="username"/>

                            </div>
                            <div class="form-group resultDetail proClient">
                                <label for="password">Password</label>
                                <form:input type="password" class="form-control" path="password"/>

                            </div>
                            <div class="form-group resultDetail proClient">

                                <form:input type="hidden" class="form-control" path="clientId" value="0"/>

                            </div>

                            <div class="resultDetail proClient">
                                <label for="proafm">Company AFM</label>
                                <form:input type="text" class="form-control" path="proafm"/>

                            </div>
                            <div class="resultDetail proClient">
                                <label for="companyName">Company Name</label>
                                <form:input type="text" class="form-control" path="companyName"/>

                            </div>



                            <div class="form-group resultDetail proClient">
                                <label for="phone">phone</label>
                                <form:input type="text" class="form-control" path="phone"/>
                            </div>
                            <div class="form-group resultDetail proClient">
                                <label for="address">Address</label>
                                <form:input type="text" class="form-control" path="address"/>
                            </div>
                            <div class="form-group resultDetail proClient">
                                <label for="email">Email</label>
                                <form:input type="text" class="form-control" path="email"/>
                            </div>

                            <button type="submit" class="btn btn-primary resultDetail proClient">Create</button>
                        </form:form>
                        <form:form method="post" action='${path}/newRetailClient' modelAttribute="retailClient">
                            <div class="form-group resultDetail retailClient">
                                <label for="username">Username</label>
                                <form:input type="text" class="form-control" path="username"/>

                            </div>
                            <div class="form-group resultDetail retailClient">
                                <label for="password">Password</label>
                                <form:input type="password" class="form-control" path="password"/>

                            </div>
                            <div class="form-group resultDetail retailClient">

                                <form:input type="hidden" class="form-control" path="clientId" value="1"/>

                            </div>


                            <div class="resultDetail retailClient">
                                <label for="retailAfm">AFM</label>
                                <form:input type="text" class="form-control" path="retailAfm"/>

                            </div>
                            <div class="resultDetail retailClient">
                                <label for="firstname">First Name</label>
                                <form:input type="text" class="form-control" path="firstname"/>

                            </div>
                            <div class="resultDetail retailClient">
                                <label for="lastname">Last name</label>
                                <form:input type="text" class="form-control" path="lastname"/>

                            </div>



                            <div class="form-group resultDetail retailClient">
                                <label for="phone">phone</label>
                                <form:input type="text" class="form-control" path="phone"/>
                            </div>
                            <div class="form-group resultDetail retailClient">
                                <label for="address">Address</label>
                                <form:input type="text" class="form-control" path="address"/>
                            </div>
                            <div class="form-group resultDetail retailClient">
                                Email
                                <form:input type="text" class="form-control" path="email"/>
                            </div>

                            <button type="submit" class="btn btn-primary resultDetail retailClient">Create</button>
                        </form:form>

                    </div>

                </div>
            </div>
        </section>
        <script>
            $('.resultDetail.retailClient').hide();
            $('input[type=radio][name=choose-one]').change(function () {
                //console.log($(this).val());

                var value = $(this).val();

                if (value == 'ProClient') {
                    $('.resultDetail').hide();
                    $('.resultDetail.proClient').show();
                } else if (value == 'RetailClient') {
                    $('.resultDetail').hide();
                    $('.resultDetail.retailClient').show();
                }
            });

        </script>
    </body>
</html>
