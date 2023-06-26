function init() {
    console.log("init function is ok");

    var resultinfo = document.getElementById("first_url");
    var urlAddressValue = resultinfo.getAttribute("href");
    console.log("urlAddress value is [" + urlAddressValue + "]");
    console.log(resultinfo.getAttribute("id"));
    console.log(resultinfo.getAttribute("target"));

}
window.onload = init;