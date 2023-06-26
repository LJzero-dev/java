function init() {
    console.log("init is OK");
    var nomalInput = document.getElementById("input_01");
    nomalInput.addEventListener("keydown", keyDownAction);
}

function keyDownAction(event) {
    console.log("keydown is OK" + event.keyCode + "]");
    var keyValue = event.keyCode;
    if (keyValue >= 48 && keyValue < 58) {
        console.log("숫자키의 입력입니다.");
    } else {
        console.log("숫자키 외의 키들입니다.");
    }
}

window.onload = init;