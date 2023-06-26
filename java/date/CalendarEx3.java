import java.util.*;

class CalendarEx3 {
	public static void main(String[] args) {
		final int[] TIME_UNIT = {3600, 60, 1};
		final String[] TIME_NAME = {"시간 ", "분 ", "초 "};

		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		//	time1은 10시 20분 30초로 지정
		//	time2는 20시 30분 10초로 지정
		
		time2.set(time2.get(Calendar.YEAR),time2.get(Calendar.MONTH),time2.get(Calendar.DATE),20,30,10);

		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);

		System.out.println("time1 의 시간은 : " + time1.get(Calendar.HOUR_OF_DAY) + " 분은 : " + time1.get(Calendar.MINUTE) + " 초는 : " + time1.get(Calendar.SECOND));
		System.out.println("time2 의 시간은 : " + time2.get(Calendar.HOUR_OF_DAY) + " 분은 : " + time2.get(Calendar.MINUTE) + " 초는 : " + time2.get(Calendar.SECOND));

		//	두 시간의 차를 초 단위로 출력(단, 절대값으로)
		System.out.println("두 시간의 차 는 : " + (Math.abs(time1.getTimeInMillis()-time2.getTimeInMillis()))/(1000*60*60) + "시간 입니다.");
		long diff = (Math.abs(time1.getTimeInMillis()-time2.getTimeInMillis()))/1000;
		String tmp = "";
		for (int i = 0; i < TIME_UNIT.length ; i++ ) {
			tmp += diff / TIME_UNIT[i] + TIME_NAME[i];
			diff %= TIME_UNIT[i];
		}
		System.out.println("시간차를 시분초로 변환하면 " + tmp + "입니다.");
	}
}
