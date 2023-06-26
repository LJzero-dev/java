// js_test_fun_06.js
// 익명함수
// 인자가 없을시 아래 처럼 사용.
var notParamFunction = new Function();// 인자가 없을 시
// var notParamFunction = new Function(console.log("notParamFunction")); // console 로그를 넣고 싶은 경우.
notParamFunction.param01 = "100"; // new를 사용하였으므로 객체가 됩니다. 이렇게 객체에 인자를 추가하고 할당 가능합니다.
notParamFunction(); // function 호출
console.log("testNewFunc.test01 value is [" + notParamFunction.param01 + "]"); // 객체의 하위 param 확인.

function solution(angle) {
    var answer = 0;
    if (0 < angle < 90) {
        return answer = 1;
    } else if (angle == 90) {
        return answer = 2;
    } else if (90 < angle > 180) {
        return answer = 3;
    }
    else { return answer = 4; }
    return answer;
}
