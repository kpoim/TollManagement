<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>New Admin</title>

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
                height: 100%;              
                padding: 50px 30px 0;
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

            

/*            .sign-in {
                transition-timing-function: ease-out;
            }*/
           

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

            /*progress Bar*/
            .container {
                width: 100%;
            }

            .progressbar {
                counter-reset: step;
            }
            .progressbar li {
                list-style: none;
                display: inline-block;
                width: 24.5%;
                position: relative;
                text-align: center;
                /*cursor: pointer;*/
            }
            .progressbar li:before {
                content: counter(step);
                counter-increment: step;
                width: 30px;
                height: 30px;
                line-height : 30px;
                border: 1px solid #ddd;
                border-radius: 100%;
                display: block;
                text-align: center;
                margin: 0 auto 10px auto;
                background-color: #fff;
            }
            .progressbar li:after {
                content: "";
                position: absolute;
                width: 100%;
                height: 1px;
                background-color: #ddd;
                top: 15px;
                left: -50%;
                z-index : -1;
            }
            .progressbar li:first-child:after {
                content: none;
            }
            .progressbar li.active {
                color: green;
            }
            .progressbar li.active:before {
                border-color: green;
            } 
            .progressbar li.active + li:after {
                background-color: green;
            }
        </style>
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

        <!--        <section style="margin-top: 100px;">
                    <div class="container  pt-3 pb-3 pl-5 pr-5 shadow extra-margin" style="box-sizing: border-box;">
                        <div class="row">
                            <div class="col-12 p-4 border border-dark bg-light shadow">
                                <h2>Forgotten Password</h2>
        
        
        <form:form id="validate">
            Give Username
            <input type="text" class="givenUsername" />
            <button id="validateButton" onclick="Validate()" >Submit </button>
        </form:form>
        <div class="correctUsernameButtonPlace"></div>

    </div>

</div>
</div>
</section>-->
        <div class="cont">
            <div class="form ">
                <h2>Forgotten Password</h2>
                <form:form id="validate">

                    <label>
                        <span>Give Username</span>
                        <input type="text" class="givenUsername" />
                    </label>
                    <div >

                        <button  id="validateButton" class="submit" onclick="Validate()">Submit</button>
                    </div>

                </form:form >
                <div class="correctUsernameButtonPlace"></div>
                <div class="container">
                    <ul class="progressbar">
                        <li class="active">Step 1</li>
                        <li>Step 2</li>
                        <li>Step 3</li>
                        <li>Step 4</li>
                    </ul>
                </div>
            </div>

        </div>


        <script>
            let data = [];
            //const correctUsernameBtn = document.querySelector("#correctUsername");

            function fetchClients() {
                const url = `${pageContext.request.contextPath}/employee-api/get-username`;
                fetch(url, {cors: 'no-cors'})
                        .then(res => res.json())
                        .then(res => {
                            console.log(res);
                            console.log("aaaaa");
                            data = res;
                        });
            }
            ;
            fetchClients();

            function Validate() {
                const counter = 0;
                const givenUsername = document.querySelector(".givenUsername").value;
                data.forEach(function (username) {
                    //                    console.log(username);
                    //                    console.log(givenUsername);
                    if (username === givenUsername) {
                        
                        console.log("CORRECT");
                        const div = document.querySelector(".correctUsernameButtonPlace");
                        console.log(div.childNodes.length);
                        if (div.childNodes.length === 0) {

                            const correctUsernameBtn = document.createElement("button");
                            const formForButton = document.createElement("form");
                            formForButton.setAttribute("action", "${pageContext.request.contextPath}/change-password-form/" + username);
                            formForButton.setAttribute("class", "submit");
                            const textForButton = document.createTextNode("Security Question");
                            formForButton.appendChild(correctUsernameBtn);
                            correctUsernameBtn.appendChild(textForButton);

                            div.appendChild(formForButton);
                            //                            preventDefaultForButton();

                        }
                    }
                });

            }
            ;
            document.querySelector("#validateButton").addEventListener("click", function (event) {
                event.preventDefault();

            });
            //            function preventDefaultForButton() {
            //
            //                correctUsernameBtn.addEventListener("click", function (event) {
            //                    event.preventDefault();
            //                    
            //                });
            //            }
            ;

            function goToSecurityQuestion() {

            }
        </script>
    </body>
</html>
