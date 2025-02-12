package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberAddService {

	public boolean addMember(Member newMember) throws Exception {
		
		boolean isAddSuccess = false;
		
		MemberDAO memberDAO = new MemberDAO();
		
		memberDAO.insertNewMember(newMember);
		
		return isAddSuccess;
	}
	
}
