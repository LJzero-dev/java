// var is_student; // 선언
// is_student = new Boolean(); // 사용 (초기화)
// is_student = 1; // value 변경

// var is_student = new Boolean();
// is_student = true;

var is_student = new Boolean(1);
var is_onTV = new Boolean(0);
is_onTV = 1;

if (is_student) {
    console.log("학생 입니다.");
} else {
    console.log("학생이 아닙니다.");
}

if (is_onTV) {
    console.log("TV ON");
}
else {
    console.log("TV OFF");
}