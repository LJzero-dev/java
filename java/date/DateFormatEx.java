import java.util.*;
import java.text.*;

class DateFormatEx {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();		//	Calendar 객체의 인스턴스를 이용하여 Date 객체 생성		//	Date today = new Date();	//	Calendar 객체 안쓰고 Date만 사용할 수 도 있음

		SimpleDateFormat sdf1, sdf2, sdf3, sdf4, sdf5, sdf6, sdf7, sdf8, sdf9;

		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("''yy년 MMM DD일 E요일");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
		sdf5 = new SimpleDateFormat("오늘은 올 해의 D번째 날입니다.");
		sdf6 = new SimpleDateFormat("오늘은 이 달의 d번째 날입니다.");
		sdf7 = new SimpleDateFormat("오늘은 올 해의 w번째 주입니다.");
		sdf8 = new SimpleDateFormat("오늘은 이 달의 w번째 주입니다.");
		sdf9 = new SimpleDateFormat("오늘은 이 달의 F번째 E요일 입니다.");

		System.out.println(sdf1.format(today));	//	2023-05-09
		System.out.println(sdf2.format(today));	//	'23년 5월 129일 화요일
		System.out.println(sdf3.format(today));	//	2023-05-09 10:59:28.382
		System.out.println(sdf4.format(today));	//	2023-05-09 10:59:28 오전
		System.out.println(sdf5.format(today));	//	오늘은 올 해의 129번째 날입니다.
		System.out.println(sdf6.format(today));	//	오늘은 이 달의 9번째 날입니다.
		System.out.println(sdf7.format(today));	//	오늘은 올 해의 19번째 주입니다.
		System.out.println(sdf8.format(today));	//	오늘은 이 달의 19번째 주입니다.
		System.out.println(sdf9.format(today));	//	오늘은 이 달의 2번째 화요일 입니다.
	}											
}

/*
G : 연대(BC, AD)		/	y : 년도				/	M : 월						/	w : 년의 몇 째 주	/ W : 월의 몇 째 주
D : 년의 몇 째 일	/	d : 월의 몇 째 일	/	F : 월의 몇 째 요일(1~5)		/	E : 요일
a : 오전/오후		/	H : 시(0~23)			/	k : 시간(1~24)				/	h : 시(0~11)			/ m : 분(0~59)
s : 초(0~59)			/	S : 밀리초(0~999)	/	' : 특수문자 표현
*/