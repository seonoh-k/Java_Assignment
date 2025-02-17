package mms.member.svc;

import java.util.List;

import mms.member.dao.MemberDAO;

public class MemberLogService {

	public List<String> getAllMemberLogs() {
		
        return MemberDAO.getAllMemberLogs();  
    }
	
}
//		MemberDAO memberDAO = new MemberDAO();
//		
//		memberDAO.getLog();
