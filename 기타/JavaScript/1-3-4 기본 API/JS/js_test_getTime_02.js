//js_test_getTime_01.js
function init() {
    console.log("init is ok");
    // var currentTime = new Date().getTime(); // milisec 단위 입니다.
    // currentTime
    // console.log("currentTime value is [" + currentTime + "]");
    var startTime = 0;
    var endTime = 0;
    for (var i = 0; i < 100000; i++) { // 십만번...
        console.log("count ["+i+"]");
        if (i == 0) {
            startTime = new Date().getTime();
        } else if (i == 99999) {
            endTime = new Date().getTime();
        }
    }
    console.log("소요시간은 [" + (endTime - startTime) / 1000 + "]" + "초 입니다.");
}

window.onload = init;