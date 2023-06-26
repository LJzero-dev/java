/*
1. 생년월일을 yyyy-mm-dd 형식으로 입력받아 Calendar형 인스턴스로 생성한 후 출력 (????년 ??월 ??일)
2. Calendar형 인스턴스의 값들을 이용하여 LocalDate형 인스턴스로 생성한 후 출력 (????년 ??월 ??일)
3. 입력받은 생일을 기준으로 나이를 계산하여 출력
실행결과
생년월일 : 
Calender : ????년 ??월 ??일
LocalDate : ????년 ??월 ??일
나이 : ??살
*/

import java.util.*;
import java.time.*;
import java.time.temporal.*;

class BirthTest {
	public static void main(String[] args) {
		System.out.print("생년월일 : ");
		Scanner sc = new Scanner(System.in);
		String birth = sc.nextLine();

		String[] birthArr = birth.split("-");
		Calendar calBirth = Calendar.getInstance();
		int cYear = calBirth.get(Calendar.YEAR);

		calBirth.set(Integer.parseInt(birthArr[0]),Integer.parseInt(birthArr[1])-1,Integer.parseInt(birthArr[2]));
		System.out.println("Calendar : " + calBirth.get(Calendar.YEAR) + "년 " + (calBirth.get(Calendar.MONTH)+1) + "월 " + calBirth.get(Calendar.DATE) + "일");

		LocalDate ldBirth =  LocalDate.of(calBirth.get(Calendar.YEAR),calBirth.get(Calendar.MONTH),calBirth.get(Calendar.DATE));
		System.out.println("LocalDate : " + ldBirth.getYear() + "년 " + (ldBirth.getMonth().getValue()+1) + "월 " + ldBirth.getDayOfMonth() + "일");

		System.out.println("나이 : " + (cYear-ldBirth.getYear()+1) + " 살 입니다.");

	}
}
