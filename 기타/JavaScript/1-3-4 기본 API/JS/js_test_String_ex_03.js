function init() {
    console.log("init is ok");
    var phoneNum = "07043201072";
    //		var phoneNum = "07055556666";
    //		var phoneNum = "0255556666";
    //		var phoneNum = "024445555";
    //		var phoneNum = "08072";
    
    if (phoneNum.length == 11 && phoneNum.indexOf("010") == 0) {
        console.log("SmartPhone number");
    } else if (phoneNum.length == 11 && phoneNum.indexOf("070") == 0) {
        console.log("Internet Phone number");
    } else if (phoneNum.length < 11 && phoneNum.indexOf("02") == 0) {
        console.log("Seoul House Phone number");
    } else {
        console.log("Unknown Phone number");
        console.log("!!!phoneNum.length value is [" + phoneNum.length + "]");
        console.log("!!!phoneNum value is [" + phoneNum + "]");
    }
    
    console.log("phoneNum.length value is [" + phoneNum.length + "]");
    console.log("phoneNum value is [" + phoneNum + "]");
}

window.onload = init;