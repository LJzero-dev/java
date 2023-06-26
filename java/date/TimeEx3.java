import java.time.*;
import java.time.temporal.*;

class TimeEx3 {
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2023, 1, 1);
		LocalDate date2 = LocalDate.of(2024, 12, 31);
		Period pe = Period.between(date1, date2);
		System.out.println("date1 : " + date1);		//	date1 : 2023-01-01
		System.out.println("date2 : " + date2);		//	date2 : 2024-12-31
		System.out.println("pe : " + pe);			//	pe : P1Y11M30D
		System.out.println();

		//	pe를 이용하여 각각 연월일을 출력

		System.out.println("year : " + pe.get(ChronoUnit.YEARS));	//	year : 1
		System.out.println("month : " + pe.getMonths());			//	month : 11
		System.out.println("day : " + pe.getDays());				//	day : 30
		System.out.println();

		LocalDate date3 = LocalDate.of(2023, 12, 31);
		LocalDate date4 = LocalDate.of(2023, 8, 15);
		Period pe2 = Period.between(date3, date4);

		System.out.println("date3 : " + date3);		//	date3 : 2023-12-31
		System.out.println("date4 : " + date4);		//	date4 : 2023-08-31
		System.out.println("pe2 : " + pe2);			//	pe2 : P-4M-16D
		System.out.println();						//	뒤의 날짜가 더 빠를 경우 Periond의 값이 음수로 나옴
		
		if (pe2.isNegative()) pe2 = Period.between(date4, date3);		//	pe2가 음수일 경우 인수의 순서를 배꿔서 재작업
		System.out.println("pe2 : " + pe2);			//	pe2 : P4M16D
	}
}
