var dog = {
    name: "happe",
    gender: "male",
    age: 3,
    color: "white",
    kind: "yorkshire",
    character: "actvity"
};

var notebook = {
    name: "notebook",
    model_number: 13425,
    muge: "12kg",
    color: "brown",
    making_day: "today",
    price: "300,000"
};

function init() {
    console.log("init function is ok");
    console.log("---------객체의 두가지 접근법이 있습니다. 보통 아랫것을 사용하도록합니다.------------------");
    console.log("dog[name] value is [" + dog["name"] + "]");
    console.log("dog.name value is [" + dog.name + "]");
    console.log("----------------------------------------");
    console.log("dog.name value is [" + dog.name + "]");
    console.log("dog.gender value is [" + dog.gender + "]");
    console.log("dog.age value is [" + dog.age + "]");
    console.log("dog.color value is [" + dog.color + "]");
    console.log("dog.kind value is [" + dog.kind + "]");
    console.log("dog.character value is [" + dog.character + "]");

    console.log(notebook.name);
    console.log(notebook.color);
    console.log(notebook.model_number);
    console.log(notebook.muge);
    console.log(notebook.color);
    console.log(notebook.price);
    dog.brithDay="2020.01.02";
    console.log(dog.brithDay);
    notebook.maker="samsung";
    console.log(notebook.maker);

    var addButton = document.getElementById("add_button");
    addButton.onclick = addObject;
    
    var okButton = document.getElementById("ok_button");
    okButton.onclick = infoObject;
}

function addObject() {
    var text_01=document.getElementById("text_01");
    var text_02=document.getElementById("text_02");
    madeComp=text_02.value;
    madeComp2=text_01.value;
    notebook.madeComp = text_01.value;
    alert("객체의 구성요소 추가 [" + notebook.madeComp + notebook.madeComp2+"]");
}

function infoObject() {
    alert("추가된 구성요소는 다음과 같습니다." + "\n" + "[" + notebook.madeComp + "]");
}

window.onload = init;