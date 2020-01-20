<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR 500</title>
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

            .img__text.m--in {
                -webkit-transform: translateX(-520px);
                transform: translateX(-520px);
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
                align-items: center;
                display: flex;
                justify-content: center;
                flex-direction: column;
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
            p{
                margin-top:20px;
            }
            /*loader*/
            .loader {
                border: 16px solid #f3f3f3; /* Light grey */
                border-top: 16px solid #3498db; /* Blue */
                border-radius: 50%;
                width: 120px;
                height: 120px;
                animation: spin 2s linear infinite;
            }

            @keyframes spin {
                0% { transform: rotate(0deg); }
                100% { transform: rotate(360deg); }
            }

            .forLoader{
                display: flex;
                align-items: center;
                justify-content: space-evenly;
                margin: 40px;
            }

        </style>
    </head>
    <body>

        <div class="cont">
            <div class="form sign-in">
                <h1 style="color:red;">Error 500</h1>

                <a href="#" onclick="history.go(-1)">Go Back</a>

            </div>
            <div class="sub-cont">
                <div class="img">
                    <div class="img__text m--up">
                        <h2>ATC</h2>
                        <p>Awesome Toll Company</p>
                    </div>


                </div>
            </div>
<!--            <script>
                const redirectURL = "${pageContext.request.contextPath}/login";
                setTimeout("window.location.href= redirectURL;", 3000);
            </script>-->
    </body>
</html>
