function init() {
    console.log("init is ok");
    var string = "suji|minsu|sumi|haksun";

    var stringArray = string.split("|");
    for (var i = 0; i < stringArray.length; i++) {
        console.log(stringArray[i]);
    }
}
window.onload = init;