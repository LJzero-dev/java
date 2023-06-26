function init(){
    var cssChange = document.getElementById("new_book_list_01");
    cssChange.style.color="red";

    var changeButton = document.getElementById("change_button");
    changeButton.onclick=changeCollor;
    
}

function changeCollor(){
    
    document.getElementById("best_book_list_01").style.color="green";

}

window.onload=init;