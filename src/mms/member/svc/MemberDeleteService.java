package mms.member.svc;

import mms.member.dao.MemberDAO;

public class MemberDeleteService {
	MemberDAO memberDAO = new MemberDAO();

	public boolean deleteMember(int memberId) throws Exception {
		
		boolean isDeleteSuccess = false;
		
		
		isDeleteSuccess = memberDAO.deleteMember(memberId);
		
		return isDeleteSuccess;
	}
	
	
}

//	public void saveLog(String log) {
//		
//		memberDAO.saveLog(log);
//		
//	}