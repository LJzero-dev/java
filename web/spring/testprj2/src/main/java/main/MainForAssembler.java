package main;

import java.io.*;
import java.util.*;
import assembler.*;
import spr.*;

public class MainForAssembler {
	private static Assembler assembler = new Assembler();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("명령어 입력 : ");
			String command = sc.nextLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다.");	return;
			}
			if (command.startsWith("new ")) {
				processNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("change ")) {
				processChangeCommand(command.split(" "));
				continue;
			}
			printHelp();
		}
	}
	
	private static void processNewCommand(String[] arr) {
		if (arr.length != 6) {
			printHelp();	return;
		}
		MemberRegisterSvc regSvc = assembler.getMemberRegisterSvc();
		RegisterRequest req = new RegisterRequest();
		req.setUid(arr[1]);	req.setPwd(arr[2]);	req.setPwd2(arr[3]);	req.setName(arr[4]);	req.setEmail(arr[5]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.");	return;
		}
		try {
		regSvc.regist(req);
		System.out.println("등록했습니다.\n");
		} catch (DuplicateMemberException e) {
			System.out.println(e.getLocalizedMessage());
		}		
	}
	
	private static void processChangeCommand(String[] arr) {
		if (arr.length != 4) {
			printHelp();	return;
		}
		try {
		ChangePasswordSvc pwdSvc = assembler.getChangePasswordSvc();
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
		System.out.println();
	}
}