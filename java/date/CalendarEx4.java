import java.util.*;

class CalendarEx4{
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.set(2020, 7, 30);
		System.out.println(toString(date));						//	2020년 8월 30일
		
		System.out.print("=== 1일 후 ===");
		date.add(Calendar.DATE, 1);
		System.out.println("\n" + toString(date));				//	2020년 8월 31일

		System.out.print("=== 6개월 전 ===");
		date.add(Calendar.MONTH, -6);
		System.out.println("\n" + toString(date));				//	2020년 2월 29일

		System.out.print("=== 31일 후(roll) ===");
		date.roll(Calendar.DATE, 31);							//	지정한 필드의 값만 변함
		System.out.println("\n" + toString(date));				//	2020년 2월 2일

		System.out.print("=== 31일 후(add) ===");
		date.add(Calendar.DATE, 31);
		System.out.println("\n" + toString(date));				//	2020년 3월 4일
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
		}
}
