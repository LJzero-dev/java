function init() {
    var cssChange = document.getElementsByClassName("new_book_list_class_01");
    for (i = 0; i < cssChange.length; i++) {
        cssChange[i].style.color = "red";
    }

    var changeButton = document.getElementById("change_button");
    changeButton.onclick = changeColor;
}

function changeColor() {
    var temp = document.getElementsByClassName("new_book_list_class_01");
    if (temp[0].style.color == "red") {
        for (i = 0; i < temp.length; i++) {
            temp[i].style.color = "blue";
        }
    } else {
        for (i = 0; i < temp.length; i++) {
            temp[i].style.color = "red";
        }
    }
}
window.onload = init;