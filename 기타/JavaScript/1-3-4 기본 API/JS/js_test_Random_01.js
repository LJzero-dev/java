function init() {
    console.log("init is ok");
    
    var randNum = Math.random();
    console.log("randNum value is " + randNum);
    
    var number = Math.floor(randNum * 6 + 1); // floor 소수점 버리기.
    console.log("Dice value is [" + number + "]");
}

window.onload = init;