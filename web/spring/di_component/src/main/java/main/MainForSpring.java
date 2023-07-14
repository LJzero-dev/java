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
			System.out.print("��ɾ� �Է� : ");
			String command = sc.nextLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("�����մϴ�.");	return;
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
		MemberRegisterSvc regSvc = ctx.getBean(MemberRegisterSvc.class);	// Component �ֳ����̼� ��� �� �� �̸��� �������� �ʾ����Ƿ� Ŭ���� Ÿ�Ը����� ��������
		// ���� �޼ҵ� �̸�
		// ����Ŭ����(AppCtx)�� �̿��Ͽ� ��ü�� �����ϰ� ���� ��ü�� �����ϴ� ������ �����̳� ��ü ����
		// ������ �����̳� : �ڹ� ��ü�� �����ֱ⸦ ���� ���� new ������ ���� ���� �����ϰ� �Һ���Ű�µ�, �������� �����̳ʰ� �� ������ ��
		// ������ �����̳ʷκ��� �̸��� 'memberRegSvc'�� �� ��ü�� ���Թ���
		RegisterRequest req = new RegisterRequest();
		// ����ڰ� �Է��� ȸ������ ������ ������ �ν��Ͻ� ����
		req.setUid(arr[1]);	req.setPwd(arr[2]);	req.setPwd2(arr[3]);	req.setName(arr[4]);	req.setEmail(arr[5]);
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("��ȣ�� Ȯ���� ��ġ���� �ʽ��ϴ�.");	return;
		}
		try {
		regSvc.regist(req);
		//	����ڰ� �Է��� ������ ���� �����ϰ� �ִ� req�� �Ű������� �Ͽ� regSvc�� regist() �޼ҵ带 ȣ��	
		System.out.println("����߽��ϴ�.\n");
		} catch (DuplicateMemberException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	private static void processChangeCommand(String[] arr) {
		if (arr.length != 4) {
			printHelp();	return;
		}
		try {
		ChangePasswordSvc pwdSvc = ctx.getBean(ChangePasswordSvc.class);	//	������ �����̳ʷκ��� �̸��� 'changePwdSvc'�� �� ��ü�� ���Թ���
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
		System.out.println("list");
		System.out.println("info ���̵�");
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
