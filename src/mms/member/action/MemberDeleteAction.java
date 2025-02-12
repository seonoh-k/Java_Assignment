package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberDeleteService;
import mms.member.util.ConsoleUtil;

public class MemberDeleteAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		int memberId = cu.deleteMember(sc);
		
		MemberDeleteService memberService = new MemberDeleteService();
		
		boolean isDeleteSuccess = memberService.deleteMember(memberId);
		
		if(isDeleteSuccess) {
			System.out.printf("%d�� ȸ�� ���� ���� ����\n", memberId);
		}else {
			System.out.println("ȸ�� ������ �������� �ʽ��ϴ�");
		}
		
		
	}

}
