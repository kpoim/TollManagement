
function initialize(e) {
    const gateId = e.target.value;
    showMainContainer();
    startEmployeeShift(gateId);
}

function fetchStations() {
    const url = `${contextPath}/employee-api/get-stations`;
    fetch(url, {cors: 'no-cors'})
            .then(res => res.json())
            .then(res => {
                console.log(res);
                const stationsDiv = document.querySelector(".station-option");
                const label = document.createElement("label");
                label.setAttribute("for", "stations");
                label.innerText = "Choose the station:";
                const stations = document.createElement("select");
                stations.setAttribute("id", "stations");
                stations.setAttribute("name", "stations");
                stations.addEventListener("change", fetchGatesByStationId);
                let option = document.createElement("option");
                option.setAttribute("value", "");
                option.innerText = "choose a station...";
                stations.appendChild(option);
                res.forEach(station => {
                    option = document.createElement("option");
                    option.setAttribute("value", station.id);
                    option.innerText = `${station.id} - ${station.stationName}`;
                    stations.appendChild(option);
                });
                stationsDiv.appendChild(label);
                stationsDiv.appendChild(stations);
            });
}

function fetchGatesByStationId(e) {
    const value = e.target.value;
    if(value === "") return;
    const url = `${contextPath}/employee-api/get-gates/entry/by-station/${value}`;
    fetch(url, {cors: 'no-cors'})
            .then(res => res.json())
            .then(res => {
                console.log(res);
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
                res.forEach(gate => {
                    option = document.createElement("option");
                    option.setAttribute("value", gate.id);
                    option.innerText = `${gate.id} - ${gate.gateNo}`;
                    gates.appendChild(option);
                });
            });
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
        const msg = e.data;
        document.getElementById("data").innerHTML = msg;
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

function startEmployeeShift(gateId){
    const url = `${contextPath}/employee-api/add-to-gate/${gateId}`;
    fetch(url,{cors:'no-cors'})
            .then(res => res.text())
            .then(res => res && listenForSSE(gateId));
}

window.onload = fetchStations;