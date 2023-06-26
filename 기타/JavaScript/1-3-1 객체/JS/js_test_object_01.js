var dog = {
    name: "happe",
    gender: "male",
    age: 3,
    color: "white",
    kind: "yorkshire",
    character: "actvity"
};

var Notebook = {
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

    console.log(Notebook.name);
    console.log(Notebook.color);
    console.log(Notebook.model_number);
    console.log(Notebook.muge);
    console.log(Notebook.color);
    console.log(Notebook.price);


}


window.onload = init;