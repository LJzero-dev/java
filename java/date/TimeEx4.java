import java.time.*;
import java.time.temporal.*;

class TimeEx4 {
	public static void main(String[] args) {
		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(12, 34, 56);
		Duration du = Duration.between(time1, time2);

		System.out.println("Time1 : " + time1);	//	Time1 : 00:00
		System.out.println("Time2 : " + time2);	//	Time2 : 12:34:56
		System.out.println("du : " + du);		//	du : PT12H34M56S
		System.out.println();

		System.out.println("du-secibd : " + du.getSeconds());	//	du-secibd : 45296	//	Duration에서는 시분초를 따로 추출할 수 없고, 초나 나노초 단위로 추출해야 함
		LocalTime tmp = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		System.out.println("hour : " + tmp.getHour());		//	hour : 12
		System.out.println("minute : " + tmp.getMinute());	//	minute : 34
		System.out.println("second : " + tmp.getSecond());	//	second : 56

	}
}
