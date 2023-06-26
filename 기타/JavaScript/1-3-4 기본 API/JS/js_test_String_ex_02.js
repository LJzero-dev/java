function init() {
    console.log("init is ok");
    var word = ("korea fighting!");
    var indicator = word.indexOf("fighting");
    console.log("indicator value is" + indicator);

    if (word.indexOf("korea") != -1) {
        console.log("Find OK");
    } else {
        console.log("Not Find");
    }
}
window.onload = init;