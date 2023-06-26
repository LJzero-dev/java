//js_test_removeListener_01.js
function init() {
    console.log("init ok");
    
    var addEventBtn = document.getElementById("button_01");
    addEventBtn.addEventListener("click", function () {
        alert("이벤트를 걸었습니다."); // 동작 알림 팝업
        var confirmBtn = document.getElementById("button_03");
        confirmBtn.addEventListener("click", actHandler); // 클릭시에 발생할 함수(핸들러) 등록 합니다.
    });
    
    var removeEventBtn = document.getElementById("button_02");
    removeEventBtn.addEventListener("click", function () {
        alert("이벤트를 제거했어요."); // 동작 알림 팝업
        var confirmBtn = document.getElementById("button_03");
        confirmBtn.removeEventListener("click", actHandler); // 클릭시에 발생할 함수(핸들러) 제거 합니다.
    });

}

function actHandler() {
    alert("팝업 이벤트가 add 잘 되었어요.");
}

window.onload = init;