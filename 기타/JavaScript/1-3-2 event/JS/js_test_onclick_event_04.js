function init() {
    console.log("init is ok");
    var normalButton = document.getElementById("button_01");
    // normalButton.onclick = goToNaver;
    normalButton.addEventListener("click", goToNaver); // 이렇게 이벤트 리스너를 걸어 동작 시킵니다.
    
    var normalButton02 = document.getElementById("button_02");
    // normalButton02.onclick = function () { // 함수의 이름이 없는(익명) 상태로 재사용이 불가능 합니다. 다른 곳에서 이 익명 함수는 호출 할 수 없어요.
    //     console.log("normalButton02 click ok");
    // }
    normalButton02.addEventListener("click", function () { // 이렇게 이벤트 리스너를 걸어서 동작 시킵니다. 익명함수를 연결시켜 놨어요.
        console.log("normalButton02 click ok");
    });
    
    var normalButton03 = document.getElementById("button_03");
    // normalButton03.onclick = goToNaver; // function의 재사용 가능 합니다.
    normalButton03.addEventListener("click", goToNaver);

    var nomalButton04 = document.getElementById("button_04");
    nomalButton04.addEventListener("click",goToNaver);
}

function goToNaver() { // 공통으로 여러곳에서 재사용 할 function 입니다.
    var link = "https://www.naver.com";
    window.open(link);
}

window.onload = init;