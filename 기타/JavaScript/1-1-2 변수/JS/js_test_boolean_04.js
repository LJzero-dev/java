var is_student = new Boolean("true");
is_student.name = "LJY";
is_student.gender = "male";

if (is_student) {
    console.log(is_student.name);
    console.log(is_student.gender);
    console.log("학생 입니다.");
} else {
    console.log("학생이 아닙니다.");
}

switch (is_student) {
    case 0:
        console.log("학생 입니다.");
    default:
        console.log("학생이 아닙니다.");
}
var a = (is_student) ? console.log("A") : console.log("B");
