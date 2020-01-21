<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:set var="path" value="${pageContext.request.contextPath}" />
        <script>const contextPath = "${pageContext.request.contextPath}";</script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.1.1/css/ol.css" type="text/css">
        <title>Document</title>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/gh/openlayers/openlayers.github.io@master/en/v6.1.1/build/ol.js"></script>
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
        <%@include file="../misc/navbars/nav-client.jsp" %>
        <h1>RETAIL CLIENT</h1>
        <section style="margin-top: 100px;">
            <div class="container  pt-3 pb-3 pl-5 pr-5 shadow extra-margin" style="box-sizing: border-box;">
                <div style="width:100%; height: 50vh;" id="map">
                    <!--<iframe width="600" height="450" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyAbR4kXi8uF3pSRYE4ULKA52LFxNUgNtbM&origin=Oslo+Norway&destination=Telemark+Norway" allowfullscreen></iframe>-->

                </div>
            </div>
        </section>
        <script src="${path}/static/js/map.js"></script>
        <script>
//            const vectorSource = new ol.source.Vector();
//            const vectorLayer = new ol.layer.Vector({
//                source: vectorSource
//            });
//            const styles = {
//                route: new ol.style.Style({
//                    stroke: new ol.style.Stroke({
//                        width: 6, color: [0, 0, 0, 1]
//                    })
//                })
//            };
//            function success() {
//                createRoute(osrmJSON.routes[0].geometry);
//                const map = new ol.Map({
//                    target: 'map',
//                    layers: [
//                        new ol.layer.Tile({
//                            source: new ol.source.OSM()
//                        }),
//                        vectorLayer
//                    ],
//                    view: new ol.View({
//                        center: ol.proj.fromLonLat([
//                            22.9959129, 39.1162255
//                        ]),
//                        zoom: 8
//                    })
//                });
//                
//            }
//
//
////COORDS: 
////    THIVA: 23.3216443, 38.365156
////    LAMIA: 22.4570683, 38.868296
//            const thivaPoints = [23.3216443, 38.365156];
//            const lamiaPoints = [22.4570683, 38.868296];
//            const points = [thivaPoints, lamiaPoints];
//            const url = "http://router.project-osrm.org/route/v1/driving/" + thivaPoints.join(",") + ";" + lamiaPoints.join(",");
//            const osrmJSON = {"routes": [{"geometry": "qddiFk_jmCetA|bMwy@t\\}wC`bEyuBoiB}k@vDqeArlCcn@rcGkmHjEkoCgk@iuBjUsfAs|BwoCikBaeAzq@{m@~kBubBmIr\\f`BglA`uJeaA`wBc`FhaCipGx}@imCvlBcDn_GgmA~pI~CdjDab@t{Chy@p`Dq\\z_B_sAh`AqgA~qE`UdpCkh@nnCgD~gHavBxkH{PlxBuhAbrB`_AdmGhFbeFra@buBqKzaBmd@j~@}hKjmG", "legs": [{"summary": "", "weight": 4231.4, "duration": 4125.3, "steps": [], "distance": 122691.6}], "weight_name": "routability", "weight": 4231.4, "duration": 4125.3, "distance": 122691.6}], "waypoints": [{"hint": "RdC0gv___38rAAAAcwAAAAAAAACXBAAAlQIPQ-Ps6EEAAAAA0B_TRCsAAAA5AAAAAAAAAEsCAADYpQAAO9xjAXxnSQIs3GMB5GdJAgAAfxAhOdt7", "distance": 11.618311172161087, "name": "Αθήνα - Θεσσαλονίκη - Εύζωνοι", "location": [23.321659, 38.365052]}, {"hint": "ahW0grIVtIISAAAAEwAAAIYAAADBAAAAdhxhQTGZbUGudNBCh7MVQxIAAAATAAAAhgAAAMEAAADYpQAA7KpWAUsVUQLsqlYBSBVRAgIAvxAhOdt7", "distance": 0.33303268457340557, "name": "", "location": [22.457068, 38.868299]}], "code": "Ok"};
//
//
//            function createRoute(polyline) {
//                var route = new ol.format.Polyline({
//                    factor: 1e5
//                }).readGeometry(polyline, {
//                    dataProjection: 'EPSG:4326',
//                    featureProjection: 'EPSG:3857'
//                });
//                var feature = new ol.Feature({
//                    type: 'route',
//                    geometry: route
//                });
//                feature.setStyle(styles.route);
//                vectorSource.addFeature(feature);
//            }
            
//            var utils = {
//                getNearest: function (coord) {
//                    var coord4326 = utils.to4326(coord);
//                    return new Promise(function (resolve, reject) {
//                        //make sure the coord is on street
//                        fetch(url_osrm_nearest + coord4326.join()).then(function (response) {
//                            // Convert to JSON
//                            return response.json();
//                        }).then(function (json) {
//                            if (json.code === 'Ok')
//                                resolve(json.waypoints[0].location);
//                            else
//                                reject();
//                        });
//                    });
//                },
//                createFeature: function (coord) {
//                    var feature = new ol.Feature({
//                        type: 'place',
//                        geometry: new ol.geom.Point(ol.proj.fromLonLat(coord))
//                    });
//                    feature.setStyle(styles.icon);
//                    vectorSource.addFeature(feature);
//                },
//                to4326: function (coord) {
//                    return ol.proj.transform([
//                        parseFloat(coord[0]), parseFloat(coord[1])
//                    ], 'EPSG:3857', 'EPSG:4326');
//                }
//            };

            jQuery(createMap());

        </script>

    </body>

</html>