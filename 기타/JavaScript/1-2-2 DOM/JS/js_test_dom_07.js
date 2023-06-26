window.onload = function init(){
    var movieAddButton = document.getElementById("movie_add_button");
    movieAddButton.onclick=handleButtonClick;
}

function handleButtonClick(){
    // if(title_text_area.value !=""){
    // alert(title_text_area.value);}
    // else{alert("영화제목을 입력하여 주세요")(title_text_area.placeholder="영화 제목을 넣으세요")};

    title_text_area.value =="" ?   alert("영화제목을 입력하여 주세요")(title_text_area.placeholder="영화 제목을 넣으세요") : alert(title_text_area.value);
}

// alert("영화제목을 입력하여 주세요")