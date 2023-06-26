var custList = [["철수", "김민수", "제갈공명"],
["영희", "이다희", "독고수진", "한이쁜새롬"]];
// console.log("custList.length value is " + custList.length);
// console.log("custList.length[0] value is " + custList[0].length);
// console.log("custList.length[1] value is " + custList[1].length);
// console.log("================================================");
// console.log("cusList[0][0] value is " + custList[0][0]);
// console.log("cusList[0][1] value is " + custList[0][1]);
// console.log("cusList[0][2] value is " + custList[0][2]);
// console.log("-------------------------------------------------");
// console.log("cusList[1][0] value is " + custList[1][0]);
// console.log("cusList[1][1] value is " + custList[1][1]);
// console.log("cusList[1][2] value is " + custList[1][2]);
// console.log("cusList[1][3] value is " + custList[1][3]);
// console.log("=====================================================");

for (var j = 0; j < custList[0].length; j++) {
    console.log("for ex cusList[" + 0 + "]" + "[" + j + "]" + "value is " + custList[0][j]);
}

for (var j = 0; j < custList[1].length; j++) {
    console.log("for ex cusList[" + 1 + "]" + "[" + j + "]" + "value is " + custList[1][j]);
}

// 위의 2개의 for문을 이중 for문으로 변경합니다.
for (var i = 0; i < custList.length; i++) {
    for (var j = 0; j < custList[i].length; j++) {
        console.log("for cusList[" + i + "]" + "[" + j + "]" + "value is " + custList[i][j]);
    }
}