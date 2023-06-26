//js_test_script_sec.js
console.log("multiCal func call value is [" + multiCal(2, 2) + "]");
function diviCal(x, y) { 
    return x / y;
}

var secScriptOn = function() { 
    console.log("secScriptOn function is called");
}

secScriptOn();
console.log("diviCal func call value is [" + diviCal(2, 2) + "]");