function init() {
    var button = document.getElementById("movie_add_button");
    button.onclick = handleButtonClick;
    var button = document.getElementById("toggle_button");
    button.onclick = toggleButtonClick;
}
function handleButtonClick() {
    alert("Button Click");
}


function toggleButtonClick() {
    var togglebutton = document.getElementById("toggle_button");
    togglebutton.value == "드라마 추가" ? togglebutton.value = "교양 추가" : togglebutton.value = "드라마 추가";
    // if (togglebutton.value == "드라마 추가") {
    //     togglebutton.value = "교양 추가";
    // } else if (togglebutton.value == "교양 추가") {
    //     togglebutton.value = "드라마 추가";
    // }
    movie_add_button.value == "영화 추가" ? movie_add_button.value = "영화 삭제" : movie_add_button.value = "영화 추가";
}
window.onload = init;