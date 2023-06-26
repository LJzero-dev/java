function init() {
    var oneLineAdd = document.getElementById("line_add");
    oneLineAdd.onclick = oneLineAddFunc;
}
function oneLineAddFunc() {
    var h1Tag = document.createElement("h1");
    var tNode = document.createTextNode(input_text.value);
    h1Tag.appendChild(tNode);

    var resultTag = document.getElementById("new_one_line");
    resultTag.appendChild(h1Tag);
}

window.onload = init;




function oneLineAddFunc() {
    var h1Tag = document.createElement("h1");
    // var tNode = document.createTextNode("textNodeTest"); // step1.
    // var inputText = document.getElementById("input_text"); // step2
    // var tNode = document.createTextNode(inputText.value);
    
    var tNode = document.createTextNode(document.getElementById("input_text").value); // step3
    h1Tag.appendChild(tNode);
    
    var resultTag = document.getElementById("new_one_line");
    resultTag.appendChild(h1Tag);
}