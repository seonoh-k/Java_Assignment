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
	
	public void printMember(int memberId) { // 리스트 출력
		
		if(memberId == 0) { // 0을 입력하면 회원 전체 출력
			memberList.forEach(System.out::println);
		}else {
			boolean found = false;
			for(Member member : memberList) {
				if(member.getId() == memberId) { // 입력한 아이디와 같은 아이디를 가지는 회원 정보 출력
					System.out.println(member);
					found = true; // 입력한 아이디와 일치하는 회원이 존재할 경우 true로 변경하고 반복문 종료.
					break;
				}
			}
			
			if(!found) { // 입력한 아이디와 일치하는 회원 정보가 없으면
				System.out.println("입력하신 아이디와 일치하는 회원 정보가 없습니다");
			}
		}		
	}
	
	public boolean deleteMember(int memberId) { // 회원 정보 삭제
		
		boolean isDeleteSuccess = false;
		
		Member memberToDelete = null; // 삭제할 회원 정보를 담을 빈 객체 생성
		
		for(Member member : memberList) {
			if(member.getId() == memberId) { // 입력한 아이디와 일치하는 회원 정보를 빈 객체에 저장
				memberToDelete = member;
				break;
			}
		}
		
		if(memberToDelete != null) { // 삭제할 회원 정보가 있다면
			memberList.remove(memberToDelete); // 회원 정보 삭제
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
