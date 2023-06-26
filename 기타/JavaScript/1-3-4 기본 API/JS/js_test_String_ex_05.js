function init() {
    console.log("init is ok");
    var string = "01022223333";
    var lastNum4 = string.substring(7, 11); // 잘라낼 문자열의 시작 index, 끝날 index를 넣어 줍니다.
    console.log("휴대전화 뒷자리 4자리의 값은 [" + lastNum4 + "]" + "입니다.");
    
    var theOtherNum = string.substring(3); // index 3 이후 모두 잘라서 버리고 보여주기.
    console.log(theOtherNum);
}

window.onload = init;