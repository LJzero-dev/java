function init() {
    var button = document.getElementById("button01");
    button.onclick = reviewButton;
    
    var radioButtonAdd = document.getElementById("radio_button_add");
    radioButtonAdd.onclick = radioButtonAddOn;
}

function reviewButton() {
    var privateInfo = document.getElementById("check01");
    var pInfoIsChecked = privateInfo.checked;
    var privateInfoValue = privateInfo.value;
    
    var usedLaw = document.getElementById("check02");
    var uInfoIsChecked = usedLaw.checked;
    var usedLawValue = usedLaw.value;
    
    alert("privateInfo Checked value is ["+pInfoIsChecked+"]"+ "\n"+
    "privateInfoValue value is ["+privateInfoValue+"]" + "\n"+ "\n"+
    "useLaw Checked value is ["+uInfoIsChecked+"]" + "\n"+
    "useLaw value is ["+usedLawValue+"]"
    );
}

function radioButtonAddOn() {
    var labelValue = document.getElementById("radio_button_text");
    var inputTag = document.createElement("input");
    inputTag.type = "radio";
    inputTag.name = "radio_button";
    
    var labelTag = document.createElement("label");
    labelTag.innerHTML = labelValue.value;
    
    var bTag = document.createElement("br");
    var resultTag = document.getElementById("new_radio_list");
    
    resultTag.appendChild(inputTag);
    resultTag.appendChild(labelTag);
    resultTag.appendChild(bTag);
}

window.onload = init;