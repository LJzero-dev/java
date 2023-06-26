function init() {
    console.log("init is ok");
}

function goToNaver() { // 공통으로 여러곳에서 재사용 할 function 입니다.
    var link = "https://www.naver.com";
    window.open(link);
}
function goToNaver(inValue) { // 공통으로 여러곳에서 재사용 할 function 입니다.
    console.log("inValue value is [" + inValue + "]");
}

window.onload = init;