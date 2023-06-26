function init() {
    console.log("init function is ok");
    
    var resultInfo = document.getElementById("first_url");
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
    resultInfo.setAttribute("id","first_url_two");
    console.log(idValue);
    console.log("new Set urlAddressValue value is [" + newUrlAddressValue + "]"); // value 확인
}
window.onload = init;