package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberPrintService;
import mms.member.util.ConsoleUtil;

public class MemberPrintAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
			
		ConsoleUtil cu = new ConsoleUtil();
		System.out.println("전체 조회는 0을 입력하세요");
		System.out.print("조회할 ");
		int memberId = cu.inputMemberId(sc);
//		String date = cu.getDate();		
		
		MemberPrintService memberService = new MemberPrintService();
		
//		System.out.println(date);
		memberService.printMember(memberId);
		
		
	}

}
