function test() {
    var temp = function() {
    	console.log("temp");
    }
    var temp02 = function() {
    	console.log("temp01");
    }
    
    temp();
    temp02();
}

test(); // 이렇게 호출 될 때 안의 temp(), temp02() 함수가 만들어 집니다.
// 만일 test 함수안에 인라인 함수가 100개가 된다면, 성능 저하가 발생합니다.
// test 함수가 호출되면, 100개의 인라인 함수가 생성되기 때문이죠.