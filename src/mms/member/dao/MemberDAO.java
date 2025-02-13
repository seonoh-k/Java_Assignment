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
	
	public void printMember(int memberId) { // ����Ʈ ���
		
		if(memberId == 0) { // 0�� �Է��ϸ� ȸ�� ��ü ���
			memberList.forEach(System.out::println);
		}else {
			boolean found = false;
			for(Member member : memberList) {
				if(member.getId() == memberId) { // �Է��� ���̵�� ���� ���̵� ������ ȸ�� ���� ���
					System.out.println(member);
					found = true; // �Է��� ���̵�� ��ġ�ϴ� ȸ���� ������ ��� true�� �����ϰ� �ݺ��� ����.
					break;
				}
			}
			
			if(!found) { // �Է��� ���̵�� ��ġ�ϴ� ȸ�� ������ ������
				System.out.println("�Է��Ͻ� ���̵�� ��ġ�ϴ� ȸ�� ������ �����ϴ�");
			}
		}		
	}
	
	public boolean deleteMember(int memberId) { // ȸ�� ���� ����
		
		boolean isDeleteSuccess = false;
		
		Member memberToDelete = null; // ������ ȸ�� ������ ���� �� ��ü ����
		
		for(Member member : memberList) {
			if(member.getId() == memberId) { // �Է��� ���̵�� ��ġ�ϴ� ȸ�� ������ �� ��ü�� ����
				memberToDelete = member;
				break;
			}
		}
		
		if(memberToDelete != null) { // ������ ȸ�� ������ �ִٸ�
			memberList.remove(memberToDelete); // ȸ�� ���� ����
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
