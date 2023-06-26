//js_test_removeListener_02.js
function init() {
    console.log("init ok");
    
    var addEventBtn = document.getElementById("button_01");
    addEventBtn.addEventListener("click", function () {
        alert("이벤트를 걸었습니다."); // 동작 알림 팝업
        
        var confirmBtn = document.getElementById("button_03");
        confirmBtn.addEventListener("click", function() { // 익명으로 하면, 호출 될 때 마다, 계속 add 되어 갑니다. 계속 호출하는 경우에 핸들러는 익명이 아닌 명명을 해 주세요.
            alert("팝업 이벤트가 add 잘 되었어요.")
        }); // 클릭시에 발생할 함수(핸들러) 등록 합니다.
    });
    
    var removeEventBtn = document.getElementById("button_02");
    removeEventBtn.addEventListener("click", function () {
        alert("이벤트를 제거했어요."); // 동작 알림 팝업
        
        var confirmBtn = document.getElementById("button_03");
        confirmBtn.removeEventListener("click", function(){ // 익명으로 하면 이름이 없어서 핸들러를 제거 할 수 없어요.// 동작하지 않는 잘 못된 코드입니다.
            alert("제거 완료..");
        }); // 클릭시에 발생할 함수(핸들러) 제거 합니다.
    });
}

window.onload = init;