<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}" />
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR 404</title>
        <link rel="stylesheet" href="${path}/static/css/emp-style.css">
        <link rel="stylesheet" href="${path}/static/css/homepage-css.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.1.1/css/ol.css" type="text/css">
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
        <script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.1.1/build/ol.js"></script>
        <script src="${path}/static/js/map.js"></script>
    </head>
    <body>

        <%@include file="../misc/navbars/nav-terminal.jsp" %>
        <section class="main-container">
            <div class="content" style="justify-content: center; margin: 0;">
                <div style="width:100%; height: 70vh;" id="content">


                    <c:choose>
                        <c:when test="${employeePresent == false}">
                            <h2>This Gate is currently closed.</h2>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${gateIsExit == null}">
                                    <c:choose>
                                        <c:when test="${history == null}">
                                            <h2>Welcome to the highway!!</h2>
                                        </c:when>
                                        <c:otherwise>
                                            <script>
            const coords = {
                entry: {
                    latitude:${entrylat},
                    longitude: ${entrylong}
                },
                exit: {
                    latitude:${exitlat},
                    longitude: ${exitlong}
                }
            };
            const url = "http://127.0.0.1:5000/route/v1/driving/" + createLongLatStringForRoute(coords);
            fetch(url)
                    .then(res => res.json())
                    .then(data => {
                        createMap(data.routes[0].geometry);
                        fetch(contextPath + "/terminal-api/store-geometry/${history.id}", {
                            method: 'POST',
                            headers: {
                                'Content-Type': 'application/json; charset=UTF-8'
                            },
                            body: JSON.stringify(data.routes[0].geometry)
                        });
                    })
                    .catch(err => console.error(err));
                                            </script>
                                            <h3>Here is your route</h3>
                                        </c:otherwise>
                                    </c:choose>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${gateIsExit == false}">
                                            <h2>This is an entry gate. You can't exit.</h2>
                                        </c:when>
                                        <c:otherwise>
                                            <h2>This is an exit gate. You can't enter.</h2>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                    <script>
                            const redirectToURL = window.location.origin + "/terminal";
                            setTimeout(() => {
                                window.location.replace(redirectToURL);
                            }, 10000);
                    </script>
                    <div style="width:100%; height: 50vh;" id="map"></div>
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
    </body>
</html>

