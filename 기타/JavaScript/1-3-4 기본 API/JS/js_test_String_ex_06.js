function init() {
    console.log("init is ok");
    
    var string = "I'm a boy";
    var toLower=string.toLocaleLowerCase();
    var toUpper=string.toUpperCase();

    console.log(toLower);
    console.log(toUpper);
}

window.onload = init;