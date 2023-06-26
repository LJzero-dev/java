// js_test_fun_07.js
function plusCalType01(x, y) { //일반함수
    return x + y;
}

var plusCalType02 = function (x, y) { // 인라인함수
    return x + y;
}

var plusCalType03 = new Function("x", "y", "return x+y"); // 익명 함수 동적, 객체로 확장
plusCalType03.myName = "NewPlusCalType03";

console.log("plusCalType01 [" + plusCalType01(1, 2) + "]");
console.log("plusCalType02 [" + plusCalType02(1, 2) + "]");
console.log("plusCalType03 [" + plusCalType03(1, 2) + "]");
console.log("plusCalType03.myName [" + plusCalType03.myName + "]");

function plusCalType01(x,y){
    return x-y;
}

var plusCalType02= function (x,y){
    return x-y;
}

var plusCalType03 = new Function("x","y", "return x-y");
plusCalType03.myName = "NewPlusCalType03";


console.log("plusCalType01 [" + plusCalType01(1, 2) + "]");
console.log("plusCalType02 [" + plusCalType02(1, 2) + "]");
console.log("plusCalType03 [" + plusCalType03(1, 2) + "]");
console.log("plusCalType03.myName [" + plusCalType03.myName + "]");