<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"> <!-- Ensures optimal rendering on mobile devices. -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge" /> <!-- Optimal Internet Explorer compatibility -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <title>Document</title>
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

        <security:authorize access="(!hasAnyRole('ADMIN','CLIENT', 'EMPLOYEE' , 'TERMINAL'))">
            <%@include file="./navbars/nav-template.jsp" %>
        </security:authorize>
        
        <security:authorize access="hasRole('CLIENT')">
            <%@include file="./navbars/nav-client.jsp" %>
        </security:authorize>
        
        
        

        
        <img src="${pageContext.request.contextPath}/static/images/donation/hamogelo-tou-paidiou.png" >
        <img src="${pageContext.request.contextPath}/static/images/donation/charity-banner.jpg" >
        <h2>Στηρίξτε κι εσείς «Το Χαμόγελο του Παιδιού», από την Ελλάδα και το εξωτερικό</h2>
        <p>Το Χαμόγελο του παιδιού είναι εθελοντικός, μη κερδοσκοπικός οργανισμός που λειτουργεί 
            στην Ελλάδα, με στόχο την προάσπιση των δικαιωμάτων των παιδιών και την αντιμετώπιση 
            καθημερινών προβλημάτων τους. Η δράση του περιλαμβάνει μεταξύ άλλων τη φιλοξενία παιδιών 
            που βρίσκονται σε κίνδυνο, την τηλεφωνική υποστήριξή τους, προγράμματα συμβουλευτικής και 
            κοινωνικής ένταξής του, την ενίσχυση οικογενειών που τελούν σε ένδεια, καθώς και τη διοργάνωση 
            εκστρατειών ενημέρωσης ή πολιτιστικών και αθλητικών εκδηλώσεων.</p>
        <label for="value" class="col-sm-8 col-form-label">Amount for Donation</label>
        <div class="col-sm-8 mb-4">
            <input type="number" class="form-control" id="value" name="amount" value="1" min="1" >
        </div>
        

        <div class="col-sm-8" id="paypal-button-container"></div>
        <span>
            paypal email <br>
            sb-eoduz871419@personal.example.com<br>
            password<br>
        !h}j_9PL
        </span>


        <!--  <script>
            paypal.Buttons().render('#paypal-button-container');
            // This function displays Smart Payment Buttons on your web page.
          </script>
          <script>
          paypal.Buttons({
            createOrder: function(data, actions) {
              // This function sets up the details of the transaction, including the amount and line item details.
              return actions.order.create({
                purchase_units: [{
                  amount: {
                    value: '0.01'
                  }
                }]
              });
            }
          }).render('#paypal-button-container');
        </script>
        <script>
          paypal.Buttons({
            createOrder: function(data, actions) {
              // This function sets up the details of the transaction, including the amount and line item details.
              return actions.order.create({
                purchase_units: [{
                  amount: {
                    value: '0.01'
                  }
                }]
              });
            },
            onApprove: function(data, actions) {
              // This function captures the funds from the transaction.
              return actions.order.capture().then(function(details) {
                // This function shows a transaction success message to your buyer.
                alert('Transaction completed by ' + details.payer.name.given_name);
              });
            }
          }).render('#paypal-button-container');
          //This function displays Smart Payment Buttons on your web page.
        </script>-->

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
                        alert('Transaction completed by ' + details.payer.name.given_name);
                        console.log(details);
                        // Call your server to save the transaction
                        return fetch('/paypal-transaction-complete', {
                            method: 'post',
                            headers: {
                                'content-type': 'application/json'
                            },
                            body: JSON.stringify({
                                orderID: data.orderID
                            })
                            
                        });
                    });
                }
            }).render('#paypal-button-container');
        </script>
    </body>
