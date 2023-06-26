// js_test_array_01.js
var ages = [10, 20, 30, 40]; // Array 선언과 생성 타입 숫자
var score = ["10", "90", "80", "70"]; // Array 선언과 생성 타입2 문자
console.log("ages[0] value is " + ages[0]);
console.log("ages[1] value is " + ages[1]);
console.log("ages[2] value is " + ages[2]);
console.log("ages[3] value is " + ages[3]);
console.log("score[0] value is " + score[0]);
console.log("score[1] value is " + score[1]);
console.log("score[2] value is " + score[2]);
console.log("score[3] value is " + score[3]);
// console.log("score[4] value is " + score[4]);
console.log("ages.length value is " + ages.length); // 배열의 길이(개수)를 가져 옵니다.
for (var i = 0; i < ages.length; i++) {
    console.log("ages[" + i + "]" + ages[i]);
}
console.log("score.length value is " + score.length); // 배열의 길이(개수)를 가져 옵니다.
for (var j = 0; j < score.length; j++) {
    console.log("score[" + j + "]" + score[j]);
}