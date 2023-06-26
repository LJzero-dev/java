// js_test_fun_05.js
// 인라인 함수
var getNotebookName = function () {
    var result = "LGX_note"
    return result;
}

var setFactoryInit = function () {
    console.log("setFactoryInit is Start");
    console.log("setFactoryInit is End");
}

var getNotebookModelName = function () {
    var result = "LG8&X0001"
    return result;
}

var isBatteryEmpty = function () {
    return false;
}

console.log("getNotebookName value is [" + getNotebookName() + "]");
setFactoryInit();
console.log("getNotebookModelName value is [" + getNotebookModelName() + "]");
console.log("isBatteryEmpty value is [" + isBatteryEmpty() + "]");