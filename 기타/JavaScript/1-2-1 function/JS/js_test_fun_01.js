function plus(x, y) {
    var result = 0;
    return result = x + y;
}
function minus(x, y) {
    var result = 0;
    result = x - y;
    return result;
}

function getName() { // 리턴 값이 String
    var result = "MyCalculor";
    return result;
}

function isBateryEmpty() { // 리턴 값이 Boolean.
    return false;
}

function setFactoryInit() {
    console.log("testFunction is OK");
}

console.log("plus(1,2) value is [" + plus(1, 2) + "]");
console.log("minus(2, 1) value is [" + minus(2, 1) + "]");
console.log("getName() value is [" + getName() + "]");
console.log("isBateryEmpty() value is [" + isBateryEmpty() + "]");
setFactoryInit();