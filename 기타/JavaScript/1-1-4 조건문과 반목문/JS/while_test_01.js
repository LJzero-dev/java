var timeCount = 0;
while (isRun=true) {
    console.log(timeCount);
    timeCount += 100;
    if (timeCount > 10000) { break; }
}