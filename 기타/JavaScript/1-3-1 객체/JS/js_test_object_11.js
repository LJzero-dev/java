var dog = {
    name: "happy",
    gender: "male",
    age: 3,
    color: "white",
    kind: "yorkshire",
    character: "activity",
    wag: function() {
        console.log("꼬리를 흔들어요.");
    },
    eat: function (meatCnt) {
        if (meatCnt > 9) {
            console.log("Dog is happiness")
        } else {
            console.log("Dog is hungry.. and sad..");
        }
    },
    isAdult: function () {
        if (this.age > 1) {
            console.log("dog is adult");
        } else {
            console.log("dog is kid");
        }
    },
    nameChange: function (toName) {
        this.name = toName; // 프로퍼타이즈 처럼 사용되므로 녹색으로 편집기에서 표시된다.
        console.log("this name value is [" + this.name + "]");
    }
};

function DogConstructor(name,gender,age, color, kind, character ) { // 생성자는 카멜표기법으로 시작시 항상 대문자로 시작해 주세요.
    this.name = name;
    this.gender = gender;
    this.age = age;
    this.color = color;
    this.kind = kind;
    this.character = character;
    this.meatCnt = 0; // 이렇게 선언 및 초기화 해 줍니다.
    this.wag = function() {
        console.log("꼬리를 흔들어요. Constructor");
    }; // ; 세미콜론을 사용해서 닫아줌에 유의 합니다. (생성자에서 함수를 만들시에 오브젝트 혹은 생성자에서의 함수는 메서드라 부릅니다.)
    this.eat = function(meatCnt) {
        this.meatCnt = meatCnt;
        if (this.meatCnt > 9) { // 위 부분에서 선언 및 사용(초기화) 해 주었습니다.
            console.log("Dog Constructor is happiness")
        } else {
            console.log("Dog Constructor is hungry.. and sad..");
        }
    };
    this.isAdult = function() {
        if (this.age > 1) {
            console.log("dog Constructor is adult");
        } else {
            console.log("dog Constructor is kid");
        }
    };
    this.nameChange = function (toName) {
        this.name = toName; // 프로퍼타이즈 처럼 사용되므로 녹색으로 편집기에서 표시된다.
        console.log("Constructor this name value is [" + this.name + "]");
    };
}

function init() {
    console.log("init function is ok");
    dog.wag();
    dog.eat(100);
    dog.eat(1);
    dog.isAdult();
    dog.nameChange("jjong");
    
    console.log("=============================================");
    console.log("이제 대량으로 만들 수 있습니다.");
    console.log("=============================================");
    
    var dog01 = new DogConstructor("aji", "male", 1, "white", "chiwawa", "sunny");
    console.log(dog01.name);
    dog01.wag();
    dog01.eat(1);
    dog01.isAdult();
    dog01.nameChange("jangji");
    
    var dog02 = new DogConstructor("angi", "female", 3, "black", "balbari", "agile");
    console.log(dog02.name);
    dog02.wag();
    dog02.eat(10);
    dog02.isAdult();
    dog02.nameChange("cute");
    
    var dog03 = new DogConstructor("goongi", "male", 10, "blue", "chiwawa", "slow");
    console.log(dog03.name);
    dog03.wag();
    dog03.eat(20);
    dog03.isAdult();
    dog03.nameChange("pretty");
}
window.onload = init;