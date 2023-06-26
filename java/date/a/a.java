import java.util.*;
import java.time.*;
import java.time.temporal.*;
import java.util.regex.*;
import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;

//	LocalDate 객체를 이용하여 달력을 출력
//	실행시 연도와 월이 없으면 기본으로 현재 연월로 달력 실행
class TimeCalendar {
	public static void main(String[] args) {
		int year, month;						//	보여줄 달력의 연월
		if (args.length == 2) {					//	사용자가 입력한 연월이 있으면
			year = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
		} else {
			LocalDate today = LocalDate.now();
			year = today.getYear();
			month = today.getMonthValue();
		}

		LocalDate sdate = LocalDate.of(year, month, 1);	//	시작일 LocalDate 객체
		int endDay = sdate.with(lastDayOfMonth()).getDayOfMonth();	//	말일
		int weekDay = sdate.getDayOfWeek().getValue();	//	시작일의 요일번호

		System.out.println("      " + year + "년 " + month + "월");
		//	월화수목금토일 순으로 출력
		//	System.out.println("MO TU WE TH FR SA SU");

		//	월화수목금토일 순으로 출력
			weekDay++;
			if (weekDay == 8) weekDay = 1;
			System.out.println("SU MO TU WE TH FR SA");
		for (int i = 1 ; i < weekDay ; i++ ) { System.out.print("   "); }	//	1일의 시작 위치를 정하기 위한 for문

		for (int i = 1 , j = weekDay ; i <= endDay ; i++ , j++ ) {		//	i : 날짜의 일(day)을 표현하기 위한 변수 j : 일주일 지날 때 마다 다른 줄로 내리기 위한 변수
			System.out.print(i < 10 ? "  " + i : " " + i );
			if (j % 7 == 0)	System.out.println();
			}
	}
}
