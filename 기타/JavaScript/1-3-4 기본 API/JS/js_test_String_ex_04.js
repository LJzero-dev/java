function init() {
    console.log("init is ok");
    var originStr = "JavaScript Study Now";
    var tobeStr = originStr.replace("Now", "YesterDay");

    console.log(originStr);
    console.log(tobeStr);
}
window.onload = init;