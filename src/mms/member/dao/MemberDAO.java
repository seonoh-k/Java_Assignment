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
	
	public void printMember() { // ����Ʈ ���
		
		memberList.forEach(System.out::println);
		
	}
	
	public boolean deleteMember(int memberId) { // ȸ�� ���� ����
		
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
		
}
