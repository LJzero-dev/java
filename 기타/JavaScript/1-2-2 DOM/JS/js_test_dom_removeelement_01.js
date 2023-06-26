function init() {
    var oneLineAdd = document.getElementById("line_add");
    oneLineAdd.onclick = oneLineAddFunc;
    
    var oneLineDel = document.getElementById("line_del");
    oneLineDel.onclick = oneLineDelFunc;
}

function oneLineAddFunc() {
    var h1Tag = document.createElement("h1");
    h1Tag.id = "h1_id"; // tag에 id를 부여하여 줍니다.
    
    var inputText = document.getElementById("input_text"); // step2
    var tNode = document.createTextNode(inputText.value); // input 값을 TextNode로 넣습니다.
    h1Tag.appendChild(tNode);
    
    var resultTag = document.getElementById("new_one_line");
    resultTag.appendChild(h1Tag);
}

function oneLineDelFunc() {
    
    var h1Tag = document.getElementById("h1_id");
    
    var getLine = document.getElementById("new_one_line");
    h1Tag !=null ? getLine.removeChild(h1Tag) : "";
}

window.onload = init;