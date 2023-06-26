import java.time.*;
import java.time.temporal.*;
import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;

class DayAfterTomorrow implements TemporalAdjuster {
	@Override	//	오버라이딩을 한다는 표식으로 생략해도 무방
	public Temporal adjustInto(Temporal temporal) {
		return temporal.plus(2, ChronoUnit.DAYS);
	}
}

class TimeEx2 {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate date = today.with(new DayAfterTomorrow());

		p(today);										//	2023-05-09
		p(date);										//	2023-05-11
		p(today.with(firstDayOfNextMonth()));			//	2023-06-01
		p(today.with(firstDayOfMonth()));				//	2023-05-01
		p(today.with(lastDayOfMonth()));				//	2023-05-31
		p(today.with(firstInMonth(TUESDAY)));			//	2023-05-02
		p(today.with(lastInMonth(TUESDAY)));			//	2023-05-30
		p(today.with(previous(TUESDAY)));				//	2023-05-02
		p(today.with(previousOrSame(TUESDAY)));			//	2023-05-09
		p(today.with(next(TUESDAY)));					//	2023-05-16
		p(today.with(nextOrSame(TUESDAY)));				//	2023-05-09
		p(today.with(dayOfWeekInMonth(4, TUESDAY)));	//	2023-05-23
	}
	public static void p(Object obj) {
		System.out.println(obj);
	}
}
