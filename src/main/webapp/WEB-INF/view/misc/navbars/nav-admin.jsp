<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#"><img src="${path}/static/images/logo.png" alt="logo" width="80" height="60"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${path}/admin">Admin Page</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Manage Admin</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${path}/admin/list-admin">List of Admins</a>
                        <a class="dropdown-item" href="${path}/admin/create">Create Admin</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Manage Employee</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${path}/admin/manage-employee/list-employee">List of Employees</a>
                        <a class="dropdown-item" href="${path}/admin/manage-employee/create">Create Employee</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Manage Gate</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${path}/admin/manage-gate/list">List of Gates</a>
                        <a class="dropdown-item" href="${path}/admin/manage-gate/create">Create Gates</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Manage Station</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${path}/admin/manage-station/list">List of Stations</a>
                        <a class="dropdown-item" href="${path}/admin/manage-station/create">Create Station</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Manage Road</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="${path}/admin/manage-road/list">List of Roads</a>
                        <a class="dropdown-item" href="${path}/admin/manage-road/create">Create Road</a>
                    </div>
                </li>



                <li class="nav-item">

                    <a class="nav-link" href="${path}/logout">Logout</a>

                </li>

            </ul>
        </div>
    </div>
</nav>
<script>
    let listOfa = document.querySelectorAll(".nav-link");
    listOfa.forEach(function (a) {
        console.log(a.href);
        console.log("=============================")
        console.log(window.location.href);
        if (a.href === window.location.href) {
            a.classList.toggle('active');
        }
    });
</script>
