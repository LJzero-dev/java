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
			System.out.print("��ɾ� �Է� : ");
			String command = sc.nextLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("�����մϴ�.");	return;
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
			System.out.println("��ȣ�� Ȯ���� ��ġ���� �ʽ��ϴ�.");	return;
		}
		try {
		regSvc.regist(req);
		System.out.println("����߽��ϴ�.\n");
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
		System.out.println("��ȣ�� �����߽��ϴ�.\n");
		} catch (MemberNotFuondException e) {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.\n");
		} catch (WrongIdPasswordException e) {
			System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�.\n");
		}
	}

	private static void printHelp() {
		System.out.println();
		System.out.println("�߸��� ��ɾ� �Դϴ�. �Ʒ� ��ɾ� ������ Ȯ���ϼ���.");
		System.out.println("��ɾ� ���� : ");
		System.out.println("new ���̵� ��ȣ ��ȣȮ�� �̸� �̸���");
		System.out.println("change ���̵� ������ ������");
		System.out.println();
	}
}