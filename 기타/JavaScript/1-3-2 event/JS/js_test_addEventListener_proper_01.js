function init() {
    console.log("init OK");

    var addEventBtn = document.getElementById("button_01");
    addEventBtn.addEventListener("click", actHandler);
    var namingEventBtn = document.getElementById("button_02");
    namingEventBtn.addEventListener("click", actHandlerTwo);

}

function actHandler() {
    alert("클릭 이벤트가 걸렸어요.");
}

function actHandlerTwo(event) {
    alert("클릭 이벤트가 걸렸어요.\n" + "event.type [" + event.type + "]"
        + "\nevent.target[" + event.target);
}

window.onload = init;