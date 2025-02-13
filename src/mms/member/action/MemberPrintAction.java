package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberPrintService;
import mms.member.util.ConsoleUtil;

public class MemberPrintAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
			
		ConsoleUtil cu = new ConsoleUtil();
		System.out.println("��ü ��ȸ�� 0�� �Է��ϼ���");
		System.out.print("��ȸ�� ");
		int memberId = cu.inputMemberId(sc);
		
		
		MemberPrintService memberService = new MemberPrintService();
		
		memberService.printMember(memberId);
		
		
	}

}
