package mms.member.action;

import java.util.Scanner;

import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		// sc = MemberUI에서 받아온 입력값
		
		ConsoleUtil cu = new ConsoleUtil();
		Member newMemeber = cu.getNewMember(sc);
		
	}

}
