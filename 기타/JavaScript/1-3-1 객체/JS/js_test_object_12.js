var cat = {
    name: "bbomi",
    age: 2,
    run: function () {
        console.log("cat is run");
    }
};
function CatConst(name,age){
    this.name=name;
    this.age=age;
    this.run=function(){
        console.log("cat is run");
    };
}
function init() {
    console.log("init function is ok");
    console.log("cat.name value is [" + cat.name + "]");
    console.log("cat.age value is [" + cat.age + "]");
    cat.run();
    console.log("=======================================");
    
    var cat01 = new CatConst("jeni", 1);
    console.log("cat01.name value is [" + cat01.name + "]");
    console.log("cat01.age value is [" + cat01.age + "]");
    cat01.run();
    
    var cat02 = new CatConst("stelra", 10);
    console.log("cat01.name value is [" + cat02.name + "]");
    console.log("cat01.age value is [" + cat02.age + "]");
    cat02.run();
}

window.onload = init;