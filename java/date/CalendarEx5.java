import java.util.*;

class CalendarEx5{
	public static void main(String[] args) {			//	2023 5
		if (args.length != 2) {
			System.out.println("사용법 : java CalenderEx5 2023 5");
			return;
		}
		Calendar sdate = Calendar.getInstance();		//	시작일을 저장할 인스턴스
		Calendar edate = Calendar.getInstance();		//	종료일을 저장할 인스턴스

		int year = Integer.parseInt(args[0]);			//	받아온 달력의 연도및 월을 int형으로 변환
		int month = Integer.parseInt(args[1]);			//	ste() 메소드의 인수로 사용하기 위해 String -> int 변환
		sdate.set(year,month - 1,1);					//	1일의 요일번호(달력의 시작위치)를 구하기 위한 시작일 지정
		edate.set(year, month, 1);
		edate.add(Calendar.DATE, -1);					//	다음달 1일에서 하루를 뺀 날짜로 종료일 지정

		int weekDay = sdate.get(Calendar.DAY_OF_WEEK);	//	1일의 요일 번호로 날짜 출력의 시작점으로 사용됨
		int endDay = edate.get(Calendar.DATE);			//	말일로 달력 출력의 종료점으로 사용됨

		System.out.println("      " + year + "년 " + month + "월");
		System.out.println(" SU MO TU WE TH FR SA");

		for (int i = 1 ; i < weekDay ; i++ ) { System.out.print("   "); }	//	1일의 시작 위치를 정하기 위한 for문

		for (int i = 1 , j = weekDay ; i <= endDay ; i++ , j++ ) {		//	i : 날짜의 일(day)을 표현하기 위한 변수 j : 일주일 지날 때 마다 다른 줄로 내리기 위한 변수
			System.out.print(i < 10 ? "  " + i : " " + i );
			if (j % 7 == 0)	System.out.println();						//	j의 값이 7의 배수일 경우 일주일이 지난걸로 하여 다음 줄로 내림
		}
	}
}
