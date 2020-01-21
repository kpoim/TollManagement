
function init(){
    const url = `${contextPath}/user-api/get-history`;
    fetch(url)
            .then(res => res.json())
            .then(data => console.log(data));
}

window.onload = init;