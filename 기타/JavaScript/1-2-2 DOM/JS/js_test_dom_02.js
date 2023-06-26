function init() {
    var classSelect01=document.getElementById("classic_01");
    classSelect01.innerHTML="베토벤의 합창";

    var classSelect02=document.getElementById("classic_02");
    classSelect02.innerHTML="베토벤의 합창2";

    var classSelect03=document.getElementById("classic_03");
    classSelect03.innerText="베토벤의 합창3";
}
window.onload=init;


//js_test_dom_02.js
// function init() {
//     var classSelect01 = document.getElementById("classic_01");
//     classSelect01.innerHTML = "베토벤의 합창";
// }
// window.onload = init; // window.onload 속성에 함수이름을 설정 -> 이렇게 해 두면 페이지가 완전히 로드된 다음에 init 함수내의 코드를 실행 하라고 알려주는 부분입니다.
// 부연: window.onload 속성에 init라는 함수 이름이 추가 되었으니 이 함수를 실행해 주세요. 
// window.onload = init(); // 이렇게 함수를 호출을 하면, 위의 함수가 수행됩니다. 그 시점은 html이 다 로딩된 시점이 아니므로 위의 코드는 error가 발생합니다.
// 이 것은 틀린 방법이므로 사용하지 말아 주세요.
// 아래 처럼 사용해도 페이지가 모두 loading 되고 난 다음에 DOM이 만들어지고 js가 이에 접근해서 제어 할 수 있습니다.


// window.onload = function init() {
//     var classSelect01 = document.getElementById("classic_01");
//     classSelect01.innerHTML = "베토벤의 합창";
// }