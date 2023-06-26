window.onload = function init(){
    var movieAddButton = document.getElementById("movie_add_button");
    movieAddButton.onclick=handleButtonClick;
}

function handleButtonClick(){
    alert("MovieAddButton Clicked");
}