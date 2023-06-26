// js_test_string_01.js
var sampleA = new String("Lee"); // new keyword는 델리게이션 메모리에 새로이 올린다는 의미 입니다.
var sampleB = new String("Lee"); // 그러므로 sampleA, sampleB는 각기 다른 객체 입니다.
// 두개가 서로 다른 객체로 다른 주소에 올라가 있습니다.
// if (sampleA == sampleB) { 
//     console.log("sampleA == sampleB");
// } else {
//     console.log("sampleA != sampleB");
// }
if (sampleA.toString() == sampleB.toString()) { // 문자열 비교는 이렇게 합니다.
    console.log("sampleA sampleB is Same");
} else {
    console.log("sampleA sampleB is Not Same");
}