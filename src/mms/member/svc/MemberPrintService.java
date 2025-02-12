package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberPrintService {
	
	public void printMember() throws Exception {
			
		MemberDAO memberDAO = new MemberDAO();
		
		memberDAO.printMember();
		
	}

}
