<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">A T W</a>
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
                <!--                <li class="nav-item">
                                    <a class="nav-link" href="${path}">About</a>
                                </li>-->
                <!--                <li class="nav-item">
                                    <a class="nav-link" href="#">Services</a>
                                </li>-->
                <li class="nav-item">
                    <a class="nav-link" href="${path}/toll-rates">Toll Rates</a>
                </li>
                <li class="nav-item">
                        <a class="nav-link" href="${path}/donation">Donation</a>
                </li>
                
                <security:authorize access="(!hasAnyRole('ADMIN','CLIENT', 'EMPLOYEE' , 'TERMINAL'))">
                    <li class="nav-item">

                        <a class="nav-link" href="${path}/login">Sign in/Sign up</a>

                    </li>
                </security:authorize>
                <security:authorize access="(hasAnyRole('ADMIN','CLIENT', 'EMPLOYEE' , 'TERMINAL'))">
                    <li class="nav-item">

                        <a class="nav-link" href="${path}/logout">Logout</a>

                    </li>
                </security:authorize>
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
