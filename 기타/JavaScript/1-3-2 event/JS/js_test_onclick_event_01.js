function init() {
    console.log("init is ok");
    var normalButton = document.getElementById("button_01");
    normalButton.onclick = normalButtonAct;
    var nomalButton02 = document.getElementById("button_02");
    nomalButton02.onclick = function () { console.log("normalButton02 click ok"); }
    var nomalButton03 = document.getElementById("button_03");
    nomalButton03.onclick = goToNaver;
}

function normalButtonAct() {
    console.log("normalButton click ok");
}

function goToNaver() { // 공통으로 여러곳에서 재사용 할 function 입니다.
    var link = "https://www.naver.com";
    window.open(link);
}

window.onload = init;