var count = 0;
var interval;

function init() {
    console.log("init is ok");
    setInterval(repeatText, 1000);
}

function repeatText() {
    console.log("Text On [" + count++ + "]");
    if (count == 10) {
        console.log("clearInterval")
        clearInterval(interval);
    }
}

window.onload = init;