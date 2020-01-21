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
        <title>Donation</title>
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <style>
            .sub-content {
                background-image: url(/static/images/donation/charity-banner.jpg);
            }

        </style>
    </head>
    <body>
        <script
            src="https://www.paypal.com/sdk/js?client-id=AWk0x1CD9HuHlrUjGIlQtoTef_TiVP0WZh9DlPb8EgOh8BBe4gIrH8th7Lv2Batwf1bE-YiPc0Nu_6uD"> // Required. Replace SB_CLIENT_ID with your sandbox client ID.
        </script>
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

        <security:authorize access="hasRole('CLIENT')">
            <%@include file="./navbars/nav-client.jsp" %>
        </security:authorize>
        <security:authorize access="(!(hasAnyRole('ADMIN','CLIENT', 'EMPLOYEE' , 'TERMINAL')))">
            <%@include file="./navbars/nav-general.jsp" %>
        </security:authorize>

        <section class="main-container">
            <div class="content">
                <!--<h1>Header</h1>--><img src="/static/images/donation/hamogelo-tou-paidiou.png">
                <div class="form sign-in">
                    <h4 class="text-center">Στηρίξτε κι εσείς «Το Χαμόγελο του Παιδιού», από την Ελλάδα και το εξωτερικό</h4>
                    
                        <p class="text-justify">Το Χαμόγελο του παιδιού είναι εθελοντικός, μη κερδοσκοπικός οργανισμός που λειτουργεί 
                            στην Ελλάδα, με στόχο την προάσπιση των δικαιωμάτων των παιδιών και την αντιμετώπιση 
                            καθημερινών προβλημάτων τους. Η δράση του περιλαμβάνει μεταξύ άλλων τη φιλοξενία παιδιών 
                            που βρίσκονται σε κίνδυνο, την τηλεφωνική υποστήριξή τους, προγράμματα συμβουλευτικής και 
                            κοινωνικής ένταξής του, την ενίσχυση οικογενειών που τελούν σε ένδεια, καθώς και τη διοργάνωση 
                            εκστρατειών ενημέρωσης ή πολιτιστικών και αθλητικών εκδηλώσεων.</p>
                        <label style="width:100%;">
                            <span >Amount for Donation</span>
                            <input type="number"  name="amount" id="value" required="required" value="1" min="1">
                        </label>
                        <!--<label for="value" class="col-sm-8 col-form-label">Amount for Donation</label>-->
                        <div class="form-group">
                            <!--<button type="submit" class="btn btn-primary btn-block">Log in</button>-->
                            <!--                            <button type="submit" class="submit submit-button">Sign In</button>-->
                            <div  id="paypal-button-container"></div>
                            <div id="successDonation" style="color:green;">
                                
                            </div>
                        </div>
                        
                    
                </div>
            </div>
            <div class="sub-content">
                <div class="side-shadow">
                    <div class="img-text">
                        <!--                        <h2>ATC</h2>
                                                <p>Awesome Toll Company</p>-->
                    </div>
                </div>
            </div>
        </section>
        <%@include file="./../misc/footer.jsp" %>


        <script>
            
            let value = document.querySelector("#value").value;
            console.log(value);
            let payButton = document.querySelector("#paypal-button-container");
            payButton.onclick = function () {
                value = document.querySelector("#value").value;
                console.log(value);
            };

            paypal.Buttons({
                createOrder: function (data, actions) {
                    let value1 = document.querySelector("#value").value;
                    console.log(value);
                    let selectedCurrency = $('input[name=gridRadios]:checked').val();
                    return actions.order.create({
                        purchase_units: [{
                                amount: {
                                    value: value1,
                                    "currency": "EUR"
                                }
                            }]
                    });
                },
                onApprove: function (data, actions) {
                    return actions.order.capture().then(function (details) {
                        
                        document.querySelector("#successDonation").innerHTML=('Transaction completed by ' + details.payer.name.given_name);
                        //alert('Transaction completed by ' + details.payer.name.given_name);
                        //console.log(details);
                        // Call your server to save the transaction
//                        return fetch('/paypal-transaction-complete', {
//                            method: 'post',
//                            headers: {
//                                'content-type': 'application/json'
//                            },
//                            body: JSON.stringify({
//                                orderID: data.orderID
//                            })
//
//                        });
                    });
                }
            }).render('#paypal-button-container');
        </script>
    </body>
