package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberDeleteService;
import mms.member.util.ConsoleUtil;

public class MemberDeleteAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		System.out.print("������ ");
		int memberId = cu.inputMemberId(sc);
//		String date = cu.getDate();
		
		MemberDeleteService memberService = new MemberDeleteService();
		
		boolean isDeleteSuccess = memberService.deleteMember(memberId);
		
		if(isDeleteSuccess) {
			System.out.printf("���̵� %d�� ȸ�� ���� ���� ����\n", memberId);
		}else {
			System.out.print("ȸ�� ������ �������� �ʽ��ϴ�");
		}
		
		
	}

}

//		String log = "���̵� " + memberId + "�� ȸ�� ���� ���� ���� - " + date;
//		memberService.saveLog(log);