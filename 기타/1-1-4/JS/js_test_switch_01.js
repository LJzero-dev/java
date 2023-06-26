var randNum = Math.random();
console.log(randNum);
var divediceNumber = Math.floor(randNum * 10 + 1);

console.log(divediceNumber);
switch (divediceNumber) {
    case 1:
        console.log("divediceNumber is 1");
        break;
    case 2:
        console.log("divediceNumber is 2");
        break;
    case 3:
        console.log("divediceNumber is 3");
        break;
    case 4:
        console.log("divediceNumber is 4");
        break;
    case 5:
        console.log("divediceNumber is 5");
        break;
    default:
        console.log("divediceNumber is 6~10");
        break;
}