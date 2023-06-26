function People(name, age, gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.walk = function walk() {
        console.log("walk");
    };
    this.eat = function eat() {
        console.log("eat");
    };
}

function init() {
    var people01 = new People("minisu", 30, "male");
    console.log("people01.name value is [" + people01.name + "]");
    console.log("people01.age value is [" + people01.age + "]");
    console.log("people01.gender value is [" + people01.gender + "]");
    people01.walk();
    people01.eat();
    
    var people02 = new People("suji", 20, "female");
    console.log("people02.name value is [" + people02.name + "]");
    console.log("people02.age value is [" + people02.age + "]");
    console.log("people02.gender value is [" + people02.gender + "]");
    people02.walk();
    people02.eat();
};
window.onload = init;