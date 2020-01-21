
function init() {
    const url = `${contextPath}/user-api/get-history`;
    fetch(url)
            .then(res => res.json())
            .then(data => {
                console.log(data);
// CHECK IF CLIENT HAS AT LEAST 1 CARD AND 1 HISTORY LOG
                if (data[0] && data[0].historyData[0]) {
                    const table = document.querySelector("#history-table");
                    const tableHead = table.querySelector("thead");
                    const tableBody = table.querySelector("tbody");

// CREATE <thead>
                    const firstEntry = data[0].historyData[0];
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
                                else if (key === "entrytime" || key === "exittime")
                                    td.innerText = `fix date bitch`;
                                else if (key === "vehicle")
                                    td.innerText = history[key].name;
                                else
                                    td.innerText = history[key];
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
            }).catch(err => console.error(err));
}

function drawMap(e, geometry) {
    document.querySelector("#map").innerHTML = "";
    if (window.olMap !== null){
        
        olMap.removeLayer(olMap.getLayers().getArray()[1]);
    }
    createMap(geometry);
}

function findElementIndex(el) {
    let i = 0;
    while ((el = el.previousSibling) != null)
        i++;
    return i;
}

function createTextForHeader(key, obj) {
    switch (k) {
        case "id":
        case "cardid":
        case "cost":
        case "entrygate":
        case "exitgate":
            return k;
        case "":
            ;
    }
}

window.onload = init;