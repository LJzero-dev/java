function init() {
    var nomalButton = document.getElementById("button_01");
    nomalButton.addEventListener("mouseover", mouseOverAction);
    nomalButton.addEventListener("mouseout", mouseOutAction);
    nomalButton.addEventListener("mouseout",function(){document.getElementById("button_01").style.color="blue"})
}
function mouseOverAction() {
    console.log("mouseOverAction is OK");
    var mouseOverBtn = document.getElementById("button_01");
    mouseOverBtn.style.color="red";
    mouseOverBtn.value = "마우스를 내려주세요";
}

function mouseOutAction() {
    console.log("mouseOutAction is OK");
    // document.getElementById("button_01").style.color="blue";
}
window.onload = init;