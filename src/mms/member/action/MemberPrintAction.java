package mms.member.action;

import java.util.Scanner;

import mms.member.svc.MemberPrintService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberPrintAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
			
		MemberPrintService memberService = new MemberPrintService();
		
		memberService.printMember();
		
		
	}

}
