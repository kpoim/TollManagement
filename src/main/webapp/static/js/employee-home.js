function initialize(e) {
    getVehicles();
    document.querySelector("#pay-button").addEventListener("click", payAndReset);
    const val = e.target.selectedOptions[0].text;
    document.querySelector(".content h2").remove();
    const gateNo = val.split(" - ")[1];
    document.querySelector("#gate-no").innerText += gateNo;
    const gateId = e.target.value;
    showMainContainer();
    startEmployeeShift(gateId);
    console.log(`--> LISTENING ON GATE ${gateId}`);
    window.onbeforeunload = (e) => logoutAndRemoveFromGate(e, gateId);
}

function payAndReset(e) {
    e.preventDefault();
    console.log(window.historyId);
    const price = parseFloat(document.querySelector("#amount").value);
    const vehicle = document.querySelectorAll("input[name=gridRadios]:checked")[0].id;
    const url = `${contextPath}/employee-api/pay/history/${window.historyId}/price/${price}/vehicle/${vehicle}`;
    fetch(url)
            .then(res => res.text())
            .then(res => {
                console.log(res);
                document.querySelector(".payment-details").style.display = "none";
            })
            .catch(err => console.error(err));
}

function getPrice(e) {
    console.log(e.target.id);
    console.log("HISTORY: " + window.historyId);
    fetch(`${contextPath}/employee-api/get-price-for-history-id/${window.historyId}/vehicle/${e.target.id}`)
            .then(res => res.text())
            .then(val => {
                document.querySelector("#amount").value = val;
            })
            .catch(err => console.log(err));

}

function getVehicles() {
    fetch(`${contextPath}/employee-api/get-vehicle-types`)
            .then(res => res.json())
            .then(data => {
                const vehiclesContainer = document.querySelector("#vehicles");
                data.forEach(vehicle => {
                    const container = document.createElement("div");
                    container.classList.add("radio-container");
                    const input = document.createElement("input");
                    input.setAttribute("type", "radio");
                    input.setAttribute("name", "gridRadios");
                    input.setAttribute("id", vehicle);
                    input.setAttribute("required", "true");
                    input.addEventListener("click", getPrice);
                    const label = document.createElement("label");
                    label.setAttribute("for", vehicle);
                    label.innerText = vehicle;
                    container.appendChild(input);
                    container.appendChild(label);
                    vehiclesContainer.appendChild(container);
                });
            })
            .catch(err => console.log(err));
}

function logoutAndRemoveFromGate(e, gateId) {
    e.preventDefault();
    fetch(`${contextPath}/employee-api/remove-from-gate/${gateId}`);
    fetch(`${contextPath}/logout`, {method: "post"});
}

function fetchData() {
    const url = `${contextPath}/employee-api/get-roads`;
    fetch(url, {cors: 'no-cors'})
            .then(res => res.json())
            .then(res => {
                console.log(res);
                createRoadsSelect(res);
            });
}

function createRoadsSelect(res) {
    const roadsDiv = document.querySelector(".road-option");
    const label = document.createElement("label");
    label.setAttribute("for", "roads");
    label.innerText = "Choose the road:";
    const roads = document.createElement("select");
    roads.setAttribute("id", "roads");
    roads.setAttribute("name", "roads");
    roads.addEventListener("change", e => createStationsSelect(e, res));
    let option = document.createElement("option");
    option.setAttribute("value", "");
    option.innerText = "choose a road...";
    roads.appendChild(option);
    res.forEach(road => {
        option = document.createElement("option");
        option.setAttribute("value", road.id);
        option.innerText = `${road.id} - ${road.roadName}`;
        roads.appendChild(option);
    });
    roadsDiv.appendChild(label);
    roadsDiv.appendChild(roads);
}

function createStationsSelect(e, res) {
    console.log(e);
    console.log(res[e.target.value - 1]);
    const stationsData = res[e.target.value - 1].stations;
    const stationsDiv = document.querySelector(".station-option");
    const label = document.createElement("label");
    label.setAttribute("for", "stations");
    label.innerText = "Choose the station:";
    const stations = document.createElement("select");
    stations.setAttribute("id", "stations");
    stations.setAttribute("name", "stations");
    stations.addEventListener("change", e => createGatesSelect(e, stationsData));
    let option = document.createElement("option");
    option.setAttribute("value", "");
    option.innerText = "choose a station...";
    stations.appendChild(option);
    stationsData.forEach(station => {
        option = document.createElement("option");
        option.setAttribute("value", station.id);
        option.innerText = `${station.id} - ${station.stationName}`;
        stations.appendChild(option);
    });
    stationsDiv.innerHTML = "";
    stationsDiv.appendChild(label);
    stationsDiv.appendChild(stations);
}

function createGatesSelect(e, res) {
    console.log(e);
    const val = e.target.selectedOptions[0].text;
    const stationName = val.split(" - ")[1];
    document.querySelector("#station-name").innerText = `Station: ${stationName}`;
    const value = e.target.value;
    if (value === "")
        return;
//    const url = `${contextPath}/employee-api/get-gates/entry/by-station/${value}`;
//    fetch(url, {cors: 'no-cors'})
//            .then(res => res.json())
//            .then(res => {
    console.log(res);
    console.log(value);
    let gateData = [];
    res.some((gate, idx) => gate.id == value && (gateData = gate));
    console.log(gateData);
    let gates = document.querySelector("#gates");
    if (!gates) {
        const gatesDiv = document.querySelector(".gate-option");
        const label = document.createElement("label");
        label.setAttribute("for", "gates");
        label.innerText = "Choose the gate:";
        gates = document.createElement("select");
        gates.setAttribute("name", "gates");
        gates.setAttribute("id", "gates");
        gates.addEventListener("change", initialize);
        gatesDiv.appendChild(label);
        gatesDiv.appendChild(gates);
    }
    while (gates.lastChild)
        gates.lastChild.remove();
    let option = document.createElement("option");
    option.setAttribute("value", "");
    option.innerText = "choose a gate...";
    gates.appendChild(option);
    gateData.gates.forEach(gate => {
        if (!gate.isEntry) {
            option = document.createElement("option");
            option.setAttribute("value", gate.id);
            option.innerText = `${gate.id} - ${gate.gateNo}`;
            gates.appendChild(option);
        }
    });
//            });
}

function showMainContainer() {
    const stationGatePicker = document.querySelector(".stationGate");
    stationGatePicker.remove();
    const mainContainer = document.querySelector(".emp-container");
    mainContainer.style.display = "block";
}

function listenForSSE(gateId) {
    const eventSource = new EventSource(`${contextPath}/notification/${gateId}`);
    eventSource.onmessage = e => {
//        console.log("data",e);
        const history = JSON.parse(e.data);
        document.querySelector("#idholder").value = history.cardid;
        console.log(history);
        window.historyId = history.id;
        document.querySelector(".payment-details").style.display = "block";
    };
    eventSource.onopen = e => console.log('open');
    eventSource.onerror = e => {
        if (e.readyState == EventSource.CLOSED) {
            console.log('close');
        } else {
            console.log(e);
        }
    };
    eventSource.addEventListener('second', function (e) {
        console.log('second', e.data);
    }, false);
}

function startEmployeeShift(gateId) {
    const url = `${contextPath}/employee-api/add-to-gate/${gateId}`;
    fetch(url, {cors: 'no-cors'})
            .then(res => res.text())
            .then(res => res && listenForSSE(gateId));
}

window.onload = fetchData;