var resultInfo; // 전역 변수로 만들어 놓습니다. (다른 function에서 사용하기 위함 입니다.)

function init() {
    console.log("init function is ok");
    
    var okButton = document.getElementById("ok_button_01");
    okButton.onclick = changeValueCall;
    
    resultInfo = document.getElementById("first_url"); // 전역변수를 사용합니다.
    
    var urlAddressValue = resultInfo.getAttribute("href");
    var idValue = resultInfo.getAttribute("id");
    var targetValue = resultInfo.getAttribute("target");
    var textValue = resultInfo.textContent; // text 값을 가져옵니다.
    console.log("urlAddressValue value is [" + urlAddressValue + "]");
    console.log("idValue value is [" + idValue + "]");
    console.log("targetValue value is [" + targetValue + "]");
    console.log("textValue value is [" + textValue + "]");
    
    resultInfo.setAttribute("href", "https://www.nate.com"); // setAttribute 사용
    var newUrlAddressValue = resultInfo.getAttribute("href"); // getAttribute 사용
    
    console.log("new Set urlAddressValue value is [" + newUrlAddressValue + "]"); // value 확인
    resultInfo.setAttribute("id", "first_url_two");
    
    var newIdValue = resultInfo.getAttribute("id"); 
    console.log("new Set newIdValue value is [" + newIdValue + "]");
}

function changeValueCall() {
    var newUrlAddressValue = resultInfo.getAttribute("href"); // resultInfo가 전역변수로 선언 되어 있어야 참조 할 수 있습니다.
    var newIdValue = resultInfo.getAttribute("id");//local (지역) 변수의 경우는 function에서 효과가 한정되므로 이름이 동일해도 됩니다.
    alert("urlAddressValue value is [" + newUrlAddressValue + "]" + "\n" + "id value is [" + newIdValue + "]");
}

window.onload = init;