
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login Form</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
        <!--<style type="text/css">
                .login-form {
                        width: 340px;
                margin: 50px auto;
                }
            .login-form form {
                margin-bottom: 15px;
                background: #f7f7f7;
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                padding: 30px;
            }
            .login-form h2 {
                margin: 0 0 15px;
            }
            .form-control, .btn {
                min-height: 38px;
                border-radius: 2px;
            }
            .btn {        
                font-size: 15px;
                font-weight: bold;
            }
        </style>-->

        <style>
            *, *:before, *:after {
                box-sizing: border-box;
                margin: 0;
                padding: 0;
            }

            body {
                font-family: 'Open Sans', Helvetica, Arial, sans-serif;
                background: #ededed;
            }

            input, button {
                border: none;
                outline: none;
                background: none;
                font-family: 'Open Sans', Helvetica, Arial, sans-serif;
            }

            .tip {
                font-size: 20px;
                margin: 40px auto 50px;
                text-align: center;
            }

            .cont {
                overflow: hidden;
                position: relative;
                width: 900px;
                height: 550px;
                margin: 0 auto 100px;
                background: #fff;
            }

            .form {
                position: relative;
                width: 640px;
                height: 100%;
                transition: -webkit-transform 1.2s ease-in-out;
                transition: transform 1.2s ease-in-out;
                transition: transform 1.2s ease-in-out, -webkit-transform 1.2s ease-in-out;
                padding: 50px 30px 0;
            }

            .sub-cont {
                overflow: hidden;
                position: absolute;
                left: 640px;
                top: 0;
                width: 900px;
                height: 100%;
                padding-left: 260px;
                background: #fff;
                transition: -webkit-transform 1.2s ease-in-out;
                transition: transform 1.2s ease-in-out;
                transition: transform 1.2s ease-in-out, -webkit-transform 1.2s ease-in-out;
            }
            .cont.s--signup .sub-cont {
                -webkit-transform: translate3d(-640px, 0, 0);
                transform: translate3d(-640px, 0, 0);
            }

            button {
                display: block;
                margin: 0 auto;
                width: 260px;
                height: 36px;
                border-radius: 30px;
                color: #fff;
                font-size: 15px;
                cursor: pointer;
            }

            .img {
                overflow: hidden;
                z-index: 2;
                position: absolute;
                left: 0;
                top: 0;
                width: 260px;
                height: 100%;
                padding-top: 360px;
            }
            .img:before {
                content: '';
                position: absolute;
                right: 0;
                top: 0;
                width: 900px;
                height: 100%;
                background-image: url("${pageContext.request.contextPath}/static/images/Tolls.jpg");
                background-size: cover;
                transition: -webkit-transform 1.2s ease-in-out;
                transition: transform 1.2s ease-in-out;
                transition: transform 1.2s ease-in-out, -webkit-transform 1.2s ease-in-out;
            }
            .img:after {
                content: '';
                position: absolute;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                background: rgba(0, 0, 0, 0.6);
            }
            .cont.s--signup .img:before {
                -webkit-transform: translate3d(640px, 0, 0);
                transform: translate3d(640px, 0, 0);
            }
            .img__text {
                z-index: 2;
                position: absolute;
                left: 0;
                top: 50px;
                width: 100%;
                padding: 0 20px;
                text-align: center;
                color: #fff;
                transition: -webkit-transform 1.2s ease-in-out;
                transition: transform 1.2s ease-in-out;
                transition: transform 1.2s ease-in-out, -webkit-transform 1.2s ease-in-out;
            }
            .img__text h2 {
                margin-bottom: 10px;
                font-weight: normal;
            }
            .img__text p {
                font-size: 14px;
                line-height: 1.5;
            }
            .cont.s--signup .img__text.m--up {
                -webkit-transform: translateX(520px);
                transform: translateX(520px);
            }
            .img__text.m--in {
                -webkit-transform: translateX(-520px);
                transform: translateX(-520px);
            }
            .cont.s--signup .img__text.m--in {
                -webkit-transform: translateX(0);
                transform: translateX(0);
            }
            .img__btn {
                overflow: hidden;
                z-index: 2;
                position: relative;
                width: 100px;
                height: 36px;
                margin: 0 auto;
                background: transparent;
                color: #fff;
                text-transform: uppercase;
                font-size: 15px;
                cursor: pointer;
            }
            .img__btn:after {
                content: '';
                z-index: 2;
                position: absolute;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                border: 2px solid #fff;
                border-radius: 30px;
            }
            .img__btn span {
                position: absolute;
                left: 0;
                top: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                width: 100%;
                height: 100%;
                transition: -webkit-transform 1.2s;
                transition: transform 1.2s;
                transition: transform 1.2s, -webkit-transform 1.2s;
            }
            .img__btn span.m--in {
                -webkit-transform: translateY(-72px);
                transform: translateY(-72px);
            }
            .cont.s--signup .img__btn span.m--in {
                -webkit-transform: translateY(0);
                transform: translateY(0);
            }
            .cont.s--signup .img__btn span.m--up {
                -webkit-transform: translateY(72px);
                transform: translateY(72px);
            }

            h2 {
                width: 100%;
                font-size: 26px;
                text-align: center;
            }

            label {
                display: block;
                width: 260px;
                margin: 25px auto 0;
                text-align: center;
            }
            label span {
                font-size: 12px;
                color: #cfcfcf;
                text-transform: uppercase;
            }

            input {
                display: block;
                width: 100%;
                margin-top: 5px;
                padding-bottom: 5px;
                font-size: 16px;
                border-bottom: 1px solid rgba(0, 0, 0, 0.4);
                text-align: center;
            }

            .forgot-pass {
                margin-top: 15px;
                text-align: center;
                font-size: 12px;
                color: #cfcfcf;
            }

            .submit {
                margin-top: 40px;
                margin-bottom: 20px;
                background: #0a3c4d;
                text-transform: uppercase;
            }

            .fb-btn {
                border: 2px solid #d3dae9;
                color: #8fa1c7;
            }
            .fb-btn span {
                font-weight: bold;
                color: #455a81;
            }

            .sign-in {
                transition-timing-function: ease-out;
            }
            .cont.s--signup .sign-in {
                transition-timing-function: ease-in-out;
                transition-duration: 1.2s;
                -webkit-transform: translate3d(640px, 0, 0);
                transform: translate3d(640px, 0, 0);
            }

            .sign-up {
                -webkit-transform: translate3d(-900px, 0, 0);
                transform: translate3d(-900px, 0, 0);
            }
            .cont.s--signup .sign-up {
                -webkit-transform: translate3d(0, 0, 0);
                transform: translate3d(0, 0, 0);
            }

            .icon-link {
                position: absolute;
                left: 5px;
                bottom: 5px;
                width: 32px;
            }
            .icon-link img {
                width: 100%;
                vertical-align: top;
            }
            .icon-link--twitter {
                left: auto;
                right: 5px;
            }


            /*-------------------------------------*/
            .form.sign-up{
                padding-top: 10px;
            }
            .options{
                display: flex;
                justify-content: space-evenly;
                align-content: center;

            }
            .radioOption{
                display: flex;
                justify-content: space-evenly;
                white-space: nowrap;
                font-size: 25px;

                align-items: center;
            }
            input.chooseOne{
                width: 20%;
            }

            .oneRow{
                display: flex;
                justify-content: space-evenly;
            }

            .customLabel{
                display: flex;
                align-items: center;
                font-weight: 300;

            }
            .forggoternPassword{
                width: 100%;
                /* font-size: 26px; */
                display: block;
                text-align: center;
            }

        </style>
    </head>
    <body>
        <!--<div class="login-form">
        <c:if test="${param.error !=null}">
            <div class="alert alert-danger">
                <i>Invalid username/password</i>
            </div>
        </c:if>
        <c:if test="${param.logout !=null}">
            <div class="alert alert-success">
                <i>Logout succesfully</i>
            </div>
        </c:if>
        <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
            <h2 class="text-center">Log in</h2>       
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Username" name="username" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" name="password" required="required">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Log in</button>
            </div>
            
        </form:form>
        
    </div>
        -->


        <!--Custom Login Form-->

        <div class="cont">
            <div class="form sign-in">
                <h2>Welcome back,</h2>
                <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
                    <h2 class="text-center">Log in</h2>       
                    <label>
                        <span>Username</span>
                        <input type="text"  name="username" required="required">
                    </label>
                    <label>
                        <span>Password</span>
                        <input type="password" name="password" required="required">
                    </label>
                    <div class="form-group">
                        <!--<button type="submit" class="btn btn-primary btn-block">Log in</button>-->
                        <button type="submit" class="submit">Sign In</button>
                    </div>

                </form:form >
                <div class="forggoternPassword">
                    <a href="${pageContext.request.contextPath}/forgotten-password">Forgotten Password</a>
                </div>
            </div>
            <div class="sub-cont">
                <div class="img">
                    <div class="img__text m--up">
                        <h2>New here?</h2>
                        <p>Sign up and discover great amount of new opportunities!</p>
                    </div>
                    <div class="img__text m--in">
                        <h2>One of us?</h2>
                        <p>If you already has an account, just sign in. We've missed you!</p>
                    </div>
                    <div class="img__btn">
                        <span class="m--up">Sign Up</span>
                        <span class="m--in">Sign In</span>
                    </div>
                </div>
                <div class="form sign-up">
                    <!--                    <h2>Time to feel like home,</h2>
                                        <label>
                                            <span>Name</span>
                                            <input type="text" />
                                        </label>
                                        <label>
                                            <span>Email</span>
                                            <input type="email" />
                                        </label>
                                        <label>
                                            <span>Password</span>
                                            <input type="password" />
                                        </label>
                                        <button type="button" class="submit">Sign Up</button>-->
                    <!--Sign up-->
                    <div class="options">
                        <div class="radioOption">
                            <label class="customLabel" style="white-space: nowrap;">
                                <input type="radio" name="choose-one" value="ProClient" checked required class="chooseOne  "
                                       id="choose-one">Pro Client
                            </label>
                        </div>
                        <div class="radioOption">
                            <label class="customLabel" >
                                <input type="radio" name="choose-one" value="RetailClient" required class="chooseOne required"
                                       id="choose-one">Retail Client
                            </label>
                        </div>
                    </div>

                    <form:form method="post" action="${pageContext.request.contextPath}/newProClient" modelAttribute="proClient">
                        <div class="oneRow">
                            <div class="resultDetail proClient">
                                <label for="username"><span>Username</span>
                                    <form:input type="text"  path="username"/>
                                </label>
                            </div>
                            <div class="resultDetail proClient">
                                <label for="password"><span>Password</span>
                                    <form:input type="password" path="password"/>
                                </label>
                            </div>
                        </div>
                        <div class="resultDetail proClient">

                            <form:input type="hidden" class="form-control" path="clientId" value="0"/>

                        </div>
                        <div class="oneRow">
                            <div class="resultDetail proClient">
                                <label for="proafm"><span>Company AFM</span>
                                    <form:input type="text"  path="proafm"/>
                                    <%--<form:errors path="proafm" cssClass="error"/>--%>
                                </label>
                            </div>
                            <div class="resultDetail proClient">
                                <label for="companyName"><span>Company Name</span>
                                    <form:input type="text"  path="companyName"/>
                                    <form:errors path="companyName" cssClass="error"/>
                                </label>
                            </div>
                        </div>
                        <div class="oneRow">
                            <div class="resultDetail proClient">
                                <label for="phone"><span>Phone</span>
                                    <form:input type="text" path="phone"/>
                                    <form:errors path="phone" cssClass="error"/>
                                </label>
                            </div>
                            <div class="resultDetail proClient">
                                <label for="address"><span>Address</span>
                                    <form:input type="text"  path="address"/>
                                    <form:errors path="address" cssClass="error"/>
                                </label>
                            </div>
                        </div>
                        <div class="oneRow">
                            <div class="resultDetail proClient">
                                <label for="email"><span>Email</span>
                                    <form:input type="text"  path="email"/>
                                    <form:errors path="email" cssClass="error"/>
                                </label>
                            </div>
                        </div>
                        <div class="oneRow">

                            <div class="resultDetail proClient">
                                <label for="companyName"><span>Security Question</span>
                                    <form:input type="text"  path="question"/>
                                    <form:errors path="question" cssClass="error"/>
                                </label>
                            </div>
                            <div class="resultDetail proClient">
                                <label for="companyName"><span>Security Answer</span>
                                    <form:input type="text"  path="answer"/>
                                    <form:errors path="answer" cssClass="error"/>
                                </label>
                            </div>
                        </div>
                        <button type="submit" class="submit resultDetail proClient">Sign Up</button>

                        <!--<button type="submit" class="btn btn-primary resultDetail proClient">Create</button>-->
                    </form:form>

                    <form:form method="post" action='${pageContext.request.contextPath}/newRetailClient' modelAttribute="retailClient">
                        <div class="oneRow">
                            <div class="resultDetail retailClient">
                                <label for="username"><span>Username</span>
                                    <form:input type="text"  path="username"/>
                                </label>
                            </div>
                            <div class="resultDetail retailClient">
                                <label for="password"><span>Password</span>
                                    <form:input type="password"  path="password"/>
                                </label>
                            </div>
                        </div>
                        <div class="resultDetail retailClient">

                            <form:input type="hidden"  path="clientId" value="1"/>

                        </div>

                        <div class="oneRow">

                            <div class="resultDetail retailClient">
                                <label for="firstname"><span>First Name</span>
                                    <form:input type="text"  path="firstname"/>
                                </label>
                            </div>
                            <div class="resultDetail retailClient">
                                <label for="lastname"><span>Last name</span>
                                    <form:input type="text" path="lastname"/>
                                </label>
                            </div>
                        </div>
                        <div class="oneRow">
                            <div class="resultDetail retailClient">
                                <label for="retailAfm"><span>AFM</span>
                                    <form:input type="text"  path="retailAfm"/>
                                </label>
                            </div>
                            <div class="resultDetail retailClient">
                                <label for="phone"><span>Phone</span>
                                    <form:input type="text"  path="phone"/>
                                </label>
                            </div>
                        </div>
                        <div class="oneRow">
                            <div class="resultDetail retailClient">
                                <label for="address"><span>Address</span>
                                    <form:input type="text"  path="address"/>
                                </label>
                            </div>
                            <div class="resultDetail retailClient">
                                <label><span>Email</span>
                                    <form:input type="text" path="email"/>
                                </label>
                            </div>
                        </div>
                        <div class="oneRow">
                            <div class="resultDetail retailClient">
                                <label for="companyName"><span>Security Question</span>
                                    <form:input type="text" path="question"/>
                                    <form:errors path="question" cssClass="error"/>
                                </label>
                            </div>
                            <div class="resultDetail retailClient">
                                <label for="companyName"><span>Security Answer</span>
                                    <form:input type="text" path="answer"/>
                                    <form:errors path="answer" cssClass="error"/>
                                </label>
                            </div>
                        </div>
                        <button type="submit" class="submit resultDetail retailClient">Sign Up</button>
                    </form:form>

                </div>
            </div>
        </div>
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

        <script>
            document.querySelector('.img__btn').addEventListener('click', function () {
                document.querySelector('.cont').classList.toggle('s--signup');
            });
        </script>
    </body>
</html>                 