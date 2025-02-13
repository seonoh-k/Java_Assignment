package mms.member.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import mms.member.vo.Member;

public class MemberDAO {

	static List<Member> memberList = new CopyOnWriteArrayList<>();
	
	public boolean insertNewMember(Member newMember) {
		
		boolean isInsertSuccess = memberList.add(newMember);
		
		return isInsertSuccess;
	}
	
	public void printMember(int memberId) { 
		
		if(memberId == 0) { 
			memberList.forEach(System.out::println);
		}else {
			boolean found = false;
			for(Member member : memberList) {
				if(member.getId() == memberId) { 
					System.out.println(member);
					found = true; 
					break;
				}
			}
			
			if(!found) { 
				System.out.println("입력하신 아이디와 일치하는 회원 정보가 없습니다");
			}
		}		
	}
	
	public boolean deleteMember(int memberId) { 
		
		boolean isDeleteSuccess = false;
		
		Member memberToDelete = null;
		
		for(Member member : memberList) {
			if(member.getId() == memberId) {
				memberToDelete = member;
				break;
			}
		}
		
		
		if(memberToDelete != null) {
			memberList.remove(memberToDelete);
			isDeleteSuccess = true;
		}else {
			isDeleteSuccess = false;
		}
		
		return isDeleteSuccess;
		
		
	}
	public boolean updateMember(Member updatedMember) { 
	    boolean isUpdateSuccess = false;

	    for (Member member : memberList) {
	        if (member.getId() == updatedMember.getId()) { 
	            memberList.set(memberList.indexOf(member), updatedMember);
	            isUpdateSuccess = true;
	            break;
	        }
	    }

	    return isUpdateSuccess; 
	}
	
	public Member getMemberById(int memberId) {
	    for (Member member : memberList) {
	        if (member.getId() == memberId) {
	            return member; 
	        }
	    }
	    return null; 
	}
	
	
		
}