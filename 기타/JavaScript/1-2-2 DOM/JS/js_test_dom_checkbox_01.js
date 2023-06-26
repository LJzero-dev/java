function init() {
    var button = document.getElementById("button01");
    button.onclick = reviewButton;
}
function reviewButton() {
    var privateInfo = document.getElementById("check01");
    var isChecked = privateInfo.checked;
    var privateInfoValue = privateInfo.value;
    
    alert("privateInfo Checked value is ["+isChecked+"]"+ "\n"+
    "privateInfoValue value is ["+privateInfoValue+"]"
    );
}
window.onload = init;