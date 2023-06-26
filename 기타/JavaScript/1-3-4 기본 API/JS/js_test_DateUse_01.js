function init() {
    console.log("init is ok");
    
    var date = new Date();
    console.log(date.getFullYear() + "년");
    console.log(date.getMonth() + 1 + "월"); // 0부터 시작 되므로...
    console.log(date.getDate() + "일");
    console.log("-----------------------------------");
    console.log(date.getHours() + "시");
    console.log(date.getMinutes() + "분");
    console.log(date.getSeconds() + "초");
    console.log(new Date().getSeconds);
}

window.onload = init;