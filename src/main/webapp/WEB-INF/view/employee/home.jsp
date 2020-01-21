<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR 404</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
    </head>
    <body>

       <%@include file="../misc/navbars/nav-employee.jsp" %>
        <section class="main-container">
            <div class="content">
                <h2>Welcome ${fullName}</h2>
                <div class="stationGate container">
                    <div class="road-option"></div>
                    <div class="station-option"></div>
                    <div class="gate-option"></div>
                </div>
                <div class="emp-container">
                    <section class="emp-info">
                        <div class="container  pt-3 pb-3 pl-5 pr-5 shadow extra-margin" style="box-sizing: border-box;">
                            <div class="row">
                                <div id="employee-name" class="col-4 border border-dark bg-light shadow">Name: ${fullName}</div>
                                <div id="station-name" class="col-4 border border-dark bg-light shadow">Station: </div>
                                <div id="gate-no" class="col-4 border border-dark bg-light shadow">Gate: </div>
                            </div>

                        </div>
                    </section>
                    <div class="container payment-details pt-3 pb-3 pl-5 pr-5 shadow extra-margin">
                        <div class="row ">
                            <div class=" col-12 p-5">
                                <form>
                                    <div class="form-group row">
                                        <label for="idholder" class="col-sm-4 col-form-label">Card Id</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="idholder" value="1524624" readonly>
                                        </div>

                                        <label for="amount" class="col-sm-4 col-form-label">Total Amount</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" id="amount" readonly>
                                        </div>
                                    </div>
                                    <div id="vehicles-container" style="width: 100%;" class="form-group row">
                                        <legend>Vehicle</legend>
                                        <div id="vehicles"></div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-10">
                                            <button type="submit" id="pay-button" class="btn btn-success">PAY</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
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

        <script src="${path}/static/js/employee-home.js"></script>
    </body>
</html>
