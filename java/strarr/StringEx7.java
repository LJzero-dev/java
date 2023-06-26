/*
사원 코드 규칙
1. 전체 글자수는 6
2. 전체 부서의 수는 5
3. 첫영문은 소속 부서를 의미(A : 총무부, B : 기획부, C : 영업부, D : 자재부, E : 전산부)

작업 내용
각 부서별 인원수를 출력 - 총무부 : ?명 / 기획부 : ? 명 ...
*/

class StringEx7 {
	public static void main(String[] args) {
		String[] arr = {"12-A34", "88-B65", "5-C321", "9-A122", "88-C55", "99-A23", "77-B21", "44-C22", "4-A223", "2-B654", "33-C44", "21-C15", "5-C325"};
		int a = 0, b = 0, c = 0, d = 0, e = 0;
		for (String x : arr) {
			switch (x.charAt(x.indexOf('-')+1)) {
			case 'A': {
				a++; break;
				}
			case 'B': {
				b++; break;
				}
			case 'C': {
				c++; break;
				}
			case 'D': {
				d++; break;
				}
			case 'E': {
				e++; break;
				}
			}
		}
		System.out.println("총무부 : " + a + "명, 기획부 : " + b + "명, 영업부 : " + c + "명, 자재부 : " + d + "명, 전산부 : " + e);
	}
}
