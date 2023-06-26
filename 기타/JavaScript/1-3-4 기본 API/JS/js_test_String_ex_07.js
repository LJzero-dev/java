function init() {
    console.log("init is ok");
    
    var string = "Tell me Something!     ";
    var string2 = "Now";
    var num = 123.31231;
    console.log(string+string2);
    console.log(string.trim()+string2);
    console.log(num);
    console.log(~~num);
}

window.onload = init;