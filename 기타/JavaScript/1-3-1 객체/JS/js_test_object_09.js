var dog = {
    name: "happy",
    gender: "male",
    age: 3,
    color: "white",
    kind: "yorkshire",
    character: "activity",
    wag: function () {
        console.log("꼬리를 흔들어요.");
    },
    eat: function(meatCnt){
        meatCnt>9 ? console.log("행복") : console.log("배고픔,슬픔");
    }
};

function init() {
    console.log("init function is ok");
    dog.wag();
    dog.eat(100);
    dog.eat(4);
}



window.onload = init;