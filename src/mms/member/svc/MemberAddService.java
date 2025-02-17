package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberAddService {
	
	MemberDAO memberDAO = new MemberDAO();

	public boolean addMember(Member newMember) throws Exception {
		
		boolean isInsertSuccess = false;
				
		isInsertSuccess = memberDAO.insertNewMember(newMember);
		
		return isInsertSuccess;
	}
	
	
}

//	public void saveLog(String log) {
//		
//		memberDAO.saveLog(log);
//		
//	}