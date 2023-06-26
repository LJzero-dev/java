//js_test_script_third.js
function remainCal(x, y) {
    return x % y;
}

var plusCal = function (x, y) {
    return x + y;
}

console.log("remainCal value is [" + remainCal(3, 2) + "]");
console.log("plusCal value is [" + plusCal(1, 1) + "]");
firstScriptOn();

var n=10;
function solution(n) {
    var answer = 0;
    for(n;n==0;n-2){
        answer+=n
    }  
    return answer;
}

