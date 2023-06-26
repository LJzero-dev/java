var movieList = ["해적", "킹메이커", "노웨이홈", "특송"];
// function init() {
//     var movieSelect00 = document.getElementById("movie_0");
//     movieSelect00.innerHTML = movieList[0];
    
//     var movieSelect00 = document.getElementById("movie_1");
//     movieSelect00.innerHTML = movieList[1];
    
//     var movieSelect00 = document.getElementById("movie_2");
//     movieSelect00.innerHTML = movieList[2];
    
//     var movieSelect00 = document.getElementById("movie_3");
//     movieSelect00.innerHTML = movieList[3];
// }
window.onload = init; // window.onload 속성에 함수이름을 설정 -> 이렇게 해 두면 페이지가 완전히 로드된 다음에 init 함수내의 코드를 실행 하라고 알려주는 부분입니다.
// 부연: window.onload 속성에 init라는 함수 이름이 추가 되었으니 이 함수를 실행해 주세요.

function init(){
    for(var i=0;i<movieList.length;i++){
    var movieSelectTemp = document.getElementById("movie_"+i);
    movieSelectTemp.innerHTML= movieList[i];
    }
}
window.onload=init()
 
