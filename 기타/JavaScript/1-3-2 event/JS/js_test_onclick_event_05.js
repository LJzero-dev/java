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
    normalButton02.addEventListener("click", stepOne); // 복수개의 함수 연결
    normalButton02.addEventListener("click", stepTwo); 
    
    var normalButton03 = document.getElementById("button_03");
    // normalButton03.onclick = goToNaver; // function의 재사용 가능 합니다.
    normalButton03.addEventListener("click", goToNaver);
    
    var normalButton04 = document.getElementById("button_04");
    normalButton04.addEventListener("click", function () {
        console.log("normalButton04 click ok");
    });
    normalButton04.addEventListener("click", stepOne); // 복수개의 함수 연결
    normalButton04.addEventListener("click", stepTwo); 
}

function goToNaver() { // 공통으로 여러곳에서 재사용 할 function 입니다.
    var link = "https://www.naver.com";
    window.open(link);
}

function stepOne() {
    console.log("stepOne is Ok");
}

function stepTwo() {
    console.log("stepTwo is Ok");
}

window.onload = init;