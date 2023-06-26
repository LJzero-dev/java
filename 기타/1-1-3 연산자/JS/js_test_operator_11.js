// // js_test_operator_11.js
// var isOnTv = true;
// var isOnRadio = true;

// if (isOnTv && isOnRadio) { // 앞의 피연산자를 검사하여 false면 뒤의 연산자를 검사하지 않습니다. 효율적이므로 실무에서 이것이 많이 쓰입니다.
//     console.log("AND(&&) is true..isOnTv isOnRadio");
//     console.log("isOnTv value is " + isOnTv);
//     console.log("isONRadio value is " + isOnRadio);
// } else {
//     console.log("AND(&&) the others case...");
//     console.log("isOnTv value is " + isOnTv);
//     console.log("isONRadio value is " + isOnRadio);
// }
// console.log("===========================================");
// if (isOnTv & isOnRadio) { // 피연산자 2개를 모두 검사합니다. (비효율적으로 실무에서 잘 사용되지 않습니다.)
//     console.log("AND(&) is true..isOnTv isOnRadio");
//     console.log("isOnTv value is " + isOnTv);
//     console.log("isONRadio value is " + isOnRadio);
// } else {
//     console.log("AND(&) the others case...");
//     console.log("isOnTv value is " + isOnTv);
//     console.log("isONRadio value is " + isOnRadio);
// }
// js_test_operator_12.js
var isOnPc = false;
var isOnPhone = false;

if (isOnPc || isOnPhone) { // 앞의 피연산자를 검사하여 true면 뒤의 연산자를 검사하지 않습니다. 효율적이므로 실무에서 이것이 많이 쓰입니다.
    console.log("OR(||) is true..isOnPc isOnPhone");
    console.log("isOnPc value is " + isOnPc);
    console.log("isOnPhone value is " + isOnPhone);
} else {
    console.log("OR(||) the others case...");
    console.log("isOnPc value is " + isOnPc);
    console.log("isOnPhone value is " + isOnPhone);
}
console.log("===========================================");
if (isOnPc | isOnPhone) { // 피연산자 2개를 모두 검사합니다. (비효율적으로 실무에서 잘 사용되지 않습니다.)
    console.log("OR(|) is true..isOnPc isOnPhone");
    console.log("isOnPc value is " + isOnPc);
    console.log("isOnPhone value is " + isOnPhone);
} else {
    console.log("OR(|) the others case...");
    console.log("isOnPc value is " + isOnPc);
    console.log("isOnPhone value is " + isOnPhone);
}

var isOnPc = true;
var isOnPhone = false;

if (isOnPc ^ isOnPhone) { // 피연산자 두개중 하나는 true, 하나는 false가 되어야 true를 반환 합니다.
    console.log("XOR(^) is true..isOnPc isOnPhone");
    console.log("isOnPc value is " + isOnPc);
    console.log("isOnPhone value is " + isOnPhone);
} else {
    console.log("XOR(^) the others case...");
    console.log("isOnPc value is " + isOnPc);
    console.log("isOnPhone value is " + isOnPhone);
}