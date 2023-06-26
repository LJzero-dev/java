function init() {
    console.log("init is ok");
    setTimeout(function () {
        console.log("oneTime is Out");
    }, 2000);
}
window.onload = init;