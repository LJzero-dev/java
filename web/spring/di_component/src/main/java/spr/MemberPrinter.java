package spr;

import java.time.format.*;
import java.util.*;
import org.springframework.beans.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.*;

public class MemberPrinter {
	/*
	 * public void print(MemberInfo mi) {
		 System.out.printf("ȸ�� ���� : �ε���=%d, ���̵�=%s, �̸�=%s, �̸���=%s, �����=%tF\n", mi.getIdx(), mi.getUid(), mi.getName(), mi.getEmail(), mi.getRegDate());
		
	}
	*/
	private  DateTimeFormatter dateTimeFormatter;
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy�� mm�� dd��");
	}
	public void print(MemberInfo mi) {
		if (dateTimeFormatter == null) {
			System.out.printf("ȸ�� ���� : �ε���=%d, ���̵�=%s, �̸�=%s, �̸���=%s, �����=%tF\n", mi.getIdx(), mi.getUid(), mi.getName(), mi.getEmail(), mi.getRegDate());
		} else {
			System.out.printf("ȸ�� ���� : �ε���=%d, ���̵�=%s, �̸�=%s, �̸���=%s, �����=%tF\n", mi.getIdx(), mi.getUid(), mi.getName(), mi.getEmail(), dateTimeFormatter.format(mi.getRegDate()));
		}
	}	
/*	
 * @Autowired(required = false)	// @Autowired�� ������ ��� setter�� ������ ����Ǿ� ������ �߻�
									// (required = false)�� �����ϸ� ���� ��� ������ �߻����� ������Ȥ, setDateFormatter() �޼ҵ带 �������� ����
	public void setDateFormatter(DateTimeFormatter dtf) {
		this.dateTimeFormatter = dtf;
	}
	@Autowired
	public void setDateFormatter(Optional<DateTimeFormatter> opt) {	//	�ڵ����� ����� Ÿ���� Oprional�̸�, ��ġ�ϴ� ���� ������ٸ� ����, ������ �ش� ���� ������ �Ҽ� �ִ� Optional�� �μ��� ������ �� ����
		if (opt.isPresent()) {										//	�ٵ �μ��� DateTimeFormatter�� ��ü�� ������
			this.dateTimeFormatter = opt.get();
		} else {
			this.dateTimeFormatter = null;
		}
	}
	*/
	@Autowired
	public void setDateFormatter(@Nullable DateTimeFormatter dtf) {
		//	@Nullable : �������� setter�� ȣ���� �� ���� ������ null�� �����ϰ�
		//	���̴� ȣ�� �Ѵٴ°� null�� �־��شٴ°�
		this.dateTimeFormatter = dtf;
	}
}
