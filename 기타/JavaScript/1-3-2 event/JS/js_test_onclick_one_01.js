//js_test_onclick_one_01.js
var isOneTime = false; // 1회 실행을 위한 변수

function init() {
    console.log("init ok");
    var confirmBtn = document.getElementById("button_01");
    confirmBtn.addEventListener("click", function () { // onclick가 아니고 click 입니다.
        alert("버튼을 눌렀습니다.");
    });

    var oneTimeBtn = document.getElementById("button_02");
    oneTimeBtn.addEventListener("click", function () {
        if (isOneTime == false) {
            alert("더 이상 이 팝업은 나오지 않어요.");
            isOneTime = true;
        }
    });

    var oneTime = { once: true };

    var oneTimeBtn02 = document.getElementById("button_03");
    oneTimeBtn02.addEventListener("click", function () {
        alert("1회용 팝업(간결하게 옵션처리) 크롬사용");
    }, oneTime); //간결하게 옵션 처리할 수 있어요. IE11에서는 동작하지 않어요. 크롬에서 사용하세요.
}
window.onload = init;