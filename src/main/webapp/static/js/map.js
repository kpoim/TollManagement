window.olMap = null;
const vectorSource = new ol.source.Vector();
const vectorLayer = new ol.layer.Vector({
    source: vectorSource
});
const styles = {
    route: new ol.style.Style({
        stroke: new ol.style.Stroke({
            width: 6, color: [0, 0, 0, 1]
        })
    })
};

function createMap(geometry) {
    console.log(geometry);
    if (geometry[0] === "\"")
        geometry = JSON.parse(geometry);
    if (!geometry)
        createRoute(osrmJSON.routes[0].geometry);
    else
        createRoute(geometry);
    window.olMap = new ol.Map({
        target: 'map',
        layers: [
            new ol.layer.Tile({
                source: new ol.source.OSM()
            }),
            vectorLayer
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([
                22.9959129, 39.1162255
            ]),
            zoom: 8
        })
    });

}

function createLongLatStringForRoute(coords) {
    return coords.entry.longitude + "," + coords.entry.latitude + ";" + coords.exit.longitude + "," + coords.exit.latitude;
}

//COORDS: 
//    THIVA: 23.3216443, 38.365156
//    LAMIA: 22.4570683, 38.868296
//const thivaPoints = [23.3216443, 38.365156];
//const lamiaPoints = [22.4570683, 38.868296];
//const points = [thivaPoints, lamiaPoints];
//const url = "http://router.project-osrm.org/route/v1/driving/" + thivaPoints.join(",") + ";" + lamiaPoints.join(",");
const osrmJSON = {"routes": [{"geometry": "qddiFk_jmCetA|bMwy@t\\}wC`bEyuBoiB}k@vDqeArlCcn@rcGkmHjEkoCgk@iuBjUsfAs|BwoCikBaeAzq@{m@~kBubBmIr\\f`BglA`uJeaA`wBc`FhaCipGx}@imCvlBcDn_GgmA~pI~CdjDab@t{Chy@p`Dq\\z_B_sAh`AqgA~qE`UdpCkh@nnCgD~gHavBxkH{PlxBuhAbrB`_AdmGhFbeFra@buBqKzaBmd@j~@}hKjmG", "legs": [{"summary": "", "weight": 4231.4, "duration": 4125.3, "steps": [], "distance": 122691.6}], "weight_name": "routability", "weight": 4231.4, "duration": 4125.3, "distance": 122691.6}], "waypoints": [{"hint": "RdC0gv___38rAAAAcwAAAAAAAACXBAAAlQIPQ-Ps6EEAAAAA0B_TRCsAAAA5AAAAAAAAAEsCAADYpQAAO9xjAXxnSQIs3GMB5GdJAgAAfxAhOdt7", "distance": 11.618311172161087, "name": "Αθήνα - Θεσσαλονίκη - Εύζωνοι", "location": [23.321659, 38.365052]}, {"hint": "ahW0grIVtIISAAAAEwAAAIYAAADBAAAAdhxhQTGZbUGudNBCh7MVQxIAAAATAAAAhgAAAMEAAADYpQAA7KpWAUsVUQLsqlYBSBVRAgIAvxAhOdt7", "distance": 0.33303268457340557, "name": "", "location": [22.457068, 38.868299]}], "code": "Ok"};


function createRoute(polyline) {
    console.log(polyline);
    var route = new ol.format.Polyline({
        factor: 1e5
    }).readGeometry(polyline, {
        dataProjection: 'EPSG:4326',
        featureProjection: 'EPSG:3857'
    });
    var feature = new ol.Feature({
        type: 'route',
        geometry: route
    });
    feature.setStyle(styles.route);
    vectorSource.addFeature(feature);
}
