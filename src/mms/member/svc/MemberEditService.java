package mms.member.svc;

import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberEditService {

    private MemberDAO memberDAO = new MemberDAO();

    public boolean editMember(Member updatedMember) {
        return memberDAO.updateMember(updatedMember); 
    }
    
}

//    public void saveLog(String log) {
//		
//		memberDAO.saveLog(log);
//		
//	}