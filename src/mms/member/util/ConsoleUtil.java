package mms.member.util;

import java.util.Scanner;

import mms.member.vo.Member;

public class ConsoleUtil {

	static int id = 1;
	
	public Member getNewMember(Scanner sc) {
		// sc = MemberAddAction���� �޾ƿ� �Է°�
		
		// �Է� ��� �ۼ�
		System.out.println("����� ȸ�� ������ �Է��ϼ���");
		
		System.out.println("�̸� : ");
		String name = sc.next();
		
		System.out.println("�ּ� : ");
		String addr = sc.next();
		
		System.out.println("�̸��� : ");
		String email = sc.next();
		
		System.out.println("���� : ");
		String nation = sc.next();
		
		System.out.println("���� : ");
		int age = sc.nextInt();
		
		return new Member(id++, name, addr, email, nation, age);
	}
	
	public int deleteMember(Scanner sc) {
		
		System.out.println("������ ȸ���� ���̵� �Է��ϼ���");
		int inputId = sc.nextInt();
		
		return inputId;
	}
	
}
