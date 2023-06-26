import java.time.*;
import java.time.temporal.*;

class TimeEx1 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();								//	오늘 날짜로 LocalDate 인스턴스 today 생성
		LocalTime now = LocalTime.now();								//	현재 시간으로 LocalTime 인스턴스 now 생성
		LocalDate bDate = LocalDate.of(1999,12,31);						//	1999년 12월 31로 새로운 LocalDate 인스턴스 bDate 생성
		LocalTime bTime = LocalTime.of(23,59,59);						//	23시 59분 59초로 새로운 LocalTime 인스턴스 bTime 생성
		System.out.println("today : " + today);							//	today : 2023-05-09
		System.out.println("now : " + now);								//	now : 11:47:52.205155600
		System.out.println("bDate : " + bDate);							//	bDate : 1999-12-31
		System.out.println("bTime : " + bTime);							//	bTime : 23:59:59
		System.out.println();
		
		System.out.println("withYear(2000) : " + bDate.withYear(2000));	//	bDate의 연도를 2000년으로 변경하여 출력	//	2000-12-31	//	원본 변경되지 않음
		System.out.println("plusDays(1)" + bDate.plusDays(1));			//	bDate에 하루를 더한 후 출력				//	2000-01-01	//	그러므로 1일 더했을 시 위와 같이 출력됨
		System.out.println("plus(1, ChronoUnit.DAYS)" + bDate.plus(1, ChronoUnit.DAYS));	//	위와 동일한 메소드

		//	bTime의 값을 23 : 00 로 출력(With() 없이)
		System.out.println("truncatedTo(ChronoUnit.HOURS)" + bTime.truncatedTo(ChronoUnit.HOURS));	//	truncatedTo(ChronoUnit.HOURS)23:00
																									//	bTime의 시(hour) 보다 작은 유닛들은 모두 0으로 변경


	}										
}
