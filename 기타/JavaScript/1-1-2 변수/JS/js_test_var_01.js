// js_test_var_01.js
console.log("var test ok");
//변수
var age; // 선언
console.log("age value is [" + age + "]");

age = 10; // 사용 (초기화)
console.log("age value is [" + age + "]");

var a, b, c; // , 표시를 사용해서 여러개를 선언가능 합니다.
// 변수의 작성규칙.
// 1.보통 웹에서는 변수의 선언에서 _(언더바) 주로 사용하면 카멜표기법도 혼용합니다.
// 2.공백문자(스페이스)는 사용할 수 없습니다.
// 3.시작시 숫자는 사용할 수 없어요.
// 4.시작시에 기호는 사용하지 않습니다.(! ~ 등)

var age_ex = 20; // 선언과 동시에 사용 (선언과 동시에 초기화)
console.log("age_ex value is [" + age_ex + "]");