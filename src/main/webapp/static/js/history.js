
function init() {
    const url = `${contextPath}/user-api/get-history`;
    fetch(url)
            .then(res => res.json())
            .then(data => {
// CHECK IF CLIENT HAS AT LEAST 1 CARD AND 1 HISTORY LOG
                if (data[0] && data[0].historyData[0]) {
                    populateFilters(data);
                    createTable(data);

                }
            }).catch(err => console.error(err));
}

function createTable(data) {
    const table = document.querySelector("#history-table");
    const tableHead = table.querySelector("thead");
    const tableBody = table.querySelector("tbody");
    tableHead.innerHTML = "";
    tableBody.innerHTML = "";
    // CREATE <thead>
    if (!data[0])
        return;
    const firstEntry = data[0].historyData[0];
    if (!firstEntry)
        return;
    Object.keys(firstEntry).forEach(key => {
        if (key === "geometry")
            return;
        const th = document.createElement("th");
        th.innerText = key;
        th.addEventListener("mouseover", toggleColumnShadow);
        th.addEventListener("mouseout", toggleColumnShadow);
        tableHead.appendChild(th);
        if (key === "entrygate" || key === "exitgate") {
            const th2 = document.createElement("th");
            th2.innerText = key === "entrygate" ? "entrystation" : "exitstation";
            th2.addEventListener("mouseover", toggleColumnShadow);
            th2.addEventListener("mouseout", toggleColumnShadow);
            tableHead.appendChild(th2);
        }

    });
// CREATE <tbody>
    data.forEach((card, cIndex) => {
        card.historyData.forEach((history, hIndex) => {
            const tr = document.createElement("tr");
            tr.setAttribute("id", `row-${cIndex}-${hIndex}`);
            tr.addEventListener("click", e => drawMap(e, history.geometry));
            Object.keys(history).forEach(key => {
                const td = document.createElement("td");
                if (key === "geometry")
                    return;
                if (key === "entrygate" || key === "exitgate")
                    td.innerText = history[key].id;
                else if (key === "entrytime" || key === "exittime") {
                    td.dataset.originalDate = history[key];
                    const arr = history[key].split("T");
                    const date = arr[0].split("-").reduceRight((acc, cur) => `${acc}/${cur}`, "").substr(1);
                    const time = arr[1].split(":");
                    const dateTime = `${date} ${time[0]}:${time[1]}`;
                    td.classList.add(key);
                    td.innerText = dateTime;
                } else if (key === "vehicle")
                    td.innerText = history[key].name;
                else
                    td.innerText = history[key];
                if(key === "cost")
                    td.classList.add("cost");
                td.addEventListener("mouseover", toggleColumnShadow);
                td.addEventListener("mouseout", toggleColumnShadow);
                tr.appendChild(td);
                if (key === "entrygate" || key === "exitgate") {
                    const td2 = document.createElement("td");
                    td2.addEventListener("mouseover", toggleColumnShadow);
                    td2.addEventListener("mouseout", toggleColumnShadow);
                    td2.innerText = history[key].station.stationName;
                    tr.appendChild(td2);
                }
            });
            tableBody.appendChild(tr);
        });
    });
    table.appendChild(tableBody);

    function toggleColumnShadow(e) {
        const index = findElementIndex(e.target);
        const th = tableHead.childNodes[index];
        try {
            th.classList.toggle("marked");
        } catch (e) {
        }
        tableBody.childNodes.forEach(tr => {
            try {
                tr.childNodes[index].classList.toggle("marked");
            } catch (e) {
            }
        });
    }
}

function populateFilters(data) {
    console.log(data);
    const historyData = data[0].historyData;
    const cards = new Set();
    const vehicles = new Set();
    data.forEach(card => {
        cards.add(card.id);

        const historyData = card.historyData;
        console.log(historyData);
        Object.keys(historyData).forEach(key => {
            vehicles.add(historyData[key].vehicle.name);
        });
    });
    const filter1 = document.querySelector(".filter1 select");
    cards.forEach(card => {
        const option = document.createElement("option");
        option.value = card;
        option.innerText = card;
        filter1.appendChild(option);
    });
    filter1.addEventListener("change", e => runFilters(e, data));

    const filter2 = document.querySelector(".filter2 select");
    vehicles.forEach(vehicle => {
        const option = document.createElement("option");
        option.value = vehicle;
        option.innerText = vehicle;
        filter2.appendChild(option);
    });
    filter2.addEventListener("change", e => {
        console.log(data[0].historyData.length);
        runFilters(e, data);
    });

    document.querySelector(".filter3 select").addEventListener("change", sortList);


}

function sortList(e) {
    console.log(e.target.value);
    switch (e.target.value) {
        case "1":
            sortEntry();
            return;
        case "2":
            sortExit();
            return;
        case "3":
            sortPrice();
            return;
    }
}

function sortEntry() {
    const tbody = document.querySelector("tbody");
    let changed = true;
    while (changed) {
        changed = false;
        let trs = document.querySelectorAll("tr");
        for (let i = 0; i < trs.length - 1; i++) {
            const current = new Date(trs[i].querySelector(".entrytime").dataset.originalDate);
            const next = new Date(trs[i + 1].querySelector(".entrytime").dataset.originalDate);
            if (current < next) {
                const ctr = tbody.removeChild(trs[i]);
                const ntr = tbody.removeChild(trs[i + 1]);
                tbody.insertBefore(ctr, tbody.querySelectorAll("tr")[i]);
                tbody.insertBefore(ntr, ctr);
                changed = true;
            }
        }
    }
}

function sortExit() {
    const tbody = document.querySelector("tbody");
    let changed = true;
    while (changed) {
        changed = false;
        let trs = document.querySelectorAll("tr");
        for (let i = 0; i < trs.length - 1; i++) {
            const current = new Date(trs[i].querySelector(".exittime").dataset.originalDate);
            const next = new Date(trs[i + 1].querySelector(".exittime").dataset.originalDate);
            if (current < next) {
                const ctr = tbody.removeChild(trs[i]);
                const ntr = tbody.removeChild(trs[i + 1]);
                tbody.insertBefore(ctr, tbody.querySelectorAll("tr")[i]);
                tbody.insertBefore(ntr, ctr);
                changed = true;
            }
        }
    }
}

function sortPrice(){
    const tbody = document.querySelector("tbody");
    let changed = true;
    while (changed) {
        changed = false;
        let trs = document.querySelectorAll("tr");
        for (let i = 0; i < trs.length - 1; i++) {
            const current = parseFloat(trs[i].querySelector(".cost").innerText);
            const next = parseFloat(trs[i + 1].querySelector(".cost").innerText);
            if (current < next) {
                const ctr = tbody.removeChild(trs[i]);
                const ntr = tbody.removeChild(trs[i + 1]);
                tbody.insertBefore(ctr, tbody.querySelectorAll("tr")[i]);
                tbody.insertBefore(ntr, ctr);
                changed = true;
            }
        }
    }
}

function runFilters(e, data) {
    console.log(data);
    let data1 = JSON.stringify(data);
    data1 = JSON.parse(data1);
    let filtered1 = data1.filter(filter1);
    const histories = filterVehicles(filtered1);
    filtered1 = [filtered1[0]];
    filtered1["0"]["historyData"] = [...histories];
    createTable(filtered1);
}

function filter1(item) {
    const cardId = (document.querySelector(".filter1 select").value);
//    console.log(cardId);
    if (cardId === "all")
        return true;
    return parseInt(cardId) === item.id;
}

function filterVehicles(cards) {
    const vehicleValue = document.querySelector(".filter2 select").value;
//    console.log(vehicleValue);
    const filtered = [];
    cards.forEach(card => {
        card.historyData.forEach(history => {
//            console.log(history.vehicle.name);
            if (history.vehicle.name === vehicleValue || vehicleValue === "all") {
                filtered.push(history);
            }
        });
    });
    return filtered;
}

function drawMap(e, geometry) {
    document.querySelector("#map").innerHTML = "";
    createMap(geometry);
}

function findElementIndex(el) {
    let i = 0;
    while ((el = el.previousSibling) != null)
        i++;
    return i;
}

window.onload = init;