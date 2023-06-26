import java.util.*;

class CalenderEx2 {
	public static void main(String[] args) {
		final String[] WEEK_DAY = {"", "일", "월", "화", "수", "목", "금", "토"};		//	요일 이름을 출력하기 위한 문자열 상수 배열
		Calendar date1 = Calendar.getInstance();									//	요일 번호는 1부터 시작하므로 첫번째 요소를 비워둠
		Calendar date2 = Calendar.getInstance();									//	오늘 날짜(date1)와 2022년 1월 15일로 지정한 날짜(date1) 객체를 생성		
		date2.set(2022, 0, 15);
		
		System.out.println("date1은 : " + toString(date1) + " " + WEEK_DAY[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고, ");		//	date1은 : 2023년 5월 8일  월요일이고,
		System.out.println("date2은 : " + toString(date2) + " " + WEEK_DAY[date2.get(Calendar.DAY_OF_WEEK)] + "요일이다. ");		//	date2은 : 2022년 1월 15일  토요일이다.

		System.out.println("date1과 date2 사이의 기간은(초) : " + (date1.getTimeInMillis() - date2.getTimeInMillis())/1000);			//	date1과 date2 사이의 기간을 초 단위로 출력
		System.out.println("date1과 date2 사이의 기간은(일) : " + (date1.getTimeInMillis() - date2.getTimeInMillis())/86400000);
	}
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
		

	}
}
