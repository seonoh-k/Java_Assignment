package mms.member.util;

import java.util.Scanner;

import mms.member.dao.MemberDAO;
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
		
		return new Member(id++, name, addr, nation, email, age);
	}
	
	public int inputMemberId(Scanner sc) {
		// ��ȸ, ����, ���� ��ɿ��� �ʿ��� ID ���� �Է�
		
		System.out.println("ȸ���� ���̵� �Է��ϼ���");
		int inputId = sc.nextInt();
		return inputId;
	}
	
	public Member EditMember(Scanner sc, int memberId) {
        
        Member currentMember = new MemberDAO().getMemberById(memberId); // �ش� ȸ�� ������ ������
        
        if (currentMember == null) {
            System.out.println("�ش� ȸ���� �������� �ʽ��ϴ�.");
            return null; 
        }
        
        System.out.println("������ ȸ�� ������ �Է��ϼ���");
        
        String name = currentMember.getName();

        System.out.println("���� �ּ�: " + currentMember.getAddr() + " ������ �ּ�: ");
        String addr = sc.next();

        System.out.println("���� �̸���: " + currentMember.getEmail() + " ������ �̸���: ");
        String email = sc.next();

        System.out.println("���� ����: " + currentMember.getNation() + " ������ ����: ");
        String nation = sc.next();

        System.out.println("���� ����: " + currentMember.getAge() + " ������ ����: ");
        int age = sc.nextInt();

        return new Member(memberId, name, addr, nation, email, age);
    }
	
}
