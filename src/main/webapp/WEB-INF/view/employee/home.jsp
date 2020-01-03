<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
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

        <nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">A T W</a>


                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Logout
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                </ul>

            </div>
        </nav>
        <div class="stationGate container" style="margin-top: 100px;">
            <!--        <h3>
                        Choose the gate:
                    </h3>-->

            <div class="station-option"></div>
            <div class="gate-option"></div>
        </div>
        <div class="emp-container">
            <section style="margin-top: 100px;">
                <div class="container  pt-3 pb-3 pl-5 pr-5 shadow extra-margin" style="box-sizing: border-box;">
                    <div class="row">
                        <div class="col-6 border border-dark bg-light shadow">Name: </div>
                        <div class="col-6 border border-dark bg-light shadow">Station: </div>
                    </div>

                </div>
            </section>
            <div class="container   pt-3 pb-3 pl-5 pr-5 shadow extra-margin">
                <div class="row ">
                    <div class=" col-12 p-5">
                        <form>
                            <div class="form-group row">
                                <label for="idholder" class="col-sm-2 col-form-label">Card Id</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="idholder" value="1524624" readonly>
                                </div>

                                <label for="amount" class="col-sm-2 col-form-label">Total Amount</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="amount" readonly>
                                </div>
                            </div>
                            <fieldset class="form-group">
                                <div class="row">
                                    <legend class="col-form-label col-sm-2 pt-0">Vehicle</legend>
                                    <div class="col-sm-10">
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="gridRadios" id="motorcycle"
                                                   value="0.04" onclick="myFunction()" required>
                                            <label class="form-check-label" for="motorcycle">
                                                Motorcycle
                                            </label>
                                        </div>
                                        <div class="form-check">
                                            <input class="form-check-input" type="radio" name="gridRadios"
                                                   id="passenger-car" value="0.06" onclick="myFunction()" required>
                                            <label class="form-check-label" for="passenger-car">
                                                Passenger car
                                            </label>
                                        </div>
                                        <div class="form-check ">
                                            <input class="form-check-input" type="radio" name="gridRadios" id="bus"
                                                   value="0.16" onclick="myFunction()" required>
                                            <label class="form-check-label" for="bus">
                                                Bus
                                            </label>
                                        </div>
                                        <div class="form-check ">
                                            <input class="form-check-input" type="radio" name="gridRadios"
                                                   id="truck-with-4-axis" value="0.23" onclick="myFunction()" required>
                                            <label class="form-check-label" for="truck-with-4-axis">
                                                Truck with >=4 axis
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div id="data"></div>
                            </fieldset>
                            <script>
                                function myFunction() {

                                    document.getElementById("amount").value = ($('input[name=gridRadios]:checked').val() * 123).toFixed(2);
                                }
                            </script>
                            <div class="form-group row">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-success">PAY</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="${path}/static/js/employee-home.js"></script>
    </body>

</html>