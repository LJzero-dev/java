function init(){
    var button = document.getElementById("movie_add_button");
    button.onclick = handleButtonClick;
}
function handleButtonClick(){
    alert("Button Click");
}
window.onload = init;