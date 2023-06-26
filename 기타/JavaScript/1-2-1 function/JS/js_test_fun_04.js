// js_test_fun_04.js
// 인라인 함수
var setProcess = function () {
    console.log("setProcess is OK");
}

var getName = function () {
    var result = "lymin";
    return result;
}

var localPlus = function (x, y) {
    var result = x + y;
    console.log("localCalPlus Function value is [" + result + "]");
}

setProcess();
console.log("my Name is [" + getName() + "]");
localPlus(1, 2);