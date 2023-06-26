import java.util.*;

/*
아이디 유효성 검사
 - 하나의 아이디를 입력받아 유효성 검사 후 이상 없으면 "정상적인 아이디 입니다." 출력
 	이상 있으면 "잘못된 아이디 입니다. \n다시 입력하세요." 출력 후 다시 입력 받음
	정상적인 아이디를 입력할 때 까지 계속 입력받아야 함

검사 조건 - isID() 메소드를 만들어 이상여부를 리턴받아 작업
1. 글자 수(6자 이상 20자 이하)
2. 첫글자는 무조건 영문자
3. 영문과 숫자만으로 입력되어야 함
*/

class StringEx6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.print("아이디 : ");
		String id = sc.nextLine().trim().toLowerCase();
		if (isID(id)) {
			System.out.println("정상적인 아이디 입니다.");
			break;
		} else {
				System.out.println("잘못된 아이디 입니다. \n다시 입력하세요.");				
			}
		}
	}
	public static boolean isID(String id) {
		if (id.length() < 6 || id.length() > 20) return false;
		for (int i = 0; i<id.length() ;i++ ) {
			char c = id.charAt(i);
			if (i == 0 && !(c >='a'&&c <='z'))	
				return false;
			else if (!(c >='a'&&c <='z')&&!(c >= '0' && c <= '9'))
				return false;			
		}
		return true;
	}
}
