window.onload = function init() {
    var movieAddButton = document.getElementById("movie_add_button");
    movieAddButton.onclick = handleButtonClick;
}
function handleButtonClick() {
    var titleTextArea = document.getElementById("title_text_area");
    var resultTitleText = titleTextArea.value; // code 가독성을 위하여 resultText -> resultTitleText로 변경했습니다.

    console.log("resultTitleText is [" + resultTitleText + "]");
    if (resultTitleText == "") {
        alert("영화제목을 넣어 주세요.");

    } else {
        alert(resultTitleText);
        var li = document.createElement("li"); // 일단<li> 태그 요소를 만듭니다.(생성)
        li.innerHTML = resultTitleText; // innerHTML를 사용해서 요소의 내용의 값을 입력받은 영화제목으로 했습니다.
        var ul = document.getElementById("movie_list"); // ul 태그를 가져옵니다.
        ul.appendChild(li); // ul 태그 아래의 차일드로 li 태그를 붙힙니다.
    }
}
