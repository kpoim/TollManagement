<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Document</title>
</head>

<body>
    <!-- header for admin pages  -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"
        integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous">
        </script>
    <%@include file="../../misc/navbars/nav-admin.jsp" %>
    <!-- end of header -->
    <section style="margin-top: 100px;">
        <div class="container  pt-3 pb-3 pl-5 pr-5 shadow extra-margin" style="box-sizing: border-box;">
            <div class="row">
                <div class="col-12 border border-dark bg-light shadow">
                    <h2>Employee data</h2>
                    <p><a href="">Create new Employee</a></p>
                    <table class="table  table-bordered">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">First Name</th>
                                <th scope="col">Last Name</th>
                                <th scope="col"></th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td><a href="">Update</a> </td>
                                <td><a href="">Delete</a> </td>
                            </tr>
                            <tr>
                                <th scope="row">1</th>
                                <td>John</td>
                                <td>Karl</td>
                                <td><a href="">Update</a> </td>
                                <td><a href="">Delete</a> </td>
                            </tr>
                            <tr>
                                <th scope="row">1</th>
                                <td>James</td>
                                <td>Jones</td>
                                <td><a href="">Update</a> </td>
                                <td><a href="">Delete</a> </td>
                            </tr>

                        </tbody>
                    </table>

                </div>
                <div class="mt-3">
                    <p> <a href="/ATR/admin/manageStation.html">Manage Station</a> | <a href="/ATR/admin/manageRoad.html">Manage Road</a> | <a href="/ATR/admin/manageGate.html">Manage Gate</a></p>
                </div>
            </div>
        </div>
    </section>


</body>

</html>