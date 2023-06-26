var cat = {
    name:"bbomi",
    age: 2,
    color: "black"
};

function init() {
    console.log("init function is ok");
    console.log("cat.name value is [" + cat.name + "]");
    console.log("cat.age value is [" + cat.age + "]");
    console.log("cat.color value is [" + cat.color + "]");
    
    for (temp in cat) {
      temp=="age" ? alert("age 속성 존재") : console.log("cat 요소 속성 [" + temp + "] " + "값[" + cat[temp] + "]");
    }
}

window.onload = init;