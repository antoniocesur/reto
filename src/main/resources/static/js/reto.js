
function fetchData() {
  fetch("/lista6")
    .then((response) => response.json())
    .then((json) => takeData(json));
}

function takeData(val) {
    let t=document.getElementById("definicion");
    t.innerHTML=val[0].palabra;
    return console.log(val);
}

//fetchData();