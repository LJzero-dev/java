console.log("VariableScopeTest");
var a = 10;
var b = 20;
var c = 30;
a = 0;
b = 0;
c = 1;

var result = a + b + c;

console.log("c value is [" + c + "]");
console.log("result value is [" + result + "]");