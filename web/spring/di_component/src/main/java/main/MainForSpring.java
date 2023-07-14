package main;

import java.util.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import config.*;
import spr.*;

public class MainForSpring {
	private static ApplicationContext ctx = null;
	public static void main(String[] args) {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("명령어 입력 : ");
			String command = sc.nextLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");	return;
			}
			if (command.startsWith("new ")) {
				processNewCommand(command.split(" "));	continue;
			} else if (command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			} else if (command.equals("list")) {
				processListCommand();	continue;
				
			} else if (command.startsWith("info ")) {
				processInfoCommand(command.split(" "));	continue;
			} else if (command.equalsIgnoreCase("version")) {
				processVersionCommand();	continue;
			}
			printHelp();
		}
	}

	private static void processNewCommand(String[] arr) {
		if (arr.length != 6) {
			printHelp();	return;
		}
		MemberRegisterSvc regSvc = ctx.getBean(MemberRegisterSvc.class);	// Component 애노테이션 사용 시 빈 이름을 지정하지 않았으므로 클래스 타입만으로 생성가능
		// 앞이 메소드 이름
		// 설정클래스(AppCtx)를 이용하여 객체를 생성하고 의존 객체를 주입하는 스프링 컨테이너 객체 생성
		// 스프링 컨테이너 : 자바 객체의 생병주기를 관리 보통 new 연산자 등을 통해 생성하고 소별시키는데, 스프링은 컨테이너가 그 역할을 함
		// 스프링 컨테이너로부터 이름이 'memberRegSvc'인 빈 객체를 주입받음
		RegisterRequest req = new RegisterRequest();
		// 사용자가 입력한 회원가입 내용을 저장할 인스턴스 생성
		req.setUid(arr[1]);	req.setPwd(arr[2]);	req.setPwd2(arr[3]);	req.setName(arr[4]);	req.setEmail(arr[5]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.");	return;
		}
		try {
		regSvc.regist(req);
		//	사용자가 입력한 데이터 들을 저장하고 있는 req를 매개변수로 하여 regSvc의 regist() 메소드를 호출	
		System.out.println("등록했습니다.\n");
		} catch (DuplicateMemberException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	private static void processChangeCommand(String[] arr) {
		if (arr.length != 4) {
			printHelp();	return;
		}
		try {
		ChangePasswordSvc pwdSvc = ctx.getBean(ChangePasswordSvc.class);	//	스프링 컨테이너로부터 이름이 'changePwdSvc'인 빈 객체를 주입받음
		pwdSvc.changePassword(arr[1], arr[2], arr[3]);
		System.out.println("암호를 변경했습니다.\n");
		} catch (MemberNotFuondException e) {
			System.out.println("존재하지 않는 아이디입니다.\n");
		} catch (WrongIdPasswordException e) {
			System.out.println("암호가 일치하지 않습니다.\n");
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령어 입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법 : ");
		System.out.println("new 아이디 암호 암호확인 이름 이메일");
		System.out.println("change 아이디 현재비번 변경비번");
		System.out.println("list");
		System.out.println("info 아이디");
		System.out.println("version");
		System.out.println();
	}

	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean(MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void processInfoCommand(String[] arr) {
		if (arr.length != 2) {
			printHelp();	return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean(MemberInfoPrinter.class);		
		infoPrinter.printMemberInfo(arr[1]);
	}

	private static void processVersionCommand() {
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}
}
