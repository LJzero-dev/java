package spr;

import java.time.format.*;
import java.util.*;
import org.springframework.beans.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.*;

public class MemberPrinter {
	/*
	 * public void print(MemberInfo mi) {
		 System.out.printf("회원 정보 : 인덱스=%d, 아이디=%s, 이름=%s, 이메일=%s, 등록일=%tF\n", mi.getIdx(), mi.getUid(), mi.getName(), mi.getEmail(), mi.getRegDate());
		
	}
	*/
	private  DateTimeFormatter dateTimeFormatter;
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 mm월 dd일");
	}
	public void print(MemberInfo mi) {
		if (dateTimeFormatter == null) {
			System.out.printf("회원 정보 : 인덱스=%d, 아이디=%s, 이름=%s, 이메일=%s, 등록일=%tF\n", mi.getIdx(), mi.getUid(), mi.getName(), mi.getEmail(), mi.getRegDate());
		} else {
			System.out.printf("회원 정보 : 인덱스=%d, 아이디=%s, 이름=%s, 이메일=%s, 등록일=%tF\n", mi.getIdx(), mi.getUid(), mi.getName(), mi.getEmail(), dateTimeFormatter.format(mi.getRegDate()));
		}
	}	
/*	
 * @Autowired(required = false)	// @Autowired만 지정할 경우 setter가 무조건 실행되어 오류가 발생
									// (required = false)를 지정하면 빈이 없어도 오류가 발생하지 ㅏㅇㄴ혹, setDateFormatter() 메소드를 실행하지 않음
	public void setDateFormatter(DateTimeFormatter dtf) {
		this.dateTimeFormatter = dtf;
	}
	@Autowired
	public void setDateFormatter(Optional<DateTimeFormatter> opt) {	//	자동주입 대상의 타입이 Oprional이면, 일치하는 빈이 없으면다른 값을, 있으면 해당 빈을 값으로 할수 있는 Optional을 인수로 전달할 수 있음
		if (opt.isPresent()) {										//	바등ㄴ 인수에 DateTimeFormatter형 객체가 있으면
			this.dateTimeFormatter = opt.get();
		} else {
			this.dateTimeFormatter = null;
		}
	}
	*/
	@Autowired
	public void setDateFormatter(@Nullable DateTimeFormatter dtf) {
		//	@Nullable : 스프링이 setter를 호출할 때 빈이 없으면 null을 전달하고
		//	차이는 호출 한다는것 null을 넣어준다는것
		this.dateTimeFormatter = dtf;
	}
}
