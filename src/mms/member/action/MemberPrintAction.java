package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberPrintService;
import mms.member.util.ConsoleUtil;

public class MemberPrintAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		
		ConsoleUtil cu = new ConsoleUtil();
		
		int id = cu.id;
		
		MemberPrintService memberService = new MemberPrintService();
		
		boolean isPrintSuccess = memberService.printMember();
		
		if(isPrintSuccess) {
			System.out.println();
		}else {
			System.out.println("데이터 출력 실패");
		}
		
	}

}
